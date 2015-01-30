package com.alexvolov.ads.ds;

/**
 * Binary heap is a tree-like data structure that generally can be
 * separated into two types: min-heap and max-heap. The difference
 * is that in the max-heap all nodes are greater than or equal to
 * each of it’s children. In the min-heap everything is vise versa,
 * all nodes are less than or equal to each of its children. Thus,
 * the highest (max-heap) or lowest (min-heap) element is always
 * on the top and this is the main advantage which provides
 * possibility to access the min or the max element in constant time.
 * Another important property is that all levels, except the last
 * last one, must be full.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 24.01.15
 */
public interface Heap {

    /**
     * Adds a new element into the heap.
     *
     * @param value - new value.
     */
    void insert(int value);

    /**
     * Creates a new heap from given array of elements.
     *
     * @param array array of elements.
     */
    void heapify(Integer[] array);

    /**
     * Returns maximum element of the heap.
     *
     * @return - the largest element in the heap.
     */
    Integer findMax();

    /**
     * Returns maximum element of the heap and removing the item from the heap.
     *
     * @return the largest element.
     */
    Integer deleteMax();

    /**
     * Checks whether the heap is empty.
     *
     * @return <code>true</code> if empty, otherwise <code>false</code>.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the heap.
     *
     * @return number of elements in the heap.
     */
    int getSize();

}
