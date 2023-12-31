package com.keroro.arknights.service;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keroro.arknights.common.PhoneTokenCache;
import com.keroro.arknights.common.constant.CryptConstant;
import com.keroro.arknights.common.constant.UrlConstant;
import com.keroro.arknights.common.exception.AccountNotFoundException;
import com.keroro.arknights.common.exception.InterfaceDataException;
import com.keroro.arknights.config.ArknightsProperties;
import com.keroro.arknights.dao.ArkAccountComponent;
import com.keroro.arknights.dao.po.ArkAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author wangpeng
 * @since 2023年12月28日 15:54
 */
@Service
public class ArkAccountService {

    private final ArkAccountComponent arkAccountComponent;

    private final ArknightsProperties arknightsProperties;

    private final PhoneTokenCache phoneTokenCache;

    public ArkAccountService(ArkAccountComponent arkAccountComponent, ArknightsProperties arknightsProperties, PhoneTokenCache phoneTokenCache) {
        this.arkAccountComponent = arkAccountComponent;
        this.arknightsProperties = arknightsProperties;
        this.phoneTokenCache = phoneTokenCache;
    }

    /**
     * 添加一个账号
     * @param arkAccount 账号（手机号）
     * @param arkPassword 密码
     * @return boolean: 是否成功
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean addAccount(String arkAccount, String arkPassword) {
        arkPassword = SecureUtil.aes(CryptConstant.AES_KEY.getBytes()).encryptBase64(arkPassword);
        return arkAccountComponent.save(new ArkAccount(arkAccount, arkPassword));
    }

    /**
     * 登录ark账号，并将token缓存下来
     * @param arkAccount 账号
     * @return 是否成功: boolean
     */
    public boolean arkLogin(String arkAccount) {
        String loginUrl = arknightsProperties.getDomainAs() + UrlConstant.USER_AUTH_URL_PREFIX + "/token_by_phone_password";

        Optional<ArkAccount> account = Optional.ofNullable(arkAccountComponent.lambdaQuery()
                .eq(ArkAccount::getArkAccount, arkAccount)
                .one());
        account.orElseThrow(() -> new AccountNotFoundException("账号不存在"));

        Map<String, Object> params = new HashMap<>(2);
        params.put("phone", arkAccount);
        params.put("password", SecureUtil.aes(CryptConstant.AES_KEY.getBytes()).decryptStr(account.get().getArkPwd()));
        String content = HttpUtil.post(loginUrl, params);

        JsonNode node;
        try {
            node = new ObjectMapper().readTree(content);
        } catch (JsonProcessingException e) {
            throw new InterfaceDataException("ark登录接口数据异常，json无法解析");
        }

        if (node.get("status").asInt() != 0) {
            throw new RuntimeException(node.get("msg").asText());
        } else {
            phoneTokenCache.add(arkAccount, node.get("data").get("token").asText());
        }

        return true;
    }

    /**
     * 登出ark账号
     * @param arkAccount 账号
     */
    public String arkLogout(String arkAccount) {
        Optional<String> token = Optional.ofNullable(phoneTokenCache.getToken(arkAccount));
        token.orElseThrow(() -> new RuntimeException("没有此账号的token，不需要登出"));

        String logoutUrl = arknightsProperties.getDomainAs() + UrlConstant.USER_INFO_URL_PREFIX + "/logout";
        Map<String, Object> params = new HashMap<>();
        params.put("token", token.get());
        String content = HttpUtil.post(logoutUrl, params);

        JsonNode node;
        try {
            node = new ObjectMapper().readTree(content);
        } catch (JsonProcessingException e) {
            throw new InterfaceDataException("ark登出接口数据异常，json无法解析");
        }

        phoneTokenCache.remove(arkAccount);

        // 3-登录已过期，0-OK
        if (node.get("status").asInt() == 3) {
            return "登录已过期，无需登出";
        }
        return "登出成功";
    }
}
