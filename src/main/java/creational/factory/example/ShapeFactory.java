package creational.factory.example;

public class ShapeFactory {

    public static Shape produceShape(ShapeType shapeType) {
        switch (shapeType) {
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
            case CIRCLE:
                return new Circle();
            default:
                return null;
        }
    }
}
