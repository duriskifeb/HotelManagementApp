
import Statics.StaticsInput;


public class Main {
    public static void main(String[] args)  {
        DI.init();
        StaticsInput.cls();
        HotelManagementApp app = new HotelManagementApp();
        app.run();
    }
} 