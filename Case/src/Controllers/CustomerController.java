package Controllers;

import model.Customer;
import service.CustomerSer;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerController {

    private String name, address;
    private LocalDate birthday;
    private final Scanner scanner = new Scanner(System.in);
    private final CustomerSer customerSer = new CustomerSer();
    public void inputData(){
        System.out.println("Nhập tên khách hàng");
        name = scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng");
        address = scanner.nextLine();
        System.out.println("Nhập ngày sinh khách hàng");
        birthday = LocalDate.parse(scanner.nextLine());
    }
    public void getAllCustomer(){
//        System.out.println("Danh sách");
        List<Customer> customers = customerSer.getAllCustomer();
        for(Customer customer:customers){
            System.out.println(customer.toString());
        }
    }
    public void addCustomer(){
        inputData();
        boolean isAddCustomer = customerSer.addCustomer(name,address,birthday);


    }
    public void updateCustomer(){

        System.out.println("Nhập ID khách hàng cần chỉnh sửa");
        int id = Integer.parseInt(scanner.nextLine());
        if(isExistID(id)){
            inputData();
            Customer customer = new Customer(id,name,address,birthday);
            customerSer.updateCustomer(customer);
        }else {
            System.out.println("Khách hàng " + id + "không tồn tại");
        }
    }
    public void deleteCustomer(){
        System.out.println("Nhập id khách hàng muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        if(isExistID(id)){
            customerSer.deleteCustomer(id);
        }else {
            System.out.println("Học viên với id ="+id+" không tồn tại!");
        }
    }

    public boolean isExistID(int id){
           Customer customer = customerSer.findByID(id);
           return customer != null;
    }

}
