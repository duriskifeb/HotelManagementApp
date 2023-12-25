package View.MainMenu;

import Util.InputUtilities;
import View.AppRouter;
import ViewModel.AuthViewModel.AuthViewModel;

import static Util.InputUtilities.readInt;
import static Util.InputUtilities.cls;
import static Util.InputUtilities.readLine;
import static View.AppRouter.AppRoute.LOGIN;
import static View.Components.MainView.appHeader;

import java.io.IOException;

public class MainMenu {

    private final AuthViewModel authViewModel;
    int ch1;
    int ch2;

    // sementara
    String ID_Pegawai;
    String email;
    String pw;

    public MainMenu(AuthViewModel authViewModel) {
        this.authViewModel = authViewModel;
    }

    public void login() throws IOException {
        do {
            appHeader();
            System.out.println("\nSilahkan pilih menu login");
            System.out.println("1. Login Pegawai");
            System.out.println("2. Login Manager");
            System.out.println("0. Keluar");

            System.out.print("\nPilihan : ");
            ch1 = readInt();


            switch (ch1) {
                case 1:
                    next();
                    loginUser("Pegawai");
                    break;

                case 2:
                    next();
                    loginUser("Manager");
                    break;

                case 0:
                    next();
                    cls();
                    System.out.println("Menutup aplikasi");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nPilihan tidak ada");
                    next();
                    break;
            }
        } while (true);

    }

    public void loginUser(String UserRole) throws IOException {
        appHeader();
        System.out.println("Login : " + UserRole + "\n");

        System.out.print("ID\t  : ");
        ID_Pegawai = readLine();
        System.out.print("Email\t  : ");
        email = readLine();
        System.out.print("Password  : ");
        pw = readLine();

        next();

        // test (misal input benar)
        if ("Pegawai".equals(UserRole)) {
            menuPegawai();
        } else if ("Manager".equals(UserRole)) {
            menuManager();
        }

        // pengecekan kalau input salah kembali ke login()

    }

    public void menuPegawai() throws IOException {
        do {

            appHeader();
            System.out.println("Menu : Pegawai\n");
            System.out.println("1. Fitur 1");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch2 = readInt();

            switch (ch2) {
                case 1:
                    next();
                    fitur1();
                    break;

                case 0:
                    next();
                    break;

                default:
                    System.out.println("\nPilihan tidak ada");
                    next();
                    break;
            }

        } while (ch2 != 0);
    }

    public void menuManager() throws IOException {
        do {

            appHeader();
            System.out.println("Menu : Manager\n");
            System.out.println("1. Fitur 1");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch2 = readInt();

            switch (ch2) {
                case 1:
                    next();
                    fitur1();
                    break;

                case 0:
                    next();
                    break;

                default:
                    System.out.println("\nPilihan tidak ada");
                    next();
                    break;
            }

        } while (ch2 != 0);

    }

    public void fitur1() throws IOException {
        appHeader();
        System.out.println("\nIni Fitur 1");
        next();
    }

    public void next() throws IOException {
        System.out.println("\n==============================");
        System.out.print("\nTekan ENTER untuk melanjutkan");
        readLine();
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
                        showMenuTransaksi();
                        break;
                    case "2":
                        showMenuReporting();
                        break;
                    case "3":
                        showMenuPelanggan();
                        break;
                    case "4":
                        showMenuKamar();
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

    private void showMenuTransaksi() {
    }

    private void showMenuReporting() {
        
    }

    private void showMenuPelanggan() {
        
    }

    private void showMenuKamar() {
        
    }
}
