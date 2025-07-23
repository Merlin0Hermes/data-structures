package array_list;

public class AList {
    int[] items;
    int size;

    public AList() {
        items = new int[100];
        size = 0;
    }

    public void addLast(int item) {
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

    public static void main(String[] args) {

    }
}