package com.mariusz.shapes;

public class BoundingBox {
    private Point bottomLeft;
    private Point topRight;

    public BoundingBox(Point bottomLeft, Point topRight)
    {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
}
