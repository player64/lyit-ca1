package com.mariusz;

import com.mariusz.shapes.*;

import javax.swing.*;

public class TesterApp {

    public static void main(String[] args) {
	    ShapesManager shapesManager = new ShapesManager();
	    Rectangle rect = new Rectangle(30,20,40,50);
	    shapesManager.addShape(rect);

        Circle circle = new Circle(100, 60, 200);
        shapesManager.addShape(circle);

        Square square = new Square(0, 0, 30);
        shapesManager.addShape(square);

        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Test Window");
        customWindow.setVisible(true);
    }
}
