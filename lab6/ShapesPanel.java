package com;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ShapesPanel extends JPanel {
    final MainFrame frame;
    JComboBox shapeCombo;
    Vector<String> shapeList = new Vector<>();

    public ShapesPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        shapeList.add("RegularPolygon");
        shapeList.add("NodeShape");
        JLabel sidesLabel = new JLabel("Select shape:");
        shapeCombo = new JComboBox(shapeList);
        add(sidesLabel);
        add(shapeCombo);
    }
}
