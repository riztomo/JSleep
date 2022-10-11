package MuhammadRizkyUtomoJSleepRJ;

import java.util.Arrays;
import java.util.Iterator;

public class Algorithm{

    private Algorithm() {

    }
    public static <T> int count(Iterator<T> a, T b){
        final Predicate<T> pred = b::equals;
        return count(a, pred);
    }

    public static <T> int count(T[] a, T b){
        final Iterator<T> it = Arrays.stream(a).iterator();
        return count(it, b);
    }

    public static <T> int count(Iterable<T> a, Predicate<T> b){
        final Iterator<T> it = a.iterator();
        return count(it, b);
    }

    public static <T> int count(T[] a, Predicate<T> b){
        final Iterator<T> it = Arrays.stream(a).iterator();
        return count(it, b);
    }

    public static <T> int count(Iterable<T> a, T b){
        final Iterator<T> it = a.iterator();
        return count(it, b);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int cou = 0;
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) { cou = cou + 1; }
        }
        return cou;
    }

    public static <T> boolean exists (Iterable<T> a, T b) {
        final Iterator<T> it = a.iterator();
        return exists(it, b);
    }

    public static <T> boolean exists (Iterable<T> a, Predicate<T> b) {
        final Iterator<T> it = a.iterator();
        return exists(it, b);
    }

    public static <T> boolean exists (T[] a, Predicate<T> b) {
        final Iterator<T> it = Arrays.stream(a).iterator();
        return exists(it, b);
    }

    public static <T> boolean exists (T[] a, T b) {
        final Iterator<T> it = Arrays.stream(a).iterator();
        return exists(it, b);
    }

    public static <T> boolean exists (Iterator<T> a, T b) {
        final Predicate<T> pred = b::equals;
        return exists(a, pred);
    }

    public static <T> boolean exists (Iterator<T> a, Predicate<T> b) {
        while (a.hasNext()) {
            T current = a.next();
            if (b.predicate(current)) { return true; }
        }
        return false;
    }

    public static <T> T find(T[] a, Predicate<T> b){
        final Iterator<T> it = Arrays.stream(a).iterator();
        return find(it, b);
    }

    public static <T> T find(T[] a, T b){
        final Iterator<T> it = Arrays.stream(a).iterator();
        return find(it, b);
    }

    public static <T> T find(Iterable<T> iterable, T b){
        final Iterator<T> it = iterable.iterator();
        return find(it, b);
    }

    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> b = value::equals;
        return find(iterator, b);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> b){
        final Iterator<T> it = iterable.iterator();
        return find(it, b);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> b){
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (b.predicate(current)) { return current; }
        }
        return null;
    }
}
