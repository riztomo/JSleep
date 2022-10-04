package muhammadRizkyUtomoJSleepRJ;
import java.util.Calendar;


/**
 * Write a description of class Invoice here.
 *
 * @author Muhammad Rizky Utomo
 * @version 04/10/2022
 */
public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;
    public Calendar time;
    public RoomRating rating;
    public PaymentStatus status;
    
    protected Invoice(int id, int buyerId, int renterId) {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(int id, Account buyer, Renter renter) {
        super(id);
        this.time = Calendar.getInstance();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print() {
        return ("Buyer ID: " + buyerId + "\n" + "Renter ID: " + renterId + "\n" + "Time: " + time + "\n");
    }
}
