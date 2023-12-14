package ViewModel.AuthViewModel;

import Data.Model.User;
import Domain.Auth.AuthUserCase;

public class AuthViewModel {
    AuthUserCase authUseCase;

    public AuthViewModel(AuthUserCase userCase) {
        this.authUseCase = userCase;
    }

    public User getLoggedInUser() {
        return authUseCase.getLoggedInUser();
    }


    public void doLogin(
            String username, // bisa id bisa email
            String password
    ){
        authUseCase.doLogin(username, password);
    }

    public void doLogout(){
        authUseCase.doLogout();
    }
}
