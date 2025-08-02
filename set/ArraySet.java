package set;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[8];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size(); ++i) {
            if ((items[i].equals(x))) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("item can't be null");
        }
        if (contains(x)) {
            return;
        }
        items[size++] = x;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int pos;

        public ArraySetIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < size();
        }
        public T next() {
            return items[pos++];
        }
    }

    @Override
    public String toString() {
        List<String> itemsList = new ArrayList<>();
        for (T item : this) {
            itemsList.add(item.toString());
        }
        return "{" + String.join(", ", itemsList) + "}";
    }

    public static <T> ArraySet<T> of(T... items) {
        ArraySet<T> returnSet = new ArraySet<>();
        for (T i : items) {
            returnSet.add(i);
        }
        return returnSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
       if (o instanceof ArraySet set)  {
           if (set.size() != this.size()) {
               return false;
           }
            for (T item : this) {
                if (!set.contains(item)) {
                    return false;
                };
            }
            return true;
       }
       return false;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        // s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");

        System.out.println(s.contains("horse"));
        System.out.println(s.size());
        System.out.println(s);

        ArraySet<String> s2 = ArraySet.of("house", "horse", "fish");
        System.out.println(s.equals(s2));

    }
}