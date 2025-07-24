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
    private IntNode last;
    private int size;


    public SLList() {
        sentinel = new IntNode(0, null);
        last = sentinel;
        size = 0;
    }

    public SLList(int item) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(item, null);
        last = sentinel;
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
        last.next = new IntNode(item, null);
        last = last.next;
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

        if (p == last) {
            last = p.next;
        }
    }

    private IntNode reverse(IntNode node) {
        if (node.next == null) {
            sentinel.next = node;
            return node;
        }
        reverse(node.next).next = node;
        return node;
    }

    public void reverse() {
        reverse(sentinel.next).next = null;
    }

    public void print() {
        IntNode p = sentinel.next;
        while(p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        SLList list = new SLList();

        for (int i = 0; i < 100000; ++i) {
            list.addLast(i);
        }

    }
}