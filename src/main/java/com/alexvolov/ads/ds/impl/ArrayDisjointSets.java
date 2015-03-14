package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.DisjointSets;

import java.util.Arrays;

/**
 * Array implementation of disjoint sets data structure.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 12.03.15
 */
public class ArrayDisjointSets implements DisjointSets {

    private int[] array;

    /**
     * Creates an instance of a disjoint sets object.
     *
     * @param capacity number of elements.
     */
    public ArrayDisjointSets(int capacity) {
        array = new int [capacity];
        Arrays.fill(array, -1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void union(int x, int y) {
        link(find(x), find(y));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void link(int x, int y) {
        if (array[x] > array[y]) {
            array[x] = y;
        } else {
            if (array[x] == array[y]) {
                array[x]--;
            }
            array[y] = x;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int find(int x) {
        if (array[x] < 0) {
            return x;
        } else {
            array[x] = find(array[x]);
            return array[x];
        }
    }

}
