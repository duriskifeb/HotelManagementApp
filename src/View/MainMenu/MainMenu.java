package View.MainMenu;

import Util.InputUtilities;
import View.AppRouter;
import ViewModel.AuthViewModel.AuthViewModel;

import static View.AppRouter.AppRoute.*;

import java.io.IOException;

public class MainMenu {
    private final AuthViewModel authViewModel;

    public MainMenu(AuthViewModel authViewModel) {
        this.authViewModel = authViewModel;
    }

    String inputUser;

    public void showMainMenu() {
        while (AppRouter.activeRoute == AppRouter.AppRoute.MAIN_MENU) {
            InputUtilities.cls();
            System.out.println("==============================");
            System.out.println("         MENU PENGUNJUNG         ");
            System.out.println("==============================");
            //untuk welcome dan memanggil data pelanggan dan siapa saja yang datatng
            System.out.println("Selamat Datang : " + authViewModel.loggedUser.getUserID() + " - "
                    + authViewModel.loggedUser.getNama());
            System.out.println();
            //menu isi perpustakaan
            System.out.println("1. Katalog");
            System.out.println("2. Pegawai");
            System.out.println("3. Peminjaman");
            System.out.println("4. Peraturan");
            System.out.println("5. Laporan");
            System.out.println("0. Logout");
            System.out.println();
            System.out.print("Masukkan Pilihan : ");
            try {
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        AppRouter.navigateTo(SUB_PEGAWAI_KAMAR);
                        break;
                    case "2":
                        AppRouter.navigateTo(SUB_PEGAWAI_CUSTOMER);
                        break;
                    case "3":
                        AppRouter.navigateTo(TRANSAKSI);
                        break;
                    case "4":
                        AppRouter.navigateTo(REPORTING);
                        break;
                    case "0":
                        authViewModel.doLogout();
                        AppRouter.navigateTo(LOGIN);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (IOException e) {
                System.out.println("Invalid Choice");
            }
        }

    }

}
