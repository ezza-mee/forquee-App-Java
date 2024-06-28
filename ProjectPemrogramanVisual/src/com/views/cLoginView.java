package com.views;

import com.partials.*;
import com.templates.cFrameLoginApp;

import javax.swing.JOptionPane;

import com.main.Controller;
import com.main.Model;

public class cLoginView extends cFrameLoginApp {

    // component of login Customer
    private cFormLabel labelEmailLoginCustomer = new cFormLabel("Email", 125, 195, 320);
    private cTextField txtEmailLoginCustomer = new cTextField(125, 230, 300);
    private cErrorLabel errorEmailLoginCustomer = new cErrorLabel("Email tidak boleh Kosong!", 125, 255, 335);
    private cFormLabel labelPasswordLoginCustomer = new cFormLabel("Password", 125, 285, 360);
    private cPasswordField txtPasswordLoginCustomer = new cPasswordField(125, 320, 300);
    private cErrorLabel errorPasswordLoginCustomer = new cErrorLabel("Password tidak boleh Kosong!", 125, 345, 335);
    private cButtonLogin btnLoginCustomer = new cButtonLogin("Login", 125, 400, 300, 40);
    private cLinkStart toDaftarCustomerLoginCustomer = new cLinkStart("belum punya akun customer?", 120, 465);
    private cLinkStart toDaftarMitraLoginCustomer = new cLinkStart("belum punya akun mitra?", 120, 490);
    private cLinkStart toLoginMitraLoginCustomer = new cLinkStart("sudah punya akun mitra?", 120, 515);
    private cLinkStart toLoginAdminLoginCustomer = new cLinkStart("login sebagai admin", 120, 540);

    // component of login mitra
    private cFormLabel labelEmailLoginMitra = new cFormLabel("Email", 125, 195, 320);
    private cTextField txtEmailLoginMitra = new cTextField(125, 230, 300);
    private cErrorLabel errorEmailLoginMitra = new cErrorLabel("Email tidak boleh Kosong!", 125, 255, 335);
    private cFormLabel labelPasswordLoginMitra = new cFormLabel("Password", 125, 285, 360);
    private cPasswordField txtPasswordLoginMitra = new cPasswordField(125, 320, 300);
    private cErrorLabel errorPasswordLoginMitra = new cErrorLabel("Password tidak boleh Kosong!", 125, 345, 335);
    private cButtonLogin btnLoginMitra = new cButtonLogin("Login", 125, 400, 300, 40);
    private cLinkStart toDaftarMitraLoginMitra = new cLinkStart("belum punya akun mitra?", 120, 465);
    private cLinkStart toDaftarCustomerLoginMitra = new cLinkStart("belum punya akun customer?", 120, 490);
    private cLinkStart toLoginCustomerLoginMitra = new cLinkStart("sudah punya akun customer?", 120, 515);
    private cLinkStart toLoginAdminLoginMitra = new cLinkStart("login sebagai admin", 120, 540);

    // component of login admin
    private cFormLabel labelEmailLoginAdmin = new cFormLabel("Email", 125, 195, 320);
    private cTextField txtEmailLoginAdmin = new cTextField(125, 230, 300);
    private cErrorLabel errorEmailLoginAdmin = new cErrorLabel("Email tidak boleh Kosong!", 125, 255, 335);
    private cFormLabel labelPasswordLoginAdmin = new cFormLabel("Password", 125, 285, 360);
    private cPasswordField txtPasswordLoginAdmin = new cPasswordField(125, 320, 300);
    private cErrorLabel errorPasswordLoginAdmin = new cErrorLabel("Password tidak boleh Kosong!", 125, 345, 335);
    private cButtonLogin btnLoginAdmin = new cButtonLogin("Login", 125, 400, 300, 40);
    private cLinkStart toDaftarMitraLoginAdmin = new cLinkStart("belum punya akun mitra?", 120, 465);
    private cLinkStart toDaftarCustomerLoginAdmin = new cLinkStart("belum punya akun customer?", 120, 490);
    private cLinkStart toLoginCustomerLoginAdmin = new cLinkStart("sudah punya akun customer?", 120, 515);
    private cLinkStart toLoginMitraLoginAdmin = new cLinkStart("sudah punya akun mitra?", 120, 540);

