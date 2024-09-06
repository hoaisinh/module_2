package model;

public class XeOto extends Vehicle{
    private int soChoNgoi;
    private String kieuXe;

    public XeOto(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "XeOto{" +
                super.toString()+
                "soChoNgoi=" + soChoNgoi +
                ", kieuXe='" + kieuXe + '\'' +
                '}';
    }

    @Override
    public String dataToString() {
        return super.dataToString()+","+kieuXe+","+soChoNgoi;
    }
}
