package com.views;

import javax.swing.JOptionPane;

import com.main.Controller;
import com.main.Model;
import com.partials.*;
import com.templates.cFrameRegisApp;

public class cRegisView extends cFrameRegisApp {

    // component of daftar Customer
    private cFormLabel labelNamaDaftarCustomer = new cFormLabel("Nama", 60, 165, 320);
    private cTextField txtNamaDaftarCustomer = new cTextField(60, 190, 300);
    private cErrorLabel errorNamaDaftarCustomer = new cErrorLabel("Nama tidak boleh Kosong!", 60, 215, 335);
    private cFormLabel labelEmailDaftarCustomer = new cFormLabel("Email", 60, 265, 360);
    private cTextField txtEmailDaftarCustomer = new cTextField(60, 290, 300);
    private cErrorLabel errorEmailDaftarCustomer = new cErrorLabel("Email tidak boleh Kosong!", 60, 315, 335);
    private cFormLabel labelNomorHpDaftarCustomer = new cFormLabel("Nomor Hp", 440, 165, 360);
    private cTextField txtNomorHpDaftarCustomer = new cTextField(440, 190, 300);
    private cErrorLabel errorNomorHpDaftarCustomer = new cErrorLabel("NomorHp tidak boleh Kosong!", 440, 215, 335);
    private cFormLabel labelPasswordDaftarCustomer = new cFormLabel("Password", 440, 265, 360);
    private cPasswordField txtPasswordDaftarCustomer = new cPasswordField(440, 290, 300);
    private cErrorLabel errorPasswordDaftarCustomer = new cErrorLabel("Password tidak boleh Kosong!", 440, 315, 335);
    private cButtonLogin btnDaftarCustomer = new cButtonLogin("Daftar", 250, 380, 300, 40);
    private cLinkStart toLoginCustomerDaftarCustomer = new cLinkStart("sudah punya akun customer?", 50, 460);
    private cLinkStart toLoginAdminDaftarCustomer = new cLinkStart("login sebagai admin?", 50, 480);
    private cLinkStart toDaftarMitraDaftarCustomer = new cLinkStart("daftar sebagai mitra?", 440, 460);
    private cLinkStart toLoginMitraDaftarCustomer = new cLinkStart("sudah punya akun mitra?", 440, 480);

    // component of daftar Mitra
    private cFormLabel labelNamaDaftarMitra = new cFormLabel("Nama", 60, 165, 320);
    private cTextField txtNamaDaftarMitra = new cTextField(60, 190, 300);
    private cErrorLabel errorNamaDaftarMitra = new cErrorLabel("Nama tidak boleh Kosong!", 60, 215, 335);
    private cFormLabel labelEmailDaftarMitra = new cFormLabel("Email", 60, 265, 360);
    private cTextField txtEmailDaftarMitra = new cTextField(60, 290, 300);
    private cErrorLabel errorEmailDaftarMitra = new cErrorLabel("Email tidak boleh Kosong!", 60, 315, 335);
    private cFormLabel labelNomorHpDaftarMitra = new cFormLabel("Nomor Hp", 440, 165, 360);
    private cTextField txtNomorHpDaftarMitra = new cTextField(440, 190, 300);
    private cErrorLabel errorNomorHpDaftarMitra = new cErrorLabel("NomorHp tidak boleh Kosong!", 440, 215, 335);
    private cFormLabel labelPasswordDaftarMitra = new cFormLabel("Password", 440, 265, 360);
    private cPasswordField txtPasswordDaftarMitra = new cPasswordField(440, 290, 300);
    private cErrorLabel errorPasswordDaftarMitra = new cErrorLabel("Password tidak boleh Kosong!", 440, 315, 335);
    private cButtonLogin btnDaftarMitra = new cButtonLogin("Daftar", 250, 380, 300, 40);
    private cLinkStart toLoginMitraDaftarMitra = new cLinkStart("sudah punya akun Mitra?", 50, 460);
    private cLinkStart toLoginAdminDaftarMitra = new cLinkStart("login sebagai admin?", 50, 480);
    private cLinkStart toDaftarCustomerDaftarMitra = new cLinkStart("daftar sebagai customer?", 440, 460);
    private cLinkStart toLoginCustomerDaftarMitra = new cLinkStart("sudah punya akun customer?", 440, 480);

