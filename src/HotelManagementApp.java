import Util.Formatting;
import View.Auth.AuthMenu;
import View.MainMenu.MainMenu;
import View.Master.*;
import View.Reporting.ReportingMenu;
import View.Transaksi.TransaksiMenu;

public class HotelManagementApp {



    //MENUS VIEWS
    AuthMenu authMenu;
    MainMenu mainMenu;

    // masters menus
    MasterCustomerMenu masterCustomerMenu;
    MasterKamarMenu masterKamarMenu;
    MasterMainMenu masterMainMenu;
    MasterPegawaiMenu masterPegawaiMenu;
    MasterReportingMenu masterReportingMenu;
    MasterTransaksiMenu masterTransaksiMenu;
    // master menus

    TransaksiMenu transaksiMenu;
    ReportingMenu reportingMenu;
    //MENUS VIEWS
    HotelManagementApp(){
        // init the application here
        onCreate();
        onViewCreated();
    }
    private void onCreate(){
        this.authMenu = new AuthMenu(DI.authViewModel);

        this.mainMenu = new MainMenu(DI.authViewModel);
        this.masterMainMenu = new MasterMainMenu(DI.authViewModel);

        this.masterCustomerMenu = new MasterCustomerMenu(DI.masterCustomerVM);
        this.masterKamarMenu = new MasterKamarMenu(DI.masterKamarVM);
        this.masterPegawaiMenu = new MasterPegawaiMenu(DI.masterPegawaiVM);
        this.masterReportingMenu = new MasterReportingMenu(DI.masterReportingVM);
        this.masterTransaksiMenu= new MasterTransaksiMenu(DI.masterTransaksiVM);

        this.transaksiMenu = new TransaksiMenu(DI.transaksiVM);
        this.reportingMenu = new ReportingMenu(DI.reportingVM);
    }

    private void onViewCreated(){
        // initial route move to Login
        AppRouter.navigateTo(AppRouter.AppRoute.LOGIN);
    }


    public void run(){
        // app loop
        while(true){
            switch (AppRouter.activeRoute){
                case LOGIN:
                   this.authMenu.showLogin();
                    break;

                case MAIN_MENU:
                    this.mainMenu.showMainMenu();
                    break;

                case MASTER_MAIN_MENU:
                    this.masterMainMenu.showMasterMainMenu();
                    break;

                case MASTER_KAMAR:

                    break;

                case MASTER_PEGAWAI:

                    break;

                case MASTER_CUSTOMER:

                    break;

                case MASTER_REPORTING:

                    break;

                case MASTER_TRANSAKSI:

                    break;

                case TRANSAKSI:

                    break;

                case REPORTING:

                    break;

                case EXIT:
                    Formatting.formatMessageOutput("Terimakasih telah menggunakan aplikasi kami");
                    Formatting.formatMessageOutput("Exiting");
                    System.exit(0);
                    break;
                default:
                    Formatting.formatMessageOutput("Invalid Route");
                    break;
            }
        }
    }


}

class AppRouter{
    public static void navigateTo(AppRoute target){
        activeRoute = target;
    }
    protected static AppRoute activeRoute;
    public enum AppRoute {
        LOGIN,
        MAIN_MENU, // main menu pegawai
        MASTER_MAIN_MENU, // main menu manager
        MASTER_PEGAWAI,
        MASTER_CUSTOMER,
        MASTER_KAMAR,
        MASTER_TRANSAKSI,
        MASTER_REPORTING,

        TRANSAKSI,
        REPORTING,
        EXIT
    };
}
