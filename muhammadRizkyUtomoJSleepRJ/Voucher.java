package muhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Voucher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Voucher
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;
    
    public Voucher( String name, int code, Type type, double minimum, 
                    double cut) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }
    
    public boolean isUsed() {
        return used;
    }
    
    public boolean canApply(Price price) {
        if (price.price > minimum && used == false) {
            return true;
        } else {
            return false;
        }
    }
    
    public double apply(Price price) {
        used = true;
        double result = 0;
        
        if (type == Type.DISCOUNT) {
            result = price.price * ((100 - cut) / 100);
        } else if (type == Type.REBATE) {
            result = price.price - cut;
        }
        
        return result;
    }
}
