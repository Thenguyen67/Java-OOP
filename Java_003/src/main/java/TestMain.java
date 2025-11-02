/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class TestMain {
    public static void main(String[] args) {
        MyDate md = new MyDate(29, 10, 2025);
        System.out.println("Day : " + md.getDay());
        
        md.setDay(30);
        System.out.println("Day : " + md.getDay());
        
        md.setDay(70);
        System.out.println("Day : " + md.getDay());
    }
}
