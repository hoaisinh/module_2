package Views;

import Controllers.CustomerController;

import java.util.Scanner;

public class CustomerManager {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CustomerMng();
    }
    public static void CustomerMng(){
        CustomerController customerController = new CustomerController();
        do{
            System.out.println(
                    """
                       -------------Home-------------" +
                       1. Xem danh sách
                       2. Thêm khách hàng
                       3. Cập nhật khách hàng
                       4. Xóa khách hàng
                       5. Thoát \n"""
            );
            int choose =Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1: customerController.getAllCustomer();break;
                case 2: customerController.addCustomer();break;
                case 3: customerController.updateCustomer();break;
                case 4: customerController.deleteCustomer();break;
                case 5: System.exit(0);break;
            }
        }while (true);
    }
}
