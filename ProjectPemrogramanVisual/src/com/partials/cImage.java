package com.partials;

import javax.swing.*;
import java.awt.*;

public class cImage extends JLabel {
    private ImageIcon imageIcon;

    public cImage(String imagePath, int x, int y, int width, int height) {
        super();
        imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        setIcon(imageIcon);
        setBounds(x, y, width, height);
    }
}
