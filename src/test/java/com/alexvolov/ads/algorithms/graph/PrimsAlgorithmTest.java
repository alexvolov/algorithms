package com.alexvolov.ads.algorithms.graph;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.GraphEdge;
import com.alexvolov.ads.ds.common.GraphType;
import com.alexvolov.ads.ds.impl.AdjacencyList;
import com.alexvolov.ads.ds.impl.AdjacencyMatrix;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link com.alexvolov.ads.algorithms.graph.PrimsAlgorithm}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 15.03.15
 */
public class PrimsAlgorithmTest{

    @Test
    public void test_onMatrix() {
        // data
        Set<GraphEdge> expected = new HashSet<GraphEdge>();
        expected.add(new GraphEdge(0, 1));
        expected.add(new GraphEdge(0, 2));
        expected.add(new GraphEdge(1, 3));

        // Prepare
        Graph g = new AdjacencyMatrix(4, GraphType.WEIGHTED_UNDIRECTED);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 4);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 8);

        // test
        Set<GraphEdge> actual = PrimsAlgorithm.getMST(g);

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void test_onList() {
        // data
        Set<GraphEdge> expected = new HashSet<GraphEdge>();
        expected.add(new GraphEdge(0, 1));
        expected.add(new GraphEdge(0, 2));
        expected.add(new GraphEdge(1, 3));

        // Prepare
        Graph g = new AdjacencyList(4, GraphType.WEIGHTED_UNDIRECTED);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 4);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 8);

        // test
        Set<GraphEdge> actual = PrimsAlgorithm.getMST(g);

        // verify
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_exception() {
        // Prepare
        Graph g = new AdjacencyList(4, GraphType.WEIGHTED_DIRECTED);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 4);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 8);

        // test
        new PrimsAlgorithm().getMST(g);
    }


}
