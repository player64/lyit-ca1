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


    public Shape(Color color, boolean filled, int xCenter, int yCenter) {
        this.color = color;
        this.filled = filled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    /**
     * Draw shape.
     *
     * @param graphics the graphics
     * @param caption  the caption is used to draw a class caption
     */
    public abstract void drawShape(Graphics graphics, boolean caption, boolean displayBounding);

    public abstract void mouseClick(MouseEvent position, boolean isRightClicked) throws Exception;


    @Override
    public abstract String toString();

    protected boolean isValueBetweenRange(int min, int max, int value)
    {
        return (value >= min && value <= max);
    }

    protected boolean isClickedInside(MouseEvent position, BoundingBox boundingBox) {
        int clickedX = position.getX();
        int clickedY = position.getY();

        Point bbBottomLeft = boundingBox.getBottomLeft();
        Point bbTopRight = boundingBox.getTopRight();

        boolean isClickedBetweenX = this.isValueBetweenRange(bbBottomLeft.getX(), bbTopRight.getX(), clickedX);
        boolean isClickedBetweenY = this.isValueBetweenRange(bbTopRight.getY(), bbBottomLeft.getY(), clickedY);

        return (isClickedBetweenX && isClickedBetweenY);
    }
}
