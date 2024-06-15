package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Model {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbforque";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connect;
    private static Statement statement;

    private static void connection() {
        try {
            connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // get Detail Data Mitra
    public static Object[] getDetailMitra(int idMitra) {
        connection();

        Object rowData[] = new Object[4];

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT * FROM vwallmitra WHERE idMitra = " + idMitra;

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            rowData[0] = resultData.getInt("idMitra");
            rowData[1] = resultData.getString("namaMitra");
            rowData[2] = resultData.getString("emailMitra");
            rowData[3] = resultData.getString("statusTerverifikasi");

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data Menu Makanan
    public static Object[] getDetailMenuMakanan(int idMenu) {

        connection();

        Object[] rowData = new Object[9];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmenumakanan WHERE idMenu = " + idMenu;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idMenu");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuMenu");
            rowData[4] = resultData.getString("namaMenu");
            rowData[5] = resultData.getInt("jumlahMenu");
            rowData[6] = resultData.getInt("hargaMenu");
            rowData[7] = resultData.getString("deskripsiMenu");
            rowData[8] = resultData.getString("statusMenu");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data Menu Coffe
    public static Object[] getDetailMenuCoffe(int idMenu) {

        connection();

        Object[] rowData = new Object[9];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmenucoffe WHERE idMenu = " + idMenu;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idMenu");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuMenu");
            rowData[4] = resultData.getString("namaMenu");
            rowData[5] = resultData.getInt("jumlahMenu");
            rowData[6] = resultData.getInt("hargaMenu");
            rowData[7] = resultData.getString("deskripsiMenu");
            rowData[8] = resultData.getString("statusMenu");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data Menu Non Coffe
    public static Object[] getDetailMenuNonCoffe(int idMenu) {

        connection();

        Object[] rowData = new Object[9];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmenunoncoffe WHERE idMenu = " + idMenu;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idMenu");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuMenu");
            rowData[4] = resultData.getString("namaMenu");
            rowData[5] = resultData.getInt("jumlahMenu");
            rowData[6] = resultData.getInt("hargaMenu");
            rowData[7] = resultData.getString("deskripsiMenu");
            rowData[8] = resultData.getString("statusMenu");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    public static int getDetailSaldoMitra(int idMitra) {
        connection();

        int saldo = 0;

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT saldoMitra FROM vwsaldomitra WHERE idMitra = " + idMitra;

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            saldo = resultData.getInt("saldoMitra");

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return saldo;

    }

    // get data all menu makanan
    public static DefaultTableModel getAllMenuMakanan() {

        connection();

        String[] dataHeader = { "ID Menu", "ID Mitra", "Mitra", "Waktu", "Menu", "Jumlah", "Harga", "Deskripsi",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmenumakanan";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idMenu"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuMenu"),
                        resultData.getString("namaMenu"),
                        resultData.getInt("jumlahMenu"),
                        resultData.getInt("hargaMenu"),
                        resultData.getString("deskripsiMenu"),
                        resultData.getString("statusMenu") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all menu coffe
    public static DefaultTableModel getAllMenuCoffe() {

        connection();

        String[] dataHeader = { "ID Menu", "ID Mitra", "Mitra", "Waktu", "Menu", "Jumlah", "Harga", "Deskripsi",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmenucoffe";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idMenu"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuMenu"),
                        resultData.getString("namaMenu"),
                        resultData.getInt("jumlahMenu"),
                        resultData.getInt("hargaMenu"),
                        resultData.getString("deskripsiMenu"),
                        resultData.getString("statusMenu") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // detail data Menu Makanan
    public static Object[] getDetailPromo(int idMenu) {

        connection();

        Object[] rowData = new Object[10];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwallpromo WHERE idMenu = " + idMenu;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idMenu");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuPromo");
            rowData[4] = resultData.getString("namaPromo");
            rowData[5] = resultData.getString("menuPromo");
            rowData[6] = resultData.getInt("jumlahPromo");
            rowData[7] = resultData.getInt("hargaPromo");
            rowData[8] = resultData.getString("deskripsiPromo");
            rowData[9] = resultData.getString("statusPromo");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data Meja
    public static Object[] getDetailMeja(int idMeja) {

        connection();

        Object[] rowData = new Object[8];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmeja WHERE idMeja = " + idMeja;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idMeja");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuMeja");
            rowData[4] = resultData.getString("nomorMeja");
            rowData[5] = resultData.getString("jenisMeja");
            rowData[6] = resultData.getString("deskripsiMeja");
            rowData[7] = resultData.getString("statusMeja");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data Meja
    public static Object[] getDetailTransaksiMakananDiproses(int idTransaksi) {

        connection();

        Object[] rowData = new Object[13];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksimakanandiproses WHERE idTransaksi = " + idTransaksi;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idTransaksi");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuTransaksi");
            rowData[4] = resultData.getString("namaTransaksi");
            rowData[5] = resultData.getString("menuTransaksi");
            rowData[6] = resultData.getString("mejaTransaksi");
            rowData[7] = resultData.getString("promoTransaksi");
            rowData[8] = resultData.getString("deskripsiTransaksi");
            rowData[9] = resultData.getInt("jumlahTransaksi");
            rowData[10] = resultData.getInt("hargaTransaksi");
            rowData[11] = resultData.getString("bayarTransaksi");
            rowData[12] = resultData.getString("statusTransaksi");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data Meja
    public static Object[] getDetailTransaksiCoffeDiproses(int idTransaksi) {

        connection();

        Object[] rowData = new Object[13];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksicoffediproses WHERE idTransaksi = " + idTransaksi;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idTransaksi");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuTransaksi");
            rowData[4] = resultData.getString("namaTransaksi");
            rowData[5] = resultData.getString("menuTransaksi");
            rowData[6] = resultData.getString("mejaTransaksi");
            rowData[7] = resultData.getString("promoTransaksi");
            rowData[8] = resultData.getString("deskripsiTransaksi");
            rowData[9] = resultData.getInt("jumlahTransaksi");
            rowData[10] = resultData.getInt("hargaTransaksi");
            rowData[11] = resultData.getString("bayarTransaksi");
            rowData[12] = resultData.getString("statusTransaksi");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

     // detail data Meja
     public static Object[] getDetailTransaksiNonCoffeDiproses(int idTransaksi) {

        connection();

        Object[] rowData = new Object[13];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksinoncoffediproses WHERE idTransaksi = " + idTransaksi;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idTransaksi");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuTransaksi");
            rowData[4] = resultData.getString("namaTransaksi");
            rowData[5] = resultData.getString("menuTransaksi");
            rowData[6] = resultData.getString("mejaTransaksi");
            rowData[7] = resultData.getString("promoTransaksi");
            rowData[8] = resultData.getString("deskripsiTransaksi");
            rowData[9] = resultData.getInt("jumlahTransaksi");
            rowData[10] = resultData.getInt("hargaTransaksi");
            rowData[11] = resultData.getString("bayarTransaksi");
            rowData[12] = resultData.getString("statusTransaksi");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // get data all menu non coffe
    public static DefaultTableModel getAllMenuNonCoffe() {

        connection();

        String[] dataHeader = { "ID Menu", "ID Mitra", "Mitra", "Waktu", "Menu", "Jumlah", "Harga", "Deskripsi",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmenuNoncoffe";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idMenu"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuMenu"),
                        resultData.getString("namaMenu"),
                        resultData.getInt("jumlahMenu"),
                        resultData.getInt("hargaMenu"),
                        resultData.getString("deskripsiMenu"),
                        resultData.getString("statusMenu") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Promo
    public static DefaultTableModel getAllPromo() {

        connection();

        String[] dataHeader = { "ID Menu", "ID Mitra", "Mitra", "Waktu", "Nama", "Menu", "Jumlah", "harga", "Deskripsi",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallpromo";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idPromo"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuPromo"),
                        resultData.getString("namaPromo"),
                        resultData.getString("menuPromo"),
                        resultData.getInt("jumlahPromo"),
                        resultData.getInt("hargaPromo"),
                        resultData.getString("deskripsiPromo"),
                        resultData.getString("statusPromo") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Meja
    public static DefaultTableModel getAllMeja() {

        connection();

        String[] dataHeader = { "ID Meja", "ID Mitra", "Mitra", "Waktu", "kode", "Jenis", "Deskripsi",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmeja";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idMeja"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuMeja"),
                        resultData.getString("nomorMeja"),
                        resultData.getString("jenisMeja"),
                        resultData.getString("deskripsiMeja"),
                        resultData.getString("statusMeja") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all customer
    public static DefaultTableModel getAllCustomer() {

        connection();

        String[] dataHeader = { "ID Customer", "Nama", " Email", "Nomor Hp", "Alamat", "Password", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallcustomer";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idCustomer"),
                        resultData.getString("namaCustomer"),
                        resultData.getString("emailCustomer"),
                        resultData.getString("nomorHpCustomer"),
                        resultData.getString("alamatCustomer"),
                        resultData.getString("passwordCustomer"),
                        resultData.getString("statusAktif") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all karyawan verified
    public static DefaultTableModel getAllKaryawanVerified() {

        connection();

        String[] dataHeader = { "ID Karyawan", "ID Mitra", "Mitra", "waktu", "Nama", " Email", "Nomor Hp", "Alamat",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwkaryawanverified";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idKaryawan"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuKaryawan"),
                        resultData.getString("namaKaryawan"),
                        resultData.getString("emailKaryawan"),
                        resultData.getString("nomorHpKaryawan"),
                        resultData.getString("alamatKaryawan"),
                        resultData.getString("statusTerverifikasi"),
                        resultData.getString("statusAktif") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all karyawan terverified
    public static DefaultTableModel getAllKaryawantTerverified() {

        connection();

        String[] dataHeader = { "ID Karyawan", "ID Mitra", "Mitra", "waktu", "Nama", " Email", "Nomor Hp", "Alamat",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwkaryawanterverified";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idKaryawan"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuKaryawan"),
                        resultData.getString("namaKaryawan"),
                        resultData.getString("emailKaryawan"),
                        resultData.getString("nomorHpKaryawan"),
                        resultData.getString("alamatKaryawan"),
                        resultData.getString("statusTerverifikasi"),
                        resultData.getString("statusAktif") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Transaksi Makanan Diproses
    public static DefaultTableModel getAllTransaksiMakananDiproses() {

        connection();

        String[] dataHeader = { "ID Transaksi", "ID Mitra", "Mitra", "waktu", "Nama", "Menu", "Meja", "Promo",
                "Deskripsi", "Jumlah", "Harga", "Pembayaran", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksimakanandiproses";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idTransaksi"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuTransaksi"),
                        resultData.getString("namaTransaksi"),
                        resultData.getString("menuTransaksi"),
                        resultData.getString("mejaTransaksi"),
                        resultData.getString("promoTransaksi"),
                        resultData.getString("deskripsiTransaksi"),
                        resultData.getInt("jumlahTransaksi"),
                        resultData.getInt("hargaTransaksi"),
                        resultData.getString("bayarTransaksi"),
                        resultData.getString("statusTransaksi") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Transaksi Makanan Selesai
    public static DefaultTableModel getAllTransaksiMakananSelesai() {

        connection();

        String[] dataHeader = { "ID Transaksi", "ID Mitra", "Mitra", "waktu", "Nama", "Menu", "Meja", "Promo",
                "Deskripsi", "Jumlah", "Harga", "Pembayaran", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksimakanandiproses";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idTransaksi"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuTransaksi"),
                        resultData.getString("namaTransaksi"),
                        resultData.getString("menuTransaksi"),
                        resultData.getString("mejaTransaksi"),
                        resultData.getString("promoTransaksi"),
                        resultData.getString("deskripsiTransaksi"),
                        resultData.getInt("jumlahTransaksi"),
                        resultData.getInt("hargaTransaksi"),
                        resultData.getString("bayarTransaksi"),
                        resultData.getString("statusTransaksi") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Transaksi Coffe Diproses
    public static DefaultTableModel getAllTransaksiCoffeDiproses() {

        connection();

        String[] dataHeader = { "ID Transaksi", "ID Mitra", "Mitra", "waktu", "Nama", "Menu", "Meja", "Promo",
                "Deskripsi", "Jumlah", "Harga", "Pembayaran", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksicoffediproses";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idTransaksi"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuTransaksi"),
                        resultData.getString("namaTransaksi"),
                        resultData.getString("menuTransaksi"),
                        resultData.getString("mejaTransaksi"),
                        resultData.getString("promoTransaksi"),
                        resultData.getString("deskripsiTransaksi"),
                        resultData.getInt("jumlahTransaksi"),
                        resultData.getInt("hargaTransaksi"),
                        resultData.getString("bayarTransaksi"),
                        resultData.getString("statusTransaksi") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Transaksi Coffe Selesai
    public static DefaultTableModel getAllTransaksiCoffeSelesai() {

        connection();

        String[] dataHeader = { "ID Transaksi", "ID Mitra", "Mitra", "waktu", "Nama", "Menu", "Meja", "Promo",
                "Deskripsi", "Jumlah", "Harga", "Pembayaran", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksicoffeselesai";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idTransaksi"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuTransaksi"),
                        resultData.getString("namaTransaksi"),
                        resultData.getString("menuTransaksi"),
                        resultData.getString("mejaTransaksi"),
                        resultData.getString("promoTransaksi"),
                        resultData.getString("deskripsiTransaksi"),
                        resultData.getInt("jumlahTransaksi"),
                        resultData.getInt("hargaTransaksi"),
                        resultData.getString("bayarTransaksi"),
                        resultData.getString("statusTransaksi") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Transaksi Non Coffe Diproses
    public static DefaultTableModel getAllTransaksiNonCoffeDiproses() {

        connection();

        String[] dataHeader = { "ID Transaksi", "ID Mitra", "Mitra", "waktu", "Nama", "Menu", "Meja", "Promo",
                "Deskripsi", "Jumlah", "Harga", "Pembayaran", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksinoncoffediproses";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idTransaksi"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuTransaksi"),
                        resultData.getString("namaTransaksi"),
                        resultData.getString("menuTransaksi"),
                        resultData.getString("mejaTransaksi"),
                        resultData.getString("promoTransaksi"),
                        resultData.getString("deskripsiTransaksi"),
                        resultData.getInt("jumlahTransaksi"),
                        resultData.getInt("hargaTransaksi"),
                        resultData.getString("bayarTransaksi"),
                        resultData.getString("statusTransaksi") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Transaksi Non Coffe Selesai
    public static DefaultTableModel getAllTransaksiNonCoffeSelesai() {

        connection();

        String[] dataHeader = { "ID Transaksi", "ID Mitra", "Mitra", "waktu", "Nama", "Menu", "Meja", "Promo",
                "Deskripsi", "Jumlah", "Harga", "Pembayaran", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksinoncoffeselesai";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idTransaksi"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuTransaksi"),
                        resultData.getString("namaTransaksi"),
                        resultData.getString("menuTransaksi"),
                        resultData.getString("mejaTransaksi"),
                        resultData.getString("promoTransaksi"),
                        resultData.getString("deskripsiTransaksi"),
                        resultData.getInt("jumlahTransaksi"),
                        resultData.getInt("hargaTransaksi"),
                        resultData.getString("bayarTransaksi"),
                        resultData.getString("statusTransaksi") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Order Bahan Diproses
    public static DefaultTableModel getAllOrderBahanDiproses() {

        connection();

        String[] dataHeader = { "ID Order", "ID Mitra", "Mitra", "waktu", "Bahan", "PT", "Deskripsi", "Alamat",
                "Jumlah", "Harga", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vworderbahandiproses";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idOrder"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuOrder"),
                        resultData.getString("bahanOrder"),
                        resultData.getString("ptOrder"),
                        resultData.getString("deskripsiOrder"),
                        resultData.getString("alamatOrder"),
                        resultData.getInt("jumlahOrder"),
                        resultData.getInt("hargaOrder"),
                        resultData.getString("statusOrder") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Order Bahan Selesai
    public static DefaultTableModel getAllOrderBahanSelesai() {

        connection();

        String[] dataHeader = { "ID Order", "ID Mitra", "Mitra", "waktu", "Bahan", "PT", "Deskripsi", "Alamat",
                "Jumlah", "Harga", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vworderbahanselesai";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idOrder"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuOrder"),
                        resultData.getString("bahanOrder"),
                        resultData.getString("ptOrder"),
                        resultData.getString("deskripsiOrder"),
                        resultData.getString("alamatOrder"),
                        resultData.getInt("jumlahOrder"),
                        resultData.getInt("hargaOrder"),
                        resultData.getString("statusOrder") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // insert data menu makanan
    public static boolean tambahMenuMakanan(int idMitra, String namaMakanan, int jumlahMakanan, int hargaMakanan,
            String deskripsiMakanan) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            String query = "INSERT INTO tblmenumakanan VALUES (NULL, '" + idMitra + "', NOW(), '" + namaMakanan
                    + "', " + jumlahMakanan + ", " + hargaMakanan + ", '" + deskripsiMakanan + "', 'Ready')";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // insert data menu Coffe
    public static boolean tambahMenuCoffe(int idMitra, String namaCoffe, int jumlahCoffe, int hargaCoffe,
            String deskripsiCoffe) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            String query = "INSERT INTO tblmenucoffe VALUES (NULL, '" + idMitra + "', NOW(), '" + namaCoffe
                    + "', " + jumlahCoffe + ", " + hargaCoffe + ", '" + deskripsiCoffe + "', 'Ready')";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // insert data menu Non Coffe
    public static boolean tambahMenuNonCoffe(int idMitra, String namaNonCoffe, int jumlahNonCoffe, int hargaNonCoffe,
            String deskripsiNonCoffe) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            String query = "INSERT INTO tblmenunoncoffe VALUES (NULL, '" + idMitra + "', NOW(), '" + namaNonCoffe
                    + "', " + jumlahNonCoffe + ", " + hargaNonCoffe + ", '" + deskripsiNonCoffe + "', 'Ready')";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // insert data Meja
    public static boolean tambahMeja(int idMitra, String nomorMeja, String jenisMeja,
            String deskripsiMeja) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            // Tambahkan tanda kutip untuk nilai string dan tambahkan koma antara nilai
            String query = "INSERT INTO tblmeja VALUES (NULL, '" + idMitra + "', NOW(), '" + nomorMeja + "', '"
                    + jenisMeja + "', '" + deskripsiMeja + "', 'Ready')";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    // insert data karyawan
    public static boolean tambahKaryawan(int idMitra, String namaKaryawan, String nomorHpKaryawan,
            String emailKaryawan, String jobdeskKaryawan, String alamatKaryawan) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            // Tambahkan tanda kutip untuk nilai string dan tambahkan koma antara nilai
            String query = "INSERT INTO tblkaryawan VALUES (NULL, '" + idMitra + "', NOW(), '" + namaKaryawan + "', '"
                    + nomorHpKaryawan + "', '" + emailKaryawan + "', '" + jobdeskKaryawan + "', '" + alamatKaryawan
                    + "', 'Verified', 'Aktif')";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    // insert data karyawan
    public static boolean tambahPromo(int idMitra, String namaPromo, String menuPromo,
            int jumlahPromo, int hargaPromo, String deskripsiPromo) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            // Tambahkan tanda kutip untuk nilai string dan tambahkan koma antara nilai
            String query = "INSERT INTO tblpromo VALUES (NULL, '" + idMitra + "', NOW(), '" + namaPromo + "', '"
                    + menuPromo + "', '" + jumlahPromo + "', '" + hargaPromo + "', '" + deskripsiPromo + "', 'Ready')";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    // insert transaksi makanan
    public static boolean tambahTransaksiMakanan(int idMitra, String namaTransaksi, String menuTransaksi,
            String mejaTransaksi, String promoTransaksi, String deskripsiTransaksi, int jumlahTransaksi,
            int hargaTransaksi, String bayarTransaksi) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            // Tambahkan tanda kutip untuk nilai string dan tambahkan koma antara nilai
            String query = "INSERT INTO tbltransaksimakanan VALUES (NULL, '" + idMitra + "', NOW(), '" + namaTransaksi
                    + "', '" + menuTransaksi + "', '" + mejaTransaksi + "', '" + promoTransaksi + "', '"
                    + deskripsiTransaksi + "', '" + jumlahTransaksi + "', '" + hargaTransaksi + "', '" + bayarTransaksi
                    + "', 'Diproses')";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    // insert transaksi Coffe
    public static boolean tambahTransaksiCoffe(int idMitra, String namaTransaksi, String menuTransaksi,
            String mejaTransaksi, String promoTransaksi, String deskripsiTransaksi, int jumlahTransaksi,
            int hargaTransaksi,
            String bayarTransaksi) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            // Tambahkan tanda kutip untuk nilai string dan tambahkan koma antara nilai
            String query = "INSERT INTO tbltransaksicoffe VALUES (NULL, '" + idMitra + "', NOW(), '" + namaTransaksi
                    + "', '" + menuTransaksi + "', '" + mejaTransaksi + "', '" + promoTransaksi + "', '"
                    + deskripsiTransaksi + "', '" + jumlahTransaksi + "', '" + hargaTransaksi + "', '" + bayarTransaksi
                    + "', 'Diproses')";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    // insert transaksi Coffe
    public static boolean tambahTransaksiNonCoffe(int idMitra, String namaTransaksi, String menuTransaksi,
            String mejaTransaksi, String promoTransaksi, String deskripsiTransaksi, int jumlahTransaksi,
            int hargaTransaksi,
            String bayarTransaksi) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            // Tambahkan tanda kutip untuk nilai string dan tambahkan koma antara nilai
            String query = "INSERT INTO tbltransaksinoncoffe VALUES (NULL, '" + idMitra + "', NOW(), '" + namaTransaksi
                    + "', '" + menuTransaksi + "', '" + mejaTransaksi + "', '" + promoTransaksi + "', '"
                    + deskripsiTransaksi + "', '" + jumlahTransaksi + "', '" + hargaTransaksi + "', '" + bayarTransaksi
                    + "', 'Diproses')";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    // UbahMenuMakanan
    public static boolean ubahMenuMakanan(int idMenu, int idMitra, String namaMenu, int jumlahMenu,
            int hargaMenu, String deskripsiMenu) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblmenumakanan SET idMitra = '" + idMitra + "', namaMenu = '"
                    + namaMenu + "', jumlahMenu = '" + jumlahMenu + "', hargaMenu = '" + hargaMenu
                    + "', deskripsiMenu = '" + deskripsiMenu
                    + "' WHERE idMenu ='" + idMenu + "'";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Ubah menu makanan
    public static boolean ubahMenuCoffe(int idMenu, int idMitra, String namaMenu, int jumlahMenu,
            int hargaMenu, String deskripsiMenu) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblmenucoffe SET idMitra = '" + idMitra + "', namaMenu = '"
                    + namaMenu + "', jumlahMenu = '" + jumlahMenu + "', hargaMenu = '" + hargaMenu
                    + "', deskripsiMenu = '" + deskripsiMenu
                    + "' WHERE idMenu ='" + idMenu + "'";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Ubah menu makanan
    public static boolean ubahMenuNonCoffe(int idMenu, int idMitra, String namaMenu, int jumlahMenu,
            int hargaMenu, String deskripsiMenu) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblmenunoncoffe SET idMitra = '" + idMitra + "', namaMenu = '"
                    + namaMenu + "', jumlahMenu = '" + jumlahMenu + "', hargaMenu = '" + hargaMenu
                    + "', deskripsiMenu = '" + deskripsiMenu
                    + "' WHERE idMenu ='" + idMenu + "'";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Ubah Data Meja
    public static boolean ubahDataMeja(int idMeja, int idMitra, String nomorMeja, String jenisMeja,
            String deskripsiMeja) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblMeja SET idMitra = '" + idMitra + "', nomorMeja = '"
                    + nomorMeja + "', jenisMeja = '" + jenisMeja + "', deskripsiMeja = '" + deskripsiMeja
                    + "' WHERE idMeja ='" + idMeja + "'";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Ubah Data karyawan
    public static boolean ubahDataKaryawan(int idKaryawan, int idMitra, String namaKaryawan, String nomorHpKaryawan,
            String emailKaryawan, String jobdeskKaryawan,
            String alamatKaryawan) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblkaryawan SET idMitra = '" + idMitra + "', namaKaryawan = '"
                    + namaKaryawan + "', nomorHpKaryawan = '" + nomorHpKaryawan + "', emailKaryawan = '" + emailKaryawan
                    + "', jobdeskKaryawan = '" + jobdeskKaryawan + "', alamatKaryawan = '" + alamatKaryawan
                    + "' WHERE idKaryawan ='" + idKaryawan + "'";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Ubah Data karyawan
    public static boolean ubahTransaksiMakanan(int idTransaksi, int idMitra, String namaTransaksi, String menuTransaksi,
            String mejaTransaksi, String promoTransaksi, String deskripsiTransaksi, int jumlahTransaksi,
            int hargaTransaksi, String bayarTransaksi) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tbltransaksimakanan SET idMitra = '" + idMitra + "', namaTransaksi = '"
                    + namaTransaksi + "', menuTransaksi = '" + menuTransaksi + "', mejaTransaksi = '" + mejaTransaksi
                    + "', promoTransaksi = '" + promoTransaksi + "', deskripsiTransaksi = '" + deskripsiTransaksi
                    + "', jumlahTransaksi = '" + jumlahTransaksi + "', hargaTransaksi = '" + hargaTransaksi
                    + "' WHERE idTransaksi ='" + idTransaksi + "'";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Ubah Data karyawan
    public static boolean ubahTransaksiCoffe(int idTransaksi, int idMitra, String namaTransaksi, String menuTransaksi,
            String mejaTransaksi, String promoTransaksi, String deskripsiTransaksi, int jumlahTransaksi,
            int hargaTransaksi, String bayarTransaksi) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tbltransaksiCoffe SET idMitra = '" + idMitra + "', namaTransaksi = '"
                    + namaTransaksi + "', menuTransaksi = '" + menuTransaksi + "', mejaTransaksi = '" + mejaTransaksi
                    + "', promoTransaksi = '" + promoTransaksi + "', deskripsiTransaksi = '" + deskripsiTransaksi
                    + "', jumlahTransaksi = '" + jumlahTransaksi + "', hargaTransaksi = '" + hargaTransaksi
                    + "' WHERE idTransaksi ='" + idTransaksi + "'";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // Ubah Data karyawan
    public static boolean ubahTransaksiNonCoffe(int idTransaksi, int idMitra, String namaTransaksi, String menuTransaksi,
            String mejaTransaksi, String promoTransaksi, String deskripsiTransaksi, int jumlahTransaksi,
            int hargaTransaksi, String bayarTransaksi) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tbltransaksinoncoffe SET idMitra = '" + idMitra + "', namaTransaksi = '"
                    + namaTransaksi + "', menuTransaksi = '" + menuTransaksi + "', mejaTransaksi = '" + mejaTransaksi
                    + "', promoTransaksi = '" + promoTransaksi + "', deskripsiTransaksi = '" + deskripsiTransaksi
                    + "', jumlahTransaksi = '" + jumlahTransaksi + "', hargaTransaksi = '" + hargaTransaksi
                    + "' WHERE idTransaksi ='" + idTransaksi + "'";

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // hapus data Menu
    public static boolean hapusDataMenuMakanan(int idMenu) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "DELETE FROM tblmenumakanan WHERE idMenu = " + idMenu;

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    // hapus data Menu
    public static boolean hapusDataMenuCoffe(int idMenu) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "DELETE FROM tblmenucoffe WHERE idMenu = " + idMenu;

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    // hapus data Menu
    public static boolean hapusDataMenuNonCoffe(int idMenu) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "DELETE FROM tblmenunoncoffe WHERE idMenu = " + idMenu;

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    // hapus data Promo
    public static boolean hapusDataPromo(int idPromo) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "DELETE FROM tblpromo WHERE idPromo = " + idPromo;

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    // hapus data Karyawan
    public static boolean hapusDataMeja(int idMeja) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "DELETE FROM tblmeja WHERE idMeja = " + idMeja;

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    // hapus data Karyawan
    public static boolean hapusDataKaryawan(int idKaryawan) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "DELETE FROM tblkaryawan WHERE idKaryawan = " + idKaryawan;

            if (statement.executeUpdate(query) > 0) {
                data = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    // get All Menu Promo
    public static ArrayList<String> getAllMenuPromo() {
        connection();

        ArrayList<String> menuPromo = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu Promo from vwallmenumakanan
            String queryMakanan = "SELECT namaMenu FROM vwallmenumakanan";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                menuPromo.add(resultDataMakanan.getString("namaMenu"));
            }

            // Query to get menu Promo from vwallmenucoffe
            String queryCoffe = "SELECT namaMenu FROM vwallmenucoffe";
            ResultSet resultDataCoffe = statement.executeQuery(queryCoffe);
            while (resultDataCoffe.next()) {
                menuPromo.add(resultDataCoffe.getString("namaMenu"));
            }
            // Query to get menu Promo from vwallmenunoncoffe
            String queryNonCoffe = "SELECT namaMenu FROM vwallmenunoncoffe";
            ResultSet resultDataNonCoffe = statement.executeQuery(queryNonCoffe);
            while (resultDataNonCoffe.next()) {
                menuPromo.add(resultDataNonCoffe.getString("namaMenu"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuPromo;
    }

    // get All Menu Makanan
    public static ArrayList<String> getAllMenuTransaksiMakanan() {
        connection();

        ArrayList<String> menuMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT namaMenu FROM vwallmenumakanan";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                menuMakanan.add(resultDataMakanan.getString("namaMenu"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuMakanan;
    }

    // get All Menu Makanan
    public static ArrayList<String> getAllMenuTransaksiUbahMakanan() {
        connection();

        ArrayList<String> menuMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT namaMenu FROM vwallmenumakanan";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                menuMakanan.add(resultDataMakanan.getString("namaMenu"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuMakanan;
    }

    // get All Menu Makanan
    public static ArrayList<String> getAllMenuTransaksiCoffe() {
        connection();

        ArrayList<String> menuCoffe = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenuCoffe
            String queryCoffe = "SELECT namaMenu FROM vwallmenuCoffe";
            ResultSet resultDataCoffe = statement.executeQuery(queryCoffe);
            while (resultDataCoffe.next()) {
                menuCoffe.add(resultDataCoffe.getString("namaMenu"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuCoffe;
    }

    // get All Menu Makanan
    public static ArrayList<String> getAllMenuTransaksiUbahCoffe() {
        connection();

        ArrayList<String> menuCoffe = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenuCoffe
            String queryCoffe = "SELECT namaMenu FROM vwallmenuCoffe";
            ResultSet resultDataCoffe = statement.executeQuery(queryCoffe);
            while (resultDataCoffe.next()) {
                menuCoffe.add(resultDataCoffe.getString("namaMenu"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuCoffe;
    }

    // get All Menu Makanan
    public static ArrayList<String> getAllMenuTransaksiNonCoffe() {
        connection();

        ArrayList<String> menuCoffe = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenuCoffe
            String queryCoffe = "SELECT namaMenu FROM vwallmenunoncoffe";
            ResultSet resultDataCoffe = statement.executeQuery(queryCoffe);
            while (resultDataCoffe.next()) {
                menuCoffe.add(resultDataCoffe.getString("namaMenu"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuCoffe;
    }

    // get All Menu Makanan
    public static ArrayList<String> getAllMenuTransaksiUbahNonCoffe() {
        connection();

        ArrayList<String> menuCoffe = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenuCoffe
            String queryCoffe = "SELECT namaMenu FROM vwallmenunoncoffe";
            ResultSet resultDataCoffe = statement.executeQuery(queryCoffe);
            while (resultDataCoffe.next()) {
                menuCoffe.add(resultDataCoffe.getString("namaMenu"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuCoffe;
    }

    // get All Meja Transakasi Makanan
    public static ArrayList<String> getAllMejaTransaksiMakanan() {
        connection();

        ArrayList<String> mejaMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT jenisMeja FROM vwallmeja";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                mejaMakanan.add(resultDataMakanan.getString("jenisMeja"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mejaMakanan;
    }

    // get All Meja Transakasi Makanan
    public static ArrayList<String> getAllMejaTransaksiUbahMakanan() {
        connection();

        ArrayList<String> mejaMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT jenisMeja FROM vwallmeja";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                mejaMakanan.add(resultDataMakanan.getString("jenisMeja"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mejaMakanan;
    }

    // get All Meja Transakasi Coffe
    public static ArrayList<String> getAllMejaTransaksiCoffe() {
        connection();

        ArrayList<String> mejaCoffe = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenuCoffe
            String queryCoffe = "SELECT jenisMeja FROM vwallmeja";
            ResultSet resultDataCoffe = statement.executeQuery(queryCoffe);
            while (resultDataCoffe.next()) {
                mejaCoffe.add(resultDataCoffe.getString("jenisMeja"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mejaCoffe;
    }

    // get All Meja Transakasi Coffe
    public static ArrayList<String> getAllMejaTransaksiUbahCoffe() {
        connection();

        ArrayList<String> mejaCoffe = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenuCoffe
            String queryCoffe = "SELECT jenisMeja FROM vwallmeja";
            ResultSet resultDataCoffe = statement.executeQuery(queryCoffe);
            while (resultDataCoffe.next()) {
                mejaCoffe.add(resultDataCoffe.getString("jenisMeja"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mejaCoffe;
    }

    // get All Meja Transakasi Non Coffe
    public static ArrayList<String> getAllMejaTransaksiNonCoffe() {
        connection();

        ArrayList<String> mejaCoffe = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenuCoffe
            String queryCoffe = "SELECT jenisMeja FROM vwallmeja";
            ResultSet resultDataCoffe = statement.executeQuery(queryCoffe);
            while (resultDataCoffe.next()) {
                mejaCoffe.add(resultDataCoffe.getString("jenisMeja"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mejaCoffe;
    }

    // get All Meja Transakasi Non Coffe
    public static ArrayList<String> getAllMejaTransaksiUbahNonCoffe() {
        connection();

        ArrayList<String> mejaCoffe = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenuCoffe
            String queryCoffe = "SELECT jenisMeja FROM vwallmeja";
            ResultSet resultDataCoffe = statement.executeQuery(queryCoffe);
            while (resultDataCoffe.next()) {
                mejaCoffe.add(resultDataCoffe.getString("jenisMeja"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mejaCoffe;
    }

    // get All Promo Transaksi Makanan
    public static ArrayList<String> getAllPromoTransaksiMakanan() {
        connection();

        ArrayList<String> promoMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT namaPromo FROM vwallpromo";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                promoMakanan.add(resultDataMakanan.getString("namaPromo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promoMakanan;
    }

    // get All Promo Transaksi Makanan
    public static ArrayList<String> getAllPromoTransaksiUbahMakanan() {
        connection();

        ArrayList<String> promoMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT namaPromo FROM vwallpromo";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                promoMakanan.add(resultDataMakanan.getString("namaPromo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promoMakanan;
    }

    // get All Promo Transaksi Makanan
    public static ArrayList<String> getAllPromoTransaksiCoffe() {
        connection();

        ArrayList<String> promoMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT namaPromo FROM vwallpromo";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                promoMakanan.add(resultDataMakanan.getString("namaPromo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promoMakanan;
    }

    // get All Promo Transaksi Makanan
    public static ArrayList<String> getAllPromoTransaksiUbahCoffe() {
        connection();

        ArrayList<String> promoMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT namaPromo FROM vwallpromo";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                promoMakanan.add(resultDataMakanan.getString("namaPromo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promoMakanan;
    }

    // get All Promo Transaksi non coffe
    public static ArrayList<String> getAllPromoTransaksiNonCoffe() {
        connection();

        ArrayList<String> promoMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT namaPromo FROM vwallpromo";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                promoMakanan.add(resultDataMakanan.getString("namaPromo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promoMakanan;
    }

    // get All Promo Transaksi non coffe
    public static ArrayList<String> getAllPromoTransaksiUbahNonCoffe() {
        connection();

        ArrayList<String> promoMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT namaPromo FROM vwallpromo";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                promoMakanan.add(resultDataMakanan.getString("namaPromo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promoMakanan;
    }

    public static int getHargaMenuMakanan(String namaMenu) {
        connection();

        int hargaMenu = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaMenu FROM vwallmenumakanan WHERE namaMenu = '" + namaMenu + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaMenu = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaMenu;
    }

    public static int getHargaMenuUbahMakanan(String namaMenu) {
        connection();

        int hargaMenu = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaMenu FROM vwallmenumakanan WHERE namaMenu = '" + namaMenu + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaMenu = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaMenu;
    }

    public static int getHargaMenuCoffe(String namaMenu) {
        connection();

        int hargaMenu = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaMenu FROM vwallmenucoffe WHERE namaMenu = '" + namaMenu + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaMenu = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaMenu;
    }

    public static int getHargaMenuUbahCoffe(String namaMenu) {
        connection();

        int hargaMenu = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaMenu FROM vwallmenucoffe WHERE namaMenu = '" + namaMenu + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaMenu = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaMenu;
    }

    public static int getHargaMenuNonCoffe(String namaMenu) {
        connection();

        int hargaMenu = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaMenu FROM vwallmenunoncoffe WHERE namaMenu = '" + namaMenu + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaMenu = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaMenu;
    }

    public static int getHargaMenuUbahNonCoffe(String namaMenu) {
        connection();

        int hargaMenu = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaMenu FROM vwallmenunoncoffe WHERE namaMenu = '" + namaMenu + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaMenu = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaMenu;
    }

    public static int getPromoMenuMakanan(String menuPromo) {
        connection();

        int hargaPromo = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaPromo FROM vwallpromo WHERE menuPromo = '" + menuPromo + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }

    public static int getPromoMenuUbahMakanan(String menuPromo) {
        connection();

        int hargaPromo = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaPromo FROM vwallpromo WHERE menuPromo = '" + menuPromo + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }

    public static int getPromoMenuCoffe(String menuPromo) {
        connection();

        int hargaPromo = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaPromo FROM vwallpromo WHERE menuPromo = '" + menuPromo + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }

    public static int getPromoMenuUbahCoffe(String menuPromo) {
        connection();

        int hargaPromo = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaPromo FROM vwallpromo WHERE menuPromo = '" + menuPromo + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }

    public static int getPromoMenuNonCoffe(String menuPromo) {
        connection();

        int hargaPromo = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaPromo FROM vwallpromo WHERE menuPromo = '" + menuPromo + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }

    public static int getPromoMenuUbahNonCoffe(String menuPromo) {
        connection();

        int hargaPromo = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaPromo FROM vwallpromo WHERE menuPromo = '" + menuPromo + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaMenu");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }
}
