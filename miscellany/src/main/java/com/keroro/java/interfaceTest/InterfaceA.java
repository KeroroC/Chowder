package com.keroro.java.interfaceTest;

/**
 * 接口
 */
public interface InterfaceA {

    /**
     * 静态变量
     * 编译后等同于public static final NAME = "name";
     */
    String NAME = "name";

    /**
     * 抽象方法
     */
    void run();

    /**
     * 静态方法
     */
    static void staticMethod() {
        System.out.println("静态方法");
    }

    /**
     * 默认方法
     */
    default void doSomething() {
        System.out.println("默认方法");
    }
}
