package creational.factory.example;

import static creational.factory.example.ShapeType.*;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class ClientApp {

    public static void main(String[] args) {
        System.out.println("Starting to production of shapes objects!!\n");

        System.out.println("Creating an object via ClientApp responsibility...");
        Shape concreteShape =  new Rectangle();
        concreteShape.draw();

        Shape shape1 = produceShape(CIRCLE);
        shape1.draw();
        Shape shape2 = produceShape(RECTANGLE);
        shape2.draw();
        Shape shape3 = produceShape(SQUARE);
        shape3.draw();

        ShapeType[] shapes = {CIRCLE, RECTANGLE, SQUARE};
        for(ShapeType shape : shapes) {
            System.out.println(format("\nLooping object creation for %s from the group of shapes", shape));
            Shape shapeObject = produceShape(shape);
            shapeObject.draw();
        }
    }

    private static Shape produceShape(ShapeType shapeType) {
        System.out.println("\nProducing object via Factory...");
        Shape shape = requireNonNull(ShapeFactory.produceShape(shapeType));
        return shape;
    }
}
