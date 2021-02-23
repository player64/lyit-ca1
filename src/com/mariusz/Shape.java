package com.mariusz;
import java.awt.*;

/**
 * This is base super class of Shape
 *
 * **/


public abstract class Shape {
    private java.awt.Color color;
    private boolean filled;

    public Shape(int xCenter, int yCenter) {

    }

    public abstract void drawShape(Graphics graphics);

    @Override
    public abstract String toString();
}
