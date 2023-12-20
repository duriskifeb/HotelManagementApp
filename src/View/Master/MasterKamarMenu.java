package View.Master;

import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;
import static View.Components.CustomerView.*;
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

    public void showMasterKamarMenu() {
        // CONTOH
        while(AppRouter.activeRoute == AppRouter.AppRoute.MASTER_KAMAR){
            masterKamarVM.selectKamar("AADS");
            if(masterKamarVM.getSelectedKamar() != null){
                AppRouter.navigateTo(AppRouter.AppRoute.SUB_MASTER_DETAIL_KAMAR);
            }

            // TODO @Daavid pilihan saat sudah pilih kamar
        }
    }

    String inputUser;
    public void showDetailKamarMenu() {
        System.out.println();
        while(AppRouter.activeRoute == AppRouter.AppRoute.SUB_MASTER_DETAIL_KAMAR){
            System.out.println("MASTER DETAIL KAMAR");
            System.out.println("1. Show detail");
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


    private void detailMasterKamar() {
        System.out.println(" NO. KAMAR \t\tKAPASITAS \t\tHARGA \t\t\t JENIS \t\tSTATUS");

        viewAllDataKamar(masterKamarVM.getListKamar());
    }

    private void editMasterKamar() {
        try {

        System.out.print("No. kamar\t: ");
        String noKamar = InputUtilities.input.readLine();

        System.out.print("Kapasitas\t: ");
        int kapasitas = InputUtilities.input.read();

        System.out.print("Jenis\t: ");
        AppEnums.JenisKamar jenisKamar = jenisKamar();

        System.out.print("Harga\t: ");
        double harga = InputUtilities.input.read();

        System.out.print("Status kamar\t: ");
        AppEnums.StatusKamar statusKamar = statusKamar();

            System.out.print("Apa anda yakin?(y/n)");
            String yn = InputUtilities.input.readLine();
            if(yn.equalsIgnoreCase("y")){
                masterKamarVM.editKamar(noKamar, kapasitas, jenisKamar, harga, statusKamar);
            } else {
                System.out.println("Perubahan dibatalkan");
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    private void deleteMasterKamar() {
        System.out.print("Masukkan no kamar : ");
        try {
        String noKamar = InputUtilities.input.readLine();

            System.out.println("Anda yakin ingin menghapus kamar?(y/n)");
            String yn = InputUtilities.input.readLine();
            if(yn.equalsIgnoreCase("y")){
                masterKamarVM.deleteKamar(noKamar);
            } else {
                System.out.println("Perubahan dibatalkan");
            }

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }


    private AppEnums.JenisKamar jenisKamar(){
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
            return  null;
        }
    }
}
