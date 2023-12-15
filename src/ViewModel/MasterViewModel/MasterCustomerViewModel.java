package ViewModel.MasterViewModel;

import Data.Model.Customer;
import Domain.Master.MasterCustomer;

public class MasterCustomerViewModel {
    MasterCustomer masterCustomer;
    public MasterCustomerViewModel(MasterCustomer masterCustomer) {
        this.masterCustomer = masterCustomer;
    }

    Customer currentSelectedCustomer;

    public void selecCustomer(String nik){
        this.currentSelectedCustomer = masterCustomer.getCustomer(nik);
    }

    public void viewDataCustomer(String NIK){
        if(currentSelectedCustomer != null){
            // TODO PRINT ALL DATA CUSTOMERS
        }
    }

    public void viewAllDataCustomer(){
        System.out.println("_______________________________________________________________________________________");
        System.out.format("%10s %25s %20s %20s\n", "NIK", "Nama", "No telp", "Email");
        System.out.println("_______________________________________________________________________________________");
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

    public void addNewCustomer(){
        Customer customer = new Customer(
                "NIK",
                "nama",
                "email",
                "telp"
        );
        masterCustomer.addCustomer(customer);

    }
}
