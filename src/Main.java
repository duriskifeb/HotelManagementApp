
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

        authViewModel.doLogin("ADM01", "ayamg oyeng");
        try{
            System.out.println(authViewModel.getLoggedInUser().getNama());
        }catch (Exception e){
            Formatting.formatMessageOutput("User Not Found");
        }

//        masterCustomerVM.viewAllDataCustomer();
    }
} 