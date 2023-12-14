package Domain.Auth;

import Data.DataSource.AuthDataSource;
import Data.Model.User;
import Util.Encryption;

public class AuthUserCase {

    AuthDataSource dataSource;
    public AuthUserCase(AuthDataSource dataSource) {
        this.dataSource = dataSource;
    }


    User loggedUser;
    public void doLogin(String userId, String password){
        String strippedPass = password.strip();
        String hashedPass = Encryption.hashPassword(strippedPass);
    }


    void addNewPegawai(User user) {
        // check if user already exists
        if(!cekUser(user)){
            dataSource.addPegawai(user);
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
