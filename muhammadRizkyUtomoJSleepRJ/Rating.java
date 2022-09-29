package muhammadRizkyUtomoJSleepRJ;


/**
 * Determines the customer's rating of their experience.
 *
 * @author Muhammad Rizky Utomo
 * @version 27/09/2022
 */
public class Rating
{
    private long total;
    private long count;
    
    public Rating()
    {
        this.total = 0;
        this.count = 0;
    }
    
    public void insert(int rating) {
        total = total + rating;
        count++;
    }
    
    public double getAverage() {
        if (count <= 0) {
            return 0;
        } else {
            return total / count;
        }
    }
    
    public long getCount() {
        return count;
    }
    
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
