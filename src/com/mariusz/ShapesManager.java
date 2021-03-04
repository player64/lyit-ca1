package com.mariusz;
import com.mariusz.shapes.Point;
import com.mariusz.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * The type Shapes manager.
 */
public class ShapesManager {
    private final ArrayList<Shape> shapes;
    private boolean displayName = true;

    /**
     * Instantiates a new Shapes manager.
     */
    public ShapesManager() {
        // new array list of shapes initialisation
        shapes = new ArrayList<Shape>();
    }

    /**
     * Draw shapes.
     *
     * @param graphicsContext the graphics context
     */
    public void drawShapes(Graphics graphicsContext)  {
        for(Shape shape : shapes) {
            shape.drawShape(graphicsContext, displayName);
        }
    }

    /**
     * Mouse is clicked
     */
    public void clickedMouse(MouseEvent e, boolean isRightClicked) {
        for(Shape shape : shapes) {
            shape.mouseClick(e, isRightClicked);
        }
    }

    /**
     * Add shape.
     *
     * @param shape the shape
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Gets shapes.
     *
     * @return the shapes
     */
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    /**
     * Sets display name.
     *
     * @param displayName the display name
     */
    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }
}
