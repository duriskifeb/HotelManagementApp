package Domain.Transaksi;

import Data.DataSource.CustomerDataSource;
import Data.DataSource.KamarDataSource;
import Data.DataSource.PegawaiDataSource;
import Data.DataSource.TransaksiDataSource;
import Data.Model.Transaksi;
import Util.Formatting;

public class TransaksiUseCase {
    TransaksiDataSource transaksiDataSource;
    CustomerDataSource customerDataSource;
    KamarDataSource kamarDataSource;
    PegawaiDataSource pegawaiDataSource;

    public TransaksiUseCase(
            TransaksiDataSource transaksiDataSource,
            CustomerDataSource customerDataSource,
            KamarDataSource kamarDataSource,
            PegawaiDataSource pegawaiDataSource
    ) {
        this.transaksiDataSource = transaksiDataSource;
        this.customerDataSource = customerDataSource;
        this.kamarDataSource = kamarDataSource;
        this.pegawaiDataSource = pegawaiDataSource;
    }

    Transaksi currentActiveTransaksi;

    // TODO logic to create a new instance of Transaksi

    public void createTransaksi(){
        // TODO Implement
    }

    public void commitTransaksi(){
        if(currentActiveTransaksi != null){
            // TODO Implement
        }
    }

    public void checkOut(){
        // TODO implement
    }

    public void checkIn(){
        // TODO implement
    }

    public void bayar(){
        // TODO Implement
    }

    public void selectTransaksi(String noTransaksi){
        this.currentActiveTransaksi = transaksiDataSource.getTransaksiDetail(noTransaksi);
        if(currentActiveTransaksi == null){
            Formatting.formatMessageOutput("Data Not Found");
        }
    }


}
