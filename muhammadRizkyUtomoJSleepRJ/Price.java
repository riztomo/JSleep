package muhammadRizkyUtomoJSleepRJ;


/**
 * Determines the total price and slashed price after discount.
 *
 * @author Muhammad Rizky Utomo
 * @version 27/09/2022
 */
public class Price
{
    public double price;
    public double discount;
    
    public Price(double price) {
        this.price = price;
    }
    
    public Price(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }
}
