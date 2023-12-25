package View;

public class AppRouter {
    public static void navigateTo(AppRoute target) {
        activeRoute = target;
    }

    public static AppRoute activeRoute;

    public enum AppRoute {
        LOGIN,
        MAIN_MENU, // main menu pegawai
        MASTER_MAIN_MENU, // main menu manager
        MASTER_PEGAWAI,
        MASTER_CUSTOMER,
        MASTER_KAMAR,
        SUB_MASTER_DETAIL_KAMAR,
        SUB_MASTER_DETAIL_PEGAWAI,
        SUB_MASTER_DETAIL_CUSTOMER,
        MASTER_TRANSAKSI,
        MASTER_REPORTING,
        TRANSAKSI,
        REPORTING,
        EXIT
    }

    ;
}
