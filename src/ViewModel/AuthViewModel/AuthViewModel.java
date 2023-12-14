package ViewModel.AuthViewModel;

import Domain.Auth.AuthUserCase;

public class AuthViewModel {
    AuthUserCase userCase;

    public AuthViewModel(AuthUserCase userCase) {
        this.userCase = userCase;
    }
}
