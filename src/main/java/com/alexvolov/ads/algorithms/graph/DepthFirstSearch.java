package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.Stack;
import com.alexvolov.ads.ds.impl.LinkedListStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Depth-First search. It is not exactly search, it is traversal,
 * but it can be easy changed to search =). I just wanted to show
 * an idea of algorithm.
 *
 * Here I've implemented both recursive and iterative versions.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 21.02.15
 */
public class DepthFirstSearch {

    private List<Integer> visited;
    private Graph graph;

    /**
     * Iteratively traverses given graph using Depth-First search.
     *
     * @param graph a graph object.
     * @param node a starting vertex
     *
     * @return {@code List} of visited vertices in order of visits.
     */
    public List<Integer> iterativeSearch(Graph graph, Integer node) {
        if (null == graph) {
            throw new NullPointerException("Graph cannot be null.");
        }
        this.graph = graph;
        visited = new ArrayList<Integer>();

        Stack<Integer> stack = new LinkedListStack<Integer>();
        Stack<Integer> auxStack;
        stack.push(node);

        while(!stack.isEmpty()){
            Integer v = stack.pop();
            if(!visited.contains(v)) {
                visited.add(v);
                auxStack = new LinkedListStack<Integer>();
                for(Integer w : graph.getNeighbours(v)){
                    if(!visited.contains(w)){
                        auxStack.push(w);
                    }
                }
                while(!auxStack.isEmpty()){
                    stack.push(auxStack.pop());
                }
            }
        }

        return visited;
    }

    /**
     * Recursively traverses given graph using Depth-First search.
     *
     * @param graph a graph object.
     * @param root a starting vertex
     *
     * @return {@code List} of visited vertices in order of visits.
     */
    public List<Integer> recursiveSearch(Graph graph, Integer root) {
        if (null == graph) {
            throw new NullPointerException("Graph cannot be null.");
        }
        this.graph = graph;
        visited = new ArrayList<Integer>();
        recursiveSearch(root);
        return visited;
    }

    private void recursiveSearch(Integer root) {
        visited.add(root);
        for(Integer n : graph.getNeighbours(root)) {
            if (!visited.contains(n)) {
                recursiveSearch(n);
            }
        }
    }

}
