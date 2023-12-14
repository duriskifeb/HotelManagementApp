package Domain.Master;

import Data.DataSource.CustomerDataSource;
import Data.Model.Customer;
import Data.Model.Kamar;

import static Util.Formatting.formatMessageOutput;

public class MasterCustomer {
    CustomerDataSource dataSource;

    public MasterCustomer(CustomerDataSource dataSource) {
        this.dataSource = dataSource;
    }
    void addCustomer(Customer customer) {
        // check if customer already exists
        if(!cekCustomer(customer.getNIK())){
            dataSource.addCustomer(customer);
        }else {
            formatMessageOutput("Data Kamar Sudah Ada");
        }
    }

    void deleteCustomer(String NIK){
        if(cekCustomer(NIK)){
            Customer kamar = getCustomer(NIK);
            dataSource.removeCustomer(kamar);
        }else {
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }
    public void editDataKamar(Customer oldDData,Customer newDData){
        // find the data's index
        if(cekCustomer(oldDData.getNIK())){
            int index = dataSource.getListCustomer().indexOf(oldDData);
            dataSource.editCustomer(index, newDData);
        }else{
            // data not found
            formatMessageOutput("Data Tidak Ditemukan");
        }
    }

    public Customer getCustomer(String nomorKamar){
        if(cekCustomer(nomorKamar)){
            return dataSource.getListCustomer().stream().filter(customer -> customer.getNIK().equals(nomorKamar)).findFirst().orElse(null);
        }else {
            formatMessageOutput("Data Tidak Ditemukan");
            return null;
        }
    }

    private boolean cekCustomer(String NIK) {
        Customer cek = dataSource.getListCustomer().stream().filter(
                cekKamar -> cekKamar.getNIK().equals(NIK)
        ).findFirst().orElse(null);
        return cek != null; // return kamar is Found when cek is not null
    }
}
