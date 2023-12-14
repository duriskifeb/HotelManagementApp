package Data.DataSource;

import Data.Enums.Enums;
import Data.Model.Customer;
import Data.Model.User;
import Util.Encryption;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerDataSource {
    private ArrayList<Customer> listCustomer = new ArrayList<>(
            Arrays.asList(
                    new Customer(
                            "12012310312",
                            "David",
                            "david-ntb@gmail.com",
                            "01923910239"
                    ),
                    new Customer(
                            "1201230016",
                            "Ryan",
                            "ryanadika09@gmail.com",
                            "08123867390"
                    )

                    // TODO @Ryan lanjutin yan, buat data yang agak banyak
            )
    );

    public ArrayList<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(ArrayList<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }


    public void addCustomer(Customer customer) {
        listCustomer.add(customer);
    }

    public void removeCustomer(Customer customer){
        listCustomer.remove(customer);
    }
    public void editCustomer(int index , Customer customer){
        listCustomer.set(index, customer);
    }


}
