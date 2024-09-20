package common;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {

    public static void writeToFile(String path,String data){
        try(
                FileWriter fileWriter = new FileWriter(path,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<String> readFile(String path){
        List<String> lists = new ArrayList<>();
        try(
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String temp;
            while ((temp = bufferedReader.readLine()) != null){
                lists.add(temp);
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        return lists;
    }
    public static void clearData(String path){
        try(
                FileWriter fileWriter = new FileWriter(path);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ){
            bufferedWriter.write("");

//            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
