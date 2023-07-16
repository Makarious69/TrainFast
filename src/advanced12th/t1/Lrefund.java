package advanced12th.t1;
public class Lrefund implements Refund
{
    int Start_location; 
    int End_location;
    Lrefund(int Start_location, int End_location)
    {
        this.Start_location=Start_location;
        this.End_location=End_location;
    }

    @Override
    public double calculateRefund() {
        return (End_location-Start_location)*100;//calculating refund by number of stops
    }
}
