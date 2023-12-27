package View.Master;

import static Util.Formatting.formatMessageOutput;
import static View.AppRouter.AppRoute.MASTER_REPORTING;
import static View.AppRouter.AppRoute.SUB_MASTER_DETAIL_REPORTING;
import static View.Components.ReportingView.*;
// import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;

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
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Buat Laporan");
            System.out.println("3. Lihat Generated Laporan");
            System.out.println("4. Simpan Laporan");
            System.out.println("5. Pilih Laporan");
            System.out.println("0. Kembali");

            System.out.print("Masukkan Pilihan : ");
            try {

                inputUser = InputUtilities.input.readLine();
                System.out.println();
                switch (inputUser) {
                    case "1":
                        headerViewReporting();
                        viewAllReports(masterReportingVM.getAllReport());
                        break;
                    case "2":
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
                    case "3":
                        InputUtilities.cls();
                        lihatGeneratedLaporan();
                        InputUtilities.pressEnter();
                        break;
                    case "4":
                        simpanLaporan();
                        InputUtilities.pressEnter();
                        break;
                    case "5":
                        pilihLaporan();
                        break;
                    case "0":
//                        AppRouter.navigateUp();

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

    private void pilihLaporan() {

        System.out.println("Pilih Laporan");
        System.out.print("Nomor Laporan\t: ");
        try {
            String noLaporan = InputUtilities.input.readLine();
            masterReportingVM.selectReport(noLaporan);
            if(masterReportingVM.getSelectedReport() != null){
                AppRouter.navigateTo(SUB_MASTER_DETAIL_REPORTING);
            }
        } catch (IOException e) {
            formatMessageOutput(e.getMessage());
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

    private void lihatGeneratedLaporan() {
        viewDetailSelectedReport(masterReportingVM.getGeneratedReport());
    }

    private void simpanLaporan() {
        masterReportingVM.saveNewGeneratedReport();

    }

    public void showDetailReportingMenu() {
        // delete and edit
        while (AppRouter.activeRoute == SUB_MASTER_DETAIL_REPORTING) {
            InputUtilities.cls();
            System.out.println("============================");
            System.out.println("      DETAIL REPORTING      ");
            System.out.println("============================");
            System.out.println("1. Lihat Detail");
            System.out.println("2. Edit Laporan");
            System.out.println("3. Hapus Laporan");
            System.out.println("0. Kembali");

            System.out.print("Masukkan Pilihan : ");
            try {

                inputUser = InputUtilities.input.readLine();
                System.out.println();
                switch (inputUser) {
                    case "1":
                        headerViewReporting();
                        viewDetailSelectedReport(masterReportingVM.getSelectedReport());
                        InputUtilities.pressEnter();
                        break;
                    case "2":
                        editLaporan();
                        break;

                    case "3":
                        hapusLaporan();
                        break;
                    case "0":
                        AppRouter.navigateTo(MASTER_REPORTING);
//                        AppRouter.navigateUp();
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

    private void editLaporan() {
        InputUtilities.cls();
        System.out.println("==============================");
        System.out.println("Edit Laporan");
        System.out.println("==============================");
        System.out.println("Kosongi input jika tidak ingin mengedit data");
        try {
            System.out.print("Tanggal range awal (dd-mm-yyyy) : ");
            Date rangeStart = InputUtilities.getDateFromInput();

            System.out.print("Tanggal range akhir (dd-mm-yyyy) : ");
            Date rangeEnd = InputUtilities.getDateFromInput();

            System.out.print("Pic ID : ");
            String picID = InputUtilities.input.readLine();

            System.out.print("Apa anda yakin?(y/n): ");
            inputUser = InputUtilities.input.readLine();
            if (inputUser.equalsIgnoreCase("y")) {
                masterReportingVM.editReport(rangeStart, rangeEnd, picID);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    private void hapusLaporan() {
        System.out.println("Hapus Laporan");
        System.out.print("Apa anda yakin ingin menghapus laporan?(y/n): ");
        try {
            inputUser = InputUtilities.input.readLine();
            if(inputUser.equalsIgnoreCase("y")){
                masterReportingVM.deleteReport(masterReportingVM.getSelectedReport().getReportNumber());
                if(masterReportingVM.getSelectedReport() == null){
                    AppRouter.navigateTo(MASTER_REPORTING);
//                    AppRouter.navigateUp();
                }

            }else{
                System.out.println("Operasi Dibatalkan");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
