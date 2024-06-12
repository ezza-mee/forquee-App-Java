package com.partials;

import javax.swing.JLabel;

public class cButtonData extends JLabel {

    public java.awt.event.MouseAdapter siButtonDataAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBackground(cColor.GREEN);
            setForeground(cColor.WHITE);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(cColor.GREEN);
            setForeground(cColor.WHITE);
        }
    };

    public java.awt.event.MouseAdapter siButtonDataNonAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBackground(cColor.GREEN);
            setForeground(cColor.WHITE);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(cColor.GREEN);
            setForeground(cColor.WHITE);
        }
    };

    public cButtonData(String text, int x, int y, int width, int height) {
        super();
        setText(text);
        setBounds(x, y, width, height);
        setOpaque(true);
        setFont(cFonts.COPYRIGHT_FONT);
        setForeground(cColor.GREEN);
        setBackground(cColor.WHITE);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
        setButtonDataNonAktif();
    }

    public void setButtonDataAktif() {
        try {
            removeMouseListener(siButtonDataNonAktif);

        } catch (Exception e) {
            // TODO: handle exception
        }
        addMouseListener(siButtonDataAktif);
    }

    public void setButtonDataNonAktif() {
        try {
            removeMouseListener(siButtonDataAktif);

        } catch (Exception e) {
            // TODO: handle exception
        }
        addMouseListener(siButtonDataNonAktif);
    }
}
