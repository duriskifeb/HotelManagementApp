package Domain.Auth;

import Data.DataSource.PegawaiDataSource;
import Data.Model.User;
import Util.Encryption;

import static Util.Formatting.formatMessageOutput;

public class AuthUserCase {
    final PegawaiDataSource dataSources;
    public AuthUserCase(PegawaiDataSource dataSources) {
        this.dataSources = dataSources;
    }
    public User loggedUser;
    
    //logic account information 
    public void doLogin(String userId, String password){
        String hashedPass = Encryption.hashPassword(password);
        loggedUser = dataSources.authenticateUser(userId, hashedPass);
        if(loggedUser != null){
           formatMessageOutput("Login Success");
        }else {
            formatMessageOutput("Login Failed Account Not Found");
        }
    }

    public void doLogout() {
        loggedUser = null;
    }

    //register role
    public void doRegister(String userId, String password, String fullName, String role) {
        String hashedPass = Encryption.hashPassword(password);
        User user = new User(userId, hashedPass, fullName, role);
        registeredUser = dataSources.registerUser(user);
        if (registeredUser != null) {
            formatMessageOutput("Registration Success");
        } else {
            formatMessageOutput("Registration Failed");
        }
    }

}
