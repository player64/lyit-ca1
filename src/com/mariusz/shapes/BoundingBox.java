package com.mariusz.shapes;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * The type Bounding box.
 */
public class BoundingBox {
    private Point bottomLeft;
    private Point topRight;

    /**
     * Instantiates a new Bounding box.
     *
     * @param bottomLeft the bottom left
     * @param topRight   the top right
     */
    public BoundingBox(Point bottomLeft, Point topRight)
    {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    /**
     * Gets bottom left.
     *
     * @return the bottom left
     */
    public Point getBottomLeft()
    {
        return this.bottomLeft;
    }

    /**
     * Gets top right.
     *
     * @return the top right
     */
    public Point getTopRight()
    {
        return topRight;
    }

}
