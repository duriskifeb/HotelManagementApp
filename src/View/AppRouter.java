package View;

import java.util.LinkedList;

public class AppRouter {
    public static final LinkedList<AppRoute> routeStack = new LinkedList();
    public static void navigateTo(AppRoute target) {
        if(target != AppRoute.EXIT){
            routeStack.add(target);
            activeRoute = routeStack.getLast();//target;
        }else{
            activeRoute = target;
        }

    }

    public static void navigateUp(){
        if(routeStack.size() > 1){
            routeStack.removeLast();
            activeRoute = routeStack.getLast();
        }
    }

    public static AppRoute activeRoute;

    public enum AppRoute {
        // GLOBAL
        LOGIN,
        EXIT,

        TRANSAKSI,
        REPORTING,
        SUB_TRANSAKSI,

        // PEGAWAI
        MAIN_MENU, // main menu pegawai,

        SUB_PEGAWAI_KAMAR,
        SUB_PEGAWAI_CUSTOMER,


        // MANAGER
        MASTER_MAIN_MENU, // main menu manager
        MASTER_PEGAWAI,
        MASTER_CUSTOMER,
        MASTER_KAMAR,
        SUB_MASTER_DETAIL_KAMAR,
        SUB_MASTER_DETAIL_PEGAWAI,
        SUB_MASTER_DETAIL_CUSTOMER,
        SUB_MASTER_DETAIL_REPORTING,
        MASTER_TRANSAKSI,
        MASTER_REPORTING,
//        SUB_MASTER_TRANSAKSI,

    }

    ;
}
