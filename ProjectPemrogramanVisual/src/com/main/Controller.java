package com.main;

import com.views.*;

public class Controller {

    private static cLoginView frameLogin = new cLoginView();
    private static cRegisView frameRegis = new cRegisView();

    private static cDashboardCustomerView dashboardCustomer;
    private static cDashboardMitraView dashboardMitra;
    private static cDashboardAdminView dashboardAdmin;

    public static void showLoginCustomer() {
        System.out.println("Showing Login Customer");
        frameLogin.setVisible(false);
        frameLogin.initsLoginCustomer();
        frameLogin.setVisible(true);
    }

    public static void showDaftarCustomer() {
        System.out.println("Showing Register Customer");
        frameRegis.setVisible(false);
        frameRegis.initsDaftarCustomer();
        frameRegis.setVisible(true);
    }

    public static void showLoginMitra() {
        System.out.println("Showing Login Mitra");
        frameLogin.setVisible(false);
        frameLogin.initsLoginMitra();
        frameLogin.setVisible(true);
    }

    public static void showDaftarMitra() {
        System.out.println("Showing Register Mitra");
        frameRegis.setVisible(false);
        frameRegis.initsDaftarMitra();
        frameRegis.setVisible(true);
    }

    public static void showLoginAdmin() {
        System.out.println("Showing Login Admin");
        frameLogin.setVisible(false);
        frameLogin.initsLoginAdmin();
        frameLogin.setVisible(true);
    }

    public static void showDashboardCustomer(Integer id) {
        System.out.println("Showing Dashboard Customer");
        hideLoginFrame();
        if (dashboardCustomer != null) {
            dashboardCustomer.setVisible(false);
        }
        dashboardCustomer = new cDashboardCustomerView(id);
        dashboardCustomer.setVisible(true);
    }

    public static void showDashboardMitra(Integer id) {
        System.out.println("Showing Dashboard Mitra");
        hideLoginFrame();
        if (dashboardMitra != null) {
            dashboardMitra.setVisible(false);
        }
        dashboardMitra = new cDashboardMitraView(id);
        dashboardMitra.setVisible(true);
    }

    public static void showDashboardAdmin(boolean statusLogin) {
        System.out.println("Showing Dashboard Admin");
        hideLoginFrame();
        if (dashboardAdmin != null) {
            dashboardAdmin.setVisible(false);
        }
        dashboardAdmin = new cDashboardAdminView(statusLogin);
        dashboardAdmin.setVisible(true);
    }

    public static void logout() {
        System.out.println("Logging out");
        if (dashboardCustomer != null) {
            dashboardCustomer.setVisible(false);
            dashboardCustomer = null;
        }
        if (dashboardMitra != null) {
            dashboardMitra.setVisible(false);
            dashboardMitra = null;
        }
        if (dashboardAdmin != null) {
            dashboardAdmin.setVisible(false);
            dashboardAdmin = null;
        }
        hideLoginFrame();
        showLoginCustomer();
    }

    public static void hideLoginFrame() {
        if (frameLogin != null) {
            frameLogin.setVisible(false);
        }
    }
}
