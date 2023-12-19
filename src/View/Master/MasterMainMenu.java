package View.Master;

import Util.InputUtilities;
import View.AppRouter;
import ViewModel.AuthViewModel.AuthViewModel;

import java.io.IOException;

import static View.AppRouter.AppRoute.*;

public class MasterMainMenu {
    private final AuthViewModel authViewModel;

    public MasterMainMenu(AuthViewModel authViewModel) {
        this.authViewModel = authViewModel;
    }

    String inputUser;
    public void showMasterMainMenu() {
        while(AppRouter.activeRoute == MASTER_MAIN_MENU){
            System.out.println("MENU MANAJER");
            System.out.println("Selamat Datang : " + authViewModel.loggedUser.getUserID() + " - " + authViewModel.loggedUser.getNama());
            System.out.println("0 to logout");
            System.out.println("1 Detail kamar");
            System.out.println("2 Reporting");
            System.out.println();
            System.out.print("Masukkan Pilihan : ");
            try {
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        AppRouter.navigateTo(SUB_MASTER_DETAIL_KAMAR);
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

    // TODO @David add main menu master to access the all submenus

}
