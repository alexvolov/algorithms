package com.alexvolov.ads.ds;

/**
 * In computing, a disjoint-set data structure, also called a
 * union–find data structure or merge–find set, is a data structure
 * that keeps track of a set of elements partitioned into a number
 * of disjoint (nonoverlapping) subsets.ss
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 12.03.15
 */
public interface DisjointSets {

    /**
     * Unites two disjoint sets into a single set.
     *
     * @param x the root of the first set.
     * @param y the root of the second set.
     */
    public void union(int x, int y);

    /**
     * Links set x with set y.
     *
     * @param x set.
     * @param y set.
     */
    public void link(int x, int y);

    /**
     * Returns {@code int} name of the set containing a given element.
     *
     * @param x searching element.
     * @return the set's name that containing x.
     */
    public int find(int x);

}
