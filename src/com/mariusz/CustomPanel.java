package com.mariusz;

import com.mariusz.shapes.Rectangle;
import com.mariusz.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * The type Custom panel.
 */
public class CustomPanel extends JPanel {
    private final ShapesManager shapesManager;

    /**
     * Instantiates a new Custom panel.
     *
     * @param shapeManager - this is
     */
    public CustomPanel(ShapesManager shapeManager) {
        this.shapesManager = shapeManager;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                boolean rightMouseClicked = false;
                int modifiers = e.getModifiersEx();

                if((modifiers & InputEvent.BUTTON1_DOWN_MASK) ==  InputEvent.BUTTON1_DOWN_MASK) {
                    // left mouse button clicked

                }

                if((modifiers & InputEvent.BUTTON2_DOWN_MASK) ==  InputEvent.BUTTON2_DOWN_MASK) {

                }

                if((modifiers & InputEvent.BUTTON3_DOWN_MASK) ==  InputEvent.BUTTON3_DOWN_MASK) {
                    // right mouse button clicked
                    // System.out.println("Right button pressed");
                    rightMouseClicked = true;

                    // ArrayList<Shape> shapes = shapesManager.getShapes();
                    // shapesManager.addShape(new Rectangle(Color.green, e.getX(), e.getY(), 50, 130, true));
                }
                //


                // lets repaint
                // System.out.println("x: "+e.getX() + " y"+e.getY());
                shapesManager.clickedMouse(e, rightMouseClicked);
                repaint();

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapesManager.drawShapes(g);
    }
}
