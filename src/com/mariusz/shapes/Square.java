package com.mariusz.shapes;

import java.awt.*;

public class Square extends Rectangle {
    private final int width;
    private final int height;
    private final int xCenter;
    private final int yCenter;

    public Square(int xCenter, int yCenter, int width)
    {
        super(xCenter, yCenter, width, width);
        this.width = this.height = width;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    @Override
    public void drawShape(Graphics graphics)
    {
        graphics.drawRect(this.xCenter, this.yCenter, this.width, this.height);
    }
}
