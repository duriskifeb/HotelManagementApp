package View.Transaksi;

import Data.AppEnums.AppEnums;
import Util.InputUtilities;
import View.AppRouter;
import ViewModel.AuthViewModel.AuthViewModel;
import ViewModel.MasterViewModel.MasterCustomerViewModel;
import ViewModel.MasterViewModel.MasterKamarViewModel;
import ViewModel.TransaksiViewModel.TransaksiViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static Util.Formatting.formatMessageOutput;
import static View.AppRouter.AppRoute.MAIN_MENU;
import static View.AppRouter.AppRoute.SUB_PEGAWAI_TRANSAKSI;
import static View.Components.KamarView.viewAllDataKamar;
import static View.Components.TransaksiView.viewAllTransaksi;

public class TransaksiMenu {

    private final TransaksiViewModel transaksiVM;
    private final MasterKamarViewModel kamarVM;
    private final AuthViewModel authViewModel;
    private final MasterCustomerViewModel masterCustomerVM;

    public TransaksiMenu(TransaksiViewModel transaksiVM, MasterKamarViewModel kamarVM, AuthViewModel authViewModel, MasterCustomerViewModel masterCustomerVM) {
        this.transaksiVM = transaksiVM;
        this.kamarVM = kamarVM;
        this.authViewModel = authViewModel;
        this.masterCustomerVM = masterCustomerVM;
    }

    String inputUser;

    public void showTransaksiMenu() {
        //        # Transaksi #
//- lihat list transaksi
//- buat transaksi baru
//- pilih transaksi

        while (AppRouter.activeRoute == AppRouter.AppRoute.TRANSAKSI) {

            System.out.println();
            System.out.println("============================");
            System.out.println("Menu Transaksi");
            System.out.println("============================");
            System.out.println("1. Lihat List Transaksi");
            System.out.println("2. Buat Transaksi Baru");
            System.out.println("3. Pilih Transaksi");
            System.out.println("0. Kembali");

            System.out.print("Masukkan Pilihan : ");
            try {
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        System.out.println();
                        viewAllTransaksi(transaksiVM.getAllTransaksi());
                        System.out.println();
                        break;
                    case "2":
                        System.out.println();
                        initNewTransaksi();
                        System.out.println();
                        break;
                    case "3":
                        System.out.println();
                        pilihTransaksi();
                        System.out.println();
                        break;
                    case "0":
                        AppRouter.navigateTo(MAIN_MENU);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private void initNewTransaksi() {


        System.out.println("============================");
        System.out.println("Initializing Transaction");
        System.out.println("============================");

        System.out.println();

        try {
            String nik = getNIKCustomer();

            viewAllDataKamar(kamarVM.getListKamar().stream().filter(kamar -> kamar.getStatusKamar() == AppEnums.StatusKamar.AVAILABLE).collect(Collectors.toCollection(ArrayList::new)));

            System.out.println();
            System.out.print("Masukkan Nomor Kamar yang dipilih dari yang tersedia diatas : ");
            String noKamar = InputUtilities.input.readLine();
            if (!nik.isBlank()) {
                transaksiVM.createInitialTransaksi(
                        nik,
                        authViewModel.loggedUser,
                        noKamar,
                        AppEnums.Pembayaran.CASH // default
                );
            } else {
                formatMessageOutput("Data Pelanggan Belum Ada, Lakukan register pelanggan dulu");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private String getNIKCustomer() {
        String result = "";
        System.out.print("Masukkan NIK");
        String nik = InputUtilities.readLine();

        masterCustomerVM.selectCustomer(nik);
        if (masterCustomerVM.getSelectedCustomer() != null) {
            result = nik;
        } else {
            System.out.println("Data pelanggan tidak ditemukan");
            System.out.print("Daftarkan pelanggan ? (y/n) : ");
            String confirm = InputUtilities.readLine();
            if (confirm.equalsIgnoreCase("y")) {
                // register new pelanggan
                addNewCustomer();
                result = nik;
            }
        }
        return result;
    }

    private void addNewCustomer() {
        try {
            System.out.print("NIK\t: ");
            String nik = InputUtilities.input.readLine();

            System.out.print("Nama\t: ");
            String nama = InputUtilities.input.readLine();

            System.out.print("Email\t: ");
            String email = InputUtilities.input.readLine();

            System.out.print("Telp\t: ");
            String telp = InputUtilities.input.readLine();

            masterCustomerVM.addNewCustomer(nik, nama, email, telp);

            System.out.println("==============================");
            InputUtilities.pressEnter();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void pilihTransaksi() {

        System.out.println("Pilih Transaksi ");
        System.out.print("Masukkan No Transaksi : ");
        try {
            String noTransaksi = InputUtilities.input.readLine();
            transaksiVM.selectTranasksi(noTransaksi);
            if (transaksiVM.currentActiveTransaksi != null) {
                AppRouter.navigateTo(SUB_PEGAWAI_TRANSAKSI);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void subTransaksiPegawai() {
        while (AppRouter.activeRoute == AppRouter.AppRoute.SUB_PEGAWAI_TRANSAKSI) {
//        - lihat detail
//       - bayar
//       - check in
//       - check out
//      - batalkan transaksi
            // commit transaksi


        }
    }
}
