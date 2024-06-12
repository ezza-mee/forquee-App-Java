package com.partials;

import javax.swing.*;

public class cButtonLogin extends JButton {
    public cButtonLogin(String text, int x, int y, int width, int height) {
        super();
        setText(text);
        setBounds(x, y, width, height);
        setFont(cFonts.BUTTON_FONT);
        setBackground(cColor.GREEN);
        setForeground(cColor.WHITE);
        setBorder(null);
    }
}
