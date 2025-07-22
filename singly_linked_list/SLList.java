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

    public boolean isEmpty() {
        return first == null;
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
        if (isEmpty()) {
            addFirst(item);
            return;
        }

        IntNode p = first;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(item, null);
        ++size;
    }

    public static void main(String[] args) {
        SLList list = new SLList();

        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);

        System.out.println(list.size());

    }
}