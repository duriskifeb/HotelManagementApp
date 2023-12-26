package View.Master;

import ViewModel.TransaksiViewModel.TransaksiViewModel;
import ViewModel.AuthViewModel.AuthViewModel;

import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;
import static View.Components.TransaksiView.headerViewTransaksi;
import static View.Components.TransaksiView.viewAllTransaksi;
import static View.Components.TransaksiView.viewDetailSelectedTransaksi;
import static Util.Formatting.formatMessageOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import Data.AppEnums.AppEnums;
import Util.InputUtilities;
import View.AppRouter;
import ViewModel.MasterViewModel.MasterCustomerViewModel;
import ViewModel.MasterViewModel.MasterKamarViewModel;
import ViewModel.MasterViewModel.MasterTransaksiViewModel;

public class MasterTransaksiMenu {
    private final MasterTransaksiViewModel masterTransaksiVM;
    private final MasterCustomerViewModel masterCustomerVM;
    private final MasterKamarViewModel masterKamarVM;

    public MasterTransaksiMenu(
            MasterTransaksiViewModel masterTransaksiVM,
            MasterCustomerViewModel masterCustomerVM,
            MasterKamarViewModel masterKamarVM) {
        this.masterTransaksiVM = masterTransaksiVM;
        this.masterCustomerVM = masterCustomerVM;
        this.masterKamarVM = masterKamarVM;
    }

    String inputUser;

