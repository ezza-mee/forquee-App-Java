package com.views;

import com.main.Controller;
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
    private cPasswordField txtNomorHpDaftarCustomer = new cPasswordField(440, 190, 300);
    private cErrorLabel errorNomorHpDaftarCustomer = new cErrorLabel("NomorHp tidak boleh Kosong!", 440, 215, 335);
    private cFormLabel labelPasswordDaftarCustomer = new cFormLabel("Password", 440, 265, 360);
    private cTextField txtPasswordDaftarCustomer = new cTextField(440, 290, 300);
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
    private cPasswordField txtNomorHpDaftarMitra = new cPasswordField(440, 190, 300);
    private cErrorLabel errorNomorHpDaftarMitra = new cErrorLabel("NomorHp tidak boleh Kosong!", 440, 215, 335);
    private cFormLabel labelPasswordDaftarMitra = new cFormLabel("Password", 440, 265, 360);
    private cTextField txtPasswordDaftarMitra = new cTextField(440, 290, 300);
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
        this.setTitle("Daftar Customer");
        cardRegis.removeAll();
        titleRegis.setText("Daftar Customer");
        cardRegis.add(titleRegis);

        cardRegis.add(labelNamaDaftarCustomer);
        cardRegis.add(txtNamaDaftarCustomer);
        cardRegis.add(errorNamaDaftarCustomer);
        cardRegis.add(labelEmailDaftarCustomer);
        cardRegis.add(txtEmailDaftarCustomer);
        cardRegis.add(errorEmailDaftarCustomer);
        cardRegis.add(labelNomorHpDaftarCustomer);
        cardRegis.add(txtNomorHpDaftarCustomer);
        cardRegis.add(errorNomorHpDaftarCustomer);
        cardRegis.add(labelPasswordDaftarCustomer);
        cardRegis.add(txtPasswordDaftarCustomer);
        cardRegis.add(errorPasswordDaftarCustomer);
        cardRegis.add(btnDaftarCustomer);
        cardRegis.add(toLoginCustomerDaftarCustomer);
        cardRegis.add(toDaftarMitraDaftarCustomer);
        cardRegis.add(toLoginMitraDaftarCustomer);
        cardRegis.add(toLoginAdminDaftarCustomer);
    }

    public void initsDaftarMitra() {
        this.setTitle("Daftar Mitra");
        cardRegis.removeAll();
        titleRegis.setText("Daftar Mitra");
        cardRegis.add(titleRegis);

        cardRegis.add(labelNamaDaftarMitra);
        cardRegis.add(txtNamaDaftarMitra);
        cardRegis.add(errorNamaDaftarMitra);
        cardRegis.add(labelEmailDaftarMitra);
        cardRegis.add(txtEmailDaftarMitra);
        cardRegis.add(errorEmailDaftarMitra);
        cardRegis.add(labelNomorHpDaftarMitra);
        cardRegis.add(txtNomorHpDaftarMitra);
        cardRegis.add(errorNomorHpDaftarMitra);
        cardRegis.add(labelPasswordDaftarMitra);
        cardRegis.add(txtPasswordDaftarMitra);
        cardRegis.add(errorPasswordDaftarMitra);
        cardRegis.add(btnDaftarMitra);
        cardRegis.add(toLoginMitraDaftarMitra);
        cardRegis.add(toDaftarCustomerDaftarMitra);
        cardRegis.add(toLoginCustomerDaftarMitra);
        cardRegis.add(toLoginAdminDaftarMitra);
    }
}
