package common;

import model.XeMay;
import model.XeOto;
import model.XeTai;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    private final static String PATH_XETAI = "src/data/xeTai.csv";
    private final static String PATH_HANG = "src/data/hangSanXuat.csv";

    private final static String PATH_XEOTO = "src/data/oto.csv";

    private final static String PATH_XEMAY = "src/data/xeMay.csv";

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
    public static List<XeOto> getAllXeOto(){
        List<XeOto> list = new ArrayList<>();
        try(

                FileReader fileReader = new FileReader(PATH_XEOTO);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String temp;
            String[] arrData;
            while ((temp = bufferedReader.readLine()) != null){
                arrData = temp.split(",");
                list.add(new XeOto(arrData[0],arrData[1],Integer.parseInt(arrData[2]),arrData[3],Integer.parseInt(arrData[4]),arrData[5]));
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        return list;
    }
    public static List<XeMay> getAllXeMay(){
        List<XeMay> list = new ArrayList<>();
        try(

                FileReader fileReader = new FileReader(PATH_XEMAY);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String temp;
            String[] arrData;
            while ((temp = bufferedReader.readLine()) != null){
                arrData = temp.split(",");
                list.add(new XeMay(arrData[0],arrData[1],Integer.parseInt(arrData[2]),arrData[3],Integer.parseInt(arrData[4])));
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
    public static void addXeOto(XeOto xeOto){
        try(
                FileWriter fileWriter = new FileWriter(PATH_XEOTO,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        ){
            bufferedWriter.write(xeOto.dataToString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void addXeMay(XeMay xeMay){
        try(
                FileWriter fileWriter = new FileWriter(PATH_XEMAY,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        ){
            bufferedWriter.write(xeMay.dataToString());
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
    public static void updateListXeOto(List<XeOto> lists){
        try(
                FileWriter fileWriter = new FileWriter(PATH_XEOTO);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        ){
            for (XeOto xeOto:lists){
                bufferedWriter.write(xeOto.dataToString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateListXeMay(List<XeMay> lists){
        try(
                FileWriter fileWriter = new FileWriter(PATH_XEMAY);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        ){
            for (XeMay xeMay:lists){
                bufferedWriter.write(xeMay.dataToString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
