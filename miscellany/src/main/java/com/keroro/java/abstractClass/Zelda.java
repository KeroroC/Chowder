package com.keroro.java.abstractClass;

/**
 * @author wangpeng
 * @since 2024年01月18日 16:16
 */
public class Zelda extends AbstractGame {

    public String publicVariable = "hhh";

    public void printSomething() {
        System.out.println("444");
    }
    @Override
    public void companyName() {
        System.out.println("Nintendo");
    }
}
