package com.mariusz.shapes;

import com.mariusz.Consts;

import java.awt.*;
import java.awt.event.MouseEvent;


/**
 * The type Rectangle.
 */
public class Rectangle extends Shape implements MoveAble {
    private final int width;
    private final int height;
    private int x;
    private final int y;
    private BoundingBox boundingBox;


    /**
     * Instantiates a new Rectangle.
     *
     * @param color   the color
     * @param xCenter the x center
     * @param yCenter the y center
     * @param width   the width
     * @param height  the height
     */
    public Rectangle(Color color, int xCenter, int yCenter, int width, int height) throws Exception {
        this(color, xCenter, yCenter, false, width, height);
    }

    /**
     * Instantiates a new Rectangle.
     *
     * @param color   the color
     * @param xCenter the x center
     * @param yCenter the y center
     * @param filled  the filled
     * @param width   the width
     * @param height  the height
     */
    public Rectangle(Color color, int xCenter, int yCenter, boolean filled, int width, int height) throws Exception {
        super(color, filled, xCenter, yCenter);


        this.width = width;
        this.height = height;
        this.color = color;

        // obtain x and y position
        x = this.xCenter - width / 2;
        y = this.yCenter - height / 2;
        this.setBoundingBox();
    }

    @Override
    public void drawShape(Graphics graphics, boolean caption, boolean displayBounding) {
        graphics.setColor(color);

        if (filled) {
            graphics.fillRect(this.x, this.y, this.width, this.height);
        } else {
            graphics.drawRect(this.x, this.y, this.width, this.height);
        }

        if (displayBounding) {
            this.boundingBox.draw(graphics);
        }

        if (caption) {
            graphics.setColor(Color.black);
            graphics.drawString(this.getClass().getSimpleName(), this.xCenter, this.yCenter);
        }
    }

    private void setBoundingBox() throws Exception {
        boundingBox = new BoundingBox(this.eachBounding());
    }

    public Point[] eachBounding() {
        return new Point[]{
                // topLeft
                new Point(x, y),
                // topRight
                new Point(x + width, y),
                // bottomRight
                new Point(x + width, y + height),
                // bottomLeft
                new Point(x, y + height),
        };
    }

    public Point getCentralPoint() {
        return new Point(this.xCenter, this.yCenter);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " drew Width: " + this.width + " Height: " + this.height;
    }

    @Override
    public void moveShape() throws Exception {
        this.x += Consts.MOVE_UNITS;
        this.xCenter += Consts.MOVE_UNITS;
        this.setBoundingBox();
    }

    @Override
    public void mouseClick(MouseEvent position, boolean isRightClicked) throws Exception {
        if (this.isClickedInside(position, this.boundingBox)) {
            this.filled = !this.filled;
            System.out.println("Mouse click detected inside " + this.getClass().getSimpleName() + " " +
                    ((this.filled) ? "" : "un-") + "filling shape");
            if (isRightClicked) {
                System.out.println("Right mouse click detected inside " + this.getClass().getSimpleName() + " moving "
                        + Consts.MOVE_UNITS + " points");
                this.moveShape();
            }
        }
    }

    public Color getColor()
    {
        return this.color;
    }

    public boolean getFilled()
    {
        return this.filled;
    }
}
