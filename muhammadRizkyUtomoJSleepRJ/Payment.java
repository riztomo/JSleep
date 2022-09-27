package muhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Payment here.
 *
 * @author Muhammad Rizky Utomo
 * @version 27/09/2022
 */
public class Payment extends Invoice
{
    
    public String to;
    public String from;
    private int roomId;
    
    public Payment( int id, int buyerId, int renterId, String time, int roomId,
                    String from, String to) {
        super(id, buyerId, renterId, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Payment( int id, Account buyer, Renter renter, String time, int roomId,
                    String from, String to) {
        super(id, buyer, renter, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public int getRoomId() {
        return roomId;
    }
    
    public String print() {
        return ("Room ID: " + roomId + "\n" + "Payment to: " + to + "\n" + "Payment from: " + from + "\n");
    }
}
