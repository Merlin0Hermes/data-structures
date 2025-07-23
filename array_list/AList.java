package array_list;

public class AList {
    private int[] items;
    private int size;

    public AList() {
        items = new int[1];
        size = 0;
    }

    public void addLast(int item) {
        if (size == items.length) {
            int[] arr = new int[size + 1];
            System.arraycopy(items, 0, arr, 0, size);
            items = arr;
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
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
    }
}