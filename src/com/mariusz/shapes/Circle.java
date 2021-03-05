package com.mariusz.shapes;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * The type Circle.
 */
public class Circle extends Shape {
    private final int x;
    private final int y;
    private final int diameter;
    private final int radius;
    private BoundingBox boundingBox;


    /**
     * Instantiates a new Circle.
     *
     * @param color   the color
     * @param xCenter the x center
     * @param yCenter the y center
     * @param radius  the radius
     */
    public Circle(Color color, int xCenter, int yCenter, int radius) throws Exception {
        this(color, xCenter, yCenter, false, radius);
    }

    /**
     * Instantiates a new Circle.
     *
     * @param color   the color
     * @param xCenter the x center
     * @param yCenter the y center
     * @param radius  the radius
     * @param filled  the filled
     */
    public Circle(Color color, int xCenter, int yCenter, boolean filled, int radius) throws Exception {
        super(color, filled, xCenter, yCenter);
        diameter = radius * 2;
        this.radius = radius;

        // obtain x and y position
        x = xCenter - radius;
        y = yCenter - radius;

        this.setBoundingBox();
    }

    @Override
    public void drawShape(Graphics graphics, boolean caption, boolean displayBounding)
    {
        graphics.setColor(this.color);
        if(this.filled) {
            graphics.fillOval(this.x, this.y, this.diameter, this.diameter);
        } else {
            graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
        }
        if(caption) {
            graphics.setColor(Color.black);
            graphics.drawString(this.getClass().getSimpleName(), this.xCenter, this.yCenter);
        }

        if(displayBounding) {
            this.boundingBox.draw(graphics);
        }
    }

    @Override
    public void mouseClick(MouseEvent position, boolean isRightClicked) {
        if (this.isClickedInside(position, this.boundingBox))
        {
            System.out.println("Mouse click detected inside " + this.getClass().getSimpleName() + " " +
                    ((this.filled) ? "" : " un-") + "filling shape");
            this.filled = !this.filled;
        }
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " drew Radius: " + this.radius;
    }

    private void setBoundingBox() throws Exception {
        boundingBox = new BoundingBox(new Point[]{
                new Point(x, y),
                new Point(x + diameter, y),
                new Point(x + diameter, y + diameter),
                new Point(x, y + diameter),
        });
    }
}
