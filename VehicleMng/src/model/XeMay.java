package model;

public class XeMay extends Vehicle{
    private int congSuat;

    public XeMay(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMay{" +
                super.toString()+
                "congSuat=" + congSuat +
                '}';
    }

    @Override
    public String dataToString() {
        return super.dataToString()+","+congSuat;
    }
}
