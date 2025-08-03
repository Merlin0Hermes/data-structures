package stack;

import deque.LinkedListDeque;

public class Stack<T> extends LinkedListDeque<T> {

    public void push(T item) {
        addLast(item);
    }

    public T pop() {
        return removeLast();
    }
}