package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.AdjacencyList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link com.alexvolov.ads.algorithms.graph.DepthFirstSearch}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 21.02.15
 */
public class DepthFirstSearchTest{

    @Test
    public void testRecursiveSearch() {
        // data
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        expected.add(10);
        expected.add(11);
        expected.add(12);
        expected.add(13);
        expected.add(14);
        expected.add(21);
        expected.add(22);
        expected.add(23);
        expected.add(15);
        expected.add(16);
        expected.add(17);
        expected.add(18);
        expected.add(19);
        expected.add(20);

        // prepare
        Graph graph = new AdjacencyList(24, GraphType.SIMPLE_DIRECTED);

        // level # one
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        // level # two
        graph.addEdge(1, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 10);

        // level # three
        graph.addEdge(0, 11);
        graph.addEdge(11, 12);
        graph.addEdge(12, 13);
        graph.addEdge(13, 14);
        graph.addEdge(14, 15);
        graph.addEdge(15, 16);
        graph.addEdge(16, 17);

        // level # four
        graph.addEdge(15, 18);
        graph.addEdge(18, 19);
        graph.addEdge(19, 20);

        // level # five
        graph.addEdge(14, 21);
        graph.addEdge(21, 22);
        graph.addEdge(22, 23);

        // test
        List<Integer> actual = new DepthFirstSearch().recursiveSearch(graph, 0);

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testIterativeSearch() {
        // data
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        expected.add(10);
        expected.add(11);
        expected.add(12);
        expected.add(13);
        expected.add(14);
        expected.add(21);
        expected.add(22);
        expected.add(23);
        expected.add(15);
        expected.add(16);
        expected.add(17);
        expected.add(18);
        expected.add(19);
        expected.add(20);

        // prepare
        Graph graph = new AdjacencyList(24, GraphType.SIMPLE_DIRECTED);

        // level # one
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        // level # two
        graph.addEdge(1, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 10);

        // level # three
        graph.addEdge(0, 11);
        graph.addEdge(11, 12);
        graph.addEdge(12, 13);
        graph.addEdge(13, 14);
        graph.addEdge(14, 15);
        graph.addEdge(15, 16);
        graph.addEdge(16, 17);

        // level # four
        graph.addEdge(15, 18);
        graph.addEdge(18, 19);
        graph.addEdge(19, 20);

        // level # five
        graph.addEdge(14, 21);
        graph.addEdge(21, 22);
        graph.addEdge(22, 23);

        // test
        List<Integer> actual = new DepthFirstSearch().iterativeSearch(graph, 0);

        // verify
        assertThat(actual, is(expected));
    }

    @Test(expected = NullPointerException.class)
    public void iterativeNullGraph() throws Exception {
        new DepthFirstSearch().iterativeSearch(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void recursiveNullGraph() throws Exception {
        new DepthFirstSearch().recursiveSearch(null, 0);
    }
}
