package Product;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GiaoDien {
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        
        Scanner sc = new Scanner(System.in);
        KhoHang kh = new KhoHang();
        int luaChon;
        
        do{
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Xoa san pham theo ID");
            System.out.println("4. Ghi danh sach vao file");
            System.out.println("5. Doc danh sach tu file");
            System.out.println("6. Tim san pham theo ID");
            System.out.println("7. Tao hoa don"); 
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            
            try {
                luaChon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                luaChon = -1;
            }
            
            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ID: ");
                    String id_SP = sc.nextLine();
                    System.out.print("Nhap ten san pham: ");
                    String tenSP = sc.nextLine();
                    
                    try 
                    {
                        System.out.print("Nhap gia: ");
                        long giaSP = Long.parseLong(sc.nextLine());
                        System.out.print("Nhap so luong: ");
                        int sl_SP = Integer.parseInt(sc.nextLine());
                        
                        kh.Add_SP(new SanPham(id_SP, tenSP, giaSP, sl_SP));
                        System.out.println("Them san pham thanh cong!");
                    } catch (Exception e) {
                        System.out.println("Loi: Gia hoac so luong khong hop le.");
                    }
                    break;
                    
                case 2:
                    kh.print_SP();
                    break;
                    
                case 3:
                    System.out.print("Nhap ID san pham can xoa: ");
                    String deleteID = sc.nextLine();
                    
                    boolean success = kh.delete_SP(deleteID);
                    
                    if (success) {
                        System.out.println("Da xoa san pham co ID: " + deleteID);
                        kh.write_SP();
                    } 
                    else {
                        System.out.println("Khong tim thay san pham voi ID: " + deleteID);
                    }
                    break;
                    
                case 4:
                    kh.write_SP();
                    break;
                    
                case 5: 
                    kh.read_SP();
                    break;
                    
                case 6:
                    System.out.print("Nhap ID can tim: ");
                    String findID01 = sc.nextLine();
                    SanPham spTim = kh.findByID(findID01);
                    
                    if (spTim != null) {
                        System.out.println("Tim thay san pham:");
                        System.out.println(spTim.toString());
                    } 
                    else {
                        System.out.println("Khong tim thay san pham co ID: " + findID01);
                    }
                    break;
                    
                case 7:
                    System.out.print("Nhap ten khach hang: ");
                    String tenKhach = sc.nextLine();

                    ArrayList<SanPham> gioHang = new ArrayList<>();
                    ArrayList<Integer> soLuongTrongGio = new ArrayList<>();

                    long tongTien = 0;

                    while (true) {
                        System.out.print("\nNhap ID san pham de mua (nhap '0' de thanh toan): ");
                        String idMua = sc.nextLine();
                        if (idMua.equals("0")) break;

                        SanPham spTimDuoc = kh.findByID(idMua);
                        if (spTimDuoc == null) {
                            System.out.println("Loi: Khong tim thay san pham voi ID nay.");
                            continue;
                        }
                        System.out.println("Da tim thay: " + spTimDuoc.getTenSP() 

                                         + " | Gia: " + formatter.format(spTimDuoc.getGiaSP()) 

                                         + " | Ton kho: " + spTimDuoc.getSluongSP());

                        int soLuongMua;
                        try {
                            System.out.print("Nhap so luong can mua: ");
                            soLuongMua = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("Loi: So luong khong hop le.");
                            continue;
                        }
                        if (soLuongMua <= 0) {
                            System.out.println("Loi: So luong phai la so duong.");
                            continue;
                        }
                        if (soLuongMua > spTimDuoc.getSluongSP()) {
                            System.out.println("Loi: Khong du ton kho. Chi con " + spTimDuoc.getSluongSP());
                            continue;
                        }
                        gioHang.add(spTimDuoc);
                        soLuongTrongGio.add(soLuongMua);
                        tongTien += (spTimDuoc.getGiaSP() * soLuongMua);
                        System.out.println(" Da them vao gio.");
                    }
                    if (gioHang.isEmpty()) {
                        System.out.println("Giao dich da duoc huy [khong co san pham].");
                    } else {
                        kh.taoHoaDon(tenKhach, gioHang, soLuongTrongGio, tongTien);
                    }
                    break;
                    
                default:
                    System.out.println("Lua chon khong hop le! Vui long nhap tu 0 den 7.");
            }
        }while(luaChon != 0);
        sc.close();     
    }
}