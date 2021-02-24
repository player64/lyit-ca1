package com.mariusz;

import javax.swing.*;
import java.awt.*;

public class CustomWindow extends JFrame {
    private CustomPanel mainPanel;


    public CustomWindow(ShapesManager shapeManager) {
        mainPanel = new CustomPanel(shapeManager);
        add(mainPanel, BorderLayout.CENTER);
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
    }
}
