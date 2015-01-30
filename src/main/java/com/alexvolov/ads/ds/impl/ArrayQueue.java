package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Queue;

/**
 * This is a simple implantation of the queue data structure
 * which is based on array. Please be aware that this implementation
 * doesn't support resizing.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;
    private int currentSize;
    private int front;
    private int back;

    /**
     * Constructor.
     *
     * @param capacity any number greater than zero.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity > 0) {
            queue = (T[])new Object[capacity];
            currentSize = 0;
            front = 0;
            back = -1;
        } else {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueue(T item) {
        if (currentSize >= queue.length) {
            throw new RuntimeException("Queue is full");
        } else {
            if (++back == queue.length) {
                back = 0;
            }
            queue[back] = item;
            currentSize++;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T dequeue() {
        T result = null;
        if (!isEmpty()) {
            result = queue[front];
            queue[front] = null;
            if (++front == queue.length) {
                front = 0;
            }
            currentSize--;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

}
