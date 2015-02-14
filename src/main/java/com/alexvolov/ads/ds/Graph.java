package com.alexvolov.ads.ds;

import java.util.Set;

/**
 * Graph is a collection of vertices connected to each other through edges.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 09.02.15
 */
public interface Graph {

    /**
     * Connects two vertices.
     *
     * @param i origin vertex.
     * @param j destination vertex.
     */
    void addEdge(int i, int j);

    /**
     * Connects two vertices using weight.
     *
     * @param i origin vertex.
     * @param j destination vertex.
     * @param weight cost/weight of the edge.
     */
    void addEdge(int i, int j, Integer weight);

    /**
     * Returns a set of vertices that are connected to the given
     * vertex.
     *
     * @param vertex given vertex.
     * @return a {@code Set} of vertices.
     */
    Set<Integer> getNeighbours(int vertex);

    /**
     * Returns  number of edges in graph.
     *
     * @return {@code int} value.
     */
    int getNumberOfEdges();

    /**
     * Returns number of vertices in the graph.
     *
     * @return {@code int} value.
     */
    int getSize();

    /**
     * Checks whether two vertices connected to each other.
     *
     * @param i vertex one.
     * @param j vertex two.
     *
     * @return {@code true} if connected, otherwise {@code false}.
     */
    boolean isAdjacent(int i, int j);

    /**
     * Removes edge from the graph.
     *
     * @param i origin vertex.
     * @param j destination vertex.
     */
    void removeEdge(int i, int j);

}
