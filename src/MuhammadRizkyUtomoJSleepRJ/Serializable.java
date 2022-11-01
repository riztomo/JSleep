package MuhammadRizkyUtomoJSleepRJ;


import java.util.HashMap;

/**
 * Write a description of class Serializable here.
 *
 * @author Muhammad Rizky Utomo
 * @version 04/10/2022
 */
public class Serializable
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();


    protected Serializable() {
        Integer il = mapCounter.get(getClass());
        if (il == null) { il = 0; }
        else {il += 1;}

        mapCounter.put(getClass(), il);
        this.id = il;
    }

    public int compareTo(Serializable a) {
        return Integer.compare(id, a.id);
    }

    public boolean equals(Object a) {
        if (a instanceof Serializable) {
            Serializable obj = (Serializable) a;
            return obj.id == id;
        } else {
            return false;
        }
    }

    public boolean equals(Serializable a) {
        return a.id == id;
    }

    public static <T extends Serializable> Integer getClosingId(Class<T> a) {
        return mapCounter.get(a);
    }

    public static <T extends Serializable> Integer setClosingId(Class<T> a, int setter) {
        return mapCounter.put(a, setter);
    }
}
