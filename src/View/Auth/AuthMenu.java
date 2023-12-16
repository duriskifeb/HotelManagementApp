package View.Auth;

import Statics.StaticsInput;
import ViewModel.AuthViewModel.AuthViewModel;
import View.AppRouter;

import java.io.IOException;

import static View.AppRouter.AppRoute.LOGIN;

public class AuthMenu {
    private final AuthViewModel authViewModel;

    public AuthMenu(AuthViewModel authViewModel) {
        this.authViewModel = authViewModel;
    }

    String inputUser;

    public void showLogin() {
        while(AppRouter.activeRoute == LOGIN){
            System.out.println("LOGIN MENU");
            System.out.println("0 to exit");
            System.out.println("1 to Login");
            System.out.print("Masukkan Pilihan : ");
            try {
                inputUser = StaticsInput.input.readLine();
                switch (inputUser) {
                    case "1":
                        showLoginInputs();
                        break;
                    case "0":
                        AppRouter.navigateTo(AppRouter.AppRoute.EXIT);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private void showLoginInputs() {

        try {
            System.out.print("Masukkan ID atau Email : ");
            String userIDEmail = StaticsInput.input.readLine();
            System.out.print("Masukkan Password : ");
            String userPass= StaticsInput.input.readLine();

            this.authViewModel.doLogin(userIDEmail, userPass);
            if(this.authViewModel.loggedUser != null){
                switch (this.authViewModel.loggedUser.getRole()){
                    case MANAGER :
                        AppRouter.navigateTo(AppRouter.AppRoute.MASTER_MAIN_MENU);
                        break;
                    case PEGAWAI:
                        AppRouter.navigateTo(AppRouter.AppRoute.MAIN_MENU);
                        break;
                    default:
                        System.out.println("HAH!?");
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
