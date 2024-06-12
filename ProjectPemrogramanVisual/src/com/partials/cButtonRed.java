package com.partials;

public class cButtonRed extends cButtonLogin {
    public cButtonRed(String text, int x, int y, int width, int height) {
        super(text, x, y, width, height);
        setFont(cFonts.BUTTON_FONT);
        setBackground(cColor.RED);
        setForeground(cColor.WHITE);
        setBorder(null);
    }
}
