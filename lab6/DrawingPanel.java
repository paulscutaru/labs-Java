package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 1280, H = 720;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    protected void reset() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
        update(graphics);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    private void drawShape(int x, int y) {
        Random random = new Random();
        String shape = (String) frame.shapesPanel.shapeCombo.getSelectedItem();
        int radius = random.nextInt(200); //generate a random number
        int sides = (int) frame.configPanel.sidesField.getValue();//get the value from UI (in ConfigPanel)
        Color color = Color.BLACK;
        if (frame.configPanel.colorCombo.getSelectedItem() == "Random")
            color = new Color(random.nextInt(255), random.nextInt(100), random.nextInt(200));
        else if(frame.configPanel.colorCombo.getSelectedItem() == "Black")
            color = Color.BLACK;
        graphics.setColor(color);
        if (shape.equals("RegularPolygon"))
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        else if (shape.equals("NodeShape"))
            graphics.fill(new NodeShape(x, y, radius));
    }

    @Override
    public void update(Graphics g) {
        updateUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
        update(g);
    }
}
