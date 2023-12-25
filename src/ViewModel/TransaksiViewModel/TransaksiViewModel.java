package ViewModel.TransaksiViewModel;

import Data.AppEnums.AppEnums;
import Data.Model.Transaksi;
import Data.Model.User;
import Domain.Transaksi.TransaksiUseCase;
import Util.Formatting;

import java.util.ArrayList;

public class TransaksiViewModel {
    TransaksiUseCase transaksiUseCase;

    public TransaksiViewModel(TransaksiUseCase transaksiUseCase) {
        this.transaksiUseCase = transaksiUseCase;
    }

    public Transaksi currentActiveTransaksi;

    private void updateStateTransaksi() {
        if (transaksiUseCase.getCurrentActiveTransaksi() != null) {
            this.currentActiveTransaksi = transaksiUseCase.getCurrentActiveTransaksi();
        } else {
            Formatting.formatMessageOutput("Tidak Ada Data");
        }
    }

    public void selectTranasksi(String noTransaksi) {
        transaksiUseCase.selectTransaksi(noTransaksi);
        updateStateTransaksi();
    }

    public ArrayList<Transaksi> getAllTransaksi() {
        return transaksiUseCase.getAllTransaksi();
    }

    public void commitTransaksi() {
        System.out.println("Menyimpan Perubahan");
        transaksiUseCase.commitTransaksi();
        updateStateTransaksi();

    }

    public void createInitialTransaksi(String NIK, User pegawai, String noKamar, AppEnums.Pembayaran payment) {
        transaksiUseCase.createInitialTransaksi(NIK, pegawai, noKamar, payment);
        updateStateTransaksi();
    }

    // UPDATES the transaction
    public void addKamar(String noKamar) {
        if(currentActiveTransaksi != null){
            transaksiUseCase.addKamar(noKamar);
            updateStateTransaksi();
        }

    }

    public void removeKamar(String noKamar) {
        if (currentActiveTransaksi != null) {
            transaksiUseCase.removeKamar(noKamar);
            updateStateTransaksi();
        }
    }

    public void addCustomer(String NIK) {
        if (currentActiveTransaksi != null) {
            transaksiUseCase.addCustomer(NIK);
            updateStateTransaksi();
        }
    }

    public void removeCustomer(String NIK) {
        if (currentActiveTransaksi != null) {
            transaksiUseCase.removeCustomer(NIK);
            updateStateTransaksi();
        }
    }

    public void checkOut() {
        if (currentActiveTransaksi != null) {
            transaksiUseCase.checkOut();
            updateStateTransaksi();
        }
    }

    public void checkIn() {
        if (currentActiveTransaksi != null) {
            transaksiUseCase.checkIn();
            updateStateTransaksi();
        }

    }

    public void bayar(AppEnums.Pembayaran metodeBayar, double amountBayar) {
        if (currentActiveTransaksi != null) {
            transaksiUseCase.bayar(metodeBayar, amountBayar);
            updateStateTransaksi();
        } else {
            Formatting.formatMessageOutput("Belum ada data transaksi yang dipilih");
        }
    }
    // UPDATES the transaction


}
