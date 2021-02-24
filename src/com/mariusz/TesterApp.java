package com.mariusz;

import com.mariusz.shapes.*;
import com.mariusz.shapes.Rectangle;

import javax.swing.*;
import java.awt.*;

public class TesterApp {

    public static void main(String[] args) {
	    ShapesManager shapesManager = new ShapesManager();
	    shapesManager.setDisplayName(false);
	    Rectangle rect = new Rectangle(Color.blue, 0,10,50,80, false);
	    shapesManager.addShape(rect);


        Circle circle = new Circle(Color.cyan, 300, 80, 50, false);
        shapesManager.addShape(circle);

        Square square = new Square(Color.gray, 450, 300, 80, true);
        shapesManager.addShape(square);

        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Test Window");
        customWindow.setVisible(true);
    }
}
