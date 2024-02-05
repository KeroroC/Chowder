package com.keroro.designPattern.factory.abstractFactory;

/**
 * @author wangpeng
 * @since 2024年02月04日 17:58
 */
public class WinterSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new WinterButton();
    }

    @Override
    public TextField createTextField() {
        return new WinterTextField();
    }
}
