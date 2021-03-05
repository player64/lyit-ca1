package com.mariusz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Custom panel.
 */
public class CustomPanel extends JPanel {
    private final ShapesManager shapesManager;

    /**
     * Instantiates a new Custom panel.
     *
     * @param shapeManager
     */
    public CustomPanel(ShapesManager shapeManager) {
        this.shapesManager = shapeManager;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                boolean rightMouseClicked = false;
                int modifiers = e.getModifiersEx();

                if((modifiers & InputEvent.BUTTON3_DOWN_MASK) ==  InputEvent.BUTTON3_DOWN_MASK) {
                    rightMouseClicked = true;
                }
                try {
                    shapesManager.clickedMouse(e, rightMouseClicked);
                    repaint();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapesManager.drawShapes(g);
    }
}
