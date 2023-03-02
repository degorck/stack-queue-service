package com.globant.stackqueueservice.utils;

/**
 * Creates a Stack.
 * @param <T> Generic object to work with the Stack.
 */
public class MyStack<T>  {
    private Object[] array;
    private int top;
    private int capacity;

    /**
     * Creates a Stack with capacity defined in @param capacity.
     * @param capacity Is the capacity of the Stack.
     */
    public MyStack(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.top = -1;
    }

    /**
     * Adds an object to the Stack.
     * @param item Is the object that are going to be added to the Stack.
     */
    public void push(T item) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        this.top++;
        this.array[top] = item;
    }

    /**
     * Gets the last Object of the Stack.
     * @return <T> The last object of the Stack.
     */
    public T pop() {
        T item;
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        item = (T)this.array[top];
        this.top--;
        return item;
    }

    /**
     * Gets the peek Object of the Stack.
     * @return <T> The peak Object of the Stack.
     */
    public T peek() {
        T obj;
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        obj = (T)this.array[top];
        return obj;
    }

    /**
     * Gets the boolean value of Stack isEmpty.
     * @return Boolean value if Stack isEmpty.
     */
    public boolean isEmpty() {
        return (this.top == -1);
    }

    /**
     * Gets the boolean value of Stack isFull.
     * @return Boolean value if Stack isFull.
     */
    public boolean isFull() {
        return (this.top == this.capacity - 1);
    }
}
