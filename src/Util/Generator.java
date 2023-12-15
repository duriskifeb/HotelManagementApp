package Util;

import Data.Enums.Enums;

import java.util.Locale;

public class Generator {
    public static String generatePegawaiID(String name, Enums.UserRole role, String email){
        String result;


        result = name +"-"+ email;
        result = Encryption.hashID(result, 5);
        switch (role){
            case PEGAWAI :
                result += "-P";
                break;
            case MANAGER:
                result += "-M";
                break;
        }

        return result.toUpperCase();
    }

    public static String generateReportNumber(String picName, String dateCreated, String totalPrice, String transaksiNumberSum){
        String result;
        result = picName +"-"+ dateCreated + "-"+ totalPrice + "-"+ transaksiNumberSum;
        result = Encryption.hashID(result, 10);
        return result.toUpperCase();
    }

    public static String generateTransaksiID(String tanggalTransaksi, String totalPrice, String orderName, String picName, Enums.Pembayaran payment){
        String result;
        result = picName +"-"+ tanggalTransaksi + "-"+ totalPrice + "-" + "-" + orderName + "-"+ payment;
        result = Encryption.hashID(result, 10);
        return result.toLowerCase();
    }
}
