package com.views;

import com.templates.cDashboardApp;
import com.partials.*;
import com.main.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

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
  private cTable tblTransaksiMakanan;
  private cScrollPane spTransaksiMakanan;

  // component of data menu coffe
  private cLabelInfo labelCariTransaksiCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariTransaksiCoffe = new cTextField(100, 40, 300);
  private cTable tblTransaksiCoffe;
  private cScrollPane spTransaksiCoffe;

  // component of data menu non coffe
  private cLabelInfo labelCariTransaksiNonCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
  private cTextField txtCariTransaksiNonCoffe = new cTextField(100, 40, 300);
  private cTable tblTransaksiNonCoffe;
  private cScrollPane spTransaksiNonCoffe;

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

  // component of input data Transaksi Non Coffe
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

    tblDataPromo.getColumnModel().getColumn(7).setMinWidth(0);
    tblDataPromo.getColumnModel().getColumn(7).setMaxWidth(0);
    tblDataPromo.getColumnModel().getColumn(7).setWidth(0);

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
    ArrayList<String> menuNames = Model.getAllMenuPromo();
    menuNames.add(0, "Pilih Menu"); // Add the default "Pilih Menu" option at the beginning

    pilihMenuPromo = new cComboBox(menuNames.toArray(new String[0]), 190, 302, 300, 30);
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
            content.add(errorNamaPromo);
          } else {
            content.remove(errorNamaPromo);
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
