package com.main;

import com.views.*;

public class Controller {

    private static cLoginView frameLogin = new cLoginView();
    private static cRegisView frameRegis = new cRegisView();

    private static cDashboardCustomerView dashboardCustomer;
    private static cDashboardMitraView dashboardMitra;
    private static cDashboardAdminView dashboardAdmin;

    public static void showLoginCustomer() {
        frameLogin.setVisible(false);
        frameLogin.initsLoginCustomer();
        frameLogin.setVisible(true);
    }

    public static void showDaftarCustomer() {
        frameRegis.setVisible(false);
        frameRegis.initsDaftarCustomer();
        frameRegis.setVisible(true);
    }

    public static void showLoginMitra() {
        frameLogin.setVisible(false);
        frameLogin.initsLoginMitra();
        frameLogin.setVisible(true);
    }

    public static void showDaftarMitra() {
        frameRegis.setVisible(false);
        frameRegis.initsDaftarMitra();
        frameRegis.setVisible(true);
    }

    public static void showLoginAdmin() {
        frameLogin.setVisible(false);
        frameLogin.initsLoginAdmin();
        frameLogin.setVisible(true);
    }

    public static void showDashboardCustomer(Integer id) {
        if (dashboardCustomer != null) {
            dashboardCustomer.setVisible(false);
        }
        dashboardCustomer = new cDashboardCustomerView(id);
        dashboardCustomer.setVisible(true);
    }

    public static void showDashboardMitra(Integer id) {
        if (dashboardMitra != null) {
            dashboardMitra.setVisible(false);
        }
        dashboardMitra = new cDashboardMitraView(id);
        dashboardMitra.setVisible(true);
    }

    public static void showDashboardAdmin(boolean statusLogin) {
        if (dashboardAdmin != null) {
            dashboardAdmin.setVisible(false);
        }
        dashboardAdmin = new cDashboardAdminView(statusLogin);
        dashboardAdmin.setVisible(true);
    }

    public static void logout() {
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
        showLoginCustomer();
    }
}
