package Statics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Statics {

//    public static Scanner input = new Scanner(System.in);
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
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
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

}
