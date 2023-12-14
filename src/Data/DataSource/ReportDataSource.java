package Data.DataSource;

import Data.Model.ReportModel;

import java.util.ArrayList;
import java.util.Arrays;

public class ReportDataSource {

    private ArrayList<ReportModel> listReports = new ArrayList<ReportModel>(
            Arrays.asList(
                    // TODO
            )
    );

    public ArrayList<ReportModel> getListReports() {
        return listReports;
    }

    public void setListReports(ArrayList<ReportModel> listReports) {
        this.listReports = listReports;
    }

    public void addNewReport(ReportModel report){
        this.listReports.add(report);
    }

    public void removeReport(ReportModel report){
        this.listReports.remove(report);
    }

    public void editReport(int index, ReportModel report){
        this.listReports.set(index, report);
    }
}
