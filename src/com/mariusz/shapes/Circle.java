package com.mariusz.shapes;

import java.awt.*;

public class Circle extends Shape {
    private final int xCenter;
    private final int yCenter;
    private boolean filled;
    private final int x;
    private final int y;
    private Color color;
    private int diameter;

    public Circle(Color color, int xCenter, int yCenter, int radius, boolean filled)
    {
        diameter = radius * 2;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.color = color;

        this.filled = filled;

        // obtain x and y position
        x = xCenter - radius;
        y = yCenter - radius;
    }

    @Override
    public void drawShape(Graphics graphics, boolean caption)
    {
        graphics.setColor(this.color);
        if(this.filled) {
            graphics.fillOval(this.x, this.y, this.diameter, this.diameter);
        } else {
            graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
        }
        if(caption) {
            graphics.setColor(Color.black);
            graphics.drawString(this.getClass().getSimpleName(), this.xCenter, this.yCenter);
        }
    }

    @Override
    public String toString()
    {
        return null;
    }
}
