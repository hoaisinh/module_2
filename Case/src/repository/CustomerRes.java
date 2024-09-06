package repository;

import model.Customer;
import common.ReadFile;

import java.time.LocalDate;
import java.util.List;

public class CustomerRes implements ICustomerRes{

    @Override
    public List<Customer> getAllCustomer() {
        return ReadFile.getListCustomerFromFile();
    }

    @Override
    public boolean addCustomer(int id, String name, String address, LocalDate birthday) {
        ReadFile.addCustomerToFile(new Customer(id,name,address,birthday));
        return true;
    }

    @Override
    public void deleteCustomer(int id) {
        List<Customer> lists = ReadFile.getListCustomerFromFile();
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i).getId() == id){
                lists.remove(i);
                break;
            }
        }
        ReadFile.updateCustomer(lists);
    }

    @Override
    public void updateCustomer(Customer customer) {
        List<Customer> lists= ReadFile.getListCustomerFromFile();
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i).getId() == customer.getId()){
                lists.set(i,customer);
                break;
            }
        }
        ReadFile.updateCustomer(lists);
    }

    @Override
    public Customer findByID(int id) {
        List<Customer> lists = ReadFile.getListCustomerFromFile();
        for( Customer customer : lists){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }
}
