public class MyDate 
{
    private int Day, Month, Year;
    public MyDate(int Day, int Month, int Year)
    {
        this.Day = Day;
        this.Month = Month;
        this.Year = Year;
    }
    public void PrintDay()
    {
        System.out.println("Day : " + this.Day);
    }
    public void PrintMonth()
    {
        System.out.println("Month : " + this.Month);
    }
    
    public void PrintYear()
    {
        System.out.println("Year : " + this.Year);
    }
    public void PrintDate()
    {
        System.out.println(this.Day + "/" + this.Month + "/" + this.Year);
    }
}
