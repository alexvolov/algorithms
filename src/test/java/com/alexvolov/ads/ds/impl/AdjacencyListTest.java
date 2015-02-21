package com.alexvolov.ads.ds.impl;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.alexvolov.ads.ds.common.GraphType.*;
import static com.alexvolov.ads.ds.common.GraphType.WEIGHTED_DIRECTED;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link com.alexvolov.ads.ds.impl.AdjacencyList}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 14.02.15
 */
public class AdjacencyListTest {

    private AdjacencyList adjacencyList;

    @Test
    public void testAddEdgeSimpleUndirected() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Map<Integer, Map<Integer, Integer>> expected = new HashMap<Integer, Map<Integer, Integer>>();
        expected.put(0, toMap(new Integer[][]{}));
        expected.put(1, toMap(new Integer[][]{ {2, 1}, {4, 1} }));
        expected.put(2, toMap(new Integer[][]{ {1, 1}, {3, 1}, {6, 1}  }));
        expected.put(3, toMap(new Integer[][]{ {2, 1}, {4, 1}, {6, 1}  }));
        expected.put(4, toMap(new Integer[][]{ {1, 1}, {3, 1}, {4, 1}, {5, 1}  }));
        expected.put(5, toMap(new Integer[][]{ {4, 1}, {6, 1} }));
        expected.put(6, toMap(new Integer[][]{ {2, 1}, {3, 1}, {5, 1}  }));

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, SIMPLE_UNDIRECTED);

        // test
        adjacencyList.addEdge(1,2);
        adjacencyList.addEdge(1,4);
        adjacencyList.addEdge(2,3);
        adjacencyList.addEdge(2,6);
        adjacencyList.addEdge(3,6);
        adjacencyList.addEdge(3,4);
        adjacencyList.addEdge(4,5);
        adjacencyList.addEdge(4,4);
        adjacencyList.addEdge(5,6);

        // verify
        Map<Integer, Map<Integer, Integer>> actual = adjacencyList.getList();
        System.out.println(adjacencyList.toString());
        assertEquals(numberOfEdges, adjacencyList.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyList.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testRemoveEdgeSimpleUndirected() {
        // data
        final int numberOfEdges = 7;
        final int numberOfVertices = 7;
        Map<Integer, Map<Integer, Integer>> expected = new HashMap<Integer, Map<Integer, Integer>>();
        expected.put(0, toMap(new Integer[][]{}));
        expected.put(1, toMap(new Integer[][]{ {4, 1} }));
        expected.put(2, toMap(new Integer[][]{ {3, 1}, {6, 1}  }));
        expected.put(3, toMap(new Integer[][]{ {2, 1}, {4, 1}, {6, 1}  }));
        expected.put(4, toMap(new Integer[][]{ {1, 1}, {3, 1}, {4, 1}, {5, 1}  }));
        expected.put(5, toMap(new Integer[][]{ {4, 1} }));
        expected.put(6, toMap(new Integer[][]{ {2, 1}, {3, 1}  }));

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, SIMPLE_UNDIRECTED);
        adjacencyList.addEdge(1,2);
        adjacencyList.addEdge(1,4);
        adjacencyList.addEdge(2,3);
        adjacencyList.addEdge(2,6);
        adjacencyList.addEdge(3,6);
        adjacencyList.addEdge(3,4);
        adjacencyList.addEdge(4,5);
        adjacencyList.addEdge(4,4);
        adjacencyList.addEdge(5,6);

        // test
        adjacencyList.removeEdge(1, 2);
        adjacencyList.removeEdge(5, 6);

        // verify
        Map<Integer, Map<Integer, Integer>> actual = adjacencyList.getList();
        System.out.println(adjacencyList.toString());
        assertEquals(numberOfEdges, adjacencyList.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyList.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testAddEdgeSimpleDirected() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Map<Integer, Map<Integer, Integer>> expected = new HashMap<Integer, Map<Integer, Integer>>();
        expected.put(0, toMap(new Integer[][]{}));
        expected.put(1, toMap(new Integer[][]{ {2, 1}, {4, 1} }));
        expected.put(2, toMap(new Integer[][]{ {1, -1}, {3, 1}, {6, 1}  }));
        expected.put(3, toMap(new Integer[][]{ {2, -1}, {4, 1}, {6, 1}  }));
        expected.put(4, toMap(new Integer[][]{ {1, -1}, {3, -1}, {4, -1}, {5, 1}  }));
        expected.put(5, toMap(new Integer[][]{ {4, -1}, {6, 1} }));
        expected.put(6, toMap(new Integer[][]{ {2, -1}, {3, -1}, {5, -1}  }));

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, SIMPLE_DIRECTED);

        // test
        adjacencyList.addEdge(1,2);
        adjacencyList.addEdge(1,4);
        adjacencyList.addEdge(2,3);
        adjacencyList.addEdge(2,6);
        adjacencyList.addEdge(3,6);
        adjacencyList.addEdge(3,4);
        adjacencyList.addEdge(4,5);
        adjacencyList.addEdge(4,4);
        adjacencyList.addEdge(5,6);

        // verify
        Map<Integer, Map<Integer, Integer>> actual = adjacencyList.getList();
        System.out.println(adjacencyList.toString());
        assertEquals(numberOfEdges, adjacencyList.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyList.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testRemoveEdgeSimpleDirected() {
        // data
        final int numberOfEdges = 7;
        final int numberOfVertices = 7;
        Map<Integer, Map<Integer, Integer>> expected = new HashMap<Integer, Map<Integer, Integer>>();
        expected.put(0, toMap(new Integer[][]{}));
        expected.put(1, toMap(new Integer[][]{ {4, 1} }));
        expected.put(2, toMap(new Integer[][]{ {3, 1}, {6, 1}  }));
        expected.put(3, toMap(new Integer[][]{ {2, -1}, {4, 1}, {6, 1}  }));
        expected.put(4, toMap(new Integer[][]{ {1, -1}, {3, -1}, {4, -1}, {5, 1}  }));
        expected.put(5, toMap(new Integer[][]{ {4, -1} }));
        expected.put(6, toMap(new Integer[][]{ {2, -1}, {3, -1}  }));

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, SIMPLE_DIRECTED);
        adjacencyList.addEdge(1,2);
        adjacencyList.addEdge(1,4);
        adjacencyList.addEdge(2,3);
        adjacencyList.addEdge(2,6);
        adjacencyList.addEdge(3,6);
        adjacencyList.addEdge(3,4);
        adjacencyList.addEdge(4,5);
        adjacencyList.addEdge(4,4);
        adjacencyList.addEdge(5,6);

        // test
        adjacencyList.removeEdge(1, 2);
        adjacencyList.removeEdge(5, 6);

        // verify
        Map<Integer, Map<Integer, Integer>> actual = adjacencyList.getList();
        System.out.println(adjacencyList.toString());
        assertEquals(numberOfEdges, adjacencyList.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyList.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testAddEdgeWeightedDirected() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Map<Integer, Map<Integer, Integer>> expected = new HashMap<Integer, Map<Integer, Integer>>();
        expected.put(0, toMap(new Integer[][]{}));
        expected.put(1, toMap(new Integer[][]{ {2, 10}, {4, 100} }));
        expected.put(2, toMap(new Integer[][]{ {1, -10}, {3, 150}, {6, 175}  }));
        expected.put(3, toMap(new Integer[][]{ {2, -150}, {4, 15}, {6, 300}  }));
        expected.put(4, toMap(new Integer[][]{ {1, -100}, {3, -15}, {4, -20}, {5, 326}  }));
        expected.put(5, toMap(new Integer[][]{ {4, -326}, {6, 80} }));
        expected.put(6, toMap(new Integer[][]{ {2, -175}, {3, -300}, {5, -80}  }));

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, WEIGHTED_DIRECTED);

        // test
        adjacencyList.addEdge(1,2, 10);
        adjacencyList.addEdge(1,4, 100);
        adjacencyList.addEdge(2,3, 150);
        adjacencyList.addEdge(2,6, 175);
        adjacencyList.addEdge(3,6, 300);
        adjacencyList.addEdge(3,4, 15);
        adjacencyList.addEdge(4,5, 326);
        adjacencyList.addEdge(4,4, 20);
        adjacencyList.addEdge(5,6, 80);

        // verify
        Map<Integer, Map<Integer, Integer>> actual = adjacencyList.getList();
        System.out.println(adjacencyList.toString());
        assertEquals(numberOfEdges, adjacencyList.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyList.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testRemoveEdgeWeightedDirected() {
        // data
        final int numberOfEdges = 7;
        final int numberOfVertices = 7;
        Map<Integer, Map<Integer, Integer>> expected = new HashMap<Integer, Map<Integer, Integer>>();
        expected.put(0, toMap(new Integer[][]{}));
        expected.put(1, toMap(new Integer[][]{ {4, 100} }));
        expected.put(2, toMap(new Integer[][]{ {3, 150}, {6, 175}  }));
        expected.put(3, toMap(new Integer[][]{ {2, -150}, {4, 15}, {6, 300}  }));
        expected.put(4, toMap(new Integer[][]{ {1, -100}, {3, -15}, {4, -20}, {5, 326}  }));
        expected.put(5, toMap(new Integer[][]{ {4, -326} }));
        expected.put(6, toMap(new Integer[][]{ {2, -175}, {3, -300}  }));

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, WEIGHTED_DIRECTED);
        adjacencyList.addEdge(1,2, 10);
        adjacencyList.addEdge(1,4, 100);
        adjacencyList.addEdge(2,3, 150);
        adjacencyList.addEdge(2,6, 175);
        adjacencyList.addEdge(3,6, 300);
        adjacencyList.addEdge(3,4, 15);
        adjacencyList.addEdge(4,5, 326);
        adjacencyList.addEdge(4,4, 20);
        adjacencyList.addEdge(5,6, 80);

        // test
        adjacencyList.removeEdge(1, 2);
        adjacencyList.removeEdge(5, 6);

        // verify
        Map<Integer, Map<Integer, Integer>> actual = adjacencyList.getList();
        System.out.println(adjacencyList.toString());
        assertEquals(numberOfEdges, adjacencyList.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyList.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testAddEdgeWeightedUndirected() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Map<Integer, Map<Integer, Integer>> expected = new HashMap<Integer, Map<Integer, Integer>>();
        expected.put(0, toMap(new Integer[][]{}));
        expected.put(1, toMap(new Integer[][]{ {2, 10}, {4, 100} }));
        expected.put(2, toMap(new Integer[][]{ {1, 10}, {3, 150}, {6, 175}  }));
        expected.put(3, toMap(new Integer[][]{ {2, 150}, {4, 15}, {6, 300}  }));
        expected.put(4, toMap(new Integer[][]{ {1, 100}, {3, 15}, {4, 20}, {5, 326}  }));
        expected.put(5, toMap(new Integer[][]{ {4, 326}, {6, 80} }));
        expected.put(6, toMap(new Integer[][]{ {2, 175}, {3, 300}, {5, 80}  }));

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, WEIGHTED_UNDIRECTED);

        // test
        adjacencyList.addEdge(1,2, 10);
        adjacencyList.addEdge(1,4, 100);
        adjacencyList.addEdge(2,3, 150);
        adjacencyList.addEdge(2,6, 175);
        adjacencyList.addEdge(3,6, 300);
        adjacencyList.addEdge(3,4, 15);
        adjacencyList.addEdge(4,5, 326);
        adjacencyList.addEdge(4,4, 20);
        adjacencyList.addEdge(5,6, 80);

        // verify
        Map<Integer, Map<Integer, Integer>> actual = adjacencyList.getList();
        System.out.println(adjacencyList.toString());
        assertEquals(numberOfEdges, adjacencyList.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyList.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testRemoveEdgeWeightedUndirected() {
        // data
        final int numberOfEdges = 7;
        final int numberOfVertices = 7;
        Map<Integer, Map<Integer, Integer>> expected = new HashMap<Integer, Map<Integer, Integer>>();
        expected.put(0, toMap(new Integer[][]{}));
        expected.put(1, toMap(new Integer[][]{ {4, 100} }));
        expected.put(2, toMap(new Integer[][]{ {3, 150}, {6, 175}  }));
        expected.put(3, toMap(new Integer[][]{ {2, 150}, {4, 15}, {6, 300}  }));
        expected.put(4, toMap(new Integer[][]{ {1, 100}, {3, 15}, {4, 20}, {5, 326}  }));
        expected.put(5, toMap(new Integer[][]{ {4, 326} }));
        expected.put(6, toMap(new Integer[][]{ {2, 175}, {3, 300}  }));

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, WEIGHTED_UNDIRECTED);
        adjacencyList.addEdge(1,2, 10);
        adjacencyList.addEdge(1,4, 100);
        adjacencyList.addEdge(2,3, 150);
        adjacencyList.addEdge(2,6, 175);
        adjacencyList.addEdge(3,6, 300);
        adjacencyList.addEdge(3,4, 15);
        adjacencyList.addEdge(4,5, 326);
        adjacencyList.addEdge(4,4, 20);
        adjacencyList.addEdge(5,6, 80);

        // test
        adjacencyList.removeEdge(1, 2);
        adjacencyList.removeEdge(5, 6);

        // verify
        Map<Integer, Map<Integer, Integer>> actual = adjacencyList.getList();
        System.out.println(adjacencyList.toString());
        assertEquals(numberOfEdges, adjacencyList.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyList.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testHasEdge() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Map<Integer, Map<Integer, Integer>> expected = new HashMap<Integer, Map<Integer, Integer>>();
        expected.put(0, toMap(new Integer[][]{}));
        expected.put(1, toMap(new Integer[][]{ {2, 10}, {4, 100} }));
        expected.put(2, toMap(new Integer[][]{ {1, 10}, {3, 150}, {6, 175}  }));
        expected.put(3, toMap(new Integer[][]{ {2, 150}, {4, 15}, {6, 300}  }));
        expected.put(4, toMap(new Integer[][]{ {1, 100}, {3, 15}, {4, 20}, {5, 326}  }));
        expected.put(5, toMap(new Integer[][]{ {4, 326}, {6, 80} }));
        expected.put(6, toMap(new Integer[][]{ {2, 175}, {3, 300}, {5, 80}  }));

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, WEIGHTED_UNDIRECTED);
        adjacencyList.addEdge(1,2, 10);
        adjacencyList.addEdge(1,4, 100);
        adjacencyList.addEdge(2,3, 150);
        adjacencyList.addEdge(2,6, 175);
        adjacencyList.addEdge(3,6, 300);
        adjacencyList.addEdge(3,4, 15);
        adjacencyList.addEdge(4,5, 326);
        adjacencyList.addEdge(4,4, 20);
        adjacencyList.addEdge(5,6, 80);

        // verify
        Map<Integer, Map<Integer, Integer>> actual = adjacencyList.getList();
        System.out.println(adjacencyList.toString());
        assertEquals(numberOfEdges, adjacencyList.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyList.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
        assertTrue(adjacencyList.isAdjacent(1, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveEdgeThatDoesNotExists() throws Exception {
        // prepare
        adjacencyList = new AdjacencyList(1, WEIGHTED_UNDIRECTED);

        // test
        adjacencyList.removeEdge(10, 10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddEdgeWrongType() throws Exception {
        // prepare
        adjacencyList = new AdjacencyList(1, WEIGHTED_UNDIRECTED);

        // test
        adjacencyList.addEdge(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeWrongVertex() throws Exception {
        // prepare
        adjacencyList = new AdjacencyList(1, SIMPLE_DIRECTED);

        // test
        adjacencyList.addEdge(0, 10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddEdgeWrongType2() throws Exception {
        // prepare
        adjacencyList = new AdjacencyList(1, SIMPLE_DIRECTED);

        // test
        adjacencyList.addEdge(0, 10, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeWrongVertex2() throws Exception {
        // prepare
        adjacencyList = new AdjacencyList(1, WEIGHTED_UNDIRECTED);

        // test
        adjacencyList.addEdge(0, 10, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeWrongWeight() throws Exception {
        // prepare
        adjacencyList = new AdjacencyList(1, WEIGHTED_UNDIRECTED);

        // test
        adjacencyList.addEdge(0, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeWrongWeight2() throws Exception {
        // prepare
        adjacencyList = new AdjacencyList(1, WEIGHTED_DIRECTED);

        // test
        adjacencyList.addEdge(0, 0, -100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongNumberOfVertices() throws Exception {
        // test
        adjacencyList = new AdjacencyList(-200, WEIGHTED_DIRECTED);
    }

    @Test
    public void testGetNeighbours() {
        // data
        final int numberOfVertices = 7;
        Set<Integer> expected = new HashSet<Integer>();
        expected.add(3);
        expected.add(6);

        // prepare
        adjacencyList = new AdjacencyList(numberOfVertices, WEIGHTED_DIRECTED);
        adjacencyList.addEdge(1,2, 10);
        adjacencyList.addEdge(1,4, 100);
        adjacencyList.addEdge(2,3, 150);
        adjacencyList.addEdge(2,6, 175);
        adjacencyList.addEdge(3,6, 300);
        adjacencyList.addEdge(3,4, 15);
        adjacencyList.addEdge(4,5, 326);
        adjacencyList.addEdge(4,4, 20);
        adjacencyList.addEdge(5,6, 80);

        // test
        Set<Integer> actual = adjacencyList.getNeighbours(2);

        // verify
        assertThat(actual, is(expected));
    }

    private Map<Integer, Integer> toMap(Integer[][] array) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            result.put(array[i][0], array[i][1]);
        }
        return result;
    }

    private boolean isEqual(Map<Integer, Map<Integer, Integer>> expected, Map<Integer, Map<Integer, Integer>> actual) {
        boolean res = true;
        if (expected.size() == actual.size()) {
            for (Integer key : expected.keySet()) {
                Map<Integer, Integer> expectedEntry = expected.get(key);
                Map<Integer, Integer> actualEntry = actual.get(key);
                if (expectedEntry.size() == actualEntry.size()) {
                    for (Integer subKey : expectedEntry.keySet()) {
                        if (!expectedEntry.get(subKey).equals(actualEntry.get(subKey))) {
                            res = false;
                            break;
                        }
                    }
                } else {
                    res = false;
                    break;
                }
            }
        } else {
            res = false;
        }
        return res;
    }

}
