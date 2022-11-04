package MuhammadRizkyUtomoJSleepRJ;
import java.util.ArrayList;
import java.util.Date;


/**
 * Describes the room properties.
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
 */
public class Room extends Serializable
{
    public int size;
    public int accountId;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<>();
    
    public Room(int accountId, String name, int size, Price price, Facility facility, City city, String address) {
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.city = city;
        this.address = address;
        this.accountId = accountId;
    }
    
    public String toString() {
        return (    
            "Name: " + name + "\n" +
            "Size: " + size + "\n" +
            price + 
            "Bed: " + bedType + "\n" +
            "Facility: " + facility + "\n" +
            "City: " + city + "\n" +
            "Address: " + address + "\n" +
            "ID: " + id + "\n"
        );
    }
    
    public Object write() {
        return null;
    }
    
    public boolean read(String a) {
        return false;
    }
}
