package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Deque;

/**
 * An implementation of the deque data structure which is
 * based on array and doesn't support resizing.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class ArrayDeque<T> implements Deque<T> {

    private T[] deque;
    private int frontIndex, backIndex;

    /**
     * Constructor.
     *
     * @param capacity max number of the elements in deque.
     */
    @SuppressWarnings("unchecked")
    public ArrayDeque(int capacity) {
        if (capacity > 0) {
            deque = (T[]) new Object[capacity];
            frontIndex = -1;
            backIndex = -1;
        } else {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pushBack(T item) {
        if (decrement(backIndex) != frontIndex) {
            backIndex = decrement(backIndex);
            deque[backIndex] = item;
            if (frontIndex == -1) {
                frontIndex = backIndex;
            }
        } else {
            throw new RuntimeException("Deque is full.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T popBack() {
        T result = null;
        if (backIndex != -1) {
            result = deque[backIndex];
            if (backIndex == frontIndex) {
                frontIndex = backIndex = -1;
            } else {
                backIndex = increment(backIndex);
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pushFront(T item) {
        if (increment(frontIndex) != backIndex) {
            frontIndex = increment(frontIndex);
            deque[frontIndex] = item;
            if (backIndex == -1) {
                backIndex = frontIndex;
            }
        } else {
            throw new RuntimeException("Deque is full.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T popFront() {
        T result = null;
        if (frontIndex != -1) {
            result = deque[frontIndex];
            if (frontIndex == backIndex) {
                frontIndex = backIndex = -1;
            } else {
                frontIndex = decrement(frontIndex);
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return frontIndex == -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T peekFront() {
        T result = null;
        if (frontIndex != -1) {
            return deque[frontIndex];
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T peekBack() {
        T result = null;
        if (backIndex != -1) {
            return deque[backIndex];
        }
        return result;
    }

    private int increment(int value) {
        if (value + 1 >= deque.length) {
            value = 0;
        } else {
            value++;
        }
        return value;
    }

    private int decrement(int value) {
        if (value - 1 <= -1) {
            value = deque.length - 1;
        } else {
            value--;
        }
        return value;
    }


}
