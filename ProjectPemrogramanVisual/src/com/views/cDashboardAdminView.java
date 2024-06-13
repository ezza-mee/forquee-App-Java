package com.views;

import com.templates.cDashboardApp;
import com.partials.*;

import javax.swing.JOptionPane;

public class cDashboardAdminView extends cDashboardApp {

    private boolean statusLogin = false;
    private Integer idSelected = null;

    // sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuOrderBahan = new cSidebarMenu("Order Bahan", 70 + 50);
    private cSidebarMenu menuTransaksi = new cSidebarMenu("Transaksi", 70 + 50 + 50);
    private cSidebarMenu menuKaryawan = new cSidebarMenu("Calon Karyawan", 70 + 50 + 50 + 50);
    private cSidebarMenu menuHistory = new cSidebarMenu("History", 70 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70 + 50 + 50 + 50 + 50 + 50);

    // component of date time
    private cDateTime labelDateTimeBeranda = new cDateTime(720, 15, 300);

    // component of Order Bahan
    private cButton btnOrderBahan = new cButton("Proses", 450, 40, 150, 30, 20);

    // component of Order Bahan
    private cLabelInfo labelCariOrderBahan = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariOrderBahan = new cTextField(100, 40, 300);

    // component of Transaksi
    private cButton btnTransaksi = new cButton("Proses", 450, 40, 150, 30, 20);

    // component of Transaksi
    private cLabelInfo labelCariTransaksi = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariTransaksi = new cTextField(100, 40, 300);

    // component of Karyawan
    private cButton btnKaryawan = new cButton("Proses", 450, 40, 150, 30, 20);

    // component of Karyawan
    private cLabelInfo labelCariKaryawan = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariKaryawan = new cTextField(100, 40, 300);

    // component of History
    private cButton btnHistoryOrderBahan = new cButton("Bahan", 450, 40, 150, 30, 20);
    private cButton btnHistoryTransaksi = new cButton("Transaksi", 650, 40, 150, 30, 20);
    private cButton btnHistoryKaryawan = new cButton("Karyawan", 840, 40, 150, 30, 20);

    // component of history OrderBahan
    private cLabelInfo labelCariHistoryOrderBahan = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariHistoryOrderBahan = new cTextField(100, 40, 300);

    // component of history Transaksi
    private cLabelInfo labelCariHistoryTransaksi = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariHistoryTransaksi = new cTextField(100, 40, 300);

    // component of history Karyawan
    private cLabelInfo labelCariHistoryKaryawan = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariHistoryKaryawan = new cTextField(100, 40, 300);

