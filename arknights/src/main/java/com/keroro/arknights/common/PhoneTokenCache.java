package com.keroro.arknights.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 手机号和对应token的缓存
 * @author wangpeng
 * @since 2023年12月27日 20:20
 */
@Component
public class PhoneTokenCache {

    /**
     * 存储手机号和对应token的缓存
     */
    private final Map<String, String> phoneTokenCache = new HashMap<>(2);

    public void add(String phone, String token) {
        phoneTokenCache.put(phone, token);
    }

    public String getToken(String phone) {
        return phoneTokenCache.get(phone);
    }
}
