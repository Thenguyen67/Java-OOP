
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputProduct ip = new InputProduct();
        ArrayList<Product> productList = ip.readProductLists();
        
        for(Product a : productList)
            System.out.println(a.toString());
        
        ip.close();
    }
}