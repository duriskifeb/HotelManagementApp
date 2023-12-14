import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import Data.Enums.Enums;
import Util.Formatting;
import Util.Generator;
import View.MainMenu.MainMenu;

import Util.Encryption;
//import View.MainMenu.*;

public class Main {


    public static void main(String[] args) throws IOException{

        String reportNumber = Generator.generateReportNumber(
                "Aayam",
                Formatting.formatDate(new Date()),
                "10000000",
                "ayam-ayam-ayam"
                );
        System.out.println(reportNumber);

//        MainMenu menu = new MainMenu();
//
//        menu.login();
    }
} 