package com.keroro.designPattern.factory.factoryMethod;

/**
 * @author wangpeng
 * @since 2024年01月17日 19:45
 */
public class CarFactory implements VehicleFactory {

    public CarFactory() {
        System.out.println("生成Car");
    }

    @Override
    public Vehicle create() {
        return new Car();
    }
}
