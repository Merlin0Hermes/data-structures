public class SLList {

    private static class IntNode {
        int item;
        IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

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

    public int size() {
        IntNode p = first;
        int size = 0;
        while (p != null) {
            ++size;
            p = p.next;
        }
        return size;
    }

    public void addLast(int item) {
        IntNode p = first;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(item, null);
    }

    public static void main(String[] args) {
        SLList list = new SLList(10);
        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);

        System.out.println(list.size());

    }
}