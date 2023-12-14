package Statics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StaticsInput {

    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine(){
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace(); // handle Exception
            return null;
        }
    }

    public static int readInt(){
        try {
            return Integer.parseInt(input.readLine());
        } catch (NumberFormatException | IOException e) {
            System.err.println("Input tidak valid. masukkan Integer");
            return readInt(); // rekursif
        }
    }

    public static void closeReader() {
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace(); // handle Exception
        }
    }

    public static void cls() {
        // wont work on IDE
        try {
            final String os = System.getProperty("os.name");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
            System.err.println("Error : cls() failed: " + e.getMessage());
        }
    }
}
