public class MyDate {
    private int Day, Month, Year;
    public MyDate(int Day, int Month, int Year){
        if(Day >= 1 && Day <= 31) this.Day = Day;
        else this.Day = 1;
        if(Month >= 1 && Month <= 12) this.Month = Month;
        else this.Month = 1;
        if (Year >= 0)this.Year = Year;
        else this.Year = 1;
    }
    public int getDay(){
        return this.Day;
    }
    public void setDay(int Day){
        if(Day >= 1 && Day <= 31) this.Day = Day;
    }
}
