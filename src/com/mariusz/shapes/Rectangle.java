package com.mariusz.shapes;

import java.awt.*;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;


public class Rectangle extends Shape implements MoveAble {
    private final int width;
    private final int height;
    private final int xCenter;
    private final int yCenter;
    private boolean filled;
    private Color color;
    private int x;
    private int y;

    private BoundingBox boundingBox;

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
        this.setupBoundingBox();
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
        /*int[] xValues1 = {  this.x, this.x + this.width, this.x, x + this.width };
        int[] yValues1 = {  y,this.y + this.height, y, this.y + this.height};*/

        // 40, 160, 160, 40
        // 100, 100, 120, 120

        /*
        * [0, 200, 0, 200]
[0, 100, 0, 100]
        *
        * */

        /*int[] xValues1 = {  20, 80, 20, 80 };
        int[] yValues1 = {  50, 60, 50, 60};*/


        /*int[] xValues1 = {this.x, this.x+width, x+width, this.x };
        int[] yValues1 = {this.y, this.y, this.y + this.height, this.y + this.height};
        Polygon p1 = new Polygon( xValues1, yValues1, 4);
        graphics.drawPolygon(p1);*/
        // graphics.fillRect(this.xCenter, this.yCenter, this.width, this.height);

        Polygon p1 = new Polygon();
        p1.addPoint(x, y);
        p1.addPoint(x+width, y);
        p1.addPoint(x+width, y+height);
        p1.addPoint(x, y+height);
        graphics.drawPolygon(p1);


/*        graphics.setColor(Color.pink);
        int[] xValues1 = {  0, 100, 150, 200 };
        int[] yValues1 = {  180, 120, 170, 220 };
        Polygon p1 = new Polygon( xValues1, yValues1, 4 );

        graphics.fillPolygon(p1);
        System.out.println(p1.getBounds());
        System.out.println(p1.contains(180, 100));*/

        if (caption) {
            graphics.setColor(Color.black);
            graphics.drawString(this.getClass().getSimpleName(), this.xCenter, this.yCenter);
        }
    }

    private void setupBoundingBox() {
        // x = 0; y = 10, w = 50, h = 80
        // bottomLeft =
        // let's put each edge coordinates to the dictionary
        Dictionary<String, Integer> coords = new Hashtable<>();
        // https://www.javaprogramto.com/2017/10/java-dictionary-creation-usage-examples.html
        // topLeft coordinate
        coords.put("tL", this.x + this.y);
        // topRight coordinate
        coords.put("tR", coords.get("tL") + this.width);
        // bottomLeft coordinate
        coords.put("bL", coords.get("tL") + this.height);
        // bottomRight coordinate
        coords.put("bR", coords.get("bL") + this.width);


        int topLeft = this.x + this.y;
        int topRight = topLeft + this.width;
        int bottomLeft = topLeft + this.height;
        int bottomRight = bottomLeft + this.width;

        BoundingBox bb = new BoundingBox(new Point(30,40), new Point(40, 40));

        // System.out.println(bb.getBottomLeft().get("y"));

        // int xRight = xLeft + this.width;

    }

    @Override
    public String toString() {
        return "Width: " + this.width + " and Height: " + this.height;
    }

    @Override
    public void moveTenUnits() {
        this.x += this.UNITS;
    }
}
