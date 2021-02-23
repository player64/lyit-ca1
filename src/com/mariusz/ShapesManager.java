package com.mariusz;
import com.mariusz.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapesManager {
    private ArrayList<Shape> shapes;


    public void drawShapes(Graphics graphicsContext) {
        for(Shape shape : this.shapes) {
            shape.drawShape(graphicsContext);
        }
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }
}
