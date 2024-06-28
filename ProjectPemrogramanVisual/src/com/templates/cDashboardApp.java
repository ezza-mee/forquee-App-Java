package com.templates;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.partials.*;

public abstract class cDashboardApp extends JFrame {
    private int mouseX, mouseY;

    public JPanel bg = new JPanel();
    public JPanel sidebar = new JPanel();
    public JPanel header = new JPanel();
    public JPanel main = new JPanel();
    public JPanel content = new croundedPanel(20);

    private JLabel appText = new JLabel("Forque");
    public JLabel roleText = new JLabel("Role");
    public JLabel menuTitle = new JLabel("Menu Title");
    public JLabel copyrightText = new JLabel("Copyright 2024. Jarmek.");

    public cLogoutDashboard logoutDashboard = new cLogoutDashboard(990);

    public cDashboardApp() {
        super();
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        bg.setBackground(cColor.GREEN);
        bg.setBounds(0, 0, 1366, 768);
        bg.setLayout(null);

        sidebar.setBackground(cColor.GREEN);
        sidebar.setBounds(0, 0, 230, 768);
        sidebar.setLayout(null);

        header.setBackground(cColor.WHITE);
        header.setBounds(230, 0, 1136, 70);
        header.setLayout(null);

        main.setBackground(cColor.GREY);
        main.setBounds(230, 70, 1136, 698);
        main.setLayout(null);

        content.setBackground(cColor.WHITE);
        content.setBounds(16, 70, 1100, 560);
        content.setLayout(null);

        appText.setFont(cFonts.APP_FONT);
        appText.setBounds(0, 0, 230, 70);
        appText.setHorizontalAlignment(JLabel.CENTER);
        appText.setVerticalAlignment(JLabel.CENTER);
        appText.setForeground(cColor.WHITE);

        roleText.setFont(cFonts.ROLE_FONT);
        roleText.setBounds(30, 0, 400, 70);
        roleText.setVerticalAlignment(JLabel.CENTER);
        roleText.setForeground(cColor.GREEN);

        menuTitle.setFont(cFonts.MENU_TITLE_FONT);
        menuTitle.setBounds(50, 10, 600, 50);
        menuTitle.setVerticalAlignment(JLabel.CENTER);
        menuTitle.setForeground(cColor.BLACK);

        copyrightText.setFont(cFonts.COPYRIGHT_FONT);
        copyrightText.setBounds(0, 630, 1136, 70);
        copyrightText.setHorizontalAlignment(JLabel.CENTER);
        copyrightText.setVerticalAlignment(JLabel.CENTER);
        copyrightText.setForeground(cColor.BLACK);

        header.add(roleText);
        header.add(logoutDashboard);
        sidebar.add(appText);

        main.add(menuTitle);
        main.add(content);
        main.add(copyrightText);
        bg.add(sidebar);
        bg.add(header);
        bg.add(main);
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

    public cDashboardApp(String title) {
        this();
        setTitle(title);
    }
}
