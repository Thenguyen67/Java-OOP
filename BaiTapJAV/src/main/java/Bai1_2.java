
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author My Computer
 */
public class Bai1_2 {
    public static void main(String[] args) {
        System.out.print("Nhap n : ");
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        
        for(int i = 0; i <= n; ++i)
            if(i % 2 != 0)System.out.print(i + " ");
    }
}
