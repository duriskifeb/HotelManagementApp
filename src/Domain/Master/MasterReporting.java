package Domain.Master;

import Data.DataSource.ReportDataSource;
import Data.Model.Kamar;
import Data.Model.ReportModel;

import java.util.ArrayList;

import static Util.Formatting.formatMessageOutput;

public class MasterReporting {
    ReportDataSource dataSource;

    public MasterReporting(ReportDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<ReportModel> getAllReport(){
        return dataSource.getListReports();
    }
    public void addReport(ReportModel report) {
        // check if data already exists
        if(!cekReport(report.getReportNumber())){
            dataSource.addNewReport(report);
        }else {
            formatMessageOutput("Data Kamar Sudah Ada");
        }
    }
    public void deleteReport(String reportNumber){
        if(cekReport(reportNumber)){
            ReportModel report = getReport(reportNumber);
            dataSource.removeReport(report);
        }else {
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }
    public void editDataReport(ReportModel oldDData, ReportModel newDData){
        // find the data's index
        if(cekReport(oldDData.getReportNumber())){
            int index = dataSource.getListReports().indexOf(oldDData);
            dataSource.editReport(index, newDData);
        }else{
            // data not found
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }
    public ReportModel getReport(String reportNumber){
        if(cekReport(reportNumber)){
            return dataSource.getListReports().stream().filter(kamar -> kamar.getReportNumber().equals(reportNumber)).findFirst().orElse(null);
        }else {
            System.out.println("Data Tidak Ditemukan");
            return null;
        }
    }

    private boolean cekReport(String reportNumber) {
        ReportModel cek = dataSource.getListReports().stream().filter(
                cekKamar -> cekKamar.getReportNumber().equals(reportNumber)
        ).findFirst().orElse(null);
        return cek != null; // return data is Found when cek is not nul
    }
}
