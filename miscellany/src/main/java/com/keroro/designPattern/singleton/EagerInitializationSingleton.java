package com.keroro.designPattern.singleton;

/**
 * 饿汉式单例
 * @author wangpeng
 * @since 2024年01月15日 19:01
 */
public class EagerInitializationSingleton {

    private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();

    private String name;

    private EagerInitializationSingleton() {}

    public static EagerInitializationSingleton getInstance() {
        return instance;
    }
}
