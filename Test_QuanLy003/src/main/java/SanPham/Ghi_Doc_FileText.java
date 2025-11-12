package SanPham;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ghi_Doc_FileText 
{
    private ArrayList<SanPham> ds = new ArrayList<>();
    private File file = new File("E:\\SaveFileWord\\SanPham.txt");

    public Ghi_Doc_FileText() 
    {
        try 
        {
            file.createNewFile();
        } 
        catch (IOException e) 
        {
            System.out.println("Khong tao duoc file");
        }
    }

    public void Add_SanPham(SanPham sp) {
        ds.add(sp);
    }

    public void print_SanPham() 
    {
        if (ds.isEmpty()) 
        {
            System.out.println("Danh sach rong");
            return;
        }
        int i = 0;
        for (SanPham sp : ds) 
        {
            ++i;
            System.out.println("STT " + i + " " + sp.toString());
        }
    }

    public void write_SanPham() 
    {
        try (PrintWriter pw = new PrintWriter(file)) 
        {
            for (SanPham sp : ds) 
            {
                pw.println(sp.toFileString());
            }
            System.out.println("Ghi file thanh cong");
        } 
        catch (Exception e) 
        {
            System.out.println("Ghi file that bai");
        }
    }

    public void read_SanPham() 
    {
        ds.clear();
        try (Scanner sc = new Scanner(file)) 
        {
            while (sc.hasNextLine()) 
            {
                String dong = sc.nextLine();
                String[] arr = dong.split(";");
                SanPham sp = new SanPham(arr[0], arr[1], Long.parseLong(arr[2]), Integer.parseInt(arr[3]));
                ds.add(sp);
            }
            System.out.println("Doc file thanh cong");
        } 
        catch (Exception e) 
        {
            System.out.println("Doc file that bai");
        }
    }
    
    public SanPham find_SanPham_ByID(String maSP) {
        if (ds.isEmpty()) {
            return null; // Danh sach rong
        }
        for (SanPham sp : ds) {
            if (sp.getId_SP().equals(maSP)) {
                return sp; // Tra ve san pham ngay khi tim thay
            }
        }
        return null; // Khong tim thay san pham nao khop
    }
    
    public ArrayList<SanPham> find_SanPham_ByPrice(long gia) {
        ArrayList<SanPham> ketQua = new ArrayList<>();
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong, khong the tim kiem.");
            return ketQua; 
        }
        for (SanPham sp : ds) {
            if (sp.getGiaSP() == gia) {
                ketQua.add(sp);
            }
        }
        return ketQua;
    }
    
    public boolean giamSoLuongTrongKho(String maSP, int soLuongDaBan) {
        // Tim san pham trong danh sach 'ds'
        SanPham sp = find_SanPham_ByID(maSP);
        
        if (sp == null) {
            System.out.println("Loi (giamSoLuong): Khong the tim thay SP voi ID " + maSP);
            return false;
        }
        
        if (sp.getSl_SP() < soLuongDaBan) {
            System.out.println("Loi (giamSoLuong): Khong du ton kho cho " + sp.getTenSP());
            return false;
        }
        
        // Giam so luong
        sp.setSl_SP(sp.getSl_SP() - soLuongDaBan);
        return true;
    }
}
