package Menu.MainMenu;

import java.util.Scanner;

public class MainMenu {
    Scanner input = new Scanner(System.in);;

    int ch1 = 0;
    int ch2 = 0;

    // sementara
    String ID_Pegawai;
    String ID_Manager;
    String email;
    String pw;

    public void header() {
        cls();

        System.out.println("==============================");
        System.out.println(" HOTEL MANAGEMENT APLICATION ");
        System.out.println("==============================");
    }

    public void login() {
        do {
            header();
            System.out.println("\nSilahkan pilih menu login");
            System.out.println("1. Login Pegawai");
            System.out.println("2. Login Manager");
            System.out.println("0. Keluar");

            System.out.print("\nPilihan : ");
            ch1 = input.nextInt();
            input.nextLine();

            switch (ch1) {
                case 1:
                    next();
                    loginPegawai();
                    break;

                case 2:
                    next();
                    loginManager();
                    break;

                case 0:
                next();
                    cls();
                    System.out.println("Menutup aplikasi");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nPilihan tidak ada");
                    next();
                    break;
            }
        } while (true);

    }

    public void loginPegawai() {
        header();
        System.out.println("Login : Pegawai\n");

        System.out.print("ID\t  : ");
        ID_Pegawai = input.nextLine();
        System.out.print("Email\t  : ");
        email = input.nextLine();
        System.out.print("Password  : ");
        pw = input.nextLine();

        next();

        // test (misal input benar)
        menuPegawai();

        // pengecekan kalau input salah kembali ke login()

    }

    public void loginManager() {
        header();
        System.out.println("Login : Manager\n");
        System.out.print("ID\t  : ");
        ID_Manager = input.nextLine();
        System.out.print("Email\t  : ");
        email = input.nextLine();
        System.out.print("Password  : ");
        pw = input.nextLine();

        next();

        // test (misal input benar)
        menuManager();

        // pengecekan kalau input salah kembali ke login()

    }

    public void menuPegawai() {
        do {

            header();
            System.out.println("Menu : Pegawai\n");
            System.out.println("1. Fitur 1");
            System.out.println("2. Fitur 2");
            System.out.println("3. Fitur 3");
            System.out.println("4. Fitur 4");
            System.out.println("5. Fitur 5");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch2 = input.nextInt();
            input.nextLine();
            
            switch (ch2) {
                case 1:
                next();
                fitur1();
                    break;

                case 2:
                next();
                    fitur2();
                    break;

                case 3:
                next();
                    fitur3();
                    break;

                case 4:
                next();
                    fitur4();
                    break;

                case 5:
                next();
                    fitur5();
                    break;

                case 0:
                next();
                    break;

                default:
                    System.out.println("\nPilihan tidak ada");
                    next();
                    break;
            }

        } while (ch2 != 0);
    }

    public void menuManager() {
        do {

            header();
            System.out.println("Menu : Manager\n");
            System.out.println("1. Fitur 1");
            System.out.println("2. Fitur 2");
            System.out.println("3. Fitur 3");
            System.out.println("4. Fitur 4");
            System.out.println("5. Fitur 5");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch2 = input.nextInt();
            input.nextLine();

            switch (ch2) {
                case 1:
                next();
                fitur1();
                    break;

                case 2:
                next();
                    fitur2();
                    break;

                case 3:
                next();
                    fitur3();
                    break;

                case 4:
                next();
                    fitur4();
                    break;

                case 5:
                next();
                    fitur5();
                    break;

                case 0:
                next();
                    break;

                default:
                    System.out.println("\nPilihan tidak ada");
                    next();
                    break;
            }

        } while (ch2 != 0);

    }

    public void fitur1() {
        header();
        System.out.println("\nIni Fitur 1");
        next();
    }

    public void fitur2() {
        header();
        System.out.println("\nIni Fitur 2");
        next();
    }

    public void fitur3() {
        header();
        System.out.println("\nIni Fitur 3");
        next();
    }

    public void fitur4() {
        header();
        System.out.println("\nIni Fitur 4");
        next();
    }

    public void fitur5() {
        header();
        System.out.println("\nIni Fitur 5");
        next();
    }

    public void next() {
        System.out.println("\n==============================");
        System.out.print("\nTekan ENTER untuk melanjutkan");
        input.nextLine();
    }

    public void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.err.println("Error : cls()");
        }
    }

}
