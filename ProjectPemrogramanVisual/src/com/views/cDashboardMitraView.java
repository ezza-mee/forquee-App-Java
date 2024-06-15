package com.views;

import com.templates.cDashboardApp;
import com.partials.*;
import com.main.*;

import java.util.ArrayList;

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
  private cComboBox pilihDataMenu = new cComboBox(
      new String[] { "Data Makanan", "Data Coffe", "Data Non Coffe" }, 100, 40, 200,
      30);
  // component of data menu
  private cComboBox pilihTransaksiMenu = new cComboBox(
      new String[] { "Makanan", "Coffe", "Non Coffe" }, 100, 40, 200,
      30);

  // component of data menu makanan
  private cLabelInfo labelCariMenuMakanan = new cLabelInfo("Cari", 40, 90, 300, 40);
  private cTextField txtCariMenuMakanan = new cTextField(100, 90, 300);
  private cTable tblMenuMakanan;
  private cScrollPane spMenuMakanan;
  private cButton btnTambahMakanan = new cButton("Tambah", 440, 90, 150, 30, 20);
  private cButton btnEditDataMakanan = new cButton("Edit", 630, 90, 150, 30, 20);
  private cButton btnHapusDataMakanan = new cButton("Hapus", 820, 90, 150, 30, 20);
  private cButton btnKembaliMakanan = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of data menu coffe
  private cLabelInfo labelCariMenuCoffe = new cLabelInfo("Cari", 40, 90, 300, 40);
  private cTextField txtCariMenuCoffe = new cTextField(100, 90, 300);
  private cTable tblMenuCoffe;
  private cScrollPane spMenuCoffe;
  private cButton btnTambahCoffe = new cButton("Tambah", 440, 90, 150, 30, 20);
  private cButton btnEditDataCoffe = new cButton("Edit", 630, 90, 150, 30, 20);
  private cButton btnHapusDataCoffe = new cButton("Hapus", 820, 90, 150, 30, 20);
  private cButton btnKembaliCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of data menu non coffe
  private cLabelInfo labelCariMenuNonCoffe = new cLabelInfo("Cari", 40, 90, 300, 40);
  private cTextField txtCariMenuNonCoffe = new cTextField(100, 90, 300);
  private cTable tblMenuNonCoffe;
  private cScrollPane spMenuNonCoffe;
  private cButton btnTambahNonCoffe = new cButton("Tambah", 440, 90, 150, 30, 20);
  private cButton btnEditDataNonCoffe = new cButton("Edit", 630, 90, 150, 30, 20);
  private cButton btnHapusDataNonCoffe = new cButton("Hapus", 820, 90, 150, 30, 20);
  private cButton btnKembaliNonCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

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
  private cButton btnHapusCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of input data menu Non Coffe
  private cLabelInfo labelInputMenuNonCoffe = new cLabelInfo("Masukan Data Menu Non Coffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaNonCoffe = new cLabelInfo("Nama Non Coffe", 190, 90, 300, 40);
  private cTextField txtNamaNonCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaNonCoffe = new cErrorLabel("Nama Non Coffe tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahNonCoffe = new cLabelInfo("Jumlah Non Coffe", 190, 180, 300, 40);
  private cTextField txtJumlahNonCoffe = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahNonCoffe = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelHargaNonCoffe = new cLabelInfo("Harga Non Coffe", 190, 270, 300, 40);
  private cTextField txtHargaNonCoffe = new cTextField(190, 302, 300);
  private cErrorLabel errorHargaNonCoffe = new cErrorLabel("Harga Non Coffe tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelDeskripsiNonCoffe = new cLabelInfo("Deskripsi NonCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiNonCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiNonCoffe = new cErrorLabel("Deskripsi Non Coffe tidak boleh Kosong!", 580, 235,
      300);
  private cButton btnHapusNonCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanNonCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of input ubah menu makanan
  private cLabelInfo labelInputMenuUbahMakanan = new cLabelInfo("Masukan Data Menu Makanan!", 190, 40, 400, 40);
  private cLabelInfo labelNamaUbahMakanan = new cLabelInfo("Nama Makanan", 190, 90, 300, 40);
  private cTextField txtNamaUbahMakanan = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaUbahMakanan = new cErrorLabel("Nama Makanan tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahUbahMakanan = new cLabelInfo("Jumlah Makanan", 190, 180, 300, 40);
  private cTextField txtJumlahUbahMakanan = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahUbahMakanan = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelHargaUbahMakanan = new cLabelInfo("Harga Makanan", 190, 270, 300, 40);
  private cTextField txtHargaUbahMakanan = new cTextField(190, 302, 300);
  private cErrorLabel errorHargaUbahMakanan = new cErrorLabel("Harga Makanan tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelDeskripsiUbahMakanan = new cLabelInfo("Deskripsi Makanan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiUbahMakanan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiUbahMakanan = new cErrorLabel("Deskripsi Makanan tidak boleh Kosong!", 580, 235,
      300);
  private cButton btnHapusUbahMakanan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanUbahMakanan = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cButton btnKembaliUbahMakanan = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of input ubah menu Coffe
  private cLabelInfo labelInputMenuUbahCoffe = new cLabelInfo("Ubah Data Menu Coffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaUbahCoffe = new cLabelInfo("Nama Coffe", 190, 90, 300, 40);
  private cTextField txtNamaUbahCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaUbahCoffe = new cErrorLabel("Nama Coffe tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahUbahCoffe = new cLabelInfo("Jumlah Coffe", 190, 180, 300, 40);
  private cTextField txtJumlahUbahCoffe = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahUbahCoffe = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelHargaUbahCoffe = new cLabelInfo("Harga Coffe", 190, 270, 300, 40);
  private cTextField txtHargaUbahCoffe = new cTextField(190, 302, 300);
  private cErrorLabel errorHargaUbahCoffe = new cErrorLabel("Harga Coffe tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelDeskripsiUbahCoffe = new cLabelInfo("Deskripsi Coffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiUbahCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiUbahCoffe = new cErrorLabel("Deskripsi Coffe tidak boleh Kosong!", 580, 235,
      300);
  private cButton btnHapusUbahCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanUbahCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cButton btnKembaliUbahCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of input ubah menu Non Coffe
  private cLabelInfo labelInputMenuUbahNonCoffe = new cLabelInfo("Masukan Data Menu Non Coffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaUbahNonCoffe = new cLabelInfo("Nama Non Coffe", 190, 90, 300, 40);
  private cTextField txtNamaUbahNonCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaUbahNonCoffe = new cErrorLabel("Nama Non Coffe tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahUbahNonCoffe = new cLabelInfo("Jumlah Non Coffe", 190, 180, 300, 40);
  private cTextField txtJumlahUbahNonCoffe = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahUbahNonCoffe = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelHargaUbahNonCoffe = new cLabelInfo("Harga Non Coffe", 190, 270, 300, 40);
  private cTextField txtHargaUbahNonCoffe = new cTextField(190, 302, 300);
  private cErrorLabel errorHargaUbahNonCoffe = new cErrorLabel("Harga Non Coffe tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelDeskripsiUbahNonCoffe = new cLabelInfo("Deskripsi Non Coffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiUbahNonCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiUbahNonCoffe = new cErrorLabel("Deskripsi Non Coffe tidak boleh Kosong!", 580,
      235,
      300);
  private cButton btnHapusUbahNonCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanUbahNonCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cButton btnKembaliUbahNonCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of data Promo
  private cLabelInfo labelPromo = new cLabelInfo("Data Promo Menu", 40, 40, 300, 40);
  private cLabelInfo labelCariPromo = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariPromo = new cTextField(100, 100, 300);
  private cButton btnTambahPromo = new cButton("Tambah", 450, 100, 150, 30, 20);
  private cButton btnHapusDataPromo = new cButton("Hapus", 630, 100, 150, 30, 20);
  private cButton btnEditDataPromo = new cButton("Edit", 810, 100, 150, 30, 20);
  private cButton btnKembaliPromo = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cTable tblDataPromo;
  private cScrollPane spDataPromo;

  // component of input promo
  private cLabelInfo labelInputPromo = new cLabelInfo("Masukan Data Promo!", 190, 40, 400, 40);
  private cLabelInfo labelNamaPromo = new cLabelInfo("Nama Promo", 190, 90, 300, 40);
  private cTextField txtNamaPromo = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaPromo = new cErrorLabel("Nama Promo tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahPromo = new cLabelInfo("Jumlah Promo", 190, 180, 300, 40);
  private cTextField txtJumlahPromo = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahPromo = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelPilihMenuPromo = new cLabelInfo("Menu Promo", 190, 270, 300, 40);
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
  private cComboBox pilihMenuPromo;

  // component of data meja
  private cLabelInfo labelMeja = new cLabelInfo("Data Ready Meja", 40, 40, 300, 40);
  private cLabelInfo labelCariMeja = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariMeja = new cTextField(100, 100, 300);
  private cButton btnTambahMeja = new cButton("Tambah", 450, 100, 150, 30, 20);
  private cButton btnHapusDataMeja = new cButton("Hapus", 630, 100, 150, 30, 20);
  private cButton btnEditDataMeja = new cButton("Edit", 800, 100, 150, 30, 20);
  private cButton btnKembaliMeja = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliUbahMeja = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cTable tblDataMeja;
  private cScrollPane spDataMeja;

  // component of input data meja
  private cLabelInfo labelInputMeja = new cLabelInfo("Masukan Data Meja!", 190, 40, 400, 40);
  private cLabelInfo labelNomorMeja = new cLabelInfo("Nomor Meja", 190, 90, 300, 40);
  private cComboBox pilihNomorMeja = new cComboBox(new String[] { "Nomor Meja", "a1", "a2", "a3" }, 190, 120, 300, 30);
  private cErrorLabel errorNomorMeja = new cErrorLabel("Nomor Meja tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelPilihMeja = new cLabelInfo("Jenis Meja", 190, 180, 300, 40);
  private cComboBox pilihMeja = new cComboBox(new String[] { "jenis Meja", "VIP", "Reguler", "Non Reguler" }, 190, 210,
      300, 30);
  private cErrorLabel errorMeja = new cErrorLabel("Jenis Meja tidak boleh Kosong!", 190, 235, 300);
  private cLabelInfo labelDeskripsiMeja = new cLabelInfo("Deskripsi Meja", 580, 90, 300, 40);
  private cTextarea txtDeskripsiMeja = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiMeja = new cErrorLabel("Deskripsi Meja tidak boleh Kosong!", 580, 235,
      300);
  private cButton btnHapusMeja = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanMeja = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of input Ubah meja
  private cLabelInfo labelInputUbahMeja = new cLabelInfo("Masukan Data untuk ubah Data Meja!", 190, 40, 400, 40);
  private cLabelInfo labelNomorUbahMeja = new cLabelInfo("Nomor Meja", 190, 90, 300, 40);
  private cComboBox pilihNomorUbahMeja = new cComboBox(new String[] { "Nomor Meja", "a1", "a2", "a3" }, 190, 120, 300,
      30);
  private cErrorLabel errorNomorUbahMeja = new cErrorLabel("Nomor Meja tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelPilihUbahMeja = new cLabelInfo("Jenis Meja", 190, 180, 300, 40);
  private cComboBox pilihUbahMeja = new cComboBox(new String[] { "jenis Meja", "VIP", "Reguler", "Non Reguler" }, 190,
      210,
      300, 30);
  private cErrorLabel errorUbahMeja = new cErrorLabel("Jenis Meja tidak boleh Kosong!", 190, 235, 300);
  private cLabelInfo labelDeskripsiUbahMeja = new cLabelInfo("Deskripsi Meja", 580, 90, 300, 40);
  private cTextarea txtDeskripsiUbahMeja = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiUbahMeja = new cErrorLabel("Deskripsi Meja tidak boleh Kosong!", 580, 235,
      300);
  private cButton btnHapusUbahMeja = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanUbahMeja = new cButton("Simpan", 730, 480, 150, 30, 20);

  // componenet of data customer
  private cLabelInfo labelCustomer = new cLabelInfo("Data Customer Aktif", 40, 40, 300, 40);
  private cLabelInfo labelCariCustomer = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariCustomer = new cTextField(100, 100, 300);
  private cTable tblDataCustomer;
  private cScrollPane spDataCustomer;

  // component of data karyawan
  private cLabelInfo labelKaryawan = new cLabelInfo("Data Ready Karyawan", 40, 40, 300, 40);
  private cLabelInfo labelCariKaryawan = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariKaryawan = new cTextField(100, 100, 300);
  private cButton btnTambahKaryawan = new cButton("Tambah", 450, 100, 150, 30, 20);
  private cButton btnHapusDataKaryawan = new cButton("Hapus", 630, 100, 150, 30, 20);
  private cButton btnEditDataKaryawan = new cButton("Edit", 800, 100, 150, 30, 20);
  private cButton btnKembaliKaryawan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cTable tblDataKaryawan;
  private cScrollPane spDataKaryawan;

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
  private cComboBox pilihJobdeskKaryawan = new cComboBox(
      new String[] { "Operator Mesin", "Petugas Layanan", "Teknisi Mesin", "Administrasi",
          "Supervisor", "Staf", "Kasir" },
      580, 135, 300, 30);
  private cButton btnHapusKaryawan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanKaryawan = new cButton("Simpan", 730, 480, 150, 30, 20);

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
  private cLabelInfo labelNamaTransaksiMakanan = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaTransaksiMakanan = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaTransaksiMakanan = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihTransaksiMakanan = new cLabelInfo("Menu Makanan", 190, 180, 300, 40);
  private cErrorLabel errorTransaksiMakanan = new cErrorLabel("Menu Makanan tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiTransaksiMakanan = new cLabelInfo("Deskripsi Makanan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiMakanan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiMakanan = new cErrorLabel(
      "Deskripsi Makanan tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiMakanan = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cErrorLabel errorMejaTransaksiMakanan = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahTransaksiMakanan = new cLabelInfo("Jumlah Makanan", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiMakanan = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiMakanan = new cErrorLabel("Jumlah Makanan tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelPembayaranMakanan = new cLabelInfo("Pilih Promo", 190, 360, 300, 40);
  private cLabelInfo labelHargaTransaksiMakanan = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiMakanan = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiMakanan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiMakanan = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cComboBox pilihPembayaranMakanan = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 390, 300, 30);
  private cErrorLabel errorPembayaranMakanan = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      415, 300);
  private cComboBox pilihTransaksiMakanan;
  private cComboBox pilihPromoMakanan;
  private cComboBox pilihMejaMakanan;
  private cTextarea txtTotalHargaMakanan = new cTextarea(40, 8000, 200, 30, false);

  // component of input data Transaksi Coffe
  private cLabelInfo labelInputTransaksiCoffe = new cLabelInfo("Masukan Data Transaksi Coffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaTransaksiCoffe = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaTransaksiCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaTransaksiCoffe = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihTransaksiCoffe = new cLabelInfo("Menu Coffe", 190, 180, 300, 40);
  private cErrorLabel errorTransaksiCoffe = new cErrorLabel("Menu Coffe tidak boleh Kosong!", 190, 235, 300);
  private cLabelInfo labelDeskripsiTransaksiCoffe = new cLabelInfo("Deskripsi Coffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiCoffe = new cErrorLabel("Deskripsi Coffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiCoffe = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cErrorLabel errorMejaTransaksiCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahTransaksiCoffe = new cLabelInfo("Jumlah Coffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiCoffe = new cErrorLabel("Jumlah Coffe tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelPromoTransaksiCoffe = new cLabelInfo("Pilih Promo", 190, 360, 300, 40);
  private cLabelInfo labelHargaTransaksiCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cComboBox pilihPembayaranCoffe = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 390, 300, 30);
  private cErrorLabel errorPembayaranCoffe = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      415, 300);
  private cComboBox pilihTransaksiCoffe;
  private cComboBox pilihPromoCoffe;
  private cComboBox pilihMejaCoffe;
  private cTextarea txtTotalHargaCoffe = new cTextarea(40, 200, 200, 30, false);

  // component of input data Transaksi Non Coffe
  private cLabelInfo labelInputTransaksiNonCoffe = new cLabelInfo("Masukan Data Transaksi NonCoffe!", 190, 40, 400, 40);
  private cLabelInfo labelNamaTransaksiNonCoffe = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaTransaksiNonCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaTransaksiNonCoffe = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihTransaksiNonCoffe = new cLabelInfo("Menu NonCoffe", 190, 180, 300, 40);
  private cErrorLabel errorTransaksiNonCoffe = new cErrorLabel("Menu NonCoffe tidak boleh Kosong!", 190, 235, 300);
  private cLabelInfo labelDeskripsiTransaksiNonCoffe = new cLabelInfo("Deskripsi NonCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiNonCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiNonCoffe = new cErrorLabel(
      "Deskripsi NonCoffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiNonCoffe = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cErrorLabel errorMejaTransaksiNonCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahTransaksiNonCoffe = new cLabelInfo("Jumlah NonCoffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiNonCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiNonCoffe = new cErrorLabel("Jumlah NonCoffe tidak boleh Kosong!", 580, 327,
      400);
  private cLabelInfo labelPromoTransaksiNonCoffe = new cLabelInfo("Pilih Promo", 190, 360, 300, 40);
  private cLabelInfo labelHargaTransaksiNonCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiNonCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiNonCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiNonCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cComboBox pilihPembayaranNonCoffe = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 390, 300, 30);
  private cErrorLabel errorPembayaranNonCoffe = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      415, 300);
  private cComboBox pilihTransaksiNonCoffe;
  private cComboBox pilihPromoNonCoffe;
  private cComboBox pilihMejaNonCoffe;
  private cTextarea txtTotalHargaNonCoffe = new cTextarea(40, 200, 200, 30, false);

  // component of input data Transaksi UbahMakanan
  private cLabelInfo labelInputTransaksiUbahMakanan = new cLabelInfo("Masukan Data Transaksi UbahMakanan!", 190, 40,
      400, 40);
  private cLabelInfo labelNamaTransaksiUbahMakanan = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaTransaksiUbahMakanan = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaTransaksiUbahMakanan = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihTransaksiUbahMakanan = new cLabelInfo("Menu UbahMakanan", 190, 180, 300, 40);
  private cErrorLabel errorTransaksiUbahMakanan = new cErrorLabel("Menu UbahMakanan tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiTransaksiUbahMakanan = new cLabelInfo("Deskripsi UbahMakanan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiUbahMakanan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiUbahMakanan = new cErrorLabel(
      "Deskripsi UbahMakanan tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiUbahMakanan = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cErrorLabel errorMejaTransaksiUbahMakanan = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahTransaksiUbahMakanan = new cLabelInfo("Jumlah UbahMakanan", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiUbahMakanan = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiUbahMakanan = new cErrorLabel("Jumlah UbahMakanan tidak boleh Kosong!", 580,
      327,
      400);
  private cLabelInfo labelPembayaranUbahMakanan = new cLabelInfo("Pilih Promo", 190, 360, 300, 40);
  private cLabelInfo labelHargaTransaksiUbahMakanan = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiUbahMakanan = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiUbahMakanan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiUbahMakanan = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cComboBox pilihPembayaranUbahMakanan = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 390, 300,
      30);
  private cErrorLabel errorPembayaranUbahMakanan = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      415, 300);
  private cComboBox pilihTransaksiUbahMakanan;
  private cComboBox pilihPromoUbahMakanan;
  private cComboBox pilihMejaUbahMakanan;
  private cTextarea txtTotalHargaUbahMakanan = new cTextarea(40, 8000, 200, 30, false);

  // component of input data Transaksi UbahCoffe
  private cLabelInfo labelInputTransaksiUbahCoffe = new cLabelInfo("Masukan Data Transaksi UbahCoffe!", 190, 40,
      400, 40);
  private cLabelInfo labelNamaTransaksiUbahCoffe = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaTransaksiUbahCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaTransaksiUbahCoffe = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihTransaksiUbahCoffe = new cLabelInfo("Menu UbahCoffe", 190, 180, 300, 40);
  private cErrorLabel errorTransaksiUbahCoffe = new cErrorLabel("Menu UbahCoffe tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiTransaksiUbahCoffe = new cLabelInfo("Deskripsi UbahCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiUbahCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiUbahCoffe = new cErrorLabel(
      "Deskripsi UbahCoffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiUbahCoffe = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cErrorLabel errorMejaTransaksiUbahCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahTransaksiUbahCoffe = new cLabelInfo("Jumlah UbahCoffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiUbahCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiUbahCoffe = new cErrorLabel("Jumlah UbahCoffe tidak boleh Kosong!", 580,
      327,
      400);
  private cLabelInfo labelPembayaranUbahCoffe = new cLabelInfo("Pilih Promo", 190, 360, 300, 40);
  private cLabelInfo labelHargaTransaksiUbahCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiUbahCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiUbahCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiUbahCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cComboBox pilihPembayaranUbahCoffe = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 390, 300,
      30);
  private cErrorLabel errorPembayaranUbahCoffe = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      415, 300);
  private cComboBox pilihTransaksiUbahCoffe;
  private cComboBox pilihPromoUbahCoffe;
  private cComboBox pilihMejaUbahCoffe;
  private cTextarea txtTotalHargaUbahCoffe = new cTextarea(40, 8000, 200, 30, false);

  // component of input data Transaksi UbahNonCoffe
  private cLabelInfo labelInputTransaksiUbahNonCoffe = new cLabelInfo("Masukan Data Transaksi UbahNonCoffe!", 190, 40,
      400, 40);
  private cLabelInfo labelNamaTransaksiUbahNonCoffe = new cLabelInfo("Nama Pemesan", 190, 90, 300, 40);
  private cTextField txtNamaTransaksiUbahNonCoffe = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaTransaksiUbahNonCoffe = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 190,
      145, 400);
  private cLabelInfo labelPilihTransaksiUbahNonCoffe = new cLabelInfo("Menu UbahNonCoffe", 190, 180, 300, 40);
  private cErrorLabel errorTransaksiUbahNonCoffe = new cErrorLabel("Menu UbahNonCoffe tidak boleh Kosong!", 190,
      235, 300);
  private cLabelInfo labelDeskripsiTransaksiUbahNonCoffe = new cLabelInfo("Deskripsi UbahNonCoffe", 580, 90, 300, 40);
  private cTextarea txtDeskripsiTransaksiUbahNonCoffe = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiTransaksiUbahNonCoffe = new cErrorLabel(
      "Deskripsi UbahNonCoffe tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelMejaTransaksiUbahNonCoffe = new cLabelInfo("Pilih Meja", 190, 270, 300, 40);
  private cErrorLabel errorMejaTransaksiUbahNonCoffe = new cErrorLabel("Pilih Meja tidak boleh Kosong!", 190,
      327, 300);
  private cLabelInfo labelJumlahTransaksiUbahNonCoffe = new cLabelInfo("Jumlah UbahNonCoffe", 580, 270, 300, 40);
  private cTextField txtJumlahTransaksiUbahNonCoffe = new cTextField(580, 302, 300);
  private cErrorLabel errorJumlahTransaksiUbahNonCoffe = new cErrorLabel("Jumlah UbahNonCoffe tidak boleh Kosong!", 580,
      327,
      400);
  private cLabelInfo labelPembayaranUbahNonCoffe = new cLabelInfo("Pilih Promo", 190, 360, 300, 40);
  private cLabelInfo labelHargaTransaksiUbahNonCoffe = new cLabelInfo("Harga Pemesan", 580, 360, 300, 40);
  private cTextField txtHargaTransaksiUbahNonCoffe = new cTextField(580, 392, 300);
  private cButton btnHapusTransaksiUbahNonCoffe = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanTransaksiUbahNonCoffe = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cComboBox pilihPembayaranUbahNonCoffe = new cComboBox(new String[] { "CASH", "OVO", "GOPAY" }, 190, 390, 300,
      30);
  private cErrorLabel errorPembayaranUbahNonCoffe = new cErrorLabel("Metode Pembayaran tidak boleh Kosong!", 190,
      415, 300);
  private cComboBox pilihTransaksiUbahNonCoffe;
  private cComboBox pilihPromoUbahNonCoffe;
  private cComboBox pilihMejaUbahNonCoffe;
  private cTextarea txtTotalHargaUbahNonCoffe = new cTextarea(40, 8000, 200, 30, false);

  // component of data OrderBahan
  private cLabelInfo labelOrderBahan = new cLabelInfo("Data OrderBahan Menu", 40, 40, 300, 40);
  private cLabelInfo labelCariOrderBahan = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariOrderBahan = new cTextField(100, 100, 300);
  private cButton btnTambahOrderBahan = new cButton("Tambah", 450, 100, 150, 30, 20);
  private cButton btnHapusDataOrderBahan = new cButton("Hapus", 630, 100, 150, 30, 20);
  private cButton btnEditDataOrderBahan = new cButton("Edit", 800, 100, 150, 30, 20);
  private cButton btnKembaliOrderBahan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cTable tblOrderBahan;
  private cScrollPane spOrderBahan;

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
      roleText.setText("Mitra | " + Model.getDetailMitra(idMitra)[1].toString());
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

    if (Model.getDetailMitra(idMitra)[3].toString().equalsIgnoreCase("terverifikasi")) {
      sidebar.add(menuBeranda);
      sidebar.add(menuDataMenu);
      sidebar.add(menuDataPromo);
      sidebar.add(menuDataMeja);
      sidebar.add(menuDataCustomer);
      sidebar.add(menuDataKaryawan);
      sidebar.add(menuTransaksi);
      sidebar.add(menuOrderBahan);
      sidebar.add(menuLogout);
    } else {
      sidebar.add(menuBeranda);

      menuLogout.setLocation(menuLogout.getLocation().x, menuBeranda.getLocation().y + 50);
      sidebar.add(menuLogout);
    }
    // add component default
    main.add(labelDateTimeBeranda);
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

    if (Model.getDetailMitra(idMitra)[3].toString().equalsIgnoreCase("terverifikasi")) {
      labelDateTimeBeranda.setVisible(true);

      valueInfoSaldoMitraBeranda.setText(String.valueOf(Model.getDetailSaldoMitra(idMitra)));

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
    } else {
      labelInfoSaldoMitraBeranda.setText("Anda Belum Terverifikasi! Silahkan Tunggu respon dari Atmin!");
      labelInfoSaldoMitraBeranda.setSize(labelInfoSaldoMitraBeranda.getWidth() + 500,
          labelInfoSaldoMitraBeranda.getHeight());
    }
    content.add(labelInfoSaldoMitraBeranda);
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
        initsInputMenuMakanan();
      }
    });

    btnEditDataMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblMenuMakanan.getSelectedRow();

        if (selectedIndex != -1) {
          int idMenu = Integer
              .valueOf(tblMenuMakanan.getValueAt(selectedIndex, 0).toString());
          initsUbahDataMakanan(idMenu);
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih Menu Makanan yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusDataMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblMenuMakanan.getSelectedRow();

        if (selectedIndex != -1) {
          int idMenu = Integer
              .valueOf(tblMenuMakanan.getValueAt(selectedIndex, 0).toString());

          if (Model.hapusDataMenuMakanan(idMenu)) {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Meja berhasil dihapus!",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsMenuMakanan();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Meja gagal dihapus!",
                "Gagal", JOptionPane.ERROR_MESSAGE);
          }
        } else {
          // kalo gak ada yang diseleksic
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih data terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
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
    content.add(btnEditDataMakanan);
    content.add(btnHapusDataMakanan);
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
        initsInputMenuCoffe();
      }
    });

    btnEditDataCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblMenuCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          int idMenu = Integer
              .valueOf(tblMenuCoffe.getValueAt(selectedIndex, 0).toString());
          initsUbahDataCoffe(idMenu);
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih Menu Coffe yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusDataCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblMenuCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          int idMenu = Integer
              .valueOf(tblMenuCoffe.getValueAt(selectedIndex, 0).toString());

          if (Model.hapusDataMenuCoffe(idMenu)) {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Meja berhasil dihapus!",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsMenuCoffe();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Meja gagal dihapus!",
                "Gagal", JOptionPane.ERROR_MESSAGE);
          }
        } else {
          // kalo gak ada yang diseleksic
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih data terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
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
    content.add(btnEditDataCoffe);
    content.add(btnHapusDataCoffe);
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
        initsInputMenuNonCoffe();
      }
    });

    btnEditDataNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblMenuNonCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          int idMenu = Integer
              .valueOf(tblMenuNonCoffe.getValueAt(selectedIndex, 0).toString());
          initsUbahDataNonCoffe(idMenu);
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih Menu NonCoffe yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusDataNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblMenuNonCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          int idMenu = Integer
              .valueOf(tblMenuNonCoffe.getValueAt(selectedIndex, 0).toString());

          if (Model.hapusDataMenuNonCoffe(idMenu)) {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Meja berhasil dihapus!",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsMenuNonCoffe();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Meja gagal dihapus!",
                "Gagal", JOptionPane.ERROR_MESSAGE);
          }
        } else {
          // kalo gak ada yang diseleksic
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih data terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
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
    content.add(btnEditDataNonCoffe);
    content.add(btnHapusDataNonCoffe);
    content.add(labelCariMenuNonCoffe);
    content.add(txtCariMenuNonCoffe);
    setVisible(true);
  }

  private void initsUbahDataMakanan(int idMenu) {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Ubah Menu Makanan");

    // ini adalah cara untuk set text jadi yang relevan

    Object[] detailMakanan = Model.getDetailMenuMakanan(idMenu);

    txtNamaUbahMakanan.setText(detailMakanan[4].toString());
    txtJumlahUbahMakanan.setText(detailMakanan[5].toString());
    txtHargaUbahMakanan.setText(detailMakanan[6].toString());
    txtDeskripsiUbahMakanan.setText(detailMakanan[7].toString());

    btnSimpanUbahMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (txtNamaUbahMakanan.getText().trim().isEmpty()
            || txtJumlahUbahMakanan.getText().trim().isEmpty()
            || txtDeskripsiUbahMakanan.getText().trim().isEmpty()
            || txtHargaUbahMakanan.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          // spesifik textfield tidak boleh kosong
          if (txtNamaUbahMakanan.getText().trim().isEmpty()) {
            content.add(errorNamaUbahMakanan);
          } else {
            content.remove(errorNamaUbahMakanan);
          }
          if (txtJumlahUbahMakanan.getText().trim().isEmpty()) {
            content.add(errorJumlahUbahMakanan);
          } else {
            content.remove(errorJumlahUbahMakanan);
          }
          if (txtDeskripsiUbahMakanan.getText().trim().isEmpty()) {
            content.add(errorDeskripsiUbahMakanan);
          } else {
            content.remove(errorDeskripsiUbahMakanan);
          }
          if (txtHargaUbahMakanan.getText().trim().isEmpty()) {
            content.add(errorHargaUbahMakanan);
          } else {
            content.remove(errorHargaUbahMakanan);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaMenu = txtNamaUbahMakanan.getText();
          int jumlahMakanan = Integer.valueOf(txtJumlahUbahMakanan.getText());
          int hargaMakanan = Integer.valueOf(txtHargaUbahMakanan.getText());
          String deskripsiMakanan = txtDeskripsiUbahMakanan.getText();

          if (Model.ubahMenuMakanan(idMenu, idMitra, namaMenu, jumlahMakanan, hargaMakanan,
              deskripsiMakanan)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Berhasil Ditambah",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            txtNamaUbahMakanan.setText(null);
            txtJumlahUbahMakanan.setText(null);
            txtDeskripsiUbahMakanan.setText(null);
            txtHargaUbahMakanan.setText(null);
            initsMenuMakanan();
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Gagal Ditambah", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusUbahMakanan.addActionListener(new java.awt.event.ActionListener() {

      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaUbahMakanan.setText(null);
        txtJumlahUbahMakanan.setText(null);
        txtDeskripsiUbahMakanan.setText(null);
        txtHargaUbahMakanan.setText(null);
      }
    });

    btnKembaliUbahMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsMenuMakanan();
      }
    });

    System.out.println("hello word");

    content.add(labelInputMenuUbahMakanan);
    content.add(labelNamaUbahMakanan);
    content.add(txtNamaUbahMakanan);
    content.add(labelJumlahUbahMakanan);
    content.add(txtJumlahUbahMakanan);
    content.add(labelHargaUbahMakanan);
    content.add(txtHargaUbahMakanan);
    content.add(labelDeskripsiUbahMakanan);
    content.add(txtDeskripsiUbahMakanan);
    content.add(btnSimpanUbahMakanan);
    content.add(btnHapusUbahMakanan);
    content.add(btnKembaliUbahMakanan);

    setVisible(true);
  }

  private void initsUbahDataCoffe(int idMenu) {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Ubah Menu Coffe");

    // ini adalah cara untuk set text jadi yang relevan

    Object[] detailCoffe = Model.getDetailMenuCoffe(idMenu);

    txtNamaUbahCoffe.setText(detailCoffe[4].toString());
    txtJumlahUbahCoffe.setText(detailCoffe[5].toString());
    txtHargaUbahCoffe.setText(detailCoffe[6].toString());
    txtDeskripsiUbahCoffe.setText(detailCoffe[7].toString());

    btnSimpanUbahCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (txtNamaUbahCoffe.getText().trim().isEmpty()
            || txtJumlahUbahCoffe.getText().trim().isEmpty()
            || txtDeskripsiUbahCoffe.getText().trim().isEmpty()
            || txtHargaUbahCoffe.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          // spesifik textfield tidak boleh kosong
          if (txtNamaUbahCoffe.getText().trim().isEmpty()) {
            content.add(errorNamaUbahCoffe);
          } else {
            content.remove(errorNamaUbahCoffe);
          }
          if (txtJumlahUbahCoffe.getText().trim().isEmpty()) {
            content.add(errorJumlahUbahCoffe);
          } else {
            content.remove(errorJumlahUbahCoffe);
          }
          if (txtDeskripsiUbahCoffe.getText().trim().isEmpty()) {
            content.add(errorDeskripsiUbahCoffe);
          } else {
            content.remove(errorDeskripsiUbahCoffe);
          }
          if (txtHargaUbahCoffe.getText().trim().isEmpty()) {
            content.add(errorHargaUbahCoffe);
          } else {
            content.remove(errorHargaUbahCoffe);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaMenu = txtNamaUbahCoffe.getText();
          int jumlahMenu = Integer.valueOf(txtJumlahUbahCoffe.getText());
          int hargaMenu = Integer.valueOf(txtHargaUbahCoffe.getText());
          String deskripsiMenu = txtDeskripsiUbahCoffe.getText();

          if (Model.ubahMenuCoffe(idMenu, idMitra, namaMenu, jumlahMenu, hargaMenu,
              deskripsiMenu)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Berhasil Ditambah",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            txtNamaUbahCoffe.setText(null);
            txtJumlahUbahCoffe.setText(null);
            txtDeskripsiUbahCoffe.setText(null);
            txtHargaUbahCoffe.setText(null);
            initsMenuCoffe();
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Gagal Ditambah", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusUbahCoffe.addActionListener(new java.awt.event.ActionListener() {

      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaUbahCoffe.setText(null);
        txtJumlahUbahCoffe.setText(null);
        txtDeskripsiUbahCoffe.setText(null);
        txtHargaUbahCoffe.setText(null);
      }
    });

    btnKembaliUbahCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsMenuCoffe();
      }
    });

    content.add(labelInputMenuUbahCoffe);
    content.add(labelNamaUbahCoffe);
    content.add(txtNamaUbahCoffe);
    content.add(labelJumlahUbahCoffe);
    content.add(txtJumlahUbahCoffe);
    content.add(labelHargaUbahCoffe);
    content.add(txtHargaUbahCoffe);
    content.add(labelDeskripsiUbahCoffe);
    content.add(txtDeskripsiUbahCoffe);
    content.add(btnSimpanUbahCoffe);
    content.add(btnHapusUbahCoffe);
    content.add(btnKembaliUbahCoffe);

    setVisible(true);
  }

  private void initsUbahDataNonCoffe(int idMenu) {
    idSelected = null;
    resetSidebar();
    menuDataMenu.setBackground(cColor.WHITE);
    menuDataMenu.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMenu.setSidebarAktif();
    menuTitle.setText("Ubah Menu Non Coffe");

    // ini adalah cara untuk set text jadi yang relevan

    Object[] detailNonCoffe = Model.getDetailMenuNonCoffe(idMenu);

    txtNamaUbahNonCoffe.setText(detailNonCoffe[4].toString());
    txtJumlahUbahNonCoffe.setText(detailNonCoffe[5].toString());
    txtHargaUbahNonCoffe.setText(detailNonCoffe[6].toString());
    txtDeskripsiUbahNonCoffe.setText(detailNonCoffe[7].toString());

    btnSimpanUbahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (txtNamaUbahNonCoffe.getText().trim().isEmpty()
            || txtJumlahUbahNonCoffe.getText().trim().isEmpty()
            || txtDeskripsiUbahNonCoffe.getText().trim().isEmpty()
            || txtHargaUbahNonCoffe.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          // spesifik textfield tidak boleh kosong
          if (txtNamaUbahNonCoffe.getText().trim().isEmpty()) {
            content.add(errorNamaUbahNonCoffe);
          } else {
            content.remove(errorNamaUbahNonCoffe);
          }
          if (txtJumlahUbahNonCoffe.getText().trim().isEmpty()) {
            content.add(errorJumlahUbahNonCoffe);
          } else {
            content.remove(errorJumlahUbahNonCoffe);
          }
          if (txtDeskripsiUbahNonCoffe.getText().trim().isEmpty()) {
            content.add(errorDeskripsiUbahNonCoffe);
          } else {
            content.remove(errorDeskripsiUbahNonCoffe);
          }
          if (txtHargaUbahNonCoffe.getText().trim().isEmpty()) {
            content.add(errorHargaUbahNonCoffe);
          } else {
            content.remove(errorHargaUbahNonCoffe);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaMenu = txtNamaUbahNonCoffe.getText();
          int jumlahMenu = Integer.valueOf(txtJumlahUbahNonCoffe.getText());
          int hargaMenu = Integer.valueOf(txtHargaUbahNonCoffe.getText());
          String deskripsiMenu = txtDeskripsiUbahNonCoffe.getText();

          if (Model.ubahMenuNonCoffe(idMenu, idMitra, namaMenu, jumlahMenu, hargaMenu,
              deskripsiMenu)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Berhasil Ditambah",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            txtNamaUbahNonCoffe.setText(null);
            txtJumlahUbahNonCoffe.setText(null);
            txtDeskripsiUbahNonCoffe.setText(null);
            txtHargaUbahNonCoffe.setText(null);
            initsMenuNonCoffe();
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Gagal Ditambah", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusUbahNonCoffe.addActionListener(new java.awt.event.ActionListener() {

      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaUbahNonCoffe.setText(null);
        txtJumlahUbahNonCoffe.setText(null);
        txtDeskripsiUbahNonCoffe.setText(null);
        txtHargaUbahNonCoffe.setText(null);
      }
    });

    btnKembaliUbahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsMenuNonCoffe();
      }
    });

    content.add(labelInputMenuUbahNonCoffe);
    content.add(labelNamaUbahNonCoffe);
    content.add(txtNamaUbahNonCoffe);
    content.add(labelJumlahUbahNonCoffe);
    content.add(txtJumlahUbahNonCoffe);
    content.add(labelHargaUbahNonCoffe);
    content.add(txtHargaUbahNonCoffe);
    content.add(labelDeskripsiUbahNonCoffe);
    content.add(txtDeskripsiUbahNonCoffe);
    content.add(btnSimpanUbahNonCoffe);
    content.add(btnHapusUbahNonCoffe);
    content.add(btnKembaliUbahNonCoffe);

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

    // set textfield null
    txtNamaMakanan.setText(null);
    txtJumlahMakanan.setText(null);
    txtDeskripsiMakanan.setText(null);
    txtHargaMakanan.setText(null);

    btnSimpanMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (txtNamaMakanan.getText().trim().isEmpty()
            || txtJumlahMakanan.getText().trim().isEmpty()
            || txtDeskripsiMakanan.getText().trim().isEmpty()
            || txtHargaMakanan.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          // spesifik textfield tidak boleh kosong
          if (txtNamaMakanan.getText().trim().isEmpty()) {
            content.add(errorNamaMakanan);
          } else {
            content.remove(errorNamaMakanan);
          }
          if (txtJumlahMakanan.getText().trim().isEmpty()) {
            content.add(errorJumlahMakanan);
          } else {
            content.remove(errorJumlahMakanan);
          }
          if (txtDeskripsiMakanan.getText().trim().isEmpty()) {
            content.add(errorDeskripsiMakanan);
          } else {
            content.remove(errorDeskripsiMakanan);
          }
          if (txtHargaMakanan.getText().trim().isEmpty()) {
            content.add(errorHargaMakanan);
          } else {
            content.remove(errorHargaMakanan);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaMenu = txtNamaMakanan.getText();
          int jumlahMakanan = Integer.valueOf(txtJumlahMakanan.getText());
          int hargaMakanan = Integer.valueOf(txtHargaMakanan.getText());
          String deskripsiMakanan = txtDeskripsiMakanan.getText();

          if (Model.tambahMenuMakanan(idMitra, namaMenu, jumlahMakanan, hargaMakanan, deskripsiMakanan)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Berhasil Ditambah",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            txtNamaMakanan.setText(null);
            txtJumlahMakanan.setText(null);
            txtDeskripsiMakanan.setText(null);
            txtHargaMakanan.setText(null);
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Gagal Ditambah", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusMakanan.addActionListener(new java.awt.event.ActionListener() {

      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaMakanan.setText(null);
        txtJumlahMakanan.setText(null);
        txtDeskripsiMakanan.setText(null);
        txtHargaMakanan.setText(null);
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
    content.add(labelJumlahMakanan);
    content.add(txtJumlahMakanan);
    content.add(labelHargaMakanan);
    content.add(txtHargaMakanan);
    content.add(labelDeskripsiMakanan);
    content.add(txtDeskripsiMakanan);
    content.add(btnSimpanMakanan);
    content.add(btnHapusMakanan);
    content.add(btnKembaliMakanan);

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

    // set textfield null
    txtNamaCoffe.setText(null);
    txtJumlahCoffe.setText(null);
    txtDeskripsiCoffe.setText(null);
    txtHargaCoffe.setText(null);

    btnSimpanCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (txtNamaCoffe.getText().trim().isEmpty()
            || txtJumlahCoffe.getText().trim().isEmpty()
            || txtDeskripsiCoffe.getText().trim().isEmpty()
            || txtHargaCoffe.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          // spesifik textfield tidak boleh kosong
          if (txtNamaCoffe.getText().trim().isEmpty()) {
            content.add(errorNamaCoffe);
          } else {
            content.remove(errorNamaCoffe);
          }
          if (txtJumlahCoffe.getText().trim().isEmpty()) {
            content.add(errorJumlahCoffe);
          } else {
            content.remove(errorJumlahCoffe);
          }
          if (txtDeskripsiCoffe.getText().trim().isEmpty()) {
            content.add(errorDeskripsiCoffe);
          } else {
            content.remove(errorDeskripsiCoffe);
          }
          if (txtHargaCoffe.getText().trim().isEmpty()) {
            content.add(errorHargaCoffe);
          } else {
            content.remove(errorHargaCoffe);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaMenu = txtNamaCoffe.getText();
          int jumlahCoffe = Integer.valueOf(txtJumlahCoffe.getText());
          int hargaCoffe = Integer.valueOf(txtHargaCoffe.getText());
          String deskripsiCoffe = txtDeskripsiCoffe.getText();

          if (Model.tambahMenuCoffe(idMitra, namaMenu, jumlahCoffe, hargaCoffe, deskripsiCoffe)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Berhasil Ditambah",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            txtNamaCoffe.setText(null);
            txtJumlahCoffe.setText(null);
            txtDeskripsiCoffe.setText(null);
            txtHargaCoffe.setText(null);
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Gagal Ditambah", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaCoffe.setText(null);
        txtJumlahCoffe.setText(null);
        txtDeskripsiCoffe.setText(null);
        txtHargaCoffe.setText(null);
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
    content.add(labelJumlahCoffe);
    content.add(txtJumlahCoffe);
    content.add(labelHargaCoffe);
    content.add(txtHargaCoffe);
    content.add(labelDeskripsiCoffe);
    content.add(txtDeskripsiCoffe);
    content.add(btnSimpanCoffe);
    content.add(btnHapusCoffe);
    content.add(btnKembaliCoffe);

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

    // set textfield null
    txtNamaNonCoffe.setText(null);
    txtJumlahNonCoffe.setText(null);
    txtDeskripsiNonCoffe.setText(null);
    txtHargaNonCoffe.setText(null);

    btnSimpanNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (txtNamaNonCoffe.getText().trim().isEmpty()
            || txtJumlahNonCoffe.getText().trim().isEmpty()
            || txtDeskripsiNonCoffe.getText().trim().isEmpty()
            || txtHargaNonCoffe.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          // spesifik textfield tidak boleh kosong
          if (txtNamaNonCoffe.getText().trim().isEmpty()) {
            content.add(errorNamaNonCoffe);
          } else {
            content.remove(errorNamaNonCoffe);
          }
          if (txtJumlahNonCoffe.getText().trim().isEmpty()) {
            content.add(errorJumlahNonCoffe);
          } else {
            content.remove(errorJumlahNonCoffe);
          }
          if (txtDeskripsiNonCoffe.getText().trim().isEmpty()) {
            content.add(errorDeskripsiNonCoffe);
          } else {
            content.remove(errorDeskripsiNonCoffe);
          }
          if (txtHargaNonCoffe.getText().trim().isEmpty()) {
            content.add(errorHargaNonCoffe);
          } else {
            content.remove(errorHargaNonCoffe);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaMenu = txtNamaNonCoffe.getText();
          int jumlahNonCoffe = Integer.valueOf(txtJumlahNonCoffe.getText());
          int hargaNonCoffe = Integer.valueOf(txtHargaNonCoffe.getText());
          String deskripsiNonCoffe = txtDeskripsiNonCoffe.getText();

          if (Model.tambahMenuNonCoffe(idMitra, namaMenu, jumlahNonCoffe, hargaNonCoffe, deskripsiNonCoffe)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Berhasil Ditambah",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            txtNamaNonCoffe.setText(null);
            txtJumlahNonCoffe.setText(null);
            txtDeskripsiNonCoffe.setText(null);
            txtHargaNonCoffe.setText(null);
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Menu Gagal Ditambah", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaNonCoffe.setText(null);
        txtJumlahNonCoffe.setText(null);
        txtDeskripsiNonCoffe.setText(null);
        txtHargaNonCoffe.setText(null);
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
    content.add(labelJumlahNonCoffe);
    content.add(txtJumlahNonCoffe);
    content.add(labelHargaNonCoffe);
    content.add(txtHargaNonCoffe);
    content.add(labelDeskripsiNonCoffe);
    content.add(txtDeskripsiNonCoffe);
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

    btnHapusDataPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataPromo.getSelectedRow();

        if (selectedIndex != -1) {
          int idPromo = Integer.valueOf(tblDataPromo.getValueAt(selectedIndex, 0).toString());

          if (Model.hapusDataPromo(idPromo)) {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Promo berhasil dihapus!", "berhasil",
                JOptionPane.INFORMATION_MESSAGE);
            initsDataPromo();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Promo gagal dihapus!", "gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih data terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
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

    content.add(btnTambahPromo);
    content.add(btnHapusDataPromo);
    content.add(btnEditDataPromo);
    content.add(labelPromo);
    content.add(labelCariPromo);
    content.add(txtCariPromo);

    setVisible(true);
  }

  private void initializePilihMenuPromo() {
    ArrayList<String> menuPromo = Model.getAllMenuPromo();
    menuPromo.add(0, "Pilih Menu"); // Add the default "Pilih Menu" option at the beginning

    pilihMenuPromo = new cComboBox(menuPromo.toArray(new String[0]), 190, 302, 300, 30);
  }

  private void initsInputDataPromo() {
    idSelected = null;
    resetSidebar();
    menuDataPromo.setBackground(cColor.WHITE);
    menuDataPromo.setForeground(cColor.GREEN);
    refreshContent();
    menuDataPromo.setSidebarAktif();
    menuTitle.setText("Tambah Promo");

    initializePilihMenuPromo();

    // set textfield null
    txtNamaPromo.setText(null);
    txtJumlahPromo.setText(null);
    pilihMenuPromo.setSelectedItem("Pilih Menu");
    txtDeskripsiPromo.setText(null);
    txtHargaPromo.setText(null);

    btnSimpanPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        // error textfield kosong
        if (txtNamaPromo.getText().trim().isEmpty()
            || txtJumlahPromo.getText().trim().isEmpty()
            || pilihMenuPromo.getSelectedItem() == null
            || txtDeskripsiPromo.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          if (txtNamaPromo.getText().trim().isEmpty()) {
            content.add(errorNamaPromo);
          } else {
            content.remove(errorNamaPromo);
          }
          if (txtJumlahPromo.getText().trim().isEmpty()) {
            content.add(errorJumlahPromo);
          } else {
            content.remove(errorJumlahPromo);
          }
          if (pilihMenuPromo.getSelectedItem() == null
              || pilihMenuPromo.getSelectedItem().toString().trim().equals("Pilih Promo")) {
            content.add(errorMenuPromo);
          } else {
            content.remove(errorMenuPromo);
          }
          if (txtDeskripsiPromo.getText().trim().isEmpty()) {
            content.add(errorDeskripsiPromo);
          } else {
            content.remove(errorDeskripsiPromo);
          }
          if (txtHargaPromo.getText().trim().isEmpty()) {
            content.add(errorHargaPromo);
          } else {
            content.remove(errorHargaPromo);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaPromo = txtNamaPromo.getText();
          String MenuPromo = (String) pilihMenuPromo.getSelectedItem();
          int jumlahPromo = Integer.valueOf(txtJumlahPromo.getText());
          int hargaPromo = Integer.valueOf(txtHargaPromo.getText());
          String deskripsiPromo = txtDeskripsiPromo.getText();

          if (Model.tambahPromo(idMitra, namaPromo, MenuPromo, jumlahPromo, hargaPromo, deskripsiPromo)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Promo Berhasil Disimpan.",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Promo Gagal Disimpan.", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

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
    content.add(labelJumlahPromo);
    content.add(txtJumlahPromo);
    content.add(labelHargaPromo);
    content.add(txtHargaPromo);
    content.add(labelDeskripsiPromo);
    content.add(txtDeskripsiPromo);
    content.add(labelPilihMenuPromo);
    content.add(pilihMenuPromo);
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

    btnHapusDataMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataMeja.getSelectedRow();

        if (selectedIndex != -1) {
          int idMeja = Integer.valueOf(tblDataMeja.getValueAt(selectedIndex, 0).toString());

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin menghapus data meja!",
              "Konfirmasi Hapus Data Meja",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            boolean isDeleted = Model.hapusDataMeja(idMeja);
            if (isDeleted) {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Meja berhasil dihapus!",
                  "Berhasil",
                  JOptionPane.INFORMATION_MESSAGE);
              initsDataMeja();
            } else {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Meja gagal dihapus!",
                  "Gagal",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        } else {
          // Jika tidak ada yang dipilih
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnEditDataMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataMeja.getSelectedRow();

        if (selectedIndex != -1) {
          int idMeja = Integer.valueOf(tblDataMeja.getValueAt(selectedIndex, 0).toString());
          initsUbahDataMeja(idMeja);
        } else {
          // Jika tidak ada yang dipilih
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data Meja yang akan diubah terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblDataMeja = new cTable(Model.getAllMeja());

    tblDataMeja.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(0).setWidth(0);

    tblDataMeja.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(1).setWidth(0);

    tblDataMeja.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(2).setWidth(0);

    tblDataMeja.getColumnModel().getColumn(6).setMinWidth(0);
    tblDataMeja.getColumnModel().getColumn(6).setMaxWidth(0);
    tblDataMeja.getColumnModel().getColumn(6).setWidth(0);

    spDataMeja = new cScrollPane(tblDataMeja, 0, 140, 1100, 300);

    content.add(spDataMeja);

    content.add(labelMeja);
    content.add(labelCariMeja);
    content.add(txtCariMeja);
    content.add(btnTambahMeja);
    content.add(btnHapusDataMeja);
    content.add(btnEditDataMeja);
    setVisible(true);
  }

  private void initsUbahDataMeja(int idMeja) {
    idSelected = null;
    resetSidebar();
    menuDataMeja.setBackground(cColor.WHITE);
    menuDataMeja.setForeground(cColor.GREEN);
    refreshContent();
    menuDataMeja.setSidebarAktif();
    menuTitle.setText("Ubah Data Meja");

    Object[] detailMeja = Model.getDetailMeja(idMeja);

    pilihNomorUbahMeja.setSelectedItem(detailMeja[4].toString());
    pilihUbahMeja.setSelectedItem(detailMeja[5].toString());
    txtDeskripsiUbahMeja.setText(detailMeja[6].toString());

    btnSimpanUbahMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        // error textfield tidak boleh kosong
        if (pilihNomorUbahMeja.getSelectedItem() == null
            || pilihUbahMeja.getSelectedItem() == null
            || txtDeskripsiUbahMeja.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          // spesifik textfield
          if (pilihNomorUbahMeja.getSelectedItem() == null
              || pilihNomorUbahMeja.getSelectedItem().toString().trim().equals("Nomor Meja")) {
            content.add(errorNomorUbahMeja);
          } else {
            content.remove(errorNomorUbahMeja);
          }
          if (pilihUbahMeja.getSelectedItem() == null
              || pilihUbahMeja.getSelectedItem().toString().trim().equals("Jenis Meja")) {
            content.add(errorUbahMeja);
          } else {
            content.remove(errorUbahMeja);
          }
          if (txtDeskripsiUbahMeja.getText().trim().isEmpty()) {
            content.add(errorDeskripsiUbahMeja);
          } else {
            content.remove(errorDeskripsiUbahMeja);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String nomorMeja = (String) pilihNomorUbahMeja.getSelectedItem();
          String jenisMeja = (String) pilihUbahMeja.getSelectedItem();
          String deskripsiMeja = txtDeskripsiUbahMeja.getText();

          if (Model.ubahDataMeja(idMeja, idMitra, nomorMeja, jenisMeja, deskripsiMeja)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data UbahMeja Berhasil Disimpan.",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data UbahMeja Gagal Disimpan.", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        pilihNomorUbahMeja.setSelectedItem("Nomor Meja");
        txtDeskripsiUbahMeja.setText(null);
        pilihUbahMeja.setSelectedItem("Jenis Meja");
      }
    });

    btnKembaliUbahMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataMeja();
      }
    });

    content.add(labelInputUbahMeja);
    content.add(labelNomorUbahMeja);
    content.add(pilihNomorUbahMeja);
    content.add(labelDeskripsiUbahMeja);
    content.add(txtDeskripsiUbahMeja);
    content.add(labelPilihUbahMeja);
    content.add(pilihUbahMeja);
    content.add(btnSimpanUbahMeja);
    content.add(btnHapusUbahMeja);
    content.add(btnKembaliUbahMeja);

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

    pilihNomorMeja.setSelectedItem("Nomor Meja");
    pilihMeja.setSelectedItem("Jenis Meja");
    txtDeskripsiMeja.setText(null);

    btnSimpanMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        // error textfield tidak boleh kosong
        if (pilihNomorMeja.getSelectedItem() == null
            || pilihMeja.getSelectedItem() == null
            || txtDeskripsiMeja.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          // spesifik textfield
          if (pilihNomorMeja.getSelectedItem() == null
              || pilihNomorMeja.getSelectedItem().toString().trim().equals("Nomor Meja")) {
            content.add(errorNomorMeja);
          } else {
            content.remove(errorNomorMeja);
          }
          if (pilihMeja.getSelectedItem() == null
              || pilihMeja.getSelectedItem().toString().trim().equals("Jenis Meja")) {
            content.add(errorMeja);
          } else {
            content.remove(errorMeja);
          }
          if (txtDeskripsiMeja.getText().trim().isEmpty()) {
            content.add(errorDeskripsiMeja);
          } else {
            content.remove(errorDeskripsiMeja);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String nomorMeja = (String) pilihNomorMeja.getSelectedItem();
          String jenisMeja = (String) pilihMeja.getSelectedItem();
          String deskripsiMeja = txtDeskripsiMeja.getText();

          if (Model.tambahMeja(idMitra, nomorMeja, jenisMeja, deskripsiMeja)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Meja Berhasil Disimpan.",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            pilihNomorMeja.setSelectedItem("Nomor Meja");
            pilihMeja.setSelectedItem("Jenis Meja");
            txtDeskripsiMeja.setText(null);
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Meja Gagal Disimpan.", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        pilihNomorMeja.setSelectedItem("Nomor Meja");
        txtDeskripsiMeja.setText(null);
        pilihMeja.setSelectedItem("Jenis Meja");
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
    content.add(pilihNomorMeja);
    content.add(labelDeskripsiMeja);
    content.add(txtDeskripsiMeja);
    content.add(labelPilihMeja);
    content.add(pilihMeja);
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

    tblDataCustomer = new cTable(Model.getAllCustomer());

    tblDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataCustomer.getColumnModel().getColumn(0).setWidth(0);

    tblDataCustomer.getColumnModel().getColumn(5).setMinWidth(0);
    tblDataCustomer.getColumnModel().getColumn(5).setMaxWidth(0);
    tblDataCustomer.getColumnModel().getColumn(5).setWidth(0);

    spDataCustomer = new cScrollPane(tblDataCustomer, 0, 150, 1080, 300);

    content.add(spDataCustomer);
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

    btnHapusDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataKaryawan.getSelectedRow();

        if (selectedIndex != -1) {
          int idKaryawan = Integer.valueOf(tblDataKaryawan.getValueAt(selectedIndex, 0).toString());

          if (Model.hapusDataKaryawan(idKaryawan)) {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Karyawan behasil dihapus!", "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
            initsDataKaryawan();

          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Karyawan gagal dihapus!", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        } else {
          // kalo gak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih data terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnEditDataKaryawan.addActionListener(new java.awt.event.ActionListener() {

      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {

      }
    });

    tblDataKaryawan = new cTable(Model.getAllKaryawanVerified());

    tblDataKaryawan.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(0).setWidth(0);

    tblDataKaryawan.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(1).setWidth(0);

    tblDataKaryawan.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(2).setWidth(0);

    tblDataKaryawan.getColumnModel().getColumn(7).setMinWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(7).setMaxWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(7).setWidth(0);

    spDataKaryawan = new cScrollPane(tblDataKaryawan, 0, 140, 1100, 300);

    content.add(spDataKaryawan);

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

    // set textfield null
    txtNamaKaryawan.setText(null);
    txtNomorHpKaryawan.setText(null);
    txtEmailKaryawan.setText(null);
    pilihJobdeskKaryawan.setSelectedItem("Operator Mesin");
    txtAlamatKaryawan.setText(null);

    btnSimpanKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        // error textfield
        if (txtNamaKaryawan.getText().trim().isEmpty()
            || txtNomorHpKaryawan.getText().trim().isEmpty()
            || txtEmailKaryawan.getText().trim().isEmpty()
            || pilihJobdeskKaryawan.getSelectedItem() == null
            || txtAlamatKaryawan.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          // spesifik error
          if (txtNamaKaryawan.getText().trim().isEmpty()) {
            content.add(errorNamaKaryawan);
          } else {
            content.remove(errorNamaKaryawan);
          }
          if (txtNomorHpKaryawan.getText().trim().isEmpty()) {
            content.add(errorNomorHpKaryawan);
          } else {
            content.remove(errorNomorHpKaryawan);
          }
          if (txtEmailKaryawan.getText().trim().isEmpty()) {
            content.add(errorEmailKaryawan);
          } else {
            content.remove(errorEmailKaryawan);
          }
          if (pilihJobdeskKaryawan.getSelectedItem() == null
              || pilihJobdeskKaryawan.getSelectedItem().toString().trim().equals("Pilih Jobdesk")) {
            content.add(errorJobdeskKaryawan);
          } else {
            content.remove(errorJobdeskKaryawan);
          }
          if (txtAlamatKaryawan.getText().trim().isEmpty()) {
            content.add(errorAlamatKaryawan);
          } else {
            content.remove(errorAlamatKaryawan);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaKaryawan = txtNamaKaryawan.getText();
          String nomorHpKaryawan = txtNomorHpKaryawan.getText();
          String emailKaryawan = txtEmailKaryawan.getText();
          String jobdeskKaryawan = (String) pilihJobdeskKaryawan.getSelectedItem();
          String alamatKaryawan = txtAlamatKaryawan.getText();

          if (Model.tambahKaryawan(idMitra, namaKaryawan, nomorHpKaryawan, emailKaryawan, jobdeskKaryawan,
              alamatKaryawan)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Karyawan Berhasil Disimpan",
                "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
            initsInputDataKaryawan();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Gagal Input data Karyawan.", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaKaryawan.setText(null);
        txtNomorHpKaryawan.setText(null);
        txtEmailKaryawan.setText(null);
        txtAlamatKaryawan.setText(null);
        pilihJobdeskKaryawan.setSelectedItem("Operator Mesin");
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
    content.add(labelNomorHpKaryawan);
    content.add(txtNomorHpKaryawan);
    content.add(labelEmailKaryawan);
    content.add(txtEmailKaryawan);
    content.add(labelAlamatKaryawan);
    content.add(txtAlamatKaryawan);
    content.add(labelJobdeskKaryawan);
    content.add(pilihJobdeskKaryawan);
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
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data Transaksi yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblTransaksiMakanan = new cTable(Model.getAllTransaksiMakananDiproses());

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
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data Transaksi yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblTransaksiCoffe = new cTable(Model.getAllTransaksiCoffeDiproses());

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
    menuTitle.setText("Data Transaksi Non Coffe");

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
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data Transaksi yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblTransaksiNonCoffe = new cTable(Model.getAllTransaksiNonCoffeDiproses());

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

    pilihTransaksiMakanan = new cComboBox(menuMakanan.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> mejaMakanan = Model.getAllMejaTransaksiMakanan();
    mejaMakanan.add(0, "Meja Makanan");

    pilihMejaMakanan = new cComboBox(mejaMakanan.toArray(new String[0]), 190, 302, 300, 30);

    ArrayList<String> promoMakanan = Model.getAllPromoTransaksiMakanan();
    promoMakanan.add(0, "Promo Makanan");

    pilihPromoMakanan = new cComboBox(promoMakanan.toArray(new String[0]), 190, 390, 300, 20);

    ArrayList<String> menuUbahMakanan = Model.getAllMenuTransaksiUbahMakanan();
    menuUbahMakanan.add(0, "Menu Makanan");

    pilihTransaksiUbahMakanan = new cComboBox(menuUbahMakanan.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> mejaUbahMakanan = Model.getAllMejaTransaksiUbahMakanan();
    mejaUbahMakanan.add(0, "Meja Makanan");

    pilihMejaUbahMakanan = new cComboBox(mejaUbahMakanan.toArray(new String[0]), 190, 302, 300, 30);

    ArrayList<String> promoUbahMakanan = Model.getAllPromoTransaksiUbahMakanan();
    promoUbahMakanan.add(0, "Promo Makanan");

    pilihPromoUbahMakanan = new cComboBox(promoUbahMakanan.toArray(new String[0]), 190, 390, 300, 20);
  }

  private void initializeTransaksiCoffe() {
    ArrayList<String> menuCoffe = Model.getAllMenuTransaksiCoffe();
    menuCoffe.add(0, "Menu Coffe");

    pilihTransaksiCoffe = new cComboBox(menuCoffe.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> mejaCoffe = Model.getAllMejaTransaksiCoffe();
    mejaCoffe.add(0, "Meja Coffe");

    pilihMejaCoffe = new cComboBox(mejaCoffe.toArray(new String[0]), 190, 302, 300, 30);

    ArrayList<String> promoCoffe = Model.getAllPromoTransaksiCoffe();
    promoCoffe.add(0, "Promo Coffe");

    ArrayList<String> menuUbahCoffe = Model.getAllMenuTransaksiUbahCoffe();
    menuUbahCoffe.add(0, "Menu Coffe");

    pilihTransaksiUbahCoffe = new cComboBox(menuUbahCoffe.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> mejaUbahCoffe = Model.getAllMejaTransaksiUbahCoffe();
    mejaUbahCoffe.add(0, "Meja Coffe");

    pilihMejaUbahCoffe = new cComboBox(mejaUbahCoffe.toArray(new String[0]), 190, 302, 300, 30);

    ArrayList<String> promoUbahCoffe = Model.getAllPromoTransaksiUbahCoffe();
    promoUbahCoffe.add(0, "Promo Coffe");

    pilihPromoUbahCoffe = new cComboBox(promoCoffe.toArray(new String[0]), 190, 390, 300, 20);
  }

  private void initializeTransaksiNonCoffe() {
    ArrayList<String> menuNonCoffe = Model.getAllMenuTransaksiNonCoffe();
    menuNonCoffe.add(0, "Menu Non Coffe");

    pilihTransaksiNonCoffe = new cComboBox(menuNonCoffe.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> mejaNonCoffe = Model.getAllMejaTransaksiNonCoffe();
    mejaNonCoffe.add(0, "Meja Non Coffe");

    pilihMejaNonCoffe = new cComboBox(mejaNonCoffe.toArray(new String[0]), 190, 302, 300, 30);

    ArrayList<String> promoNonCoffe = Model.getAllPromoTransaksiNonCoffe();
    promoNonCoffe.add(0, "Promo Non Coffe");

    ArrayList<String> menuUbahNonCoffe = Model.getAllMenuTransaksiUbahNonCoffe();
    menuUbahNonCoffe.add(0, "Menu Non Coffe");

    pilihTransaksiUbahNonCoffe = new cComboBox(menuUbahNonCoffe.toArray(new String[0]), 190, 210, 300, 30);

    ArrayList<String> mejaUbahNonCoffe = Model.getAllMejaTransaksiUbahNonCoffe();
    mejaUbahNonCoffe.add(0, "Meja Non Coffe");

    pilihMejaUbahNonCoffe = new cComboBox(mejaUbahNonCoffe.toArray(new String[0]), 190, 302, 300, 30);

    ArrayList<String> promoUbahNonCoffe = Model.getAllPromoTransaksiUbahNonCoffe();
    promoUbahNonCoffe.add(0, "Promo Non Coffe");

    pilihPromoUbahNonCoffe = new cComboBox(promoNonCoffe.toArray(new String[0]), 190, 390, 300, 20);
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

    txtNamaTransaksiMakanan.setText(null);
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
        if (txtNamaTransaksiMakanan.getText().trim().isEmpty()
            || pilihTransaksiMakanan.getSelectedItem() == null
            || pilihMejaMakanan.getSelectedItem() == null
            || pilihPembayaranMakanan.getSelectedItem() == null
            || txtDeskripsiTransaksiMakanan.getText().trim().isEmpty()
            || txtJumlahTransaksiMakanan.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          if (txtNamaTransaksiMakanan.getText().trim().isEmpty()) {
            content.add(errorNamaTransaksiMakanan);
          } else {
            content.remove(errorNamaTransaksiMakanan);
          }
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
          String namaTransaksi = txtNamaTransaksiMakanan.getText();
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
              + "nama Pemesan \n" + txtNamaTransaksiMakanan.getText() + "\n"
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

          if (Model.tambahTransaksiMakanan(idMitra, namaTransaksi, menuTransaksi,
              mejaTransaksi, promoTransaksi, deskripsiTransaksi, jumlahTransaksi, hargaTransaksi, bayarTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            txtNamaTransaksiMakanan.setText(null);
            txtJumlahTransaksiMakanan.setText(null);
            txtDeskripsiTransaksiMakanan.setText(null);
            pilihTransaksiMakanan.setSelectedIndex(0);
            pilihMejaMakanan.setSelectedIndex(0);
            pilihPromoMakanan.setSelectedIndex(0);
            txtHargaTransaksiMakanan.setText(null);
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }

        }
      }
    });

    btnHapusTransaksiMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaTransaksiMakanan.setText(null);
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
    content.add(labelNamaTransaksiMakanan);
    content.add(txtNamaTransaksiMakanan);
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
    content.add(txtTotalHargaMakanan);
    content.add(btnSimpanTransaksiMakanan);
    content.add(btnHapusTransaksiMakanan);
    content.add(btnKembaliTransaksiMakanan);
    setVisible(true);
  }

  private void initsUbahTransaksiMakanan(int idTransaksi) {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Ubah Transaksi Makanan");

    initializeTransaksiMakanan();

    Object[] detailTransaksiMakanan = Model.getDetailTransaksiMakananDiproses(idTransaksi);

    txtNamaTransaksiUbahMakanan.setText(detailTransaksiMakanan[4].toString());
    this.pilihTransaksiUbahMakanan.setSelectedItem(detailTransaksiMakanan[5].toString());
    this.pilihMejaUbahMakanan.setSelectedItem(detailTransaksiMakanan[6].toString());
    this.pilihPembayaranUbahMakanan.setSelectedItem(detailTransaksiMakanan[11].toString());
    txtDeskripsiTransaksiUbahMakanan.setText(detailTransaksiMakanan[8].toString());
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
        if (txtNamaTransaksiUbahMakanan.getText().trim().isEmpty()
            || pilihTransaksiUbahMakanan.getSelectedItem() == null
            || pilihMejaUbahMakanan.getSelectedItem() == null
            || pilihPembayaranUbahMakanan.getSelectedItem() == null
            || txtDeskripsiTransaksiUbahMakanan.getText().trim().isEmpty()
            || txtJumlahTransaksiUbahMakanan.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          if (txtNamaTransaksiUbahMakanan.getText().trim().isEmpty()) {
            content.add(errorNamaTransaksiUbahMakanan);
          } else {
            content.remove(errorNamaTransaksiUbahMakanan);
          }
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
          String namaTransaksi = txtNamaTransaksiUbahMakanan.getText();
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
              + "nama Pemesan \n" + txtNamaTransaksiUbahMakanan.getText() + "\n"
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

          if (Model.ubahTransaksiMakanan(idTransaksi, idMitra, namaTransaksi, menuTransaksi,
              mejaTransaksi, promoTransaksi, deskripsiTransaksi, jumlahTransaksi, hargaTransaksi, bayarTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            initsDataTransaksiMakanan();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }

        }
      }
    });

    btnHapusTransaksiUbahMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaTransaksiUbahMakanan.setText(null);
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
    content.add(labelNamaTransaksiUbahMakanan);
    content.add(txtNamaTransaksiUbahMakanan);
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
    content.add(txtTotalHargaUbahMakanan);
    content.add(btnSimpanTransaksiUbahMakanan);
    content.add(btnHapusTransaksiUbahMakanan);
    content.add(btnKembaliTransaksiUbahMakanan);
    setVisible(true);
  }

  private void initsUbahTransaksiNonCoffe(int idTransaksi) {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Ubah Transaksi NonCoffe");

    initializeTransaksiNonCoffe();

    Object[] detailTransaksiNonCoffe = Model.getDetailTransaksiNonCoffeDiproses(idTransaksi);

    txtNamaTransaksiUbahNonCoffe.setText(detailTransaksiNonCoffe[4].toString());
    this.pilihTransaksiUbahNonCoffe.setSelectedItem(detailTransaksiNonCoffe[5].toString());
    this.pilihMejaUbahNonCoffe.setSelectedItem(detailTransaksiNonCoffe[6].toString());
    this.pilihPembayaranUbahNonCoffe.setSelectedItem(detailTransaksiNonCoffe[11].toString());
    txtDeskripsiTransaksiUbahNonCoffe.setText(detailTransaksiNonCoffe[8].toString());
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
        if (txtNamaTransaksiUbahNonCoffe.getText().trim().isEmpty()
            || pilihTransaksiUbahNonCoffe.getSelectedItem() == null
            || pilihMejaUbahNonCoffe.getSelectedItem() == null
            || pilihPembayaranUbahNonCoffe.getSelectedItem() == null
            || txtDeskripsiTransaksiUbahNonCoffe.getText().trim().isEmpty()
            || txtJumlahTransaksiUbahNonCoffe.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          if (txtNamaTransaksiUbahNonCoffe.getText().trim().isEmpty()) {
            content.add(errorNamaTransaksiUbahNonCoffe);
          } else {
            content.remove(errorNamaTransaksiUbahNonCoffe);
          }
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
          String namaTransaksi = txtNamaTransaksiUbahNonCoffe.getText();
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
              + "nama Pemesan \n" + txtNamaTransaksiUbahNonCoffe.getText() + "\n"
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

          if (Model.ubahTransaksiNonCoffe(idTransaksi, idMitra, namaTransaksi, menuTransaksi,
              mejaTransaksi, promoTransaksi, deskripsiTransaksi, jumlahTransaksi, hargaTransaksi, bayarTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            initsDataTransaksiNonCoffe();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }

        }
      }
    });

    btnHapusTransaksiUbahNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaTransaksiUbahNonCoffe.setText(null);
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
    content.add(labelNamaTransaksiUbahNonCoffe);
    content.add(txtNamaTransaksiUbahNonCoffe);
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
    content.add(txtTotalHargaUbahNonCoffe);
    content.add(btnSimpanTransaksiUbahNonCoffe);
    content.add(btnHapusTransaksiUbahNonCoffe);
    content.add(btnKembaliTransaksiUbahNonCoffe);
    setVisible(true);
  }

  private void initsUbahTransaksiCoffe(int idTransaksi) {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Ubah Transaksi Coffe");

    initializeTransaksiCoffe();

    Object[] detailTransaksiCoffe = Model.getDetailTransaksiCoffeDiproses(idTransaksi);

    txtNamaTransaksiUbahCoffe.setText(detailTransaksiCoffe[4].toString());
    this.pilihTransaksiUbahCoffe.setSelectedItem(detailTransaksiCoffe[5].toString());
    this.pilihMejaUbahCoffe.setSelectedItem(detailTransaksiCoffe[6].toString());
    this.pilihPembayaranUbahCoffe.setSelectedItem(detailTransaksiCoffe[11].toString());
    txtDeskripsiTransaksiUbahCoffe.setText(detailTransaksiCoffe[8].toString());
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
        if (txtNamaTransaksiUbahCoffe.getText().trim().isEmpty()
            || pilihTransaksiUbahCoffe.getSelectedItem() == null
            || pilihMejaUbahCoffe.getSelectedItem() == null
            || pilihPembayaranUbahCoffe.getSelectedItem() == null
            || txtDeskripsiTransaksiUbahCoffe.getText().trim().isEmpty()
            || txtJumlahTransaksiUbahCoffe.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          if (txtNamaTransaksiUbahCoffe.getText().trim().isEmpty()) {
            content.add(errorNamaTransaksiUbahCoffe);
          } else {
            content.remove(errorNamaTransaksiUbahCoffe);
          }
          if (pilihTransaksiUbahCoffe.getSelectedItem() == null
              || pilihTransaksiUbahCoffe.getSelectedItem().toString().trim().equals("Menu Coffe")) {
            content.add(errorTransaksiUbahCoffe);
          } else {
            content.remove(errorTransaksiUbahCoffe);
          }
          if (pilihMejaUbahCoffe.getSelectedItem() == null
              || pilihMejaUbahCoffe.getSelectedItem().toString().trim().equals("Menu Coffe")) {
            content.add(errorMejaTransaksiUbahCoffe);
          } else {
            content.remove(errorMejaTransaksiUbahCoffe);
          }
          if (pilihPembayaranUbahCoffe.getSelectedItem() == null
              || pilihPembayaranUbahCoffe.getSelectedItem().toString().trim().equals("Menu Coffe")) {
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
          String namaTransaksi = txtNamaTransaksiUbahCoffe.getText();
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
              if (!selectedPromo.equals("Promo Coffe")) {
                int hargaPromo = Model.getPromoMenuUbahCoffe(selectedPromo);
                int transaksiPromo = hargaTransaksi - hargaPromo;
                String totalHargaPromo = Integer.toString(transaksiPromo);
                txtTotalHargaUbahCoffe.setText(totalHargaPromo);
              }
            }
          });

          Object[] messagePromo = { "pilih Promo Coffe", pilihPromoUbahCoffe };
          JOptionPane.showMessageDialog(null, messagePromo, "Promo",
              JOptionPane.PLAIN_MESSAGE);

          String pembayaranUbahCoffe = "Data Transaksi UbahCoffe" + "\n\n"
              + "nama Pemesan \n" + txtNamaTransaksiUbahCoffe.getText() + "\n"
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

          if (Model.ubahTransaksiCoffe(idTransaksi, idMitra, namaTransaksi, menuTransaksi,
              mejaTransaksi, promoTransaksi, deskripsiTransaksi, jumlahTransaksi, hargaTransaksi, bayarTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            initsDataTransaksiCoffe();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }

        }
      }
    });

    btnHapusTransaksiUbahCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaTransaksiUbahCoffe.setText(null);
        txtJumlahTransaksiUbahCoffe.setText(null);
        txtDeskripsiTransaksiUbahCoffe.setText(null);
        pilihTransaksiUbahCoffe.setSelectedItem("Pilih Coffe");
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
    content.add(labelNamaTransaksiUbahCoffe);
    content.add(txtNamaTransaksiUbahCoffe);
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
    content.add(txtTotalHargaUbahCoffe);
    content.add(btnSimpanTransaksiUbahCoffe);
    content.add(btnHapusTransaksiUbahCoffe);
    content.add(btnKembaliTransaksiUbahCoffe);
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

    txtNamaTransaksiCoffe.setText(null);
    txtJumlahTransaksiCoffe.setText(null);
    txtDeskripsiTransaksiCoffe.setText(null);
    pilihTransaksiCoffe.setSelectedIndex(0);
    pilihMejaCoffe.setSelectedIndex(0);
    pilihPembayaranCoffe.setSelectedIndex(0);
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
        if (txtNamaTransaksiCoffe.getText().trim().isEmpty()
            || pilihTransaksiCoffe.getSelectedItem() == null
            || pilihMejaCoffe.getSelectedItem() == null
            || pilihPembayaranCoffe.getSelectedItem() == null
            || txtDeskripsiTransaksiCoffe.getText().trim().isEmpty()
            || txtJumlahTransaksiCoffe.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          if (txtNamaTransaksiCoffe.getText().trim().isEmpty()) {
            content.add(errorNamaTransaksiCoffe);
          } else {
            content.remove(errorNamaTransaksiCoffe);
          }
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
          String namaTransaksi = txtNamaTransaksiCoffe.getText();
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
              + "nama Pemesan \n" + txtNamaTransaksiCoffe.getText() + "\n"
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

          if (Model.tambahTransaksiCoffe(idMitra, namaTransaksi, menuTransaksi,
              mejaTransaksi, promoTransaksi, deskripsiTransaksi, jumlahTransaksi, hargaTransaksi, bayarTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            txtNamaTransaksiCoffe.setText(null);
            txtJumlahTransaksiCoffe.setText(null);
            txtDeskripsiTransaksiCoffe.setText(null);
            pilihTransaksiCoffe.setSelectedIndex(0);
            pilihMejaCoffe.setSelectedIndex(0);
            pilihPembayaranCoffe.setSelectedIndex(0);
            txtHargaTransaksiCoffe.setText(null);
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }

        }
      }
    });

    btnHapusTransaksiCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaTransaksiCoffe.setText(null);
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
    content.add(labelNamaTransaksiCoffe);
    content.add(txtNamaTransaksiCoffe);
    content.add(labelJumlahTransaksiCoffe);
    content.add(txtJumlahTransaksiCoffe);
    content.add(labelMejaTransaksiCoffe);
    content.add(pilihMejaCoffe);
    content.add(labelDeskripsiTransaksiCoffe);
    content.add(txtDeskripsiTransaksiCoffe);
    content.add(labelPilihTransaksiCoffe);
    content.add(pilihTransaksiCoffe);
    content.add(labelPromoTransaksiCoffe);
    content.add(pilihPembayaranCoffe);
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

    initializeTransaksiNonCoffe();

    txtNamaTransaksiNonCoffe.setText(null);
    txtJumlahTransaksiNonCoffe.setText(null);
    txtDeskripsiTransaksiNonCoffe.setText(null);
    pilihTransaksiNonCoffe.setSelectedIndex(0);
    pilihMejaNonCoffe.setSelectedIndex(0);
    pilihPembayaranNonCoffe.setSelectedIndex(0);
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
        if (txtNamaTransaksiNonCoffe.getText().trim().isEmpty()
            || pilihTransaksiNonCoffe.getSelectedItem() == null
            || pilihMejaNonCoffe.getSelectedItem() == null
            || pilihPembayaranNonCoffe.getSelectedItem() == null
            || txtDeskripsiTransaksiNonCoffe.getText().trim().isEmpty()
            || txtJumlahTransaksiNonCoffe.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          if (txtNamaTransaksiNonCoffe.getText().trim().isEmpty()) {
            content.add(errorNamaTransaksiNonCoffe);
          } else {
            content.remove(errorNamaTransaksiNonCoffe);
          }
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
          String namaTransaksi = txtNamaTransaksiNonCoffe.getText();
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

          String pembayaranNonCoffe = "Data Transaksi Non Coffe" + "\n\n"
              + "nama Pemesan \n" + txtNamaTransaksiNonCoffe.getText() + "\n"
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

          if (Model.tambahTransaksiNonCoffe(idMitra, namaTransaksi, menuTransaksi,
              mejaTransaksi, promoTransaksi, deskripsiTransaksi, jumlahTransaksi, hargaTransaksi, bayarTransaksi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " +
                kembalian);
            txtNamaTransaksiNonCoffe.setText(null);
            txtJumlahTransaksiNonCoffe.setText(null);
            txtDeskripsiTransaksiNonCoffe.setText(null);
            pilihTransaksiNonCoffe.setSelectedIndex(0);
            pilihMejaNonCoffe.setSelectedIndex(0);
            pilihPromoNonCoffe.setSelectedIndex(0);
            txtHargaTransaksiNonCoffe.setText(null);
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Gagal!.",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }

        }
      }
    });

    btnHapusTransaksiNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaTransaksiNonCoffe.setText(null);
        txtJumlahTransaksiNonCoffe.setText(null);
        txtDeskripsiTransaksiNonCoffe.setText(null);
        pilihTransaksiNonCoffe.setSelectedItem("Pilih NonCoffe");
        pilihMejaNonCoffe.setSelectedItem("Pilih Meja");
        pilihPembayaranCoffe.setSelectedItem("Pilih Pembayaran");
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
    content.add(labelJumlahTransaksiNonCoffe);
    content.add(txtJumlahTransaksiNonCoffe);
    content.add(labelMejaTransaksiNonCoffe);
    content.add(pilihMejaNonCoffe);
    content.add(labelDeskripsiTransaksiNonCoffe);
    content.add(txtDeskripsiTransaksiNonCoffe);
    content.add(labelPilihTransaksiNonCoffe);
    content.add(pilihTransaksiNonCoffe);
    content.add(labelPromoTransaksiNonCoffe);
    content.add(pilihPembayaranNonCoffe);
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

    tblOrderBahan = new cTable(Model.getAllOrderBahanDiproses());

    tblOrderBahan.getColumnModel().getColumn(0).setMinWidth(0);
    tblOrderBahan.getColumnModel().getColumn(0).setMaxWidth(0);
    tblOrderBahan.getColumnModel().getColumn(0).setWidth(0);

    tblOrderBahan.getColumnModel().getColumn(1).setMinWidth(0);
    tblOrderBahan.getColumnModel().getColumn(1).setMaxWidth(0);
    tblOrderBahan.getColumnModel().getColumn(1).setWidth(0);

    tblOrderBahan.getColumnModel().getColumn(2).setMinWidth(0);
    tblOrderBahan.getColumnModel().getColumn(2).setMaxWidth(0);
    tblOrderBahan.getColumnModel().getColumn(2).setWidth(0);

    tblOrderBahan.getColumnModel().getColumn(6).setMinWidth(0);
    tblOrderBahan.getColumnModel().getColumn(6).setMaxWidth(0);
    tblOrderBahan.getColumnModel().getColumn(6).setWidth(0);

    tblOrderBahan.getColumnModel().getColumn(7).setMinWidth(0);
    tblOrderBahan.getColumnModel().getColumn(7).setMaxWidth(0);
    tblOrderBahan.getColumnModel().getColumn(7).setWidth(0);

    spOrderBahan = new cScrollPane(tblOrderBahan, 0, 140, 1100, 300);

    content.add(spOrderBahan);

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
