package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Stack;

/**
 * This implementation of the stack data structure is based
 * on linked list.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 23.01.15
 */
public class LinkedListStack<T> implements Stack<T> {

    private Entry top;

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T value) {
        top = new Entry(top, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T pop() {
        if (top != null) {
            T value = top.getValue();
            top = top.getNext();
            return value;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T peek() {
        T result = null;
        if (null != top) {
            result = top.getValue();
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return null == top;
    }

    /**
     * An entry of linked list.
     */
    private class Entry {
        private Entry next;
        private T value;

        /**
         * Constructor.
         *
         * @param next   link to the next element.
         * @param value  value of the element.
         */
        public Entry(Entry next, T value) {
            this.next = next;
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }
    }

}
