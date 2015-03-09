package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.AlgorithmException;
import com.alexvolov.ads.ds.common.GraphEdge;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.AdjacencyList;
import com.alexvolov.ads.ds.impl.AdjacencyMatrix;
import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *  Test class for {@link com.alexvolov.ads.algorithms.graph.JohnsonsAlgorithm}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 09.03.15
 */
public class JohnsonsAlgorithmTest{

    private static final int INF = Integer.MAX_VALUE;

    @Test
    public void test_getAllPaths() throws AlgorithmException {
        // data
        int[][] expected = new int[][] {
                {0, 4, 3, 6, 7, 11, INF, INF, 0},
                {INF, 0, 10, 2, 3, 18, INF, INF, 0},
                {INF, INF, 0, INF, INF, 8, INF, INF, 0},
                {INF, INF, INF, 0, INF, INF, INF, INF, 0},
                {INF, INF, 7, INF, 0, 15, INF, INF, 0},
                {INF, INF, INF, INF, INF, 0, INF, INF, 0},
                {INF, INF, 13, 5, 6, 7, 0, 6, 0},
                {INF, INF, 11, INF, 4, 1, INF, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0 , 0}
            };

        // prepare
        Graph graph = new AdjacencyMatrix(9, GraphType.WEIGHTED_DIRECTED);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 5, 8);
        graph.addEdge(4, 2, 7);
        graph.addEdge(6, 3, 5);
        graph.addEdge(6, 4, 6);
        graph.addEdge(6, 8, 4);
        graph.addEdge(7, 4, 4);
        graph.addEdge(7, 5, 1);
        graph.addEdge(8, 7, 2);

        // test
        int[][] actual = JohnsonsAlgorithm.getAllPaths(graph);

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void test_getAllPaths_list() throws AlgorithmException {
        // data
        int[][] expected = new int[][] {
                {0, 4, 3, 6, 7, 11, INF, INF, 0},
                {INF, 0, 10, 2, 3, 18, INF, INF, 0},
                {INF, INF, 0, INF, INF, 8, INF, INF, 0},
                {INF, INF, INF, 0, INF, INF, INF, INF, 0},
                {INF, INF, 7, INF, 0, 15, INF, INF, 0},
                {INF, INF, INF, INF, INF, 0, INF, INF, 0},
                {INF, INF, 13, 5, 6, 7, 0, 6, 0},
                {INF, INF, 11, INF, 4, 1, INF, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0 , 0}
        };

        // prepare
        Graph graph = new AdjacencyList(9, GraphType.WEIGHTED_DIRECTED);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 5, 8);
        graph.addEdge(4, 2, 7);
        graph.addEdge(6, 3, 5);
        graph.addEdge(6, 4, 6);
        graph.addEdge(6, 8, 4);
        graph.addEdge(7, 4, 4);
        graph.addEdge(7, 5, 1);
        graph.addEdge(8, 7, 2);

        // test
        int[][] actual = new JohnsonsAlgorithm().getAllPaths(graph);

        // verify
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getAllPaths_exc() throws AlgorithmException {
        // prepare
        Graph graph = new AdjacencyList(9, GraphType.SIMPLE_UNDIRECTED);

        // test
        JohnsonsAlgorithm.getAllPaths(graph);
    }

}
