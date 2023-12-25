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
            InputUtilities.cls();
            System.out.println("==============================");
            System.out.println("         MENU PEGAWAI         ");
            System.out.println("==============================");
            System.out.println("Selamat Datang : " + authViewModel.loggedUser.getUserID() + " - "
                    + authViewModel.loggedUser.getNama());
            System.out.println();
            System.out.println("1. Kamar");
            System.out.println("2. Pelanggan");
            System.out.println("3. Transaksi");
            System.out.println("4. Reporting");
            System.out.println("0. Logout");
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
                throw new RuntimeException(e);
            }
        }

    }

    private void showMenuTransaksi() {
        // # Transaksi #
        // - lihat list transaksi
        // - cari transaksi (lihat transaksi detail)
        // - buat transaksi baru
        // - pilih transaksi
        // - bayar
        // - check in
        // - check out
        // - batalkan transaksi
    }

    private void showMenuReporting() {

        // # Laporan #
        // - Buat (generate) Laporan
        // - Lihat generated laporan
        // - Simpan Laporan

    }

    private void showMenuPelanggan() {

        while (AppRouter.activeRoute == SUB_PEGAWAI_CUSTOMER) {

            System.out.println();
            System.out.println("Menu Customer Pegawai");
            System.out.println("==============");
            System.out.println("1. Transaksi");
            System.out.println("0. Kembali");

            System.out.print("Masukkan Pilihan : ");
            try {
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        AppRouter.navigateTo(TRANSAKSI);
                        // showMenuTransaksi();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        showMenuKamar();
                        break;
                    case "0":
                        AppRouter.navigateTo(LOGIN);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // # Pelanggan #
        // - lihat list pelanggan
        // - register pelanggan
        // - lihat data detail pelanggan (cari pelanggan)

    }

    private void showMenuKamar() {

        // # Kamar #
        // - lihat list kamar ( beserta status)
        // - lihat list kamar tersedia
        // - lihat detail kamar (cari kamar)

    }
}
