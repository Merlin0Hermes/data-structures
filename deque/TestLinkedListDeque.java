package deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedListDeque {

    private LinkedListDeque<Integer> deque;

    @BeforeEach
    public void setUp() {
        deque = new LinkedListDeque<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(deque.isEmpty(), "Deque should be empty initially.");
    }

    @Test
    public void testAddFirst() {
        deque.addFirst(10);
        assertFalse(deque.isEmpty(), "Deque should not be empty after adding an element.");
        assertEquals(10, deque.get(0), "First element should be 10.");
        assertEquals(1, deque.size(), "Size should be 1 after adding one element.");
    }

    @Test
    public void testAddLast() {
        deque.addLast(20);
        assertFalse(deque.isEmpty(), "Deque should not be empty after adding an element.");
        assertEquals(20, deque.get(0), "First element should be 20.");
        assertEquals(1, deque.size(), "Size should be 1 after adding one element.");
    }

    @Test
    public void testRemoveFirst() {
        deque.addFirst(30);
        deque.addFirst(40);
        int removedItem = deque.removeFirst();
        assertEquals(40, removedItem, "Removed item should be 40.");
        assertEquals(1, deque.size(), "Size should be 1 after removing one element.");
        assertEquals(30, deque.get(0), "First element should now be 30.");
    }

    @Test
    public void testRemoveLast() {
        deque.addLast(50);
        deque.addLast(60);
        int removedItem = deque.removeLast();
        assertEquals(60, removedItem, "Removed item should be 60.");
        assertEquals(1, deque.size(), "Size should be 1 after removing one element.");
        assertEquals(50, deque.get(0), "First element should now be 50.");
    }

    @Test
    public void testGet() {
        deque.addFirst(70);
        deque.addLast(80);
        assertEquals(70, deque.get(0), "Element at index 0 should be 70.");
        assertEquals(80, deque.get(1), "Element at index 1 should be 80.");
        assertNull(deque.get(2), "Element at index 2 should be null (out of bounds).");
    }

    @Test
    public void testSize() {
        assertEquals(0, deque.size(), "Size should be 0 initially.");
        deque.addFirst(90);
        assertEquals(1, deque.size(), "Size should be 1 after adding one element.");
        deque.addLast(100);
        assertEquals(2, deque.size(), "Size should be 2 after adding another element.");
        deque.removeFirst();
        assertEquals(1, deque.size(), "Size should be 1 after removing one element.");
        deque.removeLast();
        assertEquals(0, deque.size(), "Size should be 0 after removing all elements.");
    }

    @Test
    public void testPrintDeque() {
        // This test is more about ensuring no exceptions are thrown.
        deque.addFirst(110);
        deque.addLast(120);
        deque.printDeque(); // Just to see if it prints without errors.
    }
}
