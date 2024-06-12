package com.views;

import com.templates.cDashboardApp;
import com.partials.*;

import javax.swing.JOptionPane;

public class cDashboardMitraView extends cDashboardApp {

  Integer idMitra = null;
  Integer idSelected = null;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuDataMenu = new cSidebarMenu("Data Menu", 70 + 50);
  private cSidebarMenu menuDataPromo = new cSidebarMenu("Data Promo", 70 + 50 + 50);
  private cSidebarMenu menuDataMeja = new cSidebarMenu("Data Meja", 70 + 50 + 50 + 50);
  private cSidebarMenu menuDataCustomer = new cSidebarMenu("Data Customer", 70 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuDataKaryawan = new cSidebarMenu("Data Karyawan", 70 + 50 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuTransaksi = new cSidebarMenu("Transaksi", 70 + 50 + 50 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuOrderBahan = new cSidebarMenu("Order Bahan", 70 + 50 + 50 + 50 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70 + 50 + 50 + 50 + 50 + 50 + 50 + 50 + 50);

  // method resetSidebar
  private void resetSidebar() {
    try {
      setVisible(false);

      menuBeranda.setForeground(cColor.WHITE);
      menuBeranda.setBackground(cColor.GREEN);
      menuBeranda.setSidebarNonAktif();

      menuDataMenu.setForeground(cColor.WHITE);
      menuDataMenu.setBackground(cColor.GREEN);
      menuDataMenu.setSidebarNonAktif();

      menuDataPromo.setForeground(cColor.WHITE);
      menuDataPromo.setBackground(cColor.GREEN);
      menuDataPromo.setSidebarNonAktif();

      menuDataMeja.setForeground(cColor.WHITE);
      menuDataMeja.setBackground(cColor.GREEN);
      menuDataMeja.setSidebarNonAktif();

      menuDataCustomer.setForeground(cColor.WHITE);
      menuDataCustomer.setBackground(cColor.GREEN);
      menuDataCustomer.setSidebarNonAktif();

      menuDataKaryawan.setForeground(cColor.WHITE);
      menuDataKaryawan.setBackground(cColor.GREEN);
      menuDataKaryawan.setSidebarNonAktif();

      menuTransaksi.setForeground(cColor.WHITE);
      menuTransaksi.setBackground(cColor.GREEN);
      menuTransaksi.setSidebarNonAktif();

      menuOrderBahan.setForeground(cColor.WHITE);
      menuOrderBahan.setBackground(cColor.GREEN);
      menuOrderBahan.setSidebarNonAktif();

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

  public cDashboardMitraView(Integer id) {
    super("Dashboard Mitra");
    idMitra = id;
    roleText.setText("Mitra | Nama Mitra");
    menuBeranda.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsBeranda();
      }
    });
    menuDataMenu.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsDataMenu();
      }
    });
    menuDataPromo.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsDataPromo();
      }
    });
    menuDataMeja.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsDataMeja();
      }
    });
    menuDataCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsDataCustomer();
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
    menuOrderBahan.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsOrderBahan();
      }
    });
    menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        Object[] options = { "YA", "BATAL" };
        int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]);
        if (confirm == 0) {
          idMitra = null;
          idSelected = null;
          com.main.Controller.showLoginMitra();
        }
      }
    });
    // add component default
    sidebar.add(menuBeranda);
    sidebar.add(menuDataMenu);
    sidebar.add(menuDataPromo);
    sidebar.add(menuDataMeja);
    sidebar.add(menuDataCustomer);
    sidebar.add(menuDataKaryawan);
    sidebar.add(menuTransaksi);
    sidebar.add(menuOrderBahan);
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

  private void initsDataMenu() {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Data Menu");
    setVisible(true);
  }

  private void initsDataPromo() {
    idSelected = null;
    resetSidebar();
    menuDataPromo.setBackground(cColor.WHITE);
    menuDataPromo.setForeground(cColor.GREEN);
    refreshContent();
    menuDataPromo.setSidebarAktif();
    menuTitle.setText("Data Promo");
    setVisible(true);
  }

  private void initsDataMeja() {
    idSelected = null;
    resetSidebar();
    menuDataMeja.setBackground(cColor.WHITE);
    menuDataMeja.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMeja.setSidebarAktif();
    menuTitle.setText("Data Meja");
    setVisible(true);
  }

  private void initsDataCustomer() {
    idSelected = null;
    resetSidebar();
    menuDataCustomer.setBackground(cColor.WHITE);
    menuDataCustomer.setForeground(cColor.GREEN);
    refreshContent();
    menuDataCustomer.setSidebarAktif();
    menuTitle.setText("Data Meja");
    setVisible(true);
  }

  private void initsDataKaryawan() {
    idSelected = null;
    resetSidebar();
    menuDataKaryawan.setBackground(cColor.WHITE);
    menuDataKaryawan.setForeground(cColor.GREEN);
    refreshContent();
    menuDataKaryawan.setSidebarAktif();
    menuTitle.setText("Data Meja");
    setVisible(true);
  }

  private void initsTransaksi() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Data Meja");
    setVisible(true);
  }

  private void initsOrderBahan() {
    idSelected = null;
    resetSidebar();
    menuOrderBahan.setBackground(cColor.WHITE);
    menuOrderBahan.setForeground(cColor.GREEN);
    refreshContent();
    menuOrderBahan.setSidebarAktif();
    menuTitle.setText("Data Meja");
    setVisible(true);
  }

}
