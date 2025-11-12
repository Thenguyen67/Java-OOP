package SanPham;

import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Test_SanPham {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Ghi_Doc_FileText a = new Ghi_Doc_FileText();
        int luaChon;
        
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Ghi danh sach vao file");
            System.out.println("4. Doc danh sach tu file");
            System.out.println("5. Tim san pham theo ID");
            System.out.println("6. Tim san pham theo Gia");
            System.out.println("7. Ban hang (Tao hoa don)");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            
            // SUA LOI SCANNER 
            try {
                luaChon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                luaChon = -1; // Gan la gia tri khong hop le de thong bao loi
            }
            
            switch (luaChon) 
            {
                case 1:
                    System.out.print("Nhap ID: ");
                    String id_SP = sc.nextLine();
                    System.out.print("Nhap ten san pham: ");
                    String tenSP = sc.nextLine();
                    
                    // SUA LOI SCANNER (nextLong/nextInt)
                    try {
                        System.out.print("Nhap gia: ");
                        long giaSP = Long.parseLong(sc.nextLine());
                        System.out.print("Nhap so luong: ");
                        int sl_SP = Integer.parseInt(sc.nextLine());
                        
                        a.Add_SanPham(new SanPham(id_SP, tenSP, giaSP, sl_SP));
                        System.out.println("Them san pham thanh cong!");
                        
                    } catch (Exception e) {
                        System.out.println("Loi: Gia hoac so luong khong hop le.");
                    }
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
                    
                case 5:
                    System.out.print("Nhap ID can tim: ");
                    String idTim = sc.nextLine();
                    SanPham spTim = a.find_SanPham_ByID(idTim);
                    
                    if (spTim != null) {
                        System.out.println("Tim thay san pham:");
                        System.out.println(spTim.toString());
                    } else {
                        System.out.println("Khong tim thay san pham co ID: " + idTim);
                    }
                    break;
                    
                case 6:
                    try {
                        System.out.print("Nhap gia can tim: ");
                        long giaTim = Long.parseLong(sc.nextLine());
                        ArrayList<SanPham> dsKetQua = a.find_SanPham_ByPrice(giaTim);
                        
                        if (dsKetQua.isEmpty()) {
                            System.out.println("Khong tim thay san pham nao co gia " + giaTim);
                        } else {
                            // Bien 'formatter' bay gio da ton tai va chay dung
                            System.out.println("Cac san pham co gia " + formatter.format(giaTim) + ":");
                            for (SanPham sp : dsKetQua) {
                                System.out.println(sp.toString());
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Gia nhap vao khong hop le.");
                    }
                    break;

                case 7:
                    System.out.print("Nhap ten khach hang: ");
                    String tenKhach = sc.nextLine();
                    
                    ArrayList<SanPham> gioHang = new ArrayList<>();
                    ArrayList<Integer> soLuongTrongGio = new ArrayList<>();
                    long tongTien = 0;
                    
                    String idMua;
                    do {
                        System.out.print("\nNhap ID san pham de mua (nhap '0' de thanh toan): ");
                        idMua = sc.nextLine();
                        
                        if (idMua.equals("0")) {
                            break; 
                        }
                        
                        SanPham spTimDuoc = a.find_SanPham_ByID(idMua);
                        
                        if (spTimDuoc == null) {
                            System.out.println("Loi: Khong tim thay san pham voi ID nay.");
                            continue;
                        }
                        
                        // Bien 'formatter' bay gio da ton tai va chay dung
                        System.out.println("Da tim thay: " + spTimDuoc.getTenSP() 
                                         + " | Gia: " + formatter.format(spTimDuoc.getGiaSP()) 
                                         + " | Ton kho: " + spTimDuoc.getSl_SP());
                        
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
                        
                        if (soLuongMua > spTimDuoc.getSl_SP()) {
                            System.out.println("Loi: Khong du ton kho. Chi con " + spTimDuoc.getSl_SP());
                            continue;
                        }
                        
                        gioHang.add(spTimDuoc);
                        soLuongTrongGio.add(soLuongMua);
                        long thanhTienSP = spTimDuoc.getGiaSP() * soLuongMua;
                        tongTien += thanhTienSP;
                        
                        System.out.println("=> Da them " + soLuongMua + " x " + spTimDuoc.getTenSP() + " vao gio hang.");
                        System.out.println("   Tong tam tinh: " + formatter.format(tongTien) + " VND");
                        
                    } while (true); 
                    
                    if (gioHang.isEmpty()) {
                        System.out.println("Giao dich da duoc huy (khong co san pham).");
                    } else {
                        System.out.println("\n\n===== HOA DON THANH TOAN =====");
                        System.out.println("Khach hang: " + tenKhach);
                        System.out.println("Ngay: " + LocalDate.now());
                        System.out.println("---------------------------------------------------------------");
                        System.out.printf("%-20s | %-5s | %-15s | %-15s\n", "Ten San Pham", "SL", "Don Gia", "Thanh Tien");
                        System.out.println("---------------------------------------------------------------");

                        for (int i = 0; i < gioHang.size(); i++) {
                            SanPham sp = gioHang.get(i);
                            int sl = soLuongTrongGio.get(i);
                            long thanhTien = sp.getGiaSP() * sl;
                            
                            // Bien 'formatter' bay gio da ton tai va chay dung
                            System.out.printf("%-20s | %-5d | %-15s | %-15s\n",
                                    sp.getTenSP(),
                                    sl,
                                    formatter.format(sp.getGiaSP()),
                                    formatter.format(thanhTien));
                            
                            a.giamSoLuongTrongKho(sp.getId_SP(), sl);
                        }
                        
                        System.out.println("---------------------------------------------------------------");
                        System.out.printf("TONG CONG: %s VND\n", formatter.format(tongTien));
                        System.out.println("===============================================================");
                        
                        a.write_SanPham();
                        System.out.println("=> Da cap nhat lai so luong ton kho. Cam on quy khach!");
                    }
                    break;
                    
                case 0: 
                    System.out.println("Thoat chuong trinh.");
                    break;
                    
                default: 
                    // Thong bao loi ro rang hon
                    System.out.println("Lua chon khong hop le! Vui long nhap tu 0 den 7.");
            }
        } while (luaChon != 0);
        sc.close();
    }
}
