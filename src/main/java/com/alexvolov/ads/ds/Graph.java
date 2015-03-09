package com.alexvolov.ads.ds;

import com.alexvolov.ads.ds.common.GraphEdge;
import com.alexvolov.ads.ds.common.GraphType;

import java.util.List;
import java.util.Map;
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

    /**
     * Returns set of nodes without ancestors.
     *
     * @return {@code Set} of vertices.
     */
    Set<Integer> getStartNodes();

    /**
     * Checks whether the vertex has any parents;
     *
     * @param v given vertex.
     *
     * @return {@code true} if hase, otherwise {@code false}.
     */
    boolean hasParents(Integer v);

    /**
     * Returns type of the graph.
     *
     * @return {@code GraphType} enumeration.
     */
    GraphType getType();

    /**
     * Returns weight between two vertices.
     *
     * @param source vertex.
     * @param destination vertex.
     * @return weight of type {@code int}.
     */
    int getWeight(int source, int destination);

    /**
     * Returns list of all edges.
     *
     * @return dictionary of {@code GraphEdge} objects, with weight's.
     */
    Map<GraphEdge, Integer> getEdges();

    /**
     * Adds a new vertex to the graph. Has O(N^2) complexity in case
     * of adjacency matrix implementation.
     *
     * @return vertex number of type {@code int}.
     */
    int addVertex();

    /**
     * Changes weight of an edge.
     *
     * @param source origin vertex.
     * @param destination destination vertex.
     * @param weight cost/weight of the edge.
     */
    void changeWeight(int source, int destination, Integer weight);

}
