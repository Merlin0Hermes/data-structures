package List;

import deque.LinkedListDeque;
import array_list.AList;

public interface List<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public T getFirst();
    public T getLast();
    public T removeLast();
    public T get(int i);
    public int size();

    default public void print() {
        for (int i = 0; i < size(); ++i) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}