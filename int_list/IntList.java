package int_list;

public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }

    public int iterativeSize() {
        IntList list = this;
        int size = 0;
        while (list != null) {
            ++size;
            list = list.rest;
        }
        return size;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public int iterativeGet(int i) {
        IntList list = this;
        while (i != 0) {
            --i;
            list = list.rest;
        }
        return list.first;
    }

    public void addFirst(int item) {
        rest = new IntList(first, rest);
        first = item;
    }

    public int getFirst() {
        return get(0);
    }

    public static void main(String[] args) {
        IntList list = new IntList(5, null);
        list.addFirst(10);
        list.addFirst(15);
        System.out.println(list.getFirst());
    }
}