package Domain.Auth;

import Data.DataSource.AuthDataSource;
import Util.Encryption;

public class AuthUserCase {

    AuthDataSource dataSource;
    public AuthUserCase(AuthDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void doLogin(String userId, String password){
        String strippedPass = password.strip();
        String hashedPass = Encryption.hashPassword(strippedPass);
    }
}
