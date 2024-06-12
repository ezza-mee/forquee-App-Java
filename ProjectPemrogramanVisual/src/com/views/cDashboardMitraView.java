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

  // componetn of data beranda
  private cDateTime labelDateTimeBeranda = new cDateTime(720, 15, 300);
  private cLabelInfo labelInfoSaldoMitraBeranda = new cLabelInfo("Saldo Anda", 40, 40, 200, 40);
  private cBigFont valueInfoSaldoMitraBeranda = new cBigFont("0", 40, 60);
  private cLabelInfo labelJumlahMenuBeranda = new cLabelInfo("Jumlah Data Menu", 420, 40, 400, 40);
  private cBigFont valueJumlahMenuBeranda = new cBigFont("0", 420, 60);
  private cLabelInfo labelJumlahMejaBeranda = new cLabelInfo("Jumlah Data Meja", 40, 180, 400, 40);
  private cBigFont valueJumlahMejaBeranda = new cBigFont("0", 40, 205);
  private cLabelInfo labelJumlahPromoBeranda = new cLabelInfo("Jumlah Data Promo", 420, 180, 400, 40);
  private cBigFont valueJumlahPromoBeranda = new cBigFont("0", 420, 205);
  private cLabelInfo labelTransaksiBeranda = new cLabelInfo("Jumlah Data Transaksi ", 40, 280, 400, 40);
  private cBigFont valueTransaksiBeranda = new cBigFont("0", 40, 305);
  private cLabelInfo labelCustomerBeranda = new cLabelInfo("Jumlah Data Customer", 420, 280, 400, 40);
  private cBigFont valueCustomerBeranda = new cBigFont("0", 420, 305);
  private cLabelInfo labelKaryawanBeranda = new cLabelInfo("Jumlah Data Karyawan", 40, 380, 400, 40);
  private cBigFont valueKaryawanBeranda = new cBigFont("0", 40, 405);
  private cLabelInfo labelOrderBahanBeranda = new cLabelInfo("Jumlah Data Order Bahan", 420, 380, 400, 40);
  private cBigFont valueOrderBahanBeranda = new cBigFont("0", 420, 405);

  // component of data menu
  private cButton btnMenuMakanan = new cButton("Makanan", 40, 40, 150, 30, 20);
  private cButton btnMenuCoffe = new cButton("Coffe", 230, 40, 150, 30, 20);
  private cButton btnMenuNonCoffe = new cButton("Non Coffe", 420, 40, 150, 30, 20);
  private cButton btnTambahMakanan = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliMakanan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnTambahCoffe = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnTambahNonCoffe = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliNonCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of data menu makanan
  private cLabelInfo labelCariMenuMakanan = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariMenuMakanan = new cTextField(100, 100, 300);

  // component of data menu coffe
  private cLabelInfo labelCariMenuCoffe = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariMenuCoffe = new cTextField(100, 100, 300);

  // component of data menu non coffe
  private cLabelInfo labelCariMenuNonCoffe = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariMenuNonCoffe = new cTextField(100, 100, 300);

  // component of input data menu makanan
  private cLabelInfo labelInputMenuMakanan = new cLabelInfo("Masukan Data Menu Makanan!", 190, 40, 400, 40);
  private cLabelInfo labelNamaMakanan = new cLabelInfo("Nama Menu", 190, 90, 300, 40);
  private cTextField txtNamaMakanan = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaMakanan = new cErrorLabel("Nama Makanan tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahMakanan = new cLabelInfo("Jumlah Makanan", 190, 180, 300, 40);
  private cTextField txtJumlahMakanan = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahMakanan = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelHargaMakanan = new cLabelInfo("Harga Makanan", 190, 270, 300, 40);
  private cTextField txtHargaMakanan = new cTextField(190, 302, 300);
  private cErrorLabel errorHargaMakanan = new cErrorLabel("Harga Makanan tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelDeskripsiMakanan = new cLabelInfo("Deskripsi Makanan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiMakanan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiMakanan = new cErrorLabel("Deskripsi Makanan tidak boleh Kosong!", 580, 235, 300);
  private cLabelInfo labelHargaTotalMakanan = new cLabelInfo("Harga Total Makanan", 580, 270, 300, 40);
  private cTextField txtHargaTotalMakanan = new cTextField(580, 302, 300);
  private cButton btnHapusMakanan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanMakanan = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of input data menu Coffe
  private cLabelInfo labelInputMenuCoffe = new cLabelInfo("Masukan Data Menu Coffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaCoffe = new cLabelInfo("Nama Menu", 190, 90, 300, 40);
  private cTextField txtNamaCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaCoffe = new cErrorLabel("Nama Coffe tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahCoffe = new cLabelInfo("Jumlah Coffe", 190, 180, 300, 40);
  private cTextField txtJumlahCoffe = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahCoffe = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelHargaCoffe = new cLabelInfo("Harga Coffe", 190, 270, 300, 40);
  private cTextField txtHargaCoffe = new cTextField(190, 302, 300);
  private cErrorLabel errorHargaCoffe = new cErrorLabel("Harga Coffe tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelDeskripsiCoffe = new cLabelInfo("Deskripsi Coffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiCoffe = new cErrorLabel("Deskripsi Coffe tidak boleh Kosong!", 580, 235, 300);
  private cLabelInfo labelHargaTotalCoffe = new cLabelInfo("Harga Total Coffe", 580, 270, 300, 40);
  private cTextField txtHargaTotalCoffe = new cTextField(580, 302, 300);
  private cButton btnHapusCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of input data menu NonCoffe
  private cLabelInfo labelInputMenuNonCoffe = new cLabelInfo("Masukan Data Menu Non Coffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaNonCoffe = new cLabelInfo("Nama Menu", 190, 90, 300, 40);
  private cTextField txtNamaNonCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaNonCoffe = new cErrorLabel("Nama Non Coffe tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahNonCoffe = new cLabelInfo("Jumlah NonCoffe", 190, 180, 300, 40);
  private cTextField txtJumlahNonCoffe = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahNonCoffe = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelHargaNonCoffe = new cLabelInfo("Harga Non Coffe", 190, 270, 300, 40);
  private cTextField txtHargaNonCoffe = new cTextField(190, 302, 300);
  private cErrorLabel errorHargaNonCoffe = new cErrorLabel("Harga Non Coffe tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelDeskripsiNonCoffe = new cLabelInfo("Deskripsi NonCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiNonCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiNonCoffe = new cErrorLabel("Deskripsi Non Coffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelHargaTotalNonCoffe = new cLabelInfo("Harga Total NonCoffe", 580, 270, 300, 40);
  private cTextField txtHargaTotalNonCoffe = new cTextField(580, 302, 300);
  private cButton btnHapusNonCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanNonCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);

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

    main.add(labelDateTimeBeranda);

    content.add(labelInfoSaldoMitraBeranda);
    content.add(valueInfoSaldoMitraBeranda);
    content.add(labelJumlahMenuBeranda);
    content.add(valueJumlahMenuBeranda);
    content.add(labelJumlahMejaBeranda);
    content.add(valueJumlahMejaBeranda);
    content.add(labelJumlahPromoBeranda);
    content.add(valueJumlahPromoBeranda);
    content.add(labelTransaksiBeranda);
    content.add(valueTransaksiBeranda);
    content.add(labelCustomerBeranda);
    content.add(valueCustomerBeranda);
    content.add(labelKaryawanBeranda);
    content.add(valueKaryawanBeranda);
    content.add(labelOrderBahanBeranda);
    content.add(valueOrderBahanBeranda);

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
    content.add(btnTambahMakanan);
    content.add(btnKembaliMakanan);
    content.add(btnTambahCoffe);
    content.add(btnKembaliCoffe);
    content.add(btnTambahNonCoffe);
    content.add(btnKembaliNonCoffe);

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

    btnTambahMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputMenuMakanan();
      }
    });

    content.add(btnMenuMakanan);
    content.add(btnMenuCoffe);
    content.add(btnMenuNonCoffe);
    content.add(btnTambahMakanan);

    content.add(labelCariMenuMakanan);
    content.add(txtCariMenuMakanan);
    setVisible(true);
  }

  private void initsInputMenuMakanan() {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Tambah Menu Makanan");

    btnHapusMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaMakanan.setText(null);
        txtJumlahMakanan.setText(null);
        txtDeskripsiMakanan.setText(null);
        txtHargaMakanan.setText(null);
        txtHargaTotalMakanan.setText(null);
      }
    });

    btnKembaliMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsMenuMakanan();
      }
    });

    content.add(labelInputMenuMakanan);
    content.add(labelNamaMakanan);
    content.add(txtNamaMakanan);
    content.add(errorNamaMakanan);
    content.add(labelJumlahMakanan);
    content.add(txtJumlahMakanan);
    content.add(errorJumlahMakanan);
    content.add(labelHargaMakanan);
    content.add(txtHargaMakanan);
    content.add(errorHargaMakanan);
    content.add(labelDeskripsiMakanan);
    content.add(txtDeskripsiMakanan);
    content.add(errorDeskripsiMakanan);
    content.add(labelHargaTotalMakanan);
    content.add(txtHargaTotalMakanan);
    content.add(btnSimpanMakanan);
    content.add(btnHapusMakanan);
    content.add(btnKembaliMakanan);

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

    btnTambahCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputMenuCoffe();
      }
    });

    content.add(btnMenuMakanan);
    content.add(btnMenuCoffe);
    content.add(btnMenuNonCoffe);
    content.add(btnTambahCoffe);

    content.add(labelCariMenuCoffe);
    content.add(txtCariMenuCoffe);
    setVisible(true);
  }

  private void initsInputMenuCoffe() {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Tambah Menu Coffe");

    btnHapusCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaCoffe.setText(null);
        txtJumlahCoffe.setText(null);
        txtDeskripsiCoffe.setText(null);
        txtHargaCoffe.setText(null);
        txtHargaTotalCoffe.setText(null);
      }
    });

    btnKembaliCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsMenuCoffe();
      }
    });

    content.add(labelInputMenuCoffe);
    content.add(labelNamaCoffe);
    content.add(txtNamaCoffe);
    content.add(errorNamaCoffe);
    content.add(labelJumlahCoffe);
    content.add(txtJumlahCoffe);
    content.add(errorJumlahCoffe);
    content.add(labelHargaCoffe);
    content.add(txtHargaCoffe);
    content.add(errorHargaCoffe);
    content.add(labelDeskripsiCoffe);
    content.add(txtDeskripsiCoffe);
    content.add(errorDeskripsiCoffe);
    content.add(labelHargaTotalCoffe);
    content.add(txtHargaTotalCoffe);
    content.add(btnSimpanCoffe);
    content.add(btnHapusCoffe);
    content.add(btnKembaliCoffe);

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

    btnTambahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputMenuNonCoffe();
      }
    });

    content.add(btnMenuMakanan);
    content.add(btnMenuCoffe);
    content.add(btnMenuNonCoffe);
    content.add(btnTambahNonCoffe);

    content.add(labelCariMenuNonCoffe);
    content.add(txtCariMenuNonCoffe);
    setVisible(true);
  }

  private void initsInputMenuNonCoffe() {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Tambah Menu Non Coffe");

    btnHapusNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaNonCoffe.setText(null);
        txtJumlahNonCoffe.setText(null);
        txtDeskripsiNonCoffe.setText(null);
        txtHargaNonCoffe.setText(null);
        txtHargaTotalNonCoffe.setText(null);
      }
    });

    btnKembaliNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsMenuNonCoffe();
      }
    });

    content.add(labelInputMenuNonCoffe);
    content.add(labelNamaNonCoffe);
    content.add(txtNamaNonCoffe);
    content.add(errorNamaNonCoffe);
    content.add(labelJumlahNonCoffe);
    content.add(txtJumlahNonCoffe);
    content.add(errorJumlahNonCoffe);
    content.add(labelHargaNonCoffe);
    content.add(txtHargaNonCoffe);
    content.add(errorHargaNonCoffe);
    content.add(labelDeskripsiNonCoffe);
    content.add(txtDeskripsiNonCoffe);
    content.add(errorDeskripsiNonCoffe);
    content.add(labelHargaTotalNonCoffe);
    content.add(txtHargaTotalNonCoffe);
    content.add(btnSimpanNonCoffe);
    content.add(btnHapusNonCoffe);
    content.add(btnKembaliNonCoffe);

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
