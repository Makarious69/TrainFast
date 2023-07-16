package advanced12th.t1;

public class FirstClass extends Ticket {

    FirstClass(int Start_location, int End_location) {
        super(Start_location, End_location);
    }

    @Override
    public double payment() {
        return Math.abs(End_location - Start_location) * 70;//calculating price by number of stops 
    }

}
