package SanPham;

public class SanPham {
    private String id_SP, tenSP;
    private long giaSP;
    private int sl_SP;

    public SanPham(String id_SP, String tenSP, long giaSP, int sl_SP) {
        this.id_SP = id_SP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.sl_SP = sl_SP;
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

    public int getSl_SP() {
        return sl_SP;
    }

    public void setId_SP(String id_SP) {
        this.id_SP = id_SP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setGiaSP(long giaSP) {
        this.giaSP = giaSP;
    }

    public void setSl_SP(int sl_SP) {
        this.sl_SP = sl_SP;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id_SP=" + id_SP + ", tenSP=" + tenSP + ", giaSP=" + giaSP + ", sl_SP=" + sl_SP + '}';
    }
}