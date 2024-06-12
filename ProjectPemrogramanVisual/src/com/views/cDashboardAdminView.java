package com.views;

import com.templates.cDashboardApp;
import com.partials.*;

import javax.swing.JOptionPane;

public class cDashboardAdminView extends cDashboardApp {

    private boolean statusLogin = false;
    private Integer idSelected = null;

    // sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuDataKaryawan = new cSidebarMenu("Data Menu", 70 + 50);
    private cSidebarMenu menuTransaksi = new cSidebarMenu("Transaksi", 70 + 50 + 50);
    private cSidebarMenu menuHistory = new cSidebarMenu("History", 70 + 50 + 50 + 50);
    private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70 + 50 + 50 + 50 + 50 + 50 + 50 + 50 + 50);

    // method resetSidebar
    private void resetSidebar() {
        try {
            setVisible(false);

            menuBeranda.setForeground(cColor.WHITE);
            menuBeranda.setBackground(cColor.GREEN);
            menuBeranda.setSidebarNonAktif();

            menuDataKaryawan.setForeground(cColor.WHITE);
            menuDataKaryawan.setBackground(cColor.GREEN);
            menuDataKaryawan.setSidebarNonAktif();

            menuTransaksi.setForeground(cColor.WHITE);
            menuTransaksi.setBackground(cColor.GREEN);
            menuTransaksi.setSidebarNonAktif();

            menuHistory.setForeground(cColor.WHITE);
            menuHistory.setBackground(cColor.GREEN);
            menuHistory.setSidebarNonAktif();

            menuLogout.setForeground(cColor.WHITE);
            menuLogout.setBackground(cColor.GREEN);
            menuLogout.setSidebarNonAktif();

            menuLogout.setSidebarNonAktif();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // method refresh content
    private void refreshContent() {
        try {
            content.removeAll();
        } catch (Exception e) {
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
        menuDataKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsDataKaryawan();
            }
        });
        menuTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsTransaksi();
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
        sidebar.add(menuBeranda);
        sidebar.add(menuDataKaryawan);
        sidebar.add(menuTransaksi);
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

    private void initsDataKaryawan() {
        idSelected = null;
        resetSidebar();
        menuDataKaryawan.setBackground(cColor.WHITE);
        menuDataKaryawan.setForeground(cColor.GREEN);
        refreshContent();
        menuDataKaryawan.setSidebarAktif();
        menuTitle.setText("Data Menu");
        setVisible(true);
    }

    private void initsTransaksi() {
        idSelected = null;
        resetSidebar();
        menuTransaksi.setBackground(cColor.WHITE);
        menuTransaksi.setForeground(cColor.GREEN);
        refreshContent();
        menuTransaksi.setSidebarAktif();
        menuTitle.setText("Data Menu");
        setVisible(true);
    }

    private void initsHistory() {
        idSelected = null;
        resetSidebar();
        menuHistory.setBackground(cColor.WHITE);
        menuHistory.setForeground(cColor.GREEN);
        refreshContent();
        menuHistory.setSidebarAktif();
        menuTitle.setText("Data Meja");
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
        }
    }

}
