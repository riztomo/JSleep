package com.MuhammadRizkyUtomoJSleepRJ;


/**
 * Determines the total price and slashed price after discount.
 *
 * @author Muhammad Rizky Utomo
 * @version 11/12/2022
 */
public class Price
{
    
    /** Instances */
    public double price;
    public double discount;
    
    /** Constructor to set price only
     * @param price Room's price*/
    public Price(double price) {
        this.price = price;
    }
    
    /** Constructor to set price and discount
     * @param price Room's price
     * @param discount Room's price discount */
    public Price(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }
    
    /** Prints the price and discount of a room
     * @return price, discount*/
    public String toString() {
        return (
            "Price: " + price + "\n" +
            "Discount: " + discount + "\n"
        );
    }
}
