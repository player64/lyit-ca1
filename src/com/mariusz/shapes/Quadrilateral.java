package com.mariusz.shapes;

import java.awt.*;
import java.util.ArrayList;

public class Quadrilateral extends Shape implements RotateAble {
    private Point centerPoint;
    private Point[] points;

    public Quadrilateral(Point centerPoint, Point[] points) throws Exception {
        if (points.length != 4) {
            throw new Exception("You must supply exactly 4 points");
        }
        this.centerPoint = centerPoint;
        this.points = points;
    }

    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4) {
        this.centerPoint = centerPoint;
        this.points = new Point[]{p1, p2, p3, p4};
    }

    public Quadrilateral(Rectangle rectangle) {

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

    @Override
    public void rotateInDegrees() {
        float radians = (float) Math.toRadians(this.angle);

        float sinTheta = (float) Math.sin(radians);
        float cosTheta = (float) Math.cos(radians);

        for (int c = 0; c < points.length; c++) {
            int pointX = points[c].getX();
            int pointY = points[c].getY();

            int xCenterDiff = pointX - centerPoint.getX();
            int yCenterDiff = pointY - centerPoint.getY();

            float newPointX = centerPoint.getX() + xCenterDiff * cosTheta - yCenterDiff * sinTheta;
            float newPointY = centerPoint.getY() + xCenterDiff * sinTheta + yCenterDiff * cosTheta;

            points[c] = new Point((int) newPointX, (int) newPointY);
        }
    }
}
