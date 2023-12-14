package Domain.Master;

import Data.DataSource.TransaksiDataSource;

public class MasterTransaksi {
    TransaksiDataSource dataSource;
    public MasterTransaksi(TransaksiDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
