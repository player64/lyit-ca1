package com.mariusz;

import java.awt.*;

public class Circle extends Shape {
    private final int radius;
    private final int xCenter;
    private final int yCenter;

    public Circle(int xCenter, int yCenter, int radius)
    {
        super(xCenter, yCenter);
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    @Override
    public void drawShape(Graphics graphics)
    {
        graphics.drawOval(this.xCenter, this.yCenter, this.radius, this.radius);
    }

    @Override
    public String toString()
    {
        return null;
    }
}
