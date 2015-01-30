package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Queue;

/**
 * This is a simple implantation of the queue data structure
 * which is based on linked list.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class LinkedListQueue<T> implements Queue<T> {

    private Entry first, last;

    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueue(T item) {
        if (first == null) {
            last = new Entry(item);
            first = last;
        } else {
            last.setNext(new Entry(item));
            last = last.getNext();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T dequeue() {
        if (first != null) {
            T item = first.getValue();
            first = first.getNext();
            return item;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return null == first;
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
         * @param value value of the element.
         */
        public Entry(T value) {
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

    }

}
