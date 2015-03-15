package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.DisjointSets;
import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.GraphEdge;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.ArrayDisjointSets;
import java.util.*;

/**
 * Kruskal’s algorithm is used to find minimum spanning tree in a
 * weighted undirected graph. A spanning tree of a undirected graph
 * G is a sub-graph that includes all vertices of G and satisfies
 * conditions of a tree.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 12.03.15
 */
public class KruskalsAlgorithm {

    /**
     * Searches minimum spanning tree in a given graph using
     * Kruskal's algorithm.
     *
     * @param graph given graph.
     * @return s list of edges that forms a minimum spanning tree.
     */
    public static List<GraphEdge> getMST(Graph graph) {
        if (!graph.getType().equals(GraphType.WEIGHTED_UNDIRECTED)) {
            throw new IllegalArgumentException("Wrong type of the graph. Weighted undirected graph is expected.");
        }

        // Make disjoint set
        DisjointSets disjointSets = new ArrayDisjointSets(graph.getSize());

        // Sort edges
        WeightComparator weightComparator = new WeightComparator(graph.getEdges());
        Map<GraphEdge, Integer> sortedEdges = new TreeMap<GraphEdge, Integer>(weightComparator);
        sortedEdges.putAll(graph.getEdges());
        List<GraphEdge> result = new ArrayList<GraphEdge>();

        // Find MST
        for (Map.Entry<GraphEdge, Integer> edge : sortedEdges.entrySet()) {
            if (disjointSets.find(edge.getKey().getSource()) != disjointSets.find(edge.getKey().getDestination())) {
                result.add(edge.getKey());
                disjointSets.union(edge.getKey().getSource(), edge.getKey().getDestination());
            }
        }
        return result;
    }

    private static class WeightComparator implements Comparator<GraphEdge> {

        Map<GraphEdge, Integer> base;
        public WeightComparator(Map<GraphEdge, Integer> base) {
            this.base = base;
        }

        public int compare(GraphEdge a, GraphEdge b) {
            if (base.get(a) >= base.get(b)) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
