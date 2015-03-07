package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.Heap;
import com.alexvolov.ads.ds.common.HeapType;
import com.alexvolov.ads.ds.impl.BinaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Heap heap = new BinaryHeap(graph.getSize(), HeapType.MIN_HEAP);

        for (int i = 0; i < graph.getSize(); i++) {
            distance[i] = INFINITY;
            heap.insert(i);
        }

        distance[source] = source;

        while (!heap.isEmpty()) {
            int current = heap.deleteTop();
            for (Integer n : graph.getNeighbours(current)) {
                int weight = graph.getWeight(current, n) + distance[current];
                if (distance[current] != INFINITY && weight < distance[n]) {
                    distance[n] = weight;
                    prev[n] = current;
                }
            }
        }

        return distance;
    }

}
