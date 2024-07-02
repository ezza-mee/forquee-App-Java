package com.main;

public class App {

    public static void main(String[] args) {

        // Controller.showLoginCustomer();
        // Controller.showLoginMitra();
        // Controller.showLoginAdmin();

        // Controller.showDaftarCustomer();
        // Controller.showDaftarMitra();
        // Controller.showDaftarAdmin();

        // Controller.showDashboardMitra(5);
        // Controller.showDashboardCustomer(1);
        // Controller.showDashboardAdmin(true);

        // Model.connection();

        // cLoginView auth = new cLoginView();
        // auth.initsLoginCustomer();
        // auth.setVisible(true);

        int userType = 1; // ganti nilai ini sesuai dengan login yang diinginkan

        switch (userType) {
            case 1:
                Controller.showLoginCustomer();
                break;
            case 2:
                Controller.showLoginMitra();
                break;
            case 3:
                Controller.showLoginAdmin();
                break;
            default:
                System.out.println("Tipe pengguna tidak dikenal.");
                break;
        }

    }
}
