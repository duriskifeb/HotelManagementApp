package View.Components;

import Data.Model.ReportModel;

import java.util.ArrayList;

public class ReportingView {

    public static void viewAllReports(ArrayList<ReportModel> listReport){
        listReport
                .stream()
                .iterator()
                .forEachRemaining(
                        selectedReport -> {

                            // TODO @David show preview data report
//                            String idPegawai = user.getUserID();
//                            String nama = user.getNama();
//                            String email = user.getEmail();
//                            Enums.UserRole role = user.getRole();
//                            System.out.format("%10s %10s \t%15s \t%10s\n", idPegawai, nama, email, role);

                        }
                );
    }
    public static void viewDetailSelectedReport(ReportModel selectedReport){
        if(selectedReport != null){
            // TODO @David show all data in report (detail)
        }
    }
}
