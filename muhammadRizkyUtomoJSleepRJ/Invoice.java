package muhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Invoice here.
 *
 * @author Muhammad Rizky Utomo
 * @version 27/09/2022
 */
public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;
    public String time;
    public RoomRating rating;
    public PaymentStatus status;
    
    protected Invoice(int id, int buyerId, int renterId, String time) {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(int id, Account buyer, Renter renter, String time) {
        super(id);
        this.time = time;
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print() {
        return ("Buyer ID: " + buyerId + "\n" + "Renter ID: " + renterId + "\n" + "Time: " + time + "\n");
    }
}
