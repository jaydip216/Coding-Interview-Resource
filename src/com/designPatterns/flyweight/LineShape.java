package com.designPatterns.flyweight;

import java.awt.*;
import java.util.List;

public class LineShape implements Shape {

    public LineShape() {
        System.out.println("Creating Line Shape");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}
