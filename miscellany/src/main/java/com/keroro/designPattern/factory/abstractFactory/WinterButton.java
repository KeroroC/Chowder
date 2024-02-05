package com.keroro.designPattern.factory.abstractFactory;

/**
 * @author wangpeng
 * @since 2024年02月04日 17:52
 */
public class WinterButton implements Button {
    @Override
    public void display() {
        System.out.println("display Winter Button");
    }
}
