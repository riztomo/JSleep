package muhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Price
{
    public double rebate;
    public double price;
    public int discount;
    
    public Price(double price) {
        this.price = price;
        this.rebate = 0;
        this.discount = 0;
    }
    
    public Price(double price, int discount) {
        this.price = price;
        this.rebate = 0;
        this.discount = discount;
    }
    
    public Price(double price, double rebate) {
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    
    private double getDiscountedPrice() {
        if (discount >= 100) {
            return 0;
        } else {
            return price - (price * (discount / 100));
        }
    }
    
    private double getRebatedPrice() {
        if (rebate > price) {
            return 0;
        } else {
            return price - rebate;
        }
    }
}
