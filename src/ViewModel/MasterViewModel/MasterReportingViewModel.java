package ViewModel.MasterViewModel;

import Data.Enums.Enums;
import Data.Model.ReportModel;
import Domain.Master.MasterReporting;

import static Util.Formatting.formatMessageOutput;

public class MasterReportingViewModel {
    MasterReporting masterReporting;

    public MasterReportingViewModel(MasterReporting masterReporting) {
        this.masterReporting = masterReporting;
    }

    ReportModel selectedReport;

    public void selectReport(String reportNumber){
        selectedReport = masterReporting.selectReport(reportNumber);
        if(selectedReport == null){
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }

    public void viewAllReports(){
        masterReporting.getAllReport()
                .stream()
                .iterator()
                .forEachRemaining(
                        selectedReport -> {

                            // TODO @David show preview data report
//                            String idPegawai = user.getUserID();
//                            String nama = user.getNama();
//                            String email = user.getEmail();
//                            Enums.UserRole role = user.getRole();
//                            System.out.format("%10s %10s \t%15s \t%10s\n", idPegawai, nama, email, role);

                        }
                );
    }
    public void viewDetailSelectedReport(){
        if(selectedReport != null){
            // TODO @David show all data in report (detail)
        }
    }

}
