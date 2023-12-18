
import Util.Encryption;
import Util.InputUtilities;


public class Main {
    public static void main(String[] args)  {
        DI.init();
        InputUtilities.cls();
        HotelManagementApp app = new HotelManagementApp();
        app.run();
    }
} 