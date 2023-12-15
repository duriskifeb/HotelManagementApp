package Domain.Transaksi;

import Data.DataSource.CustomerDataSource;
import Data.DataSource.KamarDataSource;
import Data.DataSource.PegawaiDataSource;
import Data.DataSource.TransaksiDataSource;
import Data.Enums.Enums;
import Data.Enums.Enums.*;
import Data.Model.Customer;
import Data.Model.Kamar;
import Data.Model.Transaksi;
import Data.Model.User;
import Util.Formatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

// act like a cart and its utilities
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

    // logic to create a new instance of Transaksi, and save the transaction

    public void createInitialTransaksi(Customer pelanggan, User pegawai, Kamar kamar, Pembayaran payment) {
        Transaksi transaksi = new Transaksi(
                new Date(),
                StatusTransaksi.PENDING,
                payment,
                pegawai,
                new ArrayList<Customer>(
                        Arrays.asList(pelanggan)
                ),
                new ArrayList<Kamar>(
                        Arrays.asList(kamar)
                )
        );

        this.currentActiveTransaksi = transaksi;
    }

    public Transaksi getCurrentActiveTransaksi() {
        return currentActiveTransaksi;
    }

    public void commitTransaksi() {
        if (currentActiveTransaksi != null) {
            int cekIndex = transaksiDataSource.getListTransaksi().indexOf(currentActiveTransaksi);
            if (cekIndex != -1) {
                transaksiDataSource.addNewTransaksi(currentActiveTransaksi);
            } else {
                transaksiDataSource.editTransasi(cekIndex, currentActiveTransaksi);
            }
        }
    }

    // UPDATES the transaction
    public void addKamar(Kamar kamar){
        if(currentActiveTransaksi != null){
            ArrayList<Kamar> listKamar = currentActiveTransaksi.getKamarOrdered();
            listKamar.add(kamar);
            currentActiveTransaksi.setKamarOrdered(listKamar);
        }
    }
    public void removeKamar(Kamar kamar){
        if(currentActiveTransaksi != null){
            ArrayList<Kamar> listKamar = currentActiveTransaksi.getKamarOrdered();
            if(listKamar.size() > 1){
                listKamar.remove(kamar);
                currentActiveTransaksi.setKamarOrdered(listKamar);
            }
        }
    }
    public void addCustomer(Customer customer) {
        if(currentActiveTransaksi != null){
            ArrayList<Customer> listPelanggan = currentActiveTransaksi.getCustomers();
            listPelanggan.add(customer);
            currentActiveTransaksi.setCustomers(listPelanggan);
        }
    }
    public void removeCustomer(Customer customer){
        if(currentActiveTransaksi != null){
            ArrayList<Customer> listPelanggan = currentActiveTransaksi.getCustomers();
            if(listPelanggan.size() > 1){
                listPelanggan.remove(customer);
                currentActiveTransaksi.setCustomers(listPelanggan);
            }
        }
    }
    public void checkOut() {
        // TODO implement
        if (currentActiveTransaksi != null) {
            if (currentActiveTransaksi.getStatusPembayaran() != StatusTransaksiBayar.LUNAS) {
                //TODO @Ryan Lunasi Transaksi Dulu

            } else {
                currentActiveTransaksi.setCheckOut(new Date());
                currentActiveTransaksi.setStatusTransaksi(Enums.StatusTransaksi.DONE);
            }

        } else {
            // TODO @Ryan print error message
        }
    }
    public void checkIn() {
        // TODO implement
        if (currentActiveTransaksi != null) {
            if (currentActiveTransaksi.getStatusPembayaran() != Enums.StatusTransaksiBayar.PENDING_PAYMENT) {
                currentActiveTransaksi.setCheckIn(new Date());
                currentActiveTransaksi.setStatusTransaksi(Enums.StatusTransaksi.ONGOING);
            } else {
                // TODO @Ryan error lakukan pembayaran dulu
            }
        } else {
            // TODO @Ryan print error message
        }
    }
    public void bayar(Enums.Pembayaran metodeBayar, double amountBayar) {
        // TODO Implement
        if (currentActiveTransaksi != null) {
            if (currentActiveTransaksi.getStatusPembayaran() == StatusTransaksiBayar.LUNAS) {
                //TODO Transaksi Sudah Lunas
            } else {
                currentActiveTransaksi.setPembayaran(metodeBayar);
                currentActiveTransaksi.setStatusTransaksi(Enums.StatusTransaksi.ONGOING);
                currentActiveTransaksi.setPaid(
                        currentActiveTransaksi.getPaid() + amountBayar
                );

                if (currentActiveTransaksi.getPaid() > 0 && currentActiveTransaksi.getPaid() < currentActiveTransaksi.getTotal()) {
                    currentActiveTransaksi.setStatusPembayaran(StatusTransaksiBayar.PAID);
                } else {
                    // lunas
                    currentActiveTransaksi.setStatusPembayaran(StatusTransaksiBayar.LUNAS);
                }

            }


        } else {
            // TODO @Ryan print error message
        }
    }
    // UPDATES the transaction

    public void viewDetailTransaksi() {
        if (currentActiveTransaksi != null) {
            //TODO @Ryan print detail transaksi

        } else {
            Formatting.formatMessageOutput("Belum ada data transaksi yang dipilih");
        }
    }

    public void selectTransaksi(String noTransaksi) {
        this.currentActiveTransaksi = transaksiDataSource.getTransaksiDetail(noTransaksi);
        if (currentActiveTransaksi == null) {
            Formatting.formatMessageOutput("Data Not Found");
        }
    }


}
