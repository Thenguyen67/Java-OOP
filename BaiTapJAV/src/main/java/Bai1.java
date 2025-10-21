
import java.util.Scanner;
public class Bai1 {
    public static void main(String[] args) {
        System.out.print("Nhap n : ") ;
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        
        for(int i = 1; i <= n; ++i) System.out.print(i + " ");
        
        System.out.println();
        
        for(int i = n; i > 0; --i)System.out.print(i + " ");
        
        System.out.println();
        
        int j = 0 ;
        while(j < n){
            if(j % 2 == 0) System.out.print(j + " ");
            j++ ;
	}
    }                   
}
    