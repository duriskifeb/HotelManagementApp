package ViewModel.MasterViewModel;

import Data.Model.Transaksi;
import Domain.Master.MasterTransaksi;
import Domain.Transaksi.TransaksiUseCase;
import Util.Formatting;

import java.util.Date;

public class MasterTransaksiViewModel {
    MasterTransaksi masterTransaksi;
    TransaksiUseCase transaksiUseCase;
    public MasterTransaksiViewModel(MasterTransaksi masterTransaksi, TransaksiUseCase transaksiUseCase) {
        this.transaksiUseCase = transaksiUseCase;
        this.masterTransaksi = masterTransaksi;
    }

    // TODO implement
    Transaksi selectedTransaksi;

    public void editTransaksi(){
        if(selectedTransaksi != null){
            // TODO
        }else{
            Formatting.formatMessageOutput("Pilih transaksi yang akan di edit");
        }
    }
    public void deleteTransaksi(String noTransaksi){
        masterTransaksi.deleteTransaksi(noTransaksi);
    }
    public void viewAllTransaksi(){
        masterTransaksi.getAllTransaksi()
                .stream()
                .iterator()
                .forEachRemaining(
                        selectedReport -> {

                            // TODO @David show preview data transaksi
//                            String idPegawai = user.getUserID();
//                            String nama = user.getNama();
//                            String email = user.getEmail();
//                            Enums.UserRole role = user.getRole();
//                            System.out.format("%10s %10s \t%15s \t%10s\n", idPegawai, nama, email, role);

                        }
                );
    }
    public void viewDetailSelectedTransaksi(){
        if(selectedTransaksi != null){
            // TODO @David show all data in transaksi (detail)
        }
    }
}
