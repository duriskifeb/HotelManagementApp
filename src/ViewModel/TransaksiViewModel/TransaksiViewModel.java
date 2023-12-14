package ViewModel.TransaksiViewModel;

import Data.Model.Transaksi;
import Domain.Transaksi.TransaksiUseCase;

public class TransaksiViewModel {
    TransaksiUseCase transaksiUseCase;

    public TransaksiViewModel(TransaksiUseCase transaksiUseCase) {
        this.transaksiUseCase = transaksiUseCase;
    }
}
