
import java.util.Scanner;


public class Bai4_TongNghichDao 
{
    public static void main(String[] args) 
    {
        System.out.print("Nhap gia tri : ");
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        
        float Tong = 0f ;
        for(int i = 1; i <= n; ++i)
            Tong+=1/(i*1.0) ; 
        
        System.out.print(Tong);
        sc.close();
    }
}
