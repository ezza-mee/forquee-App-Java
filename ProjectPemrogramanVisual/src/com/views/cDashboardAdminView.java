package com.views;

import com.templates.cDashboardApp;
import com.main.Model;
import com.partials.*;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class cDashboardAdminView extends cDashboardApp {

    private boolean statusLogin = false;
    private Integer idSelected = null;

    // sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuDataCustomer = new cSidebarMenu("Data Customer", 70 + 50);
    private cSidebarMenu menuDataMitra = new cSidebarMenu("Data Mitra", 70 + 50 + 50);
    private cSidebarMenu menuOrderBahan = new cSidebarMenu("Order Bahan", 70 + 50 + 50 + 50);
    private cSidebarMenu menuCalonMitra = new cSidebarMenu("Calon Mitra", 70 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuKaryawan = new cSidebarMenu("Calon Karyawan", 70 + 50 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuHistory = new cSidebarMenu("History Transaksi", 70 + 50 + 50 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuHistoryBahan = new cSidebarMenu("History Bahan", 70 + 50 + 50 + 50 + 50 + 50 + 50 + 50);

    // component of date time
    private cDateTime labelDateTimeBeranda = new cDateTime(840, 15, 300);
    private cLabelInfo labelOrderOfflineBeranda = new cLabelInfo("Jumlah Data Order Offline", 40, 40, 400, 40);
    private cBigFont valueOrderOfflineBeranda = new cBigFont("0", 40, 60);
    private cLabelInfo labelCustomerBeranda = new cLabelInfo("Jumlah Data Customer", 420, 40, 400, 40);
    private cBigFont valueCustomerBeranda = new cBigFont("0", 420, 60);
    private cLabelInfo labelOrderOnlineBeranda = new cLabelInfo("Jumlah Data Order Online", 40, 180, 400, 40);
    private cBigFont valueOrderOnlineBeranda = new cBigFont("0", 40, 205);
    private cLabelInfo labelOrderBahanBeranda = new cLabelInfo("Jumlah Data Order Bahan", 420, 180, 400, 40);
    private cBigFont valueOrderBahanBeranda = new cBigFont("0", 420, 205);
    private cLabelInfo labelCalonMitraBeranda = new cLabelInfo("Jumlah Data Calon Mitra ", 40, 320, 400, 40);
    private cBigFont valueCalonMitraBeranda = new cBigFont("0", 40, 345);
    private cLabelInfo labelCalonKaryawanBeranda = new cLabelInfo("Jumlah Data Calon Karyawan", 420, 320, 400, 40);
    private cBigFont valueCalonKaryawanBeranda = new cBigFont("0", 420, 345);

    // componenet of data customer
    private cPanelRounded panelHeaderCustomer = new cPanelRounded(0, 0, 1100, 75, 15);
    private cLabelInfo labelCustomer = new cLabelInfo("Data Customer Aktif", 40, 20, 300, 40);
    private cTextField txtCariCustomer = new cTextField(40, 85, 300);
    private cTable tblDataCustomer;
    private cScrollPane spDataCustomer;

    // componenet of data customer
    private cPanelRounded panelHeaderMitra = new cPanelRounded(0, 0, 1100, 75, 15);
    private cLabelInfo labelMitra = new cLabelInfo("Data Mitra Aktif", 40, 20, 300, 40);
    private cTextField txtCariMitra = new cTextField(40, 85, 300);
    private cTable tblDataMitra;
    private cScrollPane spDataMitra;

    // component of Order Bahan
    private cPanelRounded panelHeaderOrderBahan = new cPanelRounded(0, 0, 1100, 75, 15);
    private cPanelRounded panelDeskripsiOrderBahan = new cPanelRounded(700, 150, 400, 410, 15);
    private cTextarea valueDeskripsiOrderBahan = new cTextarea(750, 180, 300, 150, false);
    private cTextarea valueAlamatOrderBahan = new cTextarea(750, 360, 300, 150, false);
    private cLabelInfo labelOrderBahan = new cLabelInfo("Proses Order Bahan", 40, 20, 300, 40);
    private cTextField txtCariOrderBahan = new cTextField(40, 85, 300);
    private cButton btnOrderBahan = new cButton("Proses", 400, 95, 150, 30, 20);
    private cTable tblDataOrderBahan;
    private cScrollPane spDataOrderBahan;

    // component of Calon Mitra
    private cPanelRounded panelHeaderCalonMitra = new cPanelRounded(0, 0, 1100, 75, 15);
    private cLabelInfo labelCalonMitra = new cLabelInfo("Data Calon Mitra", 40, 20, 300, 40);
    private cTextField txtCariCalonMitra = new cTextField(40, 85, 300);
    private cButton btnCalonMitra = new cButton("Setuju", 400, 95, 150, 30, 20);
    private cTable tblDataCalonMitra;
    private cScrollPane spDataCalonMitra;

    // component of Karyawan
    private cPanelRounded panelHeaderKaryawan = new cPanelRounded(0, 0, 1100, 75, 15);
    private cLabelInfo labelDataKaryawan = new cLabelInfo("Data Calon Karyawan", 40, 20, 300, 40);
    private cTextField txtCariKaryawan = new cTextField(40, 85, 300);
    private cButton btnKaryawan = new cButton("Setuju", 400, 95, 150, 30, 20);
    private cTable tblDataKaryawan;
    private cScrollPane spDataKaryawan;

    // component of data history
    private cLabelInfo labelHistory = new cLabelInfo("Pilih History", 40, 20, 300, 40);
    private cComboBox pilihHistory = new cComboBox(
            new String[] { "Order Offline", "Order Online" },
            170, 23, 200,
            30);

    // component of data History transaksi
    private cPanelRounded panelHeaderHistoryTransaksi = new cPanelRounded(0, 0, 1100, 75, 15);
    private cTextField txtCariHistoryTransaksi = new cTextField(40, 85, 300);
    private cButton btnDetailHistoryTransaksi = new cButton("Detail", 400, 95, 150, 30, 20);
    private cTable tblDataHistoryTransaksi;
    private cScrollPane spDataHistoryTransaksi;

    // component of data History transaksi Online
    private cPanelRounded panelHeaderHistoryTransaksiOnline = new cPanelRounded(0, 0, 1100, 75, 15);
    private cTextField txtCariHistoryTransaksiOnline = new cTextField(40, 85, 300);
    private cButton btnDetailHistoryTransaksiOnline = new cButton("Detail", 400, 95, 150, 30, 20);
    private cTable tblDataHistoryTransaksiOnline;
    private cScrollPane spDataHistoryTransaksiOnline;

    // method resetSidebar
    private void resetSidebar() {
        try {
            setVisible(false);

            menuBeranda.setForeground(cColor.WHITE);
            menuBeranda.setBackground(cColor.GREEN);
            menuBeranda.setSidebarNonAktif();

            menuDataCustomer.setForeground(cColor.WHITE);
            menuDataCustomer.setBackground(cColor.GREEN);
            menuDataCustomer.setSidebarNonAktif();

            menuDataMitra.setForeground(cColor.WHITE);
            menuDataMitra.setBackground(cColor.GREEN);
            menuDataMitra.setSidebarNonAktif();

            menuOrderBahan.setForeground(cColor.WHITE);
            menuOrderBahan.setBackground(cColor.GREEN);
            menuOrderBahan.setSidebarNonAktif();

            menuCalonMitra.setForeground(cColor.WHITE);
            menuCalonMitra.setBackground(cColor.GREEN);
            menuCalonMitra.setSidebarNonAktif();

            menuKaryawan.setForeground(cColor.WHITE);
            menuKaryawan.setBackground(cColor.GREEN);
            menuKaryawan.setSidebarNonAktif();

            menuHistory.setForeground(cColor.WHITE);
            menuHistory.setBackground(cColor.GREEN);
            menuHistory.setSidebarNonAktif();

            menuHistoryBahan.setForeground(cColor.WHITE);
            menuHistoryBahan.setBackground(cColor.GREEN);
            menuHistoryBahan.setSidebarNonAktif();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method refresh content
    private void refreshContent() {
        try {
            content.removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public cDashboardAdminView(boolean statusLogin) {
        super("Dasboard Admin");
        this.statusLogin = statusLogin;
        this.idSelected = null;
        roleText.setText("Admin");
        menuBeranda.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsBeranda();
            }
        });
        menuDataCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsDataCustomer();
            }
        });
        menuDataMitra.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsDataMitra();
            }
        });
        menuOrderBahan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsOrderBahan();
            }
        });
        menuCalonMitra.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsCalonMitra();
            }
        });
        menuKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsKaryawan();
            }
        });
        menuHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsHistory();
            }
        });
        menuHistoryBahan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsHistoryBahan();
            }
        });
        // add component default
        main.add(labelDateTimeBeranda);
        sidebar.add(menuBeranda);
        sidebar.add(menuDataCustomer);
        sidebar.add(menuDataMitra);
        sidebar.add(menuOrderBahan);
        sidebar.add(menuCalonMitra);
        sidebar.add(menuKaryawan);
        sidebar.add(menuHistory);
        sidebar.add(menuHistoryBahan);
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

        valueCustomerBeranda.setText(String.valueOf(Model.getCountAllDataCustomer()));
        valueOrderBahanBeranda.setText(String.valueOf(Model.getCountAllDataOrderBahan()));
        valueCalonMitraBeranda.setText(String.valueOf(Model.getCountAllDataCalonMitra()));
        valueCalonKaryawanBeranda.setText(String.valueOf(Model.getCountAllDataCalonKaryawan()));
        valueOrderOfflineBeranda.setText(String.valueOf(Model.getCountAllDataOrderOffline()));
        valueOrderOnlineBeranda.setText(String.valueOf(Model.getCountAllDataOrderOnline()));

        content.add(labelOrderOnlineBeranda);
        content.add(valueOrderOnlineBeranda);
        content.add(labelCustomerBeranda);
        content.add(valueCustomerBeranda);
        content.add(labelOrderOfflineBeranda);
        content.add(valueOrderOfflineBeranda);
        content.add(labelOrderBahanBeranda);
        content.add(valueOrderBahanBeranda);
        content.add(labelCalonMitraBeranda);
        content.add(valueCalonMitraBeranda);
        content.add(labelCalonKaryawanBeranda);
        content.add(valueCalonKaryawanBeranda);

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

    private void initsDataMitra() {
        idSelected = null;
        resetSidebar();
        menuDataMitra.setBackground(cColor.WHITE);
        menuDataMitra.setForeground(cColor.GREEN);
        refreshContent();
        menuDataMitra.setSidebarAktif();
        menuTitle.setText("Data Mitra");

        tblDataMitra = new cTable(Model.getAllMitra());

        tblDataMitra.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataMitra.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataMitra.getColumnModel().getColumn(0).setWidth(0);

        tblDataMitra.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataMitra.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataMitra.getColumnModel().getColumn(5).setWidth(0);

        spDataMitra = new cScrollPane(tblDataMitra, 0, 150, 1100, 300);

        TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
        titledBorder.setTitleFont(cFonts.CARI_FONT);

        txtCariMitra.setBorder(titledBorder);
        txtCariMitra.setSize(300, 45);

        labelMitra.setForeground(cColor.WHITE);

        content.add(spDataMitra);
        content.add(labelMitra);
        content.add(txtCariMitra);
        content.add(panelHeaderMitra);
        setVisible(true);
    }

    private void initsOrderBahan() {
        idSelected = null;
        resetSidebar();
        menuOrderBahan.setBackground(cColor.WHITE);
        menuOrderBahan.setForeground(cColor.GREEN);
        refreshContent();
        menuOrderBahan.setSidebarAktif();
        menuTitle.setText("Data Order Bahan");

        tblDataOrderBahan = new cTable(Model.getAllOrderBahanDiproses());

        tblDataOrderBahan.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(0).setWidth(0);

        tblDataOrderBahan.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(1).setWidth(0);

        tblDataOrderBahan.getColumnModel().getColumn(2).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(2).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(2).setWidth(0);

        tblDataOrderBahan.getColumnModel().getColumn(3).setMinWidth(200);
        tblDataOrderBahan.getColumnModel().getColumn(3).setMaxWidth(200);
        tblDataOrderBahan.getColumnModel().getColumn(3).setWidth(200);

        tblDataOrderBahan.getColumnModel().getColumn(6).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(6).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(6).setWidth(0);

        tblDataOrderBahan.getColumnModel().getColumn(7).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(7).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(7).setWidth(0);

        btnOrderBahan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedIndex = tblDataOrderBahan.getSelectedRow();

                if (selectedIndex != -1) {
                    // kalo ada yang dipilih
                    int idOrder = Integer
                            .valueOf(tblDataOrderBahan.getValueAt(selectedIndex, 0).toString());

                    if (Model.adminProsesBahan(idOrder)) {
                        // kalo berhasil
                        JOptionPane.showMessageDialog(cDashboardAdminView.this, "Supplier berhasil.", "Berhasil",
                                JOptionPane.INFORMATION_MESSAGE);
                        initsOrderBahan();
                    } else {
                        JOptionPane.showMessageDialog(cDashboardAdminView.this, "Supplier gagal!", "Gagal",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        tblDataOrderBahan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent me) {
                int selectedIndex = tblDataOrderBahan.getSelectedRow();
                String idString = tblDataOrderBahan.getValueAt(selectedIndex, 0).toString();
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

        spDataOrderBahan = new cScrollPane(tblDataOrderBahan, 0, 150, 700, 400);

        TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
        titledBorder.setTitleFont(cFonts.CARI_FONT);

        valueDeskripsiOrderBahan.setBorder(titledDeskripsi);
        valueAlamatOrderBahan.setBorder(titledAlamat);

        txtCariOrderBahan.setBorder(titledBorder);
        txtCariOrderBahan.setSize(300, 45);

        labelOrderBahan.setForeground(cColor.WHITE);

        content.add(spDataOrderBahan);

        content.add(labelOrderBahan);
        content.add(txtCariOrderBahan);
        content.add(btnOrderBahan);
        content.add(valueDeskripsiOrderBahan);
        content.add(valueAlamatOrderBahan);

        content.add(panelHeaderOrderBahan);
        content.add(panelDeskripsiOrderBahan);

        setVisible(true);
    }

    private void initsCalonMitra() {
        idSelected = null;
        resetSidebar();
        menuCalonMitra.setBackground(cColor.WHITE);
        menuCalonMitra.setForeground(cColor.GREEN);
        refreshContent();
        menuCalonMitra.setSidebarAktif();
        menuTitle.setText("Data Calon Mitra");

        btnCalonMitra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedIndex = tblDataCalonMitra.getSelectedRow();

                if (selectedIndex != -1) {
                    // kalo ada yang dipilih
                    int idMitra = Integer
                            .valueOf(tblDataCalonMitra.getValueAt(selectedIndex, 0).toString());

                    if (Model.adminVerifikasiCalonMitra(idMitra)) {
                        // kalo berhasil
                        JOptionPane.showMessageDialog(cDashboardAdminView.this, "Supplier berhasil.", "Berhasil",
                                JOptionPane.INFORMATION_MESSAGE);
                        initsOrderBahan();
                    } else {
                        JOptionPane.showMessageDialog(cDashboardAdminView.this, "Supplier gagal!", "Gagal",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        tblDataCalonMitra = new cTable(Model.getAllMitraVerified());

        tblDataCalonMitra.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataCalonMitra.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataCalonMitra.getColumnModel().getColumn(0).setWidth(0);

        tblDataCalonMitra.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataCalonMitra.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataCalonMitra.getColumnModel().getColumn(5).setWidth(0);

        spDataCalonMitra = new cScrollPane(tblDataCalonMitra, 0, 150, 1080, 300);

        TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
        titledBorder.setTitleFont(cFonts.CARI_FONT);

        txtCariCalonMitra.setBorder(titledBorder);
        txtCariCalonMitra.setSize(300, 45);

        labelCalonMitra.setForeground(cColor.WHITE);

        content.add(spDataCalonMitra);

        content.add(labelCalonMitra);
        content.add(txtCariCalonMitra);
        content.add(btnCalonMitra);

        content.add(panelHeaderCalonMitra);

        setVisible(true);
    }

    private void initsKaryawan() {
        idSelected = null;
        resetSidebar();
        menuKaryawan.setBackground(cColor.WHITE);
        menuKaryawan.setForeground(cColor.GREEN);
        refreshContent();
        menuKaryawan.setSidebarAktif();
        menuTitle.setText("Data Karyawan");

        btnKaryawan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedIndex = tblDataKaryawan.getSelectedRow();

                if (selectedIndex != -1) {
                    // kalo ada yang dipilih
                    int idKaryawan = Integer
                            .valueOf(tblDataKaryawan.getValueAt(selectedIndex, 0).toString());

                    if (Model.adminVerifikasiCalonKaryawan(idKaryawan)) {
                        // kalo berhasil
                        JOptionPane.showMessageDialog(cDashboardAdminView.this, "Karyawan Terverifikasi", "Berhasil",
                                JOptionPane.INFORMATION_MESSAGE);
                        initsOrderBahan();
                    } else {
                        JOptionPane.showMessageDialog(cDashboardAdminView.this, "Karyawan gagal Terverifikasi!",
                                "Gagal",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        tblDataKaryawan = new cTable(Model.getAllKaryawanVerified());

        tblDataKaryawan.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataKaryawan.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataKaryawan.getColumnModel().getColumn(0).setWidth(0);

        tblDataKaryawan.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataKaryawan.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataKaryawan.getColumnModel().getColumn(1).setWidth(0);

        tblDataKaryawan.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataKaryawan.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataKaryawan.getColumnModel().getColumn(5).setWidth(0);

        spDataKaryawan = new cScrollPane(tblDataKaryawan, 0, 150, 1080, 300);

        TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
        titledBorder.setTitleFont(cFonts.CARI_FONT);

        txtCariKaryawan.setBorder(titledBorder);
        txtCariKaryawan.setSize(300, 45);

        labelDataKaryawan.setForeground(cColor.WHITE);

        content.add(spDataKaryawan);

        content.add(labelDataKaryawan);
        content.add(txtCariKaryawan);
        content.add(btnKaryawan);

        content.add(panelHeaderKaryawan);

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

        pilihHistory.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String selectedItem = (String) pilihHistory.getSelectedItem();
                if (selectedItem.equals("Order Offline")) {
                    initsDataHistoryOrderOffline();
                } else if (selectedItem.equals("Order Online")) {
                    initsDataHistoryOrderOnline();
                }
            }
        });

        initsDataHistoryOrderOffline();

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
                            + String.format("%-60s %-30s %-10s", nonCoffeTransaksi, jumlahNonCoffe, hargaNonCoffe)
                            + "\n"
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
                    JOptionPane.showMessageDialog(cDashboardAdminView.this,
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

        tblDataHistoryTransaksi.getColumnModel().getColumn(3).setMinWidth(200);
        tblDataHistoryTransaksi.getColumnModel().getColumn(3).setMaxWidth(200);
        tblDataHistoryTransaksi.getColumnModel().getColumn(3).setWidth(200);

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

    private void initsDataHistoryOrderOnline() {
        resetSidebar();
        menuHistory.setBackground(cColor.GREEN);
        menuHistory.setForeground(cColor.WHITE);
        menuHistory.setSidebarAktif();
        refreshContent();
        menuTitle.setText("Data History Order Online");

        content.add(pilihHistory);
        content.add(labelHistory);

        btnDetailHistoryTransaksiOnline.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedIndex = tblDataHistoryTransaksiOnline.getSelectedRow();

                if (selectedIndex != -1) {
                    String idString = tblDataHistoryTransaksiOnline.getValueAt(selectedIndex, 0).toString();
                    int idTransaksi = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

                    String transaksiId = Model.getDetailOnlineDiproses(idTransaksi)[0].toString();
                    String mitraId = Model.getDetailOnlineDiproses(idTransaksi)[1].toString();
                    String customerId = Model.getDetailOnlineDiproses(idTransaksi)[2].toString();
                    String namaMitra = Model.getDetailOnlineDiproses(idTransaksi)[3].toString();
                    String namaCustomer = Model.getDetailOnlineDiproses(idTransaksi)[4].toString();
                    String waktuTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[5].toString();
                    String makananTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[6].toString();
                    String coffeTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[7].toString();
                    String nonCoffeTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[8].toString();
                    String jumlahMakanan = Model.getDetailOnlineDiproses(idTransaksi)[9].toString();
                    String jumlahCoffe = Model.getDetailOnlineDiproses(idTransaksi)[10].toString();
                    String jumlahNonCoffe = Model.getDetailOnlineDiproses(idTransaksi)[11].toString();
                    String hargaMakanan = Model.getDetailOnlineDiproses(idTransaksi)[12].toString();
                    String hargaCoffe = Model.getDetailOnlineDiproses(idTransaksi)[13].toString();
                    String hargaNonCoffe = Model.getDetailOnlineDiproses(idTransaksi)[14].toString();
                    String promoTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[15].toString();
                    String mejaTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[16].toString();
                    String deskripsiTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[17].toString();
                    String hargaTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[18].toString();
                    String hargaPromo = Model.getDetailOnlineDiproses(idTransaksi)[19].toString();
                    String bayarTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[20].toString();
                    String uangTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[21].toString();
                    String kembalianTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[22].toString();
                    String statusTransaksi = Model.getDetailOnlineDiproses(idTransaksi)[23].toString();

                    String detailTransaksi = "\tForque" + "\n\n"
                            + "Jl. Jagal No.3A RT 007/004, Jl. Jagal, Rangkapan Jaya,\n"
                            + "Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435\n"
                            + "====================================================\n"
                            + String.format("%-40s:  %s", "Tanggal/Waktu", waktuTransaksi) + "\n"
                            + String.format("%-40s:  TR%s", "ID Transaksi", transaksiId) + "\n"
                            + String.format("%-44s:  MI%s", "ID Mitra", mitraId) + "\n"
                            + String.format("%-39s: %s", "Nama Mitra", namaMitra) + "\n"
                            + "====================================================\n"
                            + String.format("%-44s:  CS%s", "ID Mitra", customerId) + "\n"
                            + String.format("%-44s: %s", "Status Transaksi", statusTransaksi) + "\n"
                            + String.format("%-44s: %s", "Nomor Meja", mejaTransaksi) + "\n"
                            + String.format("%-39s: %s", "Nama Pemesan", namaCustomer) + "\n"
                            + String.format("%-44s: %s", "Pembayaran", bayarTransaksi) + "\n"
                            + String.format("%-49s: %s", "Promo", promoTransaksi) + "\n"
                            + String.format("%-38s: %s", "Deskripsi Pesanan", deskripsiTransaksi) + "\n"
                            + "====================================================\n"
                            + String.format("%-60s %-30s %-10s", makananTransaksi, jumlahMakanan, hargaMakanan) + "\n"
                            + String.format("%-60s %-30s %-10s", coffeTransaksi, jumlahCoffe, hargaCoffe) + "\n"
                            + String.format("%-60s %-30s %-10s", nonCoffeTransaksi, jumlahNonCoffe, hargaNonCoffe)
                            + "\n"
                            + "====================================================\n"
                            + String.format("%-80s Harga Total   : %s", "", hargaTransaksi) + "\n"
                            + String.format("%-80s Harga Promo          : %s", "", hargaPromo) + "\n"
                            + String.format("%-80s Uang                 : %s", "", uangTransaksi) + "\n"
                            + String.format("%-80s Kembalian            : %s", "", kembalianTransaksi) + "\n"
                            + "=======================================================\n"
                            + "---------------TERIMAKASIH BY ARCOO NGAWI---------------\n"
                            + "=======================================================\n"
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
                    JOptionPane.showMessageDialog(cDashboardAdminView.this,
                            "Pilih data terlebih dahulu!",
                            "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        tblDataHistoryTransaksiOnline = new cTable(Model.getAllOnlineSelesai());

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(0).setMinWidth(80);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(0).setMaxWidth(80);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(0).setWidth(80);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(1).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(2).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(2).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(2).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(5).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(6).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(6).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(6).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(7).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(7).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(7).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(8).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(8).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(8).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(9).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(9).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(9).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(10).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(10).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(10).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(11).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(11).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(11).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(12).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(12).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(12).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(13).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(13).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(13).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(14).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(14).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(14).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(15).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(15).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(15).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(16).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(16).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(16).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(17).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(17).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(17).setWidth(0);

        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(18).setMinWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(18).setMaxWidth(0);
        tblDataHistoryTransaksiOnline.getColumnModel().getColumn(18).setWidth(0);

        spDataHistoryTransaksiOnline = new cScrollPane(tblDataHistoryTransaksiOnline, 0, 150, 1100, 400);

        TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
        titledBorder.setTitleFont(cFonts.CARI_FONT);

        txtCariHistoryTransaksiOnline.setBorder(titledBorder);
        txtCariHistoryTransaksiOnline.setSize(300, 45);

        content.add(btnDetailHistoryTransaksiOnline);

        content.add(spDataHistoryTransaksiOnline);
        content.add(txtCariHistoryTransaksiOnline);
        content.add(panelHeaderHistoryTransaksiOnline);

        setVisible(true);
    }

    private void initsHistoryBahan() {
        idSelected = null;
        resetSidebar();
        menuHistoryBahan.setBackground(cColor.WHITE);
        menuHistoryBahan.setForeground(cColor.GREEN);
        refreshContent();
        menuHistoryBahan.setSidebarAktif();
        menuTitle.setText("Data History Bahan");

        tblDataOrderBahan = new cTable(Model.getAllOrderBahanSelesai());

        tblDataOrderBahan.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(0).setWidth(0);

        tblDataOrderBahan.getColumnModel().getColumn(1).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(1).setWidth(0);

        tblDataOrderBahan.getColumnModel().getColumn(2).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(2).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(2).setWidth(0);

        tblDataOrderBahan.getColumnModel().getColumn(3).setMinWidth(200);
        tblDataOrderBahan.getColumnModel().getColumn(3).setMaxWidth(200);
        tblDataOrderBahan.getColumnModel().getColumn(3).setWidth(200);

        tblDataOrderBahan.getColumnModel().getColumn(6).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(6).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(6).setWidth(0);

        tblDataOrderBahan.getColumnModel().getColumn(7).setMinWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(7).setMaxWidth(0);
        tblDataOrderBahan.getColumnModel().getColumn(7).setWidth(0);

        tblDataOrderBahan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent me) {
                int selectedIndex = tblDataOrderBahan.getSelectedRow();
                String idString = tblDataOrderBahan.getValueAt(selectedIndex, 0).toString();
                int idOrder = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

                String deksripsiOrderBahan = Model.getDetailOrderBahanSelesai(idOrder)[6].toString();
                valueDeskripsiOrderBahan.setText(deksripsiOrderBahan);

                String alamatOrderBahan = Model.getDetailOrderBahanSelesai(idOrder)[7].toString();
                valueAlamatOrderBahan.setText(alamatOrderBahan);
            }
        });

        TitledBorder titledDeskripsi = new TitledBorder(new LineBorder(cColor.BLACK), "Deskripsi ");
        titledDeskripsi.setTitleFont(cFonts.CARI_FONT);

        TitledBorder titledAlamat = new TitledBorder(new LineBorder(cColor.BLACK), "Alamat");
        titledAlamat.setTitleFont(cFonts.CARI_FONT);

        spDataOrderBahan = new cScrollPane(tblDataOrderBahan, 0, 150, 700, 400);

        TitledBorder titledBorder = new TitledBorder(new LineBorder(cColor.BLACK), "Cari");
        titledBorder.setTitleFont(cFonts.CARI_FONT);

        valueDeskripsiOrderBahan.setBorder(titledDeskripsi);
        valueAlamatOrderBahan.setBorder(titledAlamat);

        txtCariOrderBahan.setBorder(titledBorder);
        txtCariOrderBahan.setSize(300, 45);

        labelOrderBahan.setForeground(cColor.WHITE);

        content.add(spDataOrderBahan);

        content.add(labelOrderBahan);
        content.add(txtCariOrderBahan);
        content.add(valueDeskripsiOrderBahan);
        content.add(valueAlamatOrderBahan);

        content.add(panelHeaderOrderBahan);
        content.add(panelDeskripsiOrderBahan);

        setVisible(true);
    }
}
