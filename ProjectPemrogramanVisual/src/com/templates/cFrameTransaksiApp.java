package com.templates;

import javax.swing.*;

import com.partials.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class cFrameTransaksiApp extends JFrame {

    private int mouseX, mouseY;

    public JPanel bg = new JPanel();
    public JPanel cardPembayaran = new JPanel();
    public JLabel titlePembayaran = new JLabel("PEMBAYARAN");

    public cFrameTransaksiApp() {
        super();
        setSize(400, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bg.setBackground(cColor.WHITE);
        bg.setBounds(0, 0, 400, 700);
        bg.setLayout(null);

        cardPembayaran.setBackground(cColor.WHITE);
        cardPembayaran.setBounds(0, 0, 400, 700);
        cardPembayaran.setLayout(null);

        titlePembayaran.setFont(cFonts.TITLE_START_FONT);
        titlePembayaran.setForeground(cColor.BLACK);
        titlePembayaran.setBounds(0, 50, 400, 40);
        titlePembayaran.setHorizontalAlignment(JLabel.CENTER);
        titlePembayaran.setVerticalAlignment(JLabel.CENTER);

        cardPembayaran.add(titlePembayaran);
        bg.add(cardPembayaran);
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

    public cFrameTransaksiApp(String title) {
        this();
        setTitle(title);
    }
}
