package com.keroro.arknights.service;

import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keroro.arknights.common.PhoneTokenCache;
import com.keroro.arknights.common.constant.UrlConstant;
import com.keroro.arknights.common.exception.InterfaceDataException;
import com.keroro.arknights.config.ArknightsProperties;
import com.keroro.arknights.dao.GachaRecordComponent;
import com.keroro.arknights.dao.po.GachaRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 抽卡记录服务
 * @author wangpeng
 * @since 2023年12月29日 23:09
 */
@Service
public class ArkGachaService {

    private final PhoneTokenCache phoneTokenCache;

    private final GachaRecordComponent gachaRecordComponent;

    private final ArknightsProperties arknightsProperties;

    public ArkGachaService(PhoneTokenCache phoneTokenCache, GachaRecordComponent gachaRecordComponent, ArknightsProperties arknightsProperties) {
        this.phoneTokenCache = phoneTokenCache;
        this.gachaRecordComponent = gachaRecordComponent;
        this.arknightsProperties = arknightsProperties;
    }

    /**
     * 更新抽卡记录
     * @param arkAccount ark账号
     * @param channelId 渠道ID
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateGacha(String arkAccount, Integer channelId) {
        // 校验
        Optional<String> token = Optional.ofNullable(phoneTokenCache.getToken(arkAccount));
        token.orElseThrow(() -> new RuntimeException("没有此账号的token"));

        // 查询库里此账号最新的记录的抽卡时间，没有则为nul
        Optional<GachaRecord> latestRecord = Optional.ofNullable(gachaRecordComponent.lambdaQuery()
                .eq(GachaRecord::getArkAccount, arkAccount)
                .orderByDesc(GachaRecord::getTime)
                .list().get(0));
        // 出现null值时这里是否会报错？
        Integer latestTimestamp = latestRecord.map(gachaRecord -> Integer.valueOf(gachaRecord.getTimestamp())).orElse(0);

        int page = 1;
        JsonNode node = getGachaRecord(token.get(), page, channelId);
        if (node.get("code").asInt() == 0) {
            // 保存
            saveGachaRecord(arkAccount, latestTimestamp, node.get("data").get("list"));

            // 还需要请求次数
            int requestTimes = 0;
            // 记录总数，十连为十次
            int total = node.get("data").get("pagination").get("total").asInt();
            if (total > 10) {
                requestTimes = ((int) Math.ceil((double) total / 10)) - 1;
            }

            while (requestTimes > 0) {
                JsonNode nextNode = getGachaRecord(token.get(), ++page, channelId);
                saveGachaRecord(arkAccount, latestTimestamp, nextNode.get("data").get("list"));
                requestTimes--;
            }

        } else {
            throw new RuntimeException(node.get("msg").asText());
        }
    }

    /**
     * 存入新的抽卡记录
     * @param arkAccount 账号
     * @param latestTimeStamp 最新的一条记录的时间戳
     * @param node 抽卡记录Node
     */
    private void saveGachaRecord(String arkAccount, Integer latestTimeStamp, JsonNode node) {
        if (node.isArray()) {
            List<GachaRecord> recordList = new ArrayList<>();
            // 遍历每一次抽卡
            for (JsonNode recordNode: node) {
                // 大于数据库中已有记录的才需要保存
                if (recordNode.get("ts").asInt() > latestTimeStamp) {
                    // 遍历每个干员
                    for (JsonNode operatorNode: recordNode.get("chars")) {
                        GachaRecord record = new GachaRecord();
                        record.setTimestamp(recordNode.get("ts").asText());
                        record.setTime(new Date(recordNode.get("ts").asLong() * 1000L));
                        record.setPool(recordNode.get("pool").asText());
                        record.setName(operatorNode.get("name").asText());
                        record.setRarity(operatorNode.get("rarity").asText());
                        record.setNew(operatorNode.get("isNew").asBoolean());
                        record.setCreateTime(new Date());
                        // uid先不存了
                        // record.setPlayerUID();
                        record.setArkAccount(arkAccount);

                        recordList.add(record);
                    }
                }
            }
            gachaRecordComponent.saveBatch(recordList);
        }
    }

    /**
     * 获取抽卡记录
     * @param token token
     * @param page 页码
     * @return 抽卡记录：JsonNode
     */
    private JsonNode getGachaRecord(String token, Integer page, Integer channelId) {
        // 获取抽卡记录
        String gachaUrl = arknightsProperties.getDomainAk() + UrlConstant.USER_API_URL_PREFIX + "/inquiry/gacha";
        Map<String, Object> params = new HashMap<>(3);
        params.put("page", page);
        params.put("token", URLUtil.encodeAll(token));
        params.put("channelId", channelId);
        String content = HttpUtil.get(gachaUrl, params);

        try {
            return new ObjectMapper().readTree(content);
        } catch (JsonProcessingException e) {
            throw new InterfaceDataException("接口数据异常，json无法解析");
        }
    }
}
