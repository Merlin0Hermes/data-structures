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
    private int size;

    public SLList() {
        first = null;
        size = 0;
    }

    public SLList(int item) {
        first = new IntNode(item, null);
        size = 1;
    }

    public int getFirst() {
        return first.item;
    }

    public void addFirst(int item) {
        first = new IntNode(item, first);
        ++size;
    }

    private static int size(IntNode node) {
        if (node.next == null) {
            return 1;
        }
        return 1 + size(node.next);
    }

    public int size() {
        return size(first);
    }

    public void addLast(int item) {
        IntNode p = first;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(item, null);
        ++size;
    }

    public static void main(String[] args) {
        SLList list = new SLList();

        list.addFirst(1);
        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);

        System.out.println(list.size());

    }
}