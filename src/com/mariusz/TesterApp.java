package com.mariusz;

import com.mariusz.shapes.*;
import com.mariusz.shapes.Point;
import com.mariusz.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;

/**
 * The type Tester app.
 */
public class TesterApp {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        ShapesManager shapesManager = new ShapesManager();
        shapesManager.setDisplayName(true);
        Rectangle rect = new Rectangle(Color.pink, 300, 200, 200, 100, true);
        shapesManager.addShape(rect);

        /*Circle circle = new Circle(Color.cyan, 300, 80, 50, false);
        shapesManager.addShape(circle);*/

        Square square = new Square(Color.gray, 450, 300, 80, true);
        shapesManager.addShape(square);

        int x = 50;
        int y = 80;
        int width = 300;
        int height = 150;


        Point[] points = new Point[]{
                new Point(50, 80),
                new Point(x+width + 20, y),
                new Point(x+width, y+height),
                new Point(x, y+height)
        };
        Quadrilateral quad = new Quadrilateral(new Point(x+width/2, y+height/2), points);
        shapesManager.addShape(quad);

        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Test Window");
        customWindow.setVisible(true);
    }
}
