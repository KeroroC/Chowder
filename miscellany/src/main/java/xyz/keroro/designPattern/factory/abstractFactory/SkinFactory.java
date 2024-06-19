package xyz.keroro.designPattern.factory.abstractFactory;

/**
 * @author wangpeng
 * @since 2024年02月04日 17:58
 */
public interface SkinFactory {

    Button createButton();

    TextField createTextField();
}
