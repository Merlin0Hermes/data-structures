package singly_linked_list;

public class SLList {

    private static class IntNode {
        int item;
        IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /** first item in list is at sentinel.next
     * sentinel is never null. */
    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLList(int item) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(item, null);
        size = 1;
    }

    public boolean isEmpty() {
        return sentinel.next == null;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addFirst(int item) {
        insert(item, 0);
    }

    public int size() {
        return size;
    }

    public void addLast(int item) {
        insert(item, size);
    }

    /** inserts item at a position. inserts at end of list
     * if position is greater than size.
     */
    public void insert(int item, int position) {
        IntNode p = sentinel;
        for (int i = 0; i < position; ++i) {
            if (p.next == null) {
                break;
            }
            p = p.next;
        }
        p.next = new IntNode(item, p.next);
        ++size;
    }

    public static void main(String[] args) {
        SLList list = new SLList();

        list.insert(10, 0);
        list.insert(20, 1);
        list.insert(100, 1000);
        list.addFirst(10);
        list.addLast(5);
        list.addLast(0);
        list.addFirst(402);

        System.out.println(list.size());

    }
}