package ViewModel.MasterViewModel;

import Data.Model.Customer;
import Data.Model.Kamar;
import Domain.Master.MasterKamar;
import Domain.Master.MasterTransaksi;

public class MasterKamarViewModel {
    MasterKamar masterKamar;

    public MasterKamarViewModel(MasterKamar masterKamar) {
        this.masterKamar = masterKamar;
    }
    Kamar currentSelectedKamar;
    public void selectKamar(String noKamar){
        this.currentSelectedKamar = masterKamar.getKamar(noKamar);
    }

    public void viewDataSelectedKamar(){
        if(currentSelectedKamar != null){
            // TODO implement
//            String idCustomer = currentSelectedCustomer.getNIK();
//            String namaCustomer = currentSelectedCustomer.getNama();
//            String telp = currentSelectedCustomer.getTelp();
//            String email = currentSelectedCustomer.getEmail();
//            System.out.format("%10s %25s \t%20s \t%20s\n", idCustomer, namaCustomer, telp, email);
        }
    }
    public void viewAllDataKamar(){

        masterKamar.getAllKamar()
                .stream()
                .iterator()
                .forEachRemaining(
                        kamar -> {
                            // TODO implement
//                            String idCustomer = cust.getNIK();
//                            String namaCustomer = cust.getNama();
//                            String telp = cust.getTelp();
//                            String email = cust.getEmail();
//                            System.out.format("%10s %25s \t%20s \t%20s\n", idCustomer, namaCustomer, telp, email);

                        }
                );
    }
    public void addNewKamar(
//            String NIK, String nama, String email, String telp
    ){
        // TODO implement
//        Kamar kamar = new Kamar(
//                NIK,
//                nama,
//                email,
//                telp
//        );
//        masterKamar.addKamar(kamar);
    }
    public void deleteKamar(String NIK) {
        masterKamar.deleteKamar(NIK);
    }
    public void editKamar(
//            String NIK, String nama, String email, String telp
    ){

        // TODO Implement
//        Customer newData = new Customer(
//                NIK,
//                nama,
//                email,
//                telp
//        );
//
//        if(currentSelectedKamar != null){
//            masterKamar.editDataKamar(currentSelectedKamar, newData);
//        }
    }


}
