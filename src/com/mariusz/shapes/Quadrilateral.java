package com.mariusz.shapes;

import com.mariusz.Consts;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Dictionary;

/**
 * The type Quadrilateral.
 */
public class Quadrilateral extends Shape implements RotateAble {
    private Point centerPoint;
    private Point[] points;

    /**
     * Instantiates a new Quadrilateral.
     *
     * @param centerPoint the center point
     * @param points      the points
     * @throws Exception the exception
     */
    public Quadrilateral(Point centerPoint, Point[] points) throws Exception {
        if (points.length != 4) {
            throw new Exception("You must supply exactly 4 points");
        }
        this.centerPoint = centerPoint;
        this.points = points;
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
    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4) {
        this.centerPoint = centerPoint;
        this.points = new Point[]{p1, p2, p3, p4};
    }

    /**
     * Instantiates a new Quadrilateral.
     *
     * @param rectangle the rectangle
     */
    public Quadrilateral(Rectangle rectangle) {
        Dictionary<String, Point> coords = rectangle.getEachPoint();

        this.centerPoint = coords.get("centerPoint");
        this.points = new Point[]{
                coords.get("topLeft"),
                coords.get("topRight"),
                coords.get("bottomRight"),
                coords.get("bottomLeft"),
        };
    }

    @Override
    public void drawShape(Graphics graphics, boolean caption) {
        Polygon polygon = new Polygon();

        for (Point point : points) {
            polygon.addPoint(point.getX(), point.getY());
        }
        graphics.drawPolygon(polygon);
        this.rotateInDegrees();
    }

    @Override
    public String toString() {
        return null;
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

    }
}
