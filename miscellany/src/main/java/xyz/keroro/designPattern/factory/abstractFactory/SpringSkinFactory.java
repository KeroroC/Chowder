package xyz.keroro.designPattern.factory.abstractFactory;

/**
 * @author wangpeng
 * @since 2024年02月04日 17:58
 */
public class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }
}
