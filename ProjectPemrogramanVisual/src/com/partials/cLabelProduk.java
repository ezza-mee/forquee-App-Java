package com.partials;
import javax.swing.*;

public class cLabelProduk extends JLabel {
    public cLabelProduk(String text, int x, int y, int width, boolean centerAligmnet){
        super();
        setText(text);
        setBounds(x,y,width, 30);
        if(centerAligmnet){
            setHorizontalAlignment(JLabel.CENTER);
        }
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FROM_LABEL_FONT);
        setForeground(cColor.BLACK);
    }
}