    public cRegisView() {
        super();

        // implemnt for link frame daftar customer
        toLoginCustomerDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginCustomer();
            }
        });
        toDaftarMitraDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarMitra();
            }
        });
        toLoginMitraDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginMitra();
            }
        });
        toLoginAdminDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginAdmin();
            }
        });

        // implement for link frame daftar mitra
        toLoginMitraDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginMitra();
            }
        });
        toDaftarCustomerDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarCustomer();
            }
        });
        toLoginCustomerDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginCustomer();
            }
        });
        toLoginAdminDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginAdmin();
            }
        });
    }

    public void initsDaftarCustomer() {
        this.setVisible(false);
        this.setTitle("Daftar Customer");
        cardRegis.removeAll();
        titleRegis.setText("Daftar Customer");
        cardRegis.add(titleRegis);

        btnDaftarCustomer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String nama = txtNamaDaftarCustomer.getText();
                String email = txtEmailDaftarCustomer.getText();
                String nomorHp = txtNomorHpDaftarCustomer.getText();
                String password = String.valueOf(txtPasswordDaftarCustomer.getPassword());

                if (nama.equalsIgnoreCase("") || nama.isEmpty() || email.equalsIgnoreCase("") || email.isEmpty()
                        || password.equalsIgnoreCase("") || password.isEmpty()) {

                    cRegisView.this.setVisible(false);

                    // kalau namanya yang kosong
                    if (nama.equalsIgnoreCase("") || nama.isEmpty())
                        cardRegis.add(errorNamaDaftarCustomer);
                    else
                        cardRegis.remove(errorNamaDaftarCustomer);

                    // kalau Nomornya yang kosong
                    if (nomorHp.equalsIgnoreCase("") || nomorHp.isEmpty())
                        cardRegis.add(errorNomorHpDaftarCustomer);
                    else
                        cardRegis.remove(errorNomorHpDaftarCustomer);

                    // kalau Emailnya yang kosong
                    if (email.equalsIgnoreCase("") || email.isEmpty())
                        cardRegis.add(errorEmailDaftarCustomer);
                    else
                        cardRegis.remove(errorEmailDaftarCustomer);

                    // kalau Passwordnya yang kosong
                    if (password.equalsIgnoreCase("") || password.isEmpty())
                        cardRegis.add(errorPasswordDaftarCustomer);
                    else
                        cardRegis.remove(errorPasswordDaftarCustomer);

                    cRegisView.this.setVisible(true);

                } else {
                    // lolos validasi

                    // cek apakah Email sudah terdaftar atau belum
                    if (Model.verifyEmailMitra(email)) {
                        // berarti Email belum terdaftar
                        if (Model.daftarMitra(nama, nomorHp, email, password)) {
                            // kalau berhasil daftar
                            JOptionPane.showMessageDialog(cRegisView.this, "Daftar Berhasil!!", "Berhasil Daftar",
                                    JOptionPane.INFORMATION_MESSAGE);
                            cLoginView loginCustomer = new cLoginView();
                            loginCustomer.setVisible(true);
                            loginCustomer.initsLoginCustomer();
                            cRegisView.this.setVisible(false);
                        } else {
                            // kalau gagal daftar
                            JOptionPane.showMessageDialog(cRegisView.this, "Pendafaran gagal!!", "Gagal Daftar",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // berarti noHp sudah terdaftar
                        JOptionPane.showMessageDialog(cRegisView.this, "Silahkan cek kembali data anda!!",
                                "Gagal Daftar", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        cardRegis.add(labelNamaDaftarCustomer);
        cardRegis.add(txtNamaDaftarCustomer);
        cardRegis.add(labelEmailDaftarCustomer);
        cardRegis.add(txtEmailDaftarCustomer);
        cardRegis.add(labelNomorHpDaftarCustomer);
        cardRegis.add(txtNomorHpDaftarCustomer);
        cardRegis.add(labelPasswordDaftarCustomer);
        cardRegis.add(txtPasswordDaftarCustomer);
        cardRegis.add(btnDaftarCustomer);
        cardRegis.add(toLoginCustomerDaftarCustomer);
        cardRegis.add(toDaftarMitraDaftarCustomer);
        cardRegis.add(toLoginMitraDaftarCustomer);
        cardRegis.add(toLoginAdminDaftarCustomer);
    }

    public void initsDaftarMitra() {
        this.setVisible(false);
        this.setTitle("Daftar Mitra");
        cardRegis.removeAll();
        titleRegis.setText("Daftar Mitra");
        cardRegis.add(titleRegis);

        btnDaftarMitra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String nama = txtNamaDaftarMitra.getText();
                String email = txtEmailDaftarMitra.getText();
                String nomorHp = txtNomorHpDaftarMitra.getText();
                String password = String.valueOf(txtPasswordDaftarMitra.getPassword());

                if (nama.equalsIgnoreCase("") || nama.isEmpty() || email.equalsIgnoreCase("") || email.isEmpty()
                        || password.equalsIgnoreCase("") || password.isEmpty()) {

                    cRegisView.this.setVisible(false);

                    // kalau namanya yang kosong
                    if (nama.equalsIgnoreCase("") || nama.isEmpty())
                        cardRegis.add(errorNamaDaftarMitra);
                    else
                        cardRegis.remove(errorNamaDaftarMitra);

                    // kalau Nomornya yang kosong
                    if (nomorHp.equalsIgnoreCase("") || nomorHp.isEmpty())
                        cardRegis.add(errorNomorHpDaftarMitra);
                    else
                        cardRegis.remove(errorNomorHpDaftarMitra);

                    // kalau Emailnya yang kosong
                    if (email.equalsIgnoreCase("") || email.isEmpty())
                        cardRegis.add(errorEmailDaftarMitra);
                    else
                        cardRegis.remove(errorEmailDaftarMitra);

                    // kalau Passwordnya yang kosong
                    if (password.equalsIgnoreCase("") || password.isEmpty())
                        cardRegis.add(errorPasswordDaftarMitra);
                    else
                        cardRegis.remove(errorPasswordDaftarMitra);

                    cRegisView.this.setVisible(true);

                } else {
                    // lolos validasi

                    // cek apakah Email sudah terdaftar atau belum
                    if (Model.verifyEmailMitra(email)) {
                        // berarti Email belum terdaftar
                        if (Model.daftarMitra(nama, nomorHp, email, password)) {
                            // kalau berhasil daftar
                            JOptionPane.showMessageDialog(cRegisView.this, "Daftar Berhasil!!", "Berhasil Daftar",
                                    JOptionPane.INFORMATION_MESSAGE);
                            cLoginView loginMitra = new cLoginView();
                            loginMitra.setVisible(true);
                            loginMitra.initsLoginMitra();
                            cRegisView.this.setVisible(false);
                        } else {
                            // kalau gagal daftar
                            JOptionPane.showMessageDialog(cRegisView.this, "Pendafaran gagal!!", "Gagal Daftar",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        // berarti noHp sudah terdaftar
                        JOptionPane.showMessageDialog(cRegisView.this, "Silahkan cek kembali data anda!!",
                                "Gagal Daftar", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        cardRegis.add(labelNamaDaftarMitra);
        cardRegis.add(txtNamaDaftarMitra);
        cardRegis.add(labelEmailDaftarMitra);
        cardRegis.add(txtEmailDaftarMitra);
        cardRegis.add(labelNomorHpDaftarMitra);
        cardRegis.add(txtNomorHpDaftarMitra);
        cardRegis.add(labelPasswordDaftarMitra);
        cardRegis.add(txtPasswordDaftarMitra);
        cardRegis.add(btnDaftarMitra);
        cardRegis.add(toLoginMitraDaftarMitra);
        cardRegis.add(toDaftarCustomerDaftarMitra);
        cardRegis.add(toLoginCustomerDaftarMitra);
        cardRegis.add(toLoginAdminDaftarMitra);
    }
}
