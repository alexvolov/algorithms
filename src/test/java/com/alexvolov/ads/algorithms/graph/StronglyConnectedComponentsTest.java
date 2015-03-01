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
 * Test class for {@link com.alexvolov.ads.algorithms.graph.StronglyConnectedComponents}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 01.03.15
 */
public class StronglyConnectedComponentsTest {

    @Test
    public void test_kosarajuSCC_list() throws Exception {
        // data
        List<List<Integer>> expected = new ArrayList<List<Integer>>();
        List<Integer> component1 = new ArrayList<Integer>();
        component1.add(1);
        component1.add(4);
        component1.add(0);
        List<Integer> component2 = new ArrayList<Integer>();
        component2.add(7);
        component2.add(3);
        component2.add(2);
        List<Integer> component3 = new ArrayList<Integer>();
        component3.add(5);
        component3.add(6);
        expected.add(component1);
        expected.add(component2);
        expected.add(component3);

        new StronglyConnectedComponents();
        Graph graph = new AdjacencyList(8, GraphType.SIMPLE_DIRECTED);
        graph.addEdge(0, 1);
        graph.addEdge(4, 0);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);
        graph.addEdge(6, 5);
        graph.addEdge(3, 7);
        graph.addEdge(7, 3);
        graph.addEdge(7, 6);


        // test
        List<List<Integer>> actual = StronglyConnectedComponents.kosarajuSCC(graph);

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void test_kosarajuSCC_matrix() throws Exception {
        // data
        List<List<Integer>> expected = new ArrayList<List<Integer>>();
        List<Integer> component1 = new ArrayList<Integer>();
        component1.add(1);
        component1.add(4);
        component1.add(0);
        List<Integer> component2 = new ArrayList<Integer>();
        component2.add(7);
        component2.add(3);
        component2.add(2);
        List<Integer> component3 = new ArrayList<Integer>();
        component3.add(5);
        component3.add(6);
        expected.add(component1);
        expected.add(component2);
        expected.add(component3);

        new StronglyConnectedComponents();
        Graph graph = new AdjacencyMatrix(8, GraphType.SIMPLE_DIRECTED);
        graph.addEdge(0, 1);
        graph.addEdge(4, 0);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);
        graph.addEdge(6, 5);
        graph.addEdge(3, 7);
        graph.addEdge(7, 3);
        graph.addEdge(7, 6);


        // test
        List<List<Integer>> actual = StronglyConnectedComponents.kosarajuSCC(graph);

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void test_tarjanSCC_matrix() throws Exception {
        // data
        List<List<Integer>> expected = new ArrayList<List<Integer>>();
        List<Integer> component1 = new ArrayList<Integer>();
        component1.add(4);
        component1.add(1);
        component1.add(0);
        List<Integer> component2 = new ArrayList<Integer>();
        component2.add(7);
        component2.add(3);
        component2.add(2);
        List<Integer> component3 = new ArrayList<Integer>();
        component3.add(5);
        component3.add(6);
        expected.add(component3);
        expected.add(component2);
        expected.add(component1);

        Graph graph = new AdjacencyMatrix(8, GraphType.SIMPLE_DIRECTED);
        graph.addEdge(0, 1);
        graph.addEdge(4, 0);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);
        graph.addEdge(6, 5);
        graph.addEdge(3, 7);
        graph.addEdge(7, 3);
        graph.addEdge(7, 6);


        // test
        List<List<Integer>> actual = StronglyConnectedComponents.tarjanSCC(graph);

        // verify
        assertThat(actual, is(expected));
    }

}
