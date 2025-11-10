package SanPham;
import java.util.ArrayList;

public class Manager_SanPham{
    ArrayList<Father_SanPham> List_SanPham;

    public Manager_SanPham() {
        this.List_SanPham = new ArrayList<>();
    }
    
    public void Add_SanPham(Father_SanPham sp){
        this.List_SanPham.add(sp);
        System.out.println("Da them san pham !");
    }
    
    public Father_SanPham Find_SanPham(String id){
        for(Father_SanPham sp : this.List_SanPham){
            if(sp.getId().equals(id)){
                return sp;
            }
        }
        return null;
    }
    
    public boolean Delete_SanPham(String id){
        Father_SanPham sp = Find_SanPham(id);
        if(sp != null){
            this.List_SanPham.remove(sp);
            System.out.println("Da xoa san pham: " + sp.getTenSP());
            return true;
        }
        else{
            System.out.println("Khong tim thay san pham voi ID : " + id);
            return false;
        }
    }
    
    public boolean Repair_SanPham(String id, String nameSP, long giaSP, int sluong) {
        Father_SanPham sp = Find_SanPham(id);
        if (sp != null) {
            sp.setTenSP(nameSP);
            sp.setGiaSP(giaSP);
            sp.setSluong(sluong);
            System.out.println("Da cap nhat san pham : " + sp.getTenSP());
            return true;
        }
        return false;
    }
    
    public void Print_SanPham() {
        System.out.println("--- DANH SACH SAN PHAM ---");
        if (List_SanPham.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        for (Father_SanPham sp : this.List_SanPham) { // Nhờ tính đa hình, nó sẽ tự gọi toString() của Cha hoặc Con
            System.out.println(sp.toString());
        }
    }
    
    public ArrayList<Father_SanPham> getListSP() { // Getter để lấy danh sách (dùng cho việc ghi file)
        return this.List_SanPham;
    }

    public void setDanhSachSP(ArrayList<Father_SanPham> newListSP) { // Setter để nạp danh sách (dùng khi đọc file)
        this.List_SanPham = newListSP;
    }
}
