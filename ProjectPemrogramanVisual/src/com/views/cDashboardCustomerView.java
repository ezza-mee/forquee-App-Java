package com.views;

import com.templates.cDashboardApp;
import com.main.Model;
import com.partials.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class cDashboardCustomerView extends cDashboardApp {

  Integer idCustomer = null;
  Integer idSelected = null;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuDataMenu = new cSidebarMenu("Menu Produk", 70 + 50);
  private cSidebarMenu menuDataPromo = new cSidebarMenu("Data Promo", 70 + 50 + 50);
  private cSidebarMenu menuDataMeja = new cSidebarMenu("Data Meja", 70 + 50 + 50 + 50);
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
  private cLabelInfo labelPilihMenu = new cLabelInfo("Pilih Menu", 40, 20, 200, 40);
  private cComboBox pilihDataMenu = new cComboBox(new String[] { "Menu Makanan", "Menu Coffe", "Menu Non Coffe" }, 160,
      25, 200, 30);

  // component of data menu makanan
  private cPanelRounded panelHeaderMenuMakanan = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelDeskripsiMenuMakanan = new cPanelRounded(600, 150, 500, 410, 15);
  private cTextField txtCariMenuMakanan = new cTextField(40, 85, 300);
  private cLabelInfo labelHargaMenuMakanan = new cLabelInfo("Harga Makanan", 660, 160, 300, 40);
  private cBigFont labelRpMenuMakanan = new cBigFont("Rp.", 660, 180);
  private cBigFont valueHargaMenuMakanan = new cBigFont("0", 730, 180);
  private cTextarea valueDeskripsiMenuMakanan = new cTextarea(660, 260, 380, 220, false);
  private cTable tblMenuMakanan;
  private cScrollPane spMenuMakanan;
  private cButton btnTambahMakanan = new cButton("Order", 400, 95, 150, 30, 15);

  // component of data menu coffe
  private cPanelRounded panelHeaderMenuCoffe = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelDeskripsiMenuCoffe = new cPanelRounded(600, 150, 500, 410, 15);
  private cLabelInfo labelHargaMenuCoffe = new cLabelInfo("Harga Coffe", 660, 160, 300, 40);
  private cBigFont labelRpMenuCoffe = new cBigFont("Rp.", 660, 180);
  private cBigFont valueHargaMenuCoffe = new cBigFont("0", 730, 180);
  private cTextarea valueDeskripsiMenuCoffe = new cTextarea(660, 260, 380, 220, false);
  private cTextField txtCariMenuCoffe = new cTextField(40, 85, 300);
  private cTable tblMenuCoffe;
  private cScrollPane spMenuCoffe;
  private cButton btnTambahCoffe = new cButton("Order", 400, 95, 150, 30, 20);

  // component of data menu non coffe
  private cPanelRounded panelHeaderMenuNonCoffe = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelDeskripsiMenuNonCoffe = new cPanelRounded(600, 150, 500, 410, 15);
  private cLabelInfo labelHargaMenuNonCoffe = new cLabelInfo("Harga Non Coffe", 660, 160, 300, 40);
  private cBigFont labelRpMenuNonCoffe = new cBigFont("Rp.", 660, 180);
  private cBigFont valueHargaMenuNonCoffe = new cBigFont("0", 730, 180);
  private cTextarea valueDeskripsiMenuNonCoffe = new cTextarea(660, 260, 380, 220, false);
  private cTextField txtCariMenuNonCoffe = new cTextField(40, 85, 300);
  private cTable tblMenuNonCoffe;
  private cScrollPane spMenuNonCoffe;
  private cButton btnTambahNonCoffe = new cButton("Order", 440, 90, 150, 30, 20);

  // component of data Promo
  private cPanelRounded panelHeaderPromo = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelDeskripsiPromo = new cPanelRounded(600, 150, 500, 410, 15);
  private cLabelInfo valueDataPromo = new cLabelInfo("Promo", 660, 160, 300, 40);
  private cBigFont labelRpDataPromo = new cBigFont("Rp.", 660, 180);
  private cBigFont valueHargaPromo = new cBigFont("0", 730, 180);
  private cTextarea valueDeskripsiPromo = new cTextarea(660, 260, 380, 220, false);
  private cLabelInfo labelPromo = new cLabelInfo("Data Promo Forque", 40, 20, 300, 40);
  private cTextField txtCariPromo = new cTextField(40, 85, 300);
  private cButton btnTambahPromo = new cButton("Order", 400, 100, 150, 30, 20);
  private cTable tblDataPromo;
  private cScrollPane spDataPromo;

  // component of data meja
  private cPanelRounded panelHeaderMeja = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelDeskripsiMeja = new cPanelRounded(600, 150, 500, 410, 15);
  private cLabelInfo labelJenisDataMeja = new cLabelInfo("Jenis Meja", 660, 160, 300, 40);
  private cBigFont valueJenisDataMeja = new cBigFont("", 660, 180);
  private cTextarea valueDeskripsiMeja = new cTextarea(660, 260, 380, 220, false);
  private cLabelInfo labelMeja = new cLabelInfo("Data Meja Forque", 40, 20, 300, 40);
  private cTextField txtCariMeja = new cTextField(40, 85, 300);
  private cButton btnTambahMeja = new cButton("Order", 400, 95, 150, 30, 20);
  private cTable tblDataMeja;
  private cScrollPane spDataMeja;

  // component of data transaksi
  private cPanelRounded panelHeaderTransaksi = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelPilihTransaksi = new cLabelInfo("Pilih Data", 40, 20, 200, 40);
  private cTextField txtCariTransaksi = new cTextField(40, 85, 300);
  private cButton btnTambahTransaksi = new cButton("Tambah", 400, 95, 150, 30, 20);
  private cButton btnEditTransaksi = new cButton("Edit", 600, 95, 150, 30, 20);
  private cButton btnHapusTransaksi = new cButton("Hapus", 800, 95, 150, 30, 20);
  private cButton btnDetailTransaksi = new cButton("Detail", 800, 500, 150, 30, 20);
  private cTable tblDataTransaksi;
  private cScrollPane spDataTransaksi;

  // component of input data Transaksi
  private cComboBox pilihMakananTransaksi;
  private cComboBox pilihCoffeTransaksi;
  private cComboBox pilihNonCoffeTransaksi;
  private cComboBox pilihMejaTransaksi;
  private cComboBox pilihPromoTransaksi;
  private cComboBox pilihMitraTransaksi;
  private cLabelInfo labelMitraTransaksi = new cLabelInfo("Mitra", 80, 175, 300, 40);
  private cErrorLabel errorMitraTransaksi = new cErrorLabel("Mitra tidak boleh Kosong!", 80, 230, 400);
  private cPanelRounded panelInputTransaksi = new cPanelRounded(0, 0, 1100, 70, 15);
  private cLabelInfo labelInputTransaksi = new cLabelInfo("Masukan Data Transaksi !", 80, 15, 400, 40);
  private cLabelInfo labelMejaTransaksi = new cLabelInfo("Nomor Meja", 80, 80, 300, 40);
  private cErrorLabel errorMejaTransaksi = new cErrorLabel("Nomor Meja tidak boleh Kosong!", 80, 135, 300);
  private cLabelInfo labelDeskripsiTransaksi = new cLabelInfo("Deskripsi ", 80, 265, 300, 40);
  private cTextarea txtDeskripsiTransaksi = new cTextarea(80, 295, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksi = new cErrorLabel(
      "Deskripsi  tidak boleh Kosong!", 80, 410,
      300);
  private cLabelInfo labelMakananTransaksi = new cLabelInfo("Menu Makanan", 440, 80, 300, 40);
  private cLabelInfo labelCoffeTransaksi = new cLabelInfo("Menu Coffe", 440, 175, 300, 40);
  private cLabelInfo labelNonCoffeTransaksi = new cLabelInfo("Menu Non Coffe", 440, 275, 300, 40);
  private cLabelInfo labelJumlahMakananTransaksi = new cLabelInfo("Jumlah", 680, 80, 100, 40);
  private cLabelInfo labelJumlahCoffeTransaksi = new cLabelInfo("Jumlah", 680, 175, 100, 40);
  private cLabelInfo labelJumlahNonCoffeTransaksi = new cLabelInfo("Jumlah", 680, 275, 100, 40);
  private cLabelInfo labelHargaMakananTransaksi = new cLabelInfo("Harga", 810, 80, 100, 40);
  private cLabelInfo labelHargaCoffeTransaksi = new cLabelInfo("Harga", 810, 175, 100, 40);
  private cLabelInfo labelHargaNonCoffeTransaksi = new cLabelInfo("Harga", 810, 275, 100, 40);
  private cTextField txtJumlahMakananTransaksi = new cTextField(680, 110, 80);
  private cTextField txtJumlahCoffeTransaksi = new cTextField(680, 210, 80);
  private cTextField txtJumlahNonCoffeTransaksi = new cTextField(680, 310, 80);
  private cTextarea txtHargaMakananTransaksi = new cTextarea(810, 110, 180, 30, false);
  private cTextarea txtHargaCoffeTransaksi = new cTextarea(810, 210, 180, 30, false);
  private cTextarea txtHargaNonCoffeTransaksi = new cTextarea(810, 310, 180, 30, false);
  private cLabelInfo labelHargaTotalTransaksi = new cLabelInfo("Harga Total", 680, 380, 300, 40);
  private cTextarea txtHargaTotalTransaksi = new cTextarea(810, 380, 180, 30, false);
  private cLabelInfo labelPromoTransaksi = new cLabelInfo("Promo", 440, 360, 300, 40);
  private cComboBox pilihPembayaranTransaksi = new cComboBox(
      new String[] { "Pembayaran", "CASH", "OVO", "GOPAY", "BCA", "MANDIRI", "DANA" }, 440, 450, 200, 30);
  private cErrorLabel errorPromoTransaksi = new cErrorLabel("Promo tidak boleh Kosong!", 440, 415, 300);
  private cButton btnHapusInputTransaksi = new cButton("Hapus", 700, 500, 150, 30, 20);
  private cButton btnSimpanTransaksi = new cButton("Checkout", 880, 500, 150, 30, 20);
  private cButton btnKembaliTransaksi = new cButton("Kembali", 80, 500, 150, 30, 20);

  // component of Ubah data Transaksi
  private cComboBox pilihMakananUbahTransaksi;
  private cComboBox pilihCoffeUbahTransaksi;
  private cComboBox pilihNonCoffeUbahTransaksi;
  private cComboBox pilihMejaUbahTransaksi;
  private cComboBox pilihPromoUbahTransaksi;
  private cComboBox pilihMitraUbahTransaksi;
  private cLabelInfo labelMitraUbahTransaksi = new cLabelInfo("Mitra", 80, 175, 300, 40);
  private cErrorLabel errorMitraUbahTransaksi = new cErrorLabel("Mitra tidak boleh Kosong!", 80, 230, 400);
  private cPanelRounded panelUbahTransaksi = new cPanelRounded(0, 0, 1100, 70, 15);
  private cLabelInfo labelInputUbahTransaksi = new cLabelInfo("Masukan Data Untuk Ubah Transaksi !", 80, 15, 400, 40);
  private cLabelInfo labelMejaUbahTransaksi = new cLabelInfo("Nomor Meja", 80, 80, 300, 40);
  private cErrorLabel errorMejaUbahTransaksi = new cErrorLabel("Nomor Meja tidak boleh Kosong!", 80, 135, 300);
  private cLabelInfo labelDeskripsiUbahTransaksi = new cLabelInfo("Deskripsi ", 80, 265, 300, 40);
  private cTextarea txtDeskripsiUbahTransaksi = new cTextarea(80, 295, 300, 120, true);
  private cErrorLabel errorDeskripsiUbahTransaksi = new cErrorLabel(
      "Deskripsi  tidak boleh Kosong!", 80, 410,
      300);
  private cLabelInfo labelMakananUbahTransaksi = new cLabelInfo("Menu Makanan", 440, 80, 300, 40);
  private cLabelInfo labelCoffeUbahTransaksi = new cLabelInfo("Menu Coffe", 440, 175, 300, 40);
  private cLabelInfo labelNonCoffeUbahTransaksi = new cLabelInfo("Menu Non Coffe", 440, 275, 300, 40);
  private cLabelInfo labelJumlahMakananUbahTransaksi = new cLabelInfo("Jumlah", 680, 80, 100, 40);
  private cLabelInfo labelJumlahCoffeUbahTransaksi = new cLabelInfo("Jumlah", 680, 175, 100, 40);
  private cLabelInfo labelJumlahNonCoffeUbahTransaksi = new cLabelInfo("Jumlah", 680, 275, 100, 40);
  private cLabelInfo labelHargaMakananUbahTransaksi = new cLabelInfo("Harga", 810, 80, 100, 40);
  private cLabelInfo labelHargaCoffeUbahTransaksi = new cLabelInfo("Harga", 810, 175, 100, 40);
  private cLabelInfo labelHargaNonCoffeUbahTransaksi = new cLabelInfo("Harga", 810, 275, 100, 40);
  private cTextField txtJumlahMakananUbahTransaksi = new cTextField(680, 110, 80);
  private cTextField txtJumlahCoffeUbahTransaksi = new cTextField(680, 210, 80);
  private cTextField txtJumlahNonCoffeUbahTransaksi = new cTextField(680, 310, 80);
  private cTextarea txtHargaMakananUbahTransaksi = new cTextarea(810, 110, 180, 30, false);
  private cTextarea txtHargaCoffeUbahTransaksi = new cTextarea(810, 210, 180, 30, false);
  private cTextarea txtHargaNonCoffeUbahTransaksi = new cTextarea(810, 310, 180, 30, false);
  private cLabelInfo labelHargaTotalUbahTransaksi = new cLabelInfo("Harga Total", 680, 380, 300, 40);
  private cTextarea txtHargaTotalUbahTransaksi = new cTextarea(810, 380, 180, 30, false);
  private cLabelInfo labelPromoUbahTransaksi = new cLabelInfo("Promo", 440, 360, 300, 40);
  private cComboBox pilihPembayaranUbahTransaksi = new cComboBox(
      new String[] { "Pembayaran", "CASH", "OVO", "GOPAY", "BCA", "MANDIRI", "DANA" }, 440, 450, 200, 30);
  private cErrorLabel errorPromoUbahTransaksi = new cErrorLabel("Promo tidak boleh Kosong!", 440, 415, 300);
  private cButton btnHapusInputUbahTransaksi = new cButton("Hapus", 700, 500, 150, 30, 20);
  private cButton btnSimpanUbahTransaksi = new cButton("Checkout", 880, 500, 150, 30, 20);
  private cButton btnKembaliUbahTransaksi = new cButton("Kembali", 80, 500, 150, 30, 20);

  // component of input data akun
  private cPanelRounded panelHeaderAkun = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInfoDataAkun = new cLabelInfo("Masukan Data Untuk Mengubah Data Akun!", 190, 20, 600, 40);
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
        initsDataTransaksi();
      }
    });

    menuHistory.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsDataHistory();
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
        if (selectedItem.equals("Menu Makanan")) {
          initsMenuMakanan();
        } else if (selectedItem.equals("Menu Coffe")) {
          initsMenuCoffe();
        } else if (selectedItem.equals("Menu Non Coffe")) {
          initsMenuNonCoffe();
        }
      }
    });

    labelPilihMenu.setForeground(cColor.WHITE);

    content.add(labelPilihMenu);

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
    content.add(labelPilihMenu);
    labelPilihMenu.setForeground(cColor.WHITE);

    txtCariMenuMakanan.setText(null);

    tblMenuMakanan = new cTable(Model.getAllMenuMakanan());

    tblMenuMakanan.getColumnModel().getColumn(0).setMinWidth(80);
    tblMenuMakanan.getColumnModel().getColumn(0).setMaxWidth(80);
    tblMenuMakanan.getColumnModel().getColumn(0).setWidth(80);

    tblMenuMakanan.getColumnModel().getColumn(1).setMinWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(1).setMaxWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(1).setWidth(0);

    tblMenuMakanan.getColumnModel().getColumn(2).setMinWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(2).setMaxWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(2).setWidth(0);

    tblMenuMakanan.getColumnModel().getColumn(3).setMinWidth(200);
    tblMenuMakanan.getColumnModel().getColumn(3).setMaxWidth(200);
    tblMenuMakanan.getColumnModel().getColumn(3).setWidth(200);

    tblMenuMakanan.getColumnModel().getColumn(4).setMinWidth(180);
    tblMenuMakanan.getColumnModel().getColumn(4).setMaxWidth(180);
    tblMenuMakanan.getColumnModel().getColumn(4).setWidth(180);

    tblMenuMakanan.getColumnModel().getColumn(6).setMinWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(6).setMaxWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(6).setWidth(0);

    tblMenuMakanan.getColumnModel().getColumn(7).setMinWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(7).setMaxWidth(0);
    tblMenuMakanan.getColumnModel().getColumn(7).setWidth(0);

    txtCariMenuMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariMenuMakanan.getText();

        tblMenuMakanan.setModel(Model.getCariMenuMakanan(keyword));

        tblMenuMakanan.getColumnModel().getColumn(0).setMinWidth(80);
        tblMenuMakanan.getColumnModel().getColumn(0).setMaxWidth(80);
        tblMenuMakanan.getColumnModel().getColumn(0).setWidth(80);

        tblMenuMakanan.getColumnModel().getColumn(1).setMinWidth(0);
        tblMenuMakanan.getColumnModel().getColumn(1).setMaxWidth(0);
        tblMenuMakanan.getColumnModel().getColumn(1).setWidth(0);

        tblMenuMakanan.getColumnModel().getColumn(2).setMinWidth(0);
        tblMenuMakanan.getColumnModel().getColumn(2).setMaxWidth(0);
        tblMenuMakanan.getColumnModel().getColumn(2).setWidth(0);

        tblMenuMakanan.getColumnModel().getColumn(3).setMinWidth(200);
        tblMenuMakanan.getColumnModel().getColumn(3).setMaxWidth(200);
        tblMenuMakanan.getColumnModel().getColumn(3).setWidth(200);

        tblMenuMakanan.getColumnModel().getColumn(4).setMinWidth(180);
        tblMenuMakanan.getColumnModel().getColumn(4).setMaxWidth(180);
        tblMenuMakanan.getColumnModel().getColumn(4).setWidth(180);

        tblMenuMakanan.getColumnModel().getColumn(6).setMinWidth(0);
        tblMenuMakanan.getColumnModel().getColumn(6).setMaxWidth(0);
        tblMenuMakanan.getColumnModel().getColumn(6).setWidth(0);

        tblMenuMakanan.getColumnModel().getColumn(7).setMinWidth(0);
        tblMenuMakanan.getColumnModel().getColumn(7).setMaxWidth(0);
        tblMenuMakanan.getColumnModel().getColumn(7).setWidth(0);

      }
    });

    tblMenuMakanan.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblMenuMakanan.getSelectedRow();
        String idString = tblMenuMakanan.getValueAt(selectedIndex, 0).toString();
        int idMenu = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

        String deksripsiMakanan = Model.getDetailMenuMakanan(idMenu)[7].toString();
        valueDeskripsiMenuMakanan.setText(deksripsiMakanan);

        String hargaMakanan = Model.getDetailMenuMakanan(idMenu)[6].toString();
        valueHargaMenuMakanan.setText(hargaMakanan);
      }
    });

    spMenuMakanan = new cScrollPane(tblMenuMakanan, 0, 150, 600, 500);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Deskripsi Makanan");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    txtCariMenuMakanan.setBorder(titledBorder);
    txtCariMenuMakanan.setSize(300, 45);

    valueDeskripsiMenuMakanan.setBorder(titledDeskripsi);

    content.add(spMenuMakanan);
    content.add(btnTambahMakanan);
    content.add(txtCariMenuMakanan);
    content.add(labelHargaMenuMakanan);
    content.add(valueHargaMenuMakanan);
    content.add(labelRpMenuMakanan);
    content.add(valueDeskripsiMenuMakanan);

    content.add(panelHeaderMenuMakanan);
    content.add(panelDeskripsiMenuMakanan);
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
    content.add(labelPilihMenu);
    labelPilihMenu.setForeground(cColor.WHITE);

    txtCariMenuCoffe.setText(null);

    tblMenuCoffe = new cTable(Model.getAllMenuCoffe());

    tblMenuCoffe.getColumnModel().getColumn(0).setMinWidth(80);
    tblMenuCoffe.getColumnModel().getColumn(0).setMaxWidth(80);
    tblMenuCoffe.getColumnModel().getColumn(0).setWidth(80);

    tblMenuCoffe.getColumnModel().getColumn(1).setMinWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(1).setWidth(0);

    tblMenuCoffe.getColumnModel().getColumn(2).setMinWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(2).setWidth(0);

    tblMenuCoffe.getColumnModel().getColumn(3).setMinWidth(200);
    tblMenuCoffe.getColumnModel().getColumn(3).setMaxWidth(200);
    tblMenuCoffe.getColumnModel().getColumn(3).setWidth(200);

    tblMenuCoffe.getColumnModel().getColumn(4).setMinWidth(180);
    tblMenuCoffe.getColumnModel().getColumn(4).setMaxWidth(180);
    tblMenuCoffe.getColumnModel().getColumn(4).setWidth(180);

    tblMenuCoffe.getColumnModel().getColumn(6).setMinWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(6).setMaxWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(6).setWidth(0);

    tblMenuCoffe.getColumnModel().getColumn(7).setMinWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
    tblMenuCoffe.getColumnModel().getColumn(7).setWidth(0);

    txtCariMenuCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariMenuCoffe.getText();

        tblMenuCoffe.setModel(Model.getCariMenuCoffe(keyword));

        tblMenuCoffe.getColumnModel().getColumn(0).setMinWidth(80);
        tblMenuCoffe.getColumnModel().getColumn(0).setMaxWidth(80);
        tblMenuCoffe.getColumnModel().getColumn(0).setWidth(80);

        tblMenuCoffe.getColumnModel().getColumn(1).setMinWidth(0);
        tblMenuCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
        tblMenuCoffe.getColumnModel().getColumn(1).setWidth(0);

        tblMenuCoffe.getColumnModel().getColumn(2).setMinWidth(0);
        tblMenuCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
        tblMenuCoffe.getColumnModel().getColumn(2).setWidth(0);

        tblMenuCoffe.getColumnModel().getColumn(3).setMinWidth(200);
        tblMenuCoffe.getColumnModel().getColumn(3).setMaxWidth(200);
        tblMenuCoffe.getColumnModel().getColumn(3).setWidth(200);

        tblMenuCoffe.getColumnModel().getColumn(4).setMinWidth(180);
        tblMenuCoffe.getColumnModel().getColumn(4).setMaxWidth(180);
        tblMenuCoffe.getColumnModel().getColumn(4).setWidth(180);

        tblMenuCoffe.getColumnModel().getColumn(6).setMinWidth(0);
        tblMenuCoffe.getColumnModel().getColumn(6).setMaxWidth(0);
        tblMenuCoffe.getColumnModel().getColumn(6).setWidth(0);

        tblMenuCoffe.getColumnModel().getColumn(7).setMinWidth(0);
        tblMenuCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
        tblMenuCoffe.getColumnModel().getColumn(7).setWidth(0);

      }
    });

    tblMenuCoffe.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblMenuCoffe.getSelectedRow();
        String idString = tblMenuCoffe.getValueAt(selectedIndex, 0).toString();
        int idMenu = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

        String deksripsiCoffe = Model.getDetailMenuCoffe(idMenu)[7].toString();
        valueDeskripsiMenuCoffe.setText(deksripsiCoffe);

        String hargaCoffe = Model.getDetailMenuCoffe(idMenu)[6].toString();
        valueHargaMenuCoffe.setText(hargaCoffe);
      }
    });

    spMenuCoffe = new cScrollPane(tblMenuCoffe, 0, 150, 600, 500);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Deskripsi Coffe");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    txtCariMenuCoffe.setBorder(titledBorder);
    txtCariMenuCoffe.setSize(300, 45);

    valueDeskripsiMenuCoffe.setBorder(titledDeskripsi);

    content.add(spMenuCoffe);
    content.add(btnTambahCoffe);
    content.add(txtCariMenuCoffe);
    content.add(labelHargaMenuCoffe);
    content.add(valueHargaMenuCoffe);
    content.add(labelRpMenuCoffe);
    content.add(valueDeskripsiMenuCoffe);

    content.add(panelHeaderMenuCoffe);
    content.add(panelDeskripsiMenuCoffe);
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
    content.add(labelPilihMenu);
    labelPilihMenu.setForeground(cColor.WHITE);

    txtCariMenuNonCoffe.setText(null);

    tblMenuNonCoffe = new cTable(Model.getAllMenuNonCoffe());

    tblMenuNonCoffe.getColumnModel().getColumn(0).setMinWidth(80);
    tblMenuNonCoffe.getColumnModel().getColumn(0).setMaxWidth(80);
    tblMenuNonCoffe.getColumnModel().getColumn(0).setWidth(80);

    tblMenuNonCoffe.getColumnModel().getColumn(1).setMinWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(1).setWidth(0);

    tblMenuNonCoffe.getColumnModel().getColumn(2).setMinWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(2).setWidth(0);

    tblMenuNonCoffe.getColumnModel().getColumn(3).setMinWidth(200);
    tblMenuNonCoffe.getColumnModel().getColumn(3).setMaxWidth(200);
    tblMenuNonCoffe.getColumnModel().getColumn(3).setWidth(200);

    tblMenuNonCoffe.getColumnModel().getColumn(4).setMinWidth(180);
    tblMenuNonCoffe.getColumnModel().getColumn(4).setMaxWidth(180);
    tblMenuNonCoffe.getColumnModel().getColumn(4).setWidth(180);

    tblMenuNonCoffe.getColumnModel().getColumn(6).setMinWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(6).setMaxWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(6).setWidth(0);

    tblMenuNonCoffe.getColumnModel().getColumn(7).setMinWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
    tblMenuNonCoffe.getColumnModel().getColumn(7).setWidth(0);

    txtCariMenuNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariMenuNonCoffe.getText();

        tblMenuNonCoffe.setModel(Model.getCariMenuNonCoffe(keyword));

        tblMenuNonCoffe.getColumnModel().getColumn(0).setMinWidth(80);
        tblMenuNonCoffe.getColumnModel().getColumn(0).setMaxWidth(80);
        tblMenuNonCoffe.getColumnModel().getColumn(0).setWidth(80);

        tblMenuNonCoffe.getColumnModel().getColumn(1).setMinWidth(0);
        tblMenuNonCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
        tblMenuNonCoffe.getColumnModel().getColumn(1).setWidth(0);

        tblMenuNonCoffe.getColumnModel().getColumn(2).setMinWidth(0);
        tblMenuNonCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
        tblMenuNonCoffe.getColumnModel().getColumn(2).setWidth(0);

        tblMenuNonCoffe.getColumnModel().getColumn(3).setMinWidth(200);
        tblMenuNonCoffe.getColumnModel().getColumn(3).setMaxWidth(200);
        tblMenuNonCoffe.getColumnModel().getColumn(3).setWidth(200);

        tblMenuNonCoffe.getColumnModel().getColumn(4).setMinWidth(180);
        tblMenuNonCoffe.getColumnModel().getColumn(4).setMaxWidth(180);
        tblMenuNonCoffe.getColumnModel().getColumn(4).setWidth(180);

        tblMenuNonCoffe.getColumnModel().getColumn(6).setMinWidth(0);
        tblMenuNonCoffe.getColumnModel().getColumn(6).setMaxWidth(0);
        tblMenuNonCoffe.getColumnModel().getColumn(6).setWidth(0);

        tblMenuNonCoffe.getColumnModel().getColumn(7).setMinWidth(0);
        tblMenuNonCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
        tblMenuNonCoffe.getColumnModel().getColumn(7).setWidth(0);

      }
    });

    tblMenuNonCoffe.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblMenuNonCoffe.getSelectedRow();
        String idString = tblMenuNonCoffe.getValueAt(selectedIndex, 0).toString();
        int idMenu = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

        String deksripsiNonCoffe = Model.getDetailMenuNonCoffe(idMenu)[7].toString();
        valueDeskripsiMenuNonCoffe.setText(deksripsiNonCoffe);

        String hargaNonCoffe = Model.getDetailMenuNonCoffe(idMenu)[6].toString();
        valueHargaMenuNonCoffe.setText(hargaNonCoffe);
      }
    });

    spMenuNonCoffe = new cScrollPane(tblMenuNonCoffe, 0, 150, 600, 500);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Deskripsi NonCoffe");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    txtCariMenuNonCoffe.setBorder(titledBorder);
    txtCariMenuNonCoffe.setSize(300, 45);

    valueDeskripsiMenuNonCoffe.setBorder(titledDeskripsi);

    content.add(spMenuNonCoffe);
    content.add(btnTambahNonCoffe);
    content.add(txtCariMenuNonCoffe);
    content.add(labelHargaMenuNonCoffe);
    content.add(valueHargaMenuNonCoffe);
    content.add(labelRpMenuNonCoffe);
    content.add(valueDeskripsiMenuNonCoffe);

    content.add(panelHeaderMenuNonCoffe);
    content.add(panelDeskripsiMenuNonCoffe);
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

    tblDataPromo = new cTable(Model.getAllPromo());

    tblDataPromo.getColumnModel().getColumn(0).setMinWidth(80);
    tblDataPromo.getColumnModel().getColumn(0).setMaxWidth(80);
    tblDataPromo.getColumnModel().getColumn(0).setWidth(80);

    tblDataPromo.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(1).setWidth(0);

    tblDataPromo.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(2).setWidth(0);

    tblDataPromo.getColumnModel().getColumn(3).setMinWidth(200);
    tblDataPromo.getColumnModel().getColumn(3).setMaxWidth(200);
    tblDataPromo.getColumnModel().getColumn(3).setWidth(200);

    tblDataPromo.getColumnModel().getColumn(4).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(4).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(4).setWidth(0);

    tblDataPromo.getColumnModel().getColumn(5).setMinWidth(180);
    tblDataPromo.getColumnModel().getColumn(5).setMaxWidth(180);
    tblDataPromo.getColumnModel().getColumn(5).setWidth(180);

    tblDataPromo.getColumnModel().getColumn(7).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(7).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(7).setWidth(0);

    tblDataPromo.getColumnModel().getColumn(8).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(8).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(8).setWidth(0);

    txtCariPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariPromo.getText();

        tblDataPromo.setModel(Model.getCariPromo(keyword));

        tblDataPromo.getColumnModel().getColumn(0).setMinWidth(80);
        tblDataPromo.getColumnModel().getColumn(0).setMaxWidth(80);
        tblDataPromo.getColumnModel().getColumn(0).setWidth(80);

        tblDataPromo.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataPromo.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataPromo.getColumnModel().getColumn(1).setWidth(0);

        tblDataPromo.getColumnModel().getColumn(2).setMinWidth(0);
        tblDataPromo.getColumnModel().getColumn(2).setMaxWidth(0);
        tblDataPromo.getColumnModel().getColumn(2).setWidth(0);

        tblDataPromo.getColumnModel().getColumn(3).setMinWidth(200);
        tblDataPromo.getColumnModel().getColumn(3).setMaxWidth(200);
        tblDataPromo.getColumnModel().getColumn(3).setWidth(200);

        tblDataPromo.getColumnModel().getColumn(4).setMinWidth(0);
        tblDataPromo.getColumnModel().getColumn(4).setMaxWidth(0);
        tblDataPromo.getColumnModel().getColumn(4).setWidth(0);

        tblDataPromo.getColumnModel().getColumn(5).setMinWidth(180);
        tblDataPromo.getColumnModel().getColumn(5).setMaxWidth(180);
        tblDataPromo.getColumnModel().getColumn(5).setWidth(180);

        tblDataPromo.getColumnModel().getColumn(7).setMinWidth(0);
        tblDataPromo.getColumnModel().getColumn(7).setMaxWidth(0);
        tblDataPromo.getColumnModel().getColumn(7).setWidth(0);

        tblDataPromo.getColumnModel().getColumn(8).setMinWidth(0);
        tblDataPromo.getColumnModel().getColumn(8).setMaxWidth(0);
        tblDataPromo.getColumnModel().getColumn(8).setWidth(0);
      }
    });

    tblDataPromo.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblDataPromo.getSelectedRow();
        String idString = tblDataPromo.getValueAt(selectedIndex, 0).toString();
        int idPromo = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

        String namaPromo = Model.getDetailPromo(idPromo)[4].toString();
        valueDataPromo.setText(namaPromo);

        String hargaPromo = Model.getDetailPromo(idPromo)[7].toString();
        valueHargaPromo.setText(hargaPromo);

        String deksripsiPromo = Model.getDetailPromo(idPromo)[8].toString();
        valueDeskripsiPromo.setText(deksripsiPromo);
      }
    });

    spDataPromo = new cScrollPane(tblDataPromo, 0, 150, 600, 500);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Deskripsi Makanan");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    txtCariPromo.setBorder(titledBorder);
    txtCariPromo.setSize(300, 45);

    valueDeskripsiPromo.setBorder(titledDeskripsi);

    labelPromo.setForeground(cColor.WHITE);

    content.add(spDataPromo);

    content.add(btnTambahPromo);
    content.add(labelPromo);
    content.add(txtCariPromo);
    content.add(valueDataPromo);
    content.add(labelRpDataPromo);
    content.add(valueHargaPromo);
    content.add(valueDeskripsiPromo);

    content.add(panelHeaderPromo);
    content.add(panelDeskripsiPromo);

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

    tblDataMeja = new cTable(Model.getAllMeja());

    tblDataMeja.getColumnModel().getColumn(0).setMinWidth(80);
    tblDataMeja.getColumnModel().getColumn(0).setMaxWidth(80);
    tblDataMeja.getColumnModel().getColumn(0).setWidth(80);

    tblDataMeja.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(1).setWidth(0);

    tblDataMeja.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(2).setWidth(0);

    tblDataMeja.getColumnModel().getColumn(3).setMinWidth(200);
    tblDataMeja.getColumnModel().getColumn(3).setMaxWidth(200);
    tblDataMeja.getColumnModel().getColumn(3).setWidth(200);

    tblDataMeja.getColumnModel().getColumn(4).setMinWidth(70);
    tblDataMeja.getColumnModel().getColumn(4).setMaxWidth(70);
    tblDataMeja.getColumnModel().getColumn(4).setWidth(70);

    tblDataMeja.getColumnModel().getColumn(5).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(5).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(5).setWidth(0);

    tblDataMeja.getColumnModel().getColumn(6).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(6).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(6).setWidth(0);

    txtCariMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariMeja.getText();

        tblDataMeja.setModel(Model.getCariMeja(keyword));

        tblDataMeja.getColumnModel().getColumn(0).setMinWidth(80);
        tblDataMeja.getColumnModel().getColumn(0).setMaxWidth(80);
        tblDataMeja.getColumnModel().getColumn(0).setWidth(80);

        tblDataMeja.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataMeja.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataMeja.getColumnModel().getColumn(1).setWidth(0);

        tblDataMeja.getColumnModel().getColumn(2).setMinWidth(0);
        tblDataMeja.getColumnModel().getColumn(2).setMaxWidth(0);
        tblDataMeja.getColumnModel().getColumn(2).setWidth(0);

        tblDataMeja.getColumnModel().getColumn(3).setMinWidth(200);
        tblDataMeja.getColumnModel().getColumn(3).setMaxWidth(200);
        tblDataMeja.getColumnModel().getColumn(3).setWidth(200);

        tblDataMeja.getColumnModel().getColumn(4).setMinWidth(70);
        tblDataMeja.getColumnModel().getColumn(4).setMaxWidth(70);
        tblDataMeja.getColumnModel().getColumn(4).setWidth(70);

        tblDataMeja.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataMeja.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataMeja.getColumnModel().getColumn(5).setWidth(0);

        tblDataMeja.getColumnModel().getColumn(6).setMinWidth(0);
        tblDataMeja.getColumnModel().getColumn(6).setMaxWidth(0);
        tblDataMeja.getColumnModel().getColumn(6).setWidth(0);

      }
    });

    tblDataMeja.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblDataMeja.getSelectedRow();
        String idString = tblDataMeja.getValueAt(selectedIndex, 0).toString();
        int idMeja = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

        String jenisMeja = Model.getDetailMeja(idMeja)[5].toString();
        valueJenisDataMeja.setText(jenisMeja);

        String deksripsiMeja = Model.getDetailMeja(idMeja)[6].toString();
        valueDeskripsiMeja.setText(deksripsiMeja);
      }
    });

    spDataMeja = new cScrollPane(tblDataMeja, 0, 150, 600, 500);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Deskripsi Meja");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    txtCariMeja.setBorder(titledBorder);
    txtCariMeja.setSize(300, 45);

    valueDeskripsiMeja.setBorder(titledDeskripsi);

    labelMeja.setForeground(cColor.WHITE);

    content.add(spDataMeja);

    content.add(labelMeja);
    content.add(txtCariMeja);
    content.add(btnTambahMeja);
    content.add(labelJenisDataMeja);
    content.add(valueJenisDataMeja);
    content.add(valueDeskripsiMeja);

    content.add(panelHeaderMeja);
    content.add(panelDeskripsiMeja);

    setVisible(true);
  }

  private void initializeTransaksi() {
    ArrayList<String> mitraTransaksi = Model.getAllMitraTransaksi();
    mitraTransaksi.add(0, "-");
    pilihMitraTransaksi = new cComboBox(mitraTransaksi.toArray(new String[0]), 80, 205, 200, 30);

    ArrayList<String> menuMakanan = Model.getAllMenuTransaksiMakanan();
    menuMakanan.add(0, "-");
    pilihMakananTransaksi = new cComboBox(menuMakanan.toArray(new String[0]), 440, 110, 200, 30);

    ArrayList<String> menuCoffe = Model.getAllMenuTransaksiCoffe();
    menuCoffe.add(0, "-");
    pilihCoffeTransaksi = new cComboBox(menuCoffe.toArray(new String[0]), 440, 210, 200, 30);

    ArrayList<String> menuNonCoffe = Model.getAllMenuTransaksiNonCoffe();
    menuNonCoffe.add(0, "-");
    pilihNonCoffeTransaksi = new cComboBox(menuNonCoffe.toArray(new String[0]), 440, 310, 200, 30);

    ArrayList<String> mejaTransaksi = Model.getAllMejaTransaksi();
    mejaTransaksi.add(0, "-");
    pilihMejaTransaksi = new cComboBox(mejaTransaksi.toArray(new String[0]), 80, 110, 200, 30);

    ArrayList<String> promoTransaksi = Model.getAllPromoTransaksi();
    promoTransaksi.add(0, "-");
    pilihPromoTransaksi = new cComboBox(promoTransaksi.toArray(new String[0]), 440, 390, 200, 30);

    // Ubah Data Transaksi
    pilihMitraUbahTransaksi = new cComboBox(mitraTransaksi.toArray(new String[0]), 80, 205, 200, 30);
    pilihMakananUbahTransaksi = new cComboBox(menuMakanan.toArray(new String[0]), 440, 110, 200, 30);
    pilihCoffeUbahTransaksi = new cComboBox(menuCoffe.toArray(new String[0]), 440, 210, 200, 30);
    pilihNonCoffeUbahTransaksi = new cComboBox(menuNonCoffe.toArray(new String[0]), 440, 310, 200, 30);
    pilihMejaUbahTransaksi = new cComboBox(mejaTransaksi.toArray(new String[0]), 80, 110, 200, 30);
    pilihPromoUbahTransaksi = new cComboBox(promoTransaksi.toArray(new String[0]), 440, 390, 200, 30);
  }

  private void initsDataTransaksi() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Data Transaksi");

    btnTambahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputTransaksi();
      }
    });

    btnEditTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataTransaksi.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblDataTransaksi.getValueAt(selectedIndex, 0).toString();
          int idTransaksi = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin mengubah data Transaksi!",
              "Konfirmasi ubah Data Transaksi",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            initsUbahDataTransaksi(idTransaksi);
          }
        } else {
          // Jika tidak ada yang dipilih
          JOptionPane.showMessageDialog(cDashboardCustomerView.this,
              "Pilih data terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataTransaksi.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblDataTransaksi.getValueAt(selectedIndex, 0).toString();
          int idTransaksi = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin menghapus data Transaksi!",
              "Konfirmasi Hapus Data Transaksi",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            boolean isDeleted = Model.hapusDataTransaksi(idTransaksi);
            if (isDeleted) {
              JOptionPane.showMessageDialog(cDashboardCustomerView.this,
                  "Data Transaksi berhasil dihapus!",
                  "Berhasil",
                  JOptionPane.INFORMATION_MESSAGE);
              initsDataMeja();
            } else {
              JOptionPane.showMessageDialog(cDashboardCustomerView.this,
                  "Data Transaksi gagal dihapus!",
                  "Gagal",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        } else {
          // Jika tidak ada yang dipilih
          JOptionPane.showMessageDialog(cDashboardCustomerView.this,
              "Pilih data terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnDetailTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataTransaksi.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblDataTransaksi.getValueAt(selectedIndex, 0).toString();
          int idTransaksi = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          String transaksiId = Model.getDetailOnlineDiproses(idTransaksi)[0].toString();
          String mitraId = Model.getDetailOnlineDiproses(idTransaksi)[1].toString();
          String customerId = Model.getDetailOnlineDiproses(idTransaksi)[2].toString();
          String namaMitra = Model.getDetailOnlineDiproses(idTransaksi)[3].toString();
          String namaCustomer = Model.getDetailOnlineDiproses(idTransaksi)[4].toString();
          String waktuTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[5].toString();
          String makananTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[6].toString();
          String coffeTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[7].toString();
          String nonCoffeTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[8].toString();
          String jumlahMakanan = Model.getDetailOnlineDiproses(idTransaksi)[9].toString();
          String jumlahCoffe = Model.getDetailOnlineDiproses(idTransaksi)[10].toString();
          String jumlahNonCoffe = Model.getDetailOnlineDiproses(idTransaksi)[11].toString();
          String hargaMakanan = Model.getDetailOnlineDiproses(idTransaksi)[12].toString();
          String hargaCoffe = Model.getDetailOnlineDiproses(idTransaksi)[13].toString();
          String hargaNonCoffe = Model.getDetailOnlineDiproses(idTransaksi)[14].toString();
          String promoTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[15].toString();
          String mejaTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[16].toString();
          String deskripsiTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[17].toString();
          String hargaTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[18].toString();
          String hargaPromo = Model.getDetailOnlineDiproses(idTransaksi)[19].toString();
          String bayarTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[20].toString();
          String uangTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[21].toString();
          String kembalianTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[22].toString();
          String statusTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[23].toString();

          String detailTransaksi = "\tForque" + "\n\n"
              + "Jl. Jagal No.3A RT 007/004, Jl. Jagal, Rangkapan Jaya,\n"
              + "Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435\n"
              + "====================================================\n"
              + String.format("%-40s:  %s", "Tanggal/Waktu", waktuTransaksi) + "\n"
              + String.format("%-40s:  TR%s", "ID Transaksi", transaksiId) + "\n"
              + String.format("%-44s:  MI%s", "ID Mitra", mitraId) + "\n"
              + String.format("%-39s: %s", "Nama Mitra", namaMitra) + "\n"
              + "====================================================\n"
              + String.format("%-44s:  CS%s", "ID Mitra", customerId) + "\n"
              + String.format("%-44s: %s", "Status Transaksi", statusTransaksi) + "\n"
              + String.format("%-44s: %s", "Nomor Meja", mejaTransaksi) + "\n"
              + String.format("%-39s: %s", "Nama Pemesan", namaCustomer) + "\n"
              + String.format("%-44s: %s", "Pembayaran", bayarTransaksi) + "\n"
              + String.format("%-49s: %s", "Promo", promoTransaksi) + "\n"
              + String.format("%-38s: %s", "Deskripsi Pesanan", deskripsiTransaksi) + "\n"
              + "====================================================\n"
              + String.format("%-60s %-30s %-10s", makananTransaksi, jumlahMakanan, hargaMakanan) + "\n"
              + String.format("%-60s %-30s %-10s", coffeTransaksi, jumlahCoffe, hargaCoffe) + "\n"
              + String.format("%-60s %-30s %-10s", nonCoffeTransaksi, jumlahNonCoffe, hargaNonCoffe) + "\n"
              + "====================================================\n"
              + String.format("%-80s Harga Total   : %s", "", hargaTransaksi) + "\n"
              + String.format("%-80s Harga Promo          : %s", "", hargaPromo) + "\n"
              + String.format("%-80s Uang                 : %s", "", uangTransaksi) + "\n"
              + String.format("%-80s Kembalian            : %s", "", kembalianTransaksi) + "\n"
              + "=======================================================\n"
              + "---------------TERIMAKASIH BY ARCOO NGAWI---------------\n"
              + "=======================================================\n"
              + "\n";

          Object[] options = { "KEMBALI" };
          JOptionPane.showOptionDialog(
              null,
              detailTransaksi,
              "detailTransaksi",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

        } else {
          // Jika tidak ada yang dipilih
          JOptionPane.showMessageDialog(cDashboardCustomerView.this,
              "Pilih data terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblDataTransaksi = new cTable(Model.getAllOnlineDiproses());

    tblDataTransaksi.getColumnModel().getColumn(0).setMinWidth(80);
    tblDataTransaksi.getColumnModel().getColumn(0).setMaxWidth(80);
    tblDataTransaksi.getColumnModel().getColumn(0).setWidth(80);

    tblDataTransaksi.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(1).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(2).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(5).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(5).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(5).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(6).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(6).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(6).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(7).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(7).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(7).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(8).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(8).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(8).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(9).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(9).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(9).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(10).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(10).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(10).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(11).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(11).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(11).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(12).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(12).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(12).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(13).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(13).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(13).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(14).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(14).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(14).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(15).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(15).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(15).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(16).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(16).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(16).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(17).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(17).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(17).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(18).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(18).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(18).setWidth(0);

    spDataTransaksi = new cScrollPane(tblDataTransaksi, 0, 150, 1100, 400);

    labelPilihTransaksi.setForeground(cColor.WHITE);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    txtCariTransaksi.setBorder(titledBorder);
    txtCariTransaksi.setSize(300, 45);

    content.add(btnTambahTransaksi);
    content.add(btnEditTransaksi);
    content.add(btnHapusTransaksi);
    content.add(btnDetailTransaksi);

    content.add(spDataTransaksi);
    content.add(labelPilihTransaksi);
    content.add(txtCariTransaksi);
    content.add(panelHeaderTransaksi);

    setVisible(true);
  }

  private void initsUbahDataTransaksi(int idTransaksi) {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Data Input Transaksi");

    initializeTransaksi();

    Object[] detailTransaksi = Model.getDetailOnlineDiproses(idTransaksi);

    pilihMitraUbahTransaksi.setSelectedItem(detailTransaksi[3].toString());
    pilihMakananUbahTransaksi.setSelectedItem(detailTransaksi[6].toString());
    pilihCoffeUbahTransaksi.setSelectedItem(detailTransaksi[7].toString());
    pilihNonCoffeUbahTransaksi.setSelectedItem(detailTransaksi[8].toString());
    pilihMejaUbahTransaksi.setSelectedItem(detailTransaksi[16].toString());
    pilihPromoUbahTransaksi.setSelectedItem(detailTransaksi[15].toString());
    txtDeskripsiUbahTransaksi.setText(detailTransaksi[17].toString());
    txtJumlahMakananUbahTransaksi.setText(detailTransaksi[9].toString());
    txtJumlahCoffeUbahTransaksi.setText(detailTransaksi[10].toString());
    txtJumlahNonCoffeUbahTransaksi.setText(detailTransaksi[11].toString());
    txtHargaMakananUbahTransaksi.setText(detailTransaksi[12].toString());
    txtHargaCoffeUbahTransaksi.setText(detailTransaksi[13].toString());
    txtHargaNonCoffeUbahTransaksi.setText(detailTransaksi[14].toString());
    txtHargaTotalUbahTransaksi.setText(detailTransaksi[18].toString());

    txtJumlahMakananUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String jumlahMakananText = txtJumlahMakananUbahTransaksi.getText();
        int jumlahMakanan;

        if (jumlahMakananText.isEmpty() || !jumlahMakananText.matches("\\d+")) {
          jumlahMakanan = 1;
          txtJumlahMakananUbahTransaksi.setText(String.valueOf(jumlahMakanan));
        } else {
          jumlahMakanan = Integer.valueOf(jumlahMakananText);
        }

        String selectedMenu = (String) pilihMakananUbahTransaksi.getSelectedItem();
        if (!selectedMenu.equals("-")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuMakanan(selectedMenu);
          txtHargaMakananUbahTransaksi.setText(String.valueOf(hargaMenu));
        }
        updateUbahTotalHarga();
      }
    });

    txtJumlahCoffeUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String jumlahCoffeText = txtJumlahCoffeUbahTransaksi.getText();
        int jumlahCoffe;

        if (jumlahCoffeText.isEmpty() || !jumlahCoffeText.matches("\\d+")) {
          jumlahCoffe = 0;
          txtJumlahCoffeUbahTransaksi.setText(String.valueOf(jumlahCoffe));
        } else {
          jumlahCoffe = Integer.valueOf(jumlahCoffeText);
        }

        String selectedMenu = (String) pilihCoffeUbahTransaksi.getSelectedItem();
        if (!selectedMenu.equals("-")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuCoffe(selectedMenu);
          txtHargaCoffeUbahTransaksi.setText(String.valueOf(hargaMenu));
        }
        updateUbahTotalHarga();
      }
    });

    txtJumlahNonCoffeUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String jumlahNonCoffeText = txtJumlahNonCoffeUbahTransaksi.getText();
        int jumlahNonCoffe;

        if (jumlahNonCoffeText.isEmpty() || !jumlahNonCoffeText.matches("\\d+")) {
          jumlahNonCoffe = 1;
          txtJumlahNonCoffeUbahTransaksi.setText(String.valueOf(jumlahNonCoffe));
        } else {
          jumlahNonCoffe = Integer.valueOf(jumlahNonCoffeText);
        }

        String selectedMenu = (String) pilihNonCoffeUbahTransaksi.getSelectedItem();
        if (!selectedMenu.equals("-")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuNonCoffe(selectedMenu);
          txtHargaNonCoffeUbahTransaksi.setText(String.valueOf(hargaMenu));
        }
        updateUbahTotalHarga();
      }
    });

    pilihMakananUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihMakananUbahTransaksi.getSelectedItem();
        String jumlahMakananText = txtJumlahMakananUbahTransaksi.getText();
        int jumlahMakanan;

        if (selectedMenu.equals("-")) {
          jumlahMakanan = 0;
          txtJumlahMakananUbahTransaksi.setText(String.valueOf(jumlahMakanan));
          txtHargaMakananUbahTransaksi.setText("0");
          txtHargaTotalUbahTransaksi.setText("0");
        } else {
          jumlahMakanan = 1;
          txtJumlahMakananUbahTransaksi.setText(String.valueOf(jumlahMakanan));
          if (jumlahMakananText.isEmpty() || !jumlahMakananText.matches("\\d+")) {
            jumlahMakanan = 1;
            txtJumlahMakananUbahTransaksi.setText(String.valueOf(jumlahMakanan));
          } else {
            jumlahMakanan = Integer.valueOf(jumlahMakananText);
          }

          if (!selectedMenu.equals("-")) {
            int hargaMenu = Model.getHargaMenuMakanan(selectedMenu);
            txtHargaMakananUbahTransaksi.setText(String.valueOf(hargaMenu));
            int totalMakanan = jumlahMakanan * hargaMenu;
            String MakananTotal = Integer.toString(totalMakanan);
            txtHargaTotalUbahTransaksi.setText(MakananTotal);
          }
        }
        updateTotalHarga();
      }
    });

    pilihCoffeUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihCoffeUbahTransaksi.getSelectedItem();
        String jumlahCoffeText = txtJumlahCoffeUbahTransaksi.getText();
        int jumlahCoffe;

        if (selectedMenu.equals("-")) {
          jumlahCoffe = 0;
          txtJumlahCoffeUbahTransaksi.setText(String.valueOf(jumlahCoffe));
          txtHargaCoffeUbahTransaksi.setText("0");
          txtHargaTotalUbahTransaksi.setText("0");
        } else {
          jumlahCoffe = 1;
          txtJumlahCoffeUbahTransaksi.setText(String.valueOf(jumlahCoffe));
          if (jumlahCoffeText.isEmpty() || !jumlahCoffeText.matches("\\d+")) {
            jumlahCoffe = 1;
            txtJumlahCoffeUbahTransaksi.setText(String.valueOf(jumlahCoffe));
          } else {
            jumlahCoffe = Integer.valueOf(jumlahCoffeText);
          }

          if (!selectedMenu.equals("-")) {
            int hargaMenu = Model.getHargaMenuCoffe(selectedMenu);
            txtHargaCoffeUbahTransaksi.setText(String.valueOf(hargaMenu));
            int totalCoffe = jumlahCoffe * hargaMenu;
            String CoffeTotal = Integer.toString(totalCoffe);
            txtHargaTotalUbahTransaksi.setText(CoffeTotal);
          }
        }
        updateTotalHarga();
      }
    });

    pilihNonCoffeUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihNonCoffeUbahTransaksi.getSelectedItem();
        String jumlahNonCoffeText = txtJumlahNonCoffeUbahTransaksi.getText();
        int jumlahNonCoffe;

        if (selectedMenu.equals("-")) {
          jumlahNonCoffe = 0;
          txtJumlahNonCoffeUbahTransaksi.setText(String.valueOf(jumlahNonCoffe));
          txtHargaNonCoffeUbahTransaksi.setText("0");
          txtHargaTotalUbahTransaksi.setText("0");
        } else {
          jumlahNonCoffe = 1;
          txtJumlahNonCoffeUbahTransaksi.setText(String.valueOf(jumlahNonCoffe));
          if (jumlahNonCoffeText.isEmpty() || !jumlahNonCoffeText.matches("\\d+")) {
            jumlahNonCoffe = 1;
            txtJumlahNonCoffeUbahTransaksi.setText(String.valueOf(jumlahNonCoffe));
          } else {
            jumlahNonCoffe = Integer.valueOf(jumlahNonCoffeText);
          }

          if (!selectedMenu.equals("-")) {
            int hargaMenu = Model.getHargaMenuNonCoffe(selectedMenu);
            txtHargaNonCoffeUbahTransaksi.setText(String.valueOf(hargaMenu));
            int totalNonCoffe = jumlahNonCoffe * hargaMenu;
            String nonCoffeTotal = Integer.toString(totalNonCoffe);
            txtHargaTotalUbahTransaksi.setText(nonCoffeTotal);
          }
        }
        updateTotalHarga();
      }
    });

    pilihPromoUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMakanan = (String) pilihMakananUbahTransaksi.getSelectedItem();
        String selectedCoffe = (String) pilihCoffeUbahTransaksi.getSelectedItem();
        String selectedNonCoffe = (String) pilihNonCoffeUbahTransaksi.getSelectedItem();
        String selectedPromo = (String) pilihPromoUbahTransaksi.getSelectedItem();
        int jumlahMakanan = Integer.valueOf(txtJumlahMakananUbahTransaksi.getText());
        int jumlahCoffe = Integer.valueOf(txtJumlahCoffeUbahTransaksi.getText());
        int jumlahNonCoffe = Integer.valueOf(txtJumlahNonCoffeUbahTransaksi.getText());
        int hargaUbahTransaksi = Integer.valueOf(txtHargaTotalUbahTransaksi.getText());

        int hargaPromo = 0;

        if (selectedPromo != null && !selectedPromo.equals("-")) {
          if (selectedMakanan != null && !selectedMakanan.equals("-")) {
            hargaPromo += Model.getPromoMakanan(selectedMakanan, selectedPromo);
          }
          if (selectedCoffe != null && !selectedCoffe.equals("-")) {
            hargaPromo += Model.getPromoCoffe(selectedCoffe, selectedPromo);
          }
          if (selectedNonCoffe != null && !selectedNonCoffe.equals("-")) {
            hargaPromo += Model.getPromoNonCoffe(selectedNonCoffe, selectedPromo);
          }
        } else {
          // Jika promo tidak dipilih atau "-" yang dipilih, hitung harga normal tanpa
          // promo
          int hargaMenuMakanan = (selectedMakanan != null && !selectedMakanan.equals("-"))
              ? Model.getHargaMenuMakanan(selectedMakanan)
              : 0;
          int hargaMenuCoffe = (selectedCoffe != null && !selectedCoffe.equals("-"))
              ? Model.getHargaMenuCoffe(selectedCoffe)
              : 0;
          int hargaMenuNonCoffe = (selectedNonCoffe != null && !selectedNonCoffe.equals("-"))
              ? Model.getHargaMenuNonCoffe(selectedNonCoffe)
              : 0;

          hargaPromo = 0; // Reset hargaPromo to 0 when no promo is selected
          hargaUbahTransaksi = (hargaMenuMakanan * jumlahMakanan) + (hargaMenuCoffe * jumlahCoffe)
              + (hargaMenuNonCoffe * jumlahNonCoffe);
        }

        int hargaTotal = hargaUbahTransaksi - hargaPromo;
        String promoTotal = Integer.toString(hargaTotal);
        txtHargaTotalUbahTransaksi.setText(promoTotal);
      }
    });

    btnHapusInputUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        pilihMitraUbahTransaksi.setSelectedItem("-");
        pilihMejaUbahTransaksi.setSelectedItem("-");
        txtDeskripsiUbahTransaksi.setText(null);
        pilihMakananUbahTransaksi.setSelectedItem("-");
        pilihCoffeUbahTransaksi.setSelectedItem("-");
        pilihNonCoffeUbahTransaksi.setSelectedItem("-");
        pilihPromoUbahTransaksi.setSelectedItem("-");
        txtJumlahMakananTransaksi.setText(null);
        txtJumlahCoffeTransaksi.setText(null);
        txtJumlahNonCoffeTransaksi.setText(null);
        txtHargaMakananUbahTransaksi.setText(null);
        txtHargaCoffeUbahTransaksi.setText(null);
        txtHargaNonCoffeUbahTransaksi.setText(null);
      }
    });

    btnKembaliUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksi();
      }
    });

    btnSimpanUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihMejaUbahTransaksi.getSelectedItem() == null
            || pilihMejaUbahTransaksi.getSelectedItem() == null
            || txtDeskripsiUbahTransaksi.getText().trim().isEmpty()
            || pilihPembayaranUbahTransaksi.getSelectedItem() == null) {
          cDashboardCustomerView.this.setVisible(false);
          if (pilihMitraUbahTransaksi.getSelectedItem() == null
              || pilihMitraUbahTransaksi.getSelectedItem().toString().trim().equals("-")) {
            content.add(errorMitraUbahTransaksi);
          } else {
            content.remove(errorMitraUbahTransaksi);
          }
          if (pilihMejaUbahTransaksi.getSelectedItem() == null
              || pilihMejaUbahTransaksi.getSelectedItem().toString().trim().equals("-")) {
            content.add(errorMejaUbahTransaksi);
          } else {
            content.remove(errorMejaUbahTransaksi);
          }
          if (txtDeskripsiUbahTransaksi.getText().trim().isEmpty()) {
            content.add(errorDeskripsiUbahTransaksi);
          } else {
            content.remove(errorDeskripsiUbahTransaksi);
          }
          if (pilihPromoUbahTransaksi.getSelectedItem() == null
              || pilihPromoUbahTransaksi.getSelectedItem().toString().trim().equals("-")) {
            content.add(errorPromoUbahTransaksi);
          } else {
            content.remove(errorPromoUbahTransaksi);
          }
          cDashboardCustomerView.this.setVisible(true);
        } else {
          Object[] messagePembayaran = { "Pilih Pembayaran", pilihPembayaranUbahTransaksi };
          JOptionPane.showMessageDialog(null, messagePembayaran, "PEMBAYRAN",
              JOptionPane.PLAIN_MESSAGE);

          // Pertama, minta pengguna untuk memasukkan uang
          String checkoutUbahTransaksi = JOptionPane.showInputDialog(null, "Masukan Uang!", "Input",
              JOptionPane.PLAIN_MESSAGE);

          if (checkoutUbahTransaksi != null && !checkoutUbahTransaksi.trim().isEmpty()) {
            try {
              String selectedMitra = (String) pilihMitraUbahTransaksi.getSelectedItem();
              int idMitra = Integer.parseInt(selectedMitra.split(" - ")[0]);
              String mejaUbahTransaksi = (String) pilihMejaUbahTransaksi.getSelectedItem();
              String deskripsiUbahTransaksi = txtDeskripsiUbahTransaksi.getText();
              String makananUbahTransaksi = (String) pilihMakananUbahTransaksi.getSelectedItem();
              String coffeUbahTransaksi = (String) pilihCoffeUbahTransaksi.getSelectedItem();
              String nonCoffeUbahTransaksi = (String) pilihNonCoffeUbahTransaksi.getSelectedItem();
              String promoUbahTransaksi = (String) pilihPromoUbahTransaksi.getSelectedItem();
              String bayarUbahTransaksi = (String) pilihPembayaranUbahTransaksi.getSelectedItem();
              int jumlahMakanan = Integer.valueOf(txtJumlahMakananUbahTransaksi.getText());
              int jumlahCoffe = Integer.valueOf(txtJumlahCoffeUbahTransaksi.getText());
              int jumlahNonCoffe = Integer.valueOf(txtJumlahNonCoffeUbahTransaksi.getText());
              int hargaMakanan = Integer.valueOf(txtHargaMakananUbahTransaksi.getText());
              int hargaCoffe = Integer.valueOf(txtHargaCoffeUbahTransaksi.getText());
              int hargaNonCoffe = Integer.valueOf(txtHargaNonCoffeUbahTransaksi.getText());
              int hargaUbahTransaksi = Integer.valueOf(txtHargaTotalUbahTransaksi.getText());
              int uangTransaksi = Integer.valueOf(checkoutUbahTransaksi.trim());
              int kembalianTransaksi = uangTransaksi - hargaUbahTransaksi;

              int hargaPromo = 0; // Masukkan ke variable ini jika promo dipilih

              if (promoUbahTransaksi != null && !promoUbahTransaksi.equals("-")) {
                if (makananUbahTransaksi != null && !makananUbahTransaksi.equals("-")) {
                  hargaPromo += Model.getPromoMakanan(makananUbahTransaksi, promoUbahTransaksi);
                }
                if (coffeUbahTransaksi != null && !coffeUbahTransaksi.equals("-")) {
                  hargaPromo += Model.getPromoCoffe(coffeUbahTransaksi, promoUbahTransaksi);
                }
                if (nonCoffeUbahTransaksi != null && !nonCoffeUbahTransaksi.equals("-")) {
                  hargaPromo += Model.getPromoNonCoffe(nonCoffeUbahTransaksi, promoUbahTransaksi);
                }
              } else {
                hargaPromo = 0;
              }

              String pembayaranUbahTransaksi = "Forque\n\n"
                  + "======================================================\n"
                  + "Jl. Jagal No.3A RT 007/004, Jl. Jagal, Rangkapan Jaya,\n"
                  + "Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435\n"
                  + "======================================================\n"
                  + String.format("%-44s: %s", "Nomor Meja", pilihMejaUbahTransaksi.getSelectedItem()) + "\n"
                  + String.format("%-44s: %s", "Pembayaran", pilihPembayaranUbahTransaksi.getSelectedItem()) + "\n"
                  + String.format("%-49s: %s", "Promo", pilihPromoUbahTransaksi.getSelectedItem()) + "\n"
                  + String.format("%-38s: %s", "Deskripsi Pesanan", txtDeskripsiUbahTransaksi.getText()) + "\n"
                  + "======================================================\n"
                  + String.format("%-60s %-40s %-10s", pilihMakananUbahTransaksi.getSelectedItem(),
                      txtJumlahMakananUbahTransaksi.getText(), txtHargaMakananUbahTransaksi.getText())
                  + "\n"
                  + String.format("%-60s %-40s %-10s", pilihCoffeUbahTransaksi.getSelectedItem(),
                      txtJumlahCoffeUbahTransaksi.getText(), txtHargaCoffeUbahTransaksi.getText())
                  + "\n"
                  + String.format("%-60s %-40s %-10s", pilihNonCoffeUbahTransaksi.getSelectedItem(),
                      txtJumlahNonCoffeUbahTransaksi.getText(), txtHargaNonCoffeUbahTransaksi.getText())
                  + "\n"
                  + "=======================================================\n"
                  + String.format("%-80s Harga Total          : %s", "", txtHargaTotalUbahTransaksi.getText()) + "\n"
                  + String.format("%-80s Harga Promo          : %s", "", hargaPromo) + "\n"
                  + String.format("%-80s Uang                 : %s", "", uangTransaksi) + "\n"
                  + String.format("%-80s Kembalian            : %s", "", kembalianTransaksi) + "\n"
                  + "=======================================================\n"
                  + "---------------TERIMAKASIH BY ARCOO NGAWI---------------\n"
                  + "=======================================================\n"

                  + "\n\n\n";

              // Jika input valid, tampilkan konfirmasi pembayaran
              Object[] options = { "IYA", "BATAL" };
              int konfirmasi = JOptionPane.showOptionDialog(
                  null,
                  pembayaranUbahTransaksi,
                  "Pembayaran",
                  JOptionPane.DEFAULT_OPTION,
                  JOptionPane.QUESTION_MESSAGE,
                  null,
                  options,
                  options[0]);

              if (konfirmasi == 0) {
                if (Model.ubahDataTransaksiOnline(idTransaksi, idMitra, idCustomer, makananUbahTransaksi,
                    coffeUbahTransaksi,
                    nonCoffeUbahTransaksi, jumlahMakanan, jumlahCoffe, jumlahNonCoffe, hargaMakanan,
                    hargaCoffe, hargaNonCoffe, promoUbahTransaksi, mejaUbahTransaksi, deskripsiUbahTransaksi,
                    hargaUbahTransaksi, hargaPromo, bayarUbahTransaksi, uangTransaksi, kembalianTransaksi)) {
                  // kalau berhasil
                  JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Ubah Transaksi berhasil",
                      "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                  pilihMejaUbahTransaksi.setSelectedItem("-");
                  txtDeskripsiUbahTransaksi.setText(null);
                  pilihMakananUbahTransaksi.setSelectedItem("-");
                  pilihCoffeUbahTransaksi.setSelectedItem("-");
                  pilihNonCoffeUbahTransaksi.setSelectedItem("-");
                  pilihPromoUbahTransaksi.setSelectedItem("-");
                  txtJumlahMakananTransaksi.setText(null);
                  txtJumlahCoffeTransaksi.setText(null);
                  txtJumlahNonCoffeTransaksi.setText(null);
                  txtHargaMakananUbahTransaksi.setText(null);
                  txtHargaCoffeUbahTransaksi.setText(null);
                  txtHargaNonCoffeUbahTransaksi.setText(null);
                  JOptionPane.showMessageDialog(null, "Pembayaran berhasil!", "Pembayaran",
                      JOptionPane.INFORMATION_MESSAGE);
                  initsDataTransaksi();
                } else {
                  // kalau tidak berhasil
                  JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Ubah Transaksi Gagal!", "Gagal",
                      JOptionPane.ERROR_MESSAGE);
                }
              } else {
                JOptionPane.showMessageDialog(null, "Pembayaran dibatalkan.", "Dibatalkan",
                    JOptionPane.WARNING_MESSAGE);
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Input tidak valid. Masukkan angka yang benar.", "Error",
                  JOptionPane.ERROR_MESSAGE);
            }
          } else {
            JOptionPane.showMessageDialog(null, "Input tidak valid. Masukkan angka yang benar.", "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    labelInputUbahTransaksi.setForeground(cColor.WHITE);

    content.add(labelInputUbahTransaksi);
    content.add(labelMitraUbahTransaksi);
    content.add(pilihMitraUbahTransaksi);
    content.add(pilihMakananUbahTransaksi);
    content.add(pilihCoffeUbahTransaksi);
    content.add(pilihNonCoffeUbahTransaksi);
    content.add(labelMejaUbahTransaksi);
    content.add(pilihMejaUbahTransaksi);
    content.add(labelDeskripsiUbahTransaksi);
    content.add(txtDeskripsiUbahTransaksi);
    content.add(labelMakananUbahTransaksi);
    content.add(labelCoffeUbahTransaksi);
    content.add(labelNonCoffeUbahTransaksi);
    content.add(labelJumlahMakananUbahTransaksi);
    content.add(labelJumlahCoffeUbahTransaksi);
    content.add(labelJumlahNonCoffeUbahTransaksi);
    content.add(labelHargaMakananUbahTransaksi);
    content.add(labelHargaCoffeUbahTransaksi);
    content.add(labelHargaNonCoffeUbahTransaksi);
    content.add(txtJumlahMakananUbahTransaksi);
    content.add(txtJumlahCoffeUbahTransaksi);
    content.add(txtJumlahNonCoffeUbahTransaksi);
    content.add(txtHargaMakananUbahTransaksi);
    content.add(txtHargaCoffeUbahTransaksi);
    content.add(txtHargaNonCoffeUbahTransaksi);
    content.add(labelHargaTotalUbahTransaksi);
    content.add(txtHargaTotalUbahTransaksi);
    content.add(labelPromoUbahTransaksi);
    content.add(pilihPromoUbahTransaksi);

    content.add(btnSimpanUbahTransaksi);
    content.add(btnHapusInputUbahTransaksi);
    content.add(btnKembaliUbahTransaksi);
    content.add(panelUbahTransaksi);

    setVisible(true);
  }

  private void initsInputTransaksi() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Data Input Transaksi");

    initializeTransaksi();

    txtJumlahMakananTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String jumlahMakananText = txtJumlahMakananTransaksi.getText();
        int jumlahMakanan;

        if (jumlahMakananText.isEmpty() || !jumlahMakananText.matches("\\d+")) {
          jumlahMakanan = 1;
          txtJumlahMakananTransaksi.setText(String.valueOf(jumlahMakanan));
        } else {
          jumlahMakanan = Integer.valueOf(jumlahMakananText);
        }

        String selectedMenu = (String) pilihMakananTransaksi.getSelectedItem();
        if (!selectedMenu.equals("-")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuMakanan(selectedMenu);
          txtHargaMakananTransaksi.setText(String.valueOf(hargaMenu));
        }
        updateTotalHarga();
      }
    });

    txtJumlahCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String jumlahCoffeText = txtJumlahCoffeTransaksi.getText();
        int jumlahCoffe;

        if (jumlahCoffeText.isEmpty() || !jumlahCoffeText.matches("\\d+")) {
          jumlahCoffe = 0;
          txtJumlahCoffeTransaksi.setText(String.valueOf(jumlahCoffe));
        } else {
          jumlahCoffe = Integer.valueOf(jumlahCoffeText);
        }

        String selectedMenu = (String) pilihCoffeTransaksi.getSelectedItem();
        if (!selectedMenu.equals("-")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuCoffe(selectedMenu);
          txtHargaCoffeTransaksi.setText(String.valueOf(hargaMenu));
        }
        updateTotalHarga();
      }
    });

    txtJumlahNonCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String jumlahNonCoffeText = txtJumlahNonCoffeTransaksi.getText();
        int jumlahNonCoffe;

        if (jumlahNonCoffeText.isEmpty() || !jumlahNonCoffeText.matches("\\d+")) {
          jumlahNonCoffe = 1;
          txtJumlahNonCoffeTransaksi.setText(String.valueOf(jumlahNonCoffe));
        } else {
          jumlahNonCoffe = Integer.valueOf(jumlahNonCoffeText);
        }

        String selectedMenu = (String) pilihNonCoffeTransaksi.getSelectedItem();
        if (!selectedMenu.equals("-")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuNonCoffe(selectedMenu);
          txtHargaNonCoffeTransaksi.setText(String.valueOf(hargaMenu));
        }
        updateTotalHarga();
      }
    });

    pilihMakananTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihMakananTransaksi.getSelectedItem();
        String jumlahMakananText = txtJumlahMakananTransaksi.getText();
        int jumlahMakanan;

        if (selectedMenu.equals("-")) {
          jumlahMakanan = 0;
          txtJumlahMakananTransaksi.setText(String.valueOf(jumlahMakanan));
          txtHargaMakananTransaksi.setText("0");
          txtHargaTotalTransaksi.setText("0");
        } else {
          jumlahMakanan = 1;
          txtJumlahMakananTransaksi.setText(String.valueOf(jumlahMakanan));
          if (jumlahMakananText.isEmpty() || !jumlahMakananText.matches("\\d+")) {
            jumlahMakanan = 1;
            txtJumlahMakananTransaksi.setText(String.valueOf(jumlahMakanan));
          } else {
            jumlahMakanan = Integer.valueOf(jumlahMakananText);
          }

          if (!selectedMenu.equals("-")) {
            int hargaMenu = Model.getHargaMenuMakanan(selectedMenu);
            txtHargaMakananTransaksi.setText(String.valueOf(hargaMenu));
            int totalMakanan = jumlahMakanan * hargaMenu;
            String MakananTotal = Integer.toString(totalMakanan);
            txtHargaTotalTransaksi.setText(MakananTotal);
          }
        }
        updateTotalHarga();
      }
    });

    pilihCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihCoffeTransaksi.getSelectedItem();
        String jumlahCoffeText = txtJumlahCoffeTransaksi.getText();
        int jumlahCoffe;

        if (selectedMenu.equals("-")) {
          jumlahCoffe = 0;
          txtJumlahCoffeTransaksi.setText(String.valueOf(jumlahCoffe));
          txtHargaCoffeTransaksi.setText("0");
          txtHargaTotalTransaksi.setText("0");
        } else {
          jumlahCoffe = 1;
          txtJumlahCoffeTransaksi.setText(String.valueOf(jumlahCoffe));
          if (jumlahCoffeText.isEmpty() || !jumlahCoffeText.matches("\\d+")) {
            jumlahCoffe = 1;
            txtJumlahCoffeTransaksi.setText(String.valueOf(jumlahCoffe));
          } else {
            jumlahCoffe = Integer.valueOf(jumlahCoffeText);
          }

          if (!selectedMenu.equals("-")) {
            int hargaMenu = Model.getHargaMenuCoffe(selectedMenu);
            txtHargaCoffeTransaksi.setText(String.valueOf(hargaMenu));
            int totalCoffe = jumlahCoffe * hargaMenu;
            String CoffeTotal = Integer.toString(totalCoffe);
            txtHargaTotalTransaksi.setText(CoffeTotal);
          }
        }
        updateTotalHarga();
      }
    });

    pilihNonCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihNonCoffeTransaksi.getSelectedItem();
        String jumlahNonCoffeText = txtJumlahNonCoffeTransaksi.getText();
        int jumlahNonCoffe;

        if (selectedMenu.equals("-")) {
          jumlahNonCoffe = 0;
          txtJumlahNonCoffeTransaksi.setText(String.valueOf(jumlahNonCoffe));
          txtHargaNonCoffeTransaksi.setText("0");
          txtHargaTotalTransaksi.setText("0");
        } else {
          jumlahNonCoffe = 1;
          txtJumlahNonCoffeTransaksi.setText(String.valueOf(jumlahNonCoffe));
          if (jumlahNonCoffeText.isEmpty() || !jumlahNonCoffeText.matches("\\d+")) {
            jumlahNonCoffe = 1;
            txtJumlahNonCoffeTransaksi.setText(String.valueOf(jumlahNonCoffe));
          } else {
            jumlahNonCoffe = Integer.valueOf(jumlahNonCoffeText);
          }

          if (!selectedMenu.equals("-")) {
            int hargaMenu = Model.getHargaMenuNonCoffe(selectedMenu);
            txtHargaNonCoffeTransaksi.setText(String.valueOf(hargaMenu));
            int totalNonCoffe = jumlahNonCoffe * hargaMenu;
            String nonCoffeTotal = Integer.toString(totalNonCoffe);
            txtHargaTotalTransaksi.setText(nonCoffeTotal);
          }
        }
        updateTotalHarga();
      }
    });

    pilihPromoTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMakanan = (String) pilihMakananTransaksi.getSelectedItem();
        String selectedCoffe = (String) pilihCoffeTransaksi.getSelectedItem();
        String selectedNonCoffe = (String) pilihNonCoffeTransaksi.getSelectedItem();
        String selectedPromo = (String) pilihPromoTransaksi.getSelectedItem();

        int jumlahMakanan = txtJumlahMakananTransaksi.getText().isEmpty() ? 0
            : Integer.valueOf(txtJumlahMakananTransaksi.getText());
        int jumlahCoffe = txtJumlahCoffeTransaksi.getText().isEmpty() ? 0
            : Integer.valueOf(txtJumlahCoffeTransaksi.getText());
        int jumlahNonCoffe = txtJumlahNonCoffeTransaksi.getText().isEmpty() ? 0
            : Integer.valueOf(txtJumlahNonCoffeTransaksi.getText());
        int hargaTransaksi = txtHargaTotalTransaksi.getText().isEmpty() ? 0
            : Integer.valueOf(txtHargaTotalTransaksi.getText());

        int hargaPromo = 0;

        if (selectedPromo != null && !selectedPromo.equals("-")) {
          if (selectedMakanan != null && !selectedMakanan.equals("-")) {
            hargaPromo += Model.getPromoMakanan(selectedMakanan, selectedPromo);
          }
          if (selectedCoffe != null && !selectedCoffe.equals("-")) {
            hargaPromo += Model.getPromoCoffe(selectedCoffe, selectedPromo);
          }
          if (selectedNonCoffe != null && !selectedNonCoffe.equals("-")) {
            hargaPromo += Model.getPromoNonCoffe(selectedNonCoffe, selectedPromo);
          }
        } else {
          // Jika promo tidak dipilih atau "-" yang dipilih, hitung harga normal tanpa
          // promo
          int hargaMenuMakanan = (selectedMakanan != null && !selectedMakanan.equals("-"))
              ? Model.getHargaMenuMakanan(selectedMakanan)
              : 0;
          int hargaMenuCoffe = (selectedCoffe != null && !selectedCoffe.equals("-"))
              ? Model.getHargaMenuCoffe(selectedCoffe)
              : 0;
          int hargaMenuNonCoffe = (selectedNonCoffe != null && !selectedNonCoffe.equals("-"))
              ? Model.getHargaMenuNonCoffe(selectedNonCoffe)
              : 0;

          hargaPromo = 0; // Reset hargaPromo to 0 when no promo is selected
          hargaTransaksi = (hargaMenuMakanan * jumlahMakanan) + (hargaMenuCoffe * jumlahCoffe)
              + (hargaMenuNonCoffe * jumlahNonCoffe);
        }

        int hargaTotal = hargaTransaksi - hargaPromo;
        String promoTotal = Integer.toString(hargaTotal);
        txtHargaTotalTransaksi.setText(promoTotal);
      }
    });

    btnHapusInputTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        pilihMejaTransaksi.setSelectedItem("-");
        txtDeskripsiTransaksi.setText(null);
        pilihMakananTransaksi.setSelectedItem("-");
        pilihCoffeTransaksi.setSelectedItem("-");
        pilihNonCoffeTransaksi.setSelectedItem("-");
        pilihPromoTransaksi.setSelectedItem("-");
        txtJumlahMakananTransaksi.setText(null);
        txtJumlahCoffeTransaksi.setText(null);
        txtJumlahNonCoffeTransaksi.setText(null);
        txtHargaMakananTransaksi.setText(null);
        txtHargaCoffeTransaksi.setText(null);
        txtHargaNonCoffeTransaksi.setText(null);
      }
    });

    btnKembaliTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksi();
      }
    });

    btnSimpanTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihMitraTransaksi.getSelectedItem() == null
            || pilihMejaTransaksi.getSelectedItem() == null
            || txtDeskripsiTransaksi.getText().trim().isEmpty()
            || pilihPembayaranTransaksi.getSelectedItem() == null) {
          cDashboardCustomerView.this.setVisible(false);
          if (pilihMitraTransaksi.getSelectedItem() == null
              || pilihMitraTransaksi.getSelectedItem().toString().trim().equals("-")) {
            content.add(errorMitraTransaksi);
          } else {
            content.remove(errorMitraTransaksi);
          }
          if (pilihMejaTransaksi.getSelectedItem() == null
              || pilihMejaTransaksi.getSelectedItem().toString().trim().equals("-")) {
            content.add(errorMejaTransaksi);
          } else {
            content.remove(errorMejaTransaksi);
          }
          if (txtDeskripsiTransaksi.getText().trim().isEmpty()) {
            content.add(errorDeskripsiTransaksi);
          } else {
            content.remove(errorDeskripsiTransaksi);
          }
          if (pilihPromoTransaksi.getSelectedItem() == null
              || pilihPromoTransaksi.getSelectedItem().toString().trim().equals("-")) {
            content.add(errorPromoTransaksi);
          } else {
            content.remove(errorPromoTransaksi);
          }
          cDashboardCustomerView.this.setVisible(true);
        } else {
          Object[] messagePembayaran = { "Pilih Pembayaran", pilihPembayaranTransaksi };
          JOptionPane.showMessageDialog(null, messagePembayaran, "PEMBAYARAN",
              JOptionPane.PLAIN_MESSAGE);

          // Pertama, minta pengguna untuk memasukkan uang
          String checkoutTransaksi = JOptionPane.showInputDialog(null, "Masukan Uang!", "Input",
              JOptionPane.PLAIN_MESSAGE);

          if (checkoutTransaksi != null && !checkoutTransaksi.trim().isEmpty()) {
            try {
              String selectedMitra = (String) pilihMitraTransaksi.getSelectedItem();
              int idMitra = Integer.parseInt(selectedMitra.split(" - ")[0]);
              String mejaTransaksi = (String) pilihMejaTransaksi.getSelectedItem();
              String mitraTransaksi = (String) pilihMitraTransaksi.getSelectedItem();
              String deskripsiTransaksi = txtDeskripsiTransaksi.getText();
              String makananTransaksi = (String) pilihMakananTransaksi.getSelectedItem();
              String coffeTransaksi = (String) pilihCoffeTransaksi.getSelectedItem();
              String nonCoffeTransaksi = (String) pilihNonCoffeTransaksi.getSelectedItem();
              String promoTransaksi = (String) pilihPromoTransaksi.getSelectedItem();
              String bayarTransaksi = (String) pilihPembayaranTransaksi.getSelectedItem();
              int jumlahMakanan = Integer.valueOf(txtJumlahMakananTransaksi.getText());
              int jumlahCoffe = Integer.valueOf(txtJumlahCoffeTransaksi.getText());
              int jumlahNonCoffe = Integer.valueOf(txtJumlahNonCoffeTransaksi.getText());
              int hargaMakanan = Integer.valueOf(txtHargaMakananTransaksi.getText());
              int hargaCoffe = Integer.valueOf(txtHargaCoffeTransaksi.getText());
              int hargaNonCoffe = Integer.valueOf(txtHargaNonCoffeTransaksi.getText());
              int hargaTransaksi = Integer.valueOf(txtHargaTotalTransaksi.getText());
              int uangTransaksi = Integer.valueOf(checkoutTransaksi.trim());
              int kembalianTransaksi = uangTransaksi - hargaTransaksi;

              int hargaPromo = 0; // Masukkan ke variable ini jika promo dipilih

              if (promoTransaksi != null && !promoTransaksi.equals("-")) {
                if (makananTransaksi != null && !makananTransaksi.equals("-")) {
                  hargaPromo += Model.getPromoMakanan(makananTransaksi, promoTransaksi);
                }
                if (coffeTransaksi != null && !coffeTransaksi.equals("-")) {
                  hargaPromo += Model.getPromoCoffe(coffeTransaksi, promoTransaksi);
                }
                if (nonCoffeTransaksi != null && !nonCoffeTransaksi.equals("-")) {
                  hargaPromo += Model.getPromoNonCoffe(nonCoffeTransaksi, promoTransaksi);
                }
              } else {
                // Handle the case when promoTransaksi equals "-"
                // For example, set hargaPromo to 0 or any default value if needed
                hargaPromo = 0; // Default value when promo is "-"
              }

              String pembayaranTransaksi = "Forque\n\n"
                  + "======================================================\n"
                  + "Jl. Jagal No.3A RT 007/004, Jl. Jagal, Rangkapan Jaya,\n"
                  + "Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435\n"
                  + "======================================================\n"
                  + String.format("%-44s: CS%s", "idCustomer", idCustomer) + "\n"
                  + String.format("%-44s: MI%s", "Mitra", mitraTransaksi) + "\n"
                  + String.format("%-44s: %s", "Nomor Meja", pilihMejaTransaksi.getSelectedItem()) + "\n"
                  + String.format("%-44s: %s", "Pembayaran", pilihPembayaranTransaksi.getSelectedItem()) + "\n"
                  + String.format("%-49s: %s", "Promo", pilihPromoTransaksi.getSelectedItem()) + "\n"
                  + String.format("%-38s: %s", "Deskripsi Pesanan", txtDeskripsiTransaksi.getText()) + "\n"
                  + "======================================================\n"
                  + String.format("%-60s %-40s %-10s", pilihMakananTransaksi.getSelectedItem(),
                      txtJumlahMakananTransaksi.getText(), txtHargaMakananTransaksi.getText())
                  + "\n"
                  + String.format("%-60s %-40s %-10s", pilihCoffeTransaksi.getSelectedItem(),
                      txtJumlahCoffeTransaksi.getText(), txtHargaCoffeTransaksi.getText())
                  + "\n"
                  + String.format("%-60s %-40s %-10s", pilihNonCoffeTransaksi.getSelectedItem(),
                      txtJumlahNonCoffeTransaksi.getText(), txtHargaNonCoffeTransaksi.getText())
                  + "\n"
                  + "=======================================================\n"
                  + String.format("%-80s Harga Total          : %s", "", txtHargaTotalTransaksi.getText()) + "\n"
                  + String.format("%-80s Harga Promo          : %s", "", hargaPromo) + "\n"
                  + String.format("%-80s Uang                 : %s", "", uangTransaksi) + "\n"
                  + String.format("%-80s Kembalian            : %s", "", kembalianTransaksi) + "\n"
                  + "=======================================================\n"
                  + "---------------TERIMAKASIH BY ARCOO NGAWI---------------\n"
                  + "=======================================================\n"

                  + "\n\n\n";

              // Jika input valid, tampilkan konfirmasi pembayaran
              Object[] options = { "IYA", "BATAL" };
              int konfirmasi = JOptionPane.showOptionDialog(
                  null,
                  pembayaranTransaksi,
                  "Pembayaran",
                  JOptionPane.DEFAULT_OPTION,
                  JOptionPane.QUESTION_MESSAGE,
                  null,
                  options,
                  options[0]);

              if (konfirmasi == 0) {
                if (Model.tambahTransaksiOnline(idMitra, idCustomer, makananTransaksi, coffeTransaksi,
                    nonCoffeTransaksi, jumlahMakanan, jumlahCoffe, jumlahNonCoffe, hargaMakanan, hargaCoffe,
                    hargaNonCoffe, promoTransaksi, mejaTransaksi, deskripsiTransaksi, hargaTransaksi, hargaPromo,
                    bayarTransaksi, uangTransaksi, kembalianTransaksi)) {
                  // kalau berhasil
                  JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi berhasil",
                      "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                  pilihMejaTransaksi.setSelectedItem("-");
                  txtDeskripsiTransaksi.setText(null);
                  pilihMakananTransaksi.setSelectedItem("-");
                  pilihCoffeTransaksi.setSelectedItem("-");
                  pilihNonCoffeTransaksi.setSelectedItem("-");
                  pilihPromoTransaksi.setSelectedItem("-");
                  txtJumlahMakananTransaksi.setText(null);
                  txtJumlahCoffeTransaksi.setText(null);
                  txtJumlahNonCoffeTransaksi.setText(null);
                  txtHargaMakananTransaksi.setText(null);
                  txtHargaCoffeTransaksi.setText(null);
                  txtHargaNonCoffeTransaksi.setText(null);
                  JOptionPane.showMessageDialog(null, "Pembayaran berhasil!", "Pembayaran",
                      JOptionPane.INFORMATION_MESSAGE);
                } else {
                  // kalau tidak berhasil
                  JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Gagal!", "Gagal",
                      JOptionPane.ERROR_MESSAGE);
                }
              } else {
                JOptionPane.showMessageDialog(null, "Pembayaran dibatalkan.", "Dibatalkan",
                    JOptionPane.WARNING_MESSAGE);
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Input tidak valid. Masukkan angka yang benar.", "Error",
                  JOptionPane.ERROR_MESSAGE);
            }
          } else {
            JOptionPane.showMessageDialog(null, "Input tidak valid. Masukkan angka yang benar.", "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    labelInputTransaksi.setForeground(cColor.WHITE);

    content.add(labelInputTransaksi);
    content.add(labelMitraTransaksi);
    content.add(pilihMitraTransaksi);
    content.add(pilihMakananTransaksi);
    content.add(pilihCoffeTransaksi);
    content.add(pilihNonCoffeTransaksi);
    content.add(labelMejaTransaksi);
    content.add(pilihMejaTransaksi);
    content.add(labelDeskripsiTransaksi);
    content.add(txtDeskripsiTransaksi);
    content.add(labelMakananTransaksi);
    content.add(labelCoffeTransaksi);
    content.add(labelNonCoffeTransaksi);
    content.add(labelJumlahMakananTransaksi);
    content.add(labelJumlahCoffeTransaksi);
    content.add(labelJumlahNonCoffeTransaksi);
    content.add(labelHargaMakananTransaksi);
    content.add(labelHargaCoffeTransaksi);
    content.add(labelHargaNonCoffeTransaksi);
    content.add(txtJumlahMakananTransaksi);
    content.add(txtJumlahCoffeTransaksi);
    content.add(txtJumlahNonCoffeTransaksi);
    content.add(txtHargaMakananTransaksi);
    content.add(txtHargaCoffeTransaksi);
    content.add(txtHargaNonCoffeTransaksi);
    content.add(labelHargaTotalTransaksi);
    content.add(txtHargaTotalTransaksi);
    content.add(labelPromoTransaksi);
    content.add(pilihPromoTransaksi);

    content.add(btnSimpanTransaksi);
    content.add(btnHapusInputTransaksi);
    content.add(btnKembaliTransaksi);

    content.add(panelInputTransaksi);

    setVisible(true);
  }

  private void updateUbahTotalHarga() {
    int makananTotal = 0;
    int coffeTotal = 0;
    int nonCoffeTotal = 0;

    try {
      int jumlahMakanan = Integer.parseInt(txtJumlahMakananUbahTransaksi.getText());
      int hargaMakanan = Integer.parseInt(txtHargaMakananUbahTransaksi.getText());
      makananTotal = jumlahMakanan * hargaMakanan;
    } catch (NumberFormatException e) {
      // handle error
    }

    try {
      int jumlahCoffe = Integer.parseInt(txtJumlahCoffeUbahTransaksi.getText());
      int hargaCoffe = Integer.parseInt(txtHargaCoffeUbahTransaksi.getText());
      coffeTotal = jumlahCoffe * hargaCoffe;
    } catch (NumberFormatException e) {
      // handle error
    }

    try {
      int jumlahNonCoffe = Integer.parseInt(txtJumlahNonCoffeUbahTransaksi.getText());
      int hargaNonCoffe = Integer.parseInt(txtHargaNonCoffeUbahTransaksi.getText());
      nonCoffeTotal = jumlahNonCoffe * hargaNonCoffe;
    } catch (NumberFormatException e) {
      // handle error
    }

    int totalHarga = makananTotal + coffeTotal + nonCoffeTotal;
    txtHargaTotalUbahTransaksi.setText(String.valueOf(totalHarga));
  }

  private void updateTotalHarga() {
    int makananTotal = 0;
    int coffeTotal = 0;
    int nonCoffeTotal = 0;

    try {
      int jumlahMakanan = Integer.parseInt(txtJumlahMakananTransaksi.getText());
      int hargaMakanan = Integer.parseInt(txtHargaMakananTransaksi.getText());
      makananTotal = jumlahMakanan * hargaMakanan;
    } catch (NumberFormatException e) {
      // handle error
    }

    try {
      int jumlahCoffe = Integer.parseInt(txtJumlahCoffeTransaksi.getText());
      int hargaCoffe = Integer.parseInt(txtHargaCoffeTransaksi.getText());
      coffeTotal = jumlahCoffe * hargaCoffe;
    } catch (NumberFormatException e) {
      // handle error
    }

    try {
      int jumlahNonCoffe = Integer.parseInt(txtJumlahNonCoffeTransaksi.getText());
      int hargaNonCoffe = Integer.parseInt(txtHargaNonCoffeTransaksi.getText());
      nonCoffeTotal = jumlahNonCoffe * hargaNonCoffe;
    } catch (NumberFormatException e) {
      // handle error
    }

    int totalHarga = makananTotal + coffeTotal + nonCoffeTotal;
    txtHargaTotalTransaksi.setText(String.valueOf(totalHarga));
  }

  private void initsDataHistory() {
    idSelected = null;
    resetSidebar();
    menuHistory.setBackground(cColor.WHITE);
    menuHistory.setForeground(cColor.GREEN);
    refreshContent();
    menuHistory.setSidebarAktif();
    menuTitle.setText("History Transaksi");

    btnTambahTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputTransaksi();
      }
    });

    btnDetailTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataTransaksi.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblDataTransaksi.getValueAt(selectedIndex, 0).toString();
          int idTransaksi = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          String transaksiId = Model.getDetailOnlineDiproses(idTransaksi)[0].toString();
          String mitraId = Model.getDetailOnlineDiproses(idTransaksi)[1].toString();
          String customerId = Model.getDetailOnlineDiproses(idTransaksi)[2].toString();
          String namaMitra = Model.getDetailOnlineDiproses(idTransaksi)[3].toString();
          String namaCustomer = Model.getDetailOnlineDiproses(idTransaksi)[4].toString();
          String waktuTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[5].toString();
          String makananTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[6].toString();
          String coffeTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[7].toString();
          String nonCoffeTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[8].toString();
          String jumlahMakanan = Model.getDetailOnlineDiproses(idTransaksi)[9].toString();
          String jumlahCoffe = Model.getDetailOnlineDiproses(idTransaksi)[10].toString();
          String jumlahNonCoffe = Model.getDetailOnlineDiproses(idTransaksi)[11].toString();
          String hargaMakanan = Model.getDetailOnlineDiproses(idTransaksi)[12].toString();
          String hargaCoffe = Model.getDetailOnlineDiproses(idTransaksi)[13].toString();
          String hargaNonCoffe = Model.getDetailOnlineDiproses(idTransaksi)[14].toString();
          String promoTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[15].toString();
          String mejaTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[16].toString();
          String deskripsiTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[17].toString();
          String hargaTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[18].toString();
          String hargaPromo = Model.getDetailOnlineDiproses(idTransaksi)[19].toString();
          String bayarTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[20].toString();
          String uangTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[21].toString();
          String kembalianTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[22].toString();
          String statusTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[23].toString();

          String detailTransaksi = "\tForque" + "\n\n"
              + "======================================================\n"
              + "Jl. Jagal No.3A RT 007/004, Jl. Jagal, Rangkapan Jaya,\n"
              + "Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435\n"
              + "====================================================\n"
              + String.format("%-40s:  %s", "Tanggal/Waktu", waktuTransaksi) + "\n"
              + String.format("%-40s:  TR%s", "ID Transaksi", transaksiId) + "\n"
              + String.format("%-44s:  MI%s", "ID Mitra", mitraId) + "\n"
              + String.format("%-39s: %s", "Nama Mitra", namaMitra) + "\n"
              + "====================================================\n"
              + String.format("%-44s:  CS%s", "ID Mitra", customerId) + "\n"
              + String.format("%-44s: %s", "Status Transaksi", statusTransaksi) + "\n"
              + String.format("%-44s: %s", "Nomor Meja", mejaTransaksi) + "\n"
              + String.format("%-39s: %s", "Nama Pemesan", namaCustomer) + "\n"
              + String.format("%-44s: %s", "Pembayaran", bayarTransaksi) + "\n"
              + String.format("%-49s: %s", "Promo", promoTransaksi) + "\n"
              + String.format("%-38s: %s", "Deskripsi Pesanan", deskripsiTransaksi) + "\n"
              + "====================================================\n"
              + String.format("%-60s %-30s %-10s", makananTransaksi, jumlahMakanan, hargaMakanan) + "\n"
              + String.format("%-60s %-30s %-10s", coffeTransaksi, jumlahCoffe, hargaCoffe) + "\n"
              + String.format("%-60s %-30s %-10s", nonCoffeTransaksi, jumlahNonCoffe, hargaNonCoffe) + "\n"
              + "====================================================\n"
              + String.format("%-80s Harga Total   : %s", "", hargaTransaksi) + "\n"
              + String.format("%-80s Harga Promo          : %s", "", hargaPromo) + "\n"
              + String.format("%-80s Uang                 : %s", "", uangTransaksi) + "\n"
              + String.format("%-80s Kembalian            : %s", "", kembalianTransaksi) + "\n"
              + "=======================================================\n"
              + "---------------TERIMAKASIH BY ARCOO NGAWI---------------\n"
              + "=======================================================\n"
              + "\n";

          Object[] options = { "KEMBALI" };
          JOptionPane.showOptionDialog(
              null,
              detailTransaksi,
              "detailTransaksi",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

        } else {
          // Jika tidak ada yang dipilih
          JOptionPane.showMessageDialog(cDashboardCustomerView.this,
              "Pilih data terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblDataTransaksi = new cTable(Model.getAllOnlineDiproses());

    tblDataTransaksi.getColumnModel().getColumn(0).setMinWidth(80);
    tblDataTransaksi.getColumnModel().getColumn(0).setMaxWidth(80);
    tblDataTransaksi.getColumnModel().getColumn(0).setWidth(80);

    tblDataTransaksi.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(1).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(2).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(5).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(5).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(5).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(6).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(6).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(6).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(7).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(7).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(7).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(8).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(8).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(8).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(9).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(9).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(9).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(10).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(10).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(10).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(11).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(11).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(11).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(12).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(12).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(12).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(13).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(13).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(13).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(14).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(14).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(14).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(15).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(15).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(15).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(16).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(16).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(16).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(17).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(17).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(17).setWidth(0);

    tblDataTransaksi.getColumnModel().getColumn(18).setMinWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(18).setMaxWidth(0);
    tblDataTransaksi.getColumnModel().getColumn(18).setWidth(0);

    spDataTransaksi = new cScrollPane(tblDataTransaksi, 0, 150, 1100, 400);

    labelPilihTransaksi.setForeground(cColor.WHITE);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    txtCariTransaksi.setBorder(titledBorder);
    txtCariTransaksi.setSize(300, 45);

    content.add(spDataTransaksi);
    content.add(labelPilihTransaksi);
    content.add(txtCariTransaksi);
    content.add(panelHeaderTransaksi);

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

    labelInfoDataAkun.setForeground(cColor.WHITE);

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

    content.add(panelHeaderAkun);

    setVisible(true);
  }

}