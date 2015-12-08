package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.common.AlgorithmException;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.AdjacencyList;
import com.alexvolov.ads.ds.impl.AdjacencyMatrix;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link com.alexvolov.ads.algorithms.graph.TopologicalSort}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 23.02.15
 */
public class TopologicalSortTest {

    @Test
    public void testKahnTopologicalSort() throws Exception {
        // data
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        // prepare
        Graph g = new AdjacencyList(6, GraphType.SIMPLE_DIRECTED);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 5);

        // test
        List<Integer> actual = TopologicalSort.kahnTopologicalSort(g);

        // verify
        assertThat(actual, is(expected));
    }

    @Test(expected = AlgorithmException.class)
    public void testKahnTopologicalSort2() throws Exception {
        // data
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        // prepare
        Graph g = new AdjacencyList(6, GraphType.SIMPLE_DIRECTED);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 5);
        g.addEdge(5, 2);

        // test
        List<Integer> actual = TopologicalSort.kahnTopologicalSort(g);
    }

    @Test
    public void testKahnTopologicalSort3() throws Exception {
        // data
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        // prepare
        Graph g = new AdjacencyMatrix(6, GraphType.SIMPLE_DIRECTED);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 5);

        // test
        List<Integer> actual = TopologicalSort.kahnTopologicalSort(g);

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testDfsTopologicalSort3() throws Exception {
        // data
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(0);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        // prepare
        Graph g = new AdjacencyMatrix(6, GraphType.SIMPLE_DIRECTED);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 5);

        // test
        List<Integer> actual = TopologicalSort.dfsTopologicalSort(g);

        // verify
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDfsTopologicalSort4() throws Exception {
        TopologicalSort.dfsTopologicalSort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDfsTopologicalSort5() throws Exception {
        // prepare
        Graph g = new AdjacencyMatrix(6, GraphType.SIMPLE_UNDIRECTED);

        // test
        TopologicalSort.dfsTopologicalSort(g);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKahnTopologicalSort4() throws Exception {
        TopologicalSort.kahnTopologicalSort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKahnTopologicalSort5() throws Exception {
        // prepare
        new TopologicalSort();
        Graph g = new AdjacencyMatrix(6, GraphType.SIMPLE_UNDIRECTED);

        // test
        TopologicalSort.kahnTopologicalSort(g);
    }

}
