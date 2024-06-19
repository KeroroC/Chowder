package xyz.keroro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        // 具体工厂类可以优化到配置文件里去，就不需要改代码了
//        SkinFactory factory = new WinterSkinFactory();
//        Button button = factory.createButton();
//        TextField textField = factory.createTextField();
//        button.display();
//        textField.display();

        List<String> list = new ArrayList<>();
        list.add("11");

        System.out.println(list.subList(0, 5));
    }
}