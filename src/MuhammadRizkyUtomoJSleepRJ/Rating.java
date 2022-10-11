package MuhammadRizkyUtomoJSleepRJ;


/**
 * Determines the customer's rating of their experience.
 *
 * @author Muhammad Rizky Utomo
 * @version 04/10/2022
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
    
    /** Adds a rating to the room */
    public void insert(int rating) {
        total = total + rating;
        count++;
    }
    
    /** Gets the average rating of a room */
    public double getAverage() {
        if (count <= 0) {
            return 0;
        } else {
            return total / count;
        }
    }
    
    /** Gets the amount of rating a room has */
    public long getCount() {
        return count;
    }
    
    /** Gets the sum of all ratings a room has */
    public long getTotal() {
        return total;
    }
    
    public String toString() {
        return(
            "Total: " + total + "\n" +
            "Count: " + count + "\n"
        );
    }
}
