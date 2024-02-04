package com.keroro.designPattern.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * Initialization on Demand Holder
 * @author wangpeng
 * @since 2024年01月15日 19:25
 */
public class IoDHSingleton implements Serializable {

    private static volatile boolean flag = false;

    private IoDHSingleton() {
        // 通过flag强化Singleton属性，防止通过反射创建对象，此时直接抛异常
        synchronized (IoDHSingleton.class) {
            if (!flag) {
                flag = !flag;
            } else {
                throw new RuntimeException("打咩，不能再建了");
            }
        }
    }

    private static class HolderClass {
        private static final IoDHSingleton instance = new IoDHSingleton();
    }

    public IoDHSingleton getInstance() {
        return HolderClass.instance;
    }

    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}
