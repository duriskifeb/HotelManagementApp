package Domain.Master;

import Data.DataSource.KamarDataSource;
import Data.Model.Kamar;
import Data.Model.User;

public class MasterKamar {
    KamarDataSource dataSource;

    public MasterKamar(KamarDataSource dataSource) {
        this.dataSource = dataSource;
    }

    void addKamar(Kamar kamar) {
        // check if kamar already exists
        if(!cekKamar(kamar.getNoKamar())){
            dataSource.addNewKamar(kamar);
        }else {
            System.out.println("Data Kamar Sudah Ada");
        }
    }


    void deleteKamar(String nomorKamar){
        if(cekKamar(nomorKamar)){
            Kamar kamar = dataSource.getListKamar().stream().filter(cekKamar -> cekKamar.getNoKamar().equals(nomorKamar)).findFirst().orElse(null);
            dataSource.removeKamar(kamar);
        }else {
            System.out.println("Data Tidak Ditemukan");
        }
    }


    public Kamar getKamar(String nomorKamar){
        if(cekKamar(nomorKamar)){
            return dataSource.getListKamar().stream().filter(kamar -> kamar.getNoKamar().equals(nomorKamar)).findFirst().orElse(null);
        }else {
            System.out.println("Data Tidak Ditemukan");
            return null;
        }
    }

    private boolean cekKamar(String noKamar) {
        Kamar cek = dataSource.getListKamar().stream().filter(
                cekKamar -> cekKamar.getNoKamar().equals(noKamar)
        ).findFirst().orElse(null);
        return cek != null; // return kamar is Found when cek is not null
    }


}
