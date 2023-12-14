package Data.DataSource;

import Data.Enums.Enums;
import Data.Model.Kamar;
import Util.Encryption;

import java.util.ArrayList;
import java.util.Arrays;

public class KamarDataSource {
    private ArrayList<Kamar> listKamar = new ArrayList<>(
            Arrays.asList(
                    new Kamar( // SINGLE
                            "0101",
                            Enums.JenisKamar.SINGLE,
                            100000.0,
                            1,
                            Enums.StatusKamar.AVAILABLE),
                    new Kamar(
                            "0102",
                            Enums.JenisKamar.SINGLE,
                            100000.0,
                            1,
                            Enums.StatusKamar.AVAILABLE),
                    new Kamar( // DOUBLE
                            "0201",
                            Enums.JenisKamar.DOUBLE,
                            150000.0,
                            2,
                            Enums.StatusKamar.AVAILABLE),
                    new Kamar(
                            "0202",
                            Enums.JenisKamar.DOUBLE,
                            150000.0,
                            2,
                            Enums.StatusKamar.AVAILABLE),
                    new Kamar( // FAMILY
                            "0301",
                            Enums.JenisKamar.FAMILY,
                            300000.0,
                            4,
                            Enums.StatusKamar.AVAILABLE),
                    new Kamar(
                            "0302",
                            Enums.JenisKamar.FAMILY,
                            300000.0,
                            4,
                            Enums.StatusKamar.AVAILABLE),
                    new Kamar( // VIP
                            "0401",
                            Enums.JenisKamar.VIP,
                            400000.0,
                            2,
                            Enums.StatusKamar.AVAILABLE),
                    new Kamar(
                            "0402",
                            Enums.JenisKamar.VIP,
                            400000.0,
                            2,
                            Enums.StatusKamar.AVAILABLE),
                    new Kamar( // BUSINESS
                            "0501",
                            Enums.JenisKamar.BUSINESS,
                            700000.0,
                            5,
                            Enums.StatusKamar.AVAILABLE),
                    new Kamar(
                            "0502",
                            Enums.JenisKamar.BUSINESS,
                            700000.0,
                            5,
                            Enums.StatusKamar.AVAILABLE)));

}
