package common;

import java.util.Objects;
import java.util.Scanner;

public class CustomFunction {
    private static final Scanner scanner = new Scanner(System.in);
    public static String  requiredDataInput(){
        String temp = "";
        boolean check = false;
        do{
            temp = scanner.nextLine();
            if(Objects.equals(temp, "")){
                check = true;
                System.out.println("Please enter data in this field");
            }else {
                check = false;
            }
        }while (check);
        return temp;
    }
}
