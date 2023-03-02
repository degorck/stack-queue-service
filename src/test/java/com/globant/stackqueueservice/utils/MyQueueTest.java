package com.globant.stackqueueservice.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyQueueTest {

    @Test
    public void testAdd() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertThrows(RuntimeException.class, () -> {
            queue.add(4);
        });
    }

    @Test
    public void testPoll() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        queue.add(one);
        queue.add(two);
        queue.add(three);
        assertEquals(one, queue.poll());
        assertEquals(two, queue.poll());
        assertEquals(three, queue.poll());
        assertThrows(RuntimeException.class, () -> {
            queue.poll();
        });
    }

    @Test
    public void testPeek() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        Integer one = 1;
        Integer two = 2;
        queue.add(one);
        queue.add(two);
        assertEquals(one, queue.peek());
        assertEquals(one, queue.peek());
        assertEquals(one, queue.poll());
        assertEquals(two, queue.peek());
        assertEquals(two, queue.peek());
        assertEquals(two, queue.poll());
        assertThrows(RuntimeException.class, () -> {
            queue.peek();
        });
    }

    @Test
    public void testIsEmpty() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        assertTrue(queue.isEmpty());
        queue.add(1);
        assertFalse(queue.isEmpty());
        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        assertFalse(queue.isFull());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertTrue(queue.isFull());
        queue.poll();
        assertFalse(queue.isFull());
    }

    @Test
    public void testSize() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        assertEquals(0, queue.size());
        queue.add(1);
        queue.add(2);
        assertEquals(2, queue.size());
        queue.poll();
        assertEquals(1, queue.size());
        queue.add(3);
        assertEquals(2, queue.size());
        queue.poll();
        queue.poll();
        assertEquals(0, queue.size());
    }
}
