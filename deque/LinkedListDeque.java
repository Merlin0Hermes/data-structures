package deque;

public class LinkedListDeque<T> {

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;
    }

    /** first item in list is at sentinel.next (if it exists) */
    Node<T> sentinel;
    int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node<T>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

    }

    public LinkedListDeque(T item) {
        size = 1;
        sentinel = new Node<T>();
        Node<T> node = new Node<T>();

        sentinel.next = node;
        sentinel.prev = node;

        node.prev = sentinel;
        node.next = sentinel;

        node.item = item;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> list = new LinkedListDeque<>(5);

    }

}