package ViewModel.MasterViewModel;

import Data.Model.User;
import Domain.Master.MasterPegawai;

import static Util.Formatting.formatMessageOutput;

public class MasterPegawaiViewModel {
    MasterPegawai masterPegawai;

    public MasterPegawaiViewModel(MasterPegawai masterPegawai) {
        this.masterPegawai = masterPegawai;
    }

    User selectedPegawai;

    public void selectPegawai(String userId){
        this.selectedPegawai = masterPegawai.getPegawai(userId);
        if(selectedPegawai == null){
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }


}
