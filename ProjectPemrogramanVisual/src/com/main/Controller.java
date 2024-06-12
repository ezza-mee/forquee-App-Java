package com.main;

import com.views.*;

public class Controller {

    private static cLoginView frameLogin = new cLoginView();
    private static cRegisView frameRegis = new cRegisView();

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

    }

    public static void showDashboardMitra(Integer id) {
        cDashboardMitraView dashboarMitra = new cDashboardMitraView(id);
        dashboarMitra.setVisible(true);
    }

    public static void showDashboardAdmin(boolean statusLogin) {
        dashboardAdminView dashboardAdmin = new dashboardAdminView(statusLogin);
        dashboardAdmin.setVisible(true);
    }

}
