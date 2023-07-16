package advanced12th.t1;
public class Srefund implements Refund
{
    int Start_location; 
    int End_location;
    Srefund(int Start_location, int End_location)
    {
        this.Start_location=Start_location;
        this.End_location=End_location;
    }

    @Override
    public double calculateRefund() {
        return (End_location-Start_location)*50; //calculating refund by number of stops
    }
}
