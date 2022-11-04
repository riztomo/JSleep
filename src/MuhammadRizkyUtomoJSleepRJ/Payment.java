package MuhammadRizkyUtomoJSleepRJ;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Prints the payment details.
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
 */
public class Payment extends Invoice
{
    
    /** Instances */
    public Date to;
    public Date from;
    private int roomId;
    
    /** The constructor obtains four int-s... */
    public Payment(int buyerId, int renterId, int roomId) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date(this.from.getTime() + 2*24*60*60*1000);
        
    }
    
    /** ...or change the two int-s of buyer and renter ID with an object from Account and Renter */
    public Payment(Account buyer, Renter renter, int roomId) {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date(this.from.getTime() + 2*24*60*60*1000);
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
    /*public String getDuration() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd MMMMMMMMM yyyy");
        String start = dateformat.format(from.getTime());
        String finish = dateformat.format(to.getTime());
        return (start + " - " + finish);
    }*/
    
    /** Prints the current time */
    public String getTime() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd MMMMMMMMM yyyy");
        String theTime = dateformat.format(time.getTime());
        return theTime;
    }
    
    public static boolean availability(Date from,Date to,Room room) {

        Date prevDate = new Date();
        int iter = 1;

        if (from.compareTo(to) > 0) {
            return false;
        } else if (room.booked.isEmpty()) {
            return true;
        } else {
            for (Date roomDate : room.booked) {
                if (roomDate.compareTo(from) >= 0 && roomDate.compareTo(to) <= 0) {
                    return false;
                } else if ((iter % 2) == 0) {
                    if (from.compareTo(prevDate) > 0 && to.compareTo(roomDate) < 0) {
                        return false;
                    }
                }

                iter += 1;
                prevDate = roomDate;
            }
        }
        
        return true;
    }
    
    public static boolean makeBooking(Date from,Date to,Room room) {
        
        boolean bool;
        
        bool = availability(from,to,room);
        
        if (bool) {
            room.booked.add(from);
            room.booked.add(to);
        }
        
        return bool;
    }
}
