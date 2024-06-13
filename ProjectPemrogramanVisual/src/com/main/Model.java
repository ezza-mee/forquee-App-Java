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

    // get data all promo
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

    // get data all menu coffe
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

}
