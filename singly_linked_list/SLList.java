public class SLList {
    private IntNode first;

    public SLList(int item) {
        first = new IntNode(item, null);
    }

    public int getFirst() {
        return first.item;
    }

    public void addFirst(int item) {
        first = new IntNode(item, first);
    }


    public static void main(String[] args) {
        SLList list = new SLList(10);
        list.addFirst(20);
        System.out.println(list.first.item);
    }
}