package View.Master;

import static Util.Formatting.formatMessageOutput;
import static View.AppRouter.AppRoute.MASTER_KAMAR;
import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;
import static View.AppRouter.AppRoute.SUB_MASTER_DETAIL_KAMAR;
import static View.Components.KamarView.*;

import java.io.IOException;

import Data.AppEnums.AppEnums;
import Data.DataSource.KamarDataSource;
import Data.Model.Kamar;
import Util.InputUtilities;
import View.AppRouter;
import View.Components.KamarView;
import ViewModel.MasterViewModel.MasterKamarViewModel;

public class MasterKamarMenu {
    private final MasterKamarViewModel masterKamarVM;

    public MasterKamarMenu(MasterKamarViewModel masterKamarVM) {
        this.masterKamarVM = masterKamarVM;
    }

    String inputUser;

    public void showMasterKamarMenu() {
        // CONTOH
        while (AppRouter.activeRoute == AppRouter.AppRoute.MASTER_KAMAR) {
            System.out.println();
            System.out.println("MASTER KAMAR");
            System.out.println("1. Show All Kamar");
            System.out.println("2. Pilih Kamar");
            System.out.println("3. Tambah Kamar");
            System.out.println("0. Back");
            System.out.println();
            try {
                System.out.print("Masukkan Pilihan : ");
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        System.out.println("All Data Kamar");
                        showAllKamar();
                        break;
                    case "2":
                        System.out.println("Pilih Kamar");
                        System.out.print("No. kamar\t: ");
                        String noKamar = InputUtilities.input.readLine();
                        masterKamarVM.selectKamar(noKamar);
                        if (masterKamarVM.getSelectedKamar() != null) {
                            AppRouter.navigateTo(AppRouter.AppRoute.SUB_MASTER_DETAIL_KAMAR);
                        }
                        break;
                    case "3":
                        System.out.println("Tambah Kamar");
                        addKamar();
                        break;

                    case "0":
                        AppRouter.navigateTo(MASTER_MAIN_MENU);
                        break;
                    default:
                        formatMessageOutput("Input Tidak Valid");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }

    public void showDetailKamarMenu() {
        while (AppRouter.activeRoute == AppRouter.AppRoute.SUB_MASTER_DETAIL_KAMAR) {
            System.out.println();
            System.out.println("DETAIL KAMAR - " + masterKamarVM.getSelectedKamar().getNoKamar());
            System.out.println("1. Show Detail Kamar");
            System.out.println("2. Edit");
            System.out.println("3. Delete");
            System.out.println("0. Back");
            System.out.println();
            System.out.print("Masukkan Pilihan : ");
            try {
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        System.out.println("SHOW DETAIL");
                        detailMasterKamar();
                        break;
                    case "2":
                        System.out.println("EDIT");
                        editMasterKamar();
                        break;
                    case "3":
                        System.out.println("DELETE");
                        deleteMasterKamar();
                        break;
                    case "0":
                        AppRouter.navigateTo(MASTER_MAIN_MENU);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        AppRouter.navigateTo(AppRouter.AppRoute.MASTER_MAIN_MENU);
    }

    private void editMasterKamar() {
        try {
            System.out.println("Ubah Data Kamar (kosongi input jika tidak ingin mengubah data) ");
            System.out.print("No. kamar\t: ");
            String noKamar = InputUtilities.input.readLine();

            masterKamarVM.selectKamar(noKamar);

            System.out.println("\nUbah data");
            System.out.print("Kapasitas\t: ");
            int kapasitas = InputUtilities.input.read();
            InputUtilities.input.readLine(); // Biar bawahnya kebaca

            System.out.print("Jenis\t: ");
            AppEnums.JenisKamar jenisKamar = jenisKamar();

            System.out.print("Harga\t: ");
            double harga = InputUtilities.input.read();
            InputUtilities.input.readLine(); // Biar bawahnya kebaca

            System.out.print("Status kamar\t: ");
            AppEnums.StatusKamar statusKamar = statusKamar();

            System.out.print("Apa anda yakin?(y/n): ");
            String yn = InputUtilities.input.readLine();
            if (yn.equalsIgnoreCase("y")) {
                masterKamarVM.editKamar(noKamar, kapasitas, jenisKamar, harga, statusKamar);
            } else {
                System.out.println("Perubahan dibatalkan");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void showAllKamar() {
        System.out.println(" NO. KAMAR \tKAPASITAS \t\tHARGA \t\t\t JENIS \t\tSTATUS");

        viewAllDataKamar(masterKamarVM.getListKamar());
    }

    private void detailMasterKamar() {
        System.out.println(" NO. KAMAR \tKAPASITAS \t\tHARGA \t\t\t JENIS \t\tSTATUS");

        viewDataSelectedKamar(masterKamarVM.getSelectedKamar());
    }

    private void addKamar() {
        try {
            System.out.print("No. Kamar\t: ");
            String noKamar = InputUtilities.input.readLine();

            System.out.print("Kapasitas\t: ");
            int kapasitas = InputUtilities.input.read();
            InputUtilities.input.readLine(); // biar bawahnya kebaca

            System.out.print("Jenis\t: ");
            AppEnums.JenisKamar jenis = jenisKamar();

            System.out.print("Harga\t: ");
            double harga = InputUtilities.input.read();
            InputUtilities.input.readLine(); // biar bawahnya kebaca

            System.out.print("Status\t: ");
            AppEnums.StatusKamar status = statusKamar();

            System.out.print("Apa anda yakin?(y/n): ");
            String yn = InputUtilities.input.readLine();

            if (yn.equalsIgnoreCase("y")) {
                masterKamarVM.addNewKamar(noKamar, kapasitas, jenis, harga, status);
            } else {
                System.out.println("Perubahan dibatalkan");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void deleteMasterKamar() {
        try {
            System.out.print("Anda yakin ingin menghapus kamar ini?(y/n): ");
            String yn = InputUtilities.input.readLine();
            if (yn.equalsIgnoreCase("y")) {
                masterKamarVM.deleteKamar(masterKamarVM.getSelectedKamar().getNoKamar());
                AppRouter.navigateTo(SUB_MASTER_DETAIL_KAMAR);
            } else {
                System.out.println("Perubahan dibatalkan");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private AppEnums.JenisKamar jenisKamar() {
        try {
            String jenisString = InputUtilities.input.readLine();
            return switch (jenisString.toLowerCase()) {
                case "single" -> AppEnums.JenisKamar.SINGLE;
                case "double" -> AppEnums.JenisKamar.DOUBLE;
                case "family" -> AppEnums.JenisKamar.FAMILY;
                case "vip" -> AppEnums.JenisKamar.VIP;
                case "business" -> AppEnums.JenisKamar.BUSINESS;
                default -> null;
            };
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private AppEnums.StatusKamar statusKamar() {
        try {
            String statusString = InputUtilities.input.readLine();
            return switch (statusString.toLowerCase()) {
                case "available" -> AppEnums.StatusKamar.AVAILABLE;
                case "booked" -> AppEnums.StatusKamar.BOOKED;
                case "cleaning" -> AppEnums.StatusKamar.CLEANING;
                case "occupied" -> AppEnums.StatusKamar.OCCUPIED;
                default -> null;
            };
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
