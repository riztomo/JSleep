package com.MuhammadRizkyUtomoJSleepRJ;


import com.MuhammadRizkyUtomoJSleepRJ.dbjson.Serializable;

/**
 * Creates a voucher ticket.
 *
 * @author Muhammad Rizky Utomo
 * @version 11/12/2022
 */
public class Voucher extends Serializable
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    /**
     * Constructor of Voucher.
     * @param name Voucher name
     * @param code Voucher code
     * @param type Voucher type, rebate or discount
     * @param used Voucher's used or not
     * @param minimum Voucher's minimum price requirement
     * @param cut Voucher cut value, in percentage for discount or value for rebate.
     */
    public Voucher( String name, int code, Type type,
                    boolean used, double minimum, double cut) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }

    /**
     * Returns boolean of whether the voucher is already used.
     * @return used
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * Returns boolean of whether the voucher can be applied.
     * @param price
     * @return boolean
     */
    public boolean canApply(Price price) {
        if (price.price > minimum && used == false) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Applies the voucher and reduces the price.
     * @param price
     * @return double
     */
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
    
    public Object write() {
        return null;
    }
    
    public boolean read(String a) {
        return false;
    }
}
