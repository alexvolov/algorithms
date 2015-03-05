package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.AdjacencyList;
import com.alexvolov.ads.ds.impl.AdjacencyMatrix;
import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link com.alexvolov.ads.algorithms.graph.DijkstrasAlgorithm}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 05.03.15
 */
public class DijkstrasAlgorithmTest {

    @Test
    public void test_findShortestPathMatrix() {
        // data
        int[] expected = new int[]{0, 8, 10, 12, 18, 13, 21};

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
        int[] actual = new DijkstrasAlgorithm().getShortestPath(graph, 0);

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void test_findShortestPathList() {
        // data
        int[] expected = new int[]{0, 8, 10, 12, 18, 13, 21};

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
        int[] actual = new DijkstrasAlgorithm().getShortestPath(graph, 0);

        // verify
        assertThat(actual, is(expected));
    }

}
