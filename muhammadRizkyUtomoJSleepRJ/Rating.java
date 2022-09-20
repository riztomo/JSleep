package muhammadRizkyUtomoJSleepRJ;


/**
 * Write a description of class Rating here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
}
