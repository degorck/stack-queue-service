package com.globant.stackqueueservice.utils;

/**
 * Creates a Queue.
 * @param <T> Generic object to work with the Queue.
 */
public class MyQueue<T> {
    private Object[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    /**
     * Creates a Queue with capacity defined in @param capacity.
     * @param capacity Is the capacity of the Queue.
     */
    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    /**
     * Adds an object to the Queue.
     * @param item Is the object that are going to be added to the Queue.
     */
    public void add(T item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        this.rear++;
        if (this.rear == this.capacity) {
            this.rear = 0;
        }
        this.array[this.rear] = item;
        this.size++;
    }

    /**
     * Gets the front value of the Queue.
     * @return <T> The front object of the Queue.
     */
    public T poll() {
        T item;
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        item = (T)this.array[this.front];
        this.front++;
        if (this.front == this.capacity) {
            this.front = 0;
        }
        this.size--;
        return item;
    }

    /**
     * Gets the peek value of the Queue.
     * @return <T> The peak object of the Queue.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return (T)this.array[this.front];
    }

    /**
     * Gets the boolean value of Queue isEmpty.
     * @return Boolean value if Queue isEmpty.
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * Gets the boolean value of Queue isFull.
     * @return Boolean value if Queue isFull.
     */
    public boolean isFull() {
        return (this.size == this.capacity);
    }
    /**
     * Gets the int value of Queue size.
     * @return int size value of Queue.
     */
    public int size() {
        return this.size;
    }
}

