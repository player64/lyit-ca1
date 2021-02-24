package com.mariusz.shapes;

import java.awt.*;

public class Square extends Rectangle {

    public Square(Color color, int xCenter, int yCenter, int width, boolean filled)
    {
        super(color, xCenter, yCenter, width, width, filled);
    }
}
