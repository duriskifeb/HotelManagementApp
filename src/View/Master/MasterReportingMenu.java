package View.Master;

import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;

import Util.InputUtilities;
import View.AppRouter;
import ViewModel.MasterViewModel.MasterReportingViewModel;

public class MasterReportingMenu {
    private final MasterReportingViewModel masterReportingVM;

    public MasterReportingMenu(MasterReportingViewModel masterReportingVM) {
        this.masterReportingVM = masterReportingVM;
    }

    public void showMasterReportingMenu() {
        InputUtilities.cls();
        System.out.println("SHOW ALL REPORT");
        System.out.println("============================================================");
        InputUtilities.pressEnter();
        AppRouter.navigateTo(MASTER_MAIN_MENU);
    }
}
