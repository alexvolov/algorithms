package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.AlgorithmException;
import com.alexvolov.ads.ds.common.GraphEdge;
import com.alexvolov.ads.ds.common.GraphType;

/**
 * Johnson's algorithm solves the all-pairs shortest path
 * problem. In other words, it searches for shortest distance
 * between every pair of vertices in a given graph.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 08.03.15
 */
public class JohnsonsAlgorithm {

    /**
     * Searches for shortest distance between every pair
     * of vertices in a given graph.
     *
     * @param graph givrn graph
     * @return V*V matrix with shortest distances.
     * @throws AlgorithmException if negative weight cycle is found.
     */
    public static int[][] getAllPaths(Graph graph) throws AlgorithmException {
        if (graph.getType() != GraphType.WEIGHTED_DIRECTED) {
            throw new IllegalArgumentException("Wrong type of graph. Graph must be directed and weighted.");
        }

        // Add new vertex to the graph and connect it to
        // all vertices in the graph.
        int newVertex = graph.addVertex();
        for (int i = 0; i < graph.getSize() - 1; i++) {
            if (newVertex != i) {
                graph.addEdge(newVertex, i, 0);
            }
        }

        // Calculate distance from new vertex to all others
        // using Bellman-Ford algorithm.
        BellmanFordAlgorithm bfa = new BellmanFordAlgorithm();
        bfa.getShortestPath(graph, newVertex);
        int[] distance = bfa.getDistance();

        // Re-weighting all weights basing on distance that
        // we get from Bellman-Ford algorithm.
        int weight;
        for (GraphEdge edge : graph.getEdges().keySet()) {
            weight = graph.getEdges().get(edge) + distance[edge.getSource()] - distance[edge.getDestination()];
            graph.changeWeight(edge.getSource(), edge.getDestination(), weight);
        }

        // Disconnect the new vertex.
        for (int n : graph.getNeighbours(newVertex)) {
            graph.removeEdge(newVertex, n);
        }

        // Run Dijkstra's algorithm
        int[][] result = new int[graph.getSize() - 1][graph.getSize() - 1];
        for (int i = 0; i < graph.getSize() - 2; i++) {
            distance = DijkstrasAlgorithm.getShortestPath(graph, i);
            for (int k = 0; k < distance.length - 2; k++) {
                result[i][k] = distance[k];
            }
        }

        return result;
    }

}
