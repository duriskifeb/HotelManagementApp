package View.Transaksi;

import View.AppRouter;
import ViewModel.AuthViewModel.AuthViewModel;
import ViewModel.TransaksiViewModel.TransaksiViewModel;

public class TransaksiMenu {

    private final TransaksiViewModel transaksiVM;
    private final AuthViewModel authViewModel;

    public TransaksiMenu(TransaksiViewModel transaksiVM, AuthViewModel authViewModel) {
        this.transaksiVM = transaksiVM;
        this.authViewModel = authViewModel;
    }

    public void showTransaksiMenu() {
        while (AppRouter.activeRoute == AppRouter.AppRoute.TRANSAKSI){

        }
//        # Transaksi #
//- lihat list transaksi
//- cari transaksi (lihat transaksi detail)
//- buat transaksi baru
//- pilih transaksi
//       - bayar
//       - check in
//       - check out
//      - batalkan transaksi
    }
}
