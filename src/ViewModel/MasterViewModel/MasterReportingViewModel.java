package ViewModel.MasterViewModel;

import Data.Model.ReportModel;
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



}
