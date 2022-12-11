package com.MuhammadRizkyUtomoJSleepRJ;
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
    
    /** The constructor obtains four int-s...
     * @param buyerId Buyer's account information.
     * @param renterId Buyer's renter information.
     * @param roomId Room's ID information.
     * @param fromDate Start date of stay.
     * @param toDate End date of stay.*/
    public Payment(int buyerId, int renterId, int roomId, Date fromDate, Date toDate) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = fromDate;
        this.to = toDate;
        
    }
    
    /** ...or change the two int-s of buyer and renter ID with an object from Account and Renter
     * @param buyer Buyer's account information.
     * @param renter Buyer's renter information.
     * @param roomId Room's ID information.*/
    public Payment(Account buyer, Renter renter, int roomId) {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date(this.from.getTime() + 2*24*60*60*1000);
    }

    /** Gets the room ID
     * @return int
     */
    public int getRoomId() {
        return roomId;
    }
    
    /**
     * Prints the payment details
     * @return String
     */
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
    /**
     * Checks room availability for the specified duration of stay.
     * @param from Start date of stay.
     * @param to End date of stay.
     * @param room Selected room.
     * @return boolean
     */
    public static boolean availability(Date from, Date to, Room room)
    {
        if(to.before(from))
            return false;
        if(room.booked.isEmpty()){
            return true;
        }
        for(Date i : room.booked){
            if(i.after(from) && i.before(to) || i.equals(from)){
                return false;
            }
        }
        return true;
    }

    /**
     * Books a room if availability is true.
     * @param from
     * @param to
     * @param room
     * @return Boolean of availability
     */
    public static boolean makeBooking(Date from,Date to,Room room) {
        Calendar tempDate = Calendar.getInstance();

        if(availability(from, to, room)){
            while(from.before(to)){
                room.booked.add(from);
                tempDate.setTime(from);
                tempDate.add(Calendar.DATE, 1);
                from = tempDate.getTime();
            }
            return true;
        }else{
            return false;
        }
    }
}
