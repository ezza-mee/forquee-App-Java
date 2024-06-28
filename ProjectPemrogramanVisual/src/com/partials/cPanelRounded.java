package com.partials;

import javax.swing.*;
import java.awt.*;

public class cPanelRounded extends JPanel {

    private int cornerRadius;

    public cPanelRounded(int x, int y, int width, int height, int radius) {
        super();
        this.cornerRadius = radius;
        setBounds(x, y, width, height);
        setBackground(cColor.GREENHEADER);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
    }
}
