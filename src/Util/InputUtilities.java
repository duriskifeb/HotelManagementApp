package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtilities {

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

    public static void cls() { // Ini aku ganti set
        // wont work on IDE
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pressEnter(){
        System.out.println();
        System.out.print("Press ENTER to continue");
        try {
            InputUtilities.input.readLine();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
