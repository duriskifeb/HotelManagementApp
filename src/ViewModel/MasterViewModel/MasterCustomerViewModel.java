package ViewModel.MasterViewModel;

import Data.Model.Customer;
import Domain.Master.MasterCustomer;

import static Util.Formatting.formatMessageOutput;
import static View.Components.CustomerView.headerViewCustomer;

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

    public void addNewCustomer(String NIK, String nama, String email, String telp){

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

    //delete selected customer
    public void deleteCustomer() {
        if(currentSelectedCustomer != null){
            masterCustomer.deleteCustomer(this.currentSelectedCustomer.getNIK());
        }

    }
    public void editCustomer(String NIK, String nama, String email, String telp){

        if(currentSelectedCustomer != null){
            Customer newData = new Customer(
                    NIK.isBlank() ? currentSelectedCustomer.getNIK() : NIK,
                    nama.isBlank() ? currentSelectedCustomer.getNama() : nama,
                    email.isBlank() ? currentSelectedCustomer.getEmail() : email,
                    telp.isBlank() ? currentSelectedCustomer.getTelp() : telp
            );

            masterCustomer.editDataCustomer(currentSelectedCustomer, newData);
        }
    }


}
