import java.io.IOException;
import java.util.Scanner;
import View.MainMenu.MainMenu;

import Util.Encryption;
//import View.MainMenu.*;

public class Main {


    public static void main(String[] args) throws IOException{

        String ayamHashed = Encryption.hashPassword("ayam");
        MainMenu menu = new MainMenu();

        menu.login();
    }
} 