package muhammadRizkyUtomoJSleepRJ;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Payment here.
 *
 * @author Muhammad Rizky Utomo
 * @version 04/10/2022
 */
public class Payment extends Invoice
{
    
    /** Instances */
    public Date to;
    public Date from;
    private int roomId;
    
    /** The constructor obtains four int-s... */
    public Payment(int id, int buyerId, int renterId, int roomId) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
        Calendar adder = Calendar.getInstance();
        adder.setTime(to);
        adder.add(Calendar.DATE, 2);
        to = adder.getTime();
        
    }
    
    /** ...or change the two int-s of buyer and renter ID with an object from Account and Renter */
    public Payment( int id, Account buyer, Renter renter, int roomId) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
        Calendar adder = Calendar.getInstance();
        adder.setTime(to);
        adder.add(Calendar.DATE, 2);
        to = adder.getTime();
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
        
        Calendar fromCal = Calendar.getInstance();
        fromCal.setTime(from);
        Calendar toCal = Calendar.getInstance();
        toCal.setTime(to);
        
        if (from.compareTo(to) > 0) {
            return false;
        } else if (room.booked.isEmpty()) {
            return true;
        } else {
            for (Date roomDate : room.booked) {
                if (roomDate.compareTo(fromCal.getTime()) >= 0 && roomDate.compareTo(toCal.getTime()) <= 0) {
                    return false;
                }
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
