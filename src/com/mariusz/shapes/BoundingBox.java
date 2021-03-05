package com.mariusz.shapes;

import java.awt.*;

/**
 * The type Bounding box.
 */
public class BoundingBox {
    private final Point bottomLeft;
    private final Point topRight;
    private final Point topLeft;
    private final Point bottomRight;

    /**
     * Instantiates a new Bounding box.
     *
     * @param points get points from four points
     */
    public BoundingBox(Point[] points) throws Exception {
        if (points.length != 4) {
            throw new Exception("You must supply exactly 4 points");
        }
        this.topLeft = points[0];
        this.topRight = points[1];
        this.bottomRight = points[2];
        this.bottomLeft = points[3];
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


    /**
     * Gets top left.
     *
     * @return the top left
     */
    public Point getTopLeft()
    {
        return topLeft;
    }

    /**
     * Gets bottom right.
     *
     * @return the bottom right
     */
    public Point getBottomRight()
    {
        return bottomRight;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.orange);
        Polygon polygon = new Polygon();
        polygon.addPoint(topLeft.getX(), topLeft.getY());
        polygon.addPoint(topRight.getX(), topRight.getY());
        polygon.addPoint(bottomRight.getX(), bottomRight.getY());
        polygon.addPoint(bottomLeft.getX(), bottomLeft.getY());

        graphics.drawPolygon(polygon);
    }
}
