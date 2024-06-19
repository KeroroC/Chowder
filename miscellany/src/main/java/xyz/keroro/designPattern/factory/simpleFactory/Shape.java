package xyz.keroro.designPattern.factory.simpleFactory;

import xyz.keroro.exception.UnSupportedShapeException;

/**
 * @author wangpeng
 * @since 2024年01月16日 19:52
 */
public abstract class Shape {

    private String name;

    public void draw() {
        System.out.println("draw：" + this.name);
    }

    public void erase() {
        System.out.println("erase: " + this.name);
    }

    public static Shape createShape(String type) {
        switch (type) {
            case "circle":
                Circle circle = new Circle();
                circle.setName(type);
                return circle;
            case "square":
                Square square = new Square();
                square.setName(type);
                return square;
            case "triangle":
                Triangle triangle = new Triangle();
                triangle.setName(type);
                return triangle;
            default:
                throw new UnSupportedShapeException("不支持的形状");
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
