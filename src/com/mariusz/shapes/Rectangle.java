package com.mariusz.shapes;

import com.mariusz.Consts;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;


/**
 * The type Rectangle.
 */
public class Rectangle extends Shape implements MoveAble {
    private final int width;
    private final int height;
    private int xCenter;
    private final int yCenter;
    private boolean filled;
    private Color color;
    private int x;
    private int y;
    private BoundingBox boundingBox;

    /**
     * Instantiates a new Rectangle.
     *
     * @param color   the color
     * @param xCenter the x center
     * @param yCenter the y center
     * @param width   the width
     * @param height  the height
     * @param filled  the filled
     */
    public Rectangle(Color color, int xCenter, int yCenter, int width, int height, boolean filled) {
        this.width = width;
        this.height = height;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.color = color;

        // obtain x and y position
        x = xCenter - width / 2;
        y = yCenter - height / 2;
        this.filled = filled;
        this.setBoundingBox();
    }

    @Override
    public void drawShape(Graphics graphics, boolean caption) {
        graphics.setColor(color);

        java.awt.Rectangle rec = new java.awt.Rectangle(this.x, this.y, this.width, this.height);
        if (filled) {
            graphics.fillRect(this.x, this.y, this.width, this.height);
        } else {
            graphics.drawRect(this.x, this.y, this.width, this.height);
        }

        graphics.setColor(Color.black);

        Polygon p1 = new Polygon();
        p1.addPoint(x, y);
        p1.addPoint(x + width, y);
        p1.addPoint(x + width, y + height);
        p1.addPoint(x, y + height);
        graphics.drawPolygon(p1);


        if (caption) {
            graphics.setColor(Color.black);
            graphics.drawString(this.getClass().getSimpleName(), this.xCenter, this.yCenter);
        }
    }

    private void setBoundingBox() {
        Dictionary<String, Point> coords = this.getEachPoint();
        boundingBox = new BoundingBox(coords.get("bottomLeft"), coords.get("topRight"));
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public Dictionary<String, Point> getEachPoint() {
        Dictionary<String, Point> coords = new Hashtable<>();
        coords.put("topLeft", new Point(x, y));
        coords.put("topRight", new Point(x + width, y));
        coords.put("bottomRight", new Point(x + width, y + height));
        coords.put("bottomLeft", new Point(x, y + height));
        coords.put("centerPoint", new Point(x + width / 2, y + height / 2));

        return coords;
    }

    public ArrayList<Point> eachBounding() {
        ArrayList<Point> bounds = new ArrayList<>();
        bounds.add(new Point(x, y)); // topLeft
        bounds.add(new Point(x + width, y)); // topRight
        bounds.add(new Point(x + width, y + height)); // bottomRight
        bounds.add(new Point(x, y + height)); // bottomLeft
        bounds.add(new Point(x + width / 2, y + height / 2)); // centerPoint
        return bounds;
    }

    @Override
    public String toString() {
        return "Width: " + this.width + " and Height: " + this.height;
    }

    @Override
    public void moveShape() {
        this.x += Consts.MOVE_UNITS;
        this.xCenter += Consts.MOVE_UNITS;
        this.setBoundingBox();
    }

    @Override
    public void mouseClick(MouseEvent position, boolean isRightClicked) {
        if (this.isClickedInside(position))
        {
            this.filled = !this.filled;

            if (isRightClicked) {
                this.moveShape();
            }
        }
    }

    private boolean isClickedInside(MouseEvent position) {
        int clickedX = position.getX();
        int clickedY = position.getY();

        Point bbBottomLeft = this.boundingBox.getBottomLeft();
        Point bbTopRight = this.boundingBox.getTopRight();

        boolean isClickedBetweenX = this.isValueBetweenRange(bbBottomLeft.getX(), bbTopRight.getX(), clickedX);
        boolean isClickedBetweenY = this.isValueBetweenRange(bbTopRight.getY(), bbBottomLeft.getY(), clickedY);

        return (isClickedBetweenX && isClickedBetweenY);
    }

    // if(bottomLeftX <= xClicked && xClicked <= topRightX && bottomLeftY >= yClicked && yClicked >= topRightY)
/*    private boolean isBetweenX(int xPoint) {
        int bottomLeft = this.boundingBox.getBottomLeft().get("x");
        int topRight = this.boundingBox.getTopRight().get("x");

        return (bottomLeft <= xPoint & xPoint <= topRight);
    }

    private boolean isBetweenY(int yPoint) {
        int bottomLeft = this.boundingBox.getBottomLeft().get("y");
        int topRight = this.boundingBox.getTopRight().get("y");

        return (bottomLeft >= yPoint & yPoint >= topRight);
    }*/
}
