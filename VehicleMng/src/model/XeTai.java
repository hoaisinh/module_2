package model;

public class XeTai extends Vehicle{
    private int trongTai;

    public XeTai(String bienKiemSoat, String hangSanXuat, int namSanXuat, String chuSoHuu, int trongTai) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "xeTai{" +
                super.toString() +
                ",trongTai=" + trongTai +
                '}';
    }

    @Override
    public String dataToString() {
        return super.dataToString()+","+trongTai;
    }
}
