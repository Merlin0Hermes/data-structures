package array_list;

public class AList<T>  implements List.List<T> {
    private T[] items;
    private int size;

    public AList() {
        items = (T[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity) {
        T[] arr = (T[]) new Object[capacity];
        System.arraycopy(items, 0, arr, 0, size);
        items = arr;
    }

    public void addLast(T item) {
        double RFACTOR = 0.25;
        if (size == items.length) {
            resize(size + (int) Math.ceil(size * RFACTOR));
        }
        items[size++] = item;
    }

    public T getLast() {
        return items[size - 1];
    }

    public T getFirst() {
        return items[0];
    }

    public T get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T item = getLast();
        items[size - 1] = null;
        --size;
        return item;
    }

    public void addFirst(T item) {
        double RFACTOR = 0.25;
        if (size == items.length) {
            resize(size + (int) Math.ceil(size * RFACTOR));
        }

        System.arraycopy(items, 0, items, 1, this.size());
        items[0] = item;
        ++size;
    }

    public static void main(String[] args) {
        AList<Integer> list = new AList<>();
        for (int i = 0; i < 100000; ++i) {
            list.addFirst(i);
        }
    }
}