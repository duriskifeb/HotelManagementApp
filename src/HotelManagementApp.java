import Data.Model.Transaksi;
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

    }


    public void run(){
        // initial route
        this.authMenu.ShowLogin();
    }
}
