package MuhammadRizkyUtomoJSleepRJ;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Location of the 'main' method.
 *
 * @author Muhammad Rizky Utomo
 * @version 27/09/2022
 */

/** Place of running (and testing) */
public class JSleep
{
    public static void main(String[] args) {
        /*Room roomEx = createRoom();
        System.out.println(roomEx.name);
        System.out.println(roomEx.size);
        System.out.println(roomEx.price.price);
        System.out.println(roomEx.facility);*/
        
        /*Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2, 2, 2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print());*/
        
        /* Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice,
        Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString()); */
        
        /*Payment testPayment = new Payment(2, 2, 2,2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        for(int i=0;i < unfilteredArray.length;i++){
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }
        System.out.println("Price List");
        for(int i=0;i < unfilteredArray.length;i++){
            System.out.println(unfilteredArray[i].price);
        }
        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000,true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000,false));*/
        
        /*Room RoomA = createRoom();
        Room RoomB = createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-18");
        Date end2 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));*/

        ArrayList<Room> RoomSer = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            RoomSer.add(i, JSleep.createRoom());
            System.out.println(RoomSer.get(i).toString());
        }
    }
    
    
    public static Room createRoom() {
        Price price = new Price(5000000, 18);
        Room room = new Room("Hotel", 30, price, Facility.AC, City.SURABAYA, "somewhere");
        return room;
    }
    
    /*
    public static int getHotelId() {
        return 0;
    }
    
    public static String getHotelName() {
        return "hotel";
    }
    
    public static boolean isDiscount() {
        return true;
    }
    
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount) {
        if (afterDiscount < beforeDiscount) {
            return (((beforeDiscount - afterDiscount) / beforeDiscount) * 100);
        } else {
            return 0;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        if (discountPercentage > 100) {
            discountPercentage = 100;
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
    }*/
}
