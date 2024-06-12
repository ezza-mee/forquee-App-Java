package com.partials;

import javax.swing.*;

public class cCheckBox extends JCheckBox {
    public cCheckBox(String text, String value, int x, int y, int widht) {
        super();
        setText(text);
        setBounds(x, y, 200, 30);
        setForeground(cColor.BLACK);
        setBackground(cColor.GREEN);
        setVerticalAlignment(JCheckBox.CENTER);
        setHorizontalAlignment(JCheckBox.CENTER);
        setFont(cFonts.FROM_LABEL_FONT);
        setForeground(cColor.BLACK);
        setActionCommand(value);

    }
}
