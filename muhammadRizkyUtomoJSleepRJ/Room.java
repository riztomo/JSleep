package muhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Room here.
 *
 * @author Muhammad Rizky Utomo
 * @version 27/09/2022
 */
public class Room extends Serializable
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    
    public Room(int id, String name, int size, Price price, Facility facility) {
        super(id);
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
    }
}
