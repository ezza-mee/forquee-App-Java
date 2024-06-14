package com.partials;

import javax.swing.JComboBox;

public class cComboBox extends JComboBox<String> {
    public cComboBox(String[] items, int x, int y, int width, int height) {
        super(items);
        setBounds(x, y, width, height);
        setFont(cFonts.LABEL_INFO_FONT);
        setForeground(cColor.BLACK);
        setBackground(cColor.WHITE);
        setBorder(new javax.swing.border.LineBorder(cColor.GREEN, 1));
        setMaximumRowCount(3);
    }

}
