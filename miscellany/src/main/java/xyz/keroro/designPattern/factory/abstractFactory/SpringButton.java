package xyz.keroro.designPattern.factory.abstractFactory;

/**
 * @author wangpeng
 * @since 2024年02月04日 17:51
 */
public class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("display Spring Button");
    }
}
