package com.alexvolov.ads.ds;

/**
 * Stack is one of the basic data structure which
 * implements ordering principle LIFO or last-in first-out.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 23.01.15
 */
public interface Stack<T> {

    /**
     * Adds a new element to the stack.
     *
     * @param value any object.
     */
    void push(T value);

    /**
     * Removes top element from the stack.
     *
     * @return removed element. Returns {@code null}
     *         even if array is empty.
     */
    T pop();

    /**
     * Returns top element without removal.
     *
     * @return top element value.
     *         Returns {@code null} even if array is empty.
     */
    T peek();

    /**
     * Checks whether stack is empty.
     *
     * @return {@code true} if empty, otherwise {@code false}.
     */
    boolean isEmpty();

}
