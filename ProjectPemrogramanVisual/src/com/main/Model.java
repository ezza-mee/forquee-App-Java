package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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

        String[] dataHeader = { "ID Menu", "ID Mitra", "Mitra", "Waktu", "Nama", "Menu", "harga", "Deskripsi",
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
                    + namaMenu + "', jumlahMenu = '" + jumlahMenu + "', deskripsiMenu = '" + deskripsiMenu
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
                    + namaMenu + "', jumlahMenu = '" + jumlahMenu + "', deskripsiMenu = '" + deskripsiMenu
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
                    + namaMenu + "', jumlahMenu = '" + jumlahMenu + "', deskripsiMenu = '" + deskripsiMenu
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

}
