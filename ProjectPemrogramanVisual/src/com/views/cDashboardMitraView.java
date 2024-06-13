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
  private cButton btnMenuMakanan = new cButton("Makanan", 450, 40, 150, 30, 20);
  private cButton btnMenuCoffe = new cButton("Coffe", 650, 40, 150, 30, 20);
private cButton btnMenuNonCoffe = new cButton("Non Coffe", 840, 40, 150, 30, 20);
  private cButton btnTambahMakanan = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliMakanan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnTambahCoffe = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnTambahNonCoffe = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliNonCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of data menu makanan
  private cLabelInfo labelCariMenuMakanan = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariMenuMakanan = new cTextField(100, 40, 300);

  // component of data menu coffe
  private cLabelInfo labelCariMenuCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariMenuCoffe = new cTextField(100, 40, 300);

  // component of data menu non coffe
  private cLabelInfo labelCariMenuNonCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariMenuNonCoffe = new cTextField(100, 40, 300);

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

  // component of input data menu Non Coffe
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

  // component of data Promo
  private cLabelInfo labelPromo = new cLabelInfo("Data Promo Menu", 40, 40, 300, 40);
  private cLabelInfo labelCariPromo = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariPromo = new cTextField(100, 100, 300);
  private cButton btnTambahPromo = new cButton("Tambah", 450, 100, 150, 30, 20);
  private cButton btnHapusDataPromo = new cButton("Hapus", 630, 100, 150, 30, 20);
  private cButton btnEditDataPromo = new cButton("Edit", 800, 100, 150, 30, 20);
  private cButton btnKembaliPromo = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of input promo
  private cLabelInfo labelInputPromo = new cLabelInfo("Masukan Data Promo!", 190, 40, 400, 40);
  private cLabelInfo labelNamaPromo = new cLabelInfo("Nama Promo", 190, 90, 300, 40);
  private cTextField txtNamaPromo = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaPromo = new cErrorLabel("Nama Promo tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahPromo = new cLabelInfo("Jumlah Promo", 190, 180, 300, 40);
  private cTextField txtJumlahPromo = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahPromo = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelPilihMenuPromo = new cLabelInfo("Menu Promo", 190, 270, 300, 40);
  private cComboBox pilihMenuPromo = new cComboBox(new String[] { "Coffe", "Non Coffe", "Makanan" }, 190, 302, 300, 30);
  private cErrorLabel errorMenuPromo = new cErrorLabel("Menu Promo tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelDeskripsiPromo = new cLabelInfo("Deskripsi Promo", 580, 90, 300, 40);
  private cTextarea txtDeskripsiPromo = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiPromo = new cErrorLabel("Deskripsi Promo tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelHargaPromo = new cLabelInfo("Harga Promo", 580, 270, 300, 40);
  private cTextField txtHargaPromo = new cTextField(580, 302, 300);
  private cErrorLabel errorHargaPromo = new cErrorLabel("Harga Promo tidak boleh Kosong!", 580, 327, 300);
  private cButton btnHapusPromo = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanPromo = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of data meja
  private cLabelInfo labelMeja = new cLabelInfo("Data Ready Meja", 40, 40, 300, 40);
  private cLabelInfo labelCariMeja = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariMeja = new cTextField(100, 100, 300);
  private cButton btnTambahMeja = new cButton("Tambah", 450, 100, 150, 30, 20);
  private cButton btnHapusDataMeja = new cButton("Hapus", 630, 100, 150, 30, 20);
  private cButton btnEditDataMeja = new cButton("Edit", 800, 100, 150, 30, 20);
  private cButton btnKembaliMeja = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of input data meja
  private cLabelInfo labelInputMeja = new cLabelInfo("Masukan Data Meja!", 190, 40, 400, 40);
  private cLabelInfo labelNomorMeja = new cLabelInfo("Nomor Meja", 190, 90, 300, 40);
  private cTextField txtNomorMeja = new cTextField(190, 120, 300);
  private cErrorLabel errorNomorMeja = new cErrorLabel("Nomor Meja tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelPilihMeja = new cLabelInfo("Jenis Meja", 190, 180, 300, 40);
  private cComboBox pilihMeja = new cComboBox(new String[] { "VIP", "Reguler", "Non Reguler" }, 190, 210, 300, 30);
  private cErrorLabel errorMeja = new cErrorLabel("Jenis Meja tidak boleh Kosong!", 190, 235, 300);
  private cLabelInfo labelDeskripsiMeja = new cLabelInfo("Deskripsi Meja", 580, 90, 300, 40);
  private cTextarea txtDeskripsiMeja = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiMeja = new cErrorLabel("Deskripsi Meja tidak boleh Kosong!", 580, 235,
      300);
  private cButton btnHapusMeja = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanMeja = new cButton("Simpan", 730, 480, 150, 30, 20);

  // componenet of data customer
  private cLabelInfo labelCustomer = new cLabelInfo("Data Customer Aktif", 40, 40, 300, 40);
  private cLabelInfo labelCariCustomer = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariCustomer = new cTextField(100, 100, 300);

  // component of data karyawan
  private cLabelInfo labelKaryawan = new cLabelInfo("Data Ready Karyawan", 40, 40, 300, 40);
  private cLabelInfo labelCariKaryawan = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariKaryawan = new cTextField(100, 100, 300);
  private cButton btnTambahKaryawan = new cButton("Tambah", 450, 100, 150, 30, 20);
  private cButton btnHapusDataKaryawan = new cButton("Hapus", 630, 100, 150, 30, 20);
  private cButton btnEditDataKaryawan = new cButton("Edit", 800, 100, 150, 30, 20);
  private cButton btnKembaliKaryawan = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of input data karyawan
  private cLabelInfo labelDataKaryawan = new cLabelInfo("Masukan Data Karyawan!", 190, 30, 400, 40);
  private cLabelInfo labelNamaKaryawan = new cLabelInfo("Nama", 190, 100, 100, 40);
  private cLabelInfo labelNomorHpKaryawan = new cLabelInfo("Nomor Hp", 190, 200, 200, 40);
  private cLabelInfo labelEmailKaryawan = new cLabelInfo("Email", 190, 300, 100, 40);
  private cLabelInfo labelAlamatKaryawan = new cLabelInfo("Alamat", 580, 200, 100, 40);
  private cLabelInfo labelJobdeskKaryawan = new cLabelInfo("Pilih Jobdesk", 580, 100, 200, 40);
  private cErrorLabel errorNamaKaryawan = new cErrorLabel("Nama tidak boleh kosong!", 190, 165, 300);
  private cErrorLabel errorNomorHpKaryawan = new cErrorLabel("Nomor Hp tidak boleh Kosong!", 190, 265, 300);
  private cErrorLabel errorEmailKaryawan = new cErrorLabel("Email tidak boleh Kosong!", 190, 365, 300);
  private cErrorLabel errorJobdeskKaryawan = new cErrorLabel("Jobdek tidak boleh Kosong!", 580, 165, 300);
  private cErrorLabel errorAlamatKaryawan = new cErrorLabel("Alamat tidak boleh Kosong!", 580, 380, 300);
  private cTextField txtNamaKaryawan = new cTextField(190, 135, 300);
  private cTextField txtNomorHpKaryawan = new cTextField(190, 235, 300);
  private cTextField txtEmailKaryawan = new cTextField(190, 335, 300);
  private cTextarea txtAlamatKaryawan = new cTextarea(580, 235, 300, 150, true);
  private cComboBox jobdeskKaryawan = new cComboBox(
      new String[] { "Operator Mesin", "Petugas Layanan", "Teknisi Mesin", "Administrasi",
          "Supervisor", "Staf", "Kasir" },
      580, 135, 300, 30);
  private cButton btnHapusKaryawan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanKaryawan = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of data Transaksi
  private cButton btnTransaksiMakanan = new cButton("Makanan", 450, 40, 150, 30, 20);
  private cButton btnTransaksiCoffe = new cButton("Coffe", 650, 40, 150, 30, 20);
  private cButton btnTransaksiNonCoffe = new cButton("Non Coffe", 840, 40, 150, 30, 20);
  private cButton btnTambahTransaksiMakanan = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliTransaksiMakanan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnTambahTransaksiCoffe = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliTransaksiCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnTambahTransaksiNonCoffe = new cButton("Tambah", 850, 480, 150, 30, 20);
  private cButton btnKembaliTransaksiNonCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of data menu makanan
  private cLabelInfo labelCariTransaksiMakanan = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariTransaksiMakanan = new cTextField(100, 40, 300);

  // component of data menu coffe
  private cLabelInfo labelCariTransaksiCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariTransaksiCoffe = new cTextField(100, 40, 300);

  // component of data menu non coffe
  private cLabelInfo labelCariTransaksiNonCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariTransaksiNonCoffe = new cTextField(100, 40, 300);

  // component of input data Transaksi Makanan
  private cLabelInfo labelInputTransaksiMakanan = new cLabelInfo("Masukan Data Transaksi Makanan!", 190, 40, 400, 40);
  private cLabelInfo labelNamaTransaksiMakanan = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaTransaksiMakanan = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaTransaksiMakanan = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihTransaksiMakanan = new cLabelInfo("Menu Makanan", 190, 180, 300, 40);
  private cComboBox pilihTransaksiMakanan = new cComboBox(new String[] { "Nasi Goreng", "Seblak", "Bakso Aci" }, 190,
      210, 300, 30);
  private cErrorLabel errorTransaksiMakanan = new cErrorLabel("Menu Makanan tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiTransaksiMakanan = new cLabelInfo("Deskripsi Makanan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiMakanan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiMakanan = new cErrorLabel(
      "Deskripsi Makanan tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiMakanan = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cComboBox pilihMejaTransaksiMakanan = new cComboBox(new String[] { "VIP", "Reguler", "Non Reguler" }, 190,
      302, 300, 30);
  private cErrorLabel errorMejaTransaksiMakanan = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahTransaksiMakanan = new cLabelInfo("Jumlah Makanan", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiMakanan = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiMakanan = new cErrorLabel("Jumlah Makanan tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelPromoTransaksiMakanan = new cLabelInfo("Pilih Promo", 190, 360, 300, 40);
  private cComboBox promoTransaksiMakanan = new cComboBox(new String[] { "Paket Normal", "Paket Jomok", "Paket Gomen" },
      190, 390, 300, 30);
  private cLabelInfo labelHargaTransaksiMakanan = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiMakanan = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiMakanan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiMakanan = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of input data Transaksi Coffe
  private cLabelInfo labelInputTransaksiCoffe = new cLabelInfo("Masukan Data Transaksi Coffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaTransaksiCoffe = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaTransaksiCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaTransaksiCoffe = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihTransaksiCoffe = new cLabelInfo("Menu Coffe", 190, 180, 300, 40);
  private cComboBox pilihTransaksiCoffe = new cComboBox(new String[] { "Nasi Goreng", "Seblak", "Bakso Aci" }, 190,
      210, 300, 30);
  private cErrorLabel errorTransaksiCoffe = new cErrorLabel("Menu Coffe tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiTransaksiCoffe = new cLabelInfo("Deskripsi Coffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiCoffe = new cErrorLabel(
      "Deskripsi Coffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiCoffe = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cComboBox pilihMejaTransaksiCoffe = new cComboBox(new String[] { "VIP", "Reguler", "Non Reguler" }, 190,
      302, 300, 30);
  private cErrorLabel errorMejaTransaksiCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahTransaksiCoffe = new cLabelInfo("Jumlah Coffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiCoffe = new cErrorLabel("Jumlah Coffe tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelPromoTransaksiCoffe = new cLabelInfo("Pilih Promo", 190, 360, 300, 40);
  private cComboBox promoTransaksiCoffe = new cComboBox(new String[] { "Paket Normal", "Paket Jomok", "Paket Gomen" },
      190, 390, 300, 30);
  private cLabelInfo labelHargaTransaksiCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of input data Transaksi NonCoffe
  private cLabelInfo labelInputTransaksiNonCoffe = new cLabelInfo("Masukan Data Transaksi NonCoffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaTransaksiNonCoffe = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaTransaksiNonCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaTransaksiNonCoffe = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihTransaksiNonCoffe = new cLabelInfo("Menu NonCoffe", 190, 180, 300, 40);
  private cComboBox pilihTransaksiNonCoffe = new cComboBox(new String[] { "Nasi Goreng", "Seblak", "Bakso Aci" }, 190,
      210, 300, 30);
  private cErrorLabel errorTransaksiNonCoffe = new cErrorLabel("Menu NonCoffe tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiTransaksiNonCoffe = new cLabelInfo("Deskripsi NonCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiNonCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiNonCoffe = new cErrorLabel(
      "Deskripsi NonCoffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiNonCoffe = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cComboBox pilihMejaTransaksiNonCoffe = new cComboBox(new String[] { "VIP", "Reguler", "Non Reguler" }, 190,
      302, 300, 30);
  private cErrorLabel errorMejaTransaksiNonCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahTransaksiNonCoffe = new cLabelInfo("Jumlah NonCoffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiNonCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiNonCoffe = new cErrorLabel("Jumlah NonCoffe tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelPromoTransaksiNonCoffe = new cLabelInfo("Pilih Promo", 190, 360, 300, 40);
  private cComboBox promoTransaksiNonCoffe = new cComboBox(
      new String[] { "Paket Normal", "Paket Jomok", "Paket Gomen" },
      190, 390, 300, 30);
  private cLabelInfo labelHargaTransaksiNonCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiNonCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiNonCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiNonCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of data OrderBahan
  private cLabelInfo labelOrderBahan = new cLabelInfo("Data OrderBahan Menu", 40, 40, 300, 40);
  private cLabelInfo labelCariOrderBahan = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariOrderBahan = new cTextField(100, 100, 300);
  private cButton btnTambahOrderBahan = new cButton("Tambah", 450, 100, 150, 30, 20);
  private cButton btnHapusDataOrderBahan = new cButton("Hapus", 630, 100, 150, 30, 20);
  private cButton btnEditDataOrderBahan = new cButton("Edit", 800, 100, 150, 30, 20);
  private cButton btnKembaliOrderBahan = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of input OrderBahan
  private cLabelInfo labelInputOrderBahan = new cLabelInfo("Masukan Data Order Bahan!", 190, 40, 400, 40);
  private cLabelInfo labelJumlahOrderBahan = new cLabelInfo("Jumlah Bahan", 190, 90, 300, 40);
  private cTextField txtJumlahOrderBahan = new cTextField(190, 120, 300);
  private cErrorLabel errorJumlahOrderBahan = new cErrorLabel("Jumlah Bahan tidak boleh Kosong!", 190, 145, 400);

  private cLabelInfo labelPilihMenuOrderBahan = new cLabelInfo("Pilih Bahan", 190, 180, 300, 40);
  private cComboBox pilihMenuOrderBahan = new cComboBox(new String[] { "Coffe", "Telur", "Beras" }, 190, 210, 300,
      30);
  private cErrorLabel errorMenuOrderBahan = new cErrorLabel("Menu Bahan tidak boleh Kosong!", 190, 235, 300);

  private cLabelInfo labelPilihPTOrderBahan = new cLabelInfo("Pilih PT", 190, 270, 300, 40);
  private cComboBox pilihPTOrderBahan = new cComboBox(new String[] { "PT JOMOK", "PT NGAWI", "PT RUSDI" }, 190, 302,
      300,
      30);
  private cErrorLabel errorPTOrderBahan = new cErrorLabel("PT tidak boleh Kosong!", 190, 327, 300);

  private cLabelInfo labelHargaOrderBahan = new cLabelInfo("Harga Bahan", 190, 360, 300, 40);
  private cTextField txtHargaOrderBahan = new cTextField(190, 392, 300);

  private cLabelInfo labelDeskripsiOrderBahan = new cLabelInfo("Deskripsi Bahan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiOrderBahan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiOrderBahan = new cErrorLabel("Deskripsi Order Bahan tidak boleh Kosong!", 580, 235,
      300);

  private cLabelInfo labelAlamatOrderBahan = new cLabelInfo("Alamat", 580, 270, 300, 40);
  private cTextarea txtAlamatOrderBahan = new cTextarea(580, 300, 300, 120, true);
  private cErrorLabel errorAlamatOrderBahan = new cErrorLabel("Alamat tidak boleh Kosong!", 580, 415, 400);

  private cButton btnHapusOrderBahan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanOrderBahan = new cButton("Simpan", 730, 480, 150, 30, 20);

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
          initsLogout();
          com.main.Controller.showLoginMitra();
        }
      }
    });
    // add component default
    main.add(labelDateTimeBeranda);
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

    btnTambahPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputDataPromo();
      }
    });

    content.add(btnTambahPromo);
    content.add(btnHapusDataPromo);
    content.add(btnEditDataPromo);
    content.add(labelPromo);
    content.add(labelCariPromo);
    content.add(txtCariPromo);

    setVisible(true);
  }

  private void initsInputDataPromo() {
    idSelected = null;
    resetSidebar();
    menuDataPromo.setBackground(cColor.WHITE);
    menuDataPromo.setForeground(cColor.GREEN);
    refreshContent();
    menuDataPromo.setSidebarAktif();
    menuTitle.setText("Tambah Promo");

    btnHapusPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaPromo.setText(null);
        txtJumlahPromo.setText(null);
        txtDeskripsiPromo.setText(null);
        pilihMenuPromo.setSelectedItem("Coffe");
        txtHargaPromo.setText(null);
      }
    });

    btnKembaliPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataPromo();
      }
    });

    content.add(labelInputPromo);
    content.add(labelNamaPromo);
    content.add(txtNamaPromo);
    content.add(errorNamaPromo);
    content.add(labelJumlahPromo);
    content.add(txtJumlahPromo);
    content.add(errorJumlahPromo);
    content.add(labelHargaPromo);
    content.add(txtHargaPromo);
    content.add(errorHargaPromo);
    content.add(labelDeskripsiPromo);
    content.add(txtDeskripsiPromo);
    content.add(errorDeskripsiPromo);
    content.add(labelPilihMenuPromo);
    content.add(pilihMenuPromo);
    content.add(errorMenuPromo);
    content.add(btnSimpanPromo);
    content.add(btnHapusPromo);
    content.add(btnKembaliPromo);

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

    btnTambahMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputDataMeja();
      }
    });

    content.add(labelMeja);
    content.add(labelCariMeja);
    content.add(txtCariMeja);
    content.add(btnTambahMeja);
    content.add(btnHapusDataMeja);
    content.add(btnEditDataMeja);
    setVisible(true);
  }

  private void initsInputDataMeja() {
    idSelected = null;
    resetSidebar();
    menuDataMeja.setBackground(cColor.WHITE);
    menuDataMeja.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMeja.setSidebarAktif();
    menuTitle.setText("Data Meja");

    btnHapusPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNomorMeja.setText(null);
        txtDeskripsiMeja.setText(null);
        pilihMeja.setSelectedItem("Coffe");

      }
    });

    btnKembaliMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataMeja();
      }
    });

    content.add(labelInputMeja);
    content.add(labelNomorMeja);
    content.add(txtNomorMeja);
    content.add(errorNomorMeja);
    content.add(labelDeskripsiMeja);
    content.add(txtDeskripsiMeja);
    content.add(errorDeskripsiMeja);
    content.add(labelPilihMeja);
    content.add(pilihMeja);
    content.add(errorMeja);
    content.add(btnSimpanMeja);
    content.add(btnHapusMeja);
    content.add(btnKembaliMeja);

    setVisible(true);
  }

  private void initsDataCustomer() {
    idSelected = null;
    resetSidebar();
    menuDataCustomer.setBackground(cColor.WHITE);
    menuDataCustomer.setForeground(cColor.GREEN);
    refreshContent();
    menuDataCustomer.setSidebarAktif();
    menuTitle.setText("Data Customer");

    content.add(labelCustomer);
    content.add(labelCariCustomer);
    content.add(txtCariCustomer);
    setVisible(true);
  }

  private void initsDataKaryawan() {
    idSelected = null;
    resetSidebar();
    menuDataKaryawan.setBackground(cColor.WHITE);
    menuDataKaryawan.setForeground(cColor.GREEN);
    refreshContent();
    menuDataKaryawan.setSidebarAktif();
    menuTitle.setText("Data Karyawan");

    btnTambahKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputDataKaryawan();
      }
    });

    content.add(btnTambahKaryawan);
    content.add(btnHapusDataKaryawan);
    content.add(btnEditDataKaryawan);
    content.add(labelKaryawan);
    content.add(labelCariKaryawan);
    content.add(txtCariKaryawan);

    setVisible(true);
  }

  private void initsInputDataKaryawan() {
    idSelected = null;
    resetSidebar();
    menuDataKaryawan.setBackground(cColor.WHITE);
    menuDataKaryawan.setForeground(cColor.GREEN);
    refreshContent();
    menuDataKaryawan.setSidebarAktif();
    menuTitle.setText("Data Karyawan");

    btnHapusKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaKaryawan.setText(null);
        txtNomorHpKaryawan.setText(null);
        txtEmailKaryawan.setText(null);
        txtAlamatKaryawan.setText(null);
        jobdeskKaryawan.setSelectedItem("Operator Mesin");
      }
    });

    btnKembaliKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataKaryawan();
      }
    });

    content.add(labelDataKaryawan);
    content.add(labelNamaKaryawan);
    content.add(txtNamaKaryawan);
    content.add(errorNamaKaryawan);
    content.add(labelNomorHpKaryawan);
    content.add(txtNomorHpKaryawan);
    content.add(errorNomorHpKaryawan);
    content.add(labelEmailKaryawan);
    content.add(txtEmailKaryawan);
    content.add(errorEmailKaryawan);
    content.add(labelAlamatKaryawan);
    content.add(txtAlamatKaryawan);
    content.add(errorAlamatKaryawan);
    content.add(labelJobdeskKaryawan);
    content.add(jobdeskKaryawan);
    content.add(errorJobdeskKaryawan);
    content.add(btnSimpanKaryawan);
    content.add(btnHapusKaryawan);
    content.add(btnKembaliKaryawan);

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

    btnTransaksiMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksiMakanan();
      }
    });

    btnTransaksiCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksiCoffe();
      }
    });

    btnTransaksiNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksiNonCoffe();
      }
    });

    content.add(btnTransaksiMakanan);
    content.add(btnTransaksiCoffe);
    content.add(btnTransaksiNonCoffe);

    initsDataTransaksiMakanan();

    setVisible(true);
  }

  private void initsDataTransaksiMakanan() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Data Transaksi Makanan");

    btnTambahTransaksiMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputTransaksiMakanan();
      }
    });

    content.add(btnTransaksiMakanan);
    content.add(btnTransaksiCoffe);
    content.add(btnTransaksiNonCoffe);
    content.add(btnTambahTransaksiMakanan);
    content.add(labelCariTransaksiMakanan);
    content.add(txtCariTransaksiMakanan);

    setVisible(true);
  }

  private void initsDataTransaksiCoffe() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Data Transaksi Coffe");

    btnTambahTransaksiCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputTransaksiCoffe();
      }
    });

    content.add(btnTransaksiMakanan);
    content.add(btnTransaksiCoffe);
    content.add(btnTransaksiNonCoffe);
    content.add(btnTambahTransaksiCoffe);
    content.add(labelCariTransaksiCoffe);
    content.add(txtCariTransaksiCoffe);
    setVisible(true);
  }

  private void initsDataTransaksiNonCoffe() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Data Transaksi Non Coffe");

    btnTambahTransaksiNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputTransaksiNonCoffe();
      }
    });

    content.add(btnTransaksiMakanan);
    content.add(btnTransaksiCoffe);
    content.add(btnTransaksiNonCoffe);
    content.add(btnTambahTransaksiNonCoffe);
    content.add(labelCariTransaksiNonCoffe);
    content.add(txtCariTransaksiNonCoffe);
    setVisible(true);
  }

  private void initsInputTransaksiMakanan() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Input Transaksi Makanan");

    txtNamaTransaksiMakanan.setText(null);
    txtJumlahTransaksiMakanan.setText(null);
    txtDeskripsiTransaksiMakanan.setText(null);
    pilihTransaksiMakanan.setSelectedItem("Nasi Goreng");
    pilihMejaTransaksiMakanan.setSelectedItem("VIP");
    promoTransaksiMakanan.setSelectedItem("Paket Normal");
    txtHargaTransaksiMakanan.setText(null);

    btnHapusTransaksiMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaTransaksiMakanan.setText(null);
        txtJumlahTransaksiMakanan.setText(null);
        txtDeskripsiTransaksiMakanan.setText(null);
        pilihTransaksiMakanan.setSelectedItem("Pilih Makanan");
        pilihMejaTransaksiMakanan.setSelectedItem("Pilih Meja");
        promoTransaksiMakanan.setSelectedItem("Pilih Promo");
        txtHargaTransaksiMakanan.setText(null);
      }
    });

    btnKembaliTransaksiMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksiMakanan();
      }
    });

    content.add(labelInputTransaksiMakanan);
    content.add(labelNamaTransaksiMakanan);
    content.add(txtNamaTransaksiMakanan);
    content.add(errorNamaTransaksiMakanan);
    content.add(labelJumlahTransaksiMakanan);
    content.add(txtJumlahTransaksiMakanan);
    content.add(errorJumlahTransaksiMakanan);
    content.add(labelMejaTransaksiMakanan);
    content.add(pilihMejaTransaksiMakanan);
    content.add(errorMejaTransaksiMakanan);
    content.add(labelDeskripsiTransaksiMakanan);
    content.add(txtDeskripsiTransaksiMakanan);
    content.add(errorDeskripsiTransaksiMakanan);
    content.add(labelPilihTransaksiMakanan);
    content.add(pilihTransaksiMakanan);
    content.add(errorTransaksiMakanan);
    content.add(labelPromoTransaksiMakanan);
    content.add(promoTransaksiMakanan);
    content.add(labelHargaTransaksiMakanan);
    content.add(txtHargaTransaksiMakanan);
    content.add(btnSimpanTransaksiMakanan);
    content.add(btnHapusTransaksiMakanan);
    content.add(btnKembaliTransaksiMakanan);
    setVisible(true);
  }

  private void initsInputTransaksiCoffe() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Input Transaksi Coffe");

    txtNamaTransaksiCoffe.setText(null);
    txtJumlahTransaksiCoffe.setText(null);
    txtDeskripsiTransaksiCoffe.setText(null);
    pilihTransaksiCoffe.setSelectedItem("Nasi Goreng");
    pilihMejaTransaksiCoffe.setSelectedItem("VIP");
    promoTransaksiCoffe.setSelectedItem("Paket Normal");
    txtHargaTransaksiCoffe.setText(null);

    btnHapusTransaksiCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaTransaksiCoffe.setText(null);
        txtJumlahTransaksiCoffe.setText(null);
        txtDeskripsiTransaksiCoffe.setText(null);
        pilihTransaksiCoffe.setSelectedItem("Pilih Coffe");
        pilihMejaTransaksiCoffe.setSelectedItem("Pilih Meja");
        promoTransaksiCoffe.setSelectedItem("Pilih Promo");
        txtHargaTransaksiCoffe.setText(null);
      }
    });

    btnKembaliTransaksiCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksiCoffe();
      }
    });

    content.add(labelInputTransaksiCoffe);
    content.add(labelNamaTransaksiCoffe);
    content.add(txtNamaTransaksiCoffe);
    content.add(errorNamaTransaksiCoffe);
    content.add(labelJumlahTransaksiCoffe);
    content.add(txtJumlahTransaksiCoffe);
    content.add(errorJumlahTransaksiCoffe);
    content.add(labelMejaTransaksiCoffe);
    content.add(pilihMejaTransaksiCoffe);
    content.add(errorMejaTransaksiCoffe);
    content.add(labelDeskripsiTransaksiCoffe);
    content.add(txtDeskripsiTransaksiCoffe);
    content.add(errorDeskripsiTransaksiCoffe);
    content.add(labelPilihTransaksiCoffe);
    content.add(pilihTransaksiCoffe);
    content.add(errorTransaksiCoffe);
    content.add(labelPromoTransaksiCoffe);
    content.add(promoTransaksiCoffe);
    content.add(labelHargaTransaksiCoffe);
    content.add(txtHargaTransaksiCoffe);
    content.add(btnSimpanTransaksiCoffe);
    content.add(btnHapusTransaksiCoffe);
    content.add(btnKembaliTransaksiCoffe);

    setVisible(true);
  }

  private void initsInputTransaksiNonCoffe() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Input Transaksi Non Coffe");

    txtNamaTransaksiNonCoffe.setText(null);
    txtJumlahTransaksiNonCoffe.setText(null);
    txtDeskripsiTransaksiNonCoffe.setText(null);
    pilihTransaksiNonCoffe.setSelectedItem("Nasi Goreng");
    pilihMejaTransaksiNonCoffe.setSelectedItem("VIP");
    promoTransaksiNonCoffe.setSelectedItem("Paket Normal");
    txtHargaTransaksiNonCoffe.setText(null);

    btnHapusTransaksiNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaTransaksiNonCoffe.setText(null);
        txtJumlahTransaksiNonCoffe.setText(null);
        txtDeskripsiTransaksiNonCoffe.setText(null);
        pilihTransaksiNonCoffe.setSelectedItem("Pilih NonCoffe");
        pilihMejaTransaksiNonCoffe.setSelectedItem("Pilih Meja");
        promoTransaksiNonCoffe.setSelectedItem("Pilih Promo");
        txtHargaTransaksiNonCoffe.setText(null);
      }
    });

    btnKembaliTransaksiNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksiNonCoffe();
      }
    });

    content.add(labelInputTransaksiNonCoffe);
    content.add(labelNamaTransaksiNonCoffe);
    content.add(txtNamaTransaksiNonCoffe);
    content.add(errorNamaTransaksiNonCoffe);
    content.add(labelJumlahTransaksiNonCoffe);
    content.add(txtJumlahTransaksiNonCoffe);
    content.add(errorJumlahTransaksiNonCoffe);
    content.add(labelMejaTransaksiNonCoffe);
    content.add(pilihMejaTransaksiNonCoffe);
    content.add(errorMejaTransaksiNonCoffe);
    content.add(labelDeskripsiTransaksiNonCoffe);
    content.add(txtDeskripsiTransaksiNonCoffe);
    content.add(errorDeskripsiTransaksiNonCoffe);
    content.add(labelPilihTransaksiNonCoffe);
    content.add(pilihTransaksiNonCoffe);
    content.add(errorTransaksiNonCoffe);
    content.add(labelPromoTransaksiNonCoffe);
    content.add(promoTransaksiNonCoffe);
    content.add(labelHargaTransaksiNonCoffe);
    content.add(txtHargaTransaksiNonCoffe);
    content.add(btnSimpanTransaksiNonCoffe);
    content.add(btnHapusTransaksiNonCoffe);
    content.add(btnKembaliTransaksiNonCoffe);
    setVisible(true);
  }

  private void initsOrderBahan() {
    idSelected = null;
    resetSidebar();
    menuOrderBahan.setBackground(cColor.WHITE);
    menuOrderBahan.setForeground(cColor.GREEN);
    refreshContent();
    menuOrderBahan.setSidebarAktif();
    menuTitle.setText("Data Oder Bahan");

    btnTambahOrderBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputDataOrderBahan();
      }
    });

    content.add(btnTambahOrderBahan);
    content.add(btnHapusDataOrderBahan);
    content.add(btnEditDataOrderBahan);
    content.add(labelOrderBahan);
    content.add(labelCariOrderBahan);
    content.add(txtCariOrderBahan);
    setVisible(true);
  }

  private void initsInputDataOrderBahan() {
    idSelected = null;
    resetSidebar();
    menuOrderBahan.setBackground(cColor.WHITE);
    menuOrderBahan.setForeground(cColor.GREEN);
    refreshContent();
    menuOrderBahan.setSidebarAktif();
    menuTitle.setText("Input Oder Bahan");

    btnHapusOrderBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtJumlahOrderBahan.setText(null);
        txtDeskripsiOrderBahan.setText(null);
        pilihMenuOrderBahan.setSelectedItem("Coffe");
        pilihPTOrderBahan.setSelectedItem("PT JOMOK");
        txtAlamatOrderBahan.setText(null);
        txtHargaOrderBahan.setText(null);
      }
    });

    btnKembaliOrderBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsOrderBahan();
      }
    });

    content.add(labelInputOrderBahan);
    content.add(labelJumlahOrderBahan);
    content.add(txtJumlahOrderBahan);
    content.add(errorJumlahOrderBahan);
    content.add(labelHargaOrderBahan);
    content.add(txtHargaOrderBahan);
    content.add(labelDeskripsiOrderBahan);
    content.add(txtDeskripsiOrderBahan);
    content.add(errorDeskripsiOrderBahan);
    content.add(labelAlamatOrderBahan);
    content.add(txtAlamatOrderBahan);
    content.add(errorAlamatOrderBahan);
    content.add(labelPilihMenuOrderBahan);
    content.add(pilihMenuOrderBahan);
    content.add(errorMenuOrderBahan);
    content.add(labelPilihPTOrderBahan);
    content.add(pilihPTOrderBahan);
    content.add(errorPTOrderBahan);
    content.add(btnSimpanOrderBahan);
    content.add(btnHapusOrderBahan);
    content.add(btnKembaliOrderBahan);

    setVisible(true);
  }

  private void initsLogout() {
    resetSidebar();
    menuLogout.setBackground(cColor.GREEN);
    menuLogout.setForeground(cColor.WHITE);
    menuLogout.setSidebarAktif();
    refreshContent();
    cDashboardMitraView.this.setVisible(false);
  }
}
