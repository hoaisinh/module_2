package controller;

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

    public void inputData(){
        System.out.println("Nhập Biển Kiểm Soát");
        bienKiemSoat =scanner.nextLine();
        System.out.println("Chọn hãng sản xuất");
        hangSanXuat = "";
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


}
