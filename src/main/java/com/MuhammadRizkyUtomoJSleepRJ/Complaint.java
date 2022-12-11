package com.MuhammadRizkyUtomoJSleepRJ;


import com.MuhammadRizkyUtomoJSleepRJ.dbjson.Serializable;

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

    /**
     * Constructor of Complaint.
     * @param date
     * @param desc
     */
    public Complaint(String date, String desc) {
        this.desc = desc;
        this.date = date;
    }
    /**
     * Returns the customers' complaint information in a string format.
     * @return date, desc
     */
    public String toString() {
        return ("Date: " + date + "\n" + "Description: " + desc + "\n");
    }
}
