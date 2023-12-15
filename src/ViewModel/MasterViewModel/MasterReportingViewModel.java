package ViewModel.MasterViewModel;

import Data.Enums.Enums;
import Data.Model.ReportModel;
import Data.Model.User;
import Domain.Master.MasterReporting;
import Domain.Report.Reporting;
import Util.Formatting;

import java.util.Date;

import static Util.Formatting.formatMessageOutput;

public class MasterReportingViewModel {
    MasterReporting masterReporting;
    Reporting reportingUseCase;
    public MasterReportingViewModel(MasterReporting masterReporting, Reporting reportingUseCase) {
        this.masterReporting = masterReporting;
        this.reportingUseCase = reportingUseCase;
    }

    ReportModel selectedReport;

    public void selectReport(String reportNumber){
        selectedReport = masterReporting.selectReport(reportNumber);
        if(selectedReport == null){
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }

    public void generateNewReport(Date rangeStart, Date rangeEnd, String picID){
        reportingUseCase.generateReport(rangeStart, rangeEnd, picID);
        selectedReport = reportingUseCase.getGeneratedReport();
    }

    public void saveNewGeneratedReport(){
        if(selectedReport != null){
            masterReporting.addReport(selectedReport);
        }
//        reportingUseCase.saveReport();
    }


    public void editReport(Date rangeStart, Date rangeEnd, String picID){
        // edit
        if(selectedReport != null){
            reportingUseCase.generateReport(
                    selectedReport.getReportNumber(),
                    rangeStart,
                    rangeEnd,
                    picID,
                    selectedReport.getDateCreated()
            );
            ReportModel newData = reportingUseCase.getGeneratedReport();
            masterReporting.editDataReport(selectedReport, newData);
        }else{
            Formatting.formatMessageOutput("Pilih data untuk di edit");
            // print tidak ada data yang dipilih untuk diedit
        }

    }

    public void deleteReport(String reportNumber){
        masterReporting.deleteReport(reportNumber);
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
