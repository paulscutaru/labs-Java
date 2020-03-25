package com;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    ShapesPanel shapesPanel;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);


        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER

        //invoke the layout manager
        pack();

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        shapesPanel = new ShapesPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(shapesPanel, BorderLayout.WEST);
    }
}