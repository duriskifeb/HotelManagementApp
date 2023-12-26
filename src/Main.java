
import Util.Encryption;
import Util.InputUtilities;
import View.AppRouter;
import View.Components.CustomerView;

import java.util.LinkedList;


public class Main {
    public static void main(String[] args)  {
        DI.init();
        HotelManagementApp app = new HotelManagementApp();
        app.run();

    }
} 