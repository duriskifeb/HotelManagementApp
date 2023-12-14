package DataSource.Enums;

public class Enums {
    // put enums here
    public enum StatusKamar {
        AVAILABLE,
        OCCUPIED,
        BOOKED,
        CLEANING
    }

    public enum JenisKamar{
        SINGLE,
        DOUBLE,
        FAMILY,
        VIP,
        BUSINESS
    }

    public enum UserRole {
        PEGAWAI,
        MANAGER
    }

    public enum Pembayaran{
        BANK,
        CASH
    }

    public enum StatusTransaksi{
        PENDING,
        ONGOING,
        DONE
    }

}
