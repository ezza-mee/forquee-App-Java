package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    // Count All Data menu from 3 virtual tables
    public static int getCountAllDataMenu() {
        connection();

        int count = 0;

        try {
            statement = connect.createStatement();

            // Query untuk menghitung jumlah data dari masing-masing tabel virtual
            String query = "(SELECT COUNT(*) FROM vwallmenumakanan) " +
                    "UNION ALL " +
                    "(SELECT COUNT(*) FROM vwallmenucoffe) " +
                    "UNION ALL " +
                    "(SELECT COUNT(*) FROM vwallmenunoncoffe)";

            ResultSet resultData = statement.executeQuery(query);

            // Mengakumulasi jumlah data dari setiap hasil query
            while (resultData.next()) {
                count += resultData.getInt(1);
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // count All Data Meja
    public static int getCountAllDataMeja() {

        connection();

        int count = 0;

        try {

            statement = connect.createStatement();

            String query = "SELECT COUNT(*) FROM vwallmeja";

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            count = resultData.getInt(1);

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    // count All Data promo
    public static int getCountAllDataPromo() {

        connection();

        int count = 0;

        try {

            statement = connect.createStatement();

            String query = "SELECT COUNT(*) FROM vwallpromo";

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            count = resultData.getInt(1);

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    // count All Data Customer
    public static int getCountAllDataCustomer() {

        connection();

        int count = 0;

        try {

            statement = connect.createStatement();

            String query = "SELECT COUNT(*) FROM vwallcustomer";

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            count = resultData.getInt(1);

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    // count All Data Karyawan
    public static int getCountAllDataKaryawan() {

        connection();

        int count = 0;

        try {

            statement = connect.createStatement();

            String query = "SELECT COUNT(*) FROM vwkaryawanverified";

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            count = resultData.getInt(1);

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    // count All Data Order Bahan
    public static int getCountAllDataOrderBahan() {

        connection();

        int count = 0;

        try {

            statement = connect.createStatement();

            String query = "SELECT COUNT(*) FROM vworderbahandiproses";

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            count = resultData.getInt(1);

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    // detail customer
    public static Object[] getDetailCustomer(int idCustomer) {

        connection();

        Object rowData[] = new Object[6];

        try {
            // buat object statement yang diambil dari koneksi
            statement = connect.createStatement();
            // query select
            String query = "SELECT * FROM vwAllcustomer WHERE idCustomer = " + idCustomer;
            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);
            // looping pengisian DefaultTableModel
            resultData.next();
            rowData[0] = resultData.getInt("idCustomer");
            rowData[1] = resultData.getString("namaCustomer");
            rowData[2] = resultData.getString("nomorHpCustomer");
            rowData[3] = resultData.getString("emailCustomer");
            rowData[4] = resultData.getString("alamatCustomer");
            rowData[5] = resultData.getString("passwordCustomer");

            // close statement dan connection
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
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

    // Detail get Data
    public static Object[] getDetailAkunMitra(int idMitra) {
        connection();

        Object rowData[] = new Object[6];

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
            rowData[2] = resultData.getString("nomorHpMitra");
            rowData[3] = resultData.getString("emailMitra");
            rowData[4] = resultData.getString("alamatMitra");
            rowData[5] = resultData.getString("passwordMitra");

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    public static Object[] getDetailMitraByEmail(String email) {
        connection();

        Object rowData[] = new Object[4];

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT * FROM vwallmitra WHERE emailMitra = '" + email + "'";

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            rowData[0] = resultData.getInt("idMitra");
            rowData[1] = resultData.getString("namaMitra");
            rowData[2] = resultData.getString("nomorHpMitra");
            rowData[3] = resultData.getString("emailMitra");

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowData;

    }

    // data calon mitra static function
    public static DefaultTableModel getAllMitraVerified() {

        connection();

        String[] dataHeader = { "ID", "Nama", "Nomor Hp", "Email", "Alamat", "Password", "Status Terverifikasi",
                "Status" };
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwmitraverified";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("nomorHpMitra"),
                        resultData.getString("emailMitra"),
                        resultData.getString("alamatMitra"),
                        resultData.getString("passwordMitra"),
                        resultData.getString("statusTerverifikasi"),
                        resultData.getString("statusAktif") };
                tm.addRow(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static boolean verifyAkunMitra(String email, String password) {
        connection();
        boolean available = false;

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT COUNT(*) FROM vwallmitra WHERE emailMitra = '" + email
                    + "' AND passwordMitra = '" + password + "'";

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            if (resultData.getInt(1) == 1) {
                available = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }

    // daftar Customer
    public static boolean daftarMitra(String nama, String nomorHp, String email, String password) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "INSERT INTO tblmitra VALUES (NULL, '" + nama + "', '" + nomorHp + "','"
                    + email + "', '' ,'" + password
                    + "', 'Verified', 'Aktif')";

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

    public static boolean verifyEmailMitra(String email) {
        connection();
        boolean available = false;

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT COUNT(*) FROM vwallMitra WHERE emailMitra = '" + email + "'";

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            if (resultData.getInt(1) == 0) {
                available = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }

    // selesai transaksi print
    public static boolean adminVerifikasiCalonMitra(int idMitra) {

        boolean data = false;

        connection();

        try {
            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblmitra SET statusTerverifikasi = 'Terverifikasi' WHERE idMitra = " + idMitra;

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
                Object[] rowData = { "FM" + resultData.getInt("idMenu"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuMenu"),
                        resultData.getString("namaMenu"),
                        resultData.getInt("jumlahMenu"),
                        "Rp. " + resultData.getInt("hargaMenu"),
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
                Object[] rowData = { "FM" + resultData.getInt("idMenu"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuMenu"),
                        resultData.getString("namaMenu"),
                        resultData.getInt("jumlahMenu"),
                        "Rp. " + resultData.getInt("hargaMenu"),
                        resultData.getString("deskripsiMenu"),
                        resultData.getString("statusMenu") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
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
                Object[] rowData = { "FM" + resultData.getInt("idMenu"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuMenu"),
                        resultData.getString("namaMenu"),
                        resultData.getInt("jumlahMenu"),
                        "Rp. " + resultData.getInt("hargaMenu"),
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
    public static Object[] getDetailPromo(int idPromo) {

        connection();

        Object[] rowData = new Object[10];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwallpromo WHERE idPromo = " + idPromo;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idPromo");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuPromo");
            rowData[4] = resultData.getString("namaPromo");
            rowData[5] = resultData.getString("namaMenu");
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

    // detail data Karyawan Verified
    public static Object[] getDetailKaryawanVerified(int idKaryawan) {

        connection();

        Object[] rowData = new Object[11];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwkaryawanverified WHERE idKaryawan = " + idKaryawan;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idKaryawan");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaKaryawan");
            rowData[3] = resultData.getString("waktuKaryawan");
            rowData[4] = resultData.getString("namaKaryawan");
            rowData[5] = resultData.getString("nomorHpKaryawan");
            rowData[6] = resultData.getString("emailKaryawan");
            rowData[7] = resultData.getString("jobdeskKaryawan");
            rowData[8] = resultData.getString("alamatKaryawan");
            rowData[9] = resultData.getString("statusTerverifikasi");
            rowData[10] = resultData.getString("statusAktif");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data Karyawan Verified
    public static Object[] getDetailKaryawanTerverifikasi(int idKaryawan) {

        connection();

        Object[] rowData = new Object[11];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwkaryawanterverifikasi WHERE idKaryawan = " + idKaryawan;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idKaryawan");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaKaryawan");
            rowData[3] = resultData.getString("waktuKaryawan");
            rowData[4] = resultData.getString("namaKaryawan");
            rowData[5] = resultData.getString("nomorHpKaryawan");
            rowData[6] = resultData.getString("emailKaryawan");
            rowData[7] = resultData.getString("jobdeskKaryawan");
            rowData[8] = resultData.getString("alamatKaryawan");
            rowData[9] = resultData.getString("statusTerverifikasi");
            rowData[10] = resultData.getString("statusAktif");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data Menu Makanan
    public static Object[] getDetailTransaksiDiproses(int idTransaksi) {

        connection();

        Object[] rowData = new Object[20];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksidiproses WHERE idTransaksi = " + idTransaksi;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idTransaksi");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuTransaksi");
            rowData[4] = resultData.getString("namaTransaksi");
            rowData[5] = resultData.getString("makananTransaksi");
            rowData[6] = resultData.getString("coffeTransaksi");
            rowData[7] = resultData.getString("nonCoffeTransaksi");
            rowData[8] = resultData.getInt("jumlahMakanan");
            rowData[9] = resultData.getInt("jumlahCoffe");
            rowData[10] = resultData.getInt("jumlahNonCoffe");
            rowData[11] = resultData.getInt("hargaMakanan");
            rowData[12] = resultData.getInt("hargaCoffe");
            rowData[13] = resultData.getInt("hargaNonCoffe");
            rowData[14] = resultData.getString("promoTransaksi");
            rowData[15] = resultData.getString("mejaTransaksi");
            rowData[16] = resultData.getString("deskripsiTransaksi");
            rowData[17] = resultData.getInt("hargaTransaksi");
            rowData[18] = resultData.getString("bayarTransaksi");
            rowData[19] = resultData.getString("statusTransaksi");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data Menu Makanan
    public static Object[] getDetailTransaksiSelesai(int idTransaksi) {

        connection();

        Object[] rowData = new Object[20];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksiselesai WHERE idTransaksi = " + idTransaksi;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idTransaksi");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuTransaksi");
            rowData[4] = resultData.getString("namaTransaksi");
            rowData[5] = resultData.getString("makananTransaksi");
            rowData[6] = resultData.getString("coffeTransaksi");
            rowData[7] = resultData.getString("nonCoffeTransaksi");
            rowData[8] = resultData.getInt("jumlahMakanan");
            rowData[9] = resultData.getInt("jumlahCoffe");
            rowData[10] = resultData.getInt("jumlahNonCoffe");
            rowData[11] = resultData.getInt("hargaMakanan");
            rowData[12] = resultData.getInt("hargaCoffe");
            rowData[13] = resultData.getInt("hargaNonCoffe");
            rowData[14] = resultData.getString("promoTransaksi");
            rowData[15] = resultData.getString("mejaTransaksi");
            rowData[16] = resultData.getString("deskripsiTransaksi");
            rowData[17] = resultData.getInt("hargaTransaksi");
            rowData[18] = resultData.getString("bayarTransaksi");
            rowData[19] = resultData.getString("statusTransaksi");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data order bahan
    public static Object[] getDetailOrderBahanDiproses(int idOrder) {

        connection();

        Object[] rowData = new Object[11];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vworderbahandiproses WHERE idOrder = " + idOrder;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idOrder");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuOrder");
            rowData[4] = resultData.getString("bahanOrder");
            rowData[5] = resultData.getString("ptOrder");
            rowData[6] = resultData.getString("deskripsiOrder");
            rowData[7] = resultData.getString("alamatOrder");
            rowData[8] = resultData.getInt("jumlahOrder");
            rowData[9] = resultData.getInt("hargaOrder");
            rowData[10] = resultData.getString("statusOrder");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // detail data order bahan
    public static Object[] getDetailOrderBahanSelesai(int idOrder) {

        connection();

        Object[] rowData = new Object[11];

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM vworderbahanselesai WHERE idOrder = " + idOrder;

            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("idOrder");
            rowData[1] = resultData.getInt("idMitra");
            rowData[2] = resultData.getString("namaMitra");
            rowData[3] = resultData.getString("waktuOrder");
            rowData[4] = resultData.getString("bahanOrder");
            rowData[5] = resultData.getString("ptOrder");
            rowData[6] = resultData.getString("deskripsiOrder");
            rowData[7] = resultData.getString("alamatOrder");
            rowData[8] = resultData.getInt("jumlahOrder");
            rowData[9] = resultData.getInt("hargaOrder");
            rowData[10] = resultData.getString("statusOrder");

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    // get data all Promo
    public static DefaultTableModel getAllPromo() {

        connection();

        String[] dataHeader = { "ID", "ID Mitra", "Mitra", "Waktu", "Nama", "Menu", "Jumlah", "harga", "Deskripsi",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallpromo";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "FP" + resultData.getInt("idPromo"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuPromo"),
                        resultData.getString("namaPromo"),
                        resultData.getString("namaMenu"),
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

        String[] dataHeader = { "ID Meja", "ID Mitra", "Mitra", "Waktu", "Nomor", "Jenis", "Deskripsi",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmeja";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "FN" + resultData.getInt("idMeja"),
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

    // get data all Meja
    public static DefaultTableModel getAllMejaReady() {

        connection();

        String[] dataHeader = { "ID Meja", "ID Mitra", "Mitra", "Waktu", "kode", "Jenis", "Deskripsi",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmejaready";

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

    public static boolean verifyAkunCustomer(String email, String password) {
        connection();
        boolean available = false;

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT COUNT(*) FROM vwallcustomer WHERE emailCustomer = '" + email
                    + "' AND passwordCustomer = '" + password + "'";

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            if (resultData.getInt(1) == 1) {
                available = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }

    public static Object[] getDetailCustomerByEmail(String email) {
        connection();

        Object rowData[] = new Object[4];

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT * FROM vwallcustomer WHERE emailCustomer =  '" + email + "'";

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            rowData[0] = resultData.getInt("idCustomer");
            rowData[1] = resultData.getString("namaCustomer");
            rowData[2] = resultData.getString("nomorHpCustomer");
            rowData[3] = resultData.getString("emailCustomer");

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowData;

    }

    public static boolean verifyEmailCustomer(String email) {
        connection();
        boolean available = false;

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT COUNT(*) FROM vwallcustomer WHERE emailCustomer = '" + email + "'";

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            if (resultData.getInt(1) == 0) {
                available = true;
            }

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }

    // daftar Customer
    public static boolean daftarCustomer(String nama, String nomorHp, String email, String password) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "INSERT INTO tblcustomer VALUES (NULL, '" + nama + "', '" + nomorHp + "','"
                    + email + "', '' ,'" + password
                    + "', 'Aktif')";

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

    public static int getCountCustomerByEmail(String email) {
        connection();
        int count = 0;

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT COUNT(*) FROM tblcustomer WHERE emailCustomer = '" + email + "'";

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            count = resultData.getInt(1);

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getCountMitraByEmail(String email) {
        connection();
        int count = 0;

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "SELECT COUNT(*) FROM tblmitra WHERE emailMitra = '" + email + "'";

            // eksekusi query-nya
            ResultSet resultData = statement.executeQuery(query);

            // looping pengisian DefaultTableModel
            resultData.next();
            count = resultData.getInt(1);

            // close statement dan connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    // untuk ubah akun customer
    public static boolean ubahProfileCustomer(int idCustomer, String namaCustomer, String nomorHpCustomer,
            String emailCustomer,
            String alamatCustomer, String passwordCustomer) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblcustomer SET namaCustomer = '" + namaCustomer + "', nomorHpCustomer = '"
                    + nomorHpCustomer + "', emailCustomer = '" + emailCustomer + "', alamatCustomer = '"
                    + alamatCustomer + "', passwordCustomer = '"
                    + passwordCustomer + "' WHERE idCustomer = " + idCustomer;

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

    // untuk ubah akun Mitra
    public static boolean ubahProfileMitra(int idMitra, String namaMitra, String nomorHpMitra,
            String emailMitra,
            String alamatMitra, String passwordMitra) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblmitra SET namaMitra = '" + namaMitra + "', nomorHpMitra = '"
                    + nomorHpMitra + "', emailMitra = '" + emailMitra + "', alamatMitra = '"
                    + alamatMitra + "', passwordMitra = '"
                    + passwordMitra + "' WHERE idMitra = " + idMitra;

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

    // get data all karyawan verified
    public static DefaultTableModel getAllKaryawanVerified() {

        connection();

        String[] dataHeader = { "ID Karyawan", "ID Mitra", "Mitra", "waktu", "Nama", " Email", "Nomor Hp", "Alamat",
                "Status",
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
    public static DefaultTableModel getAllKaryawantTerverifikasi() {

        connection();

        String[] dataHeader = { "ID Karyawan", "ID Mitra", "Mitra", "waktu", "Nama", " Email", "Nomor Hp", "Alamat",
                "Status",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwkaryawanterverifikasi";

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

    // selesai transaksi print
    public static boolean adminVerifikasiCalonKaryawan(int idKaryawan) {

        boolean data = false;

        connection();

        try {
            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblkaryawan SET statusTerverifikasi = 'Terverifikasi' WHERE idKaryawan = "
                    + idKaryawan;

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

    // get data all Transaksi Diproses
    public static DefaultTableModel getAllTransaksiDiproses() {

        connection();

        String[] dataHeader = { "ID", "ID Mitra", "Mitra", "waktu", "Nama Pemesan", "Menu",
                "Menu", "Menu", "Jumlah", "Jumlah", "Jumlah", "Harga",
                "Harga", "Harga", "Promo", "Nomor Meja", "Deskripsi", "Total Harga", "Pembayaran",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksidiproses ORDER BY idTransaksi DESC";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "TR" + resultData.getInt("idTransaksi"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuTransaksi"),
                        resultData.getString("namaTransaksi"),
                        resultData.getString("makananTransaksi"),
                        resultData.getString("coffeTransaksi"),
                        resultData.getString("nonCoffeTransaksi"),
                        resultData.getInt("jumlahMakanan"),
                        resultData.getInt("jumlahCoffe"),
                        resultData.getInt("jumlahNonCoffe"),
                        "Rp. " + resultData.getInt("hargaMakanan"),
                        "Rp. " + resultData.getInt("hargaCoffe"),
                        "Rp. " + resultData.getInt("hargaNonCoffe"),
                        resultData.getString("promoTransaksi"),
                        resultData.getString("mejaTransaksi"),
                        resultData.getString("deskripsiTransaksi"),
                        "Rp. " + resultData.getInt("hargaTransaksi"),
                        resultData.getString("bayarTransaksi"),
                        resultData.getString("statusTransaksi") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // get data all Transaksi Selesai
    public static DefaultTableModel getAllTransaksiSelesai() {

        connection();

        String[] dataHeader = { "ID", "ID Mitra", "Mitra", "waktu", "Nama Pemesan", "Menu",
                "Menu", "Menu", "Jumlah", "Jumlah", "Jumlah", "Harga",
                "Harga", "Harga", "Promo", "Nomor Meja", "Deskripsi", "Total Harga", "Pembayaran",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwtransaksiselesai ORDER BY idTransaksi DESC";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "TR" + resultData.getInt("idTransaksi"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuTransaksi"),
                        resultData.getString("namaTransaksi"),
                        resultData.getString("makananTransaksi"),
                        resultData.getString("coffeTransaksi"),
                        resultData.getString("nonCoffeTransaksi"),
                        resultData.getInt("jumlahMakanan"),
                        resultData.getInt("jumlahCoffe"),
                        resultData.getInt("jumlahNonCoffe"),
                        "Rp. " + resultData.getInt("hargaMakanan"),
                        "Rp. " + resultData.getInt("hargaCoffe"),
                        "Rp. " + resultData.getInt("hargaNonCoffe"),
                        resultData.getString("promoTransaksi"),
                        resultData.getString("mejaTransaksi"),
                        resultData.getString("deskripsiTransaksi"),
                        "Rp. " + resultData.getInt("hargaTransaksi"),
                        resultData.getString("bayarTransaksi"),
                        resultData.getString("statusTransaksi") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    // selesai transaksi
    public static boolean mitraProsesTransaksi(int idTransaksi) {

        boolean data = false;

        connection();

        try {
            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tbltransaksi SET statusTransaksi = 'Selesai' WHERE idTransaksi = " + idTransaksi;

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

    // selesai transaksi print
    public static boolean prosesMakanan(int idTransaksi, int idMitra) {

        boolean data = false;

        connection();

        try {
            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tbltransaksimakanan SET idMitra = " + idMitra
                    + ", statusTransaksi = 'Selesai' WHERE idTransaksi = " + idTransaksi;

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

    // selesai transaksi print
    public static boolean prosesCoffe(int idTransaksi, int idMitra) {

        boolean data = false;

        connection();

        try {
            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tbltransaksicoffe SET idMitra = " + idMitra
                    + ", statusTransaksi = 'Selesai' WHERE idTransaksi = " + idTransaksi;

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

    // selesai transaksi print
    public static boolean prosesNonCoffe(int idTransaksi, int idMitra) {

        boolean data = false;

        connection();

        try {
            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tbltransaksinoncoffe SET idMitra = " + idMitra
                    + ", statusTransaksi = 'Selesai' WHERE idTransaksi = " + idTransaksi;

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

    // selesai transaksi print
    public static boolean saldoMitra(int idMitra, int hargaTransaksi) {

        boolean data = false;

        connection();

        try {
            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblsaldomitra SET saldoMitra = saldoMitra +" + hargaTransaksi + " WHERE idMitra = "
                    + idMitra;

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

    // insert data karyawan
    public static boolean tambahOrderBahan(int idMitra, String bahanOrder, String ptOrder, String deskripsiOrder,
            String alamatOrder, int jumlahOrder, int hargaOrder) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            // Tambahkan tanda kutip untuk nilai string dan tambahkan koma antara nilai
            String query = "INSERT INTO tblorderbahan VALUES (NULL, '" + idMitra + "', NOW(), '" + bahanOrder + "', '"
                    + ptOrder + "', '" + deskripsiOrder + "', '" + alamatOrder + "', '" + jumlahOrder + "', '"
                    + hargaOrder + "', 'Diproses')";

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

    // insert transaksi
    public static boolean tambahTransaksi(int idMitra, String namaTransaksi, String makananTransaksi,
            String coffeTransaksi, String nonCoffeTransaksi, int jumlahMakanan, int jumlahCoffe, int jumlahNonCoffe,
            int hargaMakanan, int hargaCoffe, int hargaNonCoffe, String promoTransaksi, String mejaTransaksi,
            String deskripsiTransaksi, int hargaTransaksi, String bayarTransaksi) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            // Tambahkan tanda kutip untuk nilai string dan tambahkan koma antara nilai
            String query = "INSERT INTO tbltransaksi VALUES (NULL, '" + idMitra + "', NOW(), '" + namaTransaksi
                    + "', '" + makananTransaksi + "', '" + coffeTransaksi + "', '" + nonCoffeTransaksi + "', '"
                    + jumlahMakanan + "', '" + jumlahCoffe + "', '" + jumlahNonCoffe + "', '" + hargaMakanan + "', '"
                    + hargaCoffe + "', '" + hargaNonCoffe + "', '" + promoTransaksi + "', '" + mejaTransaksi + "', '"
                    + deskripsiTransaksi + "', '" + hargaTransaksi + "', '" + bayarTransaksi
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

    // Ubah Data Meja
    public static boolean ubahDataPromo(int idPromo, int idMitra, String namaPromo, String namaMenu,
            int jumlahPromo, int hargaPromo, String deskripsiPromo) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblpromo SET idMitra = '" + idMitra + "', namaPromo = '"
                    + namaPromo + "', namaMenu = '" + namaMenu + "',  jumlahPromo = '" + jumlahPromo
                    + "',  hargaPromo = '" + hargaPromo + "', deskripsiPromo = '" + deskripsiPromo
                    + "' WHERE idPromo ='" + idPromo + "'";

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
    public static boolean ubahDataTerverifikasi(int idKaryawan, int idMitra, String namaKaryawan,
            String nomorHpKaryawan, String emailKaryawan, String jobdeskKaryawan, String alamatKaryawan) {

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

    // ubah Data Transaksi
    public static boolean ubahDataTransaksi(int idTransaksi, int idMitra, String namaTransaksi, String makananTransaksi,
            String coffeTransaksi, String nonCoffeTransaksi, int jumlahMakanan, int jumlahCoffe, int jumlahNonCoffe,
            int hargaMakanan, int hargaCoffe, int hargaNonCoffe, String promoTransaksi, String mejaTransaksi,
            String deskripsiTransaksi, int hargaTransaksi, String bayarTransaksi) {

        boolean data = false;

        connection();

        try {
            statement = connect.createStatement();

            // Update query dengan idTransaksi sebagai kondisi
            String query = "UPDATE tbltransaksi SET "
                    + "idMitra = '" + idMitra + "', "
                    + "tanggalTransaksi = NOW(), "
                    + "namaTransaksi = '" + namaTransaksi + "', "
                    + "makananTransaksi = '" + makananTransaksi + "', "
                    + "coffeTransaksi = '" + coffeTransaksi + "', "
                    + "nonCoffeTransaksi = '" + nonCoffeTransaksi + "', "
                    + "jumlahMakanan = '" + jumlahMakanan + "', "
                    + "jumlahCoffe = '" + jumlahCoffe + "', "
                    + "jumlahNonCoffe = '" + jumlahNonCoffe + "', "
                    + "hargaMakanan = '" + hargaMakanan + "', "
                    + "hargaCoffe = '" + hargaCoffe + "', "
                    + "hargaNonCoffe = '" + hargaNonCoffe + "', "
                    + "promoTransaksi = '" + promoTransaksi + "', "
                    + "mejaTransaksi = '" + mejaTransaksi + "', "
                    + "deskripsiTransaksi = '" + deskripsiTransaksi + "', "
                    + "hargaTransaksi = '" + hargaTransaksi + "', "
                    + "bayarTransaksi = '" + bayarTransaksi + "', "
                    + "statusTransaksi = 'Diproses' "
                    + "WHERE idTransaksi = '" + idTransaksi + "'";

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

    // Ubah Data Order Bahan
    public static boolean ubahOrderBahan(int idOrder, int idMitra, String bahanOrder, String ptOrder,
            String deskripsiOrder, String alamatOrder, int jumlahOrder, int hargaOrder) {

        boolean data = false;

        connection();

        try {

            // buat object statemenet yang diambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblorderbahan SET idMitra = '" + idMitra + "', bahanOrder = '"
                    + bahanOrder + "', ptOrder = '" + ptOrder + "', deskripsiOrder = '" + deskripsiOrder
                    + "', alamatOrder = '" + alamatOrder + "', alamatOrder = '" + alamatOrder + "', jumlahOrder = '"
                    + jumlahOrder + "', hargaOrder = '" + hargaOrder + "' WHERE idOrder ='" + idOrder + "'";

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

    // selesai transaksi print
    public static boolean adminProsesBahan(int idOrder) {

        boolean data = false;

        connection();

        try {
            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "UPDATE tblorderbahan SET statusOrder = 'Selesai' WHERE idOrder = " + idOrder;

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

    // hapus data Karyawan
    public static boolean hapusDataTransaksiOnline(int idTransaksi) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "DELETE FROM tblmakananonline WHERE idTransaksi = " + idTransaksi;

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

    // hapus data Transaksi
    public static boolean hapusDataTransaksi(int idTransaksi) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "DELETE FROM tbltransaksi WHERE idTransaksi = " + idTransaksi;

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
    public static boolean hapusDataOrderBahan(int idOrder) {
        boolean data = false;

        connection();

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // query select
            String query = "DELETE FROM tblorderbahan WHERE idOrder = " + idOrder;

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
    public static ArrayList<String> getAllMejaTransaksi() {
        connection();

        ArrayList<String> mejaMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT nomorMeja FROM vwallmeja";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                mejaMakanan.add(resultDataMakanan.getString("nomorMeja"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mejaMakanan;
    }

    // get All Meja Transakasi Makanan
    public static ArrayList<String> getAllUbahMejaTransaksi() {
        connection();

        ArrayList<String> mejaMakanan = new ArrayList<>();

        try {
            statement = connect.createStatement();

            // Query to get menu names from vwallmenumakanan
            String queryMakanan = "SELECT nomorMeja FROM vwallmeja";
            ResultSet resultDataMakanan = statement.executeQuery(queryMakanan);
            while (resultDataMakanan.next()) {
                mejaMakanan.add(resultDataMakanan.getString("nomorMeja"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mejaMakanan;
    }

    // get All Promo Transaksi Makanan
    public static ArrayList<String> getAllPromoTransaksi() {
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
    public static ArrayList<String> getAllUbahPromoTransaksi() {
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

    public static int getPromoMakanan(String namaMenu, String promo) {
        connection();

        int hargaPromo = 0;

        try {
            String query = "SELECT p.hargaPromo " +
                    "FROM vwallpromo p " +
                    "JOIN vwallmenumakanan mm ON p.namaMenu = mm.namaMenu " +
                    "WHERE mm.namaMenu = ? AND p.namaPromo = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, namaMenu);
            preparedStatement.setString(2, promo);

            ResultSet resultData = preparedStatement.executeQuery();

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaPromo");
            }

            preparedStatement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }

    public static int getPromoCoffe(String namaMenu, String promo) {
        connection();

        int hargaPromo = 0;

        try {
            String query = "SELECT p.hargaPromo " +
                    "FROM vwallpromo p " +
                    "JOIN vwallmenucoffe mm ON p.namaMenu = mm.namaMenu " +
                    "WHERE mm.namaMenu = ? AND p.namaPromo = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, namaMenu);
            preparedStatement.setString(2, promo);

            ResultSet resultData = preparedStatement.executeQuery();

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaPromo");
            }

            preparedStatement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }

    public static int getPromoNonCoffe(String namaMenu, String promo) {
        connection();

        int hargaPromo = 0;

        try {
            String query = "SELECT p.hargaPromo " +
                    "FROM vwallpromo p " +
                    "JOIN vwallmenunoncoffe mm ON p.namaMenu = mm.namaMenu " +
                    "WHERE mm.namaMenu = ? AND p.namaPromo = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, namaMenu);
            preparedStatement.setString(2, promo);

            ResultSet resultData = preparedStatement.executeQuery();

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaPromo");
            }

            preparedStatement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }

    public static int getPromoUbahTransaksi(String menuPromo) {
        connection();

        int hargaPromo = 0;

        try {
            statement = connect.createStatement();
            String query = "SELECT hargaPromo FROM vwallpromo WHERE menuPromo = '" + menuPromo + "'";
            ResultSet resultData = statement.executeQuery(query);

            if (resultData.next()) {
                hargaPromo = resultData.getInt("hargaPromo");
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hargaPromo;
    }

    // Search Menu Makanan
    public static DefaultTableModel getCariMenuMakanan(String keyword) {

        connection();

        String[] dataHeader = { "ID ", "ID Mitra", "Mitra", "Waktu", "Menu", "Jumlah", "Harga", "Deskripsi", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmenumakanan WHERE namaMitra LIKE '%" + keyword
                    + "%' OR waktuMenu LIKE '%" + keyword + "%' OR namaMenu LIKE '%" + keyword
                    + "%' OR jumlahMenu LIKE '%" + keyword + "%'OR hargaMenu LIKE '%" + keyword
                    + "%' OR deskripsiMenu LIKE '%" + keyword + "%' OR statusMenu LIKE '%" + keyword + "%' ";

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

    // Search Menu Makanan
    public static DefaultTableModel getCariMenuCoffe(String keyword) {

        connection();

        String[] dataHeader = { "ID ", "ID Mitra", "Mitra", "Waktu", "Menu", "Jumlah", "Harga", "Deskripsi", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmenucoffe WHERE namaMitra LIKE '%" + keyword
                    + "%' OR waktuMenu LIKE '%" + keyword + "%' OR namaMenu LIKE '%" + keyword
                    + "%' OR jumlahMenu LIKE '%" + keyword + "%'OR hargaMenu LIKE '%" + keyword
                    + "%' OR deskripsiMenu LIKE '%" + keyword + "%' OR statusMenu LIKE '%" + keyword + "%' ";

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

    // Search Menu Makanan
    public static DefaultTableModel getCariMenuNonCoffe(String keyword) {

        connection();

        String[] dataHeader = { "ID ", "ID Mitra", "Mitra", "Waktu", "Menu", "Jumlah", "Harga", "Deskripsi", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmenunoncoffe WHERE namaMitra LIKE '%" + keyword
                    + "%' OR waktuMenu LIKE '%" + keyword + "%' OR namaMenu LIKE '%" + keyword
                    + "%' OR jumlahMenu LIKE '%" + keyword + "%'OR hargaMenu LIKE '%" + keyword
                    + "%' OR deskripsiMenu LIKE '%" + keyword + "%' OR statusMenu LIKE '%" + keyword + "%' ";

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

    // Search Promo
    public static DefaultTableModel getCariPromo(String keyword) {

        connection();

        String[] dataHeader = { "ID ", "ID Mitra", "Mitra", "Waktu", "Promo", "Menu", "Jumlah", "Harga", "Deskripsi",
                "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallpromo WHERE namaMitra LIKE '%" + keyword
                    + "%' OR waktuPromo LIKE '%" + keyword + "%' OR namaPromo LIKE '%" + keyword
                    + "%' OR namaMenu LIKE '%" + keyword + "%'OR jumlahPromo LIKE '%" + keyword
                    + "%' OR hargaPromo LIKE '%" + keyword + "%' OR deskripsiPromo LIKE '%" + keyword
                    + "%' OR statusPromo LIKE '%" + keyword + "%'";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "FP" + resultData.getInt("idPromo"),
                        resultData.getInt("idMitra"),
                        resultData.getString("namaMitra"),
                        resultData.getString("waktuPromo"),
                        resultData.getString("namaPromo"),
                        resultData.getString("namaMenu"),
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

    // Search Promo
    public static DefaultTableModel getCariMeja(String keyword) {

        connection();

        String[] dataHeader = { "ID ", "ID Mitra", "Mitra", "Waktu", "Nomor", "Jenis", "Deskripsi", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallmeja WHERE namaMitra LIKE '%" + keyword
                    + "%' OR waktuMeja LIKE '%" + keyword + "%' OR nomorMeja LIKE '%" + keyword
                    + "%' OR jenisMeja LIKE '%" + keyword + "%'OR deskripsiMeja LIKE '%" + keyword
                    + "%' OR statusMeja LIKE '%" + keyword + "%'";

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

    // Search data customer
    public static DefaultTableModel getCariDataCustomer(String keyword) {

        connection();

        String[] dataHeader = { "ID ", "Nama", " Email", "Nomor Hp", "Alamat", "Password", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwallcustomer WHERE namaCustomer LIKE '%" + keyword
                    + "%' OR emailCustomer LIKE '%" + keyword + "%' OR nomorHpCustomer LIKE '%" + keyword
                    + "%' OR alamatCustomer LIKE '%" + keyword + "%'OR statusAktif LIKE '%" + keyword + "%' ";

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

    // Search data karyawan
    public static DefaultTableModel getCariDataKaryawanVerified(String keyword) {

        connection();

        String[] dataHeader = { "ID Karyawan", "ID Mitra", "Mitra", "waktu", "Nama", " Email", "Nomor Hp", "Alamat",
                "Status", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwkaryawanverified WHERE namaMitra LIKE '%" + keyword
                    + "%' OR waktuKaryawan LIKE '%" + keyword + "%' OR namaKaryawan LIKE '%" + keyword
                    + "%' OR nomorHpKaryawan LIKE '%" + keyword + "%' OR emailKaryawan LIKE '%" + keyword
                    + "%' OR alamatKaryawan LIKE '%" + keyword + "%' OR statusTerverifikasi LIKE '%" + keyword
                    + "%' OR statusAktif LIKE '%" + keyword + "%' ";

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

    // Search data karyawan
    public static DefaultTableModel getCariDataKaryawanTerverifikasi(String keyword) {

        connection();

        String[] dataHeader = { "ID Karyawan", "ID Mitra", "Mitra", "waktu", "Nama", " Email", "Nomor Hp", "Alamat",
                "Status", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            statement = connect.createStatement();

            String query = "SELECT * FROM vwkaryawanterverifikasi WHERE namaMitra LIKE '%" + keyword
                    + "%' OR waktuKaryawan LIKE '%" + keyword + "%' OR namaKaryawan LIKE '%" + keyword
                    + "%' OR nomorHpKaryawan LIKE '%" + keyword + "%' OR emailKaryawan LIKE '%" + keyword
                    + "%' OR alamatKaryawan LIKE '%" + keyword + "%' OR statusTerverifikasi LIKE '%" + keyword
                    + "%' OR statusAktif LIKE '%" + keyword + "%' ";

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
}
