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
        sentinel.next = new IntNode(item, sentinel.next);
        ++size;
    }

    public int size() {
        return size;
    }

    public void addLast(int item) {

        IntNode p = sentinel;
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