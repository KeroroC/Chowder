package com.keroro.designPattern.factory.abstractFactory;

/**
 * @author wangpeng
 * @since 2024年02月04日 17:55
 */
public class WinterTextField implements TextField {
    @Override
    public void display() {
        System.out.println("display Winter TextField");
    }
}
