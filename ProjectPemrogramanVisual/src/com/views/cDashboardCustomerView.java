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

  // component of datetime
  private cDateTime labelDateTime = new cDateTime(700, 15, 300);

  // component of data menu
  private cButton btnMenuMakanan = new cButton("Makanan", 450, 40, 150, 30, 20);
  private cButton btnMenuCoffe = new cButton("Coffe", 650, 40, 150, 30, 20);
  private cButton btnMenuNonCoffe = new cButton("Non Coffe", 840, 40, 150, 30, 20);

  // component of data menu makanan
  private cLabelInfo labelCariMenuMakanan = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariMenuMakanan = new cTextField(100, 40, 300);

  // component of data menu coffe
  private cLabelInfo labelCariMenuCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariMenuCoffe = new cTextField(100, 40, 300);

  // component of data menu non coffe
  private cLabelInfo labelCariMenuNonCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariMenuNonCoffe = new cTextField(100, 40, 300);

  // component of data Order
  private cButton btnOrderMakanan = new cButton("Makanan", 450, 40, 150, 30, 20);
  private cButton btnOrderCoffe = new cButton("Coffe", 650, 40, 150, 30, 20);
  private cButton btnOrderNonCoffe = new cButton("Non Coffe", 840, 40, 150, 30, 20);
  private cButton btnTambahOrderMakanan = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliOrderMakanan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnTambahOrderCoffe = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliOrderCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnTambahOrderNonCoffe = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliOrderNonCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of data menu makanan
  private cLabelInfo labelCariOrderMakanan = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariOrderMakanan = new cTextField(100, 40, 300);

  // component of data menu coffe
  private cLabelInfo labelCariOrderCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariOrderCoffe = new cTextField(100, 40, 300);

  // component of data menu non coffe
  private cLabelInfo labelCariOrderNonCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariOrderNonCoffe = new cTextField(100, 40, 300);

  // component of input data Order Makanan
  private cLabelInfo labelInputOrderMakanan = new cLabelInfo("Masukan Data Order Makanan!", 190, 40, 400, 40);
  private cLabelInfo labelNamaOrderMakanan = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaOrderMakanan = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaOrderMakanan = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihOrderMakanan = new cLabelInfo("Menu Makanan", 190, 180, 300, 40);
  private cComboBox pilihOrderMakanan = new cComboBox(new String[] { "Nasi Goreng", "Seblak", "Bakso Aci" }, 190,
      210, 300, 30);
  private cErrorLabel errorOrderMakanan = new cErrorLabel("Menu Makanan tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiOrderMakanan = new cLabelInfo("Deskripsi Makanan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiOrderMakanan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiOrderMakanan = new cErrorLabel(
      "Deskripsi Makanan tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaOrderMakanan = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cComboBox pilihMejaOrderMakanan = new cComboBox(new String[] { "VIP", "Reguler", "Non Reguler" }, 190,
      302, 300, 30);
  private cErrorLabel errorMejaOrderMakanan = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahOrderMakanan = new cLabelInfo("Jumlah Makanan", 580, 270, 300, 40);
  private cTextField txtJumlahOrderMakanan = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahOrderMakanan = new cErrorLabel("Jumlah Makanan tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelPromoOrderMakanan = new cLabelInfo("Pilih Order", 190, 360, 300, 40);
  private cComboBox PromoOrderMakanan = new cComboBox(new String[] { "Paket Normal", "Paket Jomok", "Paket Gomen" },
      190, 390, 300, 30);
  private cLabelInfo labelHargaOrderMakanan = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaOrderMakanan = new cTextField(580, 392, 300);
  private cButton btnHapusOrderMakanan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanOrderMakanan = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of input data Order Coffe
  private cLabelInfo labelInputOrderCoffe = new cLabelInfo("Masukan Data Order Coffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaOrderCoffe = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaOrderCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaOrderCoffe = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihOrderCoffe = new cLabelInfo("Menu Coffe", 190, 180, 300, 40);
  private cComboBox pilihOrderCoffe = new cComboBox(new String[] { "Nasi Goreng", "Seblak", "Bakso Aci" }, 190,
      210, 300, 30);
  private cErrorLabel errorOrderCoffe = new cErrorLabel("Menu Coffe tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiOrderCoffe = new cLabelInfo("Deskripsi Coffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiOrderCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiOrderCoffe = new cErrorLabel(
      "Deskripsi Coffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaOrderCoffe = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cComboBox pilihMejaOrderCoffe = new cComboBox(new String[] { "VIP", "Reguler", "Non Reguler" }, 190,
      302, 300, 30);
  private cErrorLabel errorMejaOrderCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahOrderCoffe = new cLabelInfo("Jumlah Coffe", 580, 270, 300, 40);
  private cTextField txtJumlahOrderCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahOrderCoffe = new cErrorLabel("Jumlah Coffe tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelPromoOrderCoffe = new cLabelInfo("Pilih Order", 190, 360, 300, 40);
  private cComboBox PromoOrderCoffe = new cComboBox(new String[] { "Paket Normal", "Paket Jomok", "Paket Gomen" },
      190, 390, 300, 30);
  private cLabelInfo labelHargaOrderCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaOrderCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusOrderCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanOrderCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of input data Order NonCoffe
  private cLabelInfo labelInputOrderNonCoffe = new cLabelInfo("Masukan Data Order NonCoffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaOrderNonCoffe = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaOrderNonCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaOrderNonCoffe = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihOrderNonCoffe = new cLabelInfo("Menu NonCoffe", 190, 180, 300, 40);
  private cComboBox pilihOrderNonCoffe = new cComboBox(new String[] { "Nasi Goreng", "Seblak", "Bakso Aci" }, 190,
      210, 300, 30);
  private cErrorLabel errorOrderNonCoffe = new cErrorLabel("Menu NonCoffe tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiOrderNonCoffe = new cLabelInfo("Deskripsi NonCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiOrderNonCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiOrderNonCoffe = new cErrorLabel(
      "Deskripsi NonCoffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaOrderNonCoffe = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cComboBox pilihMejaOrderNonCoffe = new cComboBox(new String[] { "VIP", "Reguler", "Non Reguler" }, 190,
      302, 300, 30);
  private cErrorLabel errorMejaOrderNonCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahOrderNonCoffe = new cLabelInfo("Jumlah NonCoffe", 580, 270, 300, 40);
  private cTextField txtJumlahOrderNonCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahOrderNonCoffe = new cErrorLabel("Jumlah NonCoffe tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelPromoOrderNonCoffe = new cLabelInfo("Pilih Order", 190, 360, 300, 40);
  private cComboBox PromoOrderNonCoffe = new cComboBox(
      new String[] { "Paket Normal", "Paket Jomok", "Paket Gomen" },
      190, 390, 300, 30);
  private cLabelInfo labelHargaOrderNonCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaOrderNonCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusOrderNonCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanOrderNonCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of data History
  private cButton btnHistoryMakanan = new cButton("Makanan", 450, 40, 150, 30, 20);
  private cButton btnHistoryCoffe = new cButton("Coffe", 650, 40, 150, 30, 20);
  private cButton btnHistoryNonCoffe = new cButton("Non Coffe", 840, 40, 150, 30, 20);

  // component of data History makanan
  private cLabelInfo labelCariHistoryMakanan = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariHistoryMakanan = new cTextField(100, 40, 300);

  // component of data History coffe
  private cLabelInfo labelCariHistoryCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariHistoryCoffe = new cTextField(100, 40, 300);

  // component of data History non coffe
  private cLabelInfo labelCariHistoryNonCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariHistoryNonCoffe = new cTextField(100, 40, 300);

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
    main.add(labelDateTime);
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
    menuTitle.setText("Menu Produk");

    btnMenuMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsMenuMakanan();
      }
    });

    btnMenuCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsMenuCoffe();
      }
    });

    btnMenuNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsMenuNonCoffe();
      }
    });

    content.add(btnMenuMakanan);
    content.add(btnMenuCoffe);
    content.add(btnMenuNonCoffe);
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

    content.add(btnMenuMakanan);
    content.add(btnMenuCoffe);
    content.add(btnMenuNonCoffe);

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

    content.add(btnMenuMakanan);
    content.add(btnMenuCoffe);
    content.add(btnMenuNonCoffe);

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
    menuTitle.setText("Data Menu Coffe");

    content.add(btnMenuMakanan);
    content.add(btnMenuCoffe);
    content.add(btnMenuNonCoffe);

    content.add(labelCariMenuNonCoffe);
    content.add(txtCariMenuNonCoffe);
    setVisible(true);
  }

  private void initsOrder() {
    idSelected = null;
    resetSidebar();
    menuOrder.setBackground(cColor.WHITE);
    menuOrder.setForeground(cColor.GREEN);
    refreshContent();
    menuOrder.setSidebarAktif();
    menuTitle.setText("Data Order Produk");

    btnOrderMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataOrderMakanan();
      }
    });

    btnOrderCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataOrderCoffe();
      }
    });

    btnOrderNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataOrderNonCoffe();
      }
    });

    content.add(btnOrderMakanan);
    content.add(btnOrderCoffe);
    content.add(btnOrderNonCoffe);

    initsDataOrderMakanan();

    setVisible(true);
  }

  private void initsDataOrderMakanan() {
    idSelected = null;
    resetSidebar();
    menuOrder.setBackground(cColor.WHITE);
    menuOrder.setForeground(cColor.GREEN);
    refreshContent();
    menuOrder.setSidebarAktif();
    menuTitle.setText("Data Order Makanan");

    btnTambahOrderMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputOrderMakanan();
      }
    });

    content.add(btnOrderMakanan);
    content.add(btnOrderCoffe);
    content.add(btnOrderNonCoffe);
    content.add(btnTambahOrderMakanan);
    content.add(labelCariOrderMakanan);
    content.add(txtCariOrderMakanan);

    setVisible(true);
  }

  private void initsDataOrderCoffe() {
    idSelected = null;
    resetSidebar();
    menuOrder.setBackground(cColor.WHITE);
    menuOrder.setForeground(cColor.GREEN);
    refreshContent();
    menuOrder.setSidebarAktif();
    menuTitle.setText("Data Order Coffe");

    btnTambahOrderCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputOrderCoffe();
      }
    });

    content.add(btnOrderMakanan);
    content.add(btnOrderCoffe);
    content.add(btnOrderNonCoffe);
    content.add(btnTambahOrderCoffe);
    content.add(labelCariOrderCoffe);
    content.add(txtCariOrderCoffe);
    setVisible(true);
  }

  private void initsDataOrderNonCoffe() {
    idSelected = null;
    resetSidebar();
    menuOrder.setBackground(cColor.WHITE);
    menuOrder.setForeground(cColor.GREEN);
    refreshContent();
    menuOrder.setSidebarAktif();
    menuTitle.setText("Data Order Non Coffe");

    btnTambahOrderNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputOrderNonCoffe();
      }
    });

    content.add(btnOrderMakanan);
    content.add(btnOrderCoffe);
    content.add(btnOrderNonCoffe);
    content.add(btnTambahOrderNonCoffe);
    content.add(labelCariOrderNonCoffe);
    content.add(txtCariOrderNonCoffe);
    setVisible(true);
  }

  private void initsInputOrderMakanan() {
    idSelected = null;
    resetSidebar();
    menuOrder.setBackground(cColor.WHITE);
    menuOrder.setForeground(cColor.GREEN);
    refreshContent();
    menuOrder.setSidebarAktif();
    menuTitle.setText("Input Order Makanan");

    txtNamaOrderMakanan.setText(null);
    txtJumlahOrderMakanan.setText(null);
    txtDeskripsiOrderMakanan.setText(null);
    pilihOrderMakanan.setSelectedItem("Nasi Goreng");
    pilihMejaOrderMakanan.setSelectedItem("VIP");
    PromoOrderMakanan.setSelectedItem("Paket Normal");
    txtHargaOrderMakanan.setText(null);

    btnHapusOrderMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaOrderMakanan.setText(null);
        txtJumlahOrderMakanan.setText(null);
        txtDeskripsiOrderMakanan.setText(null);
        pilihOrderMakanan.setSelectedItem("Pilih Makanan");
        pilihMejaOrderMakanan.setSelectedItem("Pilih Meja");
        PromoOrderMakanan.setSelectedItem("Pilih Order");
        txtHargaOrderMakanan.setText(null);
      }
    });

    btnKembaliOrderMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataOrderMakanan();
      }
    });

    content.add(labelInputOrderMakanan);
    content.add(labelNamaOrderMakanan);
    content.add(txtNamaOrderMakanan);
    content.add(errorNamaOrderMakanan);
    content.add(labelJumlahOrderMakanan);
    content.add(txtJumlahOrderMakanan);
    content.add(errorJumlahOrderMakanan);
    content.add(labelMejaOrderMakanan);
    content.add(pilihMejaOrderMakanan);
    content.add(errorMejaOrderMakanan);
    content.add(labelDeskripsiOrderMakanan);
    content.add(txtDeskripsiOrderMakanan);
    content.add(errorDeskripsiOrderMakanan);
    content.add(labelPilihOrderMakanan);
    content.add(pilihOrderMakanan);
    content.add(errorOrderMakanan);
    content.add(labelPromoOrderMakanan);
    content.add(PromoOrderMakanan);
    content.add(labelHargaOrderMakanan);
    content.add(txtHargaOrderMakanan);
    content.add(btnSimpanOrderMakanan);
    content.add(btnHapusOrderMakanan);
    content.add(btnKembaliOrderMakanan);
    setVisible(true);
  }

  private void initsInputOrderCoffe() {
    idSelected = null;
    resetSidebar();
    menuOrder.setBackground(cColor.WHITE);
    menuOrder.setForeground(cColor.GREEN);
    refreshContent();
    menuOrder.setSidebarAktif();
    menuTitle.setText("Input Order Coffe");

    txtNamaOrderCoffe.setText(null);
    txtJumlahOrderCoffe.setText(null);
    txtDeskripsiOrderCoffe.setText(null);
    pilihOrderCoffe.setSelectedItem("Nasi Goreng");
    pilihMejaOrderCoffe.setSelectedItem("VIP");
    PromoOrderCoffe.setSelectedItem("Paket Normal");
    txtHargaOrderCoffe.setText(null);

    btnHapusOrderCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaOrderCoffe.setText(null);
        txtJumlahOrderCoffe.setText(null);
        txtDeskripsiOrderCoffe.setText(null);
        pilihOrderCoffe.setSelectedItem("Pilih Coffe");
        pilihMejaOrderCoffe.setSelectedItem("Pilih Meja");
        PromoOrderCoffe.setSelectedItem("Pilih Order");
        txtHargaOrderCoffe.setText(null);
      }
    });

    btnKembaliOrderCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataOrderCoffe();
      }
    });

    content.add(labelInputOrderCoffe);
    content.add(labelNamaOrderCoffe);
    content.add(txtNamaOrderCoffe);
    content.add(errorNamaOrderCoffe);
    content.add(labelJumlahOrderCoffe);
    content.add(txtJumlahOrderCoffe);
    content.add(errorJumlahOrderCoffe);
    content.add(labelMejaOrderCoffe);
    content.add(pilihMejaOrderCoffe);
    content.add(errorMejaOrderCoffe);
    content.add(labelDeskripsiOrderCoffe);
    content.add(txtDeskripsiOrderCoffe);
    content.add(errorDeskripsiOrderCoffe);
    content.add(labelPilihOrderCoffe);
    content.add(pilihOrderCoffe);
    content.add(errorOrderCoffe);
    content.add(labelPromoOrderCoffe);
    content.add(PromoOrderCoffe);
    content.add(labelHargaOrderCoffe);
    content.add(txtHargaOrderCoffe);
    content.add(btnSimpanOrderCoffe);
    content.add(btnHapusOrderCoffe);
    content.add(btnKembaliOrderCoffe);

    setVisible(true);
  }

  private void initsInputOrderNonCoffe() {
    idSelected = null;
    resetSidebar();
    menuOrder.setBackground(cColor.WHITE);
    menuOrder.setForeground(cColor.GREEN);
    refreshContent();
    menuOrder.setSidebarAktif();
    menuTitle.setText("Input Order Non Coffe");

    txtNamaOrderNonCoffe.setText(null);
    txtJumlahOrderNonCoffe.setText(null);
    txtDeskripsiOrderNonCoffe.setText(null);
    pilihOrderNonCoffe.setSelectedItem("Nasi Goreng");
    pilihMejaOrderNonCoffe.setSelectedItem("VIP");
    PromoOrderNonCoffe.setSelectedItem("Paket Normal");
    txtHargaOrderNonCoffe.setText(null);

    btnHapusOrderNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaOrderNonCoffe.setText(null);
        txtJumlahOrderNonCoffe.setText(null);
        txtDeskripsiOrderNonCoffe.setText(null);
        pilihOrderNonCoffe.setSelectedItem("Pilih NonCoffe");
        pilihMejaOrderNonCoffe.setSelectedItem("Pilih Meja");
        PromoOrderNonCoffe.setSelectedItem("Pilih Order");
        txtHargaOrderNonCoffe.setText(null);
      }
    });

    btnKembaliOrderNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataOrderNonCoffe();
      }
    });

    content.add(labelInputOrderNonCoffe);
    content.add(labelNamaOrderNonCoffe);
    content.add(txtNamaOrderNonCoffe);
    content.add(errorNamaOrderNonCoffe);
    content.add(labelJumlahOrderNonCoffe);
    content.add(txtJumlahOrderNonCoffe);
    content.add(errorJumlahOrderNonCoffe);
    content.add(labelMejaOrderNonCoffe);
    content.add(pilihMejaOrderNonCoffe);
    content.add(errorMejaOrderNonCoffe);
    content.add(labelDeskripsiOrderNonCoffe);
    content.add(txtDeskripsiOrderNonCoffe);
    content.add(errorDeskripsiOrderNonCoffe);
    content.add(labelPilihOrderNonCoffe);
    content.add(pilihOrderNonCoffe);
    content.add(errorOrderNonCoffe);
    content.add(labelPromoOrderNonCoffe);
    content.add(PromoOrderNonCoffe);
    content.add(labelHargaOrderNonCoffe);
    content.add(txtHargaOrderNonCoffe);
    content.add(btnSimpanOrderNonCoffe);
    content.add(btnHapusOrderNonCoffe);
    content.add(btnKembaliOrderNonCoffe);
    setVisible(true);
  }

  private void initsHistory() {
    idSelected = null;
    resetSidebar();
    menuHistory.setBackground(cColor.WHITE);
    menuHistory.setForeground(cColor.GREEN);
    refreshContent();
    menuHistory.setSidebarAktif();
    menuTitle.setText("History Pemesanan");

    btnHistoryMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsHistoryMakanan();
      }
    });

    btnHistoryCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsHistoryCoffe();
      }
    });

    btnHistoryNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsHistoryNonCoffe();
      }
    });

    content.add(btnHistoryMakanan);
    content.add(btnHistoryCoffe);
    content.add(btnHistoryNonCoffe);

    initsHistoryMakanan();

    setVisible(true);
  }

  private void initsHistoryMakanan() {
    idSelected = null;
    resetSidebar();
    menuHistory.setBackground(cColor.WHITE);
    menuHistory.setForeground(cColor.GREEN);
    refreshContent();
    menuHistory.setSidebarAktif();
    menuTitle.setText("Data History Makanan");

    content.add(btnHistoryMakanan);
    content.add(btnHistoryCoffe);
    content.add(btnHistoryNonCoffe);

    content.add(labelCariHistoryMakanan);
    content.add(txtCariHistoryMakanan);
    setVisible(true);
  }

  private void initsHistoryCoffe() {
    idSelected = null;
    resetSidebar();
    menuHistory.setBackground(cColor.WHITE);
    menuHistory.setForeground(cColor.GREEN);
    refreshContent();
    menuHistory.setSidebarAktif();
    menuTitle.setText("Data History Coffe");

    content.add(btnHistoryMakanan);
    content.add(btnHistoryCoffe);
    content.add(btnHistoryNonCoffe);

    content.add(labelCariHistoryCoffe);
    content.add(txtCariHistoryCoffe);
    setVisible(true);
  }

  private void initsHistoryNonCoffe() {
    idSelected = null;
    resetSidebar();
    menuHistory.setBackground(cColor.WHITE);
    menuHistory.setForeground(cColor.GREEN);
    refreshContent();
    menuHistory.setSidebarAktif();
    menuTitle.setText("Data History Coffe");

    content.add(btnHistoryMakanan);
    content.add(btnHistoryCoffe);
    content.add(btnHistoryNonCoffe);

    content.add(labelCariHistoryNonCoffe);
    content.add(txtCariHistoryNonCoffe);
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

    content.add(errorNamaDataAkun);
    content.add(errorNomorHpDataAkun);
    content.add(errorEmailDataAkun);
    content.add(errorPasswordDataAkun);
    content.add(errorAlamatDataAkun);

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