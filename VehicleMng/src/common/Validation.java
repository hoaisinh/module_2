package common;

import java.util.regex.Pattern;

public class Validation {
    public final static String REG_NUMBER = "^[0-9]+$";
    public final static String REG_YEAR = "^[12][0-9]{3}$";
    public static Boolean isNumber(String number){
        return Pattern.matches(REG_NUMBER,number);
    }
    public static Boolean isYear(String number){
        return Pattern.matches(REG_YEAR,number);
    }
}
