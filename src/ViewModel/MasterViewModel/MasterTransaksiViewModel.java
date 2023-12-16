package ViewModel.MasterViewModel;

import Data.Enums.Enums;
import Data.Model.Customer;
import Data.Model.Kamar;
import Data.Model.Transaksi;
import Domain.Master.MasterTransaksi;
import Domain.Transaksi.TransaksiUseCase;
import Util.Formatting;

import java.util.ArrayList;
import java.util.Date;

public class MasterTransaksiViewModel {
    MasterTransaksi masterTransaksi;
    TransaksiUseCase transaksiUseCase;

    public MasterTransaksiViewModel(MasterTransaksi masterTransaksi, TransaksiUseCase transaksiUseCase) {
        this.transaksiUseCase = transaksiUseCase;
        this.masterTransaksi = masterTransaksi;
    }

    // TODO implement
    public Transaksi selectedTransaksi;

    // EDITS REGION
    public void addKamar(String noKamar) {
        transaksiUseCase.addKamar(noKamar);
        commitTransaksi();
        updateStateSelectedTransaksi();
    }

    public void removeKamar(String noKamar) {
        transaksiUseCase.removeKamar(noKamar);
        commitTransaksi();
        updateStateSelectedTransaksi();
    }

    public void addCustomer(String NIK) {
        transaksiUseCase.addCustomer(NIK);
        commitTransaksi();
        updateStateSelectedTransaksi();
    }

    public void removeCustomer(String NIK) {
        transaksiUseCase.removeCustomer(NIK);
        commitTransaksi();
        updateStateSelectedTransaksi();
    }

    public void checkOut() {
        transaksiUseCase.checkOut();
        updateStateSelectedTransaksi();
        commitTransaksi();
    }

    public void checkIn() {
        transaksiUseCase.checkIn();
        commitTransaksi();
    }

    public void bayar(Enums.Pembayaran metodeBayar, double amountBayar) {
        transaksiUseCase.bayar(metodeBayar, amountBayar);
        commitTransaksi();
    }
    // EDITS REGION

    public void commitTransaksi() {
        if (this.selectedTransaksi != null) {
            transaksiUseCase.commitTransaksi();
        } else {
            Formatting.formatMessageOutput("Tidak ada transaksi yang dipilih / data sudah tidak ada");
        }
    }

    public void selectTranasksi(String noTransaksi) {
        masterTransaksi.selectTransaksi(noTransaksi);
        if (masterTransaksi.getSelectedTransaksi() != null) {
            transaksiUseCase.selectTransaksi(noTransaksi);
            updateStateSelectedTransaksi();
        } else {
            Formatting.formatMessageOutput("Pilih transaksi yang akan di edit");
        }
    }

    private void updateStateSelectedTransaksi() {
        this.selectedTransaksi = transaksiUseCase.getCurrentActiveTransaksi();
    }

    public void deleteTransaksi() {
        if (selectedTransaksi != null) {
            masterTransaksi.deleteTransaksi(this.selectedTransaksi.getNoTransaksi());
            this.selectedTransaksi = null;
        } else {
            Formatting.formatMessageOutput("Pilih transaksi yang akan di delete");
        }

    }

    public void viewAllTransaksi() {
        masterTransaksi.getAllTransaksi()
                .stream()
                .iterator()
                .forEachRemaining(
                        selectedTransaksi -> {
                            String noTransaksi = selectedTransaksi.getNoTransaksi();
                            String user = selectedTransaksi.getCustomers().get(0).getNama();
                            Enums.StatusTransaksi status = selectedTransaksi.getStatusTransaksi();
                            String tanggalTransaksi = Formatting.formatDate(selectedTransaksi.getTanggalTransaksi());
                            System.out.format("%20s %25s \t%20s \t%20s\n", noTransaksi, user, status, tanggalTransaksi);

                        }
                );
    }

    public void viewDetailSelectedTransaksi() {
        if (selectedTransaksi != null) {
            String noTransaksi = this.selectedTransaksi.getNoTransaksi();
            String user = this.selectedTransaksi.getPegawai().getUserID();
            ;
            Enums.StatusTransaksi status = this.selectedTransaksi.getStatusTransaksi();
            String tanggalTransaksi = Formatting.formatDate(this.selectedTransaksi.getTanggalTransaksi());

            System.out.println("========================================= DETAIL TRANSAKSI =========================================");
            System.out.println("No Transaksi: " + noTransaksi);
            System.out.println("PIC : " + "Nama PIC" + "( " + "PIC ID AYAM" + " )");
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("Pelanggan : " + user);
            System.out.println("Status: " + status);
            System.out.println("Tanggal : " + tanggalTransaksi);
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("Start : " + Formatting.formatDate(new Date()));
            System.out.println("End : " + Formatting.formatDate(new Date()));
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("Check In : " + Formatting.formatDate(new Date()));
            System.out.println("Check Out : " + Formatting.formatDate(new Date()));

            System.out.println("========================================= DETAIL PESANAN =========================================");
            System.out.println("KAMAR : ");

            this.selectedTransaksi.getKamarOrdered().stream().iterator().forEachRemaining(
                    kamar -> {
                        System.out.format("%20s %25s \t%20s \t%20s\n", kamar.getNoKamar(), kamar.getJenisKamar(), kamar.getHarga(), kamar.getKapasitas());
                    }
            );

        }

        System.out.println();

        System.out.println("CUSTOMER : ");
        this.selectedTransaksi.getCustomers().stream().iterator().forEachRemaining(
                customer -> {
                    System.out.format("%20s %25s \t%20s \t%20s\n", customer.getNIK(), customer.getNama(), customer.getTelp(), customer.getEmail());
                }
        );

        System.out.println("========================================= DETAIL BIAYA =========================================");
        System.out.println("TOTAL : " + Formatting.formatRupiah(this.selectedTransaksi.getTotal()));
        System.out.println("DIBAYARKAN : " + Formatting.formatRupiah(this.selectedTransaksi.getPaid()));
        System.out.println("Status Pembayaran : " + this.selectedTransaksi.getStatusPembayaran() + "( " + this.selectedTransaksi.getPembayaran() + " )");
        System.out.println("========================================= DETAIL TRANSAKSI =========================================");


    }

}


