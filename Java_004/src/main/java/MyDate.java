public class MyDate 
{
    private int Day, Month, Year;
    public MyDate(int Day, int Month, int Year) //Constructor
    {
        if(Day >= 1 && Day <= 31) this.Day = Day;
        else this.Day = 1;
        if(Month >= 1 && Month <= 12) this.Month = Month;
        else this.Month = 1;
        if(Year > 0)this.Year = Year;
        else this.Year = 1;
    }
    //Get
    public int getDay()
    {
        return this.Day;
    }
    public int getMonth()
    {
        return this.Month;
    }
    public int getYear()
    {
        return this.Year;
    }
    //Set
    public void setDay(int Day)
    {
        if(Day >= 1 && Day <= 31) this.Day = Day;
    }
    public void setMonth(int Month)
    {
        if(Month >= 1 && Month <= 12) this.Month = Month;
    }
    public void setYear(int Year)
    {
        if(Year > 0) this.Year = Year;
    }
    //toString

    @Override
    public String toString() {
        return this.Day + "/" + this.Month + "/" + this.Year;
    }
    
}
