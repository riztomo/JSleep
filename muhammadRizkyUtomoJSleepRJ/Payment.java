package muhammadRizkyUtomoJSleepRJ;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Payment here.
 *
 * @author Muhammad Rizky Utomo
 * @version 04/10/2022
 */
public class Payment extends Invoice
{
    
    /** Instances */
    public Calendar to;
    public Calendar from;
    private int roomId;
    
    /** The constructor obtains four int-s... */
    public Payment(int id, int buyerId, int renterId, int roomId) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
        
    }
    
    /** ...or change the two int-s of buyer and renter ID with an object from Account and Renter */
    public Payment( int id, Account buyer, Renter renter, int roomId) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
    /** Gets the room ID */
    public int getRoomId() {
        return roomId;
    }
    
    /** Prints the payment details */
    public String print() {
        return ("Room ID: " + roomId + "\n" + "Payment to: " + to + "\n" + "Payment from: " + from + "\n");
    }
    
    /** Prints the customer's duration of stay */
    public String getDuration() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd MMMMMMMMM yyyy");
        String start = dateformat.format(from.getTime());
        String finish = dateformat.format(to.getTime());
        return (start + " - " + finish);
    }
    
    /** Prints the current time */
    public String getTime() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd MMMMMMMMM yyyy");
        String theTime = dateformat.format(time.getTime());
        return theTime;
    }
}
