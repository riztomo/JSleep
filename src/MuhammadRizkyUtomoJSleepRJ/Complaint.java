package MuhammadRizkyUtomoJSleepRJ;


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
    
    public Complaint(String date, String desc) {
        this.desc = desc;
        this.date = date;
    }
    
    public String toString() {
        return ("Date: " + date + "\n" + "Description: " + desc + "\n");
    }
}
