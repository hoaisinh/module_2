package common;

import model.Customer;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private final static String PATH = "D:\\codeGym_ln\\MD2\\New\\Case\\src\\data\\customers.csv";
    public static List<Customer> getListCustomerFromFile() {
        List<Customer> list = new ArrayList<>();
        try(
                FileReader fileReader = new FileReader(PATH);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                ){
            String temp;
            String[] arrData;
            while ((temp = bufferedReader.readLine()) != null){
                arrData = temp.split(",");
                list.add(new Customer(Integer.parseInt(arrData[0]),arrData[1],arrData[2], LocalDate.parse(arrData[3])));
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        return list;
    }
    public static Integer getMaxID(){
        List<Customer> customers = getListCustomerFromFile();
        int maxID = 1;
        for(Customer customer:customers){
            if(customer.getId() > maxID){
                maxID = customer.getId();
            }
        }
        return maxID;
    }
    public static void addCustomerToFile(Customer customer){
        try (
                FileWriter fileWriter = new FileWriter(PATH,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                ){
        bufferedWriter.write(customer.dataToString());
        bufferedWriter.newLine();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("123");
    }
    public static void updateCustomer(List<Customer> customers){
        try(
                FileWriter fileWriter = new FileWriter(PATH);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        ){
            for (Customer customer:customers){
                bufferedWriter.write(customer.dataToString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
