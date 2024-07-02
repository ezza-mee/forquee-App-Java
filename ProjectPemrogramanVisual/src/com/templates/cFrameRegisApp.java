package com.templates;

import javax.swing.*;

import com.partials.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class cFrameRegisApp extends JFrame {
    private int mouseX, mouseY;

    public JPanel bg = new JPanel();
    public JPanel cardRegis = new croundedPanel(30);
    public JLabel titleRegis = new JLabel("Title Start");

    public cLinkKeluar linkKeluar = new cLinkKeluar(990);

    public cFrameRegisApp() {
        super();
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bg.setBackground(cColor.GREEN);
        bg.setBounds(0, 0, 1100, 700);
        bg.setLayout(null);

        cardRegis.setBackground(cColor.WHITE);
        cardRegis.setBounds(130, 80, 800, 550);
        cardRegis.setLayout(null);

        titleRegis.setFont(cFonts.TITLE_START_FONT);
        titleRegis.setForeground(cColor.BLACK);
        titleRegis.setBounds(0, 60, 800, 40);
        titleRegis.setHorizontalAlignment(JLabel.CENTER);
        titleRegis.setVerticalAlignment(JLabel.CENTER);

        cardRegis.add(titleRegis);
        bg.add(linkKeluar);
        bg.add(cardRegis);
        add(bg);

        // Menambahkan listener untuk menggeser frame
        bg.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        bg.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Menghitung posisi baru frame
                int newX = e.getXOnScreen() - mouseX;
                int newY = e.getYOnScreen() - mouseY;
                setLocation(newX, newY);
            }
        });
    }

    public cFrameRegisApp(String title) {
        this();
        setTitle(title);
    }

}
