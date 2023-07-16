package advanced12th.t1;
public interface Refund 
{
    
    Ticket a = new Ticket(0,0);//Compostion (There is no refund without buying a ticket)
    
    public double calculateRefund();
}
