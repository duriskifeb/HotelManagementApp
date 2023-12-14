package Data.DataSource;

import Data.Enums.Enums;
import Data.Model.User;
import Util.Encryption;

import java.util.ArrayList;
import java.util.Arrays;

public class AuthDataSource {
     private ArrayList<User> listPegawai = new ArrayList<>(
            Arrays.asList(
                    new User(
                            "ADM01",
                            "admin@gmail.com",
                            "ayam",
                            Enums.UserRole.MANAGER,
                            Encryption.hashPassword("ayamgoyeng")
                    ),
                    new User(
                            "ADM02",
                            "admindua@gmail.com",
                            "bebek",
                            Enums.UserRole.MANAGER,
                            Encryption.hashPassword("bebekgoyeng")
                    )
            )
    );

     void addNewPegawai(User user) {
        // check if user already exists
        if(!cekUser(user)){
            listPegawai.add(user);
        }else {
            System.out.println("Data Pegawai Sudah Ada");
        }
    }

     void deletePegawai(String userId){
        if(cekUser(userId)){
            listPegawai.remove(userId);
        }else {
            System.out.println("Data Tidak Ditemukan");
        }
    }

    public  ArrayList<User> getListPegawai() {
        return listPegawai;
    }


    public User authenticateUser(String email, String password){
         return listPegawai.stream().filter(
                 cekUser -> cekUser.getEmail().equals(email) &&
                         cekUser.getPassword().equals(Encryption.hashPassword(password))
         ).findFirst().orElse(null);
    }

    public void setListPegawai(ArrayList<User> listPegawai) {
        this.listPegawai = listPegawai;
    }

     boolean cekUser(User user){
        User cek = listPegawai.stream().filter(
                cekUser -> {
                    return cekUser.getNama().equals(user.getNama()) ||
                            cekUser.getEmail().equals(user.getEmail());
                }
        ).findFirst().orElse(null);
        return cek != null; // return userIs Found when cek is not null
    }
     boolean cekUser(String userId){
        User cek = listPegawai.stream().filter(
                cekUser -> cekUser.getUserID().equals(userId)
        ).findFirst().orElse(null);
        return cek != null; // return userIs Found when cek is not null
    }
}
