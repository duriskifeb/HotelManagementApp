
import Util.Encryption;
import Util.InputUtilities;
import View.Components.CustomerView;


public class Main {
    public static void main(String[] args)  {
        DI.init();
        InputUtilities.cls();
        HotelManagementApp app = new HotelManagementApp();
        app.run();

//        CustomerView.viewAllDataCustomer(
//                DI.masterCustomer.getListCustomer()
//        );
    }
} 