package com.designPatterns.flyweight;

import java.awt.*;

public class OvalShape implements Shape{

    private boolean fill;

    public OvalShape(boolean fill) {
        this.fill = fill;
        System.out.println("Creating Oval Shape with fill=" + fill);
        // Adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
        if (fill) {
            g.fillOval(x, y, width, height);
        }
    }
}
