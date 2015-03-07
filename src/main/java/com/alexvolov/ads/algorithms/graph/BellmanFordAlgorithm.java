package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.GraphEdge;
import com.alexvolov.ads.ds.common.GraphType;

import java.util.Arrays;

/**
 * The Bellman-Ford algorithm solves single-source shortest path
 * problem in a directed graph with negative and positive weights.
 * Its time complexity in worst case is equal to O(V*E) while
 * Dijkstra's algorithm has O((V+E)log V) time complexity. Thus,
 * if you don't have negative weights it's preferable to use
 * Dijkstra's algorithm.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 07.03.15
 */
public class BellmanFordAlgorithm {

    private static int INFINITY = Integer.MAX_VALUE;

    /**
     * Return shortest distance for all vertices from singe source.
     *
     * @param graph on which Dijkstra's algorithm is applied to.
     * @param source a starting node.
     * @return predecessor array.
     */
    public static int[] getShortestPath(Graph graph, int source) {
        if (graph.getType() != GraphType.WEIGHTED_DIRECTED) {
            throw new IllegalArgumentException("Wrong type of graph. Graph must be directed and weighted.");
        }

        // prepare initial data
        int[] distance = new int[graph.getSize()];
        int[] predecessor = new int[graph.getSize()];
        Arrays.fill(distance, INFINITY);
        distance[source] = source;

        // relax edges
        for (int i = 1; i < graph.getSize(); i++) {
            for (GraphEdge edge : graph.getEdges().keySet()) {
                System.out.println(edge.getSource() + "-->" + edge.getDestination());
                int weight = distance[edge.getSource()] + graph.getEdges().get(edge);
                if (distance[edge.getSource()] != INFINITY && weight < distance[edge.getDestination()]) {
                    distance[edge.getDestination()] = weight;
                    predecessor[edge.getDestination()] = edge.getSource();
                }
            }
        }

        // Check for a negative-weight cycle
        for (GraphEdge edge : graph.getEdges().keySet()) {
            int weight = distance[edge.getSource()] + graph.getEdges().get(edge);
            if (weight < distance[edge.getDestination()]) {
                throw new RuntimeException("Graph contains a negative-weight cycle");
            }
        }

        return predecessor;
    }

}
