package Domain.Report;

import Data.DataSource.CustomerDataSource;
import Data.DataSource.KamarDataSource;
import Data.DataSource.ReportDataSource;
import Data.DataSource.TransaksiDataSource;

public class Reporting {
    CustomerDataSource customerDataSource;
    KamarDataSource kamarDataSource;
    TransaksiDataSource transaksiDataSource;
    ReportDataSource reportDataSource;

    public Reporting(CustomerDataSource customerDataSource, KamarDataSource kamarDataSource, TransaksiDataSource transaksiDataSource, ReportDataSource reportDataSource) {
        this.customerDataSource = customerDataSource;
        this.kamarDataSource = kamarDataSource;
        this.transaksiDataSource = transaksiDataSource;
        this.reportDataSource = reportDataSource;
    }

    // TODO logic to create, and handle the Reporting Model

}
