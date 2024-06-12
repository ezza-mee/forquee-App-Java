package com.partials;

public class cButtonBlue extends cButtonLogin {
    public cButtonBlue(String text, int x, int y, int width, int height) {
        super(text, x, y, width, height);
        setFont(cFonts.BUTTON_FONT);
        setBackground(cColor.GREEN);
        setForeground(cColor.WHITE);
        setBorder(null);
    }
}
