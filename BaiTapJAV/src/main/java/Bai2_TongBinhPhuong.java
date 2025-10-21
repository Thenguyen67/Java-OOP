
import java.util.Scanner;


public class Bai2_TongBinhPhuong 
{
    public static void main(String[] args) 
    {
        System.out.print("Nhap gia tri : ");
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        
        int Tong = 0 ;
        for(int i = 1; i <= n; ++i) Tong+= Math.pow(i, 2) ;
        
        System.out.print(Tong);
        sc.close();
    }
}
