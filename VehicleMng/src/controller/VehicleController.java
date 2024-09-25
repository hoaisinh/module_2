package controller;

import common.CustomFunction;
import common.File;
import common.Notifications;
import common.Validation;
import model.vehicle.Motorbike;
import model.vehicle.Car;
import model.vehicle.Truck;
import service.motorbike.MotorbikeService;
import service.car.CarService;
import service.truck.TruckService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleController {
    private String licensePlate, manufacturer, owner;
    private int yearOfManufacture;
    private final Scanner scanner = new Scanner(System.in);
    private final TruckService truckService = new TruckService();
    private final CarService carService = new CarService();
    private final MotorbikeService motorbikeService = new MotorbikeService();
    private final static String PATH_MANUFACTURER = "src/data/manufacturer.csv";
    private final static Notifications NOTIFICATIONS = new Notifications("");
    
    public String selectManufacturer(){
        List<String> listInformationManufacturer = File.readFile(PATH_MANUFACTURER);
        String[] arrData;
        List<String> listOfManufacturingCompanies = new ArrayList<>();
        for (String informationHSX:listInformationManufacturer){
            arrData = informationHSX.split(",");
            listOfManufacturingCompanies.add(arrData[1]);
        }
        int tempIndex;
        do{
            for (int i = 0; i < listOfManufacturingCompanies.size() ; i++) {
                System.out.println(
                        i + " - "+ listOfManufacturingCompanies.get(i)
                );
            }
            NOTIFICATIONS.enterSelect();
            String tempChoose;
            do{
                tempChoose = CustomFunction.requiredDataInput();
                if(!Validation.isNumber(tempChoose)){
                    NOTIFICATIONS.dataIsNumeric();
                }
            }while (!Validation.isNumber(tempChoose));
             tempIndex = Integer.parseInt(tempChoose);
            if(tempIndex > listOfManufacturingCompanies.size()-1){
                NOTIFICATIONS.availableNumber();
            }
        }while (tempIndex > listOfManufacturingCompanies.size()-1);
        return listOfManufacturingCompanies.get(tempIndex);
    }
    
    public String selectVehicleModel(){
        List<String> listVehicleModel = new ArrayList<>();
        listVehicleModel.add("Xe Khách");
        listVehicleModel.add("Xe Du Lịch");
        int tempIndex;
        do{
            for (int i = 0; i < listVehicleModel.size() ; i++) {
                System.out.println(
                        i + " - "+ listVehicleModel.get(i)
                );
            }
            String tempChoose;
            do{
                tempChoose = CustomFunction.requiredDataInput();
                if(!Validation.isNumber(tempChoose)){
                    NOTIFICATIONS.dataIsNumeric();
                }
            }while (!Validation.isNumber(tempChoose));
            tempIndex = Integer.parseInt(tempChoose);
            if(tempIndex > listVehicleModel.size()-1){
                NOTIFICATIONS.availableNumber();
            }
        }while (tempIndex > listVehicleModel.size()-1);
        return listVehicleModel.get(tempIndex);
    }
    
    public void inputData(String hadLicensePlate, int vehicleType){
        if(hadLicensePlate == null){
            boolean isExist;
            do{
                System.out.println("Enter license plate");
                licensePlate = CustomFunction.requiredDataInput();
                isExist = isExist(licensePlate,vehicleType);
                if(isExist){
                    System.out.println("licensePlate = " + licensePlate + " already exists");
                }
            }while (isExist);
        }
        System.out.println("Choose a manufacturer");
        manufacturer = selectManufacturer();
        System.out.println("Year of manufacture");
        String temp;
        do{

            temp = CustomFunction.requiredDataInput();
             if(!Validation.isYear(temp)){
                 System.out.println("Year of manufacture must be from 1000 to 2999");
             }
        }while (!Validation.isYear(temp));
        yearOfManufacture = Integer.parseInt(temp);
        System.out.println("Enter Owner");
        owner = CustomFunction.requiredDataInput();
    }

    public  boolean isExist(String licensePlate,int type){
        if(type == 1){
            Truck xeTai = truckService.findByBKS(licensePlate);
            return  xeTai != null;
        } else if (type == 2) {
            Car xeOto = carService.findByBKS(licensePlate);
            return xeOto != null;
        } else if (type == 3) {
            Motorbike xeMay = motorbikeService.findByBKS(licensePlate);
            return xeMay != null;
        }
        return false;
    }

    public void getAll(int type){
        if(type == 1){
            List<Truck> lists;
           lists = truckService.getAll();
            for(Truck truck:lists){
                System.out.println(truck.toString());
            }
        } else if (type == 2) {
           List<Car> lists = carService.getAll();
            for(Car car:lists){
                System.out.println(car.toString());
            }
        } else if (type == 3) {
            List<Motorbike> lists = motorbikeService.getAll();
            for(Motorbike motorbike:lists){
                System.out.println(motorbike.toString());
            }
        }else {
            System.out.println("There is no such vehicle in the system");
        }
    }
    
    public void addTruck(String hadLicensePlate){
        boolean isAdd = true;
        inputData(hadLicensePlate,1);
        if(hadLicensePlate != null){
            isAdd = false;
            licensePlate = hadLicensePlate;
        }

        System.out.println("Enter payload");
        String temp;
        do{
            temp = CustomFunction.requiredDataInput();
            if(!Validation.isNumber(temp)){
                System.out.println("Data must be in numeric format");
            }
        }while (!Validation.isNumber(temp));
        int payload = Integer.parseInt(temp);
        Truck truck = new Truck(licensePlate, manufacturer, owner, yearOfManufacture,payload);
        if(isAdd){
            truckService.addVehicle(truck);
        }else {
            truckService.updateVehicle(truck);
        }
    }
    
    public void addCar(String hadLicensePlate){
        boolean isAdd;
        inputData(hadLicensePlate,2);
        if(hadLicensePlate == null){
            isAdd = true;
        }else {
            isAdd = false;
            licensePlate = hadLicensePlate;
        }
        System.out.println("Enter number of seats");
        String temp;
        do{
            temp = CustomFunction.requiredDataInput();
            if(!Validation.isNumber(temp)){
                System.out.println("Data must be in numeric format");
            }
        }while (!Validation.isNumber(temp));
        int numberOfSeats = Integer.parseInt(temp);
        System.out.println("Select vehicle model");
        String vehicleModel = selectVehicleModel();
        Car car = new Car(licensePlate, manufacturer,owner, yearOfManufacture, numberOfSeats,vehicleModel);
        if(isAdd){
            carService.addVehicle(car);
        }else {
            carService.updateVehicle(car);
        }
    }
    
    public void addMotorbike(String hadLicensePlate){
        boolean isAdd;
        inputData(hadLicensePlate,3);
        if(hadLicensePlate == null){
            isAdd = true;
        }else {
            isAdd = false;
            licensePlate = hadLicensePlate;
        }
        System.out.println("Enter payload");
        String temp;
        do{
            temp = CustomFunction.requiredDataInput();
            if(!Validation.isNumber(temp)){
                System.out.println("Data must be in numeric format");
            }
        }while (!Validation.isNumber(temp));
        int capacity = Integer.parseInt(temp);
        Motorbike motorbike = new Motorbike(licensePlate, manufacturer, owner, yearOfManufacture,capacity);
        if(isAdd){
            motorbikeService.addVehicle(motorbike);
        }else {
            motorbikeService.updateVehicle(motorbike);
        }

    }

    public Boolean isDeleteVehicle(String licensePlate){
        System.out.println("Are you sure you want to delete vehicles with license plates = "+licensePlate+"\n"
                +"0 - No \n"
                +"1 - Yes"
        );
        int choose = Integer.parseInt(CustomFunction.requiredDataInput());
        return choose == 1;
    }
    
    public void deleteTruck(){
        System.out.println("Enter the license plate number of the vehicle to be deleted");
        String licensePlate = CustomFunction.requiredDataInput();
        if(isExist(licensePlate,1)){
            if(isDeleteVehicle(licensePlate)){
                truckService.deleteVehicle(licensePlate);
                System.out.println("Vehicle with license plate number = "+licensePlate+" has been deleted!");
            }else {
                System.out.println("You have chosen not to delete");
            }
        }else {
            System.out.println("Vehicle with license plate number ="+licensePlate+ "does not exist!");
        }
    }
    
    public void deleteCar(){
        System.out.println("Enter the license plate number of the vehicle to be deleted");
        String licensePlate = CustomFunction.requiredDataInput();
        if(isExist(licensePlate,2)){
            if(isDeleteVehicle(licensePlate)){
                carService.deleteVehicle(licensePlate);
                System.out.println("Vehicle with license plate number = "+licensePlate+" has been deleted!");
            }else {
                System.out.println("You have chosen not to delete");
            }
        }else {
            System.out.println("Vehicle with license plate number ="+licensePlate+" does not exist!");
        }
    }
    
    public void deleteMotorbike(){
        System.out.println("Enter the license plate number of the vehicle to be deleted");
        String licensePlate = CustomFunction.requiredDataInput();
        if(isExist(licensePlate,3)){
            if(isDeleteVehicle(licensePlate)){
                motorbikeService.deleteVehicle(licensePlate);
                System.out.println("Vehicle with license plate number ="+licensePlate+" has been deleted!");
            }else {
                System.out.println("You have chosen not to delete");
            }
        }else {
            System.out.println("Vehicle with license plate number ="+licensePlate+" does not exist!");
        }
    }
    
    public void updateVehicle(int type){
        System.out.println("Enter the license plate number of the vehicle to be updated");
        String licensePlate = CustomFunction.requiredDataInput();
        if(type == 1){
            if(isExist(licensePlate,1)){
                addTruck(licensePlate);
            }else {
                System.out.println("The license plate number is invalid");
            }
        } else if (type == 2) {
            if(isExist(licensePlate,2)) {
                addCar(licensePlate);
            }else {
                System.out.println("The license plate number is invalid");
            }
        } else if (type == 3) {
            if(isExist(licensePlate,3)) {
                addMotorbike(licensePlate);
            }else {
                System.out.println("The license plate number is invalid");
            }
        }
    }
}
