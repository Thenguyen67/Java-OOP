import java.util.Scanner;
public class Bai5_TongNghichDao2 
{
    public static void main(String[] args) 
    {
        System.out.print("Nhap gia tri : ");
        Scanner sc = new Scanner(System.in);
        int giaTri = sc.nextInt() ;
        
        double Tong = 0 ;
        for(int i = 1; i <= giaTri; ++i)
            Tong+=1.0/(i*2) ;
        
        System.out.printf("%.5f", Tong);
        sc.close();
    }
}
