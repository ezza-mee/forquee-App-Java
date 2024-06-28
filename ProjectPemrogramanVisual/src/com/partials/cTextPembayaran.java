package com.partials;

import javax.swing.JTextArea;

public class cTextPembayaran extends JTextArea {

    public cTextPembayaran(int x, int y, int witdh, int height, boolean editable) {
        super();
        setEditable(editable);
        setBounds(x, y, witdh, height);
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(cFonts.PEMBAYARAN_FONT);
        setForeground(cColor.BLACK);
    }
}