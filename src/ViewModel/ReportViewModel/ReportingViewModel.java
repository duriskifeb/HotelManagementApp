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

    //TODO implement

    public ReportModel getGeneratedReport() {
        return reporting.getGeneratedReport();
    }

    public void generateReport(Date rangeStart, Date rangeEnd, String picID) {

    }
    public void generateReport(String reportNumber , Date rangeStart, Date rangeEnd, String picID, Date dateCreated) {



    }
    public void saveReport(){

    }

}