    public cLoginView() {
        super();

        // implement for link frame login Customer
        toDaftarCustomerLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarCustomer();
                cLoginView.this.setVisible(false);
            }
        });
        toDaftarMitraLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarMitra();
                cLoginView.this.setVisible(false);
            }
        });
        toLoginMitraLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginMitra();
            }
        });
        toLoginAdminLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginAdmin();
            }
        });

        // implement for link frame login mitra
        toDaftarMitraLoginMitra.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarMitra();
            }
        });
        toDaftarCustomerLoginMitra.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarCustomer();
                cLoginView.this.setVisible(false);
            }
        });
        toLoginCustomerLoginMitra.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginCustomer();
            }
        });
        toLoginAdminLoginMitra.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginAdmin();
            }
        });

        // implement for link frame login admin
        toLoginCustomerLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginCustomer();
            }
        });
        toDaftarCustomerLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarCustomer();
                cLoginView.this.setVisible(false);
            }
        });
        toLoginMitraLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showLoginMitra();
            }
        });
        toDaftarMitraLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarMitra();
                cLoginView.this.setVisible(false);
            }
        });

    }

    public void initsLoginCustomer() {
        cLoginView.this.setVisible(false);
        this.setTitle("Login Customer");
        cardLogin.removeAll();
        titleLogin.setText("Login Customer");
        titleFrom.setText("Welcome Back!");
        fromTitle.setText("Friend");
        cardLogin.add(titleLogin);

        btnLoginCustomer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String email = txtEmailLoginCustomer.getText();
                String password = String.valueOf(txtPasswordLoginCustomer.getPassword());

                // kalau salah satu datanya kosong
                if (email.equalsIgnoreCase("") || email.isEmpty() || password.equalsIgnoreCase("")
                        || password.isEmpty()) {

                    cLoginView.this.setVisible(false);

                    // masuk validasi
                    if (email.equalsIgnoreCase("") || email.isEmpty()) {
                        cardLogin.add(errorEmailLoginCustomer);
                    } else {
                        cardLogin.remove(errorEmailLoginCustomer);
                    }

                    if (password.equalsIgnoreCase("") || password.isEmpty())
                        cardLogin.add(errorPasswordLoginCustomer);
                    else
                        cardLogin.remove(errorPasswordLoginCustomer);

                    cLoginView.this.setVisible(true);
                } else {
                    // lolos validasi
                    if (Model.verifyAkunCustomer(email, password)) {
                        // kalo berhasil login
                        Controller
                                .showDashboardCustomer(
                                        Integer.valueOf(Model.getDetailCustomerByEmail(email)[0].toString()));
                        cLoginView.this.setVisible(false);
                    } else {
                        // kalo gagal login
                        JOptionPane.showMessageDialog(cLoginView.this, "Silahkan periksa email dan password!!",
                                "Gagal Login", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        cardLogin.add(labelEmailLoginCustomer);
        cardLogin.add(txtEmailLoginCustomer);
        cardLogin.add(labelPasswordLoginCustomer);
        cardLogin.add(txtPasswordLoginCustomer);
        cardLogin.add(btnLoginCustomer);
        cardLogin.add(toDaftarCustomerLoginCustomer);
        cardLogin.add(toDaftarMitraLoginCustomer);
        cardLogin.add(toLoginMitraLoginCustomer);
        cardLogin.add(toLoginAdminLoginCustomer);

        this.setVisible(true);
    }

    public void initsLoginMitra() {
        cLoginView.this.setVisible(false);
        this.setTitle("Login Mitra");
        cardLogin.removeAll();
        titleLogin.setText("Login Mitra");
        titleFrom.setText("Welcome Back!");
        fromTitle.setText("Friend");
        cardLogin.add(titleLogin);

        btnLoginMitra.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String email = txtEmailLoginMitra.getText();
                String password = String.valueOf(txtPasswordLoginMitra.getPassword());

                // kalau salah satu datanya kosong
                if (email.equalsIgnoreCase("") || email.isEmpty() || password.equalsIgnoreCase("")
                        || password.isEmpty()) {

                    cLoginView.this.setVisible(false);

                    // masuk validasi
                    if (email.equalsIgnoreCase("") || email.isEmpty()) {
                        cardLogin.add(errorEmailLoginMitra);
                    } else {
                        cardLogin.remove(errorEmailLoginMitra);
                    }

                    if (password.equalsIgnoreCase("") || password.isEmpty())
                        cardLogin.add(errorPasswordLoginMitra);
                    else
                        cardLogin.remove(errorPasswordLoginMitra);

                    cLoginView.this.setVisible(true);
                } else {
                    // lolos validasi

                    if (Model.verifyAkunMitra(email, password)) {
                        // kalo berhasil login
                        Controller
                                .showDashboardMitra(Integer.valueOf(Model.getDetailMitraByEmail(email)[0].toString()));
                        cLoginView.this.setVisible(false);
                    } else {
                        // kalo gagal login
                        JOptionPane.showMessageDialog(cLoginView.this, "Silahkan periksa email dan password!!",
                                "Gagal Login", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        cardLogin.add(labelEmailLoginMitra);
        cardLogin.add(txtEmailLoginMitra);
        cardLogin.add(labelPasswordLoginMitra);
        cardLogin.add(txtPasswordLoginMitra);
        cardLogin.add(btnLoginMitra);
        cardLogin.add(toDaftarMitraLoginMitra);
        cardLogin.add(toDaftarCustomerLoginMitra);
        cardLogin.add(toLoginCustomerLoginMitra);
        cardLogin.add(toLoginAdminLoginMitra);

        this.setVisible(true);
    }

    public void initsLoginAdmin() {
        cLoginView.this.setVisible(false);
        this.setTitle("Login Admin");
        cardLogin.removeAll();
        titleLogin.setText("Login Admin");
        titleFrom.setText("Welcome Back!");
        fromTitle.setText("Friend");
        cardLogin.add(titleLogin);

        btnLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                if (txtEmailLoginAdmin.getText().equalsIgnoreCase("")
                        || String.valueOf(txtPasswordLoginAdmin.getPassword()).equalsIgnoreCase("")) {
                    Controller.showLoginAdmin();
                    if (txtEmailLoginAdmin.getText().equalsIgnoreCase("")) {
                        cardLogin.add(errorEmailLoginAdmin);
                    }
                    if (String.valueOf(txtPasswordLoginAdmin.getPassword()).equalsIgnoreCase("")) {
                        cardLogin.add(errorPasswordLoginAdmin);
                    }
                }
                String Email = txtEmailLoginAdmin.getText();
                String password = String.valueOf(txtPasswordLoginAdmin.getPassword());

                if (Email.equals("admin") && password.equals("admin")) {
                    // loginnya Berhasil
                    Controller.showDashboardAdmin(true);
                    cLoginView.this.setVisible(false);
                } else {
                    // loginnya gagal
                    JOptionPane.showMessageDialog(cLoginView.this, "Silahkan periksa Username dan password!",
                            "Gagal Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cardLogin.add(labelEmailLoginAdmin);
        cardLogin.add(txtEmailLoginAdmin);
        cardLogin.add(labelPasswordLoginAdmin);
        cardLogin.add(txtPasswordLoginAdmin);
        cardLogin.add(btnLoginAdmin);
        cardLogin.add(toDaftarMitraLoginAdmin);
        cardLogin.add(toDaftarCustomerLoginAdmin);
        cardLogin.add(toLoginCustomerLoginAdmin);
        cardLogin.add(toLoginMitraLoginAdmin);

        this.setVisible(true);
    }

}
