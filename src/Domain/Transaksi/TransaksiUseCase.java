package Domain.Transaksi;

import Data.DataSource.TransaksiDataSource;

public class TransaksiUseCase {
    TransaksiDataSource dataSource;

    public TransaksiUseCase(TransaksiDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
