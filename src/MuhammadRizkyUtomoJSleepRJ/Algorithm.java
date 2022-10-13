package MuhammadRizkyUtomoJSleepRJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

    public static <T> List<T> collect(T[] a, Predicate<T> b){
        final Iterator<T> it = Arrays.stream(a).iterator();
        return collect(it, b);
    }

    public static <T> List<T> collect(T[] a, T b){
        final Iterator<T> it = Arrays.stream(a).iterator();
        return collect(it, b);
    }

    public static <T> List<T> collect(Iterable<T> iterable, T b){
        final Iterator<T> it = iterable.iterator();
        return collect(it, b);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value){
        final Predicate<T> b = value::equals;
        return collect(iterator, b);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> b){
        final Iterator<T> it = iterable.iterator();
        return collect(it, b);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> b){

        List<T> newList = new ArrayList<T>();

        while (iterator.hasNext()) {
            T current = iterator.next();
            if (b.predicate(current)) { newList.add(current); }
        }
        return newList;
    }

    public static <T> List<T> paginate(T[] iter, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(iter).iterator();
        return paginate(it, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterable<T> iter, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = iter.iterator();
        return paginate(it, page, pageSize, pred);
    }
    public static <T> List<T> paginate(Iterator<T> iter, int page, int pageSize, Predicate<T> pred) {

        List<T> obtained = new ArrayList<>();
        int i = 0;

        while (iter.hasNext()) {
            T current = iter.next();
            if (pred.predicate(current)) {
                if (i >= page && i < page+pageSize) {
                    obtained.add(current);
                }
                i += 1;
            }
        }

        return obtained;
    }
}
