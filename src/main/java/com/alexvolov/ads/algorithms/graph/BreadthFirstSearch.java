package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.Queue;
import com.alexvolov.ads.ds.impl.LinkedListQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Breadth-First search. It is not exactly search, it is traversal,
 * but it can be easy changed to search =).
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 19.02.15
 */
public class BreadthFirstSearch {

    /**
     * Traverses the graph using BFS algorithm.
     *
     * @param graph given graph.
     * @param vertex starting node.
     *
     * @return return a list of visited vertices.
     */
    public static List<Integer> traverse(Graph graph, int vertex) {
        List<Integer> visited = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedListQueue<Integer>();

        queue.enqueue(vertex);
        visited.add(vertex);

        while (!queue.isEmpty()) {
            Integer v = queue.dequeue();
            for (Integer neighbour : graph.getNeighbours(v)) {
                if (!visited.contains(neighbour)) {
                    queue.enqueue(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return visited;
    }

}
