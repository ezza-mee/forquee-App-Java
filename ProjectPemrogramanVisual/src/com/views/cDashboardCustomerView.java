package com.views;

import com.templates.cDashboardApp;
import com.main.Model;
import com.partials.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class cDashboardCustomerView extends cDashboardApp {

  Integer idCustomer = null;
  Integer idSelected = null;

  private cLogoutDashboard exitLink = new cLogoutDashboard(1020);

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuDataMenu = new cSidebarMenu("Menu Produk", 70 + 50);
  private cSidebarMenu menuTransaksi = new cSidebarMenu("Transaksi Produk", 70 + 50 + 50);
  private cSidebarMenu menuHistory = new cSidebarMenu("History Produk", 70 + 50 + 50 + 50);
  private cSidebarMenu menuAkun = new cSidebarMenu("Akun", 70 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 70 + 50 + 50 + 50 + 50 + 50);

  // component of datetime
  private cDateTime labelDateTime = new cDateTime(700, 15, 300);

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

  // component of data Transaksi
  private cButton btnKembaliTransaksiMakanan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliTransaksiUbahMakanan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliTransaksiCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliTransaksiUbahCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliTransaksiNonCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliTransaksiUbahNonCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of data menu makanan
  private cLabelInfo labelCariTransaksiMakanan = new cLabelInfo("Cari", 40, 90, 300, 40);
  private cTextField txtCariTransaksiMakanan = new cTextField(100, 90, 300);
  private cTable tblTransaksiMakanan;
  private cScrollPane spTransaksiMakanan;
  private cButton btnTambahMakananTransaksi = new cButton("Tambah", 450, 90, 150, 30, 20);
  private cButton btnEditMakananTransaksi = new cButton("Edit", 650, 90, 150, 30, 20);
  private cButton btnHapusMakananTransaksi = new cButton("Hapus", 840, 90, 150, 30, 20);

  // component of data menu coffe
  private cLabelInfo labelCariTransaksiCoffe = new cLabelInfo("Cari", 40, 90, 300, 40);
  private cTextField txtCariTransaksiCoffe = new cTextField(100, 90, 300);
  private cTable tblTransaksiCoffe;
  private cScrollPane spTransaksiCoffe;
  private cButton btnTambahCoffeTransaksi = new cButton("Tambah", 450, 90, 150, 30, 20);
  private cButton btnEditCoffeTransaksi = new cButton("Edit", 650, 90, 150, 30, 20);
  private cButton btnHapusCoffeTransaksi = new cButton("Hapus", 840, 90, 150, 30, 20);

  // component of data menu non coffe
  private cLabelInfo labelCariTransaksiNonCoffe = new cLabelInfo("Cari", 40, 90, 300, 40);
  private cTextField txtCariTransaksiNonCoffe = new cTextField(100, 90, 300);
  private cTable tblTransaksiNonCoffe;
  private cScrollPane spTransaksiNonCoffe;
  private cButton btnTambahNonCoffeTransaksi = new cButton("Tambah", 450, 90, 150, 30, 20);
  private cButton btnEditNonCoffeTransaksi = new cButton("Edit", 650, 90, 150, 30, 20);
  private cButton btnHapusNonCoffeTransaksi = new cButton("Hapus", 840, 90, 150, 30, 20);

  // component of input data Transaksi Makanan
  private cLabelInfo labelInputTransaksiMakanan = new cLabelInfo("Masukan Data Transaksi Makanan!", 190, 40, 400, 40);
  private cLabelInfo labelPilihTransaksiMakanan = new cLabelInfo("Menu Makanan", 190, 90, 300, 40);
  private cComboBox pilihTransaksiMakanan;
  private cErrorLabel errorTransaksiMakanan = new cErrorLabel("Menu Makanan tidak boleh Kosong!", 190,
      145, 300);
  private cLabelInfo labelDeskripsiTransaksiMakanan = new cLabelInfo("Deskripsi Makanan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiMakanan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiMakanan = new cErrorLabel(
      "Deskripsi Makanan tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiMakanan = new cLabelInfo("Pilih Meja", 190, 180, 300, 40);
  private cErrorLabel errorMejaTransaksiMakanan = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelJumlahTransaksiMakanan = new cLabelInfo("Jumlah Makanan", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiMakanan = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiMakanan = new cErrorLabel("Jumlah Makanan tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelHargaTransaksiMakanan = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiMakanan = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiMakanan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiMakanan = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cLabelInfo labelPembayaranMakanan = new cLabelInfo("Pilih Pembayaran", 190, 270, 300, 40);
  private cComboBox pilihPembayaranMakanan = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 302, 300, 30);
  private cErrorLabel errorPembayaranMakanan = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      327, 300);
  private cComboBox pilihPromoMakanan;
  private cComboBox pilihMejaMakanan;
  private cLabelInfo labelHargaTotalMakanan = new cLabelInfo("Harga Total", 190, 360, 300, 30);
  private cTextarea txtTotalHargaMakanan = new cTextarea(190, 390, 300, 30, false);

  // component of input data Transaksi UbahMakanan
  private cLabelInfo labelInputTransaksiUbahMakanan = new cLabelInfo("Masukan Data Transaksi UbahMakanan!", 190, 40,
      400, 40);
  private cLabelInfo labelPilihTransaksiUbahMakanan = new cLabelInfo("Menu UbahMakanan", 190, 90, 300, 40);
  private cComboBox pilihTransaksiUbahMakanan;
  private cErrorLabel errorTransaksiUbahMakanan = new cErrorLabel("Menu UbahMakanan tidak boleh Kosong!", 190,
      145, 300);
  private cLabelInfo labelDeskripsiTransaksiUbahMakanan = new cLabelInfo("Deskripsi UbahMakanan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiUbahMakanan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiUbahMakanan = new cErrorLabel(
      "Deskripsi UbahMakanan tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiUbahMakanan = new cLabelInfo("Pilih Meja", 190, 180, 300, 40);
  private cErrorLabel errorMejaTransaksiUbahMakanan = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelJumlahTransaksiUbahMakanan = new cLabelInfo("Jumlah UbahMakanan", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiUbahMakanan = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiUbahMakanan = new cErrorLabel("Jumlah UbahMakanan tidak boleh Kosong!", 580,
      327,
      400);
  private cLabelInfo labelHargaTransaksiUbahMakanan = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiUbahMakanan = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiUbahMakanan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiUbahMakanan = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cLabelInfo labelPembayaranUbahMakanan = new cLabelInfo("Pilih Pembayaran", 190, 270, 300, 40);
  private cComboBox pilihPembayaranUbahMakanan = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 302, 300,
      30);
  private cErrorLabel errorPembayaranUbahMakanan = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      327, 300);
  private cComboBox pilihPromoUbahMakanan;
  private cComboBox pilihMejaUbahMakanan;
  private cLabelInfo labelHargaTotalUbahMakanan = new cLabelInfo("Harga Total", 190, 360, 300, 30);
  private cTextarea txtTotalHargaUbahMakanan = new cTextarea(190, 390, 300, 30, false);

  // component of input data Transaksi Coffe
  private cLabelInfo labelInputTransaksiCoffe = new cLabelInfo("Masukan Data Transaksi Coffe!", 190, 40, 400, 40);
  private cLabelInfo labelPilihTransaksiCoffe = new cLabelInfo("Menu Coffe", 190, 90, 300, 40);
  private cComboBox pilihTransaksiCoffe;
  private cErrorLabel errorTransaksiCoffe = new cErrorLabel("Menu Coffe tidak boleh Kosong!", 190,
      145, 300);
  private cLabelInfo labelDeskripsiTransaksiCoffe = new cLabelInfo("Deskripsi Coffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiCoffe = new cErrorLabel(
      "Deskripsi Coffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiCoffe = new cLabelInfo("Pilih Meja", 190, 180, 300, 40);
  private cErrorLabel errorMejaTransaksiCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelJumlahTransaksiCoffe = new cLabelInfo("Jumlah Coffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiCoffe = new cErrorLabel("Jumlah Coffe tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelHargaTransaksiCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cLabelInfo labelPembayaranCoffe = new cLabelInfo("Pilih Pembayaran", 190, 270, 300, 40);
  private cComboBox pilihPembayaranCoffe = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 302, 300, 30);
  private cErrorLabel errorPembayaranCoffe = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      327, 300);
  private cComboBox pilihPromoCoffe;
  private cComboBox pilihMejaCoffe;
  private cLabelInfo labelHargaTotalCoffe = new cLabelInfo("Harga Total", 190, 360, 300, 30);
  private cTextarea txtTotalHargaCoffe = new cTextarea(190, 390, 300, 30, false);

  // component of input data Transaksi UbahCoffe
  private cLabelInfo labelInputTransaksiUbahCoffe = new cLabelInfo("Masukan Data Transaksi UbahCoffe!", 190, 40,
      400, 40);
  private cLabelInfo labelPilihTransaksiUbahCoffe = new cLabelInfo("Menu UbahCoffe", 190, 90, 300, 40);
  private cComboBox pilihTransaksiUbahCoffe;
  private cErrorLabel errorTransaksiUbahCoffe = new cErrorLabel("Menu UbahCoffe tidak boleh Kosong!", 190,
      145, 300);
  private cLabelInfo labelDeskripsiTransaksiUbahCoffe = new cLabelInfo("Deskripsi UbahCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiUbahCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiUbahCoffe = new cErrorLabel(
      "Deskripsi UbahCoffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiUbahCoffe = new cLabelInfo("Pilih Meja", 190, 180, 300, 40);
  private cErrorLabel errorMejaTransaksiUbahCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelJumlahTransaksiUbahCoffe = new cLabelInfo("Jumlah UbahCoffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiUbahCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiUbahCoffe = new cErrorLabel("Jumlah UbahCoffe tidak boleh Kosong!", 580,
      327,
      400);
  private cLabelInfo labelHargaTransaksiUbahCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiUbahCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiUbahCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiUbahCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cLabelInfo labelPembayaranUbahCoffe = new cLabelInfo("Pilih Pembayaran", 190, 270, 300, 40);
  private cComboBox pilihPembayaranUbahCoffe = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 302, 300,
      30);
  private cErrorLabel errorPembayaranUbahCoffe = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      327, 300);
  private cComboBox pilihPromoUbahCoffe;
  private cComboBox pilihMejaUbahCoffe;
  private cLabelInfo labelHargaTotalUbahCoffe = new cLabelInfo("Harga Total", 190, 360, 300, 30);
  private cTextarea txtTotalHargaUbahCoffe = new cTextarea(190, 390, 300, 30, false);

  // component of input data Transaksi NonCoffe
  private cLabelInfo labelInputTransaksiNonCoffe = new cLabelInfo("Masukan Data Transaksi NonCoffe!", 190, 40, 400, 40);
  private cLabelInfo labelPilihTransaksiNonCoffe = new cLabelInfo("Menu NonCoffe", 190, 90, 300, 40);
  private cComboBox pilihTransaksiNonCoffe;
  private cErrorLabel errorTransaksiNonCoffe = new cErrorLabel("Menu NonCoffe tidak boleh Kosong!", 190,
      145, 300);
  private cLabelInfo labelDeskripsiTransaksiNonCoffe = new cLabelInfo("Deskripsi NonCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiNonCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiNonCoffe = new cErrorLabel(
      "Deskripsi NonCoffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiNonCoffe = new cLabelInfo("Pilih Meja", 190, 180, 300, 40);
  private cErrorLabel errorMejaTransaksiNonCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelJumlahTransaksiNonCoffe = new cLabelInfo("Jumlah NonCoffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiNonCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiNonCoffe = new cErrorLabel("Jumlah NonCoffe tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelHargaTransaksiNonCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiNonCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiNonCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiNonCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cLabelInfo labelPembayaranNonCoffe = new cLabelInfo("Pilih Pembayaran", 190, 270, 300, 40);
  private cComboBox pilihPembayaranNonCoffe = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 302, 300, 30);
  private cErrorLabel errorPembayaranNonCoffe = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      327, 300);
  private cComboBox pilihPromoNonCoffe;
  private cComboBox pilihMejaNonCoffe;
  private cLabelInfo labelHargaTotalNonCoffe = new cLabelInfo("Harga Total", 190, 360, 300, 30);
  private cTextarea txtTotalHargaNonCoffe = new cTextarea(190, 390, 300, 30, false);

  // component of input data Transaksi UbahNonCoffe
  private cLabelInfo labelInputTransaksiUbahNonCoffe = new cLabelInfo("Masukan Data Transaksi UbahNonCoffe!", 190, 40,
      400, 40);
  private cLabelInfo labelPilihTransaksiUbahNonCoffe = new cLabelInfo("Menu UbahNonCoffe", 190, 90, 300, 40);
  private cComboBox pilihTransaksiUbahNonCoffe;
  private cErrorLabel errorTransaksiUbahNonCoffe = new cErrorLabel("Menu UbahNonCoffe tidak boleh Kosong!", 190,
      145, 300);
  private cLabelInfo labelDeskripsiTransaksiUbahNonCoffe = new cLabelInfo("Deskripsi UbahNonCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiUbahNonCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiUbahNonCoffe = new cErrorLabel(
      "Deskripsi UbahNonCoffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiUbahNonCoffe = new cLabelInfo("Pilih Meja", 190, 180, 300, 40);
  private cErrorLabel errorMejaTransaksiUbahNonCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelJumlahTransaksiUbahNonCoffe = new cLabelInfo("Jumlah UbahNonCoffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiUbahNonCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiUbahNonCoffe = new cErrorLabel("Jumlah UbahNonCoffe tidak boleh Kosong!", 580,
      327,
      400);
  private cLabelInfo labelHargaTransaksiUbahNonCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiUbahNonCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiUbahNonCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiUbahNonCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cLabelInfo labelPembayaranUbahNonCoffe = new cLabelInfo("Pilih Pembayaran", 190, 270, 300, 40);
  private cComboBox pilihPembayaranUbahNonCoffe = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 302, 300,
      30);
  private cErrorLabel errorPembayaranUbahNonCoffe = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      327, 300);
  private cComboBox pilihPromoUbahNonCoffe;
  private cComboBox pilihMejaUbahNonCoffe;
  private cLabelInfo labelHargaTotalUbahNonCoffe = new cLabelInfo("Harga Total", 190, 360, 300, 30);
  private cTextarea txtTotalHargaUbahNonCoffe = new cTextarea(190, 390, 300, 30, false);

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

      menuTransaksi.setForeground(cColor.WHITE);
      menuTransaksi.setBackground(cColor.GREEN);
      menuTransaksi.setSidebarNonAktif();

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

    menuAkun.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsAkun();
      }
    });

    exitLink.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsLogout();
      }
    });

    // add component default
    main.add(labelDateTime);
    sidebar.add(menuBeranda);
    sidebar.add(menuDataMenu);
    sidebar.add(menuTransaksi);
    sidebar.add(menuHistory);
    sidebar.add(menuAkun);
    header.add(exitLink);
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
        initsInputTransaksiMakanan();
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
        initsInputTransaksiCoffe();
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
        initsInputTransaksiNonCoffe();
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

    pilihTransaksiMenu.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedItem = (String) pilihTransaksiMenu.getSelectedItem();
        if (selectedItem.equals("Makanan")) {
          initsDataTransaksiMakanan();
        } else if (selectedItem.equals("Coffe")) {
          initsDataTransaksiCoffe();
        } else if (selectedItem.equals("Non Coffe")) {
          initsDataTransaksiNonCoffe();
        }
      }
    });

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

    content.add(pilihTransaksiMenu);

    btnTambahMakananTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputTransaksiMakanan();
      }
    });

    btnEditMakananTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblTransaksiMakanan.getSelectedRow();

        if (selectedIndex != -1) {
          int idTransaksi = Integer.valueOf(tblTransaksiMakanan.getValueAt(selectedIndex, 0).toString());
          initsUbahTransaksiMakanan(idTransaksi);
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardCustomerView.this,
              "Pilih data Transaksi yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusMakananTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblTransaksiMakanan.getSelectedRow();

        if (selectedIndex != -1) {
          int idTransaksi = Integer
              .valueOf(tblTransaksiMakanan.getValueAt(selectedIndex, 0).toString());

          if (Model.hapusDataOnlineMakanan(idTransaksi)) {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Data Transaksi berhasil dihapus!",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsDataTransaksiMakanan();
          } else {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Data Transaksi gagal dihapus!",
                "Gagal", JOptionPane.ERROR_MESSAGE);
          }
        } else {
          // kalo gak ada yang diseleksic
          JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Pilih data terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblTransaksiMakanan = new cTable(Model.getAllOnlineMakananDiproses());

    tblTransaksiMakanan.getColumnModel().getColumn(0).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(0).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(0).setWidth(0);

    tblTransaksiMakanan.getColumnModel().getColumn(1).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(1).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(1).setWidth(0);

    tblTransaksiMakanan.getColumnModel().getColumn(2).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(2).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(2).setWidth(0);

    tblTransaksiMakanan.getColumnModel().getColumn(7).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(7).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(7).setWidth(0);

    tblTransaksiMakanan.getColumnModel().getColumn(8).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(8).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(8).setWidth(0);

    spTransaksiMakanan = new cScrollPane(tblTransaksiMakanan, 0, 140, 1100, 300);

    content.add(spTransaksiMakanan);

    content.add(btnTambahMakananTransaksi);
    content.add(btnEditMakananTransaksi);
    content.add(btnHapusMakananTransaksi);

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

    content.add(pilihTransaksiMenu);

    btnTambahCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputTransaksiCoffe();
      }
    });

    btnEditCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblTransaksiCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          int idTransaksi = Integer.valueOf(tblTransaksiCoffe.getValueAt(selectedIndex, 0).toString());
          initsUbahTransaksiCoffe(idTransaksi);
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardCustomerView.this,
              "Pilih data Transaksi yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblTransaksiCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          int idTransaksi = Integer
              .valueOf(tblTransaksiCoffe.getValueAt(selectedIndex, 0).toString());

          if (Model.hapusDataOnlineCoffe(idTransaksi)) {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Data Transaksi berhasil dihapus!",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsDataTransaksiCoffe();
          } else {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Data Transaksi gagal dihapus!",
                "Gagal", JOptionPane.ERROR_MESSAGE);
          }
        } else {
          // kalo gak ada yang diseleksic
          JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Pilih data terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblTransaksiCoffe = new cTable(Model.getAllOnlineCoffeDiproses());

    tblTransaksiCoffe.getColumnModel().getColumn(0).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(0).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(0).setWidth(0);

    tblTransaksiCoffe.getColumnModel().getColumn(1).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(1).setWidth(0);

    tblTransaksiCoffe.getColumnModel().getColumn(2).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(2).setWidth(0);

    tblTransaksiCoffe.getColumnModel().getColumn(7).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(7).setWidth(0);

    tblTransaksiCoffe.getColumnModel().getColumn(8).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(8).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(8).setWidth(0);

    spTransaksiCoffe = new cScrollPane(tblTransaksiCoffe, 0, 140, 1100, 300);

    content.add(spTransaksiCoffe);

    content.add(btnTambahCoffeTransaksi);
    content.add(btnEditCoffeTransaksi);
    content.add(btnHapusCoffeTransaksi);

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
    menuTitle.setText("Data Transaksi NonCoffe");

    content.add(pilihTransaksiMenu);

    btnTambahNonCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputTransaksiNonCoffe();
      }
    });

    btnEditNonCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblTransaksiNonCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          int idTransaksi = Integer.valueOf(tblTransaksiNonCoffe.getValueAt(selectedIndex, 0).toString());
          initsUbahTransaksiNonCoffe(idTransaksi);
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardCustomerView.this,
              "Pilih data Transaksi yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusNonCoffeTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblTransaksiNonCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          int idTransaksi = Integer
              .valueOf(tblTransaksiNonCoffe.getValueAt(selectedIndex, 0).toString());

          if (Model.hapusDataOnlineNonCoffe(idTransaksi)) {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Data Transaksi berhasil dihapus!",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsDataTransaksiNonCoffe();
          } else {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Data Transaksi gagal dihapus!",
                "Gagal", JOptionPane.ERROR_MESSAGE);
          }
        } else {
          // kalo gak ada yang diseleksic
          JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Pilih data terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblTransaksiNonCoffe = new cTable(Model.getAllOnlineNonCoffeDiproses());

    tblTransaksiNonCoffe.getColumnModel().getColumn(0).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(0).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(0).setWidth(0);

    tblTransaksiNonCoffe.getColumnModel().getColumn(1).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(1).setWidth(0);

    tblTransaksiNonCoffe.getColumnModel().getColumn(2).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(2).setWidth(0);

    tblTransaksiNonCoffe.getColumnModel().getColumn(7).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(7).setWidth(0);

    tblTransaksiNonCoffe.getColumnModel().getColumn(8).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(8).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(8).setWidth(0);

    spTransaksiNonCoffe = new cScrollPane(tblTransaksiNonCoffe, 0, 140, 1100, 300);

    content.add(spTransaksiNonCoffe);

    content.add(btnTambahNonCoffeTransaksi);
    content.add(btnEditNonCoffeTransaksi);
    content.add(btnHapusNonCoffeTransaksi);

    content.add(labelCariTransaksiNonCoffe);
    content.add(txtCariTransaksiNonCoffe);

    setVisible(true);
  }

  private void initializeTransaksiMakanan() {
    ArrayList<String> menuMakanan = Model.getAllMenuTransaksiMakanan();
    menuMakanan.add(0, "Menu Makanan");

    pilihTransaksiMakanan = new cComboBox(menuMakanan.toArray(new String[0]), 190, 120, 300, 30);

    ArrayList<String> mejaMakanan = Model.getAllMejaTransaksiMakanan();
    mejaMakanan.add(0, "Meja Makanan");

    pilihMejaMakanan = new cComboBox(mejaMakanan.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> promoMakanan = Model.getAllPromoTransaksiMakanan();
    promoMakanan.add(0, "Promo Makanan");

    pilihPromoMakanan = new cComboBox(promoMakanan.toArray(new String[0]), 190, 390, 300, 20);

    ArrayList<String> menuUbahMakanan = Model.getAllMenuTransaksiMakanan();
    menuUbahMakanan.add(0, "Menu Makanan");

    pilihTransaksiUbahMakanan = new cComboBox(menuUbahMakanan.toArray(new String[0]), 190, 120, 300, 30);

    ArrayList<String> mejaUbahMakanan = Model.getAllMejaTransaksiUbahMakanan();
    mejaUbahMakanan.add(0, "Meja Makanan");

    pilihMejaUbahMakanan = new cComboBox(mejaUbahMakanan.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> promoUbahMakanan = Model.getAllPromoTransaksiUbahMakanan();
    promoUbahMakanan.add(0, "Promo Makanan");

    pilihPromoUbahMakanan = new cComboBox(promoUbahMakanan.toArray(new String[0]), 190, 390, 300, 20);
  }

  private void initializeTransaksiCoffe() {
    ArrayList<String> menuCoffe = Model.getAllMenuTransaksiCoffe();
    menuCoffe.add(0, "Menu Coffe");

    pilihTransaksiCoffe = new cComboBox(menuCoffe.toArray(new String[0]), 190, 120, 300, 30);

    ArrayList<String> mejaCoffe = Model.getAllMejaTransaksiCoffe();
    mejaCoffe.add(0, "Meja Coffe");

    pilihMejaCoffe = new cComboBox(mejaCoffe.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> promoCoffe = Model.getAllPromoTransaksiCoffe();
    promoCoffe.add(0, "Promo Coffe");

    pilihPromoCoffe = new cComboBox(promoCoffe.toArray(new String[0]), 190, 390, 300, 20);

    ArrayList<String> menuUbahCoffe = Model.getAllMenuTransaksiCoffe();
    menuUbahCoffe.add(0, "Menu Coffe");

    pilihTransaksiUbahCoffe = new cComboBox(menuUbahCoffe.toArray(new String[0]), 190, 120, 300, 30);

    ArrayList<String> mejaUbahCoffe = Model.getAllMejaTransaksiUbahCoffe();
    mejaUbahCoffe.add(0, "Meja Coffe");

    pilihMejaUbahCoffe = new cComboBox(mejaUbahCoffe.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> promoUbahCoffe = Model.getAllPromoTransaksiUbahCoffe();
    promoUbahCoffe.add(0, "Promo Coffe");

    pilihPromoUbahCoffe = new cComboBox(promoUbahCoffe.toArray(new String[0]), 190, 390, 300, 20);
  }

  private void initializeTransaksiNonCoffe() {
    ArrayList<String> menuNonCoffe = Model.getAllMenuTransaksiNonCoffe();
    menuNonCoffe.add(0, "Menu NonCoffe");

    pilihTransaksiNonCoffe = new cComboBox(menuNonCoffe.toArray(new String[0]), 190, 120, 300, 30);

    ArrayList<String> mejaNonCoffe = Model.getAllMejaTransaksiNonCoffe();
    mejaNonCoffe.add(0, "Meja NonCoffe");

    pilihMejaNonCoffe = new cComboBox(mejaNonCoffe.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> promoNonCoffe = Model.getAllPromoTransaksiNonCoffe();
    promoNonCoffe.add(0, "Promo NonCoffe");

    pilihPromoNonCoffe = new cComboBox(promoNonCoffe.toArray(new String[0]), 190, 390, 300, 20);

    ArrayList<String> menuUbahNonCoffe = Model.getAllMenuTransaksiNonCoffe();
    menuUbahNonCoffe.add(0, "Menu NonCoffe");

    pilihTransaksiUbahNonCoffe = new cComboBox(menuUbahNonCoffe.toArray(new String[0]), 190, 120, 300, 30);

    ArrayList<String> mejaUbahNonCoffe = Model.getAllMejaTransaksiUbahNonCoffe();
    mejaUbahNonCoffe.add(0, "Meja NonCoffe");

    pilihMejaUbahNonCoffe = new cComboBox(mejaUbahNonCoffe.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> promoUbahNonCoffe = Model.getAllPromoTransaksiUbahNonCoffe();
    promoUbahNonCoffe.add(0, "Promo NonCoffe");

    pilihPromoUbahNonCoffe = new cComboBox(promoUbahNonCoffe.toArray(new String[0]), 190, 390, 300, 20);
  }

  private void initsUbahTransaksiMakanan(int idTransaksi) {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Input Transaksi Makanan");

    initializeTransaksiMakanan();

    Object[] detailTransaksiMakanan = Model.getDetailOnlineMakananDiproses(idTransaksi);

    this.pilihTransaksiUbahMakanan.setSelectedItem(detailTransaksiMakanan[4].toString());
    this.pilihMejaUbahMakanan.setSelectedItem(detailTransaksiMakanan[5].toString());
    this.pilihPembayaranUbahMakanan.setSelectedItem(detailTransaksiMakanan[8].toString());
    txtDeskripsiTransaksiUbahMakanan.setText(detailTransaksiMakanan[7].toString());
    txtJumlahTransaksiUbahMakanan.setText(detailTransaksiMakanan[9].toString());
    txtHargaTransaksiUbahMakanan.setText(detailTransaksiMakanan[10].toString());

    pilihTransaksiUbahMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihTransaksiUbahMakanan.getSelectedItem();
        if (!selectedMenu.equals("Menu UbahMakanan")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuUbahMakanan(selectedMenu);
          txtHargaTransaksiUbahMakanan.setText(String.valueOf(hargaMenu));
        }
      }
    });

    btnSimpanTransaksiUbahMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihTransaksiUbahMakanan.getSelectedItem() == null
            || pilihMejaUbahMakanan.getSelectedItem() == null
            || pilihPembayaranUbahMakanan.getSelectedItem() == null
            || txtDeskripsiTransaksiUbahMakanan.getText().trim().isEmpty()
            || txtJumlahTransaksiUbahMakanan.getText().trim().isEmpty()) {
          cDashboardCustomerView.this.setVisible(false);
          if (pilihTransaksiUbahMakanan.getSelectedItem() == null
              || pilihTransaksiUbahMakanan.getSelectedItem().toString().trim().equals("Menu UbahMakanan")) {
            content.add(errorTransaksiUbahMakanan);
          } else {
            content.remove(errorTransaksiUbahMakanan);
          }
          if (pilihMejaUbahMakanan.getSelectedItem() == null
              || pilihMejaUbahMakanan.getSelectedItem().toString().trim().equals("Menu UbahMakanan")) {
            content.add(errorMejaTransaksiUbahMakanan);
          } else {
            content.remove(errorMejaTransaksiUbahMakanan);
          }
          if (pilihPembayaranUbahMakanan.getSelectedItem() == null
              || pilihPembayaranUbahMakanan.getSelectedItem().toString().trim().equals("Menu UbahMakanan")) {
            content.add(errorPembayaranUbahMakanan);
          } else {
            content.remove(errorPembayaranUbahMakanan);
          }
          if (txtDeskripsiTransaksiUbahMakanan.getText().trim().isEmpty()) {
            content.add(errorDeskripsiTransaksiUbahMakanan);
          } else {
            content.remove(errorDeskripsiTransaksiUbahMakanan);
          }
          if (txtJumlahTransaksiUbahMakanan.getText().trim().isEmpty()) {
            content.add(errorJumlahTransaksiUbahMakanan);
          } else {
            content.remove(errorJumlahTransaksiUbahMakanan);
          }
        } else {
          String menuTransaksi = (String) pilihTransaksiUbahMakanan.getSelectedItem();
          String mejaTransaksi = (String) pilihMejaUbahMakanan.getSelectedItem();
          String promoTransaksi = (String) pilihPromoUbahMakanan.getSelectedItem();
          String bayarTransaksi = (String) pilihPembayaranUbahMakanan.getSelectedItem();
          String deskripsiTransaksi = txtDeskripsiTransaksiUbahMakanan.getText();

          int jumlahTransaksi = Integer.valueOf(txtJumlahTransaksiUbahMakanan.getText());
          int hargaUbahMakanan = Integer.valueOf(txtHargaTransaksiUbahMakanan.getText());
          int hargaTotalUbahMakanan = jumlahTransaksi * hargaUbahMakanan;
          String TransaksiUbahMakanan = Integer.toString(hargaTotalUbahMakanan);
          txtTotalHargaUbahMakanan.setText(TransaksiUbahMakanan);
          int hargaTransaksi = Integer.parseInt(TransaksiUbahMakanan);

          pilihPromoUbahMakanan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
              String selectedPromo = (String) pilihPromoUbahMakanan.getSelectedItem();
              if (!selectedPromo.equals("Promo UbahMakanan")) {
                int hargaPromo = Model.getPromoMenuUbahMakanan(selectedPromo);
                int transaksiPromo = hargaTransaksi - hargaPromo;
                String totalHargaPromo = Integer.toString(transaksiPromo);
                txtTotalHargaUbahMakanan.setText(totalHargaPromo);
              }
            }
          });

          Object[] messagePromo = { "pilih Promo UbahMakanan", pilihPromoUbahMakanan };
          JOptionPane.showMessageDialog(null, messagePromo, "Promo",
              JOptionPane.PLAIN_MESSAGE);

          String pembayaranUbahMakanan = "Data Transaksi UbahMakanan" + "\n\n"
              + "menu UbahMakanan \n" + pilihTransaksiUbahMakanan.getSelectedItem() + "\n"
              + "meja UbahMakanan \n" + pilihMejaUbahMakanan.getSelectedItem() + "\n"
              + "promo UbahMakanan \n" + pilihPromoUbahMakanan.getSelectedItem() + "\n"
              + "jumlah UbahMakanan \n" + txtJumlahTransaksiUbahMakanan.getText() + "\n"
              + "harga UbahMakanan \n Rp. " + txtHargaTransaksiUbahMakanan.getText() + "\n"
              + "harga Total \n Rp. " + txtTotalHargaUbahMakanan.getText() + "\n"
              + "Masukan Uang";

          String checkoutUbahMakanan = JOptionPane.showInputDialog(pembayaranUbahMakanan);
          int uang = Integer.valueOf(checkoutUbahMakanan);
          int kembalian = uang - hargaTotalUbahMakanan;

          if (Model.ubahOnlineMakanan(idTransaksi, idCustomer, menuTransaksi, mejaTransaksi, promoTransaksi,
              deskripsiTransaksi, bayarTransaksi, jumlahTransaksi, hargaTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            initsDataTransaksiMakanan();
          } else {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusTransaksiUbahMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtJumlahTransaksiUbahMakanan.setText(null);
        txtDeskripsiTransaksiUbahMakanan.setText(null);
        pilihTransaksiUbahMakanan.setSelectedItem("Pilih UbahMakanan");
        pilihMejaUbahMakanan.setSelectedItem("Pilih Meja");
        pilihPembayaranUbahMakanan.setSelectedItem("Pilih Pembayaran");
        txtHargaTransaksiUbahMakanan.setText(null);
      }
    });

    btnKembaliTransaksiUbahMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksiMakanan();
      }
    });

    content.add(labelInputTransaksiUbahMakanan);
    content.add(labelJumlahTransaksiUbahMakanan);
    content.add(txtJumlahTransaksiUbahMakanan);
    content.add(labelMejaTransaksiUbahMakanan);
    content.add(pilihMejaUbahMakanan);
    content.add(labelDeskripsiTransaksiUbahMakanan);
    content.add(txtDeskripsiTransaksiUbahMakanan);
    content.add(labelPilihTransaksiUbahMakanan);
    content.add(pilihTransaksiUbahMakanan);
    content.add(labelPembayaranUbahMakanan);
    content.add(pilihPembayaranUbahMakanan);
    content.add(labelHargaTransaksiUbahMakanan);
    content.add(txtHargaTransaksiUbahMakanan);
    content.add(labelHargaTotalUbahMakanan);
    content.add(txtTotalHargaUbahMakanan);
    content.add(btnSimpanTransaksiUbahMakanan);
    content.add(btnHapusTransaksiUbahMakanan);
    content.add(btnKembaliTransaksiUbahMakanan);

    setVisible(true);
  }

  private void initsUbahTransaksiCoffe(int idTransaksi) {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Input Transaksi Coffe");

    initializeTransaksiCoffe();

    Object[] detailTransaksiCoffe = Model.getDetailOnlineCoffeDiproses(idTransaksi);

    this.pilihTransaksiUbahCoffe.setSelectedItem(detailTransaksiCoffe[4].toString());
    this.pilihMejaUbahCoffe.setSelectedItem(detailTransaksiCoffe[5].toString());
    this.pilihPembayaranUbahCoffe.setSelectedItem(detailTransaksiCoffe[8].toString());
    txtDeskripsiTransaksiUbahCoffe.setText(detailTransaksiCoffe[7].toString());
    txtJumlahTransaksiUbahCoffe.setText(detailTransaksiCoffe[9].toString());
    txtHargaTransaksiUbahCoffe.setText(detailTransaksiCoffe[10].toString());

    pilihTransaksiUbahCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihTransaksiUbahCoffe.getSelectedItem();
        if (!selectedMenu.equals("Menu UbahCoffe")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuUbahCoffe(selectedMenu);
          txtHargaTransaksiUbahCoffe.setText(String.valueOf(hargaMenu));
        }
      }
    });

    btnSimpanTransaksiUbahCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihTransaksiUbahCoffe.getSelectedItem() == null
            || pilihMejaUbahCoffe.getSelectedItem() == null
            || pilihPembayaranUbahCoffe.getSelectedItem() == null
            || txtDeskripsiTransaksiUbahCoffe.getText().trim().isEmpty()
            || txtJumlahTransaksiUbahCoffe.getText().trim().isEmpty()) {
          cDashboardCustomerView.this.setVisible(false);
          if (pilihTransaksiUbahCoffe.getSelectedItem() == null
              || pilihTransaksiUbahCoffe.getSelectedItem().toString().trim().equals("Menu UbahCoffe")) {
            content.add(errorTransaksiUbahCoffe);
          } else {
            content.remove(errorTransaksiUbahCoffe);
          }
          if (pilihMejaUbahCoffe.getSelectedItem() == null
              || pilihMejaUbahCoffe.getSelectedItem().toString().trim().equals("Menu UbahCoffe")) {
            content.add(errorMejaTransaksiUbahCoffe);
          } else {
            content.remove(errorMejaTransaksiUbahCoffe);
          }
          if (pilihPembayaranUbahCoffe.getSelectedItem() == null
              || pilihPembayaranUbahCoffe.getSelectedItem().toString().trim().equals("Menu UbahCoffe")) {
            content.add(errorPembayaranUbahCoffe);
          } else {
            content.remove(errorPembayaranUbahCoffe);
          }
          if (txtDeskripsiTransaksiUbahCoffe.getText().trim().isEmpty()) {
            content.add(errorDeskripsiTransaksiUbahCoffe);
          } else {
            content.remove(errorDeskripsiTransaksiUbahCoffe);
          }
          if (txtJumlahTransaksiUbahCoffe.getText().trim().isEmpty()) {
            content.add(errorJumlahTransaksiUbahCoffe);
          } else {
            content.remove(errorJumlahTransaksiUbahCoffe);
          }
        } else {
          String menuTransaksi = (String) pilihTransaksiUbahCoffe.getSelectedItem();
          String mejaTransaksi = (String) pilihMejaUbahCoffe.getSelectedItem();
          String promoTransaksi = (String) pilihPromoUbahCoffe.getSelectedItem();
          String bayarTransaksi = (String) pilihPembayaranUbahCoffe.getSelectedItem();
          String deskripsiTransaksi = txtDeskripsiTransaksiUbahCoffe.getText();

          int jumlahTransaksi = Integer.valueOf(txtJumlahTransaksiUbahCoffe.getText());
          int hargaUbahCoffe = Integer.valueOf(txtHargaTransaksiUbahCoffe.getText());
          int hargaTotalUbahCoffe = jumlahTransaksi * hargaUbahCoffe;
          String TransaksiUbahCoffe = Integer.toString(hargaTotalUbahCoffe);
          txtTotalHargaUbahCoffe.setText(TransaksiUbahCoffe);
          int hargaTransaksi = Integer.parseInt(TransaksiUbahCoffe);

          pilihPromoUbahCoffe.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
              String selectedPromo = (String) pilihPromoUbahCoffe.getSelectedItem();
              if (!selectedPromo.equals("Promo UbahCoffe")) {
                int hargaPromo = Model.getPromoMenuUbahCoffe(selectedPromo);
                int transaksiPromo = hargaTransaksi - hargaPromo;
                String totalHargaPromo = Integer.toString(transaksiPromo);
                txtTotalHargaUbahCoffe.setText(totalHargaPromo);
              }
            }
          });

          Object[] messagePromo = { "pilih Promo UbahCoffe", pilihPromoUbahCoffe };
          JOptionPane.showMessageDialog(null, messagePromo, "Promo",
              JOptionPane.PLAIN_MESSAGE);

          String pembayaranUbahCoffe = "Data Transaksi UbahCoffe" + "\n\n"
              + "menu UbahCoffe \n" + pilihTransaksiUbahCoffe.getSelectedItem() + "\n"
              + "meja UbahCoffe \n" + pilihMejaUbahCoffe.getSelectedItem() + "\n"
              + "promo UbahCoffe \n" + pilihPromoUbahCoffe.getSelectedItem() + "\n"
              + "jumlah UbahCoffe \n" + txtJumlahTransaksiUbahCoffe.getText() + "\n"
              + "harga UbahCoffe \n Rp. " + txtHargaTransaksiUbahCoffe.getText() + "\n"
              + "harga Total \n Rp. " + txtTotalHargaUbahCoffe.getText() + "\n"
              + "Masukan Uang";

          String checkoutUbahCoffe = JOptionPane.showInputDialog(pembayaranUbahCoffe);
          int uang = Integer.valueOf(checkoutUbahCoffe);
          int kembalian = uang - hargaTotalUbahCoffe;

          if (Model.ubahOnlineCoffe(idTransaksi, idCustomer, menuTransaksi, mejaTransaksi, promoTransaksi,
              deskripsiTransaksi, bayarTransaksi, jumlahTransaksi, hargaTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            initsDataTransaksiCoffe();
          } else {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusTransaksiUbahCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtJumlahTransaksiUbahCoffe.setText(null);
        txtDeskripsiTransaksiUbahCoffe.setText(null);
        pilihTransaksiUbahCoffe.setSelectedItem("Pilih UbahCoffe");
        pilihMejaUbahCoffe.setSelectedItem("Pilih Meja");
        pilihPembayaranUbahCoffe.setSelectedItem("Pilih Pembayaran");
        txtHargaTransaksiUbahCoffe.setText(null);
      }
    });

    btnKembaliTransaksiUbahCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksiCoffe();
      }
    });

    content.add(labelInputTransaksiUbahCoffe);
    content.add(labelJumlahTransaksiUbahCoffe);
    content.add(txtJumlahTransaksiUbahCoffe);
    content.add(labelMejaTransaksiUbahCoffe);
    content.add(pilihMejaUbahCoffe);
    content.add(labelDeskripsiTransaksiUbahCoffe);
    content.add(txtDeskripsiTransaksiUbahCoffe);
    content.add(labelPilihTransaksiUbahCoffe);
    content.add(pilihTransaksiUbahCoffe);
    content.add(labelPembayaranUbahCoffe);
    content.add(pilihPembayaranUbahCoffe);
    content.add(labelHargaTransaksiUbahCoffe);
    content.add(txtHargaTransaksiUbahCoffe);
    content.add(labelHargaTotalUbahCoffe);
    content.add(txtTotalHargaUbahCoffe);
    content.add(btnSimpanTransaksiUbahCoffe);
    content.add(btnHapusTransaksiUbahCoffe);
    content.add(btnKembaliTransaksiUbahCoffe);

    setVisible(true);
  }

  private void initsUbahTransaksiNonCoffe(int idTransaksi) {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Input Transaksi NonCoffe");

    initializeTransaksiNonCoffe();

    Object[] detailTransaksiNonCoffe = Model.getDetailOnlineNonCoffeDiproses(idTransaksi);

    this.pilihTransaksiUbahNonCoffe.setSelectedItem(detailTransaksiNonCoffe[4].toString());
    this.pilihMejaUbahNonCoffe.setSelectedItem(detailTransaksiNonCoffe[5].toString());
    this.pilihPembayaranUbahNonCoffe.setSelectedItem(detailTransaksiNonCoffe[8].toString());
    txtDeskripsiTransaksiUbahNonCoffe.setText(detailTransaksiNonCoffe[7].toString());
    txtJumlahTransaksiUbahNonCoffe.setText(detailTransaksiNonCoffe[9].toString());
    txtHargaTransaksiUbahNonCoffe.setText(detailTransaksiNonCoffe[10].toString());

    pilihTransaksiUbahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihTransaksiUbahNonCoffe.getSelectedItem();
        if (!selectedMenu.equals("Menu UbahNonCoffe")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuUbahNonCoffe(selectedMenu);
          txtHargaTransaksiUbahNonCoffe.setText(String.valueOf(hargaMenu));
        }
      }
    });

    btnSimpanTransaksiUbahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihTransaksiUbahNonCoffe.getSelectedItem() == null
            || pilihMejaUbahNonCoffe.getSelectedItem() == null
            || pilihPembayaranUbahNonCoffe.getSelectedItem() == null
            || txtDeskripsiTransaksiUbahNonCoffe.getText().trim().isEmpty()
            || txtJumlahTransaksiUbahNonCoffe.getText().trim().isEmpty()) {
          cDashboardCustomerView.this.setVisible(false);
          if (pilihTransaksiUbahNonCoffe.getSelectedItem() == null
              || pilihTransaksiUbahNonCoffe.getSelectedItem().toString().trim().equals("Menu UbahNonCoffe")) {
            content.add(errorTransaksiUbahNonCoffe);
          } else {
            content.remove(errorTransaksiUbahNonCoffe);
          }
          if (pilihMejaUbahNonCoffe.getSelectedItem() == null
              || pilihMejaUbahNonCoffe.getSelectedItem().toString().trim().equals("Menu UbahNonCoffe")) {
            content.add(errorMejaTransaksiUbahNonCoffe);
          } else {
            content.remove(errorMejaTransaksiUbahNonCoffe);
          }
          if (pilihPembayaranUbahNonCoffe.getSelectedItem() == null
              || pilihPembayaranUbahNonCoffe.getSelectedItem().toString().trim().equals("Menu UbahNonCoffe")) {
            content.add(errorPembayaranUbahNonCoffe);
          } else {
            content.remove(errorPembayaranUbahNonCoffe);
          }
          if (txtDeskripsiTransaksiUbahNonCoffe.getText().trim().isEmpty()) {
            content.add(errorDeskripsiTransaksiUbahNonCoffe);
          } else {
            content.remove(errorDeskripsiTransaksiUbahNonCoffe);
          }
          if (txtJumlahTransaksiUbahNonCoffe.getText().trim().isEmpty()) {
            content.add(errorJumlahTransaksiUbahNonCoffe);
          } else {
            content.remove(errorJumlahTransaksiUbahNonCoffe);
          }
        } else {
          String menuTransaksi = (String) pilihTransaksiUbahNonCoffe.getSelectedItem();
          String mejaTransaksi = (String) pilihMejaUbahNonCoffe.getSelectedItem();
          String promoTransaksi = (String) pilihPromoUbahNonCoffe.getSelectedItem();
          String bayarTransaksi = (String) pilihPembayaranUbahNonCoffe.getSelectedItem();
          String deskripsiTransaksi = txtDeskripsiTransaksiUbahNonCoffe.getText();

          int jumlahTransaksi = Integer.valueOf(txtJumlahTransaksiUbahNonCoffe.getText());
          int hargaUbahNonCoffe = Integer.valueOf(txtHargaTransaksiUbahNonCoffe.getText());
          int hargaTotalUbahNonCoffe = jumlahTransaksi * hargaUbahNonCoffe;
          String TransaksiUbahNonCoffe = Integer.toString(hargaTotalUbahNonCoffe);
          txtTotalHargaUbahNonCoffe.setText(TransaksiUbahNonCoffe);
          int hargaTransaksi = Integer.parseInt(TransaksiUbahNonCoffe);

          pilihPromoUbahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
              String selectedPromo = (String) pilihPromoUbahNonCoffe.getSelectedItem();
              if (!selectedPromo.equals("Promo UbahNonCoffe")) {
                int hargaPromo = Model.getPromoMenuUbahNonCoffe(selectedPromo);
                int transaksiPromo = hargaTransaksi - hargaPromo;
                String totalHargaPromo = Integer.toString(transaksiPromo);
                txtTotalHargaUbahNonCoffe.setText(totalHargaPromo);
              }
            }
          });

          Object[] messagePromo = { "pilih Promo UbahNonCoffe", pilihPromoUbahNonCoffe };
          JOptionPane.showMessageDialog(null, messagePromo, "Promo",
              JOptionPane.PLAIN_MESSAGE);

          String pembayaranUbahNonCoffe = "Data Transaksi UbahNonCoffe" + "\n\n"
              + "menu UbahNonCoffe \n" + pilihTransaksiUbahNonCoffe.getSelectedItem() + "\n"
              + "meja UbahNonCoffe \n" + pilihMejaUbahNonCoffe.getSelectedItem() + "\n"
              + "promo UbahNonCoffe \n" + pilihPromoUbahNonCoffe.getSelectedItem() + "\n"
              + "jumlah UbahNonCoffe \n" + txtJumlahTransaksiUbahNonCoffe.getText() + "\n"
              + "harga UbahNonCoffe \n Rp. " + txtHargaTransaksiUbahNonCoffe.getText() + "\n"
              + "harga Total \n Rp. " + txtTotalHargaUbahNonCoffe.getText() + "\n"
              + "Masukan Uang";

          String checkoutUbahNonCoffe = JOptionPane.showInputDialog(pembayaranUbahNonCoffe);
          int uang = Integer.valueOf(checkoutUbahNonCoffe);
          int kembalian = uang - hargaTotalUbahNonCoffe;

          if (Model.ubahOnlineNonCoffe(idTransaksi, idCustomer, menuTransaksi, mejaTransaksi, promoTransaksi,
              deskripsiTransaksi, bayarTransaksi, jumlahTransaksi, hargaTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            initsDataTransaksiNonCoffe();
          } else {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusTransaksiUbahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtJumlahTransaksiUbahNonCoffe.setText(null);
        txtDeskripsiTransaksiUbahNonCoffe.setText(null);
        pilihTransaksiUbahNonCoffe.setSelectedItem("Pilih UbahNonCoffe");
        pilihMejaUbahNonCoffe.setSelectedItem("Pilih Meja");
        pilihPembayaranUbahNonCoffe.setSelectedItem("Pilih Pembayaran");
        txtHargaTransaksiUbahNonCoffe.setText(null);
      }
    });

    btnKembaliTransaksiUbahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataTransaksiNonCoffe();
      }
    });

    content.add(labelInputTransaksiUbahNonCoffe);
    content.add(labelJumlahTransaksiUbahNonCoffe);
    content.add(txtJumlahTransaksiUbahNonCoffe);
    content.add(labelMejaTransaksiUbahNonCoffe);
    content.add(pilihMejaUbahNonCoffe);
    content.add(labelDeskripsiTransaksiUbahNonCoffe);
    content.add(txtDeskripsiTransaksiUbahNonCoffe);
    content.add(labelPilihTransaksiUbahNonCoffe);
    content.add(pilihTransaksiUbahNonCoffe);
    content.add(labelPembayaranUbahNonCoffe);
    content.add(pilihPembayaranUbahNonCoffe);
    content.add(labelHargaTransaksiUbahNonCoffe);
    content.add(txtHargaTransaksiUbahNonCoffe);
    content.add(labelHargaTotalUbahNonCoffe);
    content.add(txtTotalHargaUbahNonCoffe);
    content.add(btnSimpanTransaksiUbahNonCoffe);
    content.add(btnHapusTransaksiUbahNonCoffe);
    content.add(btnKembaliTransaksiUbahNonCoffe);

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

    initializeTransaksiMakanan();

    txtJumlahTransaksiMakanan.setText(null);
    txtDeskripsiTransaksiMakanan.setText(null);
    pilihTransaksiMakanan.setSelectedIndex(0);
    pilihMejaMakanan.setSelectedIndex(0);
    pilihPromoMakanan.setSelectedIndex(0);
    txtHargaTransaksiMakanan.setText(null);

    pilihTransaksiMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihTransaksiMakanan.getSelectedItem();
        if (!selectedMenu.equals("Menu Makanan")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuMakanan(selectedMenu);
          txtHargaTransaksiMakanan.setText(String.valueOf(hargaMenu));
        }
      }
    });

    btnSimpanTransaksiMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihTransaksiMakanan.getSelectedItem() == null
            || pilihMejaMakanan.getSelectedItem() == null
            || pilihPembayaranMakanan.getSelectedItem() == null
            || txtDeskripsiTransaksiMakanan.getText().trim().isEmpty()
            || txtJumlahTransaksiMakanan.getText().trim().isEmpty()) {
          cDashboardCustomerView.this.setVisible(false);
          if (pilihTransaksiMakanan.getSelectedItem() == null
              || pilihTransaksiMakanan.getSelectedItem().toString().trim().equals("Menu Makanan")) {
            content.add(errorTransaksiMakanan);
          } else {
            content.remove(errorTransaksiMakanan);
          }
          if (pilihMejaMakanan.getSelectedItem() == null
              || pilihMejaMakanan.getSelectedItem().toString().trim().equals("Menu Makanan")) {
            content.add(errorMejaTransaksiMakanan);
          } else {
            content.remove(errorMejaTransaksiMakanan);
          }
          if (pilihPembayaranMakanan.getSelectedItem() == null
              || pilihPembayaranMakanan.getSelectedItem().toString().trim().equals("Menu Makanan")) {
            content.add(errorPembayaranMakanan);
          } else {
            content.remove(errorPembayaranMakanan);
          }
          if (txtDeskripsiTransaksiMakanan.getText().trim().isEmpty()) {
            content.add(errorDeskripsiTransaksiMakanan);
          } else {
            content.remove(errorDeskripsiTransaksiMakanan);
          }
          if (txtJumlahTransaksiMakanan.getText().trim().isEmpty()) {
            content.add(errorJumlahTransaksiMakanan);
          } else {
            content.remove(errorJumlahTransaksiMakanan);
          }
        } else {
          String menuTransaksi = (String) pilihTransaksiMakanan.getSelectedItem();
          String mejaTransaksi = (String) pilihMejaMakanan.getSelectedItem();
          String promoTransaksi = (String) pilihPromoMakanan.getSelectedItem();
          String bayarTransaksi = (String) pilihPembayaranMakanan.getSelectedItem();
          String deskripsiTransaksi = txtDeskripsiTransaksiMakanan.getText();

          int jumlahTransaksi = Integer.valueOf(txtJumlahTransaksiMakanan.getText());
          int hargaMakanan = Integer.valueOf(txtHargaTransaksiMakanan.getText());
          int hargaTotalMakanan = jumlahTransaksi * hargaMakanan;
          String TransaksiMakanan = Integer.toString(hargaTotalMakanan);
          txtTotalHargaMakanan.setText(TransaksiMakanan);
          int hargaTransaksi = Integer.parseInt(TransaksiMakanan);

          pilihPromoMakanan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
              String selectedPromo = (String) pilihPromoMakanan.getSelectedItem();
              if (!selectedPromo.equals("Promo Makanan")) {
                int hargaPromo = Model.getPromoMenuMakanan(selectedPromo);
                int transaksiPromo = hargaTransaksi - hargaPromo;
                String totalHargaPromo = Integer.toString(transaksiPromo);
                txtTotalHargaMakanan.setText(totalHargaPromo);
              }
            }
          });

          Object[] messagePromo = { "pilih Promo Makanan", pilihPromoMakanan };
          JOptionPane.showMessageDialog(null, messagePromo, "Promo",
              JOptionPane.PLAIN_MESSAGE);

          String pembayaranMakanan = "Data Transaksi Makanan" + "\n\n"
              + "menu Makanan \n" + pilihTransaksiMakanan.getSelectedItem() + "\n"
              + "meja Makanan \n" + pilihMejaMakanan.getSelectedItem() + "\n"
              + "promo Makanan \n" + pilihPromoMakanan.getSelectedItem() + "\n"
              + "jumlah makanan \n" + txtJumlahTransaksiMakanan.getText() + "\n"
              + "harga Makanan \n Rp. " + txtHargaTransaksiMakanan.getText() + "\n"
              + "harga Total \n Rp. " + txtTotalHargaMakanan.getText() + "\n"
              + "Masukan Uang";

          String checkoutMakanan = JOptionPane.showInputDialog(pembayaranMakanan);
          int uang = Integer.valueOf(checkoutMakanan);
          int kembalian = uang - hargaTotalMakanan;

          if (Model.tambahOnlineMakanan(idCustomer, menuTransaksi, mejaTransaksi, promoTransaksi, deskripsiTransaksi,
              bayarTransaksi, jumlahTransaksi, hargaTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            txtJumlahTransaksiMakanan.setText(null);
            txtDeskripsiTransaksiMakanan.setText(null);
            pilihTransaksiMakanan.setSelectedIndex(0);
            pilihMejaMakanan.setSelectedIndex(0);
            pilihPromoMakanan.setSelectedIndex(0);
            txtHargaTransaksiMakanan.setText(null);
          } else {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }

        }
      }
    });

    btnHapusTransaksiMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtJumlahTransaksiMakanan.setText(null);
        txtDeskripsiTransaksiMakanan.setText(null);
        pilihTransaksiMakanan.setSelectedItem("Pilih Makanan");
        pilihMejaMakanan.setSelectedItem("Pilih Meja");
        pilihPembayaranMakanan.setSelectedItem("Pilih Pembayaran");
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
    content.add(labelJumlahTransaksiMakanan);
    content.add(txtJumlahTransaksiMakanan);
    content.add(labelMejaTransaksiMakanan);
    content.add(pilihMejaMakanan);
    content.add(labelDeskripsiTransaksiMakanan);
    content.add(txtDeskripsiTransaksiMakanan);
    content.add(labelPilihTransaksiMakanan);
    content.add(pilihTransaksiMakanan);
    content.add(labelPembayaranMakanan);
    content.add(pilihPembayaranMakanan);
    content.add(labelHargaTransaksiMakanan);
    content.add(txtHargaTransaksiMakanan);
    content.add(labelHargaTotalMakanan);
    content.add(txtTotalHargaMakanan);
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

    initializeTransaksiCoffe();

    txtJumlahTransaksiCoffe.setText(null);
    txtDeskripsiTransaksiCoffe.setText(null);
    pilihTransaksiCoffe.setSelectedIndex(0);
    pilihMejaCoffe.setSelectedIndex(0);
    pilihPromoCoffe.setSelectedIndex(0);
    txtHargaTransaksiCoffe.setText(null);

    pilihTransaksiCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihTransaksiCoffe.getSelectedItem();
        if (!selectedMenu.equals("Menu Coffe")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuCoffe(selectedMenu);
          txtHargaTransaksiCoffe.setText(String.valueOf(hargaMenu));
        }
      }
    });

    btnSimpanTransaksiCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihTransaksiCoffe.getSelectedItem() == null
            || pilihMejaCoffe.getSelectedItem() == null
            || pilihPembayaranCoffe.getSelectedItem() == null
            || txtDeskripsiTransaksiCoffe.getText().trim().isEmpty()
            || txtJumlahTransaksiCoffe.getText().trim().isEmpty()) {
          cDashboardCustomerView.this.setVisible(false);
          if (pilihTransaksiCoffe.getSelectedItem() == null
              || pilihTransaksiCoffe.getSelectedItem().toString().trim().equals("Menu Coffe")) {
            content.add(errorTransaksiCoffe);
          } else {
            content.remove(errorTransaksiCoffe);
          }
          if (pilihMejaCoffe.getSelectedItem() == null
              || pilihMejaCoffe.getSelectedItem().toString().trim().equals("Menu Coffe")) {
            content.add(errorMejaTransaksiCoffe);
          } else {
            content.remove(errorMejaTransaksiCoffe);
          }
          if (pilihPembayaranCoffe.getSelectedItem() == null
              || pilihPembayaranCoffe.getSelectedItem().toString().trim().equals("Menu Coffe")) {
            content.add(errorPembayaranCoffe);
          } else {
            content.remove(errorPembayaranCoffe);
          }
          if (txtDeskripsiTransaksiCoffe.getText().trim().isEmpty()) {
            content.add(errorDeskripsiTransaksiCoffe);
          } else {
            content.remove(errorDeskripsiTransaksiCoffe);
          }
          if (txtJumlahTransaksiCoffe.getText().trim().isEmpty()) {
            content.add(errorJumlahTransaksiCoffe);
          } else {
            content.remove(errorJumlahTransaksiCoffe);
          }
        } else {
          String menuTransaksi = (String) pilihTransaksiCoffe.getSelectedItem();
          String mejaTransaksi = (String) pilihMejaCoffe.getSelectedItem();
          String promoTransaksi = (String) pilihPromoCoffe.getSelectedItem();
          String bayarTransaksi = (String) pilihPembayaranCoffe.getSelectedItem();
          String deskripsiTransaksi = txtDeskripsiTransaksiCoffe.getText();

          int jumlahTransaksi = Integer.valueOf(txtJumlahTransaksiCoffe.getText());
          int hargaCoffe = Integer.valueOf(txtHargaTransaksiCoffe.getText());
          int hargaTotalCoffe = jumlahTransaksi * hargaCoffe;
          String TransaksiCoffe = Integer.toString(hargaTotalCoffe);
          txtTotalHargaCoffe.setText(TransaksiCoffe);
          int hargaTransaksi = Integer.parseInt(TransaksiCoffe);

          pilihPromoCoffe.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
              String selectedPromo = (String) pilihPromoCoffe.getSelectedItem();
              if (!selectedPromo.equals("Promo Coffe")) {
                int hargaPromo = Model.getPromoMenuCoffe(selectedPromo);
                int transaksiPromo = hargaTransaksi - hargaPromo;
                String totalHargaPromo = Integer.toString(transaksiPromo);
                txtTotalHargaCoffe.setText(totalHargaPromo);
              }
            }
          });

          Object[] messagePromo = { "pilih Promo Coffe", pilihPromoCoffe };
          JOptionPane.showMessageDialog(null, messagePromo, "Promo",
              JOptionPane.PLAIN_MESSAGE);

          String pembayaranCoffe = "Data Transaksi Coffe" + "\n\n"
              + "menu Coffe \n" + pilihTransaksiCoffe.getSelectedItem() + "\n"
              + "meja Coffe \n" + pilihMejaCoffe.getSelectedItem() + "\n"
              + "promo Coffe \n" + pilihPromoCoffe.getSelectedItem() + "\n"
              + "jumlah Coffe \n" + txtJumlahTransaksiCoffe.getText() + "\n"
              + "harga Coffe \n Rp. " + txtHargaTransaksiCoffe.getText() + "\n"
              + "harga Total \n Rp. " + txtTotalHargaCoffe.getText() + "\n"
              + "Masukan Uang";

          String checkoutCoffe = JOptionPane.showInputDialog(pembayaranCoffe);
          int uang = Integer.valueOf(checkoutCoffe);
          int kembalian = uang - hargaTotalCoffe;

          if (Model.tambahOnlineCoffe(idCustomer, menuTransaksi, mejaTransaksi, promoTransaksi, deskripsiTransaksi,
              bayarTransaksi, jumlahTransaksi, hargaTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            txtJumlahTransaksiCoffe.setText(null);
            txtDeskripsiTransaksiCoffe.setText(null);
            pilihTransaksiCoffe.setSelectedIndex(0);
            pilihMejaCoffe.setSelectedIndex(0);
            pilihPromoCoffe.setSelectedIndex(0);
            txtHargaTransaksiCoffe.setText(null);
          } else {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }

        }
      }
    });

    btnHapusTransaksiCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtJumlahTransaksiCoffe.setText(null);
        txtDeskripsiTransaksiCoffe.setText(null);
        pilihTransaksiCoffe.setSelectedItem("Pilih Coffe");
        pilihMejaCoffe.setSelectedItem("Pilih Meja");
        pilihPembayaranCoffe.setSelectedItem("Pilih Pembayaran");
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
    content.add(labelJumlahTransaksiCoffe);
    content.add(txtJumlahTransaksiCoffe);
    content.add(labelMejaTransaksiCoffe);
    content.add(pilihMejaCoffe);
    content.add(labelDeskripsiTransaksiCoffe);
    content.add(txtDeskripsiTransaksiCoffe);
    content.add(labelPilihTransaksiCoffe);
    content.add(pilihTransaksiCoffe);
    content.add(labelPembayaranCoffe);
    content.add(pilihPembayaranCoffe);
    content.add(labelHargaTransaksiCoffe);
    content.add(txtHargaTransaksiCoffe);
    content.add(labelHargaTotalCoffe);
    content.add(txtTotalHargaCoffe);
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
    menuTitle.setText("Input Transaksi NonCoffe");

    initializeTransaksiNonCoffe();

    txtJumlahTransaksiNonCoffe.setText(null);
    txtDeskripsiTransaksiNonCoffe.setText(null);
    pilihTransaksiNonCoffe.setSelectedIndex(0);
    pilihMejaNonCoffe.setSelectedIndex(0);
    pilihPromoNonCoffe.setSelectedIndex(0);
    txtHargaTransaksiNonCoffe.setText(null);

    pilihTransaksiNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedMenu = (String) pilihTransaksiNonCoffe.getSelectedItem();
        if (!selectedMenu.equals("Menu NonCoffe")) {
          // Mengambil harga menu
          int hargaMenu = Model.getHargaMenuNonCoffe(selectedMenu);
          txtHargaTransaksiNonCoffe.setText(String.valueOf(hargaMenu));
        }
      }
    });

    btnSimpanTransaksiNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihTransaksiNonCoffe.getSelectedItem() == null
            || pilihMejaNonCoffe.getSelectedItem() == null
            || pilihPembayaranNonCoffe.getSelectedItem() == null
            || txtDeskripsiTransaksiNonCoffe.getText().trim().isEmpty()
            || txtJumlahTransaksiNonCoffe.getText().trim().isEmpty()) {
          cDashboardCustomerView.this.setVisible(false);
          if (pilihTransaksiNonCoffe.getSelectedItem() == null
              || pilihTransaksiNonCoffe.getSelectedItem().toString().trim().equals("Menu NonCoffe")) {
            content.add(errorTransaksiNonCoffe);
          } else {
            content.remove(errorTransaksiNonCoffe);
          }
          if (pilihMejaNonCoffe.getSelectedItem() == null
              || pilihMejaNonCoffe.getSelectedItem().toString().trim().equals("Menu NonCoffe")) {
            content.add(errorMejaTransaksiNonCoffe);
          } else {
            content.remove(errorMejaTransaksiNonCoffe);
          }
          if (pilihPembayaranNonCoffe.getSelectedItem() == null
              || pilihPembayaranNonCoffe.getSelectedItem().toString().trim().equals("Menu NonCoffe")) {
            content.add(errorPembayaranNonCoffe);
          } else {
            content.remove(errorPembayaranNonCoffe);
          }
          if (txtDeskripsiTransaksiNonCoffe.getText().trim().isEmpty()) {
            content.add(errorDeskripsiTransaksiNonCoffe);
          } else {
            content.remove(errorDeskripsiTransaksiNonCoffe);
          }
          if (txtJumlahTransaksiNonCoffe.getText().trim().isEmpty()) {
            content.add(errorJumlahTransaksiNonCoffe);
          } else {
            content.remove(errorJumlahTransaksiNonCoffe);
          }
        } else {
          String menuTransaksi = (String) pilihTransaksiNonCoffe.getSelectedItem();
          String mejaTransaksi = (String) pilihMejaNonCoffe.getSelectedItem();
          String promoTransaksi = (String) pilihPromoNonCoffe.getSelectedItem();
          String bayarTransaksi = (String) pilihPembayaranNonCoffe.getSelectedItem();
          String deskripsiTransaksi = txtDeskripsiTransaksiNonCoffe.getText();

          int jumlahTransaksi = Integer.valueOf(txtJumlahTransaksiNonCoffe.getText());
          int hargaNonCoffe = Integer.valueOf(txtHargaTransaksiNonCoffe.getText());
          int hargaTotalNonCoffe = jumlahTransaksi * hargaNonCoffe;
          String TransaksiNonCoffe = Integer.toString(hargaTotalNonCoffe);
          txtTotalHargaNonCoffe.setText(TransaksiNonCoffe);
          int hargaTransaksi = Integer.parseInt(TransaksiNonCoffe);

          pilihPromoNonCoffe.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
              String selectedPromo = (String) pilihPromoNonCoffe.getSelectedItem();
              if (!selectedPromo.equals("Promo NonCoffe")) {
                int hargaPromo = Model.getPromoMenuNonCoffe(selectedPromo);
                int transaksiPromo = hargaTransaksi - hargaPromo;
                String totalHargaPromo = Integer.toString(transaksiPromo);
                txtTotalHargaNonCoffe.setText(totalHargaPromo);
              }
            }
          });

          Object[] messagePromo = { "pilih Promo NonCoffe", pilihPromoNonCoffe };
          JOptionPane.showMessageDialog(null, messagePromo, "Promo",
              JOptionPane.PLAIN_MESSAGE);

          String pembayaranNonCoffe = "Data Transaksi NonCoffe" + "\n\n"
              + "menu NonCoffe \n" + pilihTransaksiNonCoffe.getSelectedItem() + "\n"
              + "meja NonCoffe \n" + pilihMejaNonCoffe.getSelectedItem() + "\n"
              + "promo NonCoffe \n" + pilihPromoNonCoffe.getSelectedItem() + "\n"
              + "jumlah NonCoffe \n" + txtJumlahTransaksiNonCoffe.getText() + "\n"
              + "harga NonCoffe \n Rp. " + txtHargaTransaksiNonCoffe.getText() + "\n"
              + "harga Total \n Rp. " + txtTotalHargaNonCoffe.getText() + "\n"
              + "Masukan Uang";

          String checkoutNonCoffe = JOptionPane.showInputDialog(pembayaranNonCoffe);
          int uang = Integer.valueOf(checkoutNonCoffe);
          int kembalian = uang - hargaTotalNonCoffe;

          if (Model.tambahOnlineNonCoffe(idCustomer, menuTransaksi, mejaTransaksi, promoTransaksi, deskripsiTransaksi,
              bayarTransaksi, jumlahTransaksi, hargaTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            txtJumlahTransaksiNonCoffe.setText(null);
            txtDeskripsiTransaksiNonCoffe.setText(null);
            pilihTransaksiNonCoffe.setSelectedIndex(0);
            pilihMejaNonCoffe.setSelectedIndex(0);
            pilihPromoNonCoffe.setSelectedIndex(0);
            txtHargaTransaksiNonCoffe.setText(null);
          } else {
            JOptionPane.showMessageDialog(cDashboardCustomerView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }

        }
      }
    });

    btnHapusTransaksiNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtJumlahTransaksiNonCoffe.setText(null);
        txtDeskripsiTransaksiNonCoffe.setText(null);
        pilihTransaksiNonCoffe.setSelectedItem("Pilih NonCoffe");
        pilihMejaNonCoffe.setSelectedItem("Pilih Meja");
        pilihPembayaranNonCoffe.setSelectedItem("Pilih Pembayaran");
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
    content.add(labelJumlahTransaksiNonCoffe);
    content.add(txtJumlahTransaksiNonCoffe);
    content.add(labelMejaTransaksiNonCoffe);
    content.add(pilihMejaNonCoffe);
    content.add(labelDeskripsiTransaksiNonCoffe);
    content.add(txtDeskripsiTransaksiNonCoffe);
    content.add(labelPilihTransaksiNonCoffe);
    content.add(pilihTransaksiNonCoffe);
    content.add(labelPembayaranNonCoffe);
    content.add(pilihPembayaranNonCoffe);
    content.add(labelHargaTransaksiNonCoffe);
    content.add(txtHargaTransaksiNonCoffe);
    content.add(labelHargaTotalNonCoffe);
    content.add(txtTotalHargaNonCoffe);
    content.add(btnSimpanTransaksiNonCoffe);
    content.add(btnHapusTransaksiNonCoffe);
    content.add(btnKembaliTransaksiNonCoffe);

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

    tblTransaksiMakanan = new cTable(Model.getAllOnlineMakananSelesai());

    tblTransaksiMakanan.getColumnModel().getColumn(0).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(0).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(0).setWidth(0);

    tblTransaksiMakanan.getColumnModel().getColumn(1).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(1).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(1).setWidth(0);

    tblTransaksiMakanan.getColumnModel().getColumn(2).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(2).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(2).setWidth(0);

    tblTransaksiMakanan.getColumnModel().getColumn(7).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(7).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(7).setWidth(0);

    tblTransaksiMakanan.getColumnModel().getColumn(8).setMinWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(8).setMaxWidth(0);
    tblTransaksiMakanan.getColumnModel().getColumn(8).setWidth(0);

    spTransaksiMakanan = new cScrollPane(tblTransaksiMakanan, 0, 140, 1100, 300);

    content.add(spTransaksiMakanan);

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

    tblTransaksiCoffe = new cTable(Model.getAllOnlineCoffeSelesai());

    tblTransaksiCoffe.getColumnModel().getColumn(0).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(0).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(0).setWidth(0);

    tblTransaksiCoffe.getColumnModel().getColumn(1).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(1).setWidth(0);

    tblTransaksiCoffe.getColumnModel().getColumn(2).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(2).setWidth(0);

    tblTransaksiCoffe.getColumnModel().getColumn(7).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(7).setWidth(0);

    tblTransaksiCoffe.getColumnModel().getColumn(8).setMinWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(8).setMaxWidth(0);
    tblTransaksiCoffe.getColumnModel().getColumn(8).setWidth(0);

    spTransaksiCoffe = new cScrollPane(tblTransaksiCoffe, 0, 140, 1100, 300);

    content.add(spTransaksiCoffe);

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

    tblTransaksiNonCoffe = new cTable(Model.getAllOnlineNonCoffeSelesai());

    tblTransaksiNonCoffe.getColumnModel().getColumn(0).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(0).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(0).setWidth(0);

    tblTransaksiNonCoffe.getColumnModel().getColumn(1).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(1).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(1).setWidth(0);

    tblTransaksiNonCoffe.getColumnModel().getColumn(2).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(2).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(2).setWidth(0);

    tblTransaksiNonCoffe.getColumnModel().getColumn(7).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(7).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(7).setWidth(0);

    tblTransaksiNonCoffe.getColumnModel().getColumn(8).setMinWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(8).setMaxWidth(0);
    tblTransaksiNonCoffe.getColumnModel().getColumn(8).setWidth(0);

    spTransaksiNonCoffe = new cScrollPane(tblTransaksiNonCoffe, 0, 140, 1100, 300);

    content.add(spTransaksiNonCoffe);

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

  private void initsLogout() {
    cDashboardCustomerView.this.setVisible(false);
  }

}