package com.views;

import com.templates.cDashboardApp;
import com.main.Model;
import com.partials.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class cDashboardCustomerView extends cDashboardApp {

  Integer idCustomer = null;
  Integer idSelected = null;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuDataMenu = new cSidebarMenu("Menu Produk", 70 + 50);
  private cSidebarMenu menuDataPromo = new cSidebarMenu("Data Promo", 70 + 50 + 50);
  private cSidebarMenu menuDataMeja = new cSidebarMenu("Data Promo", 70 + 50 + 50 + 50);
  private cSidebarMenu menuTransaksi = new cSidebarMenu("Transaksi Produk", 70 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuHistory = new cSidebarMenu("History Produk", 70 + 50 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuAkun = new cSidebarMenu("Akun", 70 + 50 + 50 + 50 + 50 + 50 + 50);

  // component of datetime
  private cDateTime labelDateTime = new cDateTime(700, 15, 300);
  private cLabelInfo labelJumlahMenuBeranda = new cLabelInfo("Jumlah Data Menu", 420, 40, 400, 40);
  private cBigFont valueJumlahMenuBeranda = new cBigFont("0", 420, 60);
  private cLabelInfo labelJumlahMejaBeranda = new cLabelInfo("Jumlah Data Meja", 40, 180, 400, 40);
  private cBigFont valueJumlahMejaBeranda = new cBigFont("0", 40, 205);
  private cLabelInfo labelJumlahPromoBeranda = new cLabelInfo("Jumlah Data Promo", 420, 180, 400, 40);
  private cBigFont valueJumlahPromoBeranda = new cBigFont("0", 420, 205);
  private cLabelInfo labelTransaksiBeranda = new cLabelInfo("Jumlah Data Transaksi ", 40, 280, 400, 40);
  private cBigFont valueTransaksiBeranda = new cBigFont("0", 40, 305);

  // component of data menu
  private cComboBox pilihDataMenu = new cComboBox(
      new String[] { "Data Makanan", "Data Coffe", "Data Non Coffe" }, 100, 40, 200,
      30);

  // component of data menu makanan
  private cLabelInfo labelCariMenuMakanan = new cLabelInfo("Cari", 40, 90, 300, 40);
  private cTextField txtCariMenuMakanan = new cTextField(100, 90, 300);
  private cTable tblMenuMakanan;
  private cScrollPane spMenuMakanan;
  private cButton btnTambahMakanan = new cButton("Order", 440, 90, 150, 30, 20);

  // component of data menu coffe
  private cLabelInfo labelCariMenuCoffe = new cLabelInfo("Cari", 40, 90, 300, 40);
  private cTextField txtCariMenuCoffe = new cTextField(100, 90, 300);
  private cTable tblMenuCoffe;
  private cScrollPane spMenuCoffe;
  private cButton btnTambahCoffe = new cButton("Order", 440, 90, 150, 30, 20);

  // component of data menu non coffe
  private cLabelInfo labelCariMenuNonCoffe = new cLabelInfo("Cari", 40, 90, 300, 40);
  private cTextField txtCariMenuNonCoffe = new cTextField(100, 90, 300);
  private cTable tblMenuNonCoffe;
  private cScrollPane spMenuNonCoffe;
  private cButton btnTambahNonCoffe = new cButton("Order", 440, 90, 150, 30, 20);

  // component of data menu
  private cComboBox pilihTransaksiMenu = new cComboBox(
      new String[] { "Makanan", "Coffe", "Non Coffe" }, 100, 40, 200,
      30);

  // component of data Promo
  private cLabelInfo labelPromo = new cLabelInfo("Data Promo Menu", 40, 40, 300, 40);
  private cLabelInfo labelCariPromo = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariPromo = new cTextField(100, 100, 300);
  private cTable tblDataPromo;
  private cScrollPane spDataPromo;

  // component of data meja
  private cLabelInfo labelMeja = new cLabelInfo("Data Ready Meja", 40, 40, 300, 40);
  private cLabelInfo labelCariMeja = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariMeja = new cTextField(100, 100, 300);
  private cTable tblDataMeja;
  private cScrollPane spDataMeja;

  // component of input data akun
  private cLabelInfo labelInfoDataAkun = new cLabelInfo("Masukan Data Untuk Mengubah Data Akun!", 190, 30, 600, 40);
  private cLabelInfo labelNamaDataAkun = new cLabelInfo("Nama", 190, 80, 400, 40);
  private cLabelInfo labelEmailDataAkun = new cLabelInfo("Email", 190, 180, 400, 40);
  private cLabelInfo labelNomorHpDataAkun = new cLabelInfo("No Hp", 190, 290, 400, 40);
  private cLabelInfo labelPasswordDataAkun = new cLabelInfo("Password", 580, 80, 300, 40);
  private cLabelInfo labelAlamatDataAkun = new cLabelInfo("Alamat", 580, 180, 300, 40);

  private cErrorLabel errorNamaDataAkun = new cErrorLabel("Nama tidak boleh Kosong!", 190, 140, 300);
  private cErrorLabel errorEmailDataAkun = new cErrorLabel("Email tidak boleh Kosong!", 190, 240, 300);
  private cErrorLabel errorPasswordDataAkun = new cErrorLabel("Password tidak boleh Kosong!", 580, 140, 300);
  private cErrorLabel errorAlamatDataAkun = new cErrorLabel("Alamat tidak boleh Kosong!", 580, 310, 300);
  private cErrorLabel errorNomorHpDataAkun = new cErrorLabel("Nomor Hp tidak boleh Kosong!", 190, 350, 300);

  private cTextField txtNamaDataAkun = new cTextField(190, 115, 300);
  private cTextField txtEmailDataAkun = new cTextField(190, 215, 300);
  private cTextField txtNomorHpDataAkun = new cTextField(190, 325, 300);
  private cPasswordField txtPasswordDataAkun = new cPasswordField(580, 115, 300);
  private cTextarea txtAlamatDataAkun = new cTextarea(580, 215, 300, 100, true);
  private cButton btnHapusDataAkun = new cButton("Hapus", 560, 430, 150, 30, 20);
  private cButton btnSimpanDataAkun = new cButton("Simpan", 730, 430, 150, 30, 20);

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

      menuTransaksi.setForeground(cColor.WHITE);
      menuTransaksi.setBackground(cColor.GREEN);
      menuTransaksi.setSidebarNonAktif();

      menuHistory.setForeground(cColor.WHITE);
      menuHistory.setBackground(cColor.GREEN);
      menuHistory.setSidebarNonAktif();

      menuAkun.setForeground(cColor.WHITE);
      menuAkun.setBackground(cColor.GREEN);
      menuAkun.setSidebarNonAktif();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // method refresh content
  private void refreshContent() {
    try {
      roleText.setText("Customer | " + Model.getDetailCustomer(idCustomer)[1].toString());
      content.removeAll();

    } catch (Exception e) {
    }
  }

  public cDashboardCustomerView(Integer id) {
    super("Dashboard Customer");
    idCustomer = id;

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

    menuTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsTransaksi();
      }
    });

    menuHistory.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
      }
    });

    menuAkun.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsAkun();
      }
    });

    // add component default
    main.add(labelDateTime);
    sidebar.add(menuBeranda);
    sidebar.add(menuDataMenu);
    sidebar.add(menuDataPromo);
    sidebar.add(menuDataMeja);
    sidebar.add(menuTransaksi);
    sidebar.add(menuHistory);
    sidebar.add(menuAkun);
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

    valueJumlahMejaBeranda.setText(String.valueOf(Model.getCountAllDataMeja()));

    valueJumlahMenuBeranda.setText(String.valueOf(Model.getCountAllDataMenu()));

    valueJumlahPromoBeranda.setText(String.valueOf(Model.getCountAllDataPromo()));

    content.add(labelJumlahMenuBeranda);
    content.add(valueJumlahMenuBeranda);
    content.add(labelJumlahMejaBeranda);
    content.add(valueJumlahMejaBeranda);
    content.add(labelJumlahPromoBeranda);
    content.add(valueJumlahPromoBeranda);

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

    content.add(pilihDataMenu);

    pilihDataMenu.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedItem = (String) pilihDataMenu.getSelectedItem();
        if (selectedItem.equals("Data Makanan")) {
          initsMenuMakanan();
        } else if (selectedItem.equals("Data Coffe")) {
          initsMenuCoffe();
        } else if (selectedItem.equals("Data Non Coffe")) {
          initsMenuNonCoffe();
        }
      }
    });

    initsMenuMakanan();

    setVisible(true);
  }

  private void initsMenuMakanan() {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Data Menu Makanan");

    content.add(pilihDataMenu);

    btnTambahMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        
      }
    });

    tblMenuMakanan = new cTable(Model.getAllMenuMakanan());

    tblMenuMakanan.getColumnModel().getColumn(0).setMinWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(0).setMaxWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(0).setWidth(0);

    tblMenuMakanan.getColumnModel().getColumn(1).setMinWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(1).setMaxWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(1).setWidth(0);

    tblMenuMakanan.getColumnModel().getColumn(2).setMinWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(2).setMaxWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(2).setWidth(0);

    tblMenuMakanan.getColumnModel().getColumn(7).setMinWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(7).setMaxWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(7).setWidth(0);

    spMenuMakanan = new cScrollPane(tblMenuMakanan, 0, 140, 1100, 300);

    content.add(spMenuMakanan);
    content.add(btnTambahMakanan);
    content.add(labelCariMenuMakanan);
    content.add(txtCariMenuMakanan);
    setVisible(true);
  }

  private void initsMenuCoffe() {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Data Menu Coffe");

    content.add(pilihDataMenu);

    btnTambahCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        
      }
    });

    tblMenuCoffe = new cTable(Model.getAllMenuCoffe());

    tblMenuCoffe.getColumnModel().getColumn(0).setMinWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(0).setMaxWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(0).setWidth(0);

    tblMenuCoffe.getColumnModel().getColumn(1).setMinWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(1).setWidth(0);

    tblMenuCoffe.getColumnModel().getColumn(2).setMinWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(2).setWidth(0);

    tblMenuCoffe.getColumnModel().getColumn(7).setMinWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(7).setWidth(0);

    spMenuCoffe = new cScrollPane(tblMenuCoffe, 0, 140, 1100, 300);

    content.add(spMenuCoffe);
    content.add(btnTambahCoffe);
    content.add(labelCariMenuCoffe);
    content.add(txtCariMenuCoffe);
    setVisible(true);
  }

  private void initsMenuNonCoffe() {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Data Menu Non Coffe");

    content.add(pilihDataMenu);

    btnTambahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        
      }
    });

    tblMenuNonCoffe = new cTable(Model.getAllMenuNonCoffe());

    tblMenuNonCoffe.getColumnModel().getColumn(0).setMinWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(0).setMaxWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(0).setWidth(0);

    tblMenuNonCoffe.getColumnModel().getColumn(1).setMinWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(1).setWidth(0);

    tblMenuNonCoffe.getColumnModel().getColumn(2).setMinWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(2).setWidth(0);

    tblMenuNonCoffe.getColumnModel().getColumn(7).setMinWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(7).setWidth(0);

    spMenuNonCoffe = new cScrollPane(tblMenuNonCoffe, 0, 140, 1100, 300);

    content.add(spMenuNonCoffe);
    content.add(btnTambahNonCoffe);
    content.add(labelCariMenuNonCoffe);
    content.add(txtCariMenuNonCoffe);
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

    content.add(pilihTransaksiMenu);

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

    txtCariPromo.setText(null);

    txtCariPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariPromo.getText();

        tblDataPromo.setModel(Model.getCariPromo(keyword));

        tblDataPromo.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataPromo.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataPromo.getColumnModel().getColumn(0).setWidth(0);

        tblDataPromo.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataPromo.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataPromo.getColumnModel().getColumn(1).setWidth(0);

        tblDataPromo.getColumnModel().getColumn(2).setMinWidth(0);
        tblDataPromo.getColumnModel().getColumn(2).setMaxWidth(0);
        tblDataPromo.getColumnModel().getColumn(2).setWidth(0);

        tblDataPromo.getColumnModel().getColumn(8).setMinWidth(0);
        tblDataPromo.getColumnModel().getColumn(8).setMaxWidth(0);
        tblDataPromo.getColumnModel().getColumn(8).setWidth(0);
      }
    });

    tblDataPromo = new cTable(Model.getAllPromo());

    tblDataPromo.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(0).setWidth(0);

    tblDataPromo.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(1).setWidth(0);

    tblDataPromo.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(2).setWidth(0);

    tblDataPromo.getColumnModel().getColumn(8).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(8).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(8).setWidth(0);

    spDataPromo = new cScrollPane(tblDataPromo, 0, 140, 1100, 300);

    content.add(spDataPromo);

    content.add(labelPromo);
    content.add(labelCariPromo);
    content.add(txtCariPromo);

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

    txtCariMeja.setText(null);

    txtCariMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariMeja.getText();

        tblDataMeja.setModel(Model.getCariMeja(keyword));

        tblDataMeja.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataMeja.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataMeja.getColumnModel().getColumn(0).setWidth(0);

        tblDataMeja.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataMeja.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataMeja.getColumnModel().getColumn(1).setWidth(0);

      }
    });

    tblDataMeja = new cTable(Model.getAllMeja());

    tblDataMeja.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(0).setWidth(0);

    tblDataMeja.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(1).setWidth(0);

    spDataMeja = new cScrollPane(tblDataMeja, 0, 140, 1100, 300);

    content.add(spDataMeja);

    content.add(labelMeja);
    content.add(labelCariMeja);
    content.add(txtCariMeja);

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

    Object[] dataCustomer = Model.getDetailCustomer(idCustomer);

    txtNamaDataAkun.setText(dataCustomer[1].toString());
    txtEmailDataAkun.setText(dataCustomer[3].toString());
    txtNomorHpDataAkun.setText(dataCustomer[2].toString());
    txtAlamatDataAkun.setText(dataCustomer[4].toString());
    txtPasswordDataAkun.setText(dataCustomer[5].toString());

    btnSimpanDataAkun.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        // error tidak boleh kosong
        if (txtNamaDataAkun.getText().trim().isEmpty()
            || txtNomorHpDataAkun.getText().trim().isEmpty()
            || txtEmailDataAkun.getText().trim().isEmpty()
                && !dataCustomer[3].toString().equalsIgnoreCase(txtEmailDataAkun.getText())
                && Model.getCountCustomerByEmail(txtEmailDataAkun.getText()) == 1
            || txtAlamatDataAkun.getText().trim().isEmpty()
            || new String(txtPasswordDataAkun.getPassword()).trim().isEmpty()) {
          cDashboardCustomerView.this.setVisible(false);
          // spesifik error
          if (txtNamaDataAkun.getText().trim().isEmpty()) {
            content.add(errorNamaDataAkun);
          } else {
            content.remove(errorNamaDataAkun);
          }
          if (txtNomorHpDataAkun.getText().trim().isEmpty()) {
            content.add(errorNomorHpDataAkun);
          } else {
            content.remove(errorNomorHpDataAkun);
          }
          if (txtEmailDataAkun.getText().trim().isEmpty()) {
            content.add(errorEmailDataAkun);
          } else {
            content.remove(errorEmailDataAkun);
          }
          if (txtAlamatDataAkun.getText().trim().isEmpty()) {
            content.add(errorAlamatDataAkun);
          } else {
            content.remove(errorAlamatDataAkun);
          }
          if (new String(txtPasswordDataAkun.getPassword()).trim().isEmpty()) {
            content.add(errorPasswordDataAkun);
          } else {
            content.remove(errorPasswordDataAkun);
          }
          cDashboardCustomerView.this.setVisible(true);
        } else {
          String namaCustomer = txtNamaDataAkun.getText();
          String nomorHpCustomer = txtNomorHpDataAkun.getText();
          String emailCustomer = txtEmailDataAkun.getText();
          String alamatCustomer = txtAlamatDataAkun.getText();
          String passwordCustomer = new String(txtPasswordDataAkun.getPassword());

          if (Model.ubahProfileCustomer(idCustomer, namaCustomer, nomorHpCustomer, emailCustomer, passwordCustomer,
              alamatCustomer)) {
            // kalau berhasil ubah profil
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Ubah Profil berhasil", "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
            initsAkun();
          } else {
            // kalau gagal ubah profil
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Ubah profil gagal!", "Gagal",
                JOptionPane.WARNING_MESSAGE);
          }
        }
      }
    });

    content.add(labelInfoDataAkun);
    content.add(labelNamaDataAkun);
    content.add(labelEmailDataAkun);
    content.add(labelNomorHpDataAkun);
    content.add(labelPasswordDataAkun);
    content.add(labelAlamatDataAkun);
    content.add(txtNamaDataAkun);
    content.add(txtEmailDataAkun);
    content.add(txtNomorHpDataAkun);
    content.add(txtPasswordDataAkun);
    content.add(txtAlamatDataAkun);
    content.add(btnSimpanDataAkun);
    content.add(btnHapusDataAkun);

    setVisible(true);
  }

}