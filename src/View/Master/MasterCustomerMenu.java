package View.Master;

import static Util.Formatting.invalidChoice;
import static View.AppRouter.AppRoute.MASTER_CUSTOMER;
import static View.AppRouter.AppRoute.MASTER_MAIN_MENU;

import java.io.IOException;

import Util.InputUtilities;
import View.AppRouter;
import View.AppRouter.AppRoute;
import ViewModel.MasterViewModel.MasterCustomerViewModel;

public class MasterCustomerMenu {
    private final MasterCustomerViewModel masterCustomerVM;

    public MasterCustomerMenu(MasterCustomerViewModel masterCustomerVM) {
        this.masterCustomerVM = masterCustomerVM;
    }

    String inputUser;

    public void showMasterCustomerMenu() {
        while (AppRouter.activeRoute == MASTER_CUSTOMER) {
            InputUtilities.cls();
            System.out.println("==============================");
            System.out.println("        MASTER CUSTOMER       ");
            System.out.println("==============================");
            System.out.println("1. Show all customer");
            System.out.println("2. Choose customer");
            System.out.println("3. Add customer");
            System.out.println("0. Back");
            System.out.println();
            try {
                System.out.print("Masukkan Pilihan : ");
                inputUser = InputUtilities.input.readLine();
                switch (inputUser) {
                    case "1":
                        showAllCustomer();
                        break;
                    case "2":
                        choosingCustomer();
                        break;
                    case "3":
                        addCustomer();
                        break;
                    case "0":
                        AppRouter.navigateTo(MASTER_MAIN_MENU);
                        break;
                    default:
                        invalidChoice();;
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showAllCustomer() {

    }

    private void choosingCustomer() {

    }

    private void addCustomer() {
        
    }

}

// TODO @David
// add new menu methods to Create (Register), View, Update, and Delete Customer
