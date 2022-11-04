package MuhammadRizkyUtomoJSleepRJ;
import java.util.Calendar;
import java.util.Date;


/**
 * Generates the invoice for a recorded stay.
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
 */

public class Invoice extends Serializable
{
    public enum PaymentStatus
    {
        FAILED, WAITING, SUCCESS
    }
    
    public enum RoomRating
    {
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public int buyerId;
    public int renterId;
    public Date time;
    public RoomRating rating;
    public PaymentStatus status;
    
    protected Invoice(int buyerId, int renterId) {
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = new Date();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(Account buyer, Renter renter) {
        this.time = new Date();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print() {
        return ("Buyer ID: " + buyerId + "\n" + "Renter ID: " + renterId + "\n" + "Time: " + time + "\n");
    }
}