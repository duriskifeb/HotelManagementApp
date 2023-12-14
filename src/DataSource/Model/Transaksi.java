package DataSource.Model;

import DataSource.Enums.Enums;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Transaksi {

    private String noTransaksi;
    private Date tanggalTransaksi, checkIn, checkOut;

    private Enums.StatusTransaksi statusTransaksi;
    private Enums.Pembayaran pembayaran;

    private User pegawai;

    private ArrayList<Customer> customers; // get(0) customers is the one who order

    private double total;
    private ArrayList<Kamar> kamarOrdered;
    public Transaksi(
            String noTransaksi,
            Date tanggalTransaksi,
            Enums.StatusTransaksi statusTransaksi,
            Enums.Pembayaran pembayaran,
            User pegawai,
            ArrayList<Customer> customers,
            ArrayList<Kamar> kamarOrdered
    ) {
        this.noTransaksi = noTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.statusTransaksi = statusTransaksi;
        this.pembayaran = pembayaran;
        this.pegawai = pegawai;
        this.customers = customers;
        this.kamarOrdered = kamarOrdered;
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Enums.StatusTransaksi getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(Enums.StatusTransaksi statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public Enums.Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Enums.Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public User getPegawai() {
        return pegawai;
    }

    public void setPegawai(User pegawai) {
        this.pegawai = pegawai;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public double getTotal() {
        return total;
    }

    public void calculateTotal() {
        // sum the total
        this.total = 0;
        for(Kamar kamar : this.kamarOrdered){
            this.total += kamar.getHarga();
        }

    }

    public ArrayList<Kamar> getAllKamarOrdered() {
        return kamarOrdered;
    }

    public void setKamarOrdered(ArrayList<Kamar> kamarOrdered) {
        this.kamarOrdered = kamarOrdered;
    }

    public void addKamar(Kamar kamar){
        this.kamarOrdered.add(kamar);
    }

    public void removeKamar(Kamar k){
        this.kamarOrdered.remove(k);
    }
}
