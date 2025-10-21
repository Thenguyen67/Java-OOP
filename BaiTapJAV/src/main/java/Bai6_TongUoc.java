import java.util.Scanner;
public class Bai6_TongUoc 
{
    public static void main(String[] args) 
    {
        System.out.print("Nhap gia tri : ");
        Scanner sc = new Scanner(System.in) ;
        int giaTri = sc.nextInt() ;
        
        int Tong = 0 ;
        for(int i = 1; i <= Math.sqrt(giaTri); ++i)
            if(giaTri % i == 0)
            {
                Tong+=i ;
                int j = giaTri/i ;
                if(i != j) Tong+=j ;
            }
        
        System.out.print(Tong) ;
        sc.close();
    }
}
