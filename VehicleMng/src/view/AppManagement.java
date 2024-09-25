package view;

import common.CustomFunction;
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
                    """
                            -------------Vehicle Management-------------\s
                            1. Add new \s
                            2. View list \s
                            3. Delete \s
                            4. Update\s
                            5. Exit"""
            );
            int choose =Integer.parseInt(CustomFunction.requiredDataInput());
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
                """
                        -------------Add Vehicle-------------\s
                        1. Truck\s
                        2. Car\s
                        3. Motorbike"""
        );
        int choose =Integer.parseInt(CustomFunction.requiredDataInput());
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
                """
                        -------------View Vehicle-------------\s
                        1. Truck\s
                        2. Car\s
                        3. Motorbike"""
        );
        int choose =Integer.parseInt(CustomFunction.requiredDataInput());
        switch (choose){
            case 1:
                VEHICLE_CONTROLLER.getAll(1);break;
            case 2:
                VEHICLE_CONTROLLER.getAll(2);break;
            case 3:
                VEHICLE_CONTROLLER.getAll(3);break;

        }
    }
    public static void updateVehicle(){
        System.out.println(
                """
                        -------------Update Vehicle-------------\s
                        1. Truck\s
                        2. Car\s
                        3. Motorbike"""
        );
        int choose =Integer.parseInt(CustomFunction.requiredDataInput());
        switch (choose){
            case 1:
                VEHICLE_CONTROLLER.updateVehicle(1);break;
            case 2:
                VEHICLE_CONTROLLER.updateVehicle(2);break;
            case 3:
                VEHICLE_CONTROLLER.updateVehicle(3);break;

        }
    }
    public static void deleteVehicle(){
        System.out.println(
                """
                        -------------Delete Vehicle-------------\s
                        1. Truck\s
                        2. Car\s
                        3. Motorbike"""
        );
        int choose =Integer.parseInt(CustomFunction.requiredDataInput());
        switch (choose){
            case 1:
                VEHICLE_CONTROLLER.deleteTruck();break;
            case 2:
                VEHICLE_CONTROLLER.deleteCar();break;
            case 3:
                VEHICLE_CONTROLLER.deleteMotorbike();break;

        }
    }
}
