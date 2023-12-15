package ViewModel.MasterViewModel;

import Data.Enums.Enums;
import Data.Model.Kamar;
import Data.Model.User;
import Domain.Master.MasterPegawai;
import Util.Encryption;
import Util.Formatting;

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
            Enums.UserRole role
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
            Enums.UserRole role
    ){
        User newData = new User(email, nama,  role, selectedPegawai.getPassword());

        if(selectedPegawai != null){
            masterPegawai.editDataPegawai(selectedPegawai, newData);
        }
    }

    public void viewAllDataPegawai(){
        masterPegawai.getAllPegawai()
                .stream()
                .iterator()
                .forEachRemaining(
                        user -> {
                            String idPegawai = user.getUserID();
                            String nama = user.getNama();
                            String email = user.getEmail();
                            Enums.UserRole role = user.getRole();
                            System.out.format("%10s %10s \t%15s \t%10s\n", idPegawai, nama, email, role);

                        }
                );

    }

    public void viewSelectedPegawai(){
        if(selectedPegawai != null){
            String idPegawai = selectedPegawai.getUserID();
            String nama = selectedPegawai.getNama();
            String email = selectedPegawai.getEmail();
            Enums.UserRole role = selectedPegawai.getRole();
            System.out.format("%10s %10s \t%15s \t%10s\n", idPegawai, nama, email, role);
        }
    }

}
