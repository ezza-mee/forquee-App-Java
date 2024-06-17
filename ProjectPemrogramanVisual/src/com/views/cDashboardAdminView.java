package com.views;

import com.templates.cDashboardApp;
import com.main.Model;
import com.partials.*;

import javax.swing.JOptionPane;

public class cDashboardAdminView extends cDashboardApp {

    private boolean statusLogin = false;
    private Integer idSelected = null;

    private cLogoutDashboard exitLink = new cLogoutDashboard(1020);

    // sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuOrderBahan = new cSidebarMenu("Order Bahan", 70 + 50);
    private cSidebarMenu menuCalonMitra = new cSidebarMenu("Calon Mitra", 70 + 50 + 50);
    private cSidebarMenu menuKaryawan = new cSidebarMenu("Calon Karyawan", 70 + 50 + 50 + 50);
    private cSidebarMenu menuHistory = new cSidebarMenu("History Transaksi", 70 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuHistoryBahan = new cSidebarMenu("History Bahan", 70 + 50 + 50 + 50 + 50 + 50);

    // component of date time
    private cDateTime labelDateTimeBeranda = new cDateTime(720, 15, 300);

    // component of Order Bahan
    private cButton btnOrderBahan = new cButton("Proses", 450, 40, 150, 30, 20);

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

    // component of data History
    private cButton btnHistoryMakanan = new cButton("Makanan", 450, 40, 150, 30, 20);
    private cButton btnHistoryCoffe = new cButton("Coffe", 650, 40, 150, 30, 20);
    private cButton btnHistoryNonCoffe = new cButton("Non Coffe", 840, 40, 150, 30, 20);

    // component of data History makanan
    private cLabelInfo labelCariHistoryMakanan = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariHistoryMakanan = new cTextField(100, 40, 300);
    private cTable tblTransaksiMakanan;
    private cScrollPane spTransaksiMakanan;

    // component of data History coffe
    private cLabelInfo labelCariHistoryCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariHistoryCoffe = new cTextField(100, 40, 300);
    private cTable tblTransaksiCoffe;
    private cScrollPane spTransaksiCoffe;

    // component of data History non coffe
    private cLabelInfo labelCariHistoryNonCoffe = new cLabelInfo("Cari", 40, 35, 300, 40);
    private cTextField txtCariHistoryNonCoffe = new cTextField(100, 40, 300);
    private cTable tblTransaksiNonCoffe;
    private cScrollPane spTransaksiNonCoffe;

    // method resetSidebar
    private void resetSidebar() {
        try {
            setVisible(false);

            menuBeranda.setForeground(cColor.WHITE);
            menuBeranda.setBackground(cColor.GREEN);
            menuBeranda.setSidebarNonAktif();

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
        exitLink.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                cDashboardAdminView.this.setVisible(false);
            }
        });
        // add component default
        main.add(labelDateTimeBeranda);
        sidebar.add(menuBeranda);
        sidebar.add(menuOrderBahan);
        sidebar.add(menuCalonMitra);
        sidebar.add(menuKaryawan);
        sidebar.add(menuHistory);
        sidebar.add(menuHistoryBahan);
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
