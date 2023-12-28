package com.keroro.arknights.service;

import com.keroro.arknights.dao.ArkAccountComponent;
import com.keroro.arknights.dao.po.ArkAccount;
import org.springframework.stereotype.Service;

/**
 * @author wangpeng
 * @since 2023年12月28日 15:54
 */
@Service
public class ArkAccountService {

    private final ArkAccountComponent arkAccountComponent;

    public ArkAccountService(ArkAccountComponent arkAccountComponent) {
        this.arkAccountComponent = arkAccountComponent;
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
}
