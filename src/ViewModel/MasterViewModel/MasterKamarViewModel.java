package ViewModel.MasterViewModel;

import Data.Enums.Enums;
import Data.Model.Customer;
import Data.Model.Kamar;
import Domain.Master.MasterKamar;
import Domain.Master.MasterTransaksi;
import Util.Formatting;

import static Util.Formatting.formatMessageOutput;

public class MasterKamarViewModel {
    MasterKamar masterKamar;

    public MasterKamarViewModel(MasterKamar masterKamar) {
        this.masterKamar = masterKamar;
    }
    Kamar currentSelectedKamar;
    public void selectKamar(String noKamar){
        this.currentSelectedKamar = masterKamar.getKamar(noKamar);
        if(currentSelectedKamar == null){
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }

    public void viewDataSelectedKamar(){
        if(currentSelectedKamar != null){
            String noKamar = currentSelectedKamar.getNoKamar();
            int kapasitas = currentSelectedKamar.getKapasitas();
            String harga = Formatting.formatRupiah(currentSelectedKamar.getHarga());
            Enums.StatusKamar status = currentSelectedKamar.getStatusKamar();
            System.out.format("%10s %10s \t%15s \t%10s \t%10s\n", noKamar, kapasitas, harga, jenis, status);
        }
    }
    public void viewAllDataKamar(){
        masterKamar.getAllKamar()
                .stream()
                .iterator()
                .forEachRemaining(
                        kamar -> {
                            String noKamar = kamar.getNoKamar();
                            int kapasitas = kamar.getKapasitas();
                            String harga = Formatting.formatRupiah(kamar.getHarga());
                            Enums.JenisKamar jenis = kamar.getJenisKamar();
                            Enums.StatusKamar status = kamar.getStatusKamar();
                            System.out.format("%10s %10s \t%15s \t%10s \t%10s\n", noKamar, kapasitas, harga, jenis, status);

                        }
                );
    }
    public void addNewKamar(
            String noKamar,
            int kapasitas,
            Enums.JenisKamar jenis,
            double harga,
            Enums.StatusKamar statusKamar
    ){
        Kamar kamar = new Kamar(
                noKamar,
                jenis,
                harga,
                kapasitas,
                statusKamar
        );
        masterKamar.addKamar(kamar);
    }
    public void deleteKamar(String noKamar) {
        masterKamar.deleteKamar(noKamar);
    }
    public void editKamar(
            String noKamar,
            int kapasitas,
            Enums.JenisKamar jenis,
            double harga,
            Enums.StatusKamar statusKamar
    ){
        Kamar kamar = new Kamar(
                noKamar,
                jenis,
                harga,
                kapasitas,
                statusKamar
        );
        if(currentSelectedKamar != null){
            masterKamar.editDataKamar(currentSelectedKamar, kamar);
        }
    }


}
