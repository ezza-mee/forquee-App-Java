package com.views;

import com.templates.cDashboardApp;
import com.partials.*;
import com.main.*;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class cDashboardMitraView extends cDashboardApp {

  Integer idMitra = null;
  Integer idSelected = null;
  int hargaBahan = 0;

  // sidebar menu
  private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
  private cSidebarMenu menuDataMenu = new cSidebarMenu("Data Menu", 70 + 50);
  private cSidebarMenu menuDataPromo = new cSidebarMenu("Data Promo", 70 + 50 + 50);
  private cSidebarMenu menuDataMeja = new cSidebarMenu("Data Meja", 70 + 50 + 50 + 50);
  private cSidebarMenu menuDataCustomer = new cSidebarMenu("Data Customer", 70 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuDataKaryawan = new cSidebarMenu("Data Karyawan", 70 + 50 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuTransaksi = new cSidebarMenu("Transaksi", 70 + 50 + 50 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuOrderBahan = new cSidebarMenu("Order Bahan", 70 + 50 + 50 + 50 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuHistory = new cSidebarMenu("History", 70 + 50 + 50 + 50 + 50 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuReport = new cSidebarMenu("Data Laporan", 70 + 50 + 50 + 50 + 50 + 50 + 50 + 50 + 50 + 50);
  private cSidebarMenu menuAkun = new cSidebarMenu("Akun", 70 + 50 + 50 + 50 + 50 + 50 + 50 + 50 + 50 + 50 + 50);

  // componetn of data beranda
  private cDateTime labelDateTimeBeranda = new cDateTime(840, 15, 300);
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

  // component of data Menu
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
  private cButton btnTambahMakanan = new cButton("Tambah", 400, 95, 150, 30, 15);
  private cButton btnEditDataMakanan = new cButton("Edit", 600, 95, 150, 30, 15);
  private cButton btnHapusDataMakanan = new cButton("Hapus", 800, 95, 150, 30, 15);
  private cButton btnKembaliMakanan = new cButton("Kembali", 190, 480, 150, 30, 15);

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
  private cButton btnTambahCoffe = new cButton("Tambah", 400, 95, 150, 30, 20);
  private cButton btnEditDataCoffe = new cButton("Edit", 600, 95, 150, 30, 20);
  private cButton btnHapusDataCoffe = new cButton("Hapus", 800, 95, 150, 30, 20);
  private cButton btnKembaliCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

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
  private cButton btnTambahNonCoffe = new cButton("Tambah", 440, 90, 150, 30, 20);
  private cButton btnEditDataNonCoffe = new cButton("Edit", 630, 90, 150, 30, 20);
  private cButton btnHapusDataNonCoffe = new cButton("Hapus", 820, 90, 150, 30, 20);
  private cButton btnKembaliNonCoffe = new cButton("Kembali", 190, 480, 150, 30, 20);

  // component of input data menu makanan
  private cPanelRounded panelHeaderInputMenuMakanan = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputMenuMakanan = new cLabelInfo("Masukan Data Menu Makanan!", 190, 20, 400, 40);
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
  private cPanelRounded panelHeaderInputMenuCoffe = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputMenuCoffe = new cLabelInfo("Masukan Data Menu Coffe!", 190, 20, 400, 40);
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
  private cPanelRounded panelHeaderInputMenuNonCoffe = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputMenuNonCoffe = new cLabelInfo("Masukan Data Menu Non Coffe!", 190, 20, 400, 40);
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
  private cPanelRounded panelHeaderInputMenuUbahMakanan = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputMenuUbahMakanan = new cLabelInfo("Ubah Data Menu Makanan!", 190, 20, 400, 40);
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
  private cPanelRounded panelHeaderInputMenuUbahCoffe = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputMenuUbahCoffe = new cLabelInfo("Ubah Data Menu Coffe!", 190, 20, 400, 40);
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
  private cPanelRounded panelHeaderInputMenuUbahNonCoffe = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputMenuUbahNonCoffe = new cLabelInfo("Ubah Data Menu Non Coffe!", 190, 20, 400, 40);
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
  private cPanelRounded panelHeaderPromo = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelDeskripsiPromo = new cPanelRounded(600, 150, 500, 410, 15);
  private cLabelInfo valueDataPromo = new cLabelInfo("Promo", 660, 160, 300, 40);
  private cBigFont labelRpDataPromo = new cBigFont("Rp.", 660, 180);
  private cBigFont valueHargaPromo = new cBigFont("0", 730, 180);
  private cTextarea valueDeskripsiPromo = new cTextarea(660, 260, 380, 220, false);
  private cLabelInfo labelPromo = new cLabelInfo("Data Promo Forque", 40, 20, 300, 40);
  private cTextField txtCariPromo = new cTextField(40, 85, 300);
  private cButton btnTambahPromo = new cButton("Tambah", 400, 100, 150, 30, 20);
  private cButton btnHapusDataPromo = new cButton("Hapus", 600, 100, 150, 30, 20);
  private cButton btnEditDataPromo = new cButton("Edit", 800, 100, 150, 30, 20);
  private cButton btnKembaliPromo = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliUbahPromo = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cTable tblDataPromo;
  private cScrollPane spDataPromo;

  // component of input promo
  private cPanelRounded panelHeaderInputPromo = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputPromo = new cLabelInfo("Masukan Data Promo!", 190, 20, 400, 40);
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

  // component of input Ubah Promo
  private cPanelRounded panelHeaderUbahPromo = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputUbahPromo = new cLabelInfo("Ubah Data Promo!", 190, 20, 400, 40);
  private cLabelInfo labelNamaUbahPromo = new cLabelInfo("Nama UbahPromo", 190, 90, 300, 40);
  private cTextField txtNamaUbahPromo = new cTextField(190, 120, 300);
  private cErrorLabel errorNamaUbahPromo = new cErrorLabel("Nama UbahPromo tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelJumlahUbahPromo = new cLabelInfo("Jumlah UbahPromo", 190, 180, 300, 40);
  private cTextField txtJumlahUbahPromo = new cTextField(190, 210, 300);
  private cErrorLabel errorJumlahUbahPromo = new cErrorLabel("Jumlah tidak boleh Kosong!", 190, 235, 400);
  private cLabelInfo labelPilihMenuUbahPromo = new cLabelInfo("Menu UbahPromo", 190, 270, 300, 40);
  private cErrorLabel errorMenuUbahPromo = new cErrorLabel("Menu UbahPromo tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelDeskripsiUbahPromo = new cLabelInfo("Deskripsi UbahPromo", 580, 90, 300, 40);
  private cTextarea txtDeskripsiUbahPromo = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiUbahPromo = new cErrorLabel("Deskripsi UbahPromo tidak boleh Kosong!", 580, 235,
      300);
  private cLabelInfo labelHargaUbahPromo = new cLabelInfo("Harga UbahPromo", 580, 270, 300, 40);
  private cTextField txtHargaUbahPromo = new cTextField(580, 302, 300);
  private cErrorLabel errorHargaUbahPromo = new cErrorLabel("Harga UbahPromo tidak boleh Kosong!", 580, 327, 300);
  private cButton btnHapusUbahPromo = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanUbahPromo = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cComboBox pilihMenuUbahPromo;

  // component of data meja
  private cPanelRounded panelHeaderMeja = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelDeskripsiMeja = new cPanelRounded(600, 150, 500, 410, 15);
  private cLabelInfo labelJenisDataMeja = new cLabelInfo("Jenis Meja", 660, 160, 300, 40);
  private cBigFont valueJenisDataMeja = new cBigFont("", 660, 180);
  private cTextarea valueDeskripsiMeja = new cTextarea(660, 260, 380, 220, false);
  private cLabelInfo labelMeja = new cLabelInfo("Data Meja Forque", 40, 20, 300, 40);
  private cTextField txtCariMeja = new cTextField(40, 85, 300);
  private cButton btnTambahMeja = new cButton("Tambah", 400, 95, 150, 30, 20);
  private cButton btnHapusDataMeja = new cButton("Hapus", 600, 95, 150, 30, 20);
  private cButton btnEditDataMeja = new cButton("Edit", 800, 95, 150, 30, 20);
  private cButton btnKembaliMeja = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliUbahMeja = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cTable tblDataMeja;
  private cScrollPane spDataMeja;

  // component of input data meja
  private cPanelRounded panelHeaderInputMeja = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputMeja = new cLabelInfo("Masukan Data Meja!", 190, 20, 400, 40);
  private cLabelInfo labelNomorMeja = new cLabelInfo("Nomor Meja", 190, 90, 300, 40);
  private cComboBox pilihNomorMeja = new cComboBox(new String[] { "Nomor Meja", "V1", "V2", "V3", "V4", "V5", "V6",
      "V7", "V8", "V9", "V10", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "NR1", "NR2", "NR3", "NR4",
      "NR5", "NR6", "NR7", "NR8", "NR9", "NR10" }, 190, 120, 300, 30);
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
  private cPanelRounded panelHeaderUbahMeja = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelInputUbahMeja = new cLabelInfo("Masukan Data untuk ubah Data Meja!", 190, 20, 400, 40);
  private cLabelInfo labelNomorUbahMeja = new cLabelInfo("Nomor Meja", 190, 90, 300, 40);
  private cComboBox pilihNomorUbahMeja = new cComboBox(new String[] { "Nomor Meja", "V1", "V2", "V3", "V4", "V5", "V6",
      "V7", "V8", "V9", "V10", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "NR1", "NR2", "NR3", "NR4",
      "NR5", "NR6", "NR7", "NR8", "NR9", "NR10" }, 190, 120, 300, 30);
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
  private cPanelRounded panelHeaderCustomer = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelCustomer = new cLabelInfo("Data Customer Aktif", 40, 20, 300, 40);
  private cTextField txtCariCustomer = new cTextField(40, 85, 300);
  private cTable tblDataCustomer;
  private cScrollPane spDataCustomer;

  // component of data karyawan
  private cComboBox pilihDataKaryawan = new cComboBox(
      new String[] { "Karyawan Verified", "Karyawan Terverifikasi" }, 150, 25, 300, 30);

  // component of data karyawan Terverifikasi
  private cPanelRounded panelHeaderTerverifikasi = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelAlamatTerverifikasi = new cPanelRounded(610, 430, 490, 130, 15);
  private cLabelInfo labelTerverifikasi = new cLabelInfo("Pilih Data", 40, 20, 200, 40);
  private cTextarea valueAlamatDataTerverifikasi = new cTextarea(650, 450, 400, 100, false);
  private cTextField txtCariTerverifikasi = new cTextField(40, 85, 300);
  private cButton btnHapusDataTerverifikasi = new cButton("Hapus", 400, 95, 150, 30, 20);
  private cButton btnEditDataTerverifikasi = new cButton("Edit", 600, 95, 150, 30, 20);
  private cButton btnKembaliUbahTerverifikasi = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cTable tblDataTerverifikasi;
  private cScrollPane spDataTerverifikasi;

  // component of input data Ubah Karyawan Terverifikasi
  private cPanelRounded panelHeaderInputTerverifikasi = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelDataUbahTerverifikasi = new cLabelInfo("Masukan Data Ubah Terverifikasi!", 190, 20, 400, 40);
  private cLabelInfo labelNamaUbahTerverifikasi = new cLabelInfo("Nama", 190, 100, 100, 40);
  private cLabelInfo labelNomorHpUbahTerverifikasi = new cLabelInfo("Nomor Hp", 190, 200, 200, 40);
  private cLabelInfo labelEmailUbahTerverifikasi = new cLabelInfo("Email", 190, 300, 100, 40);
  private cLabelInfo labelAlamatUbahTerverifikasi = new cLabelInfo("Alamat", 580, 200, 100, 40);
  private cLabelInfo labelJobdeskUbahTerverifikasi = new cLabelInfo("Pilih Jobdesk", 580, 100, 200, 40);
  private cErrorLabel errorNamaUbahTerverifikasi = new cErrorLabel("Nama tidak boleh kosong!", 190, 165, 300);
  private cErrorLabel errorNomorHpUbahTerverifikasi = new cErrorLabel("Nomor Hp tidak boleh Kosong!", 190, 265, 300);
  private cErrorLabel errorEmailUbahTerverifikasi = new cErrorLabel("Email tidak boleh Kosong!", 190, 365, 300);
  private cErrorLabel errorJobdeskUbahTerverifikasi = new cErrorLabel("Jobdek tidak boleh Kosong!", 580, 165, 300);
  private cErrorLabel errorAlamatUbahTerverifikasi = new cErrorLabel("Alamat tidak boleh Kosong!", 580, 380, 300);
  private cTextField txtNamaUbahTerverifikasi = new cTextField(190, 135, 300);
  private cTextField txtNomorHpUbahTerverifikasi = new cTextField(190, 235, 300);
  private cTextField txtEmailUbahTerverifikasi = new cTextField(190, 335, 300);
  private cTextarea txtAlamatUbahTerverifikasi = new cTextarea(580, 235, 300, 150, true);
  private cComboBox pilihJobdeskUbahTerverifikasi = new cComboBox(
      new String[] { "Operator Mesin", "Petugas Layanan", "Teknisi Mesin", "Administrasi",
          "Supervisor", "Staf", "Kasir" },
      580, 135, 300, 30);
  private cButton btnHapusUbahTerverifikasi = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanUbahTerverifikasi = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of data karyawan Verified
  private cPanelRounded panelHeaderKaryawan = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelAlamatKaryawan = new cPanelRounded(610, 430, 490, 130, 15);
  private cLabelInfo labelKaryawan = new cLabelInfo("Pilih Data", 40, 20, 200, 40);
  private cTextarea valueAlamatDataKaryawan = new cTextarea(650, 450, 400, 100, false);
  private cTextField txtCariKaryawan = new cTextField(40, 85, 300);
  private cButton btnTambahKaryawan = new cButton("Tambah", 400, 95, 150, 30, 20);
  private cButton btnHapusDataKaryawan = new cButton("Hapus", 600, 95, 150, 30, 20);
  private cButton btnEditDataKaryawan = new cButton("Edit", 800, 95, 150, 30, 20);
  private cButton btnKembaliKaryawan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliUbahKaryawan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cTable tblDataKaryawan;
  private cScrollPane spDataKaryawan;

  // component of input data karyawan Verified
  private cPanelRounded panelHeaderInputKaryawan = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelDataKaryawan = new cLabelInfo("Masukan Data Karyawan!", 190, 20, 400, 40);
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

  // component of input data Ubah Karyawan Verified
  private cPanelRounded panelHeaderUbahKaryawan = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelDataUbahKaryawan = new cLabelInfo("Masukan Data Ubah Karyawan!", 190, 20, 400, 40);
  private cLabelInfo labelNamaUbahKaryawan = new cLabelInfo("Nama", 190, 100, 100, 40);
  private cLabelInfo labelNomorHpUbahKaryawan = new cLabelInfo("Nomor Hp", 190, 200, 200, 40);
  private cLabelInfo labelEmailUbahKaryawan = new cLabelInfo("Email", 190, 300, 100, 40);
  private cLabelInfo labelAlamatUbahKaryawan = new cLabelInfo("Alamat", 580, 200, 100, 40);
  private cLabelInfo labelJobdeskUbahKaryawan = new cLabelInfo("Pilih Jobdesk", 580, 100, 200, 40);
  private cErrorLabel errorNamaUbahKaryawan = new cErrorLabel("Nama tidak boleh kosong!", 190, 165, 300);
  private cErrorLabel errorNomorHpUbahKaryawan = new cErrorLabel("Nomor Hp tidak boleh Kosong!", 190, 265, 300);
  private cErrorLabel errorEmailUbahKaryawan = new cErrorLabel("Email tidak boleh Kosong!", 190, 365, 300);
  private cErrorLabel errorJobdeskUbahKaryawan = new cErrorLabel("Jobdek tidak boleh Kosong!", 580, 165, 300);
  private cErrorLabel errorAlamatUbahKaryawan = new cErrorLabel("Alamat tidak boleh Kosong!", 580, 380, 300);
  private cTextField txtNamaUbahKaryawan = new cTextField(190, 135, 300);
  private cTextField txtNomorHpUbahKaryawan = new cTextField(190, 235, 300);
  private cTextField txtEmailUbahKaryawan = new cTextField(190, 335, 300);
  private cTextarea txtAlamatUbahKaryawan = new cTextarea(580, 235, 300, 150, true);
  private cComboBox pilihJobdeskUbahKaryawan = new cComboBox(
      new String[] { "Operator Mesin", "Petugas Layanan", "Teknisi Mesin", "Administrasi",
          "Supervisor", "Staf", "Kasir" },
      580, 135, 300, 30);
  private cButton btnHapusUbahKaryawan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanUbahKaryawan = new cButton("Simpan", 730, 480, 150, 30, 20);

  // component of data transaksi
  private cPanelRounded panelHeaderTransaksi = new cPanelRounded(0, 0, 1100, 75, 15);
  private cLabelInfo labelPilihTransaksi = new cLabelInfo("Pilih Data", 40, 20, 200, 40);
  private cComboBox pilihTransaksi = new cComboBox(new String[] { "Data Transaksi", "Proses Transaksi" }, 180, 23, 200,
      30);
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
  private cPanelRounded panelInputTransaksi = new cPanelRounded(0, 0, 1100, 70, 15);
  private cLabelInfo labelInputTransaksi = new cLabelInfo("Masukan Data Transaksi !", 80, 15, 400, 40);
  private cLabelInfo labelMejaTransaksi = new cLabelInfo("Nomor Meja", 80, 80, 300, 40);
  private cErrorLabel errorMejaTransaksi = new cErrorLabel("Nomor Meja tidak boleh Kosong!", 80, 135, 300);
  private cLabelInfo labelNamaTransaksi = new cLabelInfo("Nama Pemesan", 80, 175, 300, 40);
  private cTextField txtNamaTransaksi = new cTextField(80, 205, 300);
  private cErrorLabel errorNamaTransaksi = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 80, 230, 400);
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
  private cPanelRounded panelUbahTransaksi = new cPanelRounded(0, 0, 1100, 70, 15);
  private cLabelInfo labelInputUbahTransaksi = new cLabelInfo("Masukan Data Untuk Ubah Transaksi !", 80, 15, 400, 40);
  private cLabelInfo labelMejaUbahTransaksi = new cLabelInfo("Nomor Meja", 80, 80, 300, 40);
  private cErrorLabel errorMejaUbahTransaksi = new cErrorLabel("Nomor Meja tidak boleh Kosong!", 80, 135, 300);
  private cLabelInfo labelNamaUbahTransaksi = new cLabelInfo("Nama Pemesan", 80, 175, 300, 40);
  private cTextField txtNamaUbahTransaksi = new cTextField(80, 205, 300);
  private cErrorLabel errorNamaUbahTransaksi = new cErrorLabel("Nama Pemesan tidak boleh Kosong!", 80, 230, 400);
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

  // component of Proses transaksi
  private cRadioButton rdOfflineProsesTransaksi = new cRadioButton("Order Offline", "active", 40, 100, 150);
  private cRadioButton rdOnlineProsesTransaksi = new cRadioButton("Order Online", "nonactive", 200, 100, 150);

  // component of proses order offline
  private cPanelRounded panelHeaderProsesOrderOffline = new cPanelRounded(0, 0, 1100, 75, 15);
  private cTextField txtCariProsesOrderOffline = new cTextField(760, 85, 300);
  private cLabelInfo labelPilihProsesOrderOffline = new cLabelInfo("Pilih Data", 40, 20, 200, 40);
  private cButton btnProsesOrderOffline = new cButton("Proses", 380, 95, 150, 30, 20);
  private cButton btnDetailProsesOrderOffline = new cButton("Detail", 570, 95, 150, 30, 20);
  private cTable tblDataProsesOrderOffline;
  private cScrollPane spDataProsesOrderOffline;

  // component of proses order online
  private cPanelRounded panelHeaderProsesOrderOnline = new cPanelRounded(0, 0, 1100, 75, 15);
  private cTextField txtCariProsesOrderOnline = new cTextField(760, 85, 300);
  private cLabelInfo labelPilihProsesOrderOnline = new cLabelInfo("Pilih Data", 40, 20, 200, 40);
  private cButton btnProsesOrderOnline = new cButton("Proses", 380, 95, 150, 30, 20);
  private cButton btnDetailProsesOrderOnline = new cButton("Detail", 570, 95, 150, 30, 20);
  private cTable tblDataProsesOrderOnline;
  private cScrollPane spDataProsesOrderOnline;

  // component of data Order Bahan
  private cPanelRounded panelHeaderOrderBahan = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelDeskripsiOrderBahan = new cPanelRounded(700, 150, 400, 410, 15);
  private cTextarea valueDeskripsiOrderBahan = new cTextarea(750, 180, 300, 150, false);
  private cTextarea valueAlamatOrderBahan = new cTextarea(750, 360, 300, 150, false);
  private cLabelInfo labelOrderBahan = new cLabelInfo("Data Order Bahan", 40, 20, 300, 40);
  private cTextField txtCariOrderBahan = new cTextField(40, 85, 300);
  private cButton btnTambahOrderBahan = new cButton("Tambah", 400, 95, 150, 30, 20);
  private cButton btnHapusDataOrderBahan = new cButton("Hapus", 600, 95, 150, 30, 20);
  private cButton btnEditDataOrderBahan = new cButton("Edit", 800, 95, 150, 30, 20);
  private cButton btnKembaliOrderBahan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cButton btnKembaliUbahOrderBahan = new cButton("Kembali", 190, 480, 150, 30, 20);
  private cTable tblOrderBahan;
  private cScrollPane spOrderBahan;

  // component of input Order Bahan
  private cLabelInfo labelInputOrderBahan = new cLabelInfo("Masukan Data Order Bahan!", 190, 20, 400, 40);
  private cLabelInfo labelJumlahOrderBahan = new cLabelInfo("Jumlah Bahan", 190, 90, 300, 40);
  private cTextField txtJumlahOrderBahan = new cTextField(190, 120, 300);
  private cErrorLabel errorJumlahOrderBahan = new cErrorLabel("Jumlah Bahan tidak boleh Kosong!", 190, 145, 400);
  private cLabelInfo labelPilihMenuOrderBahan = new cLabelInfo("Pilih Bahan", 190, 180, 300, 40);
  private cComboBox pilihMenuOrderBahan = new cComboBox(new String[] { "Coffe", "Telur", "Beras" }, 190, 210, 300,
      30);
  private cErrorLabel errorMenuOrderBahan = new cErrorLabel("Menu Bahan tidak boleh Kosong!", 190, 235, 300);
  private cLabelInfo labelPilihPTOrderBahan = new cLabelInfo("Pilih PT", 190, 270, 300, 40);
  private cComboBox pilihPTOrderBahan = new cComboBox(new String[] { "PT SAWI", "PT COFFE", "PT CABE", "PT TOBRUT" },
      190, 302,
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
  private cTextField txtHargaTotalOrderBahan = new cTextField(190, 120, 300);

  // component of ubah input Order Bahan
  private cLabelInfo labelInputOrderUbahBahan = new cLabelInfo("Masukan Data Order Ubah Bahan!", 190, 20, 400, 40);
  private cLabelInfo labelJumlahOrderUbahBahan = new cLabelInfo("Jumlah UbahBahan", 190, 90, 300, 40);
  private cTextField txtJumlahOrderUbahBahan = new cTextField(190, 120, 300);
  private cErrorLabel errorJumlahOrderUbahBahan = new cErrorLabel("Jumlah Bahan tidak boleh Kosong!", 190, 145,
      400);
  private cLabelInfo labelPilihMenuOrderUbahBahan = new cLabelInfo("Pilih Ubah Bahan", 190, 180, 300, 40);
  private cComboBox pilihMenuOrderUbahBahan = new cComboBox(new String[] { "Coffe", "Telur", "Beras" }, 190, 210, 300,
      30);
  private cErrorLabel errorMenuOrderUbahBahan = new cErrorLabel("Menu Bahan tidak boleh Kosong!", 190, 235, 300);
  private cLabelInfo labelPilihPTOrderUbahBahan = new cLabelInfo("Pilih PT", 190, 270, 300, 40);
  private cComboBox pilihPTOrderUbahBahan = new cComboBox(new String[] { "PT SAWI", "PT COFFE", "PT CABE" }, 190, 302,
      300,
      30);
  private cErrorLabel errorPTOrderUbahBahan = new cErrorLabel("PT tidak boleh Kosong!", 190, 327, 300);
  private cLabelInfo labelHargaOrderUbahBahan = new cLabelInfo("Harga UbahBahan", 190, 360, 300, 40);
  private cTextField txtHargaOrderUbahBahan = new cTextField(190, 392, 300);
  private cLabelInfo labelDeskripsiOrderUbahBahan = new cLabelInfo("Deskripsi UbahBahan", 580, 90, 300, 40);
  private cTextarea txtDeskripsiOrderUbahBahan = new cTextarea(580, 120, 300, 120, true);
  private cErrorLabel errorDeskripsiOrderUbahBahan = new cErrorLabel("Deskripsi Order Ubah Bahan tidak boleh Kosong!",
      580, 235,
      300);
  private cLabelInfo labelAlamatOrderUbahBahan = new cLabelInfo("Alamat", 580, 270, 300, 40);
  private cTextarea txtAlamatOrderUbahBahan = new cTextarea(580, 300, 300, 120, true);
  private cErrorLabel errorAlamatOrderUbahBahan = new cErrorLabel("Alamat tidak boleh Kosong!", 580, 415, 400);
  private cButton btnHapusOrderUbahBahan = new cButton("Hapus", 540, 480, 150, 30, 20);
  private cButton btnSimpanOrderUbahBahan = new cButton("Simpan", 730, 480, 150, 30, 20);
  private cTextField txtHargaTotalUbahBahan = new cTextField(190, 120, 300);

  // component of data history
  private cLabelInfo labelHistory = new cLabelInfo("Pilih History", 40, 20, 300, 40);
  private cComboBox pilihHistory = new cComboBox(
      new String[] { "History Bahan", "Order Offline", "Order Online" },
      170, 23, 200,
      30);

  // History Order Bahan
  private cPanelRounded panelHeaderHistoryBahan = new cPanelRounded(0, 0, 1100, 75, 15);
  private cPanelRounded panelDeskripsiHistoryBahan = new cPanelRounded(700, 150, 400, 410, 15);
  private cTextarea valueDeskripsiHistoryBahan = new cTextarea(750, 180, 300, 150, false);
  private cTextarea valueAlamatHistoryBahan = new cTextarea(750, 360, 300, 150, false);
  private cTextField txtCariHistoryBahan = new cTextField(40, 85, 300);
  private cTable tblHistoryBahan;
  private cScrollPane spHistoryBahan;

  // component of data History transaksi
  private cPanelRounded panelHeaderHistoryTransaksi = new cPanelRounded(0, 0, 1100, 75, 15);
  private cTextField txtCariHistoryTransaksi = new cTextField(40, 85, 300);
  private cButton btnDetailHistoryTransaksi = new cButton("Detail", 400, 95, 150, 30, 20);
  private cTable tblDataHistoryTransaksi;
  private cScrollPane spDataHistoryTransaksi;

  // component of data laporan
  private cLabelInfo labelDataLaporan = new cLabelInfo("Pilih Data", 40, 20, 300, 40);
  private cComboBox pilihDataLaporan = new cComboBox(
      new String[] { "Data Customer", "Data Karyawan", "Data Promo", "Data Meja" }, 150, 23, 200,
      30);

  // Component Data Report Customer
  private cButton btnCetakReportCustomer = new cButton("Cetak", 400, 95, 150, 30, 20);

  // Component Data Report Karyawan
  private cButton btnCetakReportKaryawan = new cButton("Cetak", 400, 95, 150, 30, 20);

  // Component Data Report Promo
  private cLabelInfo labelCariReportPromo = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariReportPromo = new cTextField(100, 100, 300);
  private cButton btnCetakReportPromo = new cButton("Cetak", 450, 100, 150, 30, 20);

  // Component Data Report Meja
  private cLabelInfo labelCariReportMeja = new cLabelInfo("Cari", 40, 95, 300, 40);
  private cTextField txtCariReportMeja = new cTextField(100, 100, 300);
  private cButton btnCetakReportMeja = new cButton("Cetak", 450, 100, 150, 30, 20);

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

      menuHistory.setForeground(cColor.WHITE);
      menuHistory.setBackground(cColor.GREEN);
      menuHistory.setSidebarNonAktif();

      menuReport.setForeground(cColor.WHITE);
      menuReport.setBackground(cColor.GREEN);
      menuReport.setSidebarNonAktif();

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
    menuHistory.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsHistory();
      }
    });
    menuReport.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsDataReport();
      }
    });

    menuAkun.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsAkun();
      }
    });

    if (Model.getDetailMitra(idMitra)[3].toString().equalsIgnoreCase("terverifikasi"))

    {
      sidebar.add(menuBeranda);
      sidebar.add(menuDataMenu);
      sidebar.add(menuDataPromo);
      sidebar.add(menuDataMeja);
      sidebar.add(menuDataCustomer);
      sidebar.add(menuDataKaryawan);
      sidebar.add(menuTransaksi);
      sidebar.add(menuOrderBahan);
      sidebar.add(menuHistory);
      sidebar.add(menuReport);
      sidebar.add(menuAkun);
    } else {
      sidebar.add(menuBeranda);

      menuReport.setLocation(menuReport.getLocation().x, menuBeranda.getLocation().y + 50);
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
      valueJumlahMenuBeranda.setText(String.valueOf(Model.getCountAllDataMenu()));
      valueCustomerBeranda.setText(String.valueOf(Model.getCountAllDataCustomer()));
      valueJumlahMejaBeranda.setText(String.valueOf(Model.getCountAllDataMeja()));
      valueKaryawanBeranda.setText(String.valueOf(Model.getCountAllDataKaryawan()));
      valueOrderBahanBeranda.setText(String.valueOf(Model.getCountAllDataOrderBahan()));
      valueJumlahPromoBeranda.setText(String.valueOf(Model.getCountAllDataPromo()));

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
          String idString = tblMenuMakanan.getValueAt(selectedIndex, 0).toString();
          int idMenu = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin mengubah data Menu!",
              "Konfirmasi ubah Data Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
              options[0]);

          if (konfirmasi == 0) {
            initsUbahDataMakanan(idMenu);
          }
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih Menu Makanan yang akan diubah terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusDataMakanan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblMenuMakanan.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblMenuMakanan.getValueAt(selectedIndex, 0).toString();
          int idMenu = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin menghapus data Menu!",
              "Konfirmasi Hapus Data Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
              options[0]);

          if (konfirmasi == 0) {
            boolean isDeleted = Model.hapusDataMenuMakanan(idMenu);
            if (isDeleted) {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Menu berhasil dihapus!",
                  "Berhasil",
                  JOptionPane.INFORMATION_MESSAGE);
              initsDataMeja();
            } else {
              JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Menu gagal dihapus!", "Gagal",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        } else {
          // kalo gak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih data terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
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
    content.add(btnEditDataMakanan);
    content.add(btnHapusDataMakanan);
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
          String idString = tblMenuCoffe.getValueAt(selectedIndex, 0).toString();
          int idMenu = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin mengubah data Menu!",
              "Konfirmasi ubah Data Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
              options[0]);

          if (konfirmasi == 0) {
            initsUbahDataCoffe(idMenu);
          }
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih Menu yang akan diubah terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusDataCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblMenuCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblMenuCoffe.getValueAt(selectedIndex, 0).toString();
          int idMenu = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin menghapus data Menu!",
              "Konfirmasi Hapus Data Menu",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            boolean isDeleted = Model.hapusDataMenuCoffe(idMenu);
            if (isDeleted) {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Menu berhasil dihapus!",
                  "Berhasil",
                  JOptionPane.INFORMATION_MESSAGE);
              initsDataMeja();
            } else {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Menu gagal dihapus!",
                  "Gagal",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        } else {
          // kalo gak ada yang diseleksic
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih data terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
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
    content.add(btnEditDataCoffe);
    content.add(btnHapusDataCoffe);
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
          String idString = tblMenuNonCoffe.getValueAt(selectedIndex, 0).toString();
          int idMenu = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin mengubah data Menu!",
              "Konfirmasi ubah Data Menu",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            initsUbahDataNonCoffe(idMenu);
          }
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih Menu yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusDataNonCoffe.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblMenuNonCoffe.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblMenuNonCoffe.getValueAt(selectedIndex, 0).toString();
          int idMenu = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin menghapus data Menu!",
              "Konfirmasi Hapus Data Menu",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            boolean isDeleted = Model.hapusDataMenuNonCoffe(idMenu);
            if (isDeleted) {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Menu berhasil dihapus!",
                  "Berhasil",
                  JOptionPane.INFORMATION_MESSAGE);
              initsDataMeja();
            } else {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Menu gagal dihapus!",
                  "Gagal",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        } else {
          // kalo gak ada yang diseleksic
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih data terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
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
    content.add(btnEditDataNonCoffe);
    content.add(btnHapusDataNonCoffe);
    content.add(txtCariMenuNonCoffe);
    content.add(labelHargaMenuNonCoffe);
    content.add(valueHargaMenuNonCoffe);
    content.add(labelRpMenuNonCoffe);
    content.add(valueDeskripsiMenuNonCoffe);

    content.add(panelHeaderMenuNonCoffe);
    content.add(panelDeskripsiMenuNonCoffe);
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

    labelInputMenuUbahMakanan.setForeground(cColor.WHITE);

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

    content.add(panelHeaderInputMenuUbahMakanan);

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

    labelInputMenuUbahCoffe.setForeground(cColor.WHITE);

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

    content.add(panelHeaderInputMenuUbahCoffe);

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

    labelInputMenuUbahNonCoffe.setForeground(cColor.WHITE);

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

    content.add(panelHeaderInputMenuUbahNonCoffe);

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

    labelInputMenuMakanan.setForeground(cColor.WHITE);

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

    content.add(panelHeaderInputMenuMakanan);

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

    labelInputMenuCoffe.setForeground(cColor.WHITE);

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

    content.add(panelHeaderInputMenuCoffe);

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

    labelInputMenuNonCoffe.setForeground(cColor.WHITE);

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

    content.add(panelHeaderInputMenuNonCoffe);

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
          String idString = tblDataPromo.getValueAt(selectedIndex, 0).toString();
          int idPromo = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin menghapus data Menu!",
              "Konfirmasi Hapus Data Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
              options[0]);

          if (konfirmasi == 0) {
            boolean isDeleted = Model.hapusDataMenuMakanan(idPromo);
            if (isDeleted) {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Promo berhasil dihapus!",
                  "Berhasil",
                  JOptionPane.INFORMATION_MESSAGE);
              initsDataPromo();
            } else {
              JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Promo gagal dihapus!", "Gagal",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        } else {
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih data terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnEditDataPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataPromo.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblDataPromo.getValueAt(selectedIndex, 0).toString();
          int idPromo = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin mengubah data Promo!",
              "Konfirmasi ubah Data Promo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
              options[0]);

          if (konfirmasi == 0) {
            initsUbahDataPromo(idPromo);
          }
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pilih promo yang akan diubah terlebih dahulu!",
              "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
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
    content.add(btnHapusDataPromo);
    content.add(btnEditDataPromo);
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

  private void initializePilihMenuPromo() {
    ArrayList<String> menuPromo = Model.getAllMenuPromo();
    menuPromo.add(0, "Pilih Menu"); // Add the default "Pilih Menu" option at the beginning

    pilihMenuPromo = new cComboBox(menuPromo.toArray(new String[0]), 190, 302, 300, 30);

    ArrayList<String> menuUbahPromo = Model.getAllMenuPromo();
    menuUbahPromo.add(0, "Pilih Menu"); // Add the default "Pilih Menu" option at the beginning

    pilihMenuUbahPromo = new cComboBox(menuUbahPromo.toArray(new String[0]), 190, 302, 300, 30);
  }

  private void initsUbahDataPromo(int idPromo) {
    idSelected = null;
    resetSidebar();
    menuDataPromo.setBackground(cColor.WHITE);
    menuDataPromo.setForeground(cColor.GREEN);
    refreshContent();
    menuDataPromo.setSidebarAktif();
    menuTitle.setText("Ubah Data Promo");

    initializePilihMenuPromo();

    Object[] detailPromo = Model.getDetailPromo(idPromo);

    txtNamaUbahPromo.setText(detailPromo[4].toString());
    pilihMenuUbahPromo.setSelectedItem(detailPromo[5].toString());
    txtJumlahUbahPromo.setText(detailPromo[6].toString());
    txtHargaUbahPromo.setText(detailPromo[7].toString());
    txtDeskripsiUbahPromo.setText(detailPromo[8].toString());

    btnSimpanUbahPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        // error textfield kosong
        if (txtNamaUbahPromo.getText().trim().isEmpty()
            || txtJumlahUbahPromo.getText().trim().isEmpty()
            || pilihMenuUbahPromo.getSelectedItem() == null
            || txtDeskripsiUbahPromo.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          if (txtNamaUbahPromo.getText().trim().isEmpty()) {
            content.add(errorNamaUbahPromo);
          } else {
            content.remove(errorNamaUbahPromo);
          }
          if (txtJumlahUbahPromo.getText().trim().isEmpty()) {
            content.add(errorJumlahUbahPromo);
          } else {
            content.remove(errorJumlahUbahPromo);
          }
          if (pilihMenuUbahPromo.getSelectedItem() == null
              || pilihMenuUbahPromo.getSelectedItem().toString().trim().equals("Pilih Promo")) {
            content.add(errorMenuUbahPromo);
          } else {
            content.remove(errorMenuUbahPromo);
          }
          if (txtDeskripsiUbahPromo.getText().trim().isEmpty()) {
            content.add(errorDeskripsiUbahPromo);
          } else {
            content.remove(errorDeskripsiUbahPromo);
          }
          if (txtHargaUbahPromo.getText().trim().isEmpty()) {
            content.add(errorHargaUbahPromo);
          } else {
            content.remove(errorHargaUbahPromo);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaPromo = txtNamaUbahPromo.getText();
          String menuPromo = (String) pilihMenuUbahPromo.getSelectedItem();
          int jumlahPromo = Integer.valueOf(txtJumlahUbahPromo.getText());
          int hargaPromo = Integer.valueOf(txtHargaUbahPromo.getText());
          String deskripsiPromo = txtDeskripsiUbahPromo.getText();

          if (Model.ubahDataPromo(idPromo, idMitra, namaPromo, menuPromo, jumlahPromo, hargaPromo, deskripsiPromo)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "UbahPromo Berhasil Disimpan.",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
          } else {
            // kalau tidak berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "UbahPromo Gagal Disimpan.", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusUbahPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaUbahPromo.setText(null);
        txtJumlahUbahPromo.setText(null);
        txtDeskripsiUbahPromo.setText(null);
        pilihMenuUbahPromo.setSelectedItem("Coffe");
        txtHargaUbahPromo.setText(null);
      }
    });

    btnKembaliUbahPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataPromo();
      }
    });

    labelInputUbahPromo.setForeground(cColor.WHITE);

    content.add(labelInputUbahPromo);
    content.add(labelNamaUbahPromo);
    content.add(txtNamaUbahPromo);
    content.add(labelJumlahUbahPromo);
    content.add(txtJumlahUbahPromo);
    content.add(labelHargaUbahPromo);
    content.add(txtHargaUbahPromo);
    content.add(labelDeskripsiUbahPromo);
    content.add(txtDeskripsiUbahPromo);
    content.add(labelPilihMenuUbahPromo);
    content.add(pilihMenuUbahPromo);
    content.add(btnSimpanUbahPromo);
    content.add(btnHapusUbahPromo);
    content.add(btnKembaliUbahPromo);

    content.add(panelHeaderUbahPromo);

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
          String namaMenu = (String) pilihMenuPromo.getSelectedItem();
          int jumlahPromo = Integer.valueOf(txtJumlahPromo.getText());
          int hargaPromo = Integer.valueOf(txtHargaPromo.getText());
          String deskripsiPromo = txtDeskripsiPromo.getText();

          if (Model.tambahPromo(idMitra, namaPromo, namaMenu, jumlahPromo, hargaPromo, deskripsiPromo)) {
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

    labelInputPromo.setForeground(cColor.WHITE);

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

    content.add(panelHeaderInputPromo);

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
          String idString = tblDataMeja.getValueAt(selectedIndex, 0).toString();
          int idMeja = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin mengubah data Promo!",
              "Konfirmasi ubah Data Promo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
              options[0]);

          if (konfirmasi == 0) {
            initsUbahDataMeja(idMeja);
          }
        } else {
          // Jika tidak ada yang dipilih
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data Meja yang akan diubah terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
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
    content.add(btnHapusDataMeja);
    content.add(btnEditDataMeja);
    content.add(labelJenisDataMeja);
    content.add(valueJenisDataMeja);
    content.add(valueDeskripsiMeja);

    content.add(panelHeaderMeja);
    content.add(panelDeskripsiMeja);

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

    labelInputUbahMeja.setForeground(cColor.WHITE);

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

    content.add(panelHeaderUbahMeja);

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

    labelInputMeja.setForeground(cColor.WHITE);

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

    content.add(panelHeaderInputMeja);

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

    txtCariCustomer.setText(null);

    txtCariCustomer.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariCustomer.getText();

        tblDataCustomer.setModel(Model.getCariDataCustomer(keyword));

        tblDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataCustomer.getColumnModel().getColumn(0).setWidth(0);

        tblDataCustomer.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataCustomer.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataCustomer.getColumnModel().getColumn(5).setWidth(0);
      }
    });

    tblDataCustomer = new cTable(Model.getAllCustomer());

    tblDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataCustomer.getColumnModel().getColumn(0).setWidth(0);

    tblDataCustomer.getColumnModel().getColumn(5).setMinWidth(0);
    tblDataCustomer.getColumnModel().getColumn(5).setMaxWidth(0);
    tblDataCustomer.getColumnModel().getColumn(5).setWidth(0);

    spDataCustomer = new cScrollPane(tblDataCustomer, 0, 150, 1100, 300);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    txtCariCustomer.setBorder(titledBorder);
    txtCariCustomer.setSize(300, 45);

    labelCustomer.setForeground(cColor.WHITE);

    content.add(spDataCustomer);
    content.add(labelCustomer);
    content.add(txtCariCustomer);
    content.add(panelHeaderCustomer);
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

    content.add(pilihDataKaryawan);

    pilihDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedItem = (String) pilihDataKaryawan.getSelectedItem();
        if (selectedItem.equals("Karyawan Verified")) {
          initsKaryawanVerified();
        } else if (selectedItem.equals("Karyawan Terverifikasi")) {
          initsKaryawanTerverifikasi();
        }
      }
    });

    initsKaryawanVerified();

    setVisible(true);
  }

  private void initsKaryawanVerified() {
    idSelected = null;
    resetSidebar();
    menuDataKaryawan.setBackground(cColor.WHITE);
    menuDataKaryawan.setForeground(cColor.GREEN);
    refreshContent();
    menuDataKaryawan.setSidebarAktif();
    menuTitle.setText("Data Karyawan");

    content.add(pilihDataKaryawan);

    txtCariKaryawan.setText(null);

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

    tblDataKaryawan.getColumnModel().getColumn(9).setMinWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(9).setMaxWidth(0);
    tblDataKaryawan.getColumnModel().getColumn(9).setWidth(0);

    txtCariKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariKaryawan.getText();

        tblDataKaryawan.setModel(Model.getCariDataKaryawanVerified(keyword));

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

        tblDataKaryawan.getColumnModel().getColumn(9).setMinWidth(0);
        tblDataKaryawan.getColumnModel().getColumn(9).setMaxWidth(0);
        tblDataKaryawan.getColumnModel().getColumn(9).setWidth(0);

      }
    });

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

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin menghapus data Karyawan!",
              "Konfirmasi Hapus Data Karyawan",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            boolean isDeleted = Model.hapusDataKaryawan(idKaryawan);
            if (isDeleted) {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Karyawan berhasil dihapus!",
                  "Berhasil",
                  JOptionPane.INFORMATION_MESSAGE);
              initsDataKaryawan();
            } else {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Karyawan gagal dihapus!",
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

    btnEditDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataKaryawan.getSelectedRow();

        if (selectedIndex != -1) {
          int idKaryawan = Integer
              .valueOf(tblDataKaryawan.getValueAt(selectedIndex, 0).toString());
          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin mengubah data Karyawan!",
              "Konfirmasi ubah Data Karyawan",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            initsUbahDataKaryawan(idKaryawan);
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

    tblDataKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblDataKaryawan.getSelectedRow();

        int idKaryawan = Integer.valueOf(tblDataKaryawan.getValueAt(selectedIndex, 0).toString());

        String deksripsiMakanan = Model.getDetailKaryawanVerified(idKaryawan)[8].toString();
        valueAlamatDataKaryawan.setText(deksripsiMakanan);
      }
    });

    spDataKaryawan = new cScrollPane(tblDataKaryawan, 0, 150, 1100, 400);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Alamat Karyawan");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    valueAlamatDataKaryawan.setBorder(titledDeskripsi);

    txtCariKaryawan.setBorder(titledBorder);
    txtCariKaryawan.setSize(300, 45);

    labelKaryawan.setForeground(cColor.WHITE);

    content.add(valueAlamatDataKaryawan);
    content.add(panelAlamatKaryawan);
    content.add(spDataKaryawan);
    content.add(labelKaryawan);
    content.add(btnTambahKaryawan);
    content.add(btnHapusDataKaryawan);
    content.add(btnEditDataKaryawan);
    content.add(txtCariKaryawan);

    content.add(panelHeaderKaryawan);

    setVisible(true);
  }

  private void initsKaryawanTerverifikasi() {
    idSelected = null;
    resetSidebar();
    menuDataKaryawan.setBackground(cColor.WHITE);
    menuDataKaryawan.setForeground(cColor.GREEN);
    refreshContent();
    menuDataKaryawan.setSidebarAktif();
    menuTitle.setText("Data Karyawan");

    content.add(pilihDataKaryawan);

    txtCariTerverifikasi.setText(null);

    tblDataTerverifikasi = new cTable(Model.getAllKaryawantTerverifikasi());

    tblDataTerverifikasi.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(0).setWidth(0);

    tblDataTerverifikasi.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(1).setWidth(0);

    tblDataTerverifikasi.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(2).setWidth(0);

    tblDataTerverifikasi.getColumnModel().getColumn(7).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(7).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(7).setWidth(0);

    tblDataTerverifikasi.getColumnModel().getColumn(9).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(9).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(9).setWidth(0);

    txtCariTerverifikasi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariTerverifikasi.getText();

        tblDataTerverifikasi.setModel(Model.getCariDataKaryawanTerverifikasi(keyword));

        tblDataTerverifikasi.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(0).setWidth(0);

        tblDataTerverifikasi.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(1).setWidth(0);

        tblDataTerverifikasi.getColumnModel().getColumn(2).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(2).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(2).setWidth(0);

        tblDataTerverifikasi.getColumnModel().getColumn(7).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(7).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(7).setWidth(0);

        tblDataTerverifikasi.getColumnModel().getColumn(9).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(9).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(9).setWidth(0);

      }
    });

    btnHapusDataTerverifikasi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataTerverifikasi.getSelectedRow();

        if (selectedIndex != -1) {
          int idTerverifikasi = Integer.valueOf(tblDataTerverifikasi.getValueAt(selectedIndex, 0).toString());

          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin menghapus data Terverifikasi!",
              "Konfirmasi Hapus Data Terverifikasi",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            boolean isDeleted = Model.hapusDataKaryawan(idTerverifikasi);
            if (isDeleted) {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Terverifikasi berhasil dihapus!",
                  "Berhasil",
                  JOptionPane.INFORMATION_MESSAGE);
              initsDataKaryawan();
            } else {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Terverifikasi gagal dihapus!",
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

    btnEditDataTerverifikasi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataTerverifikasi.getSelectedRow();

        if (selectedIndex != -1) {
          int idKaryawan = Integer
              .valueOf(tblDataTerverifikasi.getValueAt(selectedIndex, 0).toString());
          Object[] options = { "IYA", "BATAL" };
          int konfirmasi = JOptionPane.showOptionDialog(null,
              "Yakin ingin mengubah data Terverifikasi!",
              "Konfirmasi ubah Data Terverifikasi",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              options,
              options[0]);

          if (konfirmasi == 0) {
            initsUbahDataTerverifikasi(idKaryawan);
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

    tblDataTerverifikasi.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblDataTerverifikasi.getSelectedRow();

        int idKaryawan = Integer.valueOf(tblDataTerverifikasi.getValueAt(selectedIndex, 0).toString());

        String alamatKaryawan = Model.getDetailKaryawanTerverifikasi(idKaryawan)[8].toString();
        valueAlamatDataTerverifikasi.setText(alamatKaryawan);
      }
    });

    spDataTerverifikasi = new cScrollPane(tblDataTerverifikasi, 0, 150, 1100, 400);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Alamat Terverifikasi");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    valueAlamatDataTerverifikasi.setBorder(titledDeskripsi);

    txtCariTerverifikasi.setBorder(titledBorder);
    txtCariTerverifikasi.setSize(300, 45);

    labelTerverifikasi.setForeground(cColor.WHITE);

    content.add(valueAlamatDataTerverifikasi);
    content.add(panelAlamatTerverifikasi);
    content.add(spDataTerverifikasi);
    content.add(labelTerverifikasi);
    content.add(btnHapusDataTerverifikasi);
    content.add(btnEditDataTerverifikasi);
    content.add(txtCariTerverifikasi);

    content.add(panelHeaderTerverifikasi);

    setVisible(true);
  }

  private void initsUbahDataTerverifikasi(int idKaryawan) {
    idSelected = null;
    resetSidebar();
    menuDataKaryawan.setBackground(cColor.WHITE);
    menuDataKaryawan.setForeground(cColor.GREEN);
    refreshContent();
    menuDataKaryawan.setSidebarAktif();
    menuTitle.setText("Ubah Data Karyawan Terverifikasi");

    Object[] detailTerverifikasi = Model.getDetailKaryawanTerverifikasi(idKaryawan);

    txtNamaUbahTerverifikasi.setText(detailTerverifikasi[4].toString());
    txtNomorHpUbahTerverifikasi.setText(detailTerverifikasi[5].toString());
    txtEmailUbahTerverifikasi.setText(detailTerverifikasi[6].toString());
    pilihJobdeskUbahTerverifikasi.setSelectedItem(detailTerverifikasi[7].toString());
    txtAlamatUbahTerverifikasi.setText(detailTerverifikasi[8].toString());

    btnSimpanUbahTerverifikasi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        // error textfield
        if (txtNamaUbahTerverifikasi.getText().trim().isEmpty()
            || txtNomorHpUbahTerverifikasi.getText().trim().isEmpty()
            || txtEmailUbahTerverifikasi.getText().trim().isEmpty()
            || pilihJobdeskUbahTerverifikasi.getSelectedItem() == null
            || txtAlamatUbahTerverifikasi.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          // spesifik error
          if (txtNamaUbahTerverifikasi.getText().trim().isEmpty()) {
            content.add(errorNamaUbahTerverifikasi);
          } else {
            content.remove(errorNamaUbahTerverifikasi);
          }
          if (txtNomorHpUbahTerverifikasi.getText().trim().isEmpty()) {
            content.add(errorNomorHpUbahTerverifikasi);
          } else {
            content.remove(errorNomorHpUbahTerverifikasi);
          }
          if (txtEmailUbahTerverifikasi.getText().trim().isEmpty()) {
            content.add(errorEmailUbahTerverifikasi);
          } else {
            content.remove(errorEmailUbahTerverifikasi);
          }
          if (pilihJobdeskUbahTerverifikasi.getSelectedItem() == null
              || pilihJobdeskUbahTerverifikasi.getSelectedItem().toString().trim().equals("Pilih Jobdesk")) {
            content.add(errorJobdeskUbahTerverifikasi);
          } else {
            content.remove(errorJobdeskUbahTerverifikasi);
          }
          if (txtAlamatUbahTerverifikasi.getText().trim().isEmpty()) {
            content.add(errorAlamatUbahTerverifikasi);
          } else {
            content.remove(errorAlamatUbahTerverifikasi);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaUbahTerverifikasi = txtNamaUbahTerverifikasi.getText();
          String nomorHpUbahTerverifikasi = txtNomorHpUbahTerverifikasi.getText();
          String emailUbahTerverifikasi = txtEmailUbahTerverifikasi.getText();
          String jobdeskUbahTerverifikasi = (String) pilihJobdeskUbahTerverifikasi.getSelectedItem();
          String alamatUbahTerverifikasi = txtAlamatUbahTerverifikasi.getText();

          if (Model.ubahDataTerverifikasi(idKaryawan, idMitra, namaUbahTerverifikasi, nomorHpUbahTerverifikasi,
              emailUbahTerverifikasi,
              jobdeskUbahTerverifikasi,
              alamatUbahTerverifikasi)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data UbahTerverifikasi Berhasil Disimpan",
                "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
            txtNamaUbahTerverifikasi.setText(null);
            txtNomorHpUbahTerverifikasi.setText(null);
            txtEmailUbahTerverifikasi.setText(null);
            txtAlamatUbahTerverifikasi.setText(null);
            pilihJobdeskUbahTerverifikasi.setSelectedItem("Operator Mesin");
            initsDataKaryawan();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Gagal Input data UbahTerverifikasi.", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusUbahTerverifikasi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaUbahTerverifikasi.setText(null);
        txtNomorHpUbahTerverifikasi.setText(null);
        txtEmailUbahTerverifikasi.setText(null);
        txtAlamatUbahTerverifikasi.setText(null);
        pilihJobdeskUbahTerverifikasi.setSelectedItem("Operator Mesin");
      }
    });

    btnKembaliUbahTerverifikasi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsKaryawanTerverifikasi();
      }
    });

    labelDataUbahTerverifikasi.setForeground(cColor.WHITE);

    content.add(labelDataUbahTerverifikasi);
    content.add(labelNamaUbahTerverifikasi);
    content.add(txtNamaUbahTerverifikasi);
    content.add(labelNomorHpUbahTerverifikasi);
    content.add(txtNomorHpUbahTerverifikasi);
    content.add(labelEmailUbahTerverifikasi);
    content.add(txtEmailUbahTerverifikasi);
    content.add(labelAlamatUbahTerverifikasi);
    content.add(txtAlamatUbahTerverifikasi);
    content.add(labelJobdeskUbahTerverifikasi);
    content.add(pilihJobdeskUbahTerverifikasi);
    content.add(btnSimpanUbahTerverifikasi);
    content.add(btnHapusUbahTerverifikasi);
    content.add(btnKembaliUbahTerverifikasi);

    content.add(panelHeaderInputTerverifikasi);

    setVisible(true);
  }

  private void initsUbahDataKaryawan(int idKaryawan) {
    idSelected = null;
    resetSidebar();
    menuDataKaryawan.setBackground(cColor.WHITE);
    menuDataKaryawan.setForeground(cColor.GREEN);
    refreshContent();
    menuDataKaryawan.setSidebarAktif();
    menuTitle.setText("Data Karyawan");

    Object[] detailKaryawan = Model.getDetailKaryawanVerified(idKaryawan);

    txtNamaUbahKaryawan.setText(detailKaryawan[4].toString());
    txtNomorHpUbahKaryawan.setText(detailKaryawan[5].toString());
    txtEmailUbahKaryawan.setText(detailKaryawan[6].toString());
    pilihJobdeskKaryawan.setSelectedItem(detailKaryawan[7].toString());
    txtAlamatUbahKaryawan.setText(detailKaryawan[8].toString());

    btnSimpanUbahKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        // error textfield
        if (txtNamaUbahKaryawan.getText().trim().isEmpty()
            || txtNomorHpUbahKaryawan.getText().trim().isEmpty()
            || txtEmailUbahKaryawan.getText().trim().isEmpty()
            || pilihJobdeskUbahKaryawan.getSelectedItem() == null
            || txtAlamatUbahKaryawan.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);

          // spesifik error
          if (txtNamaUbahKaryawan.getText().trim().isEmpty()) {
            content.add(errorNamaUbahKaryawan);
          } else {
            content.remove(errorNamaUbahKaryawan);
          }
          if (txtNomorHpUbahKaryawan.getText().trim().isEmpty()) {
            content.add(errorNomorHpUbahKaryawan);
          } else {
            content.remove(errorNomorHpUbahKaryawan);
          }
          if (txtEmailUbahKaryawan.getText().trim().isEmpty()) {
            content.add(errorEmailUbahKaryawan);
          } else {
            content.remove(errorEmailUbahKaryawan);
          }
          if (pilihJobdeskUbahKaryawan.getSelectedItem() == null
              || pilihJobdeskUbahKaryawan.getSelectedItem().toString().trim().equals("Pilih Jobdesk")) {
            content.add(errorJobdeskUbahKaryawan);
          } else {
            content.remove(errorJobdeskUbahKaryawan);
          }
          if (txtAlamatUbahKaryawan.getText().trim().isEmpty()) {
            content.add(errorAlamatUbahKaryawan);
          } else {
            content.remove(errorAlamatUbahKaryawan);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaUbahKaryawan = txtNamaUbahKaryawan.getText();
          String nomorHpUbahKaryawan = txtNomorHpUbahKaryawan.getText();
          String emailUbahKaryawan = txtEmailUbahKaryawan.getText();
          String jobdeskUbahKaryawan = (String) pilihJobdeskUbahKaryawan.getSelectedItem();
          String alamatUbahKaryawan = txtAlamatUbahKaryawan.getText();

          if (Model.ubahDataKaryawan(idKaryawan, idMitra, namaUbahKaryawan, nomorHpUbahKaryawan, emailUbahKaryawan,
              jobdeskUbahKaryawan,
              alamatUbahKaryawan)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data UbahKaryawan Berhasil Disimpan",
                "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
            txtNamaUbahKaryawan.setText(null);
            txtNomorHpUbahKaryawan.setText(null);
            txtEmailUbahKaryawan.setText(null);
            txtAlamatUbahKaryawan.setText(null);
            pilihJobdeskUbahKaryawan.setSelectedItem("Operator Mesin");
            initsDataKaryawan();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Gagal Input data UbahKaryawan.", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusUbahKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtNamaUbahKaryawan.setText(null);
        txtNomorHpUbahKaryawan.setText(null);
        txtEmailUbahKaryawan.setText(null);
        txtAlamatUbahKaryawan.setText(null);
        pilihJobdeskUbahKaryawan.setSelectedItem("Operator Mesin");
      }
    });

    btnKembaliUbahKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsDataKaryawan();
      }
    });

    labelDataUbahKaryawan.setForeground(cColor.WHITE);

    content.add(labelDataUbahKaryawan);
    content.add(labelNamaUbahKaryawan);
    content.add(txtNamaUbahKaryawan);
    content.add(labelNomorHpUbahKaryawan);
    content.add(txtNomorHpUbahKaryawan);
    content.add(labelEmailUbahKaryawan);
    content.add(txtEmailUbahKaryawan);
    content.add(labelAlamatUbahKaryawan);
    content.add(txtAlamatUbahKaryawan);
    content.add(labelJobdeskUbahKaryawan);
    content.add(pilihJobdeskUbahKaryawan);
    content.add(btnSimpanUbahKaryawan);
    content.add(btnHapusUbahKaryawan);
    content.add(btnKembaliUbahKaryawan);

    content.add(panelHeaderUbahKaryawan);

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

    labelDataKaryawan.setForeground(cColor.WHITE);

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

    content.add(panelHeaderInputKaryawan);

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

    content.add(pilihTransaksi);

    pilihTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedItem = (String) pilihTransaksi.getSelectedItem();
        if (selectedItem.equals("Data Transaksi")) {
          initsDataTransaksi();
        } else if (selectedItem.equals("Proses Transaksi")) {
          initsProsesTransaksi();
        }
      }
    });

    initsDataTransaksi();

    setVisible(true);
  }

  private void initializeTransaksi() {
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

    content.add(pilihTransaksi);

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
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
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
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Transaksi berhasil dihapus!",
                  "Berhasil",
                  JOptionPane.INFORMATION_MESSAGE);
              initsDataMeja();
            } else {
              JOptionPane.showMessageDialog(cDashboardMitraView.this,
                  "Data Transaksi gagal dihapus!",
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

    btnDetailTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataTransaksi.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblDataTransaksi.getValueAt(selectedIndex, 0).toString();
          int idTransaksi = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          String transaksiId = Model.getDetailTransaksiDiproses(idTransaksi)[0].toString();
          String mitraId = Model.getDetailTransaksiDiproses(idTransaksi)[1].toString();
          String namaMitra = Model.getDetailTransaksiDiproses(idTransaksi)[2].toString();
          String waktuTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[3].toString();
          String namaTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[4].toString();
          String makananTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[5].toString();
          String coffeTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[6].toString();
          String nonCoffeTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[7].toString();
          String jumlahMakanan = Model.getDetailTransaksiDiproses(idTransaksi)[8].toString();
          String jumlahCoffe = Model.getDetailTransaksiDiproses(idTransaksi)[9].toString();
          String jumlahNonCoffe = Model.getDetailTransaksiDiproses(idTransaksi)[10].toString();
          String hargaMakanan = Model.getDetailTransaksiDiproses(idTransaksi)[11].toString();
          String hargaCoffe = Model.getDetailTransaksiDiproses(idTransaksi)[12].toString();
          String hargaNonCoffe = Model.getDetailTransaksiDiproses(idTransaksi)[13].toString();
          String promoTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[14].toString();
          String mejaTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[15].toString();
          String deskripsiTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[16].toString();
          String hargaTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[17].toString();
          String hargaPromo = Model.getDetailTransaksiDiproses(idTransaksi)[18].toString();
          String bayarTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[19].toString();
          String uangTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[20].toString();
          String kembalianTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[21].toString();
          String statusTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[22].toString();

          String detailTransaksi = "\tForque" + "\n\n"
              + "Jl. Jagal No.3A RT 007/004, Jl. Jagal, Rangkapan Jaya,\n"
              + "Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435\n"
              + "====================================================\n"
              + String.format("%-40s:  %s", "Tanggal/Waktu", waktuTransaksi) + "\n"
              + String.format("%-40s:  TR%s", "ID Transaksi", transaksiId) + "\n"
              + String.format("%-44s:  MI%s", "ID Mitra", mitraId) + "\n"
              + String.format("%-39s: %s", "Nama Mitra", namaMitra) + "\n"
              + "====================================================\n"
              + String.format("%-44s: %s", "Status Transaksi", statusTransaksi) + "\n"
              + String.format("%-44s: %s", "Nomor Meja", mejaTransaksi) + "\n"
              + String.format("%-39s: %s", "Nama Pemesan", namaTransaksi) + "\n"
              + String.format("%-44s: %s", "Pembayaran", bayarTransaksi) + "\n"
              + String.format("%-49s: %s", "Promo", promoTransaksi) + "\n"
              + String.format("%-38s: %s", "Deskripsi Pesanan", deskripsiTransaksi) + "\n"
              + "====================================================\n"
              + String.format("%-60s %-30s %-10s", makananTransaksi, jumlahMakanan, hargaMakanan) + "\n"
              + String.format("%-60s %-30s %-10s", coffeTransaksi, jumlahCoffe, hargaCoffe) + "\n"
              + String.format("%-60s %-30s %-10s", nonCoffeTransaksi, jumlahNonCoffe, hargaNonCoffe) + "\n"
              + "====================================================\n"
              + String.format("%-80s Harga Total   : %s", "", hargaTransaksi) + "\n"
              + String.format("%-80s Harga Promo   : %s", "", hargaPromo) + "\n"
              + String.format("%-80s uang          : %s", "", uangTransaksi) + "\n"
              + String.format("%-80s Kembalian     : %s", "", kembalianTransaksi) + "\n"
              + "====================================================\n"
              + "---------------TERIMAKASIH BY ARCOO NGAWI---------------\n"
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
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblDataTransaksi = new cTable(Model.getAllTransaksiDiproses());

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

    pilihTransaksi.setBackground(cColor.WHITE);
    pilihTransaksi.setForeground(cColor.GREEN);
    pilihTransaksi.setBorder(new javax.swing.border.LineBorder(cColor.WHITE, 1));

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

    Object[] detailTransaksi = Model.getDetailTransaksiDiproses(idTransaksi);

    pilihMakananUbahTransaksi.setSelectedItem(detailTransaksi[5].toString());
    pilihCoffeUbahTransaksi.setSelectedItem(detailTransaksi[6].toString());
    pilihNonCoffeUbahTransaksi.setSelectedItem(detailTransaksi[7].toString());
    pilihMejaUbahTransaksi.setSelectedItem(detailTransaksi[15].toString());
    pilihPromoUbahTransaksi.setSelectedItem(detailTransaksi[14].toString());
    txtNamaUbahTransaksi.setText(detailTransaksi[4].toString());
    txtDeskripsiUbahTransaksi.setText(detailTransaksi[16].toString());
    txtJumlahMakananUbahTransaksi.setText(detailTransaksi[8].toString());
    txtJumlahCoffeUbahTransaksi.setText(detailTransaksi[9].toString());
    txtJumlahNonCoffeUbahTransaksi.setText(detailTransaksi[10].toString());
    txtHargaMakananUbahTransaksi.setText(detailTransaksi[11].toString());
    txtHargaCoffeUbahTransaksi.setText(detailTransaksi[12].toString());
    txtHargaNonCoffeUbahTransaksi.setText(detailTransaksi[13].toString());
    txtHargaTotalUbahTransaksi.setText(detailTransaksi[17].toString());

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
        updateUbahTotalHarga();
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
        updateUbahTotalHarga();
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
        updateUbahTotalHarga();
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
        pilihMejaUbahTransaksi.setSelectedItem("-");
        txtNamaUbahTransaksi.setText(null);
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
        if (txtNamaUbahTransaksi.getText().trim().isEmpty()
            || pilihMejaUbahTransaksi.getSelectedItem() == null
            || txtDeskripsiUbahTransaksi.getText().trim().isEmpty()
            || pilihPembayaranUbahTransaksi.getSelectedItem() == null) {
          cDashboardMitraView.this.setVisible(false);
          if (txtNamaUbahTransaksi.getText().trim().isEmpty()) {
            content.add(errorNamaUbahTransaksi);
          } else {
            content.remove(errorNamaUbahTransaksi);
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
          cDashboardMitraView.this.setVisible(true);
        } else {
          Object[] messagePembayaran = { "Pilih Pembayaran", pilihPembayaranUbahTransaksi };
          JOptionPane.showMessageDialog(null, messagePembayaran, "PEMBAYRAN",
              JOptionPane.PLAIN_MESSAGE);

          // Pertama, minta pengguna untuk memasukkan uang
          String checkoutUbahTransaksi = JOptionPane.showInputDialog(null, "Masukan Uang!", "Input",
              JOptionPane.PLAIN_MESSAGE);

          if (checkoutUbahTransaksi != null && !checkoutUbahTransaksi.trim().isEmpty()) {
            try {
              String mejaUbahTransaksi = (String) pilihMejaUbahTransaksi.getSelectedItem();
              String namaUbahTransaksi = txtNamaUbahTransaksi.getText();
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
                  + String.format("%-39s: %s", "Nama Pemesan", txtNamaUbahTransaksi.getText()) + "\n"
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
                if (Model.ubahDataTransaksi(idTransaksi, idMitra, namaUbahTransaksi, makananUbahTransaksi,
                    coffeUbahTransaksi, nonCoffeUbahTransaksi, jumlahMakanan, jumlahCoffe, jumlahNonCoffe, hargaMakanan,
                    hargaCoffe, hargaNonCoffe, promoUbahTransaksi,
                    mejaUbahTransaksi, deskripsiUbahTransaksi, hargaUbahTransaksi, bayarUbahTransaksi)) {
                  // kalau berhasil
                  JOptionPane.showMessageDialog(cDashboardMitraView.this, "Ubah Transaksi berhasil",
                      "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                  pilihMejaUbahTransaksi.setSelectedItem("-");
                  txtNamaUbahTransaksi.setText(null);
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
                  JOptionPane.showMessageDialog(cDashboardMitraView.this, "UbahTransaksi Gagal!", "Gagal",
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
    content.add(pilihMakananUbahTransaksi);
    content.add(pilihCoffeUbahTransaksi);
    content.add(pilihNonCoffeUbahTransaksi);
    content.add(labelMejaUbahTransaksi);
    content.add(pilihMejaUbahTransaksi);
    content.add(labelNamaUbahTransaksi);
    content.add(txtNamaUbahTransaksi);
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
    menuTitle.setText("Input Transaksi");

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
        txtNamaTransaksi.setText(null);
        txtDeskripsiTransaksi.setText(null);
        pilihMakananTransaksi.setSelectedItem("-");
        pilihCoffeTransaksi.setSelectedItem("-");
        pilihNonCoffeTransaksi.setSelectedItem("-");
        pilihPromoTransaksi.setSelectedItem("-");
        txtJumlahMakanan.setText(null);
        txtJumlahCoffe.setText(null);
        txtJumlahNonCoffe.setText(null);
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
        if (txtNamaTransaksi.getText().trim().isEmpty()
            || pilihMejaTransaksi.getSelectedItem() == null
            || txtDeskripsiTransaksi.getText().trim().isEmpty()
            || pilihPembayaranTransaksi.getSelectedItem() == null) {
          cDashboardMitraView.this.setVisible(false);
          if (txtNamaTransaksi.getText().trim().isEmpty()) {
            content.add(errorNamaTransaksi);
          } else {
            content.remove(errorNamaTransaksi);
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
          cDashboardMitraView.this.setVisible(true);
        } else {
          Object[] messagePembayaran = { "Pilih Pembayaran", pilihPembayaranTransaksi };
          JOptionPane.showMessageDialog(null, messagePembayaran, "PEMBAYRAN",
              JOptionPane.PLAIN_MESSAGE);

          // Pertama, minta pengguna untuk memasukkan uang
          String checkoutTransaksi = JOptionPane.showInputDialog(null, "Masukan Uang!", "Input",
              JOptionPane.PLAIN_MESSAGE);

          if (checkoutTransaksi != null && !checkoutTransaksi.trim().isEmpty()) {
            try {
              String mejaTransaksi = (String) pilihMejaTransaksi.getSelectedItem();
              String namaTransaksi = txtNamaTransaksi.getText();
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
                hargaPromo = 0;
              }

              String pembayaranTransaksi = "Forque\n\n"
                  + "======================================================\n"
                  + "Jl. Jagal No.3A RT 007/004, Jl. Jagal, Rangkapan Jaya,\n"
                  + "Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435\n"
                  + "======================================================\n"
                  + String.format("%-44s: %s", "Nomor Meja", pilihMejaTransaksi.getSelectedItem()) + "\n"
                  + String.format("%-39s: %s", "Nama Pemesan", txtNamaTransaksi.getText()) + "\n"
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
                if (Model.tambahTransaksi(idMitra, namaTransaksi, makananTransaksi, coffeTransaksi, nonCoffeTransaksi,
                    jumlahMakanan, jumlahCoffe, jumlahNonCoffe, hargaMakanan, hargaCoffe, hargaNonCoffe, promoTransaksi,
                    mejaTransaksi, deskripsiTransaksi, hargaTransaksi, hargaPromo, bayarTransaksi, uangTransaksi,
                    kembalianTransaksi)) {
                  // kalau berhasil
                  JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi berhasil",
                      "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                  pilihMejaTransaksi.setSelectedItem("-");
                  txtNamaTransaksi.setText(null);
                  txtDeskripsiTransaksi.setText(null);
                  pilihMakananTransaksi.setSelectedItem("-");
                  pilihCoffeTransaksi.setSelectedItem("-");
                  pilihNonCoffeTransaksi.setSelectedItem("-");
                  pilihPromoTransaksi.setSelectedItem("-");
                  txtJumlahMakanan.setText(null);
                  txtJumlahCoffe.setText(null);
                  txtJumlahNonCoffe.setText(null);
                  txtHargaMakananTransaksi.setText(null);
                  txtHargaCoffeTransaksi.setText(null);
                  txtHargaNonCoffeTransaksi.setText(null);
                  JOptionPane.showMessageDialog(null, "Pembayaran berhasil!", "Pembayaran",
                      JOptionPane.INFORMATION_MESSAGE);
                } else {
                  // kalau tidak berhasil
                  JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Gagal!", "Gagal",
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
    content.add(pilihMakananTransaksi);
    content.add(pilihCoffeTransaksi);
    content.add(pilihNonCoffeTransaksi);
    content.add(labelMejaTransaksi);
    content.add(pilihMejaTransaksi);
    content.add(labelNamaTransaksi);
    content.add(txtNamaTransaksi);
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

  private void initsProsesTransaksi() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Proses Transaksi");

    content.add(pilihTransaksi);
    content.add(rdOfflineProsesTransaksi);
    content.add(rdOnlineProsesTransaksi);
    ButtonGroup groupButtonRadio = new ButtonGroup();
    groupButtonRadio.add(rdOfflineProsesTransaksi);
    groupButtonRadio.add(rdOnlineProsesTransaksi);

    rdOfflineProsesTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsProsesOrderOffline();
      }
    });

    rdOnlineProsesTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsProsesOrderOnline();
      }
    });

    // Pilih radio button offline secara default
    groupButtonRadio.setSelected(rdOfflineProsesTransaksi.getModel(), true);
    initsProsesOrderOffline();

    setVisible(true);
  }

  private void initsProsesOrderOffline() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Proses Order Offline");

    content.add(pilihTransaksi);
    content.add(rdOfflineProsesTransaksi);
    content.add(rdOnlineProsesTransaksi);

    ButtonGroup groupButtonRadio = new ButtonGroup();
    groupButtonRadio.add(rdOfflineProsesTransaksi);
    groupButtonRadio.add(rdOnlineProsesTransaksi);

    btnDetailProsesOrderOffline.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataProsesOrderOffline.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblDataProsesOrderOffline.getValueAt(selectedIndex, 0).toString();
          int idTransaksi = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          String transaksiId = Model.getDetailTransaksiDiproses(idTransaksi)[0].toString();
          String mitraId = Model.getDetailTransaksiDiproses(idTransaksi)[1].toString();
          String namaMitra = Model.getDetailTransaksiDiproses(idTransaksi)[2].toString();
          String waktuTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[3].toString();
          String namaTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[4].toString();
          String makananTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[5].toString();
          String coffeTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[6].toString();
          String nonCoffeTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[7].toString();
          String jumlahMakanan = Model.getDetailTransaksiDiproses(idTransaksi)[8].toString();
          String jumlahCoffe = Model.getDetailTransaksiDiproses(idTransaksi)[9].toString();
          String jumlahNonCoffe = Model.getDetailTransaksiDiproses(idTransaksi)[10].toString();
          String hargaMakanan = Model.getDetailTransaksiDiproses(idTransaksi)[11].toString();
          String hargaCoffe = Model.getDetailTransaksiDiproses(idTransaksi)[12].toString();
          String hargaNonCoffe = Model.getDetailTransaksiDiproses(idTransaksi)[13].toString();
          String promoTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[14].toString();
          String mejaTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[15].toString();
          String deskripsiTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[16].toString();
          String hargaTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[17].toString();
          String bayarTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[18].toString();
          String statusTransaksi = Model.getDetailTransaksiDiproses(idTransaksi)[19].toString();

          String detailTransaksi = "\tForque" + "\n\n"
              + "Jl. Jagal No.3A RT 007/004, Jl. Jagal, Rangkapan Jaya,\n"
              + "Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435\n"
              + "====================================================\n"
              + String.format("%-40s:  %s", "Tanggal/Waktu", waktuTransaksi) + "\n"
              + String.format("%-40s:  TR%s", "ID Transaksi", transaksiId) + "\n"
              + String.format("%-44s:  MI%s", "ID Mitra", mitraId) + "\n"
              + String.format("%-39s: %s", "Nama Mitra", namaMitra) + "\n"
              + "====================================================\n"
              + String.format("%-44s: %s", "Status Transaksi", statusTransaksi) + "\n"
              + String.format("%-44s: %s", "Nomor Meja", mejaTransaksi) + "\n"
              + String.format("%-39s: %s", "Nama Pemesan", namaTransaksi) + "\n"
              + String.format("%-44s: %s", "Pembayaran", bayarTransaksi) + "\n"
              + String.format("%-49s: %s", "Promo", promoTransaksi) + "\n"
              + String.format("%-38s: %s", "Deskripsi Pesanan", deskripsiTransaksi) + "\n"
              + "====================================================\n"
              + String.format("%-60s %-30s %-10s", makananTransaksi, jumlahMakanan, hargaMakanan) + "\n"
              + String.format("%-60s %-30s %-10s", coffeTransaksi, jumlahCoffe, hargaCoffe) + "\n"
              + String.format("%-60s %-30s %-10s", nonCoffeTransaksi, jumlahNonCoffe, hargaNonCoffe) + "\n"
              + "====================================================\n"
              + String.format("%-80s Harga Total   : %s", "", hargaTransaksi) + "\n"
              + "====================================================\n"
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
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnProsesOrderOffline.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataProsesOrderOffline.getSelectedRow();

        if (selectedIndex != -1) {
          // kalo ada yang dipilih
          String idString = tblDataProsesOrderOffline.getValueAt(selectedIndex, 0).toString();
          int idTransaksi = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          if (Model.mitraProsesTransaksi(idTransaksi)) {
            // kalo berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Proses Transaksi berhasil.", "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
            initsProsesOrderOffline();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Proses Transaksi gagal!", "Gagal",
                JOptionPane.ERROR_MESSAGE);
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

    rdOnlineProsesTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me) {
        initsProsesOrderOnline();
      }
    });

    tblDataProsesOrderOffline = new cTable(Model.getAllTransaksiDiproses());

    tblDataProsesOrderOffline.getColumnModel().getColumn(0).setMinWidth(80);
    tblDataProsesOrderOffline.getColumnModel().getColumn(0).setMaxWidth(80);
    tblDataProsesOrderOffline.getColumnModel().getColumn(0).setWidth(80);

    tblDataProsesOrderOffline.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(1).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(2).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(5).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(5).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(5).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(6).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(6).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(6).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(7).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(7).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(7).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(8).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(8).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(8).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(9).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(9).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(9).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(10).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(10).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(10).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(11).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(11).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(11).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(12).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(12).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(12).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(13).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(13).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(13).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(14).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(14).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(14).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(15).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(15).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(15).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(16).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(16).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(16).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(17).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(17).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(17).setWidth(0);

    tblDataProsesOrderOffline.getColumnModel().getColumn(18).setMinWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(18).setMaxWidth(0);
    tblDataProsesOrderOffline.getColumnModel().getColumn(18).setWidth(0);

    spDataProsesOrderOffline = new cScrollPane(tblDataProsesOrderOffline, 0, 150, 1100, 400);
    content.add(spDataProsesOrderOffline);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    txtCariProsesOrderOffline.setBorder(titledBorder);
    txtCariProsesOrderOffline.setSize(300, 45);

    content.add(labelPilihProsesOrderOffline);
    content.add(txtCariProsesOrderOffline);
    content.add(btnProsesOrderOffline);
    content.add(btnDetailProsesOrderOffline);

    content.add(panelHeaderProsesOrderOffline);

    setVisible(true);
  }

  private void initsProsesOrderOnline() {
    idSelected = null;
    resetSidebar();
    menuTransaksi.setBackground(cColor.WHITE);
    menuTransaksi.setForeground(cColor.GREEN);
    refreshContent();
    menuTransaksi.setSidebarAktif();
    menuTitle.setText("Proses Order Online");

    content.add(pilihTransaksi);

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

    tblOrderBahan.getColumnModel().getColumn(3).setMinWidth(200);
    tblOrderBahan.getColumnModel().getColumn(3).setMaxWidth(200);
    tblOrderBahan.getColumnModel().getColumn(3).setWidth(200);

    tblOrderBahan.getColumnModel().getColumn(6).setMinWidth(0);
    tblOrderBahan.getColumnModel().getColumn(6).setMaxWidth(0);
    tblOrderBahan.getColumnModel().getColumn(6).setWidth(0);

    tblOrderBahan.getColumnModel().getColumn(7).setMinWidth(0);
    tblOrderBahan.getColumnModel().getColumn(7).setMaxWidth(0);
    tblOrderBahan.getColumnModel().getColumn(7).setWidth(0);

    btnTambahOrderBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsInputDataOrderBahan();
      }
    });

    btnEditDataOrderBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblOrderBahan.getSelectedRow();

        if (selectedIndex != -1) {
          int idOrder = Integer.valueOf(tblOrderBahan.getValueAt(selectedIndex, 0).toString());
          initsUbahDataOrderBahan(idOrder);
        } else {
          // kalo tidak ada yang diseleksi
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data Transaksi yang akan diubah terlebih dahulu!", "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    btnHapusDataOrderBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblOrderBahan.getSelectedRow();

        if (selectedIndex != -1) {
          int idOrder = Integer
              .valueOf(tblOrderBahan.getValueAt(selectedIndex, 0).toString());

          if (Model.hapusDataOrderBahan(idOrder)) {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Data Meja berhasil dihapus!",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            initsOrderBahan();
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

    tblOrderBahan.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblOrderBahan.getSelectedRow();
        String idString = tblOrderBahan.getValueAt(selectedIndex, 0).toString();
        int idOrder = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

        String deksripsiOrderBahan = Model.getDetailOrderBahanDiproses(idOrder)[6].toString();
        valueDeskripsiOrderBahan.setText(deksripsiOrderBahan);

        String alamatOrderBahan = Model.getDetailOrderBahanDiproses(idOrder)[7].toString();
        valueAlamatOrderBahan.setText(alamatOrderBahan);
      }
    });

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Deskripsi ");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledAlamat = new TitledBorder(new LineBorder(cColor.BLACK), "Alamat");
    titledAlamat.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledCari = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledCari.setTitleFont(cFonts.CARI_FONT);

    txtCariOrderBahan.setBorder(titledCari);
    txtCariOrderBahan.setSize(300, 45);

    valueDeskripsiOrderBahan.setBorder(titledDeskripsi);
    valueAlamatOrderBahan.setBorder(titledAlamat);

    spOrderBahan = new cScrollPane(tblOrderBahan, 0, 150, 700, 400);

    labelOrderBahan.setForeground(cColor.WHITE);

    content.add(spOrderBahan);

    content.add(btnTambahOrderBahan);
    content.add(btnHapusDataOrderBahan);
    content.add(btnEditDataOrderBahan);
    content.add(labelOrderBahan);
    content.add(txtCariOrderBahan);
    content.add(valueDeskripsiOrderBahan);
    content.add(valueAlamatOrderBahan);

    content.add(panelHeaderOrderBahan);
    content.add(panelDeskripsiOrderBahan);
    setVisible(true);
  }

  private void initsUbahDataOrderBahan(int idOrder) {
    idSelected = null;
    resetSidebar();
    menuOrderBahan.setBackground(cColor.WHITE);
    menuOrderBahan.setForeground(cColor.GREEN);
    refreshContent();
    menuOrderBahan.setSidebarAktif();
    menuTitle.setText("Ubah Oder Bahan");

    Object[] detailOrder = Model.getDetailOrderBahanDiproses(idOrder);

    pilihMenuOrderUbahBahan.setSelectedItem(detailOrder[4].toString());
    pilihPTOrderUbahBahan.setSelectedItem(detailOrder[5].toString());
    txtDeskripsiOrderUbahBahan.setText(detailOrder[6].toString());
    txtAlamatOrderUbahBahan.setText(detailOrder[7].toString());
    txtJumlahOrderUbahBahan.setText(detailOrder[8].toString());
    txtHargaOrderUbahBahan.setText(detailOrder[9].toString());

    pilihMenuOrderUbahBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihMenuOrderUbahBahan.getSelectedItem().equals("Coffe")) {
          hargaBahan = 10000;
          String bahanHarga = Integer.toString(hargaBahan);
          txtHargaOrderUbahBahan.setText(bahanHarga);
        } else if (pilihMenuOrderUbahBahan.getSelectedItem().equals("Telur")) {
          hargaBahan = 1000;
          String bahanHarga = Integer.toString(hargaBahan);
          txtHargaOrderUbahBahan.setText(bahanHarga);
        } else if (pilihMenuOrderUbahBahan.getSelectedItem().equals("Beras")) {
          hargaBahan = 2000;
          String bahanHarga = Integer.toString(hargaBahan);
          txtHargaOrderUbahBahan.setText(bahanHarga);
        } else {
          hargaBahan = 5000;
          String bahanHarga = Integer.toString(hargaBahan);
          txtHargaOrderUbahBahan.setText(bahanHarga);
        }
      }
    });

    btnSimpanOrderUbahBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (txtJumlahOrderUbahBahan.getText().trim().isEmpty()
            || txtDeskripsiOrderUbahBahan.getText().trim().isEmpty()
            || pilihMenuOrderUbahBahan.getSelectedItem() == null
            || pilihPTOrderUbahBahan.getSelectedItem() == null
            || txtAlamatOrderUbahBahan.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          if (txtJumlahOrderUbahBahan.getText().trim().isEmpty()) {
            content.add(errorJumlahOrderUbahBahan);
          } else {
            content.remove(errorJumlahOrderUbahBahan);
          }
          if (txtDeskripsiOrderUbahBahan.getText().trim().isEmpty()) {
            content.add(errorDeskripsiOrderUbahBahan);
          } else {
            content.remove(errorDeskripsiOrderUbahBahan);
          }
          if (pilihMenuOrderUbahBahan.getSelectedItem() == null
              || pilihMenuOrderUbahBahan.getSelectedItem().toString().trim().equals("Pilih Bahan")) {
            content.add(errorMenuOrderUbahBahan);
          } else {
            content.remove(errorMenuOrderUbahBahan);
          }
          if (pilihPTOrderUbahBahan.getSelectedItem() == null
              || pilihPTOrderUbahBahan.getSelectedItem().toString().trim().equals("Pilih PT")) {
            content.add(errorPTOrderUbahBahan);
          } else {
            content.remove(errorPTOrderUbahBahan);
          }
          if (txtAlamatOrderUbahBahan.getText().trim().isEmpty()) {
            content.add(errorAlamatOrderUbahBahan);
          } else {
            content.remove(errorAlamatOrderUbahBahan);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          int jumlahOrder = Integer.valueOf(txtJumlahOrderUbahBahan.getText());
          String bahanOrder = (String) pilihMenuOrderUbahBahan.getSelectedItem();
          String ptOrder = (String) pilihPTOrderUbahBahan.getSelectedItem();
          String deskripsiOrder = txtDeskripsiOrderUbahBahan.getText();
          String alamatOrder = txtAlamatOrderUbahBahan.getText();
          int hargaOrder = Integer.valueOf(txtHargaOrderUbahBahan.getText());
          int hargaTotalOrder = hargaOrder * jumlahOrder;
          String hargaTotal = Integer.toString(hargaTotalOrder);
          txtHargaTotalUbahBahan.setText(hargaTotal);

          String PembayaranOrder = "Data Order Bahan" + "\n\n"
              + "Jumlah bahan" + "\t" + txtJumlahOrderUbahBahan.getText() + "\n"
              + "Jenis Bahan" + "\t" + pilihMenuOrderUbahBahan.getSelectedItem() + "\n"
              + "Nama PT" + "\t" + pilihPTOrderUbahBahan.getSelectedItem() + "\n"
              + "deskripsi Bahan" + "\t" + txtDeskripsiOrderUbahBahan.getText() + "\n"
              + "Harga Bahan" + "\t" + txtHargaOrderUbahBahan.getText() + "\n"
              + "Harga Total" + "\t" + txtHargaTotalUbahBahan.getText() + "\n\n"
              + "Masukan Uang";

          String checkoutOrder = JOptionPane.showInputDialog(null, PembayaranOrder, "Pembayaran",
              JOptionPane.QUESTION_MESSAGE);
          int uang = Integer.parseInt(checkoutOrder);
          int kembalian = uang - hargaTotalOrder;

          if (Model.ubahOrderBahan(idOrder, idMitra, bahanOrder, ptOrder, deskripsiOrder, alamatOrder, jumlahOrder,
              hargaOrder)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pesanan ada akan diproses!",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " + kembalian);
            txtJumlahOrderUbahBahan.setText(null);
            txtDeskripsiOrderUbahBahan.setText(null);
            pilihMenuOrderUbahBahan.setSelectedItem("Pilih Bahan");
            pilihPTOrderUbahBahan.setSelectedItem("Pilih PT");
            txtAlamatOrderUbahBahan.setText(null);
            txtHargaOrderUbahBahan.setText(null);
            initsOrderBahan();
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Gagal!.", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    btnHapusOrderUbahBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        txtJumlahOrderUbahBahan.setText(null);
        txtDeskripsiOrderUbahBahan.setText(null);
        pilihMenuOrderUbahBahan.setSelectedItem("Coffe");
        pilihPTOrderUbahBahan.setSelectedItem("PT JOMOK");
        txtAlamatOrderUbahBahan.setText(null);
        txtHargaOrderUbahBahan.setText(null);
      }
    });

    btnKembaliUbahOrderBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        initsOrderBahan();
      }
    });

    labelInputOrderUbahBahan.setForeground(cColor.WHITE);

    content.add(labelInputOrderUbahBahan);
    content.add(labelJumlahOrderUbahBahan);
    content.add(txtJumlahOrderUbahBahan);
    content.add(labelHargaOrderUbahBahan);
    content.add(txtHargaOrderUbahBahan);
    content.add(labelDeskripsiOrderUbahBahan);
    content.add(txtDeskripsiOrderUbahBahan);
    content.add(labelAlamatOrderUbahBahan);
    content.add(txtAlamatOrderUbahBahan);
    content.add(labelPilihMenuOrderUbahBahan);
    content.add(pilihMenuOrderUbahBahan);
    content.add(labelPilihPTOrderUbahBahan);
    content.add(pilihPTOrderUbahBahan);
    content.add(txtHargaTotalUbahBahan);
    content.add(btnSimpanOrderUbahBahan);
    content.add(btnHapusOrderUbahBahan);
    content.add(btnKembaliUbahOrderBahan);

    content.add(panelHeaderOrderBahan);

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

    pilihMenuOrderBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (pilihMenuOrderBahan.getSelectedItem().equals("Coffe")) {
          hargaBahan = 10000;
          String bahanHarga = Integer.toString(hargaBahan);
          txtHargaOrderBahan.setText(bahanHarga);
        } else if (pilihMenuOrderBahan.getSelectedItem().equals("Telur")) {
          hargaBahan = 1000;
          String bahanHarga = Integer.toString(hargaBahan);
          txtHargaOrderBahan.setText(bahanHarga);
        } else if (pilihMenuOrderBahan.getSelectedItem().equals("Beras")) {
          hargaBahan = 2000;
          String bahanHarga = Integer.toString(hargaBahan);
          txtHargaOrderBahan.setText(bahanHarga);
        } else {
          hargaBahan = 5000;
          String bahanHarga = Integer.toString(hargaBahan);
          txtHargaOrderBahan.setText(bahanHarga);
        }
      }
    });

    btnSimpanOrderBahan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        if (txtJumlahOrderBahan.getText().trim().isEmpty()
            || txtDeskripsiOrderBahan.getText().trim().isEmpty()
            || pilihMenuOrderBahan.getSelectedItem() == null
            || pilihPTOrderBahan.getSelectedItem() == null
            || txtAlamatOrderBahan.getText().trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
          if (txtJumlahOrderBahan.getText().trim().isEmpty()) {
            content.add(errorJumlahOrderBahan);
          } else {
            content.remove(errorJumlahOrderBahan);
          }
          if (txtDeskripsiOrderBahan.getText().trim().isEmpty()) {
            content.add(errorDeskripsiOrderBahan);
          } else {
            content.remove(errorDeskripsiOrderBahan);
          }
          if (pilihMenuOrderBahan.getSelectedItem() == null
              || pilihMenuOrderBahan.getSelectedItem().toString().trim().equals("Pilih Bahan")) {
            content.add(errorMenuOrderBahan);
          } else {
            content.remove(errorMenuOrderBahan);
          }
          if (pilihPTOrderBahan.getSelectedItem() == null
              || pilihPTOrderBahan.getSelectedItem().toString().trim().equals("Pilih PT")) {
            content.add(errorPTOrderBahan);
          } else {
            content.remove(errorPTOrderBahan);
          }
          if (txtAlamatOrderBahan.getText().trim().isEmpty()) {
            content.add(errorAlamatOrderBahan);
          } else {
            content.remove(errorAlamatOrderBahan);
          }
          cDashboardMitraView.this.setVisible(true);
        } else {
          int jumlahOrder = Integer.valueOf(txtJumlahOrderBahan.getText());
          String bahanOrder = (String) pilihMenuOrderBahan.getSelectedItem();
          String ptOrder = (String) pilihPTOrderBahan.getSelectedItem();
          String deskripsiOrder = txtDeskripsiOrderBahan.getText();
          String alamatOrder = txtAlamatOrderBahan.getText();
          int hargaOrder = Integer.valueOf(txtHargaOrderBahan.getText());
          int hargaTotalOrder = hargaOrder * jumlahOrder;
          String hargaTotal = Integer.toString(hargaTotalOrder);
          txtHargaTotalOrderBahan.setText(hargaTotal);

          String PembayaranOrder = "Data Order Bahan" + "\n\n"
              + "Jumlah bahan" + "\t" + txtJumlahOrderBahan.getText() + "\n"
              + "Jenis Bahan" + "\t" + pilihMenuOrderBahan.getSelectedItem() + "\n"
              + "Nama PT" + "\t" + pilihPTOrderBahan.getSelectedItem() + "\n"
              + "deskripsi Bahan" + "\t" + txtDeskripsiOrderBahan.getText() + "\n"
              + "Harga Bahan" + "\t" + txtHargaOrderBahan.getText() + "\n"
              + "Harga Total" + "\t" + txtHargaTotalOrderBahan.getText() + "\n\n"
              + "Masukan Uang";

          String checkoutOrder = JOptionPane.showInputDialog(null, PembayaranOrder, "Pembayaran",
              JOptionPane.QUESTION_MESSAGE);
          int uang = Integer.parseInt(checkoutOrder);
          int kembalian = uang - hargaTotalOrder;

          if (Model.tambahOrderBahan(idMitra, bahanOrder, ptOrder, deskripsiOrder, alamatOrder, jumlahOrder,
              hargaOrder)) {
            // kalau berhasil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Berhasil",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Pesanan ada akan diproses!",
                "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Uang Kembalian Anda " + "Rp. " + kembalian);
            txtJumlahOrderBahan.setText(null);
            txtDeskripsiOrderBahan.setText(null);
            pilihMenuOrderBahan.setSelectedItem("Pilih Bahan");
            pilihPTOrderBahan.setSelectedItem("Pilih PT");
            txtAlamatOrderBahan.setText(null);
            txtHargaOrderBahan.setText(null);
          } else {
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Transaksi Gagal!.", "Gagal",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

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

    labelInputOrderBahan.setForeground(cColor.WHITE);

    content.add(labelInputOrderBahan);
    content.add(labelJumlahOrderBahan);
    content.add(txtJumlahOrderBahan);
    content.add(labelHargaOrderBahan);
    content.add(txtHargaOrderBahan);
    content.add(labelDeskripsiOrderBahan);
    content.add(txtDeskripsiOrderBahan);
    content.add(labelAlamatOrderBahan);
    content.add(txtAlamatOrderBahan);
    content.add(labelPilihMenuOrderBahan);
    content.add(pilihMenuOrderBahan);
    content.add(labelPilihPTOrderBahan);
    content.add(pilihPTOrderBahan);
    content.add(txtHargaTotalOrderBahan);
    content.add(btnSimpanOrderBahan);
    content.add(btnHapusOrderBahan);
    content.add(btnKembaliOrderBahan);

    content.add(panelHeaderOrderBahan);

    setVisible(true);
  }

  private void initsHistory() {
    resetSidebar();
    menuHistory.setBackground(cColor.GREEN);
    menuHistory.setForeground(cColor.WHITE);
    menuHistory.setSidebarAktif();
    refreshContent();
    menuTitle.setText("Data History");

    content.add(pilihHistory);

    pilihHistory.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedItem = (String) pilihHistory.getSelectedItem();
        if (selectedItem.equals("History Bahan")) {
          initsDataHistoryBahan();
        } else if (selectedItem.equals("Order Offline")) {
          initsDataHistoryOrderOffline();
        }
      }
    });

    initsDataHistoryBahan();

    setVisible(true);
  }

  private void initsDataHistoryBahan() {
    resetSidebar();
    menuHistory.setBackground(cColor.GREEN);
    menuHistory.setForeground(cColor.WHITE);
    menuHistory.setSidebarAktif();
    refreshContent();
    menuTitle.setText("Data History Order Bahan");

    content.add(pilihHistory);

    tblHistoryBahan = new cTable(Model.getAllOrderBahanSelesai());

    tblHistoryBahan.getColumnModel().getColumn(0).setMinWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(0).setMaxWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(0).setWidth(0);

    tblHistoryBahan.getColumnModel().getColumn(1).setMinWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(1).setMaxWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(1).setWidth(0);

    tblHistoryBahan.getColumnModel().getColumn(2).setMinWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(2).setMaxWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(2).setWidth(0);

    tblHistoryBahan.getColumnModel().getColumn(3).setMinWidth(200);
    tblHistoryBahan.getColumnModel().getColumn(3).setMaxWidth(200);
    tblHistoryBahan.getColumnModel().getColumn(3).setWidth(200);

    tblHistoryBahan.getColumnModel().getColumn(6).setMinWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(6).setMaxWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(6).setWidth(0);

    tblHistoryBahan.getColumnModel().getColumn(7).setMinWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(7).setMaxWidth(0);
    tblHistoryBahan.getColumnModel().getColumn(7).setWidth(0);

    tblHistoryBahan.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblHistoryBahan.getSelectedRow();
        String idString = tblHistoryBahan.getValueAt(selectedIndex, 0).toString();
        int idOrder = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

        String deksripsiHistoryBahan = Model.getDetailOrderBahanSelesai(idOrder)[6].toString();
        valueDeskripsiHistoryBahan.setText(deksripsiHistoryBahan);

        String alamatHistoryBahan = Model.getDetailOrderBahanSelesai(idOrder)[7].toString();
        valueAlamatHistoryBahan.setText(alamatHistoryBahan);
      }
    });

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Deskripsi ");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledAlamat = new TitledBorder(new LineBorder(cColor.BLACK), "Alamat");
    titledAlamat.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledCari = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledCari.setTitleFont(cFonts.CARI_FONT);

    txtCariHistoryBahan.setBorder(titledCari);
    txtCariHistoryBahan.setSize(300, 45);

    valueDeskripsiHistoryBahan.setBorder(titledDeskripsi);
    valueAlamatHistoryBahan.setBorder(titledAlamat);

    spHistoryBahan = new cScrollPane(tblHistoryBahan, 0, 150, 700, 400);

    labelHistory.setForeground(cColor.WHITE);

    content.add(spHistoryBahan);

    content.add(labelHistory);
    content.add(txtCariHistoryBahan);
    content.add(valueDeskripsiHistoryBahan);
    content.add(valueAlamatHistoryBahan);

    content.add(panelHeaderHistoryBahan);
    content.add(panelDeskripsiHistoryBahan);

    setVisible(true);
  }

  private void initsDataHistoryOrderOffline() {
    resetSidebar();
    menuHistory.setBackground(cColor.GREEN);
    menuHistory.setForeground(cColor.WHITE);
    menuHistory.setSidebarAktif();
    refreshContent();
    menuTitle.setText("Data History Order Bahan");

    content.add(pilihHistory);
    content.add(labelHistory);

    btnDetailHistoryTransaksi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        int selectedIndex = tblDataHistoryTransaksi.getSelectedRow();

        if (selectedIndex != -1) {
          String idString = tblDataHistoryTransaksi.getValueAt(selectedIndex, 0).toString();
          int idTransaksi = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

          String transaksiId = Model.getDetailTransaksiSelesai(idTransaksi)[0].toString();
          String mitraId = Model.getDetailTransaksiSelesai(idTransaksi)[1].toString();
          String namaMitra = Model.getDetailTransaksiSelesai(idTransaksi)[2].toString();
          String waktuTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[3].toString();
          String namaTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[4].toString();
          String makananTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[5].toString();
          String coffeTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[6].toString();
          String nonCoffeTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[7].toString();
          String jumlahMakanan = Model.getDetailTransaksiSelesai(idTransaksi)[8].toString();
          String jumlahCoffe = Model.getDetailTransaksiSelesai(idTransaksi)[9].toString();
          String jumlahNonCoffe = Model.getDetailTransaksiSelesai(idTransaksi)[10].toString();
          String hargaMakanan = Model.getDetailTransaksiSelesai(idTransaksi)[11].toString();
          String hargaCoffe = Model.getDetailTransaksiSelesai(idTransaksi)[12].toString();
          String hargaNonCoffe = Model.getDetailTransaksiSelesai(idTransaksi)[13].toString();
          String promoTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[14].toString();
          String mejaTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[15].toString();
          String deskripsiTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[16].toString();
          String hargaTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[17].toString();
          String bayarTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[18].toString();
          String statusTransaksi = Model.getDetailTransaksiSelesai(idTransaksi)[19].toString();

          String detailTransaksi = "\tForque" + "\n\n"
              + "Jl. Jagal No.3A RT 007/004, Jl. Jagal, Rangkapan Jaya,\n"
              + "Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435\n"
              + "====================================================\n"
              + String.format("%-40s:  %s", "Tanggal/Waktu", waktuTransaksi) + "\n"
              + String.format("%-40s:  TR%s", "ID Transaksi", transaksiId) + "\n"
              + String.format("%-44s:  MI%s", "ID Mitra", mitraId) + "\n"
              + String.format("%-39s: %s", "Nama Mitra", namaMitra) + "\n"
              + "====================================================\n"
              + String.format("%-44s: %s", "Status Transaksi", statusTransaksi) + "\n"
              + String.format("%-44s: %s", "Nomor Meja", mejaTransaksi) + "\n"
              + String.format("%-39s: %s", "Nama Pemesan", namaTransaksi) + "\n"
              + String.format("%-44s: %s", "Pembayaran", bayarTransaksi) + "\n"
              + String.format("%-49s: %s", "Promo", promoTransaksi) + "\n"
              + String.format("%-38s: %s", "Deskripsi Pesanan", deskripsiTransaksi) + "\n"
              + "====================================================\n"
              + String.format("%-60s %-30s %-10s", makananTransaksi, jumlahMakanan, hargaMakanan) + "\n"
              + String.format("%-60s %-30s %-10s", coffeTransaksi, jumlahCoffe, hargaCoffe) + "\n"
              + String.format("%-60s %-30s %-10s", nonCoffeTransaksi, jumlahNonCoffe, hargaNonCoffe) + "\n"
              + "====================================================\n"
              + String.format("%-80s Harga Total   : %s", "", hargaTransaksi) + "\n"
              + "====================================================\n"
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
          JOptionPane.showMessageDialog(cDashboardMitraView.this,
              "Pilih data terlebih dahulu!",
              "Peringatan",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    tblDataHistoryTransaksi = new cTable(Model.getAllTransaksiSelesai());

    tblDataHistoryTransaksi.getColumnModel().getColumn(0).setMinWidth(80);
    tblDataHistoryTransaksi.getColumnModel().getColumn(0).setMaxWidth(80);
    tblDataHistoryTransaksi.getColumnModel().getColumn(0).setWidth(80);

    tblDataHistoryTransaksi.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(1).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(2).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(5).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(5).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(5).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(6).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(6).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(6).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(7).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(7).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(7).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(8).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(8).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(8).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(9).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(9).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(9).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(10).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(10).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(10).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(11).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(11).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(11).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(12).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(12).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(12).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(13).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(13).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(13).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(14).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(14).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(14).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(15).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(15).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(15).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(16).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(16).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(16).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(17).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(17).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(17).setWidth(0);

    tblDataHistoryTransaksi.getColumnModel().getColumn(18).setMinWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(18).setMaxWidth(0);
    tblDataHistoryTransaksi.getColumnModel().getColumn(18).setWidth(0);

    spDataHistoryTransaksi = new cScrollPane(tblDataHistoryTransaksi, 0, 150, 1100, 400);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    txtCariHistoryTransaksi.setBorder(titledBorder);
    txtCariHistoryTransaksi.setSize(300, 45);

    content.add(btnDetailHistoryTransaksi);

    content.add(spDataHistoryTransaksi);
    content.add(txtCariHistoryTransaksi);
    content.add(panelHeaderHistoryTransaksi);

    setVisible(true);
  }

  private void initsDataReport() {
    resetSidebar();
    menuReport.setBackground(cColor.GREEN);
    menuReport.setForeground(cColor.WHITE);
    menuReport.setSidebarAktif();
    refreshContent();
    menuTitle.setText("Data Report");

    content.add(pilihDataLaporan);
    content.add(labelDataLaporan);

    pilihDataLaporan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String selectedItem = (String) pilihDataLaporan.getSelectedItem();
        if (selectedItem.equals("Data Customer")) {
          initsDataReportCustomer();
        } else if (selectedItem.equals("Data Karyawan")) {
          initsDataReportKaryawan();
        } else if (selectedItem.equals("Data Promo")) {
          initsDataReportPromo();
        } else if (selectedItem.equals("Data Meja")) {
          initsDataReportMeja();
        }
      }
    });

    initsDataReportCustomer();

    setVisible(true);
  }

  private void initsDataReportCustomer() {
    resetSidebar();
    menuReport.setBackground(cColor.GREEN);
    menuReport.setForeground(cColor.WHITE);
    menuReport.setSidebarAktif();
    refreshContent();
    menuTitle.setText("Data Report Customer");

    content.add(pilihDataLaporan);
    content.add(labelDataLaporan);

    btnCetakReportCustomer.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {

      }
    });

    txtCariCustomer.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariCustomer.getText();

        tblDataCustomer.setModel(Model.getCariDataCustomer(keyword));

        tblDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataCustomer.getColumnModel().getColumn(0).setWidth(0);

        tblDataCustomer.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataCustomer.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataCustomer.getColumnModel().getColumn(5).setWidth(0);
      }
    });

    tblDataCustomer = new cTable(Model.getAllCustomer());

    tblDataCustomer.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataCustomer.getColumnModel().getColumn(0).setWidth(0);

    tblDataCustomer.getColumnModel().getColumn(5).setMinWidth(0);
    tblDataCustomer.getColumnModel().getColumn(5).setMaxWidth(0);
    tblDataCustomer.getColumnModel().getColumn(5).setWidth(0);

    spDataCustomer = new cScrollPane(tblDataCustomer, 0, 150, 1100, 300);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    txtCariCustomer.setBorder(titledBorder);
    txtCariCustomer.setSize(300, 45);

    labelDataLaporan.setForeground(cColor.WHITE);

    content.add(spDataCustomer);
    content.add(txtCariCustomer);
    content.add(btnCetakReportCustomer);
    content.add(panelHeaderCustomer);

    setVisible(true);
  }

  private void initsDataReportKaryawan() {
    resetSidebar();
    menuReport.setBackground(cColor.GREEN);
    menuReport.setForeground(cColor.WHITE);
    menuReport.setSidebarAktif();
    refreshContent();
    menuTitle.setText("Data Report Karyawan");

    content.add(pilihDataLaporan);
    content.add(labelDataLaporan);

    btnCetakReportKaryawan.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {

      }
    });

    tblDataTerverifikasi = new cTable(Model.getAllKaryawantTerverifikasi());

    tblDataTerverifikasi.getColumnModel().getColumn(0).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(0).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(0).setWidth(0);

    tblDataTerverifikasi.getColumnModel().getColumn(1).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(1).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(1).setWidth(0);

    tblDataTerverifikasi.getColumnModel().getColumn(2).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(2).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(2).setWidth(0);

    tblDataTerverifikasi.getColumnModel().getColumn(7).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(7).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(7).setWidth(0);

    tblDataTerverifikasi.getColumnModel().getColumn(9).setMinWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(9).setMaxWidth(0);
    tblDataTerverifikasi.getColumnModel().getColumn(9).setWidth(0);

    txtCariTerverifikasi.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        String keyword = txtCariTerverifikasi.getText();

        tblDataTerverifikasi.setModel(Model.getCariDataKaryawanTerverifikasi(keyword));

        tblDataTerverifikasi.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(0).setWidth(0);

        tblDataTerverifikasi.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(1).setWidth(0);

        tblDataTerverifikasi.getColumnModel().getColumn(2).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(2).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(2).setWidth(0);

        tblDataTerverifikasi.getColumnModel().getColumn(7).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(7).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(7).setWidth(0);

        tblDataTerverifikasi.getColumnModel().getColumn(9).setMinWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(9).setMaxWidth(0);
        tblDataTerverifikasi.getColumnModel().getColumn(9).setWidth(0);

      }
    });

    tblDataTerverifikasi.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mousePressed(java.awt.event.MouseEvent me) {
        int selectedIndex = tblDataTerverifikasi.getSelectedRow();

        int idKaryawan = Integer.valueOf(tblDataTerverifikasi.getValueAt(selectedIndex, 0).toString());

        String alamatKaryawan = Model.getDetailKaryawanTerverifikasi(idKaryawan)[8].toString();
        valueAlamatDataTerverifikasi.setText(alamatKaryawan);
      }
    });

    spDataTerverifikasi = new cScrollPane(tblDataTerverifikasi, 0, 150, 1100, 400);

    TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
    titledBorder.setTitleFont(cFonts.CARI_FONT);

    TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Alamat Terverifikasi");
    titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

    valueAlamatDataTerverifikasi.setBorder(titledDeskripsi);

    txtCariTerverifikasi.setBorder(titledBorder);
    txtCariTerverifikasi.setSize(300, 45);

    labelDataLaporan.setForeground(cColor.WHITE);

    content.add(valueAlamatDataTerverifikasi);
    content.add(panelAlamatTerverifikasi);
    content.add(spDataTerverifikasi);
    content.add(btnCetakReportKaryawan);

    content.add(txtCariTerverifikasi);

    content.add(panelHeaderTerverifikasi);

    setVisible(true);
  }

  private void initsDataReportPromo() {
    resetSidebar();
    menuReport.setBackground(cColor.GREEN);
    menuReport.setForeground(cColor.WHITE);
    menuReport.setSidebarAktif();
    refreshContent();
    menuTitle.setText("Data Report Karyawan");

    content.add(pilihDataLaporan);
    content.add(labelDataLaporan);

    btnCetakReportPromo.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {

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

    spDataPromo = new cScrollPane(tblDataPromo, 0, 150, 1080, 300);

    content.add(spDataPromo);

    content.add(labelCariReportPromo);
    content.add(txtCariReportPromo);
    content.add(btnCetakReportPromo);

    setVisible(true);
  }

  private void initsDataReportMeja() {
    resetSidebar();
    menuReport.setBackground(cColor.GREEN);
    menuReport.setForeground(cColor.WHITE);
    menuReport.setSidebarAktif();
    refreshContent();
    menuTitle.setText("Data Report Meja");

    content.add(pilihDataLaporan);

    btnCetakReportMeja.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {

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

    spDataMeja = new cScrollPane(tblDataMeja, 0, 150, 1080, 300);

    content.add(spDataMeja);

    content.add(labelCariReportMeja);
    content.add(txtCariReportMeja);
    content.add(btnCetakReportMeja);

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

    Object[] dataMitra = Model.getDetailAkunMitra(idMitra);

    txtNamaDataAkun.setText(dataMitra[1].toString());
    txtEmailDataAkun.setText(dataMitra[3].toString());
    txtNomorHpDataAkun.setText(dataMitra[2].toString());
    txtAlamatDataAkun.setText(dataMitra[4].toString());
    txtPasswordDataAkun.setText(dataMitra[5].toString());

    btnSimpanDataAkun.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae) {
        // error tidak boleh kosong
        if (txtNamaDataAkun.getText().trim().isEmpty()
            || txtNomorHpDataAkun.getText().trim().isEmpty()
            || txtEmailDataAkun.getText().trim().isEmpty()
                && !dataMitra[3].toString().equalsIgnoreCase(txtEmailDataAkun.getText())
                && Model.getCountMitraByEmail(txtEmailDataAkun.getText()) == 1
            || txtAlamatDataAkun.getText().trim().isEmpty()
            || new String(txtPasswordDataAkun.getPassword()).trim().isEmpty()) {
          cDashboardMitraView.this.setVisible(false);
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
          cDashboardMitraView.this.setVisible(true);
        } else {
          String namaMitra = txtNamaDataAkun.getText();
          String nomorHpMitra = txtNomorHpDataAkun.getText();
          String emailMitra = txtEmailDataAkun.getText();
          String alamatMitra = txtAlamatDataAkun.getText();
          String passwordMitra = new String(txtPasswordDataAkun.getPassword());

          if (Model.ubahProfileMitra(idMitra, namaMitra, nomorHpMitra, emailMitra, passwordMitra,
              alamatMitra)) {
            // kalau berhasil ubah profil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Ubah Profil berhasil", "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
            initsAkun();
          } else {
            // kalau gagal ubah profil
            JOptionPane.showMessageDialog(cDashboardMitraView.this, "Ubah profil gagal!", "Gagal",
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
