package Domain.Auth;

import Data.DataSource.PegawaiDataSource;
import Data.Model.User;
import Util.Encryption;

public class AuthUserCase {

    PegawaiDataSource dataSource;
    public AuthUserCase(PegawaiDataSource dataSource) {
        this.dataSource = dataSource;
    }


    User loggedUser;
    public void doLogin(String userId, String password){
        String strippedPass = password.strip();
        String hashedPass = Encryption.hashPassword(strippedPass);
        loggedUser = dataSource.authenticateUser(userId, hashedPass);
    }
}
