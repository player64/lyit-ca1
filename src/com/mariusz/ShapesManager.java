package com.mariusz;
import com.mariusz.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapesManager {
    private final ArrayList<Shape> shapes;
    private boolean displayName = true;

    public ShapesManager() {
        // new array list of shapes initialisation
        shapes = new ArrayList<Shape>();
    }

    public void drawShapes(Graphics graphicsContext)  {
        for(Shape shape : shapes) {
            shape.drawShape(graphicsContext, displayName);
        }
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }
}
