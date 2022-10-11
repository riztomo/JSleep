package MuhammadRizkyUtomoJSleepRJ;
import java.util.ArrayList;
import java.util.Date;


/**
 * Write a description of class Room here.
 *
 * @author Muhammad Rizky Utomo
 * @version 04/10/2022
 */
public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<>();
    
    public Room(String name, int size, Price price, Facility facility, City city, String address) {
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.city = city;
        this.address = address;
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
