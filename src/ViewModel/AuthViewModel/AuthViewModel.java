package ViewModel.AuthViewModel;

import Data.Model.User;
import Domain.Auth.AuthUserCase;
import Util.Formatting;

public class AuthViewModel {
    AuthUserCase authUseCase;

    public AuthViewModel(AuthUserCase userCase) {
        this.authUseCase = userCase;
    }
    public User loggedUser;
    public void doLogin(
            String username, // bisa id bisa email
            String password
    ){
        authUseCase.doLogin(username, password);
        if(authUseCase.loggedUser != null){
            this.loggedUser = authUseCase.loggedUser;
        }else{
            Formatting.formatMessageOutput("User Not Found");
        }
    }

    public void doLogout(){
        authUseCase.doLogout();
    }

    public void showProfile(){
        if(loggedUser != null){
            // TODO implement : show the user profile
        }
    }

    public void changePassword(String userID, String oldPassword, String newPassword){
        // TODO
    }
}
