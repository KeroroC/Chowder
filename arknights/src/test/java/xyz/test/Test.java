package xyz.test;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.thread.ThreadUtil;

/**
 * @author wangpeng
 * @since 2023年12月27日 19:43
 */
public class Test {

    public static void main(String[] args) {
        TimedCache<String, String> phoneTokenCache = CacheUtil.newTimedCache(5000);
        phoneTokenCache.put("key", "123");
        System.out.println(phoneTokenCache.get("key"));
        ThreadUtil.sleep(5001);
        System.out.println(phoneTokenCache.get("key"));
    }
}
