package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.Queue;
import com.alexvolov.ads.ds.common.AlgorithmException;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.LinkedListQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Besides, traversing and searching shortest path in a graph,
 * you can sort vertices in directed acyclic graph. This type
 * of sorting is called topological sort and it can be useful
 * in task scheduling application. The tasks can have
 * dependencies on other tasks. These dependencies can be
 * simple, then we can arrange the tasks in a linked list and
 * execute task one by one. In case if we have more that one
 * dependency, then we will use DAG, to represent these tasks.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 23.02.15
 */
public class TopologicalSort {

    /**
     * Kahn's topological sort. Be careful it remove edges in
     * the graph.
     *
     * @param graph to be sorted
     * @return List of sorted vertices.
     */
    public static List<Integer> kahnTopologicalSort(Graph graph) throws AlgorithmException {
        if (null == graph) {
            throw new IllegalArgumentException("Graph is null");
        }

        if (graph.getType() != GraphType.SIMPLE_DIRECTED && graph.getType() != GraphType.WEIGHTED_DIRECTED) {
            throw new IllegalArgumentException("Graph is no directed");
        }

        List<Integer> sorted = new ArrayList<Integer>();

        Queue<Integer> startNodes = new LinkedListQueue<Integer>();
        for (Integer i : graph.startNodes()) {
            startNodes.enqueue(i);
        }

        while (!startNodes.isEmpty()) {
            Integer s = startNodes.dequeue();
            sorted.add(s);
            for (Integer n : graph.getNeighbours(s)) {
                graph.removeEdge(s, n);
                if (!graph.hasParents(n)) {
                    startNodes.enqueue(n);
                }
            }
        }

        if (graph.getNumberOfEdges() > 0) {
            throw new AlgorithmException("A cycle has detected.");
        }

        return sorted;
    }

    /**
     * Topological sort algorithm that is based on Depth-first search.
     *
     * @param graph to be sorted.
     * @return list of sorted vertices
     */
    public static List<Integer> dfsTopologicalSort(Graph graph) {
        if (null == graph) {
            throw new IllegalArgumentException("Graph is null");
        }

        if (graph.getType() != GraphType.SIMPLE_DIRECTED && graph.getType() != GraphType.WEIGHTED_DIRECTED) {
            throw new IllegalArgumentException("Graph is no directed");
        }

        List<Integer> sorted = new ArrayList<Integer>();
        List<Integer> visited = new ArrayList<Integer>();

        for (Integer node : graph.startNodes()) {
            dfsSearch(graph, node, visited, sorted);
        }
        Collections.reverse(sorted);
        return sorted;
    }

    private static void dfsSearch(Graph graph, Integer node, List<Integer> visited, List<Integer> sorted) {
        visited.add(node);
        for(Integer n : graph.getNeighbours(node)) {
            if (!visited.contains(n)) {
                dfsSearch(graph, n, visited, sorted);
            }
        }
        sorted.add(node);
    }

}
