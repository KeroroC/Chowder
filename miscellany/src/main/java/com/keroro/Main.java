package com.keroro;

import com.keroro.designPattern.factory.abstractFactory.Button;
import com.keroro.designPattern.factory.abstractFactory.SkinFactory;
import com.keroro.designPattern.factory.abstractFactory.TextField;
import com.keroro.designPattern.factory.abstractFactory.WinterSkinFactory;

public class Main {
    public static void main(String[] args) {
        // 具体工厂类可以优化到配置文件里去，就不需要改代码了
        SkinFactory factory = new WinterSkinFactory();
        Button button = factory.createButton();
        TextField textField = factory.createTextField();
        button.display();
        textField.display();
    }
}