package View.Master;

import static Util.Formatting.formatMessageOutput;
// import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;
import static View.Components.ReportingView.viewDetailSelectedReport;

import java.io.IOException;
import java.util.Date;

import Util.InputUtilities;
import View.AppRouter;
import ViewModel.AuthViewModel.AuthViewModel;
import ViewModel.MasterViewModel.MasterReportingViewModel;

public class MasterReportingMenu {
    private final MasterReportingViewModel masterReportingVM;
    private final AuthViewModel authViewModel;

    public MasterReportingMenu(MasterReportingViewModel masterReportingVM, AuthViewModel authViewModel) {
        this.masterReportingVM = masterReportingVM;
        this.authViewModel = authViewModel;
    }

    String inputUser;

    public void showMasterReportingMenu() {
        while (AppRouter.activeRoute == AppRouter.AppRoute.MASTER_REPORTING) {
            InputUtilities.cls();
            System.out.println("============================");
            System.out.println("      MASTER REPORTING      ");
            System.out.println("============================");
            System.out.println("1. Buat Laporan");
            System.out.println("2. Lihat Laporan");
            System.out.println("3. Simpan Laporan");
            System.out.println("0. Kembali");

            System.out.print("Masukkan Pilihan : ");
            try {

                inputUser = InputUtilities.input.readLine();
                System.out.println();
                switch (inputUser) {
                    case "1":
                        System.out.println();
                        if (masterReportingVM.getGeneratedReport() != null) {
                            System.out.println("Ada data yang sudah di generate");
                            System.out.print("Apakah anda ingin generate ulang? (y/n): ");
                            inputUser = InputUtilities.input.readLine();
                            if (inputUser.equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                        generateLaporan();
                        break;
                    case "2":
                        InputUtilities.cls();
                        lihatLaporan();
                        InputUtilities.pressEnter();
                        break;
                    case "3":
                        simpanLaporan();
                        InputUtilities.pressEnter();
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

    private void generateLaporan() {

        System.out.println("Generating report...");

        System.out.print("Masukkan Range Tanggal Awal (dd-MM-yyyy) : ");
        Date dateStart = InputUtilities.getDateFromInput();

        System.out.print("Masukkan Range Tanggal Akhir (dd-MM-yyyy) : ");
        Date dateEnd = InputUtilities.getDateFromInput();

        if (dateStart != null && dateEnd != null) {
            masterReportingVM.generateNewReport(dateStart, dateEnd, authViewModel.loggedUser.getUserID());
        } else {
            formatMessageOutput("Invalid Date");
        }

    }

    private void lihatLaporan() {
        viewDetailSelectedReport(masterReportingVM.getGeneratedReport());
    }

    private void simpanLaporan() {
        masterReportingVM.saveNewGeneratedReport();

    }
}
