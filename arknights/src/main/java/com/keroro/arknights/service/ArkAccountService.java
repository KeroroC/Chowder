package com.keroro.arknights.service;

import cn.hutool.http.HttpUtil;
import com.keroro.arknights.common.PhoneTokenCache;
import com.keroro.arknights.common.constant.UrlConstant;
import com.keroro.arknights.common.exception.AccountNotFoundException;
import com.keroro.arknights.config.ArknightsProperties;
import com.keroro.arknights.dao.ArkAccountComponent;
import com.keroro.arknights.dao.po.ArkAccount;
import org.springframework.stereotype.Service;

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
    public boolean addAccount(String arkAccount, String arkPassword) {
        return arkAccountComponent.save(new ArkAccount(arkAccount, arkPassword));
    }

    /**
     * 登录ark账号，并将token缓存下来
     * @param arkAccount 账号
     * @return 是否成功: boolean
     */
    public boolean arkLogin(String arkAccount) {
        String loginUrl = arknightsProperties.getDomainName() + UrlConstant.USER_AUTH_URL_PREFIX + "/token_by_phone_password";

        Optional<ArkAccount> account = Optional.ofNullable(arkAccountComponent.lambdaQuery()
                .eq(ArkAccount::getArkAccount, arkAccount)
                .one());
        account.orElseThrow(() -> new AccountNotFoundException("账号不存在"));

        Map<String, Object> params = new HashMap<>(2);
        params.put("phone", arkAccount);
        params.put("password", account.get().getArkPwd());
        String content = HttpUtil.post(loginUrl, params);

        phoneTokenCache.add(arkAccount, content);

        return true;
    }
}
