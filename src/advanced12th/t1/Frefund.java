package advanced12th.t1;

public class Frefund implements Refund {

    int Start_location;
    int End_location;

    Frefund(int Start_location, int End_location) {
        this.Start_location = Start_location;
        this.End_location = End_location;
    }

    @Override
    public double calculateRefund() {
        return (End_location - Start_location) * 70;//calculating refund by number of stops
    }
}
