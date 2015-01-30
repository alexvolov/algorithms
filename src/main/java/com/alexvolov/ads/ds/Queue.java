package com.alexvolov.ads.ds;

/**
 * Queue is a data structure which implements ordering
 * principle FIFO or first-in first-out. The essence of the
 * principle FIFO is that the first element added to the queue
 * will be the first one to be removed.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public interface Queue<T> {

    /**
     * Adds a new element to the queue.
     *
     * @param item any object.
     */
    void enqueue(T item);

    /**
     * Removes element from the queue.
     *
     * @return removed element.
     */
    T dequeue();

    /**
     * Checks whether the queue is empty.
     *
     * @return <code>true</code> if empty, otherwise <code>false</code>.
     */
    boolean isEmpty();

}
