package Data.DataSource;

import Data.Enums.Enums;
import Data.Model.User;
import Util.Encryption;

import java.util.ArrayList;
import java.util.Arrays;

public class PegawaiDataSource {
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

    public void addNewPegawai(User user) {

        listPegawai.add(user);

    }

    public void deletePegawai(User usr) {

        listPegawai.remove(usr);
    }

    public ArrayList<User> getListPegawai() {
        return listPegawai;
    }

    public void editPegawai(int index, User user) {
        listPegawai.set(index, user);
    }

    public void setListPegawai(ArrayList<User> listPegawai) {
        this.listPegawai = listPegawai;
    }

    public User authenticateUser(String email, String password) {
        return listPegawai.stream().filter(
                cekUser -> cekUser.getEmail().equals(email) &&
                        cekUser.getPassword().equals(Encryption.hashPassword(password))
        ).findFirst().orElse(null);
    }


}
