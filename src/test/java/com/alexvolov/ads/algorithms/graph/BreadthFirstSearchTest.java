package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.AdjacencyList;
import com.alexvolov.ads.ds.impl.AdjacencyMatrix;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link com.alexvolov.ads.algorithms.graph.BreadthFirstSearch}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 21.02.15
 */
public class BreadthFirstSearchTest {

    @Test
    public void testTraverse() {
        // data
        new BreadthFirstSearch();
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(3);
        expected.add(6);
        expected.add(5);

        // prepare
        Graph graph = new AdjacencyList(10, GraphType.SIMPLE_DIRECTED);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(3,6);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,4);
        graph.addEdge(5,6);

        // test
        List<Integer> actual = BreadthFirstSearch.traverse(graph, 1);

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testTraverse2() {
        // data
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(3);
        expected.add(6);
        expected.add(4);
        expected.add(5);

        // prepare
        Graph graph = new AdjacencyList(10, GraphType.SIMPLE_DIRECTED);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(3,6);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,4);
        graph.addEdge(5,6);

        // test
        List<Integer> actual = BreadthFirstSearch.traverse(graph, 2);

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void testTraverse3() {
        // data
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(3);
        expected.add(6);
        expected.add(4);
        expected.add(5);

        // prepare
        Graph graph = new AdjacencyMatrix(10, GraphType.SIMPLE_DIRECTED);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(3,6);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,4);
        graph.addEdge(5,6);

        // test
        List<Integer> actual = BreadthFirstSearch.traverse(graph, 2);

        // verify
        assertThat(actual, is(expected));
    }

}
