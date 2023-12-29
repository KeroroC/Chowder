package com.keroro.arknights.common;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUnit;
import org.springframework.stereotype.Component;

/**
 * 手机号和对应token的缓存
 * @author wangpeng
 * @since 2023年12月27日 20:20
 */
@Component
public class PhoneTokenCache {

    /**
     * 存储手机号和对应token的缓存，20min过期
     */
    private final TimedCache<String, String> phoneTokenCache = CacheUtil.newTimedCache(DateUnit.MINUTE.getMillis() * 20);

    public PhoneTokenCache() {
        phoneTokenCache.schedulePrune(DateUnit.MINUTE.getMillis() * 20);
    }

    public void add(String phone, String token) {
        phoneTokenCache.put(phone, token);
    }

    public String getToken(String phone) {
        return phoneTokenCache.get(phone);
    }
}
