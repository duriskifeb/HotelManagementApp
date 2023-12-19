package View.Master;

import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;
import static View.Components.CustomerView.*;
import static View.Components.KamarView.*;

import java.io.IOException;

import Util.InputUtilities;
import View.AppRouter;
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
            System.out.println("3. Update");
            System.out.println("4. Delete");
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
                        System.out.println("UPDATE");
                        updateMasterKamar();
                        break;
                    case "4":
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
    // TODO @David
    // add new sub menu methods to Create (Register), View, Update, and Delete Kamar

    private void detailMasterKamar() {
        viewAllDataKamar(null);
    }

    private void editMasterKamar() {
        
    }

    private void updateMasterKamar() {
        
    }

    private void deleteMasterKamar() {
        
    }


}
