package com.partials;

import javax.swing.JTextArea;

public class cTextarea extends JTextArea {

    public cTextarea(int x, int y, int witdh, int height, boolean editable) {
        super();
        setEditable(editable);
        setBounds(x, y, witdh, height);
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(cFonts.TEXTFIELD_FONT);
        setForeground(cColor.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColor.GREEN, 1));
    }
}
