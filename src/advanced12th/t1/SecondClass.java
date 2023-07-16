package advanced12th.t1;
public class SecondClass extends Ticket
{
    SecondClass(int Start_location,int End_location)
    {
        super(Start_location, End_location);
    }
    
    @Override
    public double payment() 
    {
        return Math.abs(End_location - Start_location )*50; //calculating refund by number of stops
    }
    
}
