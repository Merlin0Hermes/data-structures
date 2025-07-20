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

    public static void main(String[] args) {
        IntList list = new IntList(5, null);
        list = new IntList(10, list);
        list = new IntList(15, list);
        System.out.println(list.iterativeSize());
    }
}