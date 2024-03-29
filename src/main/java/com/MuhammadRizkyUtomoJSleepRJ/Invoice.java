package com.MuhammadRizkyUtomoJSleepRJ;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.Serializable;

import java.util.Date;


/**
 * Generates the invoice for a recorded stay.
 *
 * @author Muhammad Rizky Utomo
 * @version 11/12/2022
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
    public RoomRating rating;
    public PaymentStatus status;

    /**
     * Constructor of Invoice.
     * @param buyerId Buyer's account ID.
     * @param renterId Buyer's renter ID.
     */
    protected Invoice(int buyerId, int renterId) {
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * Constructor of Invoice.
     * @param buyer
     * @param renter
     */
    public Invoice(Account buyer, Renter renter) {
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    /**
     * Returns the customers' buyer and renter ID information in a string format.
     * @return buyerId, renterId
     */
    public String print() {
        return ("Buyer ID: " + buyerId + "\n" + "Renter ID: " + renterId + "\n" + "\n");
    }
}
