package stack;

import deque.LinkedListDeque;

public class Stack<T>{
    private LinkedListDeque<T> stack;

    public Stack() {
        stack = new LinkedListDeque<>();
    }
    public void push(T item) {
        stack.addLast(item);
    }
    public T pop() {
        return stack.removeLast();
    }
    public int size() {
        return stack.size();
    }
}