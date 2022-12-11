package com.MuhammadRizkyUtomoJSleepRJ.dbjson;


import java.util.HashMap;

/**
 * Serializable sets the id with increments
 *
 * @author Muhammad Rizky Utomo
 * @version 01/11/2022
 */
public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    /**
     * Constructor of Serializable.
     */
    protected Serializable() {
        Integer il = mapCounter.get(getClass());
        if (il == null) { il = 0; }
        else {il += 1;}

        mapCounter.put(getClass(), il);
        this.id = il;
    }

    /**
     * Compares a Serializable ID to another Serializable ID.
     * @param a the object to be compared.
     * @return int
     */
    public int compareTo(Serializable a) {
        return Integer.compare(id, a.id);
    }

    /**
     * Checks whether an Object is an instance of Serializable
     * @param a
     * @return boolean
     */
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
