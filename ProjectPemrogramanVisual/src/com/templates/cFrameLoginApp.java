package com.templates;

import javax.swing.*;

import com.partials.*;

public abstract class cFrameLoginApp extends JFrame {
    public JPanel bg = new JPanel();
    public JPanel cardLogin = new croundedPanel(30);
    public JLabel titleLogin = new JLabel("Title Login");
    public JLabel titleFrom = new JLabel("Title From");
    public JLabel fromTitle = new JLabel("Title From");

    public cLinkKeluar linkKeluar = new cLinkKeluar(990);

    public cFrameLoginApp() {
        super();
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bg.setBackground(cColor.GREEN);
        bg.setBounds(0, 0, 1100, 700);
        bg.setLayout(null);

        cardLogin.setBackground(cColor.WHITE);
        cardLogin.setBounds(100, 50, 550, 600);
        cardLogin.setLayout(null);

        titleLogin.setFont(cFonts.TITLE_START_FONT);
        titleLogin.setForeground(cColor.BLACK);
        titleLogin.setBounds(0, 90, 550, 40);
        titleLogin.setHorizontalAlignment(JLabel.CENTER);
        titleLogin.setVerticalAlignment(JLabel.CENTER);

        titleFrom.setFont(cFonts.TITLE_START_FONT);
        titleFrom.setForeground(cColor.WHITE);
        titleFrom.setBounds(770, 250, 550, 40);

        fromTitle.setFont(cFonts.TITLE_START_FONT);
        fromTitle.setForeground(cColor.WHITE);
        fromTitle.setBounds(770, 290, 550, 40);

        cardLogin.add(titleLogin);
        bg.add(titleFrom);
        bg.add(fromTitle);
        bg.add(linkKeluar);
        bg.add(cardLogin);
        add(bg);
    }

    public cFrameLoginApp(String title) {
        this();
        setTitle(title);
    }

}
