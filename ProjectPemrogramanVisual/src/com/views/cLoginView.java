package com.views;

import com.partials.*;
import com.templates.cFrameLoginApp;
import com.main.Controller;

public class cLoginView extends cFrameLoginApp {

    // component of login Customer
    private cFormLabel labelEmailLoginCustomer = new cFormLabel("Email", 125, 195, 320);
    private cTextField txtEmailLoginCustomer = new cTextField(125, 230, 300);
    private cErrorLabel errorEmailLoginCustomer = new cErrorLabel("Email tidak boleh Kosong!", 125, 255, 335);
    private cFormLabel labelPasswordLoginCustomer = new cFormLabel("Password", 125, 285, 360);
    private cPasswordField txtPasswordLoginCustomer = new cPasswordField(125, 320, 300);
    private cErrorLabel errorPasswordLoginCustomer = new cErrorLabel("Password tidak boleh Kosong!", 125, 345, 335);
    private cButtonLogin btnLoginCustomer = new cButtonLogin("Login", 125, 400, 300, 40);
    private cLinkStart toDaftarCustomerLoginCustomer = new cLinkStart("belum punya akun customer?", 120, 470);
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
    private cLinkStart toDaftarMitraLoginMitra = new cLinkStart("belum punya akun mitra?", 120, 470);
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
    private cLinkStart toDaftarMitraLoginAdmin = new cLinkStart("belum punya akun mitra?", 120, 470);
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
            }
        });
        toDaftarMitraLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarMitra();
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
        toDaftarCustomerLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                Controller.showDaftarCustomer();
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
            }
        });

    }

    public void initsLoginCustomer() {
        this.setVisible(false);
        this.setTitle("Login Customer");
        cardLogin.removeAll();
        titleLogin.setText("Login Customer");
        titleFrom.setText("Welcome Back!");
        fromTitle.setText("Friend");
        cardLogin.add(titleLogin);

        cardLogin.add(labelEmailLoginCustomer);
        cardLogin.add(txtEmailLoginCustomer);
        cardLogin.add(errorEmailLoginCustomer);
        cardLogin.add(labelPasswordLoginCustomer);
        cardLogin.add(txtPasswordLoginCustomer);
        cardLogin.add(errorPasswordLoginCustomer);
        cardLogin.add(btnLoginCustomer);
        cardLogin.add(toDaftarCustomerLoginCustomer);
        cardLogin.add(toDaftarMitraLoginCustomer);
        cardLogin.add(toLoginMitraLoginCustomer);
        cardLogin.add(toLoginAdminLoginCustomer);
    }

    public void initsLoginMitra() {
        this.setVisible(false);
        this.setTitle("Login Mitra");
        cardLogin.removeAll();
        titleLogin.setText("Login Mitra");
        titleFrom.setText("Welcome Back!");
        fromTitle.setText("Friend");
        cardLogin.add(titleLogin);

        cardLogin.add(labelEmailLoginMitra);
        cardLogin.add(txtEmailLoginMitra);
        cardLogin.add(errorEmailLoginMitra);
        cardLogin.add(labelPasswordLoginMitra);
        cardLogin.add(txtPasswordLoginMitra);
        cardLogin.add(errorPasswordLoginMitra);
        cardLogin.add(btnLoginMitra);
        cardLogin.add(toDaftarMitraLoginMitra);
        cardLogin.add(toDaftarCustomerLoginMitra);
        cardLogin.add(toLoginCustomerLoginMitra);
        cardLogin.add(toLoginAdminLoginMitra);
    }

    public void initsLoginAdmin() {
        this.setVisible(false);
        this.setTitle("Login Admin");
        cardLogin.removeAll();
        titleLogin.setText("Login Admin");
        titleFrom.setText("Welcome Back!");
        fromTitle.setText("Friend");
        cardLogin.add(titleLogin);

        cardLogin.add(labelEmailLoginAdmin);
        cardLogin.add(txtEmailLoginAdmin);
        cardLogin.add(errorEmailLoginAdmin);
        cardLogin.add(labelPasswordLoginAdmin);
        cardLogin.add(txtPasswordLoginAdmin);
        cardLogin.add(errorPasswordLoginAdmin);
        cardLogin.add(btnLoginAdmin);
        cardLogin.add(toDaftarMitraLoginAdmin);
        cardLogin.add(toDaftarCustomerLoginAdmin);
        cardLogin.add(toLoginCustomerLoginAdmin);
        cardLogin.add(toLoginMitraLoginAdmin);
    }

}
