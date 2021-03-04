package com.mariusz.shapes;

import java.awt.*;

/**
 * Square class all method are inherited from parent Rectangle class,
 * except constructor which omits height attribute
 */
public class Square extends Rectangle {

    /**
     * Instantiates a new Square.
     *
     * @param color   the color
     * @param xCenter the x center
     * @param yCenter the y center
     * @param width   the width
     * @param filled  the filled
     */
    public Square(Color color, int xCenter, int yCenter, int width, boolean filled)
    {
        super(color, xCenter, yCenter, width, width, filled);
    }
}
