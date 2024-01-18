package com.keroro.java.interfaceTest;

/**
 * @author wangpeng
 * @since 2024年01月18日 11:13
 */
public class TestClass implements InterfaceA, InterfaceB {
    @Override
    public void run() {
        System.out.println("重写的方法");
    }

    public void selfMethod() {
        System.out.println("自己的方法");
    }
}
