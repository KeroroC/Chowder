package com.keroro.designPattern.factory.factoryMethod;

/**
 * @author wangpeng
 * @since 2024年01月17日 19:44
 */
public class BicycleFactory implements VehicleFactory {

    public BicycleFactory() {
        System.out.println("生成Bicycle");
    }

    @Override
    public Vehicle create() {
        return new Bicycle();
    }
}
