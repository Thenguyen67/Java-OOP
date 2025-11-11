package SanPham;

import java.util.Scanner;

public class Test_SanPham {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ghi_Doc_FileText a = new Ghi_Doc_FileText();
        int luaChon;
        
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Ghi danh sach vao file");
            System.out.println("4. Doc danh sach tu file");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            
            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhap ten san pham: ");
                    String ten = sc.nextLine();
                    System.out.print("Nhap gia: ");
                    long gia = sc.nextLong();
                    System.out.print("Nhap so luong: ");
                    int sl = sc.nextInt();
                    
                    a.Add_SanPham(new SanPham(id, ten, gia, sl));
                    break;
                    
                case 2:
                    a.print_SanPham();
                    break;
                    
                case 3:
                    a.write_SanPham();
                    break;
                    
                case 4:
                    a.read_SanPham();
                    break;
                    
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                    
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);
    }
}