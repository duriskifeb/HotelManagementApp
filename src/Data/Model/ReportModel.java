package Data.Model;

import java.util.Date;
import java.util.List;

public class ReportModel {
    private String reportNumber;
    private Date dateCreated, dateUpdated;
    private List<Transaksi> listTransaksi;
    private User reportPIC;

    public ReportModel(
            String reportNumber,
            Date dateCreated,
            Date dateUpdated,
            List<Transaksi> listTransaksi,
            User reportPIC
    ) {
        this.reportNumber = reportNumber;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.listTransaksi = listTransaksi;
        this.reportPIC = reportPIC;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(List<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

    public User getReportPIC() {
        return reportPIC;
    }

    public void setReportPIC(User reportPIC) {
        this.reportPIC = reportPIC;
    }
}
