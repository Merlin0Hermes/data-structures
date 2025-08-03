package stack;

import deque.LinkedListDeque;

public class Stack<T>{
    private LinkedListDeque<T> stack;
    private int size;

    public Stack() {
        stack = new LinkedListDeque<>();
        ++size;
    }
    public void push(T item) {
        stack.addLast(item);
    }
    public T pop() {
        return stack.removeLast();
    }
}