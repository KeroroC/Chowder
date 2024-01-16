package com.keroro.designPattern.factory.simpleFactory;

/**
 * @author wangpeng
 * @since 2024年01月16日 19:59
 */
public class Square extends Shape {

    private String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
