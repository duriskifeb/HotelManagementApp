package Data.DataSource;

public class ReportDataSource {
    CustomerDataSource customerDataSource;
    KamarDataSource kamarDataSource;
    TransaksiDataSource transaksiDataSource;
    ReportDataSource reportDataSource;

    public ReportDataSource(CustomerDataSource customerDataSource, KamarDataSource kamarDataSource, TransaksiDataSource transaksiDataSource, ReportDataSource reportDataSource) {
        this.customerDataSource = customerDataSource;
        this.kamarDataSource = kamarDataSource;
        this.transaksiDataSource = transaksiDataSource;
        this.reportDataSource = reportDataSource;
    }
}