    public void showMasterTransaksiMenu() {
        while (AppRouter.activeRoute == AppRouter.AppRoute.MASTER_TRANSAKSI) {
            InputUtilities.cls();
            System.out.println("============================");
            System.out.println("      MASTER TRANSAKSI      ");
            System.out.println("============================");
            System.out.println("1. Lihat List Transaksi");
            System.out.println("2. Buat Transaksi Baru");
            System.out.println("3. Pilih Transaksi");
            System.out.println("0. Kembali");

            System.out.print("Masukkan Pilihan : ");
            try {

                inputUser = InputUtilities.input.readLine();
                System.out.println();
                switch (inputUser) {
                    case "1":
                        showAllTransaksi();
                        break;
                    case "2":
                        newTransaksi();
                        break;
                    case "3":
                        chooseTransaksi();
                        break;
                    case "0":
                        AppRouter.navigateUp();
                        break;
                    default:
                        formatMessageOutput("Invalid Choice");
                }
                System.out.println();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void showAllTransaksi() {
        InputUtilities.cls();
        headerViewTransaksi();
        viewAllTransaksi(masterTransaksiVM.getAllTransaksi());
        InputUtilities.pressEnter();
    }

    private void newTransaksi() {
        InputUtilities.cls();
        System.out.println("============================");
        System.out.println("        NEW TRANSAKSI       ");
        System.out.println("============================");

        System.out.println();

        try {
            System.out.print("Tanggal Mulai (dd-MM-yyyy) : "); 
            Date startDate = InputUtilities.getDateFromInput();
            System.out.print("Tanggal Berakhir (dd-MM-yyyy) : ");
            Date endDate = InputUtilities.getDateFromInput();

            String nik = getNIKCustomer();
            viewAllDataKamar(masterKamarVM.getListKamar().stream()
                    .filter(kamar -> kamar.getStatusKamar() == AppEnums.StatusKamar.AVAILABLE)
                    .collect(Collectors.toCollection(ArrayList::new)));

            System.out.println();
            System.out.print("Masukkan Nomor Kamar yang dipilih dari yang tersedia diatas : ");
            String noKamar = InputUtilities.input.readLine();
            if (!nik.isBlank()) {
                masterTransaksiVM.createInitialTransaksi(
                        nik,
                        authViewModel.loggedUser,
                        noKamar,
                        AppEnums.Pembayaran.CASH // default
                );

                if (masterTransaksiVM.currentActiveTransaksi != null) {
                    masterTransaksiVM.currentActiveTransaksi.setStartDate(startDate);
                    masterTransaksiVM.currentActiveTransaksi.setStartDate(endDate);
                    AppRouter.navigateTo(SUB_MASTER_TRANSAKSI);
                }

            } else {
                formatMessageOutput("Data Pelanggan Belum Ada, Lakukan register pelanggan dulu");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void chooseTransaksi() {
        System.out.println("Pilih Transaksi ");
        System.out.print("Masukkan No Transaksi : ");
        try {
            String noTransaksi = InputUtilities.input.readLine();
            masterTransaksiVM.selectTranasksi(noTransaksi);
            if (masterTransaksiVM.currentActiveTransaksi != null) {
                AppRouter.navigateTo(SUB_MASTER_TRANSAKSI);
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
            masterTransaksiVM.selectTranasksi(noTransaksi);
            if (masterTransaksiVM.currentActiveTransaksi != null) {
                AppRouter.navigateTo(SUB_MASTER_TRANSAKSI);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean conditionHaveToPay() {
        return masterTransaksiVM.currentActiveTransaksi.getStatusTransaksi() == AppEnums.StatusTransaksi.PENDING
                || masterTransaksiVM.currentActiveTransaksi.getStatusTransaksi() == AppEnums.StatusTransaksi.ONGOING;
    }

    private boolean conditionCanStillEdit() {
        return masterTransaksiVM.currentActiveTransaksi.getStatusTransaksi() == AppEnums.StatusTransaksi.PENDING;
    }

    private boolean conditionAlreadyCheckIn() {
        return masterTransaksiVM.currentActiveTransaksi.getStatusTransaksi() == AppEnums.StatusTransaksi.ONGOING;
    }

    public void subTransaksiMenu() {
        while (AppRouter.activeRoute == AppRouter.AppRoute.SUB_MASTER_TRANSAKSI) {
            // - lihat detail
            // - bayar
            // - check in
            // - check out
            // - batalkan transaksi
            // commit transaksi

            System.out.println();
            System.out.println("============================");
            System.out.println("Sub-Menu Transaksi " + masterTransaksiVM.currentActiveTransaksi.getNoTransaksi());
            System.out.println("============================");
            System.out.println("1. Lihat Detail");
            if (conditionHaveToPay()) {
                System.out.println("2. Bayar");
            }
            if (conditionCanStillEdit()) {
                System.out.println("---------------------------");
                System.out.println("3. Ubah Tanggal Mulai");
                System.out.println("4. Ubah Tanggal Selesai");
                System.out.println("---------------------------");
                System.out.println("5. Tambah Tamu");
                System.out.println("6. Kurangi Tamu");
                System.out.println("---------------------------");
                System.out.println("7. Tambah Kamar");
                System.out.println("8. Kurangi Kamar");
                System.out.println("---------------------------");
                System.out.println("9. Check In");
            }
            if (conditionAlreadyCheckIn()) {
                System.out.println("10. Check Out");
            }
            System.out.println("11. Commit Transaksi");
            System.out.println("0. Kembali");

            System.out.print("Masukkan Pilihan : ");
            try {
                inputUser = InputUtilities.input.readLine();
                boolean conditionCantEdit = !conditionCanStillEdit() && Integer.parseInt(inputUser) <= 3
                        && Integer.parseInt(inputUser) >= 10;
                boolean conditionHaveToPay = !conditionHaveToPay() && inputUser.equals("2");
                boolean conditionAlreadyCheckIn = !conditionHaveToPay() && inputUser.equals("10");

                if (conditionCantEdit || conditionHaveToPay || conditionAlreadyCheckIn) {
                    inputUser = "";
                }
                System.out.println();
                switch (inputUser) {
                    case "1":
                        viewDetailSelectedTransaksi(masterTransaksiVM.currentActiveTransaksi);
                        break;
                    case "2":
                        bayarTransaksi();
                        break;
                    case "3":
                        ubahTanggalMulai();
                        break;
                    case "4":
                        ubahTanggalSelesai();
                        break;
                    case "5":
                        tambahTamu();
                        break;
                    case "6":
                        kurangiTamu();
                        break;
                    case "7":
                        tambahKamar();
                        break;
                    case "8":
                        kurangiKamar();
                        break;
                    case "9":
                        checkIn();
                        break;
                    case "10":
                        checkOut();
                        break;

                    case "11":
                        masterTransaksiVM.commitTransaksi();
                        break;
                    case "0":
                        masterTransaksiVM.commitTransaksi();
                        AppRouter.navigateUp();
                        // AppRouter.navigateTo(TRANSAKSI);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
                System.out.println();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void checkOut() {
        System.out.println("Check out");
        masterTransaksiVM.checkOut();
    }

    private void checkIn() {
        System.out.println("Check in");
        masterTransaksiVM.checkIn();
    }

    private void kurangiKamar() {
        try {
            System.out.println("Kurangi Kamar");
            System.out.print("Masukkan Nomor Kamar : ");
            String noKamar = InputUtilities.input.readLine();
            masterTransaksiVM.removeKamar(noKamar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void tambahKamar() {
        try {
            System.out.println("Tambakan Kamar");
            System.out.print("Masukkan Nomor Kamar : ");
            String noKamar = InputUtilities.input.readLine();
            masterTransaksiVM.addKamar(noKamar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void kurangiTamu() {
        try {
            System.out.println("Hapus tamu dari transaksi");
            System.out.print("Masukkan NIK : ");
            String nik = InputUtilities.input.readLine();
            masterTransaksiVM.removeCustomer(nik);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void tambahTamu() {
        System.out.println("tambahkan tamu ke transaksi");
        String nik = getNIKCustomer();
        if (!nik.isBlank()) {
            masterTransaksiVM.addCustomer(nik);
        }
    }

    private void ubahTanggalSelesai() {
        System.out.println("Ubah Tanggal Selesai");
        System.out.print("Masukkan Tanggal Selesai (dd-MM-yyyy) : ");
        Date date = InputUtilities.getDateFromInput();
        if (date != null) {
            masterTransaksiVM.currentActiveTransaksi.setEndDate(date);
        } else {
            formatMessageOutput("Invalid Date");
        }
    }

    private void ubahTanggalMulai() {
        System.out.println("Ubah Tanggal Mulai");

        System.out.print("Masukkan Tanggal Mulai (dd-MM-yyyy) : ");
        Date date = InputUtilities.getDateFromInput();
        if (date != null) {
            masterTransaksiVM.currentActiveTransaksi.setStartDate(date);
        } else {
            formatMessageOutput("Invalid Date");
        }
    }

    private void bayarTransaksi() {
        try {
            System.out.println("Pembayaran Transaksi");
            double amountBayar = 0;
            System.out.print("Masukkan Metode Bayar (bank/ cash) : ");
            AppEnums.Pembayaran metodebayar = InputUtilities.getMetodeBayarFromInput();

            if (metodebayar == AppEnums.Pembayaran.CASH) {
                System.out.print("Masukkan Amount Bayar : ");
                amountBayar = Double.parseDouble(InputUtilities.input.readLine());
            } else {
                amountBayar = masterTransaksiVM.currentActiveTransaksi.getTotal();
            }
            masterTransaksiVM.bayar(metodebayar, amountBayar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
