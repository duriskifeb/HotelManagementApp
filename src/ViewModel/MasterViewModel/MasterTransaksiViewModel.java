package ViewModel.MasterViewModel;

import Domain.Master.MasterKamar;
import Domain.Master.MasterTransaksi;
import Domain.Transaksi.TransaksiUseCase;

public class MasterTransaksiViewModel {
    MasterTransaksi masterTransaksi;
    TransaksiUseCase transaksiUseCase;
    public MasterTransaksiViewModel(MasterTransaksi masterTransaksi, TransaksiUseCase transaksiUseCase) {
        this.transaksiUseCase = transaksiUseCase;
        this.masterTransaksi = masterTransaksi;
    }

    // TODO implement
}
