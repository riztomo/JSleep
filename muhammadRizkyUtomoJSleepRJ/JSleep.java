package muhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class JSleep here.
 *
 * @author Muhammad Rizky Utomo
 * @version 13/09/2022
 */
public class JSleep
{
    public static void main(String[] args) {
        
    }
    
    public static int getHotelId() {
        return 0;
    }
    
    public static String getHotelName() {
        return "hotel";
    }
    
    public static boolean isDiscount() {
        return true;
    }
    
    public static float getDiscountedPercentage(int beforeDiscount, int afterDiscount) {
        if (afterDiscount < beforeDiscount) {
            return (((beforeDiscount - afterDiscount) / beforeDiscount) * 100);
        } else {
            return 0;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        if (discountPercentage > 100) {
            return 0;
        }
        
        return (int) (((100 - discountPercentage) / 100) * price);
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        return (int) (discountedPrice * (100 / (100 - discountPercentage)));
    }
    
    public static float getAdminFeePercentage() {
        return 0.05f;
    }
    
    public static int getAdminFee(int price) {
        return (int) (price * getAdminFeePercentage());
    }
    
    public static int getTotalPrice(int price, int numberOfNight) {
        int total = numberOfNight * price;
        return (int) (total + (total * getAdminFeePercentage()));
    }
}
