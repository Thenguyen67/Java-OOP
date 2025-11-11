package SanPham;

import java.text.NumberFormat;
import java.util.Locale;

public class SanPham 
{
    private String id_SP, tenSP;
    private long giaSP;
    private int sl_SP;

    public SanPham(String id_SP, String tenSP, long giaSP, int sl_SP) {
        this.id_SP = id_SP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.sl_SP = sl_SP;
    }

    public String getId_SP(){return id_SP;}
    public String getTenSP(){return tenSP;}
    public long getGiaSP() {return giaSP;}
    public int getSl_SP() {return sl_SP;}

    public void setId_SP(String id_SP){
        if(!id_SP.isEmpty())
            this.id_SP = id_SP;
    }

    public void setTenSP(String tenSP){
        if(!tenSP.isEmpty())
            this.tenSP = tenSP;
    }

    public void setGiaSP(long giaSP){
        if(giaSP >= 0)
            this.giaSP = giaSP;
    }

    public void setSl_SP(int sl_SP) {
        if(sl_SP >= 0)
            this.sl_SP = sl_SP;
    }

    @Override
    public String toString() {
        // Định dạng số cho đẹp, ví dụ: 30,000,000
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        String giaFormatted = formatter.format(giaSP);
        
        // Dùng String.format để căn lề cho đẹp
        return String.format("ID: %-7s | Tên: %-20s | Giá: %15s VNĐ | Số lượng: %d",
                             id_SP, tenSP, giaFormatted, sl_SP);
    }

    public String toFileString(){
        return id_SP + ";" + tenSP + ";" + giaSP + ";" + sl_SP;
    }
}