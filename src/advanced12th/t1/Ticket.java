package advanced12th.t1;

import java.util.Arrays;

public class Ticket {

    public int Start_location;
    public int End_location;
    private String date;
    private int NumberOfTickets;
    private double payment;

    Ticket(int Start_location, int End_location) { //Constructer that takes the start station order and end station order
        this.Start_location = Start_location;
        this.End_location = End_location;
    }

    //Getters and Setters
    public int getNumberOfTickets() {
        return NumberOfTickets;
    }

    public void setNumberOfTickets(int NumberOfTickets) {
        this.NumberOfTickets = NumberOfTickets;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String[] stations = {"Alexandria", "Cairo", "Giza", "Beni Suef", "Minya", "Assiut", "Sohag", "Qena", "Luxor", "Aswan"};//array of station names ordered

    public double payment() { //payment calculation method that is overriden by sub-classes 
        return payment;
    }
}
