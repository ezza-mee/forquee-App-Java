package com.views;

import com.templates.cDashboardApp;
import com.main.Model;
import com.partials.*;

import javax.swing.JOptionPane;

public class cDashboardAdminView extends cDashboardApp {

    private boolean statusLogin = false;
    private Integer idSelected = null;

    // sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuDataCustomer = new cSidebarMenu("Data Customer", 70 + 50);
    private cSidebarMenu menuOrderBahan = new cSidebarMenu("Order Bahan", 70 + 50 + 50);
    private cSidebarMenu menuCalonMitra = new cSidebarMenu("Calon Mitra", 70 + 50 + 50 + 50);
    private cSidebarMenu menuKaryawan = new cSidebarMenu("Calon Karyawan", 70 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuHistory = new cSidebarMenu("History Transaksi", 70 + 50 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuHistoryBahan = new cSidebarMenu("History Bahan", 70 + 50 + 50 + 50 + 50 + 50 + 50);

    // component of date time
    private cDateTime labelDateTimeBeranda = new cDateTime(720, 15, 300);
    private cLabelInfo labelCustomerBeranda = new cLabelInfo("Jumlah Data Customer", 420, 280, 400, 40);
    private cBigFont valueCustomerBeranda = new cBigFont("0", 420, 305);
    private cLabelInfo labelKaryawanBeranda = new cLabelInfo("Jumlah Data Karyawan", 40, 380, 400, 40);
    private cBigFont valueKaryawanBeranda = new cBigFont("0", 40, 405);
    private cLabelInfo labelOrderBahanBeranda = new cLabelInfo("Jumlah Data Order Bahan", 420, 380, 400, 40);
    private cBigFont valueOrderBahanBeranda = new cBigFont("0", 420, 405);
    private cLabelInfo labelTransaksiBeranda = new cLabelInfo("Jumlah Data Transaksi ", 40, 280, 400, 40);
    private cBigFont valueTransaksiBeranda = new cBigFont("0", 40, 305);

    // component of Order Bahan
    private cButton btnOrderBahan = new cButton("Proses", 450, 40, 150, 30, 20);

    // componenet of data customer
    private cLabelInfo labelCustomer = new cLabelInfo("Data Customer Aktif", 40, 40, 300, 40);
    private cLabelInfo labelCariCustomer = new cLabelInfo("Cari", 40, 95, 300, 40);
    private cTextField txtCariCustomer = new cTextField(100, 100, 300);
    private cTable tblDataCustomer;
    private cScrollPane spDataCustomer;

    // component of Order Bahan
    private cLabelInfo labelCariOrderBahan = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariOrderBahan = new cTextField(100, 40, 300);
    private cTable tblOrderBahan;
    private cScrollPane spOrderBahan;

    // component of Calon Mitra
    private cLabelInfo labelCariCalonMitra = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariCalonMitra = new cTextField(100, 40, 300);
    private cButton btnCalonMitra = new cButton("Proses", 450, 40, 150, 30, 20);
    private cTable tblDataMitra;
    private cScrollPane spDataMitra;

    // component of Karyawan
    private cLabelInfo labelCariKaryawan = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariKaryawan = new cTextField(100, 40, 300);
    private cButton btnKaryawan = new cButton("Proses", 450, 40, 150, 30, 20);
    private cTable tblDataKaryawan;
    private cScrollPane spDataKaryawan;

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
        valueKaryawanBeranda.setText(String.valueOf(Model.getCountAllDataKaryawan()));
        valueOrderBahanBeranda.setText(String.valueOf(Model.getCountAllDataOrderBahan()));

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

        spDataCustomer = new cScrollPane(tblDataCustomer, 0, 150, 1080, 300);

        content.add(spDataCustomer);
        content.add(labelCustomer);
        content.add(labelCariCustomer);
        content.add(txtCariCustomer);
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

        btnOrderBahan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedIndex = tblOrderBahan.getSelectedRow();

                if (selectedIndex != -1) {
                    // kalo ada yang dipilih
                    int idOrder = Integer
                            .valueOf(tblOrderBahan.getValueAt(selectedIndex, 0).toString());

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

        content.add(labelCariOrderBahan);
        content.add(txtCariOrderBahan);
        content.add(btnOrderBahan);

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
                int selectedIndex = tblDataMitra.getSelectedRow();

                if (selectedIndex != -1) {
                    // kalo ada yang dipilih
                    int idMitra = Integer
                            .valueOf(tblDataMitra.getValueAt(selectedIndex, 0).toString());

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

        tblDataMitra = new cTable(Model.getAllMitraVerified());

        tblDataMitra.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataMitra.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataMitra.getColumnModel().getColumn(0).setWidth(0);

        tblDataMitra.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataMitra.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataMitra.getColumnModel().getColumn(5).setWidth(0);

        spDataMitra = new cScrollPane(tblDataMitra, 0, 150, 1080, 300);

        content.add(spDataMitra);

        content.add(labelCariCalonMitra);
        content.add(txtCariCalonMitra);
        content.add(btnCalonMitra);

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

        content.add(spDataKaryawan);

        content.add(labelCariKaryawan);
        content.add(txtCariKaryawan);
        content.add(btnKaryawan);

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

        tblOrderBahan = new cTable(Model.getAllOrderBahanSelesai());

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

        content.add(labelCariOrderBahan);
        content.add(txtCariOrderBahan);
        content.add(btnOrderBahan);

        setVisible(true);
    }
}
