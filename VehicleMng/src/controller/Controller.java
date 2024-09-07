package controller;

import common.File;
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
    public String chonHangSanXuat(){
        List<String> listHangXe = File.getHangSanXuat();
        int tempIndex;
        do{
            for (int i = 0; i < listHangXe.size() ; i++) {
                System.out.println(
                        i + " - "+ listHangXe.get(i)
                );
            }
             tempIndex = Integer.parseInt(scanner.nextLine());
            if(tempIndex > listHangXe.size()-1){
                System.out.println("Vui lòng chọn các sô có sẵn");
            }
        }while (tempIndex > listHangXe.size()-1);
        return listHangXe.get(tempIndex);
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
            tempIndex = Integer.parseInt(scanner.nextLine());
            if(tempIndex > listKieuXe.size()-1){
                System.out.println("Vui lòng chọn các sô có sẵn");
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
        namSanXuat = Integer.parseInt(scanner.nextLine());
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
        int trongTai = Integer.parseInt(scanner.nextLine());
        XeTai xeTai = new XeTai(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,trongTai);
        xeTaiService.addXeTai(xeTai);
    }
    public void addXeOto(){
        inputData();
        System.out.println("Nhập số chỗ ngồi");
        int soChoNgoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Chọn kiểu xe");
        String kieuXe = chonkieuXe();
        XeOto xeOto = new XeOto(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,soChoNgoi,kieuXe);
        xeOtoService.addXeOto(xeOto);
    }
    public void addXeMay(){
        inputData();
        System.out.println("Nhập công suất");
        int congSuat = Integer.parseInt(scanner.nextLine());
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
