package com.mariusz.shapes;

import java.awt.*;

public class Rectangle extends Shape implements MoveAble {
    private final int width;
    private final int height;
    private final int xCenter;
    private final int yCenter;
    private boolean filled;
    private Color color;
    private int x;
    private int y;

    private BoundingBox boundingBox;

    public Rectangle(Color color, int xCenter, int yCenter, int width, int height, boolean filled)
    {
        this.width = width;
        this.height = height;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.color = color;

        // obtain x and y position
        x = xCenter - width / 2;
        y = yCenter - height / 2;
        this.filled = filled;
        this.setupBoundingBox();
    }

    @Override
    public void drawShape(Graphics graphics, boolean caption)
    {
        graphics.setColor(color);
        if(filled) {
            graphics.fillRect(this.x, this.y, this.width, this.height);
        } else {
            graphics.drawRect(this.xCenter, this.yCenter, this.width, this.height);
        }

        // graphics.fillRect(this.xCenter, this.yCenter, this.width, this.height);

/*        graphics.setColor(Color.pink);
        int[] xValues1 = {  0, 100, 150, 200 };
        int[] yValues1 = {  180, 120, 170, 220 };
        Polygon p1 = new Polygon( xValues1, yValues1, 4 );

        graphics.fillPolygon(p1);
        System.out.println(p1.getBounds());
        System.out.println(p1.contains(180, 100));*/

        if(caption) {
            graphics.setColor(Color.black);
            graphics.drawString(this.getClass().getSimpleName(), this.xCenter, this.yCenter);
        }
    }

    private void setupBoundingBox() {
        // x = 0; y = 10, w = 50, h = 80
        // bottomLeft =

        int topLeft = this.x + this.y;
        int topRight = topLeft + this.width;
        int bottomLeft = topLeft + this.height;
        int bottomRight = bottomLeft + this.width;

        // int xRight = xLeft + this.width;

    }

    @Override
    public String toString()
    {
        return "Width: " + this.width + " and Height: " + this.height;
    }

    @Override
    public void moveTenUnits()
    {
        this.x += 10;
    }
}
