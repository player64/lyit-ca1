package com.mariusz.shapes;

import java.util.Dictionary;
import java.util.Hashtable;

public class BoundingBox {
    private Point bottomLeft;
    private Point topRight;

    public BoundingBox(Point bottomLeft, Point topRight)
    {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Dictionary<String, Integer> getBottomLeft()
    {
        Dictionary<String, Integer> coords = new Hashtable<>();
        coords.put("x", bottomLeft.getX());
        coords.put("y", bottomLeft.getY());
        return coords;
    }

    public Dictionary<String, Integer> getTopRight()
    {
        Dictionary<String, Integer> coords = new Hashtable<>();
        coords.put("x", topRight.getX());
        coords.put("y", topRight.getY());
        return coords;
    }
}
