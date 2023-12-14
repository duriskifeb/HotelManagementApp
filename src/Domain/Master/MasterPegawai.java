package Domain.Master;

import Data.DataSource.PegawaiDataSource;
import Data.Model.User;

import static Util.Formatting.formatMessageOutput;

public class MasterPegawai {
    PegawaiDataSource dataSource;

    public MasterPegawai(PegawaiDataSource dataSource) {
        this.dataSource = dataSource;
    }

    void addNewPegawai(User user) {
        // check if user already exists
        if(!cekUser(user)){
            dataSource.addNewPegawai(user);
        }else {
            formatMessageOutput("Data Pegawai Sudah Ada");
        }
    }

    void deletePegawai(String userId){
        if(cekUser(userId)){
            User usr = getPegawai(userId);
            dataSource.deletePegawai(usr);
        }else {
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }

    public User getPegawai(String userId){
        if(cekUser(userId)){
            return dataSource.getListPegawai().stream().filter(user -> user.getUserID().equals(userId)).findFirst().orElse(null);
        }else {
            System.out.println("Data Tidak Ditemukan");
            return null;
        }
    }

    public void editDataPegawai(User oldDData, User newDData){
        // find the data's index
        if(cekUser(oldDData)){
            int index = dataSource.getListPegawai().indexOf(oldDData);
            dataSource.editPegawai(index, newDData);
        }else{
            // data not found
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }

    private boolean cekUser(User user){
        User cek = dataSource.getListPegawai().stream().filter(
                cekUser -> {
                    return cekUser.getNama().equals(user.getNama()) ||
                            cekUser.getEmail().equals(user.getEmail());
                }
        ).findFirst().orElse(null);
        return cek != null; // return userIs Found when cek is not null
    }
    private boolean cekUser(String userId){
        User cek = dataSource.getListPegawai().stream().filter(
                cekUser -> cekUser.getUserID().equals(userId)
        ).findFirst().orElse(null);
        return cek != null; // return userIs Found when cek is not null
    }

}
