package com.mariusz.shapes;

import java.awt.*;

public class Circle extends Shape {
    private final int radius;
    private final int xCenter;
    private final int yCenter;

    public Circle(int xCenter, int yCenter, int radius)
    {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    @Override
    public void drawShape(Graphics graphics, boolean caption)
    {
        graphics.drawOval(this.xCenter, this.yCenter, this.radius, this.radius);
        if(caption) {
            graphics.drawString(this.getClass().getSimpleName(), this.xCenter - 30, this.yCenter -30);
        }
    }

    @Override
    public String toString()
    {
        return null;
    }
}
