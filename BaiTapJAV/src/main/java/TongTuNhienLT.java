import java.util.Scanner;
public class TongTuNhienLT 
{
    public static void main(String[] args) 
    {
        System.out.print("Nhap gia tri : ");
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int Tong = 0 ;
        for(int i = 1; i <= n; ++i) Tong+=i ;
        
        System.out.println("Tong bang For : " + Tong);
        System.out.println("Tong bang cong thuc : " + n*(n+1)/2);
        sc.close();
    }
}
