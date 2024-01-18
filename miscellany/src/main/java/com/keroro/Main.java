package com.keroro;

import com.keroro.designPattern.factory.factoryMethod.BicycleFactory;
import com.keroro.designPattern.factory.factoryMethod.CarFactory;
import com.keroro.designPattern.factory.factoryMethod.Vehicle;
import com.keroro.designPattern.factory.factoryMethod.VehicleFactory;
import com.keroro.java.abstractClass.Zelda;
import com.keroro.java.interfaceTest.InterfaceA;
import com.keroro.java.interfaceTest.TestClass;

public class Main {
    public static void main(String[] args) {

        Zelda zelda = new Zelda();
        System.out.println(zelda);
        zelda.printSomething();
        zelda.companyName();
    }
}