package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.Heap;
import com.alexvolov.ads.ds.common.HeapType;
import com.alexvolov.ads.ds.impl.BinaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Searching the shortest path between two vertices is a very common problem
 * when you are dealing with graphs. This problem can be solved by various
 * algorithms and this is implementation of Dijkstra's algorithm.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 03.03.15
 */
public class DijkstrasAlgorithm {

    private static int INFINITY = Integer.MAX_VALUE;

    /**
     * Return shortest distance for all vertices from singe source.
     *
     * @param graph on which Dijkstra's algorithm is applied to.
     * @param source staring vertex.
     * @return array of shortest distances.
     */
    public static int[] getShortestPath(Graph graph, int source) {
        int[] distance = new int[graph.getSize()];
        int[] prev = new int[graph.getSize()];
        PriorityQueue<Distance> queue = new PriorityQueue<Distance>();

        Arrays.fill(distance, INFINITY);
        distance[source] = 0;
        queue.offer(new Distance(source, 0));

        while (!queue.isEmpty()) {
            Distance current = queue.poll();
            for (Integer n : graph.getNeighbours(current.getVertex())) {
                int weight = graph.getWeight(current.getVertex(), n) + distance[current.getVertex()];
                if (distance[current.getVertex()] != INFINITY && weight < distance[n]) {
                    distance[n] = weight;
                    prev[n] = current.getVertex();
                    Distance newDistance = new Distance(n, weight);
                    if (queue.contains(newDistance)) {
                        queue.remove(newDistance);
                    }
                    queue.offer(newDistance);
                }
            }
        }

        return distance;
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
