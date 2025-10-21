import java.util.Scanner;
public class nghiLuc3 
{
    public static void main(String[] args) 
    {
        int a = 100 , b = 200 ;
        System.out.println("Gia tri cua bien la : " + a + " " + b) ;
        Scanner c = new Scanner(System.in) ;
        int d = c.nextInt() ;
        System.out.println(d);
        char kiTu = c.nextLine().charAt(0) ;
        c.close();
    }
}
