
import java.util.Objects;

public class Product {
    private final String id;
    private String name;
    private long cost;
    private int quantidy;

    public Product(String id, String name, long cost, int quantidy) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantidy = quantidy;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCost() {
        return cost;
    }

    public int getQuantidy() {
        return quantidy;
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty())
            this.name = name;
    }

    public void setCost(long cost) {
        if(cost > 0)
            this.cost = cost;
        else
            System.out.println("Gia khong the am !");
    }

    public void setQuantidy(int quantidy) {
        if(quantidy >= 0)
            this.quantidy = quantidy;
        else
            System.out.println("So luong san pham khong the am !");
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", cost=" + cost + ", quantidy=" + quantidy + '}';
    }
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        // Hai sản phẩm là một nếu có cùng ID
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
