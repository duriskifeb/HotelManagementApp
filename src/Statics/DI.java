package Statics;

import Data.DataSource.AuthDataSource;
import Domain.Auth.AuthUserCase;
import ViewModel.AuthViewModel.AuthViewModel;

public class DI {

    // Datasources
    public static AuthDataSource authDataSource = new AuthDataSource();

    //Domains
    public static AuthUserCase authUserCase = new AuthUserCase(DI.authDataSource);

    // ViewModel
    public static AuthViewModel authViewModel = new AuthViewModel(DI.authUserCase);

}
