public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public static void main(String[] args) {
        IntList list = new IntList(5, null);
        list = new IntList(10, list);
        list = new IntList(15, list);
    }
}