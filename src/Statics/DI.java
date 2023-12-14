package Statics;

import Data.DataSource.*;
import Domain.Auth.AuthUserCase;
import Domain.Master.MasterKamar;
import Domain.Master.MasterPegawai;
import Domain.Master.MasterReporting;
import Domain.Master.MasterTransaksi;
import Domain.Report.Reporting;
import Domain.Transaksi.TransaksiUseCase;
import ViewModel.AuthViewModel.AuthViewModel;

public class DI {

    // Datasources
    public static PegawaiDataSource pegawaiDataSource = new PegawaiDataSource();
    public static CustomerDataSource customerDataSource = new CustomerDataSource();
    public static KamarDataSource kamarDataSource = new KamarDataSource();
    public static TransaksiDataSource transaksiDataSource = new TransaksiDataSource();
    public static ReportDataSource reportDataSource = new ReportDataSource(
            DI.customerDataSource,
            DI.kamarDataSource,
            DI.transaksiDataSource
    );


    //Domains
    public static AuthUserCase authUserCase = new AuthUserCase(DI.pegawaiDataSource);
    public static MasterPegawai masterPegawai = new MasterPegawai(DI.pegawaiDataSource);
    public static MasterKamar masterKamar = new MasterKamar(DI.kamarDataSource);
    public static MasterTransaksi masterTransaksi = new MasterTransaksi(DI.transaksiDataSource);
    public static MasterReporting masterReporting = new MasterReporting(DI.reportDataSource);
    public static Reporting reporting = new Reporting(
            DI.customerDataSource,
            DI.kamarDataSource,
            DI.transaksiDataSource,
            DI.reportDataSource
    );

    public static TransaksiUseCase transaksiUseCase = new TransaksiUseCase(DI.transaksiDataSource);

    // ViewModel
    public static AuthViewModel authViewModel = new AuthViewModel(DI.authUserCase);

}
