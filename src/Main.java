
import Statics.DI;
import Statics.DI.*;
import Statics.StaticsInput;
import Util.Formatting;

import static Statics.DI.authViewModel;
import static Statics.DI.masterCustomerVM;


public class Main {
    public static void main(String[] args)  {
        DI.init();
        StaticsInput.cls();

        authViewModel.doLogin("ADM01", "ayamgoyeng");
        try{
            System.out.println(authViewModel.loggedUser.getNama());
        } catch (Exception e){

        }

//        masterCustomerVM.viewAllDataCustomer();
    }
} 