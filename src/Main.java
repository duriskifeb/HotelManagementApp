
import Util.Encryption;
import Util.InputUtilities;
import View.AppRouter;
import View.Components.CustomerView;

import java.util.LinkedList;


public class Main {
    public static void main(String[] args)  {
        DI.init();
        HotelManagementApp app = new HotelManagementApp();
        app.run();

//        LinkedList<AppRouter.AppRoute> routeList = new LinkedList();
//
//        routeList.add(AppRouter.AppRoute.MAIN_MENU);
//
//        System.out.println(routeList);
//        System.out.println("navigate");
//        System.out.println();
//
//        routeList.add(AppRouter.AppRoute.MASTER_CUSTOMER);
//
//        System.out.println(routeList);
//        System.out.println("navigate");
//        System.out.println();
//
//        routeList.add(AppRouter.AppRoute.SUB_MASTER_DETAIL_CUSTOMER);
//
//        System.out.println(routeList);
//        System.out.println("navigate");
//        System.out.println();
//
//        System.out.println("current");
//        System.out.println(routeList.getLast());
//        System.out.println();
//
//        System.out.println("back");
//        routeList.removeLast();
//        System.out.println(routeList);
//
//        System.out.println("current");
//        System.out.println(routeList.getLast());
//        System.out.println();

    }
} 