package com.partials;

import javax.swing.*;

public class cLinkStart extends JLabel {
    public cLinkStart(String text, int x, int y) {
        super();
        setText(text);
        setBounds(x, y, 300, 30);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.DAFTAR_LOGIN_FONT);
        setForeground(cColor.BLACK);

        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
    }
}
