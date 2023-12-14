package Domain.Auth;

import Util.Encryption;

public class AuthLogic {
    public void doLogin(String userId, String password){
        String strippedPass = password.strip();
        String hashedPass = Encryption.hashPassword(strippedPass);

    }
}
