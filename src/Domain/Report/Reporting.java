package Domain.Report;

import Data.DataSource.*;
import Data.Model.ReportModel;
import Data.Model.Transaksi;
import Data.Model.User;
import Util.Formatting;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Reporting {
//    CustomerDataSource customerDataSource;
//    KamarDataSource kamarDataSource;

    PegawaiDataSource pegawaiDataSource;
    TransaksiDataSource transaksiDataSource;
    ReportDataSource reportDataSource;

    public Reporting(
//            CustomerDataSource customerDataSource,
//            KamarDataSource kamarDataSource,
            PegawaiDataSource pegawaiDataSource,
            TransaksiDataSource transaksiDataSource,
            ReportDataSource reportDataSource
    ) {
//        this.customerDataSource = customerDataSource;
//        this.kamarDataSource = kamarDataSource;
        this.transaksiDataSource = transaksiDataSource;
        this.reportDataSource = reportDataSource;
    }

    // TODO logic to create, and handle the Reporting Model

    ReportModel generatedReport;

    public void generateReport(Date rangeStart, Date rangeEnd, String picID) {
        Formatting.formatMessageOutput("Generating Report");

        Date dateCreated = new Date();
        User pic = pegawaiDataSource.getPegawai(picID);
        ArrayList<Transaksi> listTransaksi = transaksiDataSource.getListTransaksi().stream().filter(
                transaksi -> transaksi.getTanggalTransaksi().after(rangeStart) && transaksi.getTanggalTransaksi().before(rangeEnd)
        ).collect(Collectors.toCollection(ArrayList::new));

        generatedReport = new ReportModel(
                dateCreated,
                listTransaksi,
                pic
        );

        Formatting.formatMessageOutput("Report Generated");
    }

    public void saveReport(){
        Formatting.formatMessageOutput("Saving Report");
        if(this.generatedReport != null){
            reportDataSource.addNewReport(this.generatedReport);
            Formatting.formatMessageOutput("Report saved");
        }else {
            Formatting.formatMessageOutput("No generated report found");
        }

    }

}
