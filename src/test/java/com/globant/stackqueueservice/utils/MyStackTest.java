package com.globant.stackqueueservice.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStackTest {

    @Test
    public void testPush() {
        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThrows(RuntimeException.class, () -> {
            stack.push(4);
        });
    }

    @Test
    public void testPop() {
        MyStack<Integer> stack = new MyStack<>(3);
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        stack.push(one);
        stack.push(two);
        stack.push(three);
        assertEquals(three, stack.pop());
        assertEquals(two, stack.pop());
        assertEquals(one, stack.pop());
        assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void testPeek() {
        MyStack<Integer> stack = new MyStack<>(3);
        Integer one = 1;
        Integer two = 2;
        stack.push(one);
        stack.push(two);
        assertEquals(two, stack.peek());
        assertEquals(two, stack.peek());
        assertEquals(two, stack.pop());
        assertEquals(one, stack.peek());
        assertEquals(one, stack.peek());
        assertEquals(one, stack.pop());
        assertThrows(RuntimeException.class, () -> {
            stack.peek();
        });
    }

    @Test
    public void testIsEmpty() {
        MyStack<Integer> stack = new MyStack<>(3);
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        MyStack<Integer> stack = new MyStack<>(3);
        assertFalse(stack.isFull());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
        stack.pop();
        assertFalse(stack.isFull());
    }

}
