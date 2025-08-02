package set;

import java.util.Iterator;

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
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size() - 1; ++i) {
            sb.append(items[i]).append(", ");
        }
        sb.append(items[size() - 1]).append("}");
        return sb.toString();
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

        ArraySet<String> s2 = new ArraySet<>();
        s2.add("house");
        s2.add("horse");
        s2.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
        System.out.println(s);
        System.out.println(s.equals(s2));

    }
}