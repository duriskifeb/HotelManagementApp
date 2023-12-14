package Data.DataSource;

public class ReportDataSource {
    CustomerDataSource customerDataSource;
    KamarDataSource kamarDataSource;
    TransaksiDataSource transaksiDataSource;

    public ReportDataSource(CustomerDataSource customerDataSource, KamarDataSource kamarDataSource, TransaksiDataSource transaksiDataSource) {
        this.customerDataSource = customerDataSource;
        this.kamarDataSource = kamarDataSource;
        this.transaksiDataSource = transaksiDataSource;
    }
}
