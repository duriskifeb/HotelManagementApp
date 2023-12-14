package Domain.Master;

import Data.DataSource.TransaksiDataSource;
import Data.Model.ReportModel;
import Data.Model.Transaksi;

import static Util.Formatting.formatMessageOutput;

public class MasterTransaksi {
    TransaksiDataSource dataSource;
    public MasterTransaksi(TransaksiDataSource dataSource) {
        this.dataSource = dataSource;
    }


    void addReport(Transaksi report) {
        // check if data already exists
        if(!cekTransaksi(report.getNoTransaksi())){
            dataSource.addNewTransaksi(report);
        }else {
            formatMessageOutput("Data Kamar Sudah Ada");
        }
    }
    void deleteTransaksi(String noTransaksi){
        if(cekTransaksi(noTransaksi)){
            Transaksi transaksi = getTransaksi(noTransaksi);
            dataSource.removeTransaksi(transaksi);
        }else {
            System.out.println("Data Tidak Ditemukan");
        }
    }
    public void editDataTransaksi(Transaksi oldDData, Transaksi newDData){
        // find the data's index
        if(cekTransaksi(oldDData.getNoTransaksi())){
            int index = dataSource.getListTransaksi().indexOf(oldDData);
            dataSource.editTransasi(index, newDData);
        }else{
            // data not found
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }
    public Transaksi getTransaksi(String noTransaksi){
        if(cekTransaksi(noTransaksi)){
            return dataSource.getListTransaksi().stream().filter(kamar -> kamar.getNoTransaksi().equals(noTransaksi)).findFirst().orElse(null);
        }else {
            formatMessageOutput("Data Tidak Ditemukan");
            return null;
        }
    }
    private boolean cekTransaksi(String reportNumber) {
        Transaksi cek = dataSource.getListTransaksi().stream().filter(
                cekKamar -> cekKamar.getNoTransaksi().equals(reportNumber)
        ).findFirst().orElse(null);
        return cek != null; // return data is Found when cek is not nul
    }
}
