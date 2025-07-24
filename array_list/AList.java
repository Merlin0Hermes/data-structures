package array_list;

public class AList {
    private int[] items;
    private int size;

    public AList() {
        items = new int[1];
        size = 0;
    }

    private void resize(int capacity) {
        int[] arr = new int[capacity];
        System.arraycopy(items, 0, arr, 0, size);
        items = arr;
    }

    public void addLast(int item) {
        double RFACTOR = 0.25;
        if (size == items.length) {
            resize(size + (int) Math.ceil(size * RFACTOR));
        }
        items[size++] = item;
    }

    public int getLast() {
        return items[size - 1];
    }

    public int get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public int removeLast() {
        int item = getLast();
        --size;
        return item;
    }

    public static void main(String[] args) {
        AList list = new AList();
        for (int i = 0; i < 100000; ++i) {
            list.addLast(i);
        }
    }
}