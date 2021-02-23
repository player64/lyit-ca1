package com.mariusz.shapes;

import java.awt.*;

public class Rectangle extends Shape implements MoveAble {
    private final int width;
    private final int height;
    private final int xCenter;
    private final int yCenter;

    public Rectangle(int xCenter, int yCenter, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    @Override
    public void drawShape(Graphics graphics)
    {
        graphics.drawRect(this.xCenter, this.yCenter, this.width, this.height);
    }

    @Override
    public String toString()
    {
        return "Width: " + this.width + " and Height: " + this.height;
    }

    @Override
    public void moveTenUnits()
    {

    }
}
