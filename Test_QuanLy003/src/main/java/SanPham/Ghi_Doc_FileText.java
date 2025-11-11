package SanPham;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ghi_Doc_FileText {
    private ArrayList<SanPham> ds = new ArrayList<>();
    private File file = new File("E:\\SaveFileWord\\SanPham.txt");

    public Ghi_Doc_FileText() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Khong tao duoc file");
        }
    }

    public void Add_SanPham(SanPham sp) {
        ds.add(sp);
    }

    public void print_SanPham() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }
        int i = 0;
        for (SanPham sp : ds) {
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
        } catch (Exception e) {
            System.out.println("Doc file that bai");
        }
    }
}
