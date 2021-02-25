package com.mariusz.shapes;

import java.awt.*;
import java.util.ArrayList;

public class Quadrilateral extends Shape implements RotateAble {
    private Point centerPoint;
    private Point[] points;
    
    public Quadrilateral(Point centerPoint, Point[] points) throws Exception {
        if(points.length != 4) {
            throw new Exception("You must supply exactly 4 points");
        }
        this.centerPoint = centerPoint;
        this.points = points;
    }

    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4)
    {
        this.centerPoint = centerPoint;
        this.points = new Point[]{p1, p2, p3, p4};
    }

    public Quadrilateral(Rectangle rectangle)
    {
        
    }

    @Override
    public void drawShape(Graphics graphics, boolean caption) {
        Polygon polygon = new Polygon();

        for(Point point : points) {
            polygon.addPoint(point.getX(), point.getY());
        }
        graphics.drawPolygon(polygon);

        this.rotateNinetyDegrees();

    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void rotateNinetyDegrees() {
        int angle = 90;
        float radians = (float) ((float) angle * Math.PI / 180);
        // https://stackoverflow.com/questions/26648722/rotating-a-point-around-another-point-java
        for(int c = 0; c < points.length; c++) {
            int pointX = points[c].getX();
            int pointY = points[c].getY();

            // x1 = x cosθtheta - y sinθtheta
            // y1 = x sinθtheta + y cosθtheta
            float sinTheta = (float) Math.sin(Math.toRadians(angle));
            float cosTheta = (float) Math.cos(Math.toRadians(angle ));

            int newPointX = (int) (pointX * cosTheta - pointY * sinTheta);
            int newPointY = (int) (pointX * sinTheta - pointY * cosTheta);

            System.out.println("x: "+ newPointX + " y: "+newPointY);


            points[c] = new Point(newPointX,newPointY);

        }
    }
}
