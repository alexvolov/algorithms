package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.Stack;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.AdjacencyList;
import com.alexvolov.ads.ds.impl.LinkedListStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A strongly connected component of the graph is a maximal
 * set of vertices in which there is a path from any vertex
 * to any other vertex in both directions.
 *
 * There are several common approaches that can decompose
 * graph into SCC in linear time. First one called Kosaraju's
 * algorithm and second one is Tarjan's strongly connected
 * components algorithm.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 01.03.15
 */
public class StronglyConnectedComponents {

    private static int preCount;

    /**
     * Kosaraju's algorithm requires two passes of
     * depth-first search to make a decomposition.
     *
     * @param graph given graph.
     * @return List of components.
     */
    public static List<List<Integer>> kosarajuSCC(Graph graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[graph.getSize()];

        // calculate finish time.
        List<Integer> sorted = new ArrayList<Integer>();
        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i]) {
                kosarajuDfs(graph, i, visited, sorted);
            }
        }
        Collections.reverse(sorted);

        // transpose graph.
        Graph reversedGraph = new AdjacencyList(graph.getSize(), GraphType.SIMPLE_DIRECTED);
        for (int i = 0; i < graph.getSize(); i++) {
            for (Integer n : graph.getNeighbours(i)) {
                reversedGraph.addEdge(n, i);
            }
        }

        // decompose into strongly connected components
        visited = new boolean[graph.getSize()];
        for (Integer s : sorted) {
            if (!visited[s]) {
                List<Integer> component = new ArrayList<Integer>();
                kosarajuDfs(reversedGraph, s, visited, component);
                result.add(component);
            }
        }

        return result;
    }

    /**
     * Another approach was proposed by american mathematician
     * Robert Tarjan and it's also based on depth-first search
     * algorithm. The vertices are indexed as they are traversed
     * by DFS. While returning from the recursion of DFS, every
     * vertex V gets assigned a vertex L as a representative. L
     * is a vertex with the least index that can be reach from V.
     * Nodes with the same representative assigned are located in
     * the same strongly connected component.
     *
     * @param graph given graph.
     * @return List of components.
     */
    public static List<List<Integer>> tarjanSCC(Graph graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int[] low = new int[graph.getSize()];
        boolean[] visited = new boolean[graph.getSize()];
        Stack<Integer> stack = new LinkedListStack<Integer>();

        for (int v = 0; v < graph.getSize(); v++) {
            if (!visited[v]) {
                tarjanDfs(graph, v, stack, low, visited, result);
            }
        }

        return result;
    }

    private static void tarjanDfs(Graph graph, int v, Stack<Integer> stack, int[] low, boolean[] visited,
                                  List<List<Integer>> result) {
        low[v] = preCount++;
        visited[v] = true;
        stack.push(v);
        int min = low[v];
        for (int w : graph.getNeighbours(v))
        {
            if (!visited[w])
                tarjanDfs(graph, w, stack, low, visited, result);
            if (low[w] < min)
                min = low[w];
        }
        if (min < low[v])
        {
            low[v] = min;
            return;
        }
        List<Integer> component = new ArrayList<Integer>();
        int w;
        do
        {
            w = stack.pop();
            component.add(w);
            low[w] = graph.getSize();
        } while (w != v);
        result.add(component);
    }

    private static void kosarajuDfs(Graph graph, Integer node, boolean[] visited, List<Integer> sorted) {
        visited[node] = true;
        for(Integer n : graph.getNeighbours(node)) {
            if (!visited[n]) {
                kosarajuDfs(graph, n, visited, sorted);
            }
        }
        sorted.add(node);
    }

}
