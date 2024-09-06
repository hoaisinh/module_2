package common;

import model.XeTai;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class File {
    private final static String PATH_XETAI = "src/data/xeTai.csv";
    private final static String PATH_HANG = "src/data/hangSanXuat.csv";

    public static List<XeTai> getAllXeTai(){
        List<XeTai> list = new ArrayList<>();
        try(

                FileReader fileReader = new FileReader(PATH_XETAI);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String temp;
            String[] arrData;
            while ((temp = bufferedReader.readLine()) != null){
                arrData = temp.split(",");
                list.add(new XeTai(arrData[0],arrData[1],Integer.parseInt(arrData[2]),arrData[3],Integer.parseInt(arrData[4])));
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        return list;
    }
    public static List<String> getHangSanXuat (){
        List<String> list = new ArrayList<>();
        try(

                FileReader fileReader = new FileReader(PATH_HANG);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String temp;
            String[] arrData;
            while ((temp = bufferedReader.readLine()) != null){
                arrData = temp.split(",");
                list.add(arrData[1]);
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        return list;
    }
    public static void addXeTai(XeTai xeTai){
        try(
                FileWriter fileWriter = new FileWriter(PATH_XETAI,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        ){
            bufferedWriter.write(xeTai.dataToString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void updateListXeTai(List<XeTai> lists){
        try(
                FileWriter fileWriter = new FileWriter(PATH_XETAI);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        ){
            for (XeTai xeTai:lists){
                bufferedWriter.write(xeTai.dataToString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
