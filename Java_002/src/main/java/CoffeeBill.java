
public class CoffeeBill 
{
    private String nameCoffee;
    private double moneyValue, getMass;
    
    public CoffeeBill(String nameCoffee, double moneyValue, double getMass)
    {
        this.nameCoffee = nameCoffee;
        this.moneyValue = moneyValue;
        this.getMass = getMass;
    }
    public double countSum()
    {
        return this.moneyValue * this.getMass;
    }
}
