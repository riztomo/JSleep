package MuhammadRizkyUtomoJSleepRJ;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Validate filters prices that are lower or higher than a certain value.
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
 */
public class Validate
{
    public Validate() {
        
    }
    
    public static ArrayList filter (Price[] list, int value, boolean less) {
        ArrayList<Double> values = new ArrayList<>();
        
        if (less) {
            for (Price iter : list) {
                if (iter.price < value) {
                    values.add(iter.price);
                }
            }
        } else {
            for (Price iter : list) {
                if (iter.price >= value) {
                    values.add(iter.price);
                }
            }
        }

        Collections.sort(values);
        
        return values;
    }
}