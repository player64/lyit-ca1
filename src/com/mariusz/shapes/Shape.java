package com.mariusz.shapes;
import java.awt.*;
import java.awt.event.MouseEvent;


/**
 * This is base super class of Shape
 */
public abstract class Shape {
    protected java.awt.Color color;
    protected boolean filled;
    protected int xCenter;
    protected int yCenter;


/*    public Shape(Color color, int xCenter, int yCenter) {
        this.color = color;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }*/

    /**
     * Draw shape.
     *
     * @param graphics the graphics
     * @param caption  the caption is used to draw a class caption
     */
    public abstract void drawShape(Graphics graphics, boolean caption);

    public abstract void mouseClick(MouseEvent position, boolean isRightClicked);

    @Override
    public abstract String toString();

    protected boolean isBetweenX(int bottomLeftX, int clickX, int topRightX)
    {
        return (bottomLeftX <= clickX & clickX <= topRightX);
    }

    protected boolean isBetweenY(int bottomLeftY, int clickY, int topRightY)
    {
        return (bottomLeftY >= clickY & clickY >= topRightY);
    }

    protected boolean isValueBetweenRange(int min, int max, int value) {
        return (value >= min && value <= max);
    }
}
