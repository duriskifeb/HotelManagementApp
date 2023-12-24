package View.Master;

import static Util.Formatting.invalidChoice;
import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;
import static View.AppRouter.AppRoute.MASTER_PEGAWAI;
import static View.AppRouter.AppRoute.SUB_MASTER_DETAIL_PEGAWAI;
import static View.Components.KamarView.viewAllDataKamar;
import static View.Components.PegawaiView.*;

import java.io.IOException;

import Util.InputUtilities;
import View.AppRouter;
import View.AppRouter.AppRoute;
import ViewModel.MasterViewModel.MasterPegawaiViewModel;

public class MasterPegawaiMenu {
    private final MasterPegawaiViewModel masterPegawaiVM;

    public MasterPegawaiMenu(MasterPegawaiViewModel masterPegawaiVM) {
        this.masterPegawaiVM = masterPegawaiVM;
    }

    String inputUser;

    public void showMasterPegawaiMenu() {
        while (AppRouter.activeRoute == MASTER_PEGAWAI) {
            InputUtilities.cls();
            System.out.println("==============================");
            System.out.println("         MENU MANAJER         ");
            System.out.println("==============================");
            System.out.println("1. Show all pegawai");
            System.out.println("2. choose pegawai");
            System.out.println("3. Add pegawai");
            System.out.println("0. Back");
            System.out.println();
            try {
                System.out.print("Masukkan Pilihan : ");
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        showAllPegawai();
                        break;
                    case "2":
                        choosingPegawai();
                        break;
                    case "3":
                        addPegawai();
                        break;
                    case "0":
                        AppRouter.navigateTo(MASTER_MAIN_MENU);
                        break;
                    default:
                        invalidChoice();
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showAllPegawai() {
        InputUtilities.cls();
        System.out.println("SHOW ALL KAMAR");
        System.out.println("============================================================");
        System.out.println(" USER ID \tNAMA \t\tEMAIL \t\t ROLE");
        System.out.println("============================================================");
        
        viewAllDataPegawai(masterPegawaiVM.getListPegawai());
        System.out.println("============================================================");

        InputUtilities.pressEnter();
    }

    private void choosingPegawai() {
        try {
            InputUtilities.cls();
            System.out.println("==============================");
            System.out.println("        CHOOSE PEGAWAI        ");
            System.out.println("==============================");
            System.out.print("No. kamar\t: ");
            String userID = InputUtilities.input.readLine();
            masterPegawaiVM.selectPegawai(userID);
            System.out.println("==============================");
            InputUtilities.pressEnter();

            if (masterPegawaiVM.getSelectedPegawai() != null) {
                AppRouter.navigateTo(AppRouter.AppRoute.SUB_MASTER_DETAIL_PEGAWAI);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addPegawai() {

    }

    public void showDetailPegawaiMenu(){
        while (AppRouter.activeRoute == SUB_MASTER_DETAIL_PEGAWAI) {
            InputUtilities.cls();
            System.out.println("==============================");
            System.out.println("      SHOW DETAIL PEGAWAI     ");
            System.out.println("==============================");
            System.out.println("Selected pegawai : " + masterPegawaiVM.getSelectedPegawai().getUserID());
            System.out.println();
            System.out.println("1. Show detail");
            System.out.println("2. Edit kamar");
            System.out.println("3. Delete kamar");
            System.out.println("0. Back");
            System.out.println();
            System.out.print("Masukkan Pilihan : ");
            try {
                System.out.print("Masukkan Pilihan : ");
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        showAllPegawai();
                        break;
                    case "2":
                        choosingPegawai();
                        break;
                    case "3":
                        addPegawai();
                        break;
                    case "0":
                        AppRouter.navigateTo(MASTER_MAIN_MENU);
                        break;
                    default:
                        invalidChoice();
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