    // method resetSidebar
    private void resetSidebar() {
        try {
            setVisible(false);

            menuBeranda.setForeground(cColor.WHITE);
            menuBeranda.setBackground(cColor.GREEN);
            menuBeranda.setSidebarNonAktif();

            menuOrderBahan.setForeground(cColor.WHITE);
            menuOrderBahan.setBackground(cColor.GREEN);
            menuOrderBahan.setSidebarNonAktif();

            menuTransaksi.setForeground(cColor.WHITE);
            menuTransaksi.setBackground(cColor.GREEN);
            menuTransaksi.setSidebarNonAktif();

            menuKaryawan.setForeground(cColor.WHITE);
            menuKaryawan.setBackground(cColor.GREEN);
            menuKaryawan.setSidebarNonAktif();

            menuHistory.setForeground(cColor.WHITE);
            menuHistory.setBackground(cColor.GREEN);
            menuHistory.setSidebarNonAktif();

            menuLogout.setForeground(cColor.WHITE);
            menuLogout.setBackground(cColor.GREEN);
            menuLogout.setSidebarNonAktif();

            menuLogout.setSidebarNonAktif();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method refresh content
    private void refreshContent() {
        try {
            content.removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public cDashboardAdminView(boolean statusLogin) {
        super("Dasboard Admin");
        this.statusLogin = statusLogin;
        this.idSelected = null;
        roleText.setText("Admin | Nama Admin");
        menuBeranda.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsBeranda();
            }
        });
        menuOrderBahan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsOrderBahan();
            }
        });
        menuTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsTransaksi();
            }
        });
        menuKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsKaryawan();
            }
        });
        menuHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsHistory();
            }
        });
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsLogout();
            }
        });
        // add component default
        main.add(labelDateTimeBeranda);
        sidebar.add(menuBeranda);
        sidebar.add(menuOrderBahan);
        sidebar.add(menuTransaksi);
        sidebar.add(menuKaryawan);
        sidebar.add(menuHistory);
        sidebar.add(menuLogout);
        initsBeranda();
    }

    private void initsBeranda() {
        idSelected = null;
        resetSidebar();
        menuBeranda.setBackground(cColor.WHITE);
        menuBeranda.setForeground(cColor.GREEN);
        refreshContent();
        menuBeranda.setSidebarAktif();
        menuTitle.setText("Beranda");
        setVisible(true);
    }

    private void initsOrderBahan() {
        idSelected = null;
        resetSidebar();
        menuOrderBahan.setBackground(cColor.WHITE);
        menuOrderBahan.setForeground(cColor.GREEN);
        refreshContent();
        menuOrderBahan.setSidebarAktif();
        menuTitle.setText("Data Order Bahan");

        content.add(labelCariOrderBahan);
        content.add(txtCariOrderBahan);
        content.add(btnOrderBahan);

        setVisible(true);
    }

    private void initsTransaksi() {
        idSelected = null;
        resetSidebar();
        menuTransaksi.setBackground(cColor.WHITE);
        menuTransaksi.setForeground(cColor.GREEN);
        refreshContent();
        menuTransaksi.setSidebarAktif();
        menuTitle.setText("Data Transaksi");

        content.add(labelCariTransaksi);
        content.add(txtCariTransaksi);
        content.add(btnTransaksi);

        setVisible(true);
    }

    private void initsKaryawan() {
        idSelected = null;
        resetSidebar();
        menuKaryawan.setBackground(cColor.WHITE);
        menuKaryawan.setForeground(cColor.GREEN);
        refreshContent();
        menuKaryawan.setSidebarAktif();
        menuTitle.setText("Data Karyawan");

        content.add(labelCariKaryawan);
        content.add(txtCariKaryawan);
        content.add(btnKaryawan);

        setVisible(true);
    }

    private void initsHistory() {
        idSelected = null;
        resetSidebar();
        menuHistory.setBackground(cColor.WHITE);
        menuHistory.setForeground(cColor.GREEN);
        refreshContent();
        menuHistory.setSidebarAktif();
        menuTitle.setText("Data History");

        btnHistoryOrderBahan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryOrderBahan();
            }
        });

        btnHistoryTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryTransaksi();
            }
        });

        btnHistoryKaryawan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryKaryawan();
            }
        });

        content.add(btnHistoryOrderBahan);
        content.add(btnHistoryTransaksi);
        content.add(btnHistoryKaryawan);
        initsHistoryOrderBahan();
        setVisible(true);
    }

    private void initsHistoryOrderBahan() {
        idSelected = null;
        resetSidebar();
        menuHistory.setBackground(cColor.WHITE);
        menuHistory.setForeground(cColor.GREEN);
        refreshContent();
        menuHistory.setSidebarAktif();
        menuTitle.setText("Data History Bahan");

        btnHistoryOrderBahan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryOrderBahan();
            }
        });

        btnHistoryTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryTransaksi();
            }
        });

        btnHistoryKaryawan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryKaryawan();
            }
        });

        content.add(btnHistoryOrderBahan);
        content.add(btnHistoryTransaksi);
        content.add(btnHistoryKaryawan);
        content.add(labelCariHistoryOrderBahan);
        content.add(txtCariHistoryOrderBahan);
        setVisible(true);
    }

    private void initsHistoryTransaksi() {
        idSelected = null;
        resetSidebar();
        menuHistory.setBackground(cColor.WHITE);
        menuHistory.setForeground(cColor.GREEN);
        refreshContent();
        menuHistory.setSidebarAktif();
        menuTitle.setText("Data History Transaksi");

        btnHistoryOrderBahan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryOrderBahan();
            }
        });

        btnHistoryTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryTransaksi();
            }
        });

        btnHistoryKaryawan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryKaryawan();
            }
        });

        content.add(btnHistoryOrderBahan);
        content.add(btnHistoryTransaksi);
        content.add(btnHistoryKaryawan);
        content.add(labelCariHistoryTransaksi);
        content.add(txtCariHistoryTransaksi);
        setVisible(true);
    }

    private void initsHistoryKaryawan() {
        idSelected = null;
        resetSidebar();
        menuHistory.setBackground(cColor.WHITE);
        menuHistory.setForeground(cColor.GREEN);
        refreshContent();
        menuHistory.setSidebarAktif();
        menuTitle.setText("Data History Karyawan");

        btnHistoryOrderBahan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryOrderBahan();
            }
        });

        btnHistoryTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryTransaksi();
            }
        });

        btnHistoryKaryawan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                initsHistoryKaryawan();
            }
        });

        content.add(btnHistoryOrderBahan);
        content.add(btnHistoryTransaksi);
        content.add(btnHistoryKaryawan);
        content.add(labelCariHistoryKaryawan);
        content.add(txtCariHistoryKaryawan);
        setVisible(true);
    }

    private void initsLogout() {
        Object[] options = { "YA", "BATAL" };
        int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        if (confirm == 0) {
            this.statusLogin = false;
            this.idSelected = null;
            com.main.Controller.showLoginAdmin();
            cDashboardAdminView.this.setVisible(false);
        }
    }

}
