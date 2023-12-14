package Domain.Master;

import Data.DataSource.PegawaiDataSource;
import Data.Model.User;

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
            System.out.println("Data Pegawai Sudah Ada");
        }
    }

    void deletePegawai(String userId){
        if(cekUser(userId)){
            dataSource.deletePegawai(userId);
        }else {
            System.out.println("Data Tidak Ditemukan");
        }
    }



    boolean cekUser(User user){
        User cek = dataSource.getListPegawai().stream().filter(
                cekUser -> {
                    return cekUser.getNama().equals(user.getNama()) ||
                            cekUser.getEmail().equals(user.getEmail());
                }
        ).findFirst().orElse(null);
        return cek != null; // return userIs Found when cek is not null
    }
    boolean cekUser(String userId){
        User cek = dataSource.getListPegawai().stream().filter(
                cekUser -> cekUser.getUserID().equals(userId)
        ).findFirst().orElse(null);
        return cek != null; // return userIs Found when cek is not null
    }

}
