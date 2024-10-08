package xyz.keroro.arknights.service;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.keroro.arknights.common.PhoneTokenCache;
import xyz.keroro.arknights.common.constant.CryptConstant;
import xyz.keroro.arknights.common.constant.UrlConstant;
import xyz.keroro.arknights.common.exception.AccountNotFoundException;
import xyz.keroro.arknights.common.exception.InterfaceDataException;
import xyz.keroro.arknights.config.ArknightsProperties;
import xyz.keroro.arknights.dao.ArkAccountComponent;
import xyz.keroro.arknights.dao.po.ArkAccount;

import java.util.HashMap;
import java.util.List;
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

    public ArkAccountService(ArkAccountComponent arkAccountComponent, ArknightsProperties arknightsProperties) {
        this.arkAccountComponent = arkAccountComponent;
        this.arknightsProperties = arknightsProperties;
    }

    /**
     * 查询所有ark账号
     * @return List<ArkAccount>: 账号列表
     */
    public List<ArkAccount> arkAccountList() {
        return arkAccountComponent.list();
    }

    /**
     * 添加一个账号
     * @param arkAccount 账号（手机号）
     * @param arkPassword 密码
     * @return boolean: 是否成功
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean addAccount(String arkAccount, String arkPassword) {
        Optional.ofNullable(arkAccountComponent.lambdaQuery().eq(ArkAccount::getArkAccount, arkAccount).one())
                .ifPresent(item -> {throw new RuntimeException("账号已存在");});

        arkPassword = SecureUtil.aes(CryptConstant.AES_KEY.getBytes()).encryptBase64(arkPassword);
        return arkAccountComponent.save(new ArkAccount(arkAccount, arkPassword));
    }

    /**
     * 获取账号列表
     * @return 账号list
     */
    public List<ArkAccount> list() {
        return arkAccountComponent.list();
    }

    /**
     * 添加账号token缓存
     * @param arkAccount ark账号
     * @param token token
     */
    public void addToken(String arkAccount, String token) {
        PhoneTokenCache.INSTANCE.add(arkAccount, token);
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

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> params = new HashMap<>(2);
        params.put("phone", arkAccount);
        params.put("password", SecureUtil.aes(CryptConstant.AES_KEY.getBytes()).decryptStr(account.get().getArkPwd()));
        String content;
        try {
            content = HttpUtil.post(loginUrl, objectMapper.writeValueAsString(params));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("登录方法参数构造异常：" + e.getMessage());
        }

        JsonNode node;
        try {
            node = new ObjectMapper().readTree(content);
        } catch (JsonProcessingException e) {
            throw new InterfaceDataException("ark登录接口数据异常，json无法解析");
        }

        if (node.get("status").asInt() != 0) {
            throw new RuntimeException(node.get("msg").asText());
        } else {
            addToken(arkAccount, node.get("data").get("token").asText());
        }

        return true;
    }

    /**
     * 登出ark账号
     * @param arkAccount 账号
     */
    public String arkLogout(String arkAccount) {
        Optional<String> token = Optional.ofNullable(PhoneTokenCache.INSTANCE.getToken(arkAccount));
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

        PhoneTokenCache.INSTANCE.remove(arkAccount);

        // 3-登录已过期，0-OK
        if (node.get("status").asInt() == 3) {
            return "登录已过期，无需登出";
        }
        return "登出成功";
    }
}
