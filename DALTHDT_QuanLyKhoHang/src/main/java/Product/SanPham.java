package Product;

import java.text.NumberFormat;
import java.util.Locale;

public class SanPham {
    private String id_SP, tenSP;
    private long giaSP;
    private int sluongSP;

    public SanPham(String id_SP, String TtenSP, long giaSP, int sluongSP) {
        this.id_SP = id_SP;
        this.tenSP = TtenSP;
        this.giaSP = giaSP;
        this.sluongSP = sluongSP;
    }

    public String getId_SP() {
        return id_SP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public long getGiaSP() {
        return giaSP;
    }

    public int getSluongSP() {
        return sluongSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setGiaSP(long giaSP) {
        this.giaSP = giaSP;
    }

    public void setSluongSP(int sluongSP) {
        this.sluongSP = sluongSP;
    }
    
    public String toString(){
        NumberFormat nf = NumberFormat.getInstance(new Locale("vi, VN"));
        String cost_nf =nf.format(giaSP);
        return String.format("ID : %6s  | Ten  : %15s  | Gia  : %s  | so luong : %d",
                id_SP, tenSP, cost_nf, sluongSP);
    }
    
    public String toFileString(){
        return id_SP + ";" + tenSP + ";" + giaSP + ";" + sluongSP;
    }
}