package com.keroro;

import com.keroro.designPattern.factory.factoryMethod.BicycleFactory;
import com.keroro.designPattern.factory.factoryMethod.CarFactory;
import com.keroro.designPattern.factory.factoryMethod.Vehicle;
import com.keroro.designPattern.factory.factoryMethod.VehicleFactory;

public class Main {
    public static void main(String[] args) {

        VehicleFactory factory = new CarFactory();
        Vehicle car = factory.create();
        car.printName();
        factory = new BicycleFactory();
        Vehicle bicycle = factory.create();
        bicycle.printName();
    }
}