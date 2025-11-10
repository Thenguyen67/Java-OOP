import java.util.ArrayList;
import java.util.Scanner;

public class InputProduct {
    private Scanner sc;

    public InputProduct() {
        this.sc = new Scanner(System.in);
    }
    public ArrayList<Product> readProductLists(){
        ArrayList<Product> List = new ArrayList<>();
        
        System.out.print("Nhap so luong cac san pham : ");
        int a = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < a; ++i){
            System.out.println("Moi nhap thong tin san pham ");
        
            System.out.print("ID san pham : ");
            String id = sc.nextLine();

            System.out.print("Ten san pham : ");
            String name = sc.nextLine();

            System.out.print("Gia san pham : ");
            long cost = sc.nextLong();

            System.out.print("So luong san pham : ");
            int quantidy = sc.nextInt();
            sc.nextLine();
            
            Product p = new Product(id, name, cost, quantidy);
            List.add(p);
        }
        return List;
    }
    
    public void close(){
        this.sc.close();
    }
}
