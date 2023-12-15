package ViewModel.MasterViewModel;

import Data.Model.Kamar;
import Domain.Master.MasterKamar;
import Domain.Master.MasterTransaksi;

public class MasterKamarViewModel {
    MasterKamar masterKamar;

    public MasterKamarViewModel(MasterKamar masterKamar) {
        this.masterKamar = masterKamar;
    }
    Kamar currentSelectedKamar;
    public void selectKamar(String noKamar){
        this.currentSelectedKamar = masterKamar.getKamar(noKamar);
    }


}
