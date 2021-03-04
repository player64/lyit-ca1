package com.mariusz;

import javax.swing.*;
import java.awt.*;

/**
 * The type Custom window.
 */
public class CustomWindow extends JFrame {

    /**
     * Instantiates a new Custom window.
     *
     * @param shapeManager the shape manager
     */
    public CustomWindow(ShapesManager shapeManager) {
        CustomPanel mainPanel = new CustomPanel(shapeManager);
        add(mainPanel, BorderLayout.CENTER);
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
    }
}
