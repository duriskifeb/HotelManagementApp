package Domain.Transaksi;

import Data.DataSource.CustomerDataSource;
import Data.DataSource.KamarDataSource;
import Data.DataSource.PegawaiDataSource;
import Data.DataSource.TransaksiDataSource;
import Data.Enums.Enums;
import Data.Enums.Enums.*;
import Data.Model.Transaksi;
import Util.Formatting;

import java.util.Date;

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

            int cekIndex = transaksiDataSource.getListTransaksi().indexOf(currentActiveTransaksi);
            if(cekIndex != -1){
                transaksiDataSource.addNewTransaksi(currentActiveTransaksi);
            }else{
                transaksiDataSource.editTransasi(cekIndex, currentActiveTransaksi);
            }
        }
    }

    public void checkOut(){
        // TODO implement
        if(currentActiveTransaksi != null){
            if(currentActiveTransaksi.getStatusPembayaran() != StatusTransaksiBayar.LUNAS){
                //TODO @Ryan Lunasi Transaksi Dulu

            }else{
                currentActiveTransaksi.setCheckOut(new Date());
                currentActiveTransaksi.setStatusTransaksi(Enums.StatusTransaksi.DONE);
            }

        }else{
            // TODO @Ryan print error message
        }
    }

    public void checkIn(){
        // TODO implement
        if(currentActiveTransaksi != null){
            if(currentActiveTransaksi.getStatusPembayaran() != Enums.StatusTransaksiBayar.PENDING_PAYMENT){
                currentActiveTransaksi.setCheckIn(new Date());
                currentActiveTransaksi.setStatusTransaksi(Enums.StatusTransaksi.ONGOING);
            }else {
             // TODO @Ryan error lakukan pembayaran dulu
            }
        }else{
            // TODO @Ryan print error message
        }
    }

    public void bayar(Enums.Pembayaran metodeBayar, double amountBayar){
        // TODO Implement
        if(currentActiveTransaksi != null){
            if(currentActiveTransaksi.getStatusPembayaran() == StatusTransaksiBayar.LUNAS){
                //TODO Transaksi Sudah Lunas
            }else{
                currentActiveTransaksi.setPembayaran(metodeBayar);
                currentActiveTransaksi.setStatusTransaksi(Enums.StatusTransaksi.ONGOING);
                currentActiveTransaksi.setPaid(
                        currentActiveTransaksi.getPaid()+amountBayar
                );

                if(currentActiveTransaksi.getPaid() > 0 && currentActiveTransaksi.getPaid() < currentActiveTransaksi.getTotal()){
                    currentActiveTransaksi.setStatusPembayaran(StatusTransaksiBayar.PAID);
                }else{
                    // lunas
                    currentActiveTransaksi.setStatusPembayaran(StatusTransaksiBayar.LUNAS);
                }

            }


        }else{
            // TODO @Ryan print error message
        }
    }

    public void viewDetailTransaksi(){
        if(currentActiveTransaksi != null){
            //TODO @Ryan print detail transaksi

        }else {
            Formatting.formatMessageOutput("Belum ada data transaksi yang dipilih");
        }
    }

    public void selectTransaksi(String noTransaksi){
        this.currentActiveTransaksi = transaksiDataSource.getTransaksiDetail(noTransaksi);
        if(currentActiveTransaksi == null){
            Formatting.formatMessageOutput("Data Not Found");
        }
    }


}
