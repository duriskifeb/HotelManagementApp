package DataSource.Model;

import DataSource.Enums.Enums;

public class Kamar {
    private String noKamar;
    private Enums.JenisKamar jenisKamar;
    private double harga;
    private int kapasitas;
    private Enums.StatusKamar statusKamar;

    public Kamar(String noKamar, Enums.JenisKamar jenisKamar, double harga, int kapasitas, Enums.StatusKamar statusKamar) {
        this.noKamar = noKamar;
        this.jenisKamar = jenisKamar;
        this.harga = harga;
        this.kapasitas = kapasitas;
        this.statusKamar = statusKamar;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }

    public Enums.JenisKamar getJenisKamar() {
        return jenisKamar;
    }

    public void setJenisKamar(Enums.JenisKamar jenisKamar) {
        this.jenisKamar = jenisKamar;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public Enums.StatusKamar getStatusKamar() {
        return statusKamar;
    }

    public void setStatusKamar(Enums.StatusKamar statusKamar) {
        this.statusKamar = statusKamar;
    }
}
