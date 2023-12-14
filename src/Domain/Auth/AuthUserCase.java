package Domain.Auth;

import Data.DataSource.PegawaiDataSource;
import Data.Model.User;
import Util.Encryption;

public class AuthUserCase {

    PegawaiDataSource dataSource;
    public AuthUserCase(PegawaiDataSource dataSource) {
        this.dataSource = dataSource;
    }
    public User loggedUser;
    public void doLogin(String userId, String password){
        String hashedPass = Encryption.hashPassword(password);
        loggedUser = dataSource.authenticateUser(userId, hashedPass);
        if(loggedUser != null){
            System.out.println("Login Success");
        }else {
            System.out.println("Login Failed Akun Tidak Ditemukan");
        }
    }

    public void doLogout() {
        loggedUser = null;
    }

    public User getLoggedInUser() {
        return loggedUser;
    }
}
