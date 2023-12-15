package ViewModel.MasterViewModel;

import Data.Model.Customer;
import Domain.Master.MasterCustomer;

import static Util.Formatting.formatMessageOutput;

public class MasterCustomerViewModel {
    MasterCustomer masterCustomer;
    public MasterCustomerViewModel(MasterCustomer masterCustomer) {
        this.masterCustomer = masterCustomer;
    }

    Customer currentSelectedCustomer;

    public void selectCustomer(String nik){
        this.currentSelectedCustomer = masterCustomer.getCustomer(nik);
        if(this.currentSelectedCustomer == null) {
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }
    public void viewDataSelectedCustomer(){
        if(currentSelectedCustomer != null){
            headerViewCustomer();
            String idCustomer = currentSelectedCustomer.getNIK();
            String namaCustomer = currentSelectedCustomer.getNama();
            String telp = currentSelectedCustomer.getTelp();
            String email = currentSelectedCustomer.getEmail();
            System.out.format("%10s %25s \t%20s \t%20s\n", idCustomer, namaCustomer, telp, email);
        }
    }
    public void viewAllDataCustomer(){
        headerViewCustomer();
        masterCustomer.getListCustomer()
                .stream()
                .iterator()
                .forEachRemaining(
                        cust -> {
                            String idCustomer = cust.getNIK();
                            String namaCustomer = cust.getNama();
                            String telp = cust.getTelp();
                            String email = cust.getEmail();
                            System.out.format("%10s %25s \t%20s \t%20s\n", idCustomer, namaCustomer, telp, email);

                        }
                );
    }
    public void addNewCustomer(String NIK, String nama, String email, String telp){
        // TODO implement the parameters
        Customer customer = new Customer(
                NIK,
                nama,
                email,
                telp
        );
        masterCustomer.addCustomer(customer);
    }
    public void deleteCustomer(String NIK) {
        masterCustomer.deleteCustomer(NIK);
    }
    public void editCustomer(String NIK, String nama, String email, String telp){
        Customer newData = new Customer(
                NIK,
                nama,
                email,
                telp
        );

        if(currentSelectedCustomer != null){
            masterCustomer.editDataCustomer(currentSelectedCustomer, newData);
        }
    }


    // TODO Move this method to View Layer
    private void headerViewCustomer(){
        System.out.println("_______________________________________________________________________________________");
        System.out.format("%10s %25s %20s %20s\n", "NIK", "Nama", "No telp", "Email");
        System.out.println("_______________________________________________________________________________________");
    }
}
