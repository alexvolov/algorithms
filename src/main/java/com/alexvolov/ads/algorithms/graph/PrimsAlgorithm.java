package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.GraphEdge;
import com.alexvolov.ads.ds.common.GraphType;

import java.util.*;

/**
 * Prim's algorithm searches minimum spanning tree in a weighted
 * undirected graph. In other words, it finds a sub-set of edges
 * that forms a tree, where all vertices of a given graph are
 * included and total weight of all edges is minimized.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 15.03.15
 */
public class PrimsAlgorithm {

    private static int INFINITY = Integer.MAX_VALUE;

    /**
     * Searches minimum spanning tree in a given graph using
     * Prim's algorithm.
     *
     * @param graph given graph.
     * @return s list of edges that forms a minimum spanning tree.
     */
    public static Set<GraphEdge> getMST(Graph graph) {

        if (!graph.getType().equals(GraphType.WEIGHTED_UNDIRECTED)) {
            throw new IllegalArgumentException("Wrong type of the graph. Weighted undirected graph is expected.");
        }

        Set<GraphEdge> result = new HashSet<GraphEdge>();
        int[] distance = new int[graph.getSize()];
        PriorityQueue<Distance> queue = new PriorityQueue<Distance>();

        for (int i = 0; i < graph.getSize(); i++) {
            distance[i] = INFINITY;
            queue.offer(new Distance(i, INFINITY));
        }

        // Starting vertex
        distance[0] = 0;
        queue.offer(new Distance(0, 0));

        while (!queue.isEmpty()) {
            Distance current = queue.poll();
            for (Integer n : graph.getNeighbours(current.getVertex())) {
                int weight = graph.getWeight(current.getVertex(), n);
                if (queue.contains(new Distance(n, weight)) && weight < distance[n]) {
                    distance[n] = weight;
                    result.add(new GraphEdge(current.getVertex(), n));
                }
            }
        }

        return result;
    }

    private static class Distance implements Comparable<Distance> {

        private int vertex;
        private int distance;

        /**
         * Constructs a new object with given values.
         *
         * @param vertex vertex id.
         * @param distance distance to vertex
         */
        private Distance(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int getVertex() {
            return vertex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Distance distance = (Distance) o;

            if (vertex != distance.vertex) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return vertex;
        }

        @Override
        public int compareTo(Distance o) {
            return this.distance < o.distance ? -1 : this.distance == o.distance ? 0 : 1;
        }
    }

}
