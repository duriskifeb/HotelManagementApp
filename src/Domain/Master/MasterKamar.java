package Domain.Master;

import Data.DataSource.KamarDataSource;
import Data.Model.Kamar;

import java.util.ArrayList;

import static Util.Formatting.formatMessageOutput;

public class MasterKamar {
    final KamarDataSource dataSource;

    public MasterKamar(KamarDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<Kamar> getAllKamar(){
        return dataSource.getListKamar();
    }
    public void addKamar(Kamar kamar) {
        // check if kamar already exists
        if(!cekKamar(kamar.getNoKamar())){
            dataSource.addNewKamar(kamar);
            formatMessageOutput("Kamar Added");
        }else {
            formatMessageOutput("Data Kamar Sudah Ada");
        }
    }
    public void deleteKamar(String nomorKamar){
        if(cekKamar(nomorKamar)){
            Kamar kamar = getKamar(nomorKamar);
            dataSource.removeKamar(kamar);
        }else {
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }
    public void editDataKamar(Kamar oldDData, Kamar newDData){
        // find the data's index
        if(cekKamar(oldDData.getNoKamar())){
            int index = dataSource.getListKamar().indexOf(oldDData);
            dataSource.editKamar(index, newDData);

        }else{
            // data not found
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }
    public Kamar getKamar(String nomorKamar){
       return dataSource.getKamar(nomorKamar);
    }
    public boolean cekKamar(String noKamar) {
        Kamar cek = dataSource.getListKamar().stream().filter(
                cekKamar -> cekKamar.getNoKamar().equals(noKamar)
        ).findFirst().orElse(null);
        return cek != null; // return kamar is Found when cek is not null
    }


}
