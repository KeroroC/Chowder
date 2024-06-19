package xyz.keroro.arknights.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 手机号和对应token的缓存
 * @author wangpeng
 * @since 2023年12月27日 20:20
 */
public enum PhoneTokenCache {
    INSTANCE;

    /**
     * 存储手机号和对应token的缓存
     */
    private final Map<String, String> phoneTokenCache = new HashMap<>(2);

    public void add(String phone, String token) {
        phoneTokenCache.put(phone, token);
    }

    public void remove(String phone) {
        phoneTokenCache.remove(phone);
    }

    public String getToken(String phone) {
        return phoneTokenCache.get(phone);
    }
}
