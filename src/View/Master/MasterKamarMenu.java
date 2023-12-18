package View.Master;

import View.AppRouter;
import ViewModel.MasterViewModel.MasterKamarViewModel;

public class MasterKamarMenu {
    private final MasterKamarViewModel masterKamarVM;

    public MasterKamarMenu(MasterKamarViewModel masterKamarVM) {
        this.masterKamarVM = masterKamarVM;
    }

    public void showMasterKamarMenu() {
    }

    public void showDetailKamarMenu() {
        System.out.println("Master Detail Kamar");
        while(AppRouter.activeRoute == AppRouter.AppRoute.SUB_MASTER_DETAIL_KAMAR){

        }
        // edit ->
        // update
        // delete
        // show detail
        // back
        AppRouter.navigateTo(AppRouter.AppRoute.MASTER_MAIN_MENU);
    }
    // TODO @David
    // add new sub menu methods to Create (Register), View, Update, and Delete Kamar


}
