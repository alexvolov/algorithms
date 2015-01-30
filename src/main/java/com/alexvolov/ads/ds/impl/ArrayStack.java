package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Stack;

/**
 * This implementation of the stack data structure is based
 * on array. Also, my implementation doesn't support resizing.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 23.01.15
 */
public class ArrayStack<T> implements Stack<T>  {

    private int topIndex;
    private T[] stack;

    /**
     * Creates a new instance of the array based stack.
     *
     * @param capacity any number greater than zero.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        if (capacity > 0) {
            this.topIndex = -1;
            stack = (T[]) new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T value) {
        if (topIndex >= stack.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++topIndex] = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T pop() {
        T result = null;
        if (topIndex != -1) {
            result = stack[topIndex--];
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T peek() {
        T result = null;
        if (topIndex != -1) {
            result = stack[topIndex];
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return -1 == topIndex;
    }

}
