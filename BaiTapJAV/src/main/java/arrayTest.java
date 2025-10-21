
import java.util.Scanner;

public class arrayTest 
{
    public static void main(String[] args) 
    {
        System.out.print("Nhap so luong phan tu mang : ");
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int[] a = new int[n] ;
        System.out.println();
        
        System.out.println("Nhap vao phan tu cua mang : ");
        for(int i = 0; i < n; ++i)
        {
            System.out.print("a["+i+"]= ");
            a[i] = sc.nextInt() ;
        }
        System.out.println();
        
        for(int i = 0; i < n; ++i) System.out.print(a[i]+ " ");
    }
}
