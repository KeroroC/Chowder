package com.keroro.designPattern.factory.factoryMethod;

/**
 * @author wangpeng
 * @since 2024年01月17日 19:49
 */
public class Car implements Vehicle {

    public Car() {
        System.out.println("创建了car");
    }

    @Override
    public void printName() {
        System.out.println("car");
    }
}
