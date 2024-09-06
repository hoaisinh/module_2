package service;

import model.Customer;

import java.time.LocalDate;
import java.util.List;

public interface ICustomerSer {
    List<Customer> getAllCustomer();

    boolean addCustomer( String name, String address, LocalDate birthday);

    void deleteCustomer(int id);

    void updateCustomer(Customer customer);

    Customer findByID(int id);
}
