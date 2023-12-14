package DataSource.Enums;

public class Enums {
    // put enums here
    enum StatusKamar {
        AVAILABLE,
        OCCUPIED,
        BOOKED,
        CLEANING
    }

    enum UserRole {
        PEGAWAI,
        MANAGER
    }

    enum Pembayaran{
        BANK,
        CASH
    }

    enum StatusTransaksi{
        PENDING,
        ONGOING,
        DONE
    }
}
