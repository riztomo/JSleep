package com.MuhammadRizkyUtomoJSleepRJ;


/**
 * Determines the customer's rating of their experience.
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
 */
public class Rating
{
    /** Instances */
    private long total;
    private long count;
    
    /** Initializes a room's rating mechanism */
    public Rating()
    {
        this.total = 0;
        this.count = 0;
    }
    
    /** Adds a rating to the room
     * @param rating Room rating from 1 to 10*/
    public void insert(int rating) {
        total = total + rating;
        count++;
    }
    
    /** Gets the average rating of a room
     * @return double*/
    public double getAverage() {
        if (count <= 0) {
            return 0;
        } else {
            return total / count;
        }
    }
    
    /** Gets the number of how many rating a room has
     * @return long*/
    public long getCount() {
        return count;
    }
    
    /** Gets the sum of all ratings a room has
     * @return long*/
    public long getTotal() {
        return total;
    }
    /**
     * Returns the count and total of ratings information in a string format.
     * @return total, count
     */
    public String toString() {
        return(
            "Total: " + total + "\n" +
            "Count: " + count + "\n"
        );
    }
}
