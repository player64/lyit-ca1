package com.mariusz;

import javax.swing.*;
import java.awt.*;

public class CustomWindow extends JFrame {

    public CustomWindow(ShapesManager shapeManager) {
        CustomPanel mainPanel = new CustomPanel(shapeManager);
        add(mainPanel, BorderLayout.CENTER);
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
    }
}
