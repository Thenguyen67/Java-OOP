package SanPham;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; // Cần import
import java.io.FileNotFoundException; // Cần import
import java.util.ArrayList;

/**
 * Class này chịu trách nhiệm ĐỌC file "SanPham_Data.txt"
 * và chuyển đổi dữ liệu thành một ArrayList<Father_SanPham>.
 */
public class BufferedReader_SanPham {

    /**
     * Đọc file dữ liệu sản phẩm.
     * @param Filename Đường dẫn đầy đủ của file để đọc.
     * @return Một ArrayList<Father_SanPham> chứa tất cả sản phẩm đọc được.
     */
    public ArrayList<Father_SanPham> read_SP(String Filename) {
        
        // 1. Tạo một danh sách rỗng để chứa kết quả
        ArrayList<Father_SanPham> list = new ArrayList<>();
        
        // 2. Sử dụng try-with-resources để tự động đóng file
        try (BufferedReader br = new BufferedReader(new FileReader(Filename))) {
            
            String line;
            // 3. Đọc từng dòng trong file cho đến khi hết (line == null)
            while ((line = br.readLine()) != null) {
                
                // Tách dữ liệu bằng dấu phẩy (định dạng CSV)
                String[] parts = line.split(",");
                
                // Bỏ qua nếu dòng bị lỗi, không đủ dữ liệu cơ bản
                if (parts.length < 5) continue; 
                
                // 4. Lấy các thông tin chung
                String type = parts[0];
                String id = parts[1];
                String ten = parts[2];
                long gia = Long.parseLong(parts[3]); // Chuyển String sang long
                int sluong = Integer.parseInt(parts[4]); // Chuyển String sang int
                
                // 5. Kiểm tra xem đây là "CON" hay "CHA"
                if (type.equals("CON") && parts.length == 10) {
                    // Nếu là "CON" và có đủ 10 cột dữ liệu
                    String maker = parts[5];
                    String cpu = parts[6];
                    String ram = parts[7];
                    String storage = parts[8];
                    String card = parts[9];
                    
                    // Tạo đối tượng Son_SanPham (phải đúng thứ tự constructor)
                    // (maker, CPU, giaSP, sluong, RAM, storage, cardGraphic, id, tenSP)
                    Son_SanPham con_SP = new Son_SanPham(maker, cpu, gia, sluong, ram, storage, card, id, ten);
                    list.add(con_SP); // Thêm vào danh sách
                    
                } else if (type.equals("CHA")) {
                    // Nếu là "CHA"
                    Father_SanPham cha_SP = new Father_SanPham(id, ten, gia, sluong);
                    list.add(cha_SP); // Thêm vào danh sách
                }
            }
        } catch (FileNotFoundException e) {
            // Lỗi này là BÌNH THƯỜNG nếu bạn chạy lần đầu tiên và file chưa tồn tại
            System.out.println("Loi khi doc file: Khong tim thay file. Mot file moi se duoc tao khi ket thuc.");
        } catch (IOException e) {
            // Lỗi I/O khác (ví dụ: không có quyền đọc)
            System.out.println("Loi I/O khi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Lỗi nếu "gia" hoặc "sluong" trong file không phải là số
            System.out.println("Loi dinh dang so trong file: " + e.getMessage());
        }
        
        System.out.println("Da doc file, nap " + list.size() + " san pham.");
        // 6. Trả về danh sách (có thể rỗng nếu file không tồn tại)
        return list;
    }
}