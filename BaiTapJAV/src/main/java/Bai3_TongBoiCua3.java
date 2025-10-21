import java.util.Scanner;
public class Bai3_TongBoiCua3 
{
    public static void main(String[] args)
    {
        System.out.print("Nhap gia tri : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if(n <= 0) System.exit(0);
        int Tong = 0 ;
        for(int i = 1; i <= n; ++i)
            if(i % 3 == 0) Tong+=i ;
        
        System.out.print(Tong);
    }
}
