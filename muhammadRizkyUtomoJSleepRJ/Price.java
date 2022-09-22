package muhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
