package muhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Complaint here.
 *
 * @author Muhammad Rizky Utomo
 * @version 04/10/2022
 */
public class Complaint extends Serializable
{
    public String desc;
    public String date;
    
    public Complaint(int id, String date, String desc) {
        super(id);
        this.desc = desc;
        this.date = date;
    }
    
    public String toString() {
        return ("Date: " + date + "\n" + "Description: " + desc + "\n");
    }
}
