package com.alexvolov.ads.ds;

/**
 * Deque or double-ended queue is almost the same as the queue. But,
 * the main difference is that it provides possibility to add and
 * remove elements from both sides of the queue. In other words it
 * combines FIFO and LIFO principles.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public interface Deque<T> {

    /**
     * Adds a new element to the back of the deque.
     *
     * @param item any object.
     */
    void pushBack(T item);

    /**
     * Removes element from the back.
     *
     * @return removed element.
     */
    T popBack();

    /**
     * Adds a new element to the front of the deque.
     *
     * @param item any object.
     */
    void pushFront(T item);

    /**
     * Removes element from the front.
     *
     * @return removed element.
     */
    T popFront();

    /**
     * Checks whether the queue is empty.
     *
     * @return <code>true</code> if empty, otherwise <code>false</code>.
     */
    boolean isEmpty();

    /**
     * Returns front element.
     *
     * @return front element.
     */
    T peekFront();

    /**
     * Returns back element.
     *
     * @return back element.
     */
    T peekBack();

}
