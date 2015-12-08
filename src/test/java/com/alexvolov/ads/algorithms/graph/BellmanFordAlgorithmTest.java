package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.common.AlgorithmException;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.AdjacencyList;
import com.alexvolov.ads.ds.impl.AdjacencyMatrix;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link com.alexvolov.ads.algorithms.graph.BellmanFordAlgorithm}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 07.03.15
 */
public class BellmanFordAlgorithmTest {

    @Test
    public void test_findShortestPathMatrix() throws AlgorithmException  {
        // data
        int[] expected = new int[]{0, 0, 0, 0, 1, 2, 5};

        // prepare
        Graph graph = new AdjacencyMatrix(7, GraphType.WEIGHTED_DIRECTED);
        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 2, 10);
        graph.addEdge(0, 3, 12);
        graph.addEdge(1, 4, 10);
        graph.addEdge(2, 5, 3);
        graph.addEdge(3, 6, 12);
        graph.addEdge(4, 3, 10);
        graph.addEdge(4, 6, 50);
        graph.addEdge(5, 6, 8);

        // test
        int[] actual = new BellmanFordAlgorithm().getShortestPath(graph, 0);

        // verify
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_wrongGraph() throws AlgorithmException  {
        // prepare
        Graph graph = new AdjacencyList(7, GraphType.SIMPLE_UNDIRECTED);

        // test
        int[] actual = new BellmanFordAlgorithm().getShortestPath(graph, 0);
    }

    @Test
    public void test_findShortestPathList() throws AlgorithmException {
        // data
        int[] expected = new int[]{0, 0, 0, 0, 1, 2, 5};

        // prepare
        Graph graph = new AdjacencyList(7, GraphType.WEIGHTED_DIRECTED);
        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 2, 10);
        graph.addEdge(0, 3, 12);
        graph.addEdge(1, 4, 10);
        graph.addEdge(2, 5, 3);
        graph.addEdge(3, 6, 12);
        graph.addEdge(4, 3, 10);
        graph.addEdge(4, 6, 50);
        graph.addEdge(5, 6, 8);

        // test
        int[] actual = new BellmanFordAlgorithm().getShortestPath(graph, 0);

        // verify
        assertThat(actual, is(expected));
    }

}
