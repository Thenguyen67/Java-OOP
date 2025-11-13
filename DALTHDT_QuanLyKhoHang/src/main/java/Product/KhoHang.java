package Product;

import java.io.File;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class KhoHang {
    private ArrayList<SanPham> ds = new ArrayList<>(); //Tạo một mảng ĐỘNG kiểu sản phẩm(phần tử sẽ bao gồm tất cả các thuộc tính của sản phẩm)
    private File new_File = new File("E:\\SaveFileWord\\SanPham.txt"); //Tạo một biến kiểu File để gán địa chỉ file text muốn đọc/ghi file text
    
    //Hàm tìm kiếm sản phẩm có ID giống với ID nhập vào
    public SanPham findByID(String id_SP){ 
        if(ds.isEmpty()){ //Kiểm tra liệu danh sách có phần tử nào không
            return null; 
        }
        for(SanPham sp : ds){ //Nếu danh sách có phần tử, thực hiện range for loop
            if(sp.getId_SP().equals(id_SP)){ //Duyệt qua các phần tử trong danh sách, xét xem ID của phần tử có bằng ID yêu cầu hay không
                return sp; 
            }
        }
        return null; // Nếu duyệt hết danh sách mà không có phần tử nào, trả về null
    }
    
    //Chỉnh 
    public boolean updateSluong(String id_SP, int sold_SP){
        SanPham sp = findByID(id_SP);
        if(sp == null){
            System.out.println("Loi ! Khong tim thay san pham trung voi ID");
            return false;
        }
        if(sp.getSluongSP() < sold_SP){
            System.out.println("Khong co du so luong");
            return false;
        }
        sp.setSluongSP(sp.getSluongSP() - sold_SP);
        return true;
    }
    
    //Hàm thêm sản phẩm vào danh sách. Nếu sản phẩm đã tồn tại từ trước, TĂNG số lượng
    public void Add_SP(SanPham new_SP){
        SanPham old_SP = findByID(new_SP.getId_SP()); //Kiểm tra ID sản phẩm thêm vào thông qua hàm findByID, nếu đã tồn tại thì gán vào old_SP
        if(old_SP != null){ 
            int newSluong = old_SP.getSluongSP() + new_SP.getSluongSP(); //Tính tổng số lượng của sản phẩm cũ đã có trong kho và sản phẩm vừa thêm 
            old_SP.setSluongSP(newSluong); //Sau khi tính tổng, dùng phương thức set để thay đổi giá trị của sản phẩm
            System.out.println("Da cap nhat so luong moi cho san pham : " + old_SP.getTenSP());
            //Note : Khi findByID gán vào old_SP, nó gán cả địa chỉ. Vậy nên cũng sẽ cập nhật lại số lượng trong ArrayList
        }
        else
            ds.add(new_SP); //Nếu chưa tồn tại, thêm sản phẩm mới vào ArrayList
        System.out.println("Da them san pham" + new_SP.getId_SP() + "vao kho !");
    }
    
    //Hàm in danh sách(Chỉ in trên output)
    public void print_SP(){
        if(ds.isEmpty()){ //Kiểm tra danh sách có rỗng hay không
            System.out.println("Danh sach rong !");
        }
        else{
            int i = 0;
            for(SanPham sp : ds){ //In ra danh sách
                ++i;
                System.out.println("STT" + i + sp.toString());
            }
        }
    }
    
    //Hàm xóa sản phẩm thông qua ID
    public boolean delete_SP(String id_SP){
        SanPham needDelete = findByID(id_SP);
        
        if(needDelete != null){
            ds.remove(needDelete); //Xóa sản phẩm trong ArrayList bằng phương thức remove của thư viện ArrayList 
            System.out.println("Da xoa san pham hoi danh sach !");
            return true;
        }
        else{
            System.out.println("Khong tim thay san pham !");
            return false;
        }
    }
    
    
    //Hàm đọc dữ liệu từ file text
    public void read_SP(){
        ds.clear(); //Dọn phần tử còn nằm trong ArrayList để tránh in trùng lặp
        try (Scanner sc = new Scanner(new_File)){  // "new Scanner cho biết đọc file ở đâu. Ở đây là đọc từ new_file (có địa chỉ đến SanPham.txt
            while(sc.hasNextLine()){ //hasNextLine dùng để check liệu dòng tiếp theo còn văn bản hay không  
                String readedLine = sc.nextLine(); //Sau khi check , lưu dòng đã đọc vào biến chuỗi 
                String[] arr = readedLine.split(";"); //Tách chuỗi thành các chuỗi nhỏ mỗi khi gặp ";" và gán vào mảng arr
                SanPham sp = new SanPham(arr[0], arr[1], Long.parseLong(arr[2]), Integer.parseInt(arr[3])); // Gán các chuỗi trong arr vào constructor SanPham
                ds.add(sp); //Thêm sản phẩm vào ds
            }
                System.out.println("Doc file thanh cong !");
        } catch (Exception e) {
            System.out.println("Doc file that bai !");
        }
    }
    
    //Hàm viết file 
    public void write_SP(){ 
        try(PrintWriter pw = new PrintWriter(new_File)){ //Tạo biến ghi file 
            for(SanPham sp : ds){
                pw.print(sp.toFileString()); //Viết vào file các phần tử trong sp đã chỉnh kiểu theo toFileString
            }
            System.out.println("Ghi file thanh cong ");
        } catch (Exception e) {
            System.out.println("Ghi file that bai ");
        }
    }
    
    //Hàm tìm ID 
    public SanPham findByID_SP(String id_SP){
        if(ds.isEmpty()){
            return null;
        }
        for(SanPham sp : ds){
            if(sp.getId_SP().equals(id_SP))
                return sp;
        }
        return null;
    }
    
    public void taoHoaDon(String tenKhach, ArrayList<SanPham> gioHang, ArrayList<Integer> soLuongTrongGio, long tongTien) {
        
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String tenKhachAnToan = tenKhach.replaceAll("\\s+", "_");
        String tenFile = "HoaDon_" + tenKhachAnToan + "_" + timestamp + ".txt";

        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));

        try (PrintWriter pw = new PrintWriter(new File(tenFile))) {
            
            System.out.println("\n\n===== HOA DON THANH TOAN =====");
            String khach = "Khach hang: " + tenKhach;
            String ngay = "Ngay: " + LocalDate.now();
            String gachNgang = "---------------------------------------------------------------";
            String tieuDe = String.format("%-20s | %-5s | %-15s | %-15s", "Ten San Pham", "SL", "Don Gia", "Thanh Tien");
            
            System.out.println(khach);
            System.out.println(ngay);
            System.out.println(gachNgang);
            System.out.println(tieuDe);
            System.out.println(gachNgang);

            pw.println("===== HOA DON THANH TOAN =====");
            pw.println(khach);
            pw.println(ngay);
            pw.println(gachNgang);
            pw.println(tieuDe);
            pw.println(gachNgang);

            for (int i = 0; i < gioHang.size(); i++) {
                SanPham sp = gioHang.get(i);
                int sl = soLuongTrongGio.get(i);
                long thanhTien = sp.getGiaSP() * sl;

                String dong = String.format("%-20s | %-5d | %-15s | %-15s",
                        sp.getTenSP(),
                        sl,
                        formatter.format(sp.getGiaSP()),
                        formatter.format(thanhTien));

                System.out.println(dong); 
                pw.println(dong);         

                this.updateSluong(sp.getId_SP(), sl);
            }

            System.out.println(gachNgang);
            pw.println(gachNgang);

            String tongCong = String.format("TONG CONG: %s VND", formatter.format(tongTien));
            System.out.println(tongCong);
            pw.println(tongCong);

            String gachKet = "===============================================================";
            System.out.println(gachKet);
            pw.println(gachKet);

            System.out.println("=> Da luu hoa don thanh cong vao file: " + tenFile);

        } catch (Exception e) {
            System.out.println("=> LOI: Khong the ghi hoa don ra file: " + e.getMessage());
        }

        this.write_SP();
        System.out.println("=> Da cap nhat lai so luong ton kho. Cam on quy khach!");
    }
}