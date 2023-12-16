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

    public Transaksi getCurrentActiveTransaksi() {
        return currentActiveTransaksi;
    }

    public ArrayList<Transaksi> getAllTransaksi() {
        return transaksiDataSource.getListTransaksi();
    }


    // logic to create a new instance of Transaksi, and save the transaction
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

    public void createInitialTransaksi(String nik, User pegawai, String noKamar, Pembayaran payment) {
        Customer customer = customerDataSource.getCustomer(nik);
        Kamar kamar = kamarDataSource.getKamar(noKamar);
        if(customer == null){
            Formatting.formatMessageOutput("Data Customer Tidak Diperlukan");
        } else if (kamar.getStatusKamar() != StatusKamar.AVAILABLE) {
            Formatting.formatMessageOutput("Kamar Sedang Digunakan");
        }else{
            this.currentActiveTransaksi = new Transaksi(
                    new Date(),
                    StatusTransaksi.PENDING,
                    payment,
                    pegawai,
                    new ArrayList<Customer>(
                            Arrays.asList(customer)
                    ),
                    new ArrayList<Kamar>(
                            Arrays.asList(kamar)
                    )
            );
        }

    }

    // UPDATES the transaction
    public void addKamar(String noKamar) {
        if (currentActiveTransaksi != null) {
            Kamar kamar = kamarDataSource.getKamar(noKamar);
            if(kamar != null && kamar.getStatusKamar() == StatusKamar.AVAILABLE){
                ArrayList<Kamar> listKamar = currentActiveTransaksi.getKamarOrdered();
                listKamar.add(kamar);
                currentActiveTransaksi.setKamarOrdered(listKamar);
                updateStatusKamar(kamar, StatusKamar.BOOKED); //
            }

        }
    }

    private void updateStatusKamar(Kamar kamar, StatusKamar statusKamar) {
        Kamar oldData = kamarDataSource.getKamar(kamar.getNoKamar());
        kamar.setStatusKamar(statusKamar);
        int index = kamarDataSource.getListKamar().indexOf(oldData);
        kamarDataSource.editKamar(index, kamar);
    }

    public void removeKamar(String noKamar) {
        if (currentActiveTransaksi != null) {
            Kamar kamar = kamarDataSource.getKamar(noKamar);
            if(kamar != null) {
                ArrayList<Kamar> listKamar = currentActiveTransaksi.getKamarOrdered();
                if (listKamar.size() > 1) {
                    listKamar.remove(kamar);
                    currentActiveTransaksi.setKamarOrdered(listKamar);
                    updateStatusKamar(kamar, StatusKamar.AVAILABLE);
                }
            }
        }
    }

    public void addCustomer(String NIK) {
        if (currentActiveTransaksi != null) {
            Customer customer = customerDataSource.getCustomer(NIK);
            ArrayList<Customer> listPelanggan = currentActiveTransaksi.getCustomers();
            listPelanggan.add(customer);
            currentActiveTransaksi.setCustomers(listPelanggan);
        }
    }

    public void removeCustomer(String NIK) {
        if (currentActiveTransaksi != null) {
            Customer customer = customerDataSource.getCustomer(NIK);
            ArrayList<Customer> listPelanggan = currentActiveTransaksi.getCustomers();
            if (listPelanggan.size() > 1) {
                listPelanggan.remove(customer);
                currentActiveTransaksi.setCustomers(listPelanggan);
            }
        }
    }

    public void checkOut() {

        if (currentActiveTransaksi != null) {
            if (currentActiveTransaksi.getStatusPembayaran() != StatusTransaksiBayar.LUNAS) {
                Formatting.formatMessageOutput("Lunasi dulu untuk bisa checkout");

            } else {

                currentActiveTransaksi.setCheckOut(new Date());
                currentActiveTransaksi.setStatusTransaksi(Enums.StatusTransaksi.DONE);

                // update all status kamar to cleaniong
                for (Kamar kamar : currentActiveTransaksi.getKamarOrdered()) {
                    updateStatusKamar(kamar, StatusKamar.CLEANING);
                }
                commitTransaksi();

            }

        } else {
            Formatting.formatMessageOutput("Belum ada data transaksi yang dipilih");
        }
    }

    public void checkIn() {
        // TODO implement
        if (currentActiveTransaksi != null) {
            if (currentActiveTransaksi.getStatusPembayaran() != Enums.StatusTransaksiBayar.PENDING_PAYMENT) {
                currentActiveTransaksi.setCheckIn(new Date());
                currentActiveTransaksi.setStatusTransaksi(Enums.StatusTransaksi.ONGOING);
                // update all status kamar to occupied
                for (Kamar kamar : currentActiveTransaksi.getKamarOrdered()) {
                    updateStatusKamar(kamar, StatusKamar.OCCUPIED);
                }
                commitTransaksi();

            } else {
                Formatting.formatMessageOutput("Lakukan pembayaran terlebih dahulu untuk bisa chekc in");
            }
        } else {
            Formatting.formatMessageOutput("Belum ada data transaksi yang dipilih");
        }
    }

    public void bayar(Enums.Pembayaran metodeBayar, double amountBayar) {
        if (currentActiveTransaksi != null) {
            if (currentActiveTransaksi.getStatusPembayaran() == StatusTransaksiBayar.LUNAS) {
                Formatting.formatMessageOutput("Tidak Bisa bayar karena transaksi sudah lunas");
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

                    if (amountBayar <= 0) {
                        Formatting.formatMessageOutput("Jumlah bayar tidak valid");
                    } else {
                        currentActiveTransaksi.setStatusPembayaran(StatusTransaksiBayar.LUNAS);
                    }

                }

            }


        } else {
            Formatting.formatMessageOutput("Belum ada data transaksi yang dipilih");
        }
    }
    // UPDATES the transaction


    public void selectTransaksi(String noTransaksi) {
        this.currentActiveTransaksi = transaksiDataSource.getTransaksiDetail(noTransaksi);
        if (currentActiveTransaksi == null) {
            Formatting.formatMessageOutput("Data Not Found");
        }
    }


}
