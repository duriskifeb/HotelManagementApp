package Data.DataSource;

import Data.Model.Transaksi;

import java.util.ArrayList;

public class TransaksiDataSource {
    private ArrayList<Transaksi> listTransaksi = new ArrayList<>();

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

}
