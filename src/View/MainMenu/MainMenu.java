package View.MainMenu;

import Util.InputUtilities;
import View.AppRouter;
import ViewModel.AuthViewModel.AuthViewModel;

import static Util.InputUtilities.readInt;
import static Util.InputUtilities.cls;
import static Util.InputUtilities.readLine;
import static View.AppRouter.AppRoute.*;
import static View.Components.MainView.appHeader;

import java.io.IOException;

public class MainMenu {
    private final AuthViewModel authViewModel;

    public MainMenu(AuthViewModel authViewModel) {
        this.authViewModel = authViewModel;
    }
    String inputUser;

    public void showMainMenu() {
        while (AppRouter.activeRoute == AppRouter.AppRoute.MAIN_MENU) {
            System.out.println();
            appHeader();
            System.out.println("Selamat Datang : " + authViewModel.loggedUser.getUserID() + " - " + authViewModel.loggedUser.getNama());
            System.out.println("==============");
            System.out.println("1. Transaksi");
            System.out.println("2. Reporting");
            System.out.println("==============");
            System.out.println("3. Pelanggan");
            System.out.println("4. Kamar");
            System.out.println("0. Logout");
            System.out.print("Masukkan Pilihan : ");
            try {
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        AppRouter.navigateTo(TRANSAKSI);
                        break;
                    case "2":
                        AppRouter.navigateTo(REPORTING);
                        break;
                    case "3":
                        AppRouter.navigateTo(SUB_PEGAWAI_CUSTOMER);
                        break;
                    case "4":
                        AppRouter.navigateTo(SUB_PEGAWAI_KAMAR);
                        break;
                    case "0":
                        authViewModel.doLogout();
                        AppRouter.navigateTo(LOGIN);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
