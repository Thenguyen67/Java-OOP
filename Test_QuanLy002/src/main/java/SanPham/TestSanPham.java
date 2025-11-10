package SanPham;

import java.util.ArrayList;

/**
 * Đây là class chính để chạy chương trình (Main class).
 * Nơi điều phối tất cả các chức năng.
 * @author My Computer
 */
public class TestSanPham {

    public static void main(String[] args) {
        
        // 1. KHOI TAO
        // Khởi tạo các đối tượng quản lý
        Manager_SanPham qlsp = new Manager_SanPham(); // Quản lý danh sách (Thêm/Sửa/Xóa)
        PrintWriter_SanPham writer = new PrintWriter_SanPham();     // Quản lý GHI file
        BufferedReader_SanPham reader = new BufferedReader_SanPham(); // Quản lý ĐỌC file
        
        // Định nghĩa tên file MỘT LẦN ở đây để dễ dàng thay đổi
        String tenFile = "E:\\SaveFileWord\\SanPham_Data.txt";

        // -----------------------------------------------------------------
        // 2. NAP DU LIEU (LOAD)
        // -----------------------------------------------------------------
        System.out.println("--- KHOI DONG: Dang nap du lieu tu file... ---");
        // Gọi hàm đọc file
        ArrayList<Father_SanPham> dataFromFile = reader.read_SP(tenFile);
        // Nạp danh sách vừa đọc vào trong bộ quản lý
        qlsp.setDanhSachSP(dataFromFile);

        // 3. IN DANH SACH BAN DAU
        System.out.println("\n--- DANH SACH SAN PHAM HIEN TAI ---");
        qlsp.Print_SanPham();

        // -----------------------------------------------------------------
        // 4. THEM MOI SAN PHAM (Ví dụ)
        // -----------------------------------------------------------------
        System.out.println("\n--- THEM SAN PHAM MOI ---");
        
        // Thêm sản phẩm CHA (có kiểm tra trùng lặp)
        if (qlsp.Find_SanPham("P001") == null) {
            Father_SanPham sp1 = new Father_SanPham("P001", "Ao So Mi Trang", 350000, 50);
            qlsp.Add_SanPham(sp1);
        } else {
            System.out.println("San pham P001 da ton tai, khong them.");
        }
        
        // Thêm sản phẩm CON (có kiểm tra trùng lặp)
        if (qlsp.Find_SanPham("P002") == null) {
            // Lưu ý: Phải đúng thứ tự tham số của constructor Son_SanPham
            // (maker, CPU, giaSP, sluong, RAM, storage, cardGraphic, id, tenSP)
            Son_SanPham sp2 = new Son_SanPham("Dell", "Core i9", 30000000, 15, "32GB", "1TB SSD", "RTX 4060", "P002", "Laptop Gaming Dell");
            qlsp.Add_SanPham(sp2);
        } else {
            System.out.println("San pham P002 da ton tai, khong them.");
        }

        // -----------------------------------------------------------------
        // 5. SUA SAN PHAM (Ví dụ)
        // -----------------------------------------------------------------
        System.out.println("\n--- SUA SAN PHAM P001 ---");
        qlsp.Repair_SanPham("P001", "Ao So Mi DEN", 400000, 45); // Sửa P001
        
        // -----------------------------------------------------------------
        // 6. XOA SAN PHAM (Ví dụ)
        // -----------------------------------------------------------------
        System.out.println("\n--- XOA SAN PHAM P002 ---");
        qlsp.Delete_SanPham("P002"); // Xóa P002

        // 7. IN DANH SACH CUOI CUNG
        System.out.println("\n--- DANH SACH SAN PHAM SAU KHI THAY DOI ---");
        qlsp.Print_SanPham();

        // -----------------------------------------------------------------
        // 8. LUU LAI (SAVE)
        // -----------------------------------------------------------------
        System.out.println("\n--- LUU DANH SACH MOI VAO FILE ---");
        // Lấy danh sách MỚI NHẤT từ 'qlsp' và ghi vào file
        writer.write_SP(tenFile, qlsp.getListSP());
        
        System.out.println("\n--- CHUONG TRINH KET THUC ---");
    }
}