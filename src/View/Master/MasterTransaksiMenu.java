package View.Master;

import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;
import static View.Components.TransaksiView.viewAllTransaksi;

import Util.InputUtilities;
import View.AppRouter;
import ViewModel.MasterViewModel.MasterTransaksiViewModel;

public class MasterTransaksiMenu {
    private final MasterTransaksiViewModel masterTransaksiVM;

    public MasterTransaksiMenu(MasterTransaksiViewModel masterTransaksiVM) {
        this.masterTransaksiVM = masterTransaksiVM;
    }

    public void showMasterTransaksiMenu() {
        InputUtilities.cls();
        System.out.println("SHOW ALL TRANSAKSI");
        viewAllTransaksi(masterTransaksiVM.getAllTransaksi()); // tidak bisa mengambil list transaksi
        System.out.println("============================================================");
        InputUtilities.pressEnter();
        AppRouter.navigateTo(MASTER_MAIN_MENU);
    }
}
