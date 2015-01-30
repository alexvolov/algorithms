package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Deque;

/**
 * An implementation of the deque data structure which is
 * based on linked list.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public class LinkedListDeque<T> implements Deque<T> {

    private Entry front, back;

    /**
     * Adds a new element to the back of the deque.
     *
     * @param item any object.
     */
    public void pushBack(T item) {
        if (back == null) {
            front = new Entry(item);
            back = front;
        } else {
            Entry newNode = new Entry(item);
            newNode.setPrevious(back);
            back.setNext(newNode);
            back = newNode;
        }
    }

    /**
     * Adds a new element to the front of the deque.
     *
     * @param item any object.
     */
    public void pushFront(T item) {
        if (front == null) {
            front = new Entry(item);
            back = front;
        } else {
            Entry newNode = new Entry(item);
            newNode.setNext(front);
            front.setPrevious(newNode);
            front = newNode;
        }
    }

    /**
     * Removes element from the back.
     *
     * @return removed element.
     */
    public T popBack() {
        if (back != null) {
            T item = back.getValue();
            back = back.getPrevious();
            if (back == null) {
                front = null;
            } else {
                back.setNext(null);
            }
            return item;
        }
        return null;
    }

    /**
     * Removes element from the front.
     *
     * @return removed element.
     */
    public T popFront() {
        if (front != null) {
            T item = front.getValue();
            if (null != front.getNext()) {
                front = front.getNext();
                front.setPrevious(null);
            } else {
                front = null;
                back = null;
            }
            return item;
        }
        return null;
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return <code>true</code> if empty, otherwise <code>false</code>.
     */
    public boolean isEmpty() {
        return null == front;
    }

    /**
     * Returns front element.
     *
     * @return front element.
     */
    public T peekFront() {
        T result = null;
        if (null != front.getValue()) {
            result = front.getValue();
        }
        return result;
    }

    /**
     * Returns back element.
     *
     * @return back element.
     */
    public T peekBack() {
        T result = null;
        if (null != back.getValue()) {
            result = back.getValue();
        }
        return result;
    }

    /**
     * An entry of linked list.
     */
    private class Entry {
        private Entry next, previous;
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

        public Entry getPrevious() {
            return previous;
        }

        public void setPrevious(Entry previous) {
            this.previous = previous;
        }
    }

}
