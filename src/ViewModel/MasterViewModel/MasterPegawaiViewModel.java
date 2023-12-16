package ViewModel.MasterViewModel;

import Data.AppEnums.AppEnums;
import Data.Model.User;
import Domain.Master.MasterPegawai;
import Util.Encryption;

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

    public void addNewPegawai(
            String nama,
            String email,
            String password,
            AppEnums.UserRole role
    ){
        User newData = new User(email, nama,  role, Encryption.hashPassword(password));
        masterPegawai.addNewPegawai(newData);
    }

    public void deletePegawai(String userID) {
        masterPegawai.deletePegawai(userID);
    }
    public void editDataPegawai(
            String nama,
            String email,
            AppEnums.UserRole role
    ){
        User newData = new User(email, nama,  role, selectedPegawai.getPassword());

        if(selectedPegawai != null){
            masterPegawai.editDataPegawai(selectedPegawai, newData);
        }
    }



}
