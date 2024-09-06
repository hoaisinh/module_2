package controller;

import common.File;
import model.XeTai;
import service.XeTaiService;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private String bienKiemSoat,hangSanXuat,chuSoHuu;
    private int namSanXuat;
    public String type;
    private final Scanner scanner = new Scanner(System.in);
    private XeTaiService xeTaiService = new XeTaiService();
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
        List<XeTai> lists;
        if(type == 1){
           lists = xeTaiService.getAll();
            for(XeTai xeTai:lists){
                System.out.println(xeTai.toString());
            }
        } else if (type == 2) {
            System.out.println("Danh sách ô tô");
        } else if (type == 3) {
            System.out.println("Danh sách xe máy");
        }else {

        }
    }
    public void addXeTai(){
        inputData();
        System.out.println("Nhập trọng tải");
        int trongTai = Integer.parseInt(scanner.nextLine());
        XeTai xeTai = new XeTai(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,trongTai);
        xeTaiService.addXeTai(xeTai);
    }

    public  boolean isExist(String bienKiemSoat){
        XeTai xeTai = xeTaiService.findByBKS(bienKiemSoat);
        return  xeTai != null;

    }

    public void deleteXeTai(){
        System.out.println("Nhập biển kiểm soát cần xóa");
        String bienKiemSoat = scanner.nextLine();
        if(isExist(bienKiemSoat)){
            xeTaiService.deleteXeTai(bienKiemSoat);
            System.out.println("Xe mang BKS ="+bienKiemSoat+" đã được xóa!");
        }else {
            System.out.println("Xe mang BKS ="+bienKiemSoat+" không tồn tại!");
        }
    }

}
