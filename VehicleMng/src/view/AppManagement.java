package view;

import controller.VehicleController;

import java.util.Scanner;

public class AppManagement {
    private final static Scanner scanner = new Scanner(System.in);
    private static final VehicleController VEHICLE_CONTROLLER = new VehicleController();
    public static void main(String[] args) {
        vehicleManagement();
    }
    public static void vehicleManagement(){

        do{
            System.out.println(
                    "-------------Quản lý phương tiện------------- \n" +
                            "1. Thêm mới  \n" +
                            "2. Hiển thị  \n" +
                            "3. Xóa  \n" +
                            "4. Cập nhật thông tin \n" +
                            "5. Thoát"
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
                    updateVehicle();break;
                case 5:
                    System.exit(1);break;
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
              VEHICLE_CONTROLLER.addTruck(null);break;
            case 2:
                VEHICLE_CONTROLLER.addCar(null);break;
            case 3:
               VEHICLE_CONTROLLER.addMotorbike(null);break;

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
                VEHICLE_CONTROLLER.getAll(1);break;
            case 2:
                VEHICLE_CONTROLLER.getAll(2);;break;
            case 3:
                VEHICLE_CONTROLLER.getAll(3);break;

        }
    }
    public static void updateVehicle(){
        System.out.println(
                "-------------Cập nhật thông tin phương tiện ------------- \n" +
                        "1. Xe tải \n" +
                        "2. Xe ô tô \n" +
                        "3. Xe máy"
        );
        int choose =Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1:
                VEHICLE_CONTROLLER.updateVehicle(1);break;
            case 2:
                VEHICLE_CONTROLLER.updateVehicle(2);;break;
            case 3:
                VEHICLE_CONTROLLER.updateVehicle(3);break;

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
                VEHICLE_CONTROLLER.deleteTruck();break;
            case 2:
                VEHICLE_CONTROLLER.deleteCar();;break;
            case 3:
                VEHICLE_CONTROLLER.deleteMotorbike();break;

        }
    }
}
