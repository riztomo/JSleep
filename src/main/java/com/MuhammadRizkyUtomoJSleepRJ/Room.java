package com.MuhammadRizkyUtomoJSleepRJ;
import com.MuhammadRizkyUtomoJSleepRJ.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;


/**
 * Describes the room properties.
 *
 * @author Muhammad Rizky Utomo
 * @version 11/12/2022
 */
public class Room extends Serializable
{
    public int size;
    public int accountId;
    public String name;
    public ArrayList<Facility> facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<>();

    /**
     * Constructor of a Room.
     * @param accountId Buyer's account ID.
     * @param name Room's name
     * @param size Room's size
     * @param price Room's price
     * @param facility Room's facility
     * @param city Room's city
     * @param address Room's address
     * @param bedType Room's bedType
     */
    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address, BedType bedType) {
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.city = city;
        this.address = address;
        this.accountId = accountId;
        this.bedType = bedType;
    }
    /**
     * Returns the room's information in a string format.
     * @return name, size, price, bedType, facility, city, address, id
     */
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
