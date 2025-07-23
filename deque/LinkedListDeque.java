package deque;

public class LinkedListDeque<T> {

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T i, Node<T> p, Node<T> n) {
            item = i;
            prev = p;
            next = n;
        }

        public Node(Node<T> n, Node<T> p) {
            next = n;
            prev = p;
        }

        public Node() {

        }
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
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        Node<T> node = new Node<T>(item, sentinel, sentinel.next);
        sentinel.next = node;
        node.next.prev = node;
        ++size;
    }

    public void addLast(T item) {
        Node<T> node = new Node<T>(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        ++size;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        list.addLast(10);
        list.addLast(20);
        list.addFirst(30);
    }

}