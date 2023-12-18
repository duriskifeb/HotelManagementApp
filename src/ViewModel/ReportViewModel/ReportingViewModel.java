package ViewModel.ReportViewModel;

import Data.Model.ReportModel;
import Data.Model.Transaksi;
import Data.Model.User;
import Domain.Report.Reporting;
import Util.Formatting;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class ReportingViewModel {
    Reporting reporting;

    public ReportingViewModel(Reporting reporting) {
        this.reporting = reporting;
    }

    public ReportModel getGeneratedReport() {
        return reporting.getGeneratedReport();
    }

    public void generateReport(Date rangeStart, Date rangeEnd, String picID) {
        reporting.generateReport(rangeStart, rangeEnd, picID);
    }
    public void generateReport(String reportNumber , Date rangeStart, Date rangeEnd, String picID, Date dateCreated) {
        reporting.generateReport(reportNumber, rangeStart, rangeEnd, picID, dateCreated);

    }
    public void saveReport(){
        reporting.saveReport();
    }

}
