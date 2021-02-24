package com.mariusz;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    private final ShapesManager shapesManager;

    public CustomPanel(ShapesManager shapeManager) {
        this.shapesManager = shapeManager;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapesManager.drawShapes(g);
    }
}
