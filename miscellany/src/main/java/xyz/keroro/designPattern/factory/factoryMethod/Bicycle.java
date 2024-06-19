package xyz.keroro.designPattern.factory.factoryMethod;

/**
 * @author wangpeng
 * @since 2024年01月17日 19:51
 */
public class Bicycle implements Vehicle {

    public Bicycle() {
        System.out.println("创建了Bicycle");
    }

    @Override
    public void printName() {
        System.out.println("Bicycle");
    }
}
