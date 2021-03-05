package com.mariusz.shapes;

import com.mariusz.Consts;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * The type Quadrilateral.
 */
public class Quadrilateral extends Shape implements RotateAble {
    private final Point centerPoint;
    private final Point[] points;
    private Polygon polygon;
    private BoundingBox boundingBox;

    /**
     * Instantiates a new Quadrilateral.
     * @param centerPoint the center point
     * @param points      the points
     * @throws Exception the exception
     */
    public Quadrilateral(Point centerPoint, Point[] points ) throws Exception {
        this(Color.gray, false, centerPoint, points);
    }

    /**
     * Instantiates a new Quadrilateral.
     * @param color the color
     * @param filled the color
     * @param centerPoint the center point
     * @param points      the points
     * @throws Exception the exception
     */
    public Quadrilateral(Color color, boolean filled, Point centerPoint, Point[] points ) throws Exception {
        super(color, filled, centerPoint.getX(), centerPoint.getY());
        if (points.length != 4) {
            throw new Exception("You must supply exactly 4 points");
        }
        this.centerPoint = centerPoint;
        this.points = points;

        this.setBoundingBox();
    }

    /**
     * Instantiates a new Quadrilateral.
     *
     * @param centerPoint the center point
     * @param p1          the p 1
     * @param p2          the p 2
     * @param p3          the p 3
     * @param p4          the p 4
     */
    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4) throws Exception {
        this(Color.gray, false, centerPoint, new Point[]{p1, p2, p3, p4});
    }

    /**
     * Instantiates a new Quadrilateral from rectangle.
     *
     * @param rect the rectangle
     */
    public Quadrilateral(Rectangle rect) throws Exception {
        super(rect.getColor(), rect.getFilled(), rect.getCentralPoint().getX(), rect.getCentralPoint().getY());
        this.centerPoint = rect.getCentralPoint();
        this.points = rect.eachBounding();
        this.setBoundingBox();
    }

    @Override
    public void drawShape(Graphics graphics, boolean caption, boolean displayBounding) {
        graphics.setColor(this.color);
        this.polygon = new Polygon();

        for (Point point : points) {
            this.polygon.addPoint(point.getX(), point.getY());
        }

        if(this.filled) {
            graphics.fillPolygon(this.polygon);
        } else {
            graphics.drawPolygon(this.polygon);
        }

        if(displayBounding) {
            this.boundingBox.draw(graphics);
        }

        if (caption) {
            graphics.setColor(Color.black);
            graphics.drawString(this.getClass().getSimpleName(), this.xCenter, this.yCenter);
        }
    }


    private void setBoundingBox() throws Exception {
        boundingBox = new BoundingBox(this.points);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " drew";
    }


    /**
     * rotateInDegrees obtain each point position on rotation
     */
    @Override
    public void rotateInDegrees() {
        float radians = (float) Math.toRadians(Consts.ANGLE_ROTATION);

        float sinTheta = (float) Math.sin(radians);
        float cosTheta = (float) Math.cos(radians);

        for (Point point : points) {
            int xCenterDiff = point.getX() - centerPoint.getX();
            int yCenterDiff = point.getY() - centerPoint.getY();

            float newPointX = centerPoint.getX() + xCenterDiff * cosTheta - yCenterDiff * sinTheta;
            float newPointY = centerPoint.getY() + xCenterDiff * sinTheta + yCenterDiff * cosTheta;

            // change to the new position
            point.setX((int) newPointX);
            point.setY((int) newPointY);
        }
    }

    @Override
    public void mouseClick(MouseEvent position, boolean isRightClicked) {
        if(!this.polygon.contains(position.getX(), position.getY())) {
            return;
        }

        this.filled = !this.filled;

        if(isRightClicked) {
            System.out.println("Right mouse click detected inside " + this.getClass().getSimpleName() + " rotating "
                    + Consts.ANGLE_ROTATION + " angle");
            this.rotateInDegrees();
        }
    }
}
