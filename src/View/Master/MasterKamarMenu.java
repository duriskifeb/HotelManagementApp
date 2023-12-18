package View.Master;

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

    public void showDetailKamarMenu() {
        System.out.println("Master Detail Kamar");
        while(AppRouter.activeRoute == AppRouter.AppRoute.SUB_MASTER_DETAIL_KAMAR){

            // TODO @Daavid pilihan saat sudah pilih kamar
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
