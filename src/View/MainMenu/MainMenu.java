package View.MainMenu;

import static Statics.StaticsInput.readInt;
import static Statics.StaticsInput.readLine;

import java.io.IOException;

public class MainMenu {

    int ch1;
    int ch2;

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

    public void login() throws IOException {
        do {
            header();
            System.out.println("\nSilahkan pilih menu login");
            System.out.println("1. Login Pegawai");
            System.out.println("2. Login Manager");
            System.out.println("0. Keluar");

            System.out.print("\nPilihan : ");
            ch1 = readInt();


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

    public void loginPegawai() throws IOException {
        header();
        System.out.println("Login : Pegawai\n");

        System.out.print("ID\t  : ");
        ID_Pegawai = readLine();
        System.out.print("Email\t  : ");
        email = readLine();
        System.out.print("Password  : ");
        pw = readLine();

        next();

        // test (misal input benar)
        menuPegawai();

        // pengecekan kalau input salah kembali ke login()

    }

    public void loginManager() throws IOException {
        header();
        System.out.println("Login : Manager\n");
        System.out.print("ID\t  : ");
        ID_Manager = readLine();
        System.out.print("Email\t  : ");
        email = readLine();
        System.out.print("Password  : ");
        pw = readLine();

        next();

        // test (misal input benar)
        menuManager();

        // pengecekan kalau input salah kembali ke login()

    }

    public void menuPegawai() throws IOException {
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
            ch2 = readInt();

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

    public void menuManager() throws IOException {
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
            ch2 = readInt();

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

    public void fitur1() throws IOException {
        header();
        System.out.println("\nIni Fitur 1");
        next();
    }

    public void fitur2() throws IOException {
        header();
        System.out.println("\nIni Fitur 2");
        next();
    }

    public void fitur3() throws IOException {
        header();
        System.out.println("\nIni Fitur 3");
        next();
    }

    public void fitur4() throws IOException {
        header();
        System.out.println("\nIni Fitur 4");
        next();
    }

    public void fitur5() throws IOException {
        header();
        System.out.println("\nIni Fitur 5");
        next();
    }

    public void next() throws IOException {
        System.out.println("\n==============================");
        System.out.print("\nTekan ENTER untuk melanjutkan");
        readLine();
    }

    public void cls() {

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
