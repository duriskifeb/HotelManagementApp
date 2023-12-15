package Domain.Master;

import Data.DataSource.TransaksiDataSource;
import Data.Model.ReportModel;
import Data.Model.Transaksi;

import java.util.ArrayList;

import static Util.Formatting.formatMessageOutput;

public class MasterTransaksi {
    TransaksiDataSource dataSource;
    public MasterTransaksi(TransaksiDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Transaksi selectedTransaksi;
    public ArrayList<Transaksi> getAllTransaksi() {
        return dataSource.getListTransaksi();
    }
    public void addNewTransaksi(Transaksi report) {
        // check if data already exists
        if(!cekTransaksi(report.getNoTransaksi())){
            dataSource.addNewTransaksi(report);
        }else {
            formatMessageOutput("Data Transaksi Sudah Ada");
        }
    }
    public void deleteTransaksi(String noTransaksi){
        if(cekTransaksi(noTransaksi)){
            Transaksi transaksi = dataSource.getTransaksiDetail(noTransaksi);
            dataSource.removeTransaksi(transaksi);
        }else {
            formatMessageOutput("Data Tidak Ditemukan");
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
    public void selectTransaksi(String noTransaksi){
         selectedTransaksi = dataSource.getTransaksiDetail(noTransaksi);
         if(selectedTransaksi == null){
             formatMessageOutput("Data Tidak Ditemukan");
         }
    }
    private boolean cekTransaksi(String reportNumber) {
        Transaksi cek = dataSource.getListTransaksi().stream().filter(
                transaksi -> transaksi.getNoTransaksi().equals(reportNumber)
        ).findFirst().orElse(null);
        return cek != null; // return data is Found when cek is not nul
    }
}
