package SanPham;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PrintWriter_SanPham {

    /**
     * Ghi một danh sách sản phẩm (ArrayList) ra file
     * @param Filename Đường dẫn đầy đủ của file để ghi (ví dụ: "E:\\data.txt")
     * @param ds Danh sách sản phẩm (cha và con) để ghi
     */
    public void write_SP(String Filename, ArrayList<Father_SanPham> ds) {
        
        // 1. Sử dụng try-with-resources để tự động đóng file
        try (PrintWriter pw = new PrintWriter("E:\\SaveFileWord\\data.txt", "UTF-8")) {
            
            // 2. Duyệt qua từng sản phẩm trong danh sách
            for (Father_SanPham sp : ds) {
                
                // 3. Kiểm tra xem đó là "Con" hay "Cha"
                if (sp instanceof Son_SanPham) {
                    // Nếu là "Con", ép kiểu để lấy thông tin chi tiết
                    Son_SanPham con_SP = (Son_SanPham) sp;
                    
                    // Tạo dòng theo định dạng "CON"
                    String line = "CON," + con_SP.getId() + "," + con_SP.getTenSP() + "," + 
                                  con_SP.getGiaSP() + "," + con_SP.getSluong() + "," + 
                                  con_SP.getMaker() + "," + con_SP.getCPU() + "," + 
                                  con_SP.getRAM() + "," + con_SP.getStorage() + "," + con_SP.getCardGraphic();
                    
                    pw.println(line); // Ghi dòng vào file
                    
                } else {
                    // Nếu chỉ là "Cha"
                    
                    // Tạo dòng theo định dạng "CHA" (Đã sửa lỗi khoảng trắng)
                    String line = "CHA," + sp.getId() + "," + sp.getTenSP() + "," + 
                                  sp.getGiaSP() + "," + sp.getSluong();
                                  
                    pw.println(line); // Ghi dòng vào file
                }
            }
            
            // 4. Dùng biến 'Filename'
            System.out.println("Da ghi file " + Filename + " thanh cong!");

        } 
        // 5. Bắt lỗi theo thứ tự: Cụ thể -> Chung
        catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Loi khi ghi file (duong dan hoac ma hoa UTF-8): " + e.getMessage());
        } catch (IOException e) {
            // Khối này đã 'reachable' (tới được) vì nó nằm sau các lỗi cụ thể hơn
            System.out.println("Da xay ra loi I/O khi ghi file: " + e.getMessage());
        }
    }
}