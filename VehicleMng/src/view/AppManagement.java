package view;

import controller.Controller;

import java.util.Scanner;

public class AppManagement {
    private final static Scanner scanner = new Scanner(System.in);
    private static final Controller controller = new Controller();
    public static void main(String[] args) {
        vehicleManagement();
    }
    public static void vehicleManagement(){

        do{
            System.out.println(
                    "-------------Home------------- \n" +
                            "1. Thêm mới phương tiện \n" +
                            "2. Hiển thị phương tiện \n" +
                            "3. Xóa phương tiện \n" +
                            "4. Thoát"
            );
            int choose =Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    addVehicleManagement();break;
                case 2:
                    showVehicleManagement();break;
                case 3:
                    deleteVehicle();break;
                case 4:
                    System.out.println("Thoát");break;
            }
        }while (true);
    }
    public static void addVehicleManagement(){
        System.out.println(
                "-------------Thêm mới phương tiện ------------- \n" +
                        "1. Thêm mới xe tải \n" +
                        "2. Thêm mới xe ô tô \n" +
                        "3. Thêm mới xe máy"
        );
        int choose =Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1:
              controller.addXeTai();break;
            case 2:
                System.out.println("Thêm mới ô tô");break;
            case 3:
                System.out.println("Thêm mới xe máy");break;

        }
    }
    public static void showVehicleManagement(){
        System.out.println(
                "-------------Hiển thị phương tiện ------------- \n" +
                        "1. Hiển thị xe tải \n" +
                        "2. Hiển thị xe ô tô \n" +
                        "3. Hiển thị xe máy"
        );
        int choose =Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1:
                controller.getAll(1);break;
            case 2:
                System.out.println("oto");;break;
            case 3:
                System.out.println("Hiển thị danh sách xe máy");break;

        }
    }
    public static void deleteVehicle(){
        System.out.println(
                "-------------Xóa phương tiện ------------- \n" +
                        "1. Xóa xe tải \n" +
                        "2. Xóa xe ô tô \n" +
                        "3. Xóa xe máy"
        );
        int choose =Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1:
                controller.deleteXeTai();break;
            case 2:
                System.out.println("oto");;break;
            case 3:
                System.out.println("Hiển thị danh sách xe máy");break;

        }
    }
}
