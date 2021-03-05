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
        shapesManager.setDisplayBounding(false);
        Rectangle rect = new Rectangle(Color.pink, 400, 200,true, 200, 100);
        shapesManager.addShape(rect);

        Circle circle = new Circle(Color.cyan, 400, 80, false, 50);
        shapesManager.addShape(circle);

        Square square = new Square(Color.green, 280, 350, true, 80);
        shapesManager.addShape(square);

        Point[] points = new Point[]{
                new Point(10, 50),
                new Point(220, 80),
                new Point(200, 170),
                new Point(50, 155)
        };

        Point centerPointQuad = new Point(125, 117);

        Quadrilateral quad = new Quadrilateral(centerPointQuad, points);
        shapesManager.addShape(quad);

        Rectangle rect2 = new Rectangle(Color.red, 140, 300, 100, 70);
        Quadrilateral quad2 = new Quadrilateral(rect2);
        shapesManager.addShape(quad2);

        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Test Window");
        customWindow.setVisible(true);
    }
}
