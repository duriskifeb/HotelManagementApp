import java.util.Scanner;
import Menu.MainMenu.*;

public class Main {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();

        menu.login();
    }
} 