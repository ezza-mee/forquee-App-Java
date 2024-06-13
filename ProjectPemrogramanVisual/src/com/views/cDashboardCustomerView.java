package com.views;

import com.templates.cDashboardApp;
import com.partials.*;

import javax.swing.JOptionPane;

public class cDashboardCustomerView extends cDashboardApp {

  Integer idCustomer = null;
  Integer idSelected = null;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuDataMenu = new cSidebarMenu("Menu Produk", 70 + 50);
  private cSidebarMenu menuOrder = new cSidebarMenu("Order Produk", 70 + 50 + 50);
  private cSidebarMenu menuHistory = new cSidebarMenu("History Produk", 70 + 50 + 50 + 50);
  private cSidebarMenu menuAkun = new cSidebarMenu("Akun", 70 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70 + 50 + 50 + 50 + 50 + 50);

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

      menuOrder.setForeground(cColor.WHITE);
      menuOrder.setBackground(cColor.GREEN);
      menuOrder.setSidebarNonAktif();

      menuHistory.setForeground(cColor.WHITE);
      menuHistory.setBackground(cColor.GREEN);
      menuHistory.setSidebarNonAktif();

      menuAkun.setForeground(cColor.WHITE);
      menuAkun.setBackground(cColor.GREEN);
      menuAkun.setSidebarNonAktif();

      menuLogout.setForeground(cColor.WHITE);
      menuLogout.setBackground(cColor.GREEN);
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
    }
  }

  public cDashboardCustomerView(Integer id) {
    super("Dashboard Customer");
    idCustomer = id;
    roleText.setText("Customer | Nama Customer");

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

    menuOrder.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsOrder();
      }
    });

    menuHistory.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsHistory();
      }
    });

    menuAkun.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsAkun();
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
    sidebar.add(menuDataMenu);
    sidebar.add(menuOrder);
    sidebar.add(menuHistory);
    sidebar.add(menuAkun);
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
    menuTitle.setText("Menu");
    setVisible(true);
  }

  private void initsOrder() {
    idSelected = null;
    resetSidebar();
    menuOrder.setBackground(cColor.WHITE);
    menuOrder.setForeground(cColor.GREEN);
    refreshContent();
    menuOrder.setSidebarAktif();
    menuTitle.setText("Order");
    setVisible(true);
  }

  private void initsHistory() {
    idSelected = null;
    resetSidebar();
    menuHistory.setBackground(cColor.WHITE);
    menuHistory.setForeground(cColor.GREEN);
    refreshContent();
    menuHistory.setSidebarAktif();
    menuTitle.setText("History");
    setVisible(true);
  }

  private void initsAkun() {
    idSelected = null;
    resetSidebar();
    menuAkun.setBackground(cColor.WHITE);
    menuAkun.setForeground(cColor.GREEN);
    refreshContent();
    menuAkun.setSidebarAktif();
    menuTitle.setText("Akun");
    setVisible(true);
  }

  private void initsLogout() {
    idSelected = null;
    resetSidebar();
    menuLogout.setBackground(cColor.WHITE);
    menuLogout.setForeground(cColor.GREEN);
    refreshContent();
    menuLogout.setSidebarAktif();

    Object[] options = { "YA", "BATAL" };
    int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, options, options[0]);
    if (confirm == 0) {
      idCustomer = null;
      idSelected = null;
      com.main.Controller.showLoginCustomer();
    }
  }

}