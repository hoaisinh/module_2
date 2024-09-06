package repository;

import model.Customer;

import java.time.LocalDate;
import java.util.List;

public interface ICustomerRes {
    List<Customer> getAllCustomer();

    boolean addCustomer(int id, String name, String address, LocalDate birthday);

    void deleteCustomer(int id);

    void updateCustomer(Customer customer);

    Customer findByID(int id);
}
