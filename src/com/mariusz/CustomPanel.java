package com.mariusz;

import com.mariusz.shapes.Rectangle;
import com.mariusz.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CustomPanel extends JPanel {
    private final ShapesManager shapesManager;

    public CustomPanel(ShapesManager shapeManager) {
        this.shapesManager = shapeManager;
        addMouseListener(new MouseAdapter() {

            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                boolean rightMouseClicked = false;
                int modifiers = e.getModifiersEx();

                if((modifiers & InputEvent.BUTTON1_DOWN_MASK) ==  InputEvent.BUTTON1_DOWN_MASK) {
                    // clicked left button
                    System.out.println("Left button pressed");
                }

                if((modifiers & InputEvent.BUTTON3_DOWN_MASK) ==  InputEvent.BUTTON3_DOWN_MASK) {
                    System.out.println("Right button pressed");
                    rightMouseClicked = true;

                    ArrayList<Shape> shapes = shapesManager.getShapes();
                    shapesManager.addShape(new Rectangle(Color.green, e.getX(), e.getY(), 50, 130, true));
                    /*for(Shape shape : shapes) {
                        System.out.println(shape.contains());
                    }*/

                    repaint();
                }

                System.out.println(rightMouseClicked);

                // System.out.println(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapesManager.drawShapes(g);
    }
}
