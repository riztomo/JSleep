package com.MuhammadRizkyUtomoJSleepRJ;


/**
 * Stores a customer's complaint.
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
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
