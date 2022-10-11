package MuhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Renter here.
 *
 * @author Muhammad Rizky Utomo
 * @version 04/10/2022
 */
public class Renter extends Serializable
{
    public int phoneNumber;
    public String address;
    public String username;
    
    public Renter(String username) {
        this.username = username;
        this.phoneNumber = 0;
        this.address = " ";
    }
    
    public Renter(String username, String address) {
        this.username = username;
        this.address = address;
        this.phoneNumber = 0;
    }
    
    public Renter(String username, int phoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = " ";
    }
    
    public Renter(String username, int phoneNumber, String address) {
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
