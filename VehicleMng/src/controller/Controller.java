package controller;

import common.File;
import common.Validation;
import model.XeMay;
import model.XeOto;
import model.XeTai;
import service.XeMayService;
import service.XeOtoService;
import service.XeTaiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private String bienKiemSoat,hangSanXuat,chuSoHuu;
    private int namSanXuat;
    public String type;
    private final Scanner scanner = new Scanner(System.in);
    private final XeTaiService xeTaiService = new XeTaiService();
    private final XeOtoService xeOtoService = new XeOtoService();
    private final XeMayService xeMayService = new XeMayService();
    private final static String PATH_HANG = "src/data/hangSanXuat.csv";
    public String chonHangSanXuat(){
        List<String> listInformationHSX = File.readFile(PATH_HANG);
        String[] arrData;
        List<String> listTenHangXe = new ArrayList<>();
        for (String informationHSX:listInformationHSX){
            arrData = informationHSX.split(",");
            listTenHangXe.add(arrData[1]);
        }
        int tempIndex;
        do{
            for (int i = 0; i < listTenHangXe.size() ; i++) {
                System.out.println(
                        i + " - "+ listTenHangXe.get(i)
                );
            }
            System.out.println("Nhập lựa chọn của bạn");
            String tempChoose;
            do{
                tempChoose = scanner.nextLine();
                if(!Validation.isNumber(tempChoose)){
                    System.out.println("Dữ liệu phải có định dạng số");
                }
            }while (!Validation.isNumber(tempChoose));
             tempIndex = Integer.parseInt(tempChoose);
            if(tempIndex > listTenHangXe.size()-1){
                System.out.println("Vui lòng chọn các số có sẵn");
            }
        }while (tempIndex > listTenHangXe.size()-1);
        return listTenHangXe.get(tempIndex);
    }
    public String chonkieuXe(){
        List<String> listKieuXe = new ArrayList<>();
        listKieuXe.add("Xe Khách");
        listKieuXe.add("Xe Du Lịch");
        int tempIndex;
        do{
            for (int i = 0; i < listKieuXe.size() ; i++) {
                System.out.println(
                        i + " - "+ listKieuXe.get(i)
                );
            }
            String tempChoose;
            do{
                tempChoose = scanner.nextLine();
                if(!Validation.isNumber(tempChoose)){
                    System.out.println("Dữ liệu phải có định dạng số");
                }
            }while (!Validation.isNumber(tempChoose));
            tempIndex = Integer.parseInt(tempChoose);
            if(tempIndex > listKieuXe.size()-1){
                System.out.println("Vui lòng chọn các số có sẵn");
            }
        }while (tempIndex > listKieuXe.size()-1);
        return listKieuXe.get(tempIndex);
    }
    public void inputData(){

        System.out.println("Nhập Biển Kiểm Soát");
        bienKiemSoat =scanner.nextLine();
        System.out.println("Chọn hãng sản xuất");
        hangSanXuat = chonHangSanXuat();
        System.out.println("Nhập năm sản xuất");
        String temp;
        do{
             temp = scanner.nextLine();
             if(!Validation.isYear(temp)){
                 System.out.println("Năm sản xuất phải từ 1000 đến 2999");
             }
        }while (!Validation.isYear(temp));
        namSanXuat = Integer.parseInt(temp);
        System.out.println("Nhập chủ sở hữu");
        chuSoHuu =scanner.nextLine();
    }

    public void getAll(int type){

        if(type == 1){
            List<XeTai> lists;
           lists = xeTaiService.getAll();
            for(XeTai xeTai:lists){
                System.out.println(xeTai.toString());
            }
        } else if (type == 2) {
           List<XeOto> lists = xeOtoService.getAll();
            for(XeOto xeOto:lists){
                System.out.println(xeOto.toString());
            }
        } else if (type == 3) {
            List<XeMay> lists = xeMayService.getAll();
            for(XeMay xeMay:lists){
                System.out.println(xeMay.toString());
            }
        }else {
            System.out.println("Không có loại xe này trong hệ thống");
        }
    }
    public void addXeTai(){
        inputData();
        System.out.println("Nhập trọng tải");
        String temp;
        do{
            temp = scanner.nextLine();
            if(!Validation.isNumber(temp)){
                System.out.println("Nhập dữ liệu định dạng số");
            }
        }while (!Validation.isNumber(temp));
        int trongTai = Integer.parseInt(temp);
        XeTai xeTai = new XeTai(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,trongTai);
        xeTaiService.addXeTai(xeTai);
    }
    public void addXeOto(){
        inputData();
        System.out.println("Nhập số chỗ ngồi");
        String temp;
        do{
            temp = scanner.nextLine();
            if(!Validation.isNumber(temp)){
                System.out.println("Nhập dữ liệu định dạng số");
            }
        }while (!Validation.isNumber(temp));
        int soChoNgoi = Integer.parseInt(temp);
        System.out.println("Chọn kiểu xe");
        String kieuXe = chonkieuXe();
        XeOto xeOto = new XeOto(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,soChoNgoi,kieuXe);
        xeOtoService.addXeOto(xeOto);
    }
    public void addXeMay(){
        inputData();
        System.out.println("Nhập công suất");
        String temp;
        do{
            temp = scanner.nextLine();
            if(!Validation.isNumber(temp)){
                System.out.println("Nhập dữ liệu định dạng số");
            }
        }while (!Validation.isNumber(temp));
        int congSuat = Integer.parseInt(temp);
        XeMay xeMay = new XeMay(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,congSuat);
        xeMayService.addXeMay(xeMay);
    }

    public  boolean isExist(String bienKiemSoat,int type){
        if(type == 1){
            XeTai xeTai = xeTaiService.findByBKS(bienKiemSoat);
            return  xeTai != null;
        } else if (type == 2) {
            XeOto xeOto = xeOtoService.findByBKS(bienKiemSoat);
            return xeOto != null;
        } else if (type == 3) {
            XeMay xeMay = xeMayService.findByBKS(bienKiemSoat);
            return xeMay != null;
        }
        return false;
    }
    public Boolean isDeleteVehicle(String bienKiemSoat){
        System.out.println("Bạn có chắc chắn muốn xóa xe mang KKS = "+bienKiemSoat+"\n"
                +"0 - Không \n"
                +"1 - Có"
        );
        int choose = Integer.parseInt(scanner.nextLine());
        if(choose == 1){
            return true;
        }
        return false;
    }
    public void deleteXeTai(){
        System.out.println("Nhập biển kiểm soát cần xóa");
        String bienKiemSoat = scanner.nextLine();
        if(isExist(bienKiemSoat,1)){
            if(isDeleteVehicle(bienKiemSoat)){
                xeTaiService.deleteVehicle(bienKiemSoat);
                System.out.println("Xe mang BKS ="+bienKiemSoat+" đã được xóa!");
            }else {
                System.out.println("Không xóa thì thôi");
            }

        }else {
            System.out.println("Xe mang BKS ="+bienKiemSoat+" không tồn tại!");
        }
    }
    public void deleteXeOto(){
        System.out.println("Nhập biển kiểm soát cần xóa");
        String bienKiemSoat = scanner.nextLine();
        if(isExist(bienKiemSoat,2)){
            if(isDeleteVehicle(bienKiemSoat)){
                xeOtoService.deleteVehicle(bienKiemSoat);
                System.out.println("Xe mang BKS ="+bienKiemSoat+" đã được xóa!");
            }else {
                System.out.println("Không xóa thì thôi");
            }
        }else {
            System.out.println("Xe mang BKS ="+bienKiemSoat+" không tồn tại!");
        }
    }
    public void deleteXeMay(){
        System.out.println("Nhập biển kiểm soát cần xóa");
        String bienKiemSoat = scanner.nextLine();
        if(isExist(bienKiemSoat,3)){
            if(isDeleteVehicle(bienKiemSoat)){
                xeMayService.deleteVehicle(bienKiemSoat);
                System.out.println("Xe mang BKS ="+bienKiemSoat+" đã được xóa!");
            }else {
                System.out.println("Không xóa thì thôi");
            }
        }else {
            System.out.println("Xe mang BKS ="+bienKiemSoat+" không tồn tại!");
        }
    }
}
