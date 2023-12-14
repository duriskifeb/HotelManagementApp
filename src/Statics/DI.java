package Statics;

import Data.DataSource.AuthDataSource;
import Data.DataSource.CustomerDataSource;
import Data.DataSource.KamarDataSource;
import Data.DataSource.TransaksiDataSource;
import Domain.Auth.AuthUserCase;
import ViewModel.AuthViewModel.AuthViewModel;

public class DI {

    // Datasources
    public static AuthDataSource authDataSource = new AuthDataSource();
    public static CustomerDataSource customerDataSource = new CustomerDataSource();
    public static KamarDataSource kamarDataSource = new KamarDataSource();
    public static TransaksiDataSource transaksiDataSource = new TransaksiDataSource();

    //Domains
    public static AuthUserCase authUserCase = new AuthUserCase(DI.authDataSource);

    // ViewModel
    public static AuthViewModel authViewModel = new AuthViewModel(DI.authUserCase);

}
