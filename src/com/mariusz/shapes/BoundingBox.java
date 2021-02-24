package com.mariusz.shapes;

import java.lang.reflect.Array;

public class BoundingBox {
    private Point bottomLeft;
    private Point topRight;

    public BoundingBox(Point bottomLeft, Point topRight)
    {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
}
