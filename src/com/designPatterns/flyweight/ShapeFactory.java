package com.designPatterns.flyweight;

import java.util.HashMap;

public class ShapeFactory {

    private static final HashMap<ShapeType, Shape> shapes = new HashMap<>();

    public static Shape getShape(ShapeType type) {
        Shape shape = shapes.get(type);

        if (shape == null) {
            if (type.equals(ShapeType.OVAL_FILL)) {
                shape = new OvalShape(true);
            } else if (type.equals(ShapeType.OVAL_NOFILL)) {
                shape = new OvalShape(false);
            } else if (type.equals(ShapeType.LINE)) {
                shape = new LineShape();
            }
            shapes.put(type, shape);
        }
        return shape;
    }

}
