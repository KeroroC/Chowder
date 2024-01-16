package com.keroro;

import com.keroro.designPattern.factory.simpleFactory.Shape;

public class Main {
    public static void main(String[] args) {

        Shape shape = Shape.createShape("triangle");
        shape.draw();
        shape.erase();
    }
}