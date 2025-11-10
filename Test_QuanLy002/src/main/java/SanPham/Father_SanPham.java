package SanPham;

public class Father_SanPham {
    private final String id;
    private String tenSP;
    private long giaSP;
    private int sluong;

    public Father_SanPham(String id, String tenSP, long giaSP, int sluong) {
        this.id = id;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.sluong = sluong;
    }

    public String getId() {return id;}
    public String getTenSP() {return tenSP;}
    public long getGiaSP() {return giaSP;}
    public int getSluong() {return sluong;}

    public void setTenSP(String tenSP) {
        if(tenSP != null && !tenSP.trim().isEmpty())
            this.tenSP = tenSP;
    }

    public void setGiaSP(long giaSP) {
        if(giaSP >= 0)
            this.giaSP = giaSP;
        else
            System.out.println("Gia san pham khong duoc am !");
    }

    public void setSluong(int sluong) {
        if(sluong >= 0)
            this.sluong = sluong;
        else
            System.out.println("So luong cua san pham khong duoc am");
    }

    @Override
    public String toString() {
        return "Father_SanPham{" +
                "id=" + id +
                ", tenSP=" + tenSP +
                ", giaSP=" + giaSP +
                ", sluong=" + sluong +
                '}';
    }
}
