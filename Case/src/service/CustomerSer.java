package service;

import model.Customer;
import repository.CustomerRes;
import common.ReadFile;

import java.time.LocalDate;
import java.util.List;

public class CustomerSer implements ICustomerSer {

    private final CustomerRes customerRes = new CustomerRes();
    @Override
    public List<Customer> getAllCustomer() {
        return customerRes.getAllCustomer();
    }

    @Override
    public boolean addCustomer(String name, String address, LocalDate birthday) {
        int id = ReadFile.getMaxID()+1;
        return customerRes.addCustomer(id,name,address,birthday);


    }

    @Override
    public void deleteCustomer(int id) {
        customerRes.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRes.updateCustomer(customer);
    }

    @Override
    public Customer findByID(int id) {
        return customerRes.findByID(id);
    }
}
