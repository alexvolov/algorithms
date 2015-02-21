package com.alexvolov.ads.ds.impl;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static com.alexvolov.ads.ds.common.GraphType.SIMPLE_DIRECTED;
import static com.alexvolov.ads.ds.common.GraphType.SIMPLE_UNDIRECTED;
import static com.alexvolov.ads.ds.common.GraphType.WEIGHTED_DIRECTED;
import static com.alexvolov.ads.ds.common.GraphType.WEIGHTED_UNDIRECTED;

/**
 * Test class for {@link com.alexvolov.ads.ds.impl.AdjacencyMatrix}.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 11.02.15
 */
public class AdjacencyMatrixTest {

    private AdjacencyMatrix adjacencyMatrix;

    @Test
    public void testAddEdgeSimpleUndirected() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Integer[][] expected = new Integer[][] {
            new Integer[] {null, null, null, null, null, null, null},
            new Integer[] {null, null, 1   , null, 1   , null, null},
            new Integer[] {null, 1   , null, 1   , null, null, 1   },
            new Integer[] {null, null, 1   , null, 1   , null, 1   },
            new Integer[] {null, 1   , null, 1   , 1   , 1   , null},
            new Integer[] {null, null, null, null, 1   , null, 1   },
            new Integer[] {null, null, 1   , 1   , null, 1   , null}
        };

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, SIMPLE_UNDIRECTED);

        // test
        adjacencyMatrix.addEdge(1,2);
        adjacencyMatrix.addEdge(1,4);
        adjacencyMatrix.addEdge(2,3);
        adjacencyMatrix.addEdge(2,6);
        adjacencyMatrix.addEdge(3,6);
        adjacencyMatrix.addEdge(3,4);
        adjacencyMatrix.addEdge(4,5);
        adjacencyMatrix.addEdge(4,4);
        adjacencyMatrix.addEdge(5,6);

        // verify
        Integer[][] actual = adjacencyMatrix.getMatrix();
        System.out.println(adjacencyMatrix.toString());
        assertEquals(numberOfEdges, adjacencyMatrix.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyMatrix.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testRemoveEdgeSimpleUndirected() {
        // data
        final int numberOfEdges = 7;
        final int numberOfVertices = 7;
        Integer[][] expected = new Integer[][] {
                new Integer[] {null, null, null, null, null, null, null},
                new Integer[] {null, null, null, null, 1   , null, null},
                new Integer[] {null, null, null, 1   , null, null, 1   },
                new Integer[] {null, null, 1   , null, 1   , null, 1   },
                new Integer[] {null, 1   , null, 1   , 1   , 1   , null},
                new Integer[] {null, null, null, null, 1   , null, null},
                new Integer[] {null, null, 1   , 1   , null, null, null}
        };

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, SIMPLE_UNDIRECTED);
        adjacencyMatrix.addEdge(1,2);
        adjacencyMatrix.addEdge(1,4);
        adjacencyMatrix.addEdge(2,3);
        adjacencyMatrix.addEdge(2,6);
        adjacencyMatrix.addEdge(3,6);
        adjacencyMatrix.addEdge(3,4);
        adjacencyMatrix.addEdge(4,5);
        adjacencyMatrix.addEdge(4,4);
        adjacencyMatrix.addEdge(5,6);

        // test
        adjacencyMatrix.removeEdge(1, 2);
        adjacencyMatrix.removeEdge(5, 6);

        // verify
        Integer[][] actual = adjacencyMatrix.getMatrix();
        System.out.println(adjacencyMatrix.toString());
        assertEquals(numberOfEdges, adjacencyMatrix.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyMatrix.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testAddEdgeSimpleDirected() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Integer[][] expected = new Integer[][] {
                new Integer[] {null, null, null, null, null, null, null},
                new Integer[] {null, null, 1   , null, 1   , null, null},
                new Integer[] {null, -1  , null, 1   , null, null, 1   },
                new Integer[] {null, null, -1  , null, 1   , null, 1   },
                new Integer[] {null, -1  , null, -1  , -1  , 1   , null},
                new Integer[] {null, null, null, null, -1  , null, 1   },
                new Integer[] {null, null, -1  , -1  , null, -1   , null}
        };

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, SIMPLE_DIRECTED);

        // test
        adjacencyMatrix.addEdge(1,2);
        adjacencyMatrix.addEdge(1,4);
        adjacencyMatrix.addEdge(2,3);
        adjacencyMatrix.addEdge(2,6);
        adjacencyMatrix.addEdge(3,6);
        adjacencyMatrix.addEdge(3,4);
        adjacencyMatrix.addEdge(4,5);
        adjacencyMatrix.addEdge(4,4);
        adjacencyMatrix.addEdge(5,6);

        // verify
        Integer[][] actual = adjacencyMatrix.getMatrix();
        System.out.println(adjacencyMatrix.toString());
        assertEquals(numberOfEdges, adjacencyMatrix.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyMatrix.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testRemoveEdgeSimpleDirected() {
        // data
        final int numberOfEdges = 7;
        final int numberOfVertices = 7;
        Integer[][] expected = new Integer[][] {
                new Integer[] {null, null, null, null, null, null, null},
                new Integer[] {null, null, null, null, 1   , null, null},
                new Integer[] {null, null, null, 1   , null, null, 1   },
                new Integer[] {null, null, -1  , null, 1   , null, 1   },
                new Integer[] {null, -1  , null, -1  , -1  , 1   , null},
                new Integer[] {null, null, null, null, -1  , null, null},
                new Integer[] {null, null, - 1 , -1  , null, null, null}
        };

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, SIMPLE_DIRECTED);
        adjacencyMatrix.addEdge(1,2);
        adjacencyMatrix.addEdge(1,4);
        adjacencyMatrix.addEdge(2,3);
        adjacencyMatrix.addEdge(2,6);
        adjacencyMatrix.addEdge(3,6);
        adjacencyMatrix.addEdge(3,4);
        adjacencyMatrix.addEdge(4,5);
        adjacencyMatrix.addEdge(4,4);
        adjacencyMatrix.addEdge(5,6);

        // test
        adjacencyMatrix.removeEdge(1, 2);
        adjacencyMatrix.removeEdge(5, 6);

        // verify
        Integer[][] actual = adjacencyMatrix.getMatrix();
        System.out.println(adjacencyMatrix.toString());
        assertEquals(numberOfEdges, adjacencyMatrix.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyMatrix.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testAddEdgeWeightedDirected() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Integer[][] expected = new Integer[][] {
                new Integer[] {null, null, null, null, null, null, null},
                new Integer[] {null, null, 10  , null, 100 , null, null},
                new Integer[] {null, -10 , null, 150 , null, null, 175 },
                new Integer[] {null, null, -150, null, 15  , null, 300 },
                new Integer[] {null, -100, null, -15 , -20 , 326 , null},
                new Integer[] {null, null, null, null, -326, null, 80  },
                new Integer[] {null, null, -175, -300, null, -80 , null}
        };

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, WEIGHTED_DIRECTED);

        // test
        adjacencyMatrix.addEdge(1,2, 10);
        adjacencyMatrix.addEdge(1,4, 100);
        adjacencyMatrix.addEdge(2,3, 150);
        adjacencyMatrix.addEdge(2,6, 175);
        adjacencyMatrix.addEdge(3,6, 300);
        adjacencyMatrix.addEdge(3,4, 15);
        adjacencyMatrix.addEdge(4,5, 326);
        adjacencyMatrix.addEdge(4,4, 20);
        adjacencyMatrix.addEdge(5,6, 80);

        // verify
        Integer[][] actual = adjacencyMatrix.getMatrix();
        System.out.println(adjacencyMatrix.toString());
        assertEquals(numberOfEdges, adjacencyMatrix.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyMatrix.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testRemoveEdgeWeightedDirected() {
        // data
        final int numberOfEdges = 7;
        final int numberOfVertices = 7;
        Integer[][] expected = new Integer[][] {
                new Integer[] {null, null, null, null, null, null, null},
                new Integer[] {null, null, null, null, 100 , null, null},
                new Integer[] {null, null, null, 150 , null, null, 175 },
                new Integer[] {null, null, -150, null, 15  , null, 300 },
                new Integer[] {null, -100, null, -15 , -20 , 326 , null},
                new Integer[] {null, null, null, null, -326, null, null},
                new Integer[] {null, null, -175, -300, null, null , null}
        };

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, WEIGHTED_DIRECTED);
        adjacencyMatrix.addEdge(1,2, 10);
        adjacencyMatrix.addEdge(1,4, 100);
        adjacencyMatrix.addEdge(2,3, 150);
        adjacencyMatrix.addEdge(2,6, 175);
        adjacencyMatrix.addEdge(3,6, 300);
        adjacencyMatrix.addEdge(3,4, 15);
        adjacencyMatrix.addEdge(4,5, 326);
        adjacencyMatrix.addEdge(4,4, 20);
        adjacencyMatrix.addEdge(5,6, 80);

        // test
        adjacencyMatrix.removeEdge(1, 2);
        adjacencyMatrix.removeEdge(5, 6);

        // verify
        Integer[][] actual = adjacencyMatrix.getMatrix();
        System.out.println(adjacencyMatrix.toString());
        assertEquals(numberOfEdges, adjacencyMatrix.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyMatrix.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testAddEdgeWeightedUndirected() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Integer[][] expected = new Integer[][] {
                new Integer[] {null, null, null, null, null, null, null},
                new Integer[] {null, null, 10  , null, 100 , null, null},
                new Integer[] {null, 10  , null, 150 , null, null, 175 },
                new Integer[] {null, null, 150 , null, 15  , null, 300 },
                new Integer[] {null, 100 , null, 15  , 20  , 326 , null},
                new Integer[] {null, null, null, null, 326 , null, 80  },
                new Integer[] {null, null, 175 , 300 , null, 80  , null}
        };

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, WEIGHTED_UNDIRECTED);

        // test
        adjacencyMatrix.addEdge(1,2, 10);
        adjacencyMatrix.addEdge(1,4, 100);
        adjacencyMatrix.addEdge(2,3, 150);
        adjacencyMatrix.addEdge(2,6, 175);
        adjacencyMatrix.addEdge(3,6, 300);
        adjacencyMatrix.addEdge(3,4, 15);
        adjacencyMatrix.addEdge(4,5, 326);
        adjacencyMatrix.addEdge(4,4, 20);
        adjacencyMatrix.addEdge(5,6, 80);

        // verify
        Integer[][] actual = adjacencyMatrix.getMatrix();
        System.out.println(adjacencyMatrix.toString());
        assertEquals(numberOfEdges, adjacencyMatrix.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyMatrix.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testRemoveEdgeWeightedUndirected() {
        // data
        final int numberOfEdges = 7;
        final int numberOfVertices = 7;
        Integer[][] expected = new Integer[][] {
                new Integer[] {null, null, null, null, null, null, null},
                new Integer[] {null, null, null, null, 100 , null, null},
                new Integer[] {null, null, null, 150 , null, null, 175 },
                new Integer[] {null, null, 150 , null, 15  , null, 300 },
                new Integer[] {null, 100 , null, 15  , 20  , 326 , null},
                new Integer[] {null, null, null, null, 326 , null, null},
                new Integer[] {null, null, 175 , 300 , null, null, null}
        };

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, WEIGHTED_UNDIRECTED);
        adjacencyMatrix.addEdge(1,2, 10);
        adjacencyMatrix.addEdge(1,4, 100);
        adjacencyMatrix.addEdge(2,3, 150);
        adjacencyMatrix.addEdge(2,6, 175);
        adjacencyMatrix.addEdge(3,6, 300);
        adjacencyMatrix.addEdge(3,4, 15);
        adjacencyMatrix.addEdge(4,5, 326);
        adjacencyMatrix.addEdge(4,4, 20);
        adjacencyMatrix.addEdge(5,6, 80);

        // test
        adjacencyMatrix.removeEdge(1, 2);
        adjacencyMatrix.removeEdge(5, 6);

        // verify
        Integer[][] actual = adjacencyMatrix.getMatrix();
        System.out.println(adjacencyMatrix.toString());
        assertEquals(numberOfEdges, adjacencyMatrix.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyMatrix.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
    }

    @Test
    public void testHasEdge() {
        // data
        final int numberOfEdges = 9;
        final int numberOfVertices = 7;
        Integer[][] expected = new Integer[][] {
                new Integer[] {null, null, null, null, null, null, null},
                new Integer[] {null, null, 10  , null, 100 , null, null},
                new Integer[] {null, 10  , null, 150 , null, null, 175 },
                new Integer[] {null, null, 150 , null, 15  , null, 300 },
                new Integer[] {null, 100 , null, 15  , 20  , 326 , null},
                new Integer[] {null, null, null, null, 326 , null, 80  },
                new Integer[] {null, null, 175 , 300 , null, 80  , null}
        };

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, WEIGHTED_UNDIRECTED);
        adjacencyMatrix.addEdge(1,2, 10);
        adjacencyMatrix.addEdge(1,4, 100);
        adjacencyMatrix.addEdge(2,3, 150);
        adjacencyMatrix.addEdge(2,6, 175);
        adjacencyMatrix.addEdge(3,6, 300);
        adjacencyMatrix.addEdge(3,4, 15);
        adjacencyMatrix.addEdge(4,5, 326);
        adjacencyMatrix.addEdge(4,4, 20);
        adjacencyMatrix.addEdge(5,6, 80);

        // verify
        Integer[][] actual = adjacencyMatrix.getMatrix();
        System.out.println(adjacencyMatrix.toString());
        assertEquals(numberOfEdges, adjacencyMatrix.getNumberOfEdges());
        assertEquals(numberOfVertices, adjacencyMatrix.getSize());
        assertTrue("Actual result doesn't match expected", isEqual(expected, actual));
        assertTrue(adjacencyMatrix.isAdjacent(1, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveEdgeThatDoesNotExists() throws Exception {
        // prepare
        adjacencyMatrix = new AdjacencyMatrix(1, WEIGHTED_UNDIRECTED);

        // test
        adjacencyMatrix.removeEdge(10, 10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddEdgeWrongType() throws Exception {
        // prepare
        adjacencyMatrix = new AdjacencyMatrix(1, WEIGHTED_UNDIRECTED);

        // test
        adjacencyMatrix.addEdge(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeWrongVertex() throws Exception {
        // prepare
        adjacencyMatrix = new AdjacencyMatrix(1, SIMPLE_DIRECTED);

        // test
        adjacencyMatrix.addEdge(0, 10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddEdgeWrongType2() throws Exception {
        // prepare
        adjacencyMatrix = new AdjacencyMatrix(1, SIMPLE_DIRECTED);

        // test
        adjacencyMatrix.addEdge(0, 10, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeWrongVertex2() throws Exception {
        // prepare
        adjacencyMatrix = new AdjacencyMatrix(1, WEIGHTED_UNDIRECTED);

        // test
        adjacencyMatrix.addEdge(0, 10, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeWrongWeight() throws Exception {
        // prepare
        adjacencyMatrix = new AdjacencyMatrix(1, WEIGHTED_UNDIRECTED);

        // test
        adjacencyMatrix.addEdge(0, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeWrongWeight2() throws Exception {
        // prepare
        adjacencyMatrix = new AdjacencyMatrix(1, WEIGHTED_DIRECTED);

        // test
        adjacencyMatrix.addEdge(0, 0, -100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongNumberOfVertices() throws Exception {
        // test
        adjacencyMatrix = new AdjacencyMatrix(-200, WEIGHTED_DIRECTED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNeighboursWrongVertex() throws Exception {
        // prepare
        adjacencyMatrix = new AdjacencyMatrix(1, WEIGHTED_DIRECTED);

        // test
        adjacencyMatrix.getNeighbours(2);
    }

    @Test
    public void testGetNeighbours() {
        // data
        final int numberOfVertices = 7;
        Set<Integer> expected = new HashSet<Integer>();
        expected.add(3);
        expected.add(6);

        // prepare
        adjacencyMatrix = new AdjacencyMatrix(numberOfVertices, WEIGHTED_DIRECTED);
        adjacencyMatrix.addEdge(1,2, 10);
        adjacencyMatrix.addEdge(1,4, 100);
        adjacencyMatrix.addEdge(2,3, 150);
        adjacencyMatrix.addEdge(2,6, 175);
        adjacencyMatrix.addEdge(3,6, 300);
        adjacencyMatrix.addEdge(3,4, 15);
        adjacencyMatrix.addEdge(4,5, 326);
        adjacencyMatrix.addEdge(4,4, 20);
        adjacencyMatrix.addEdge(5,6, 80);

        // test
        Set<Integer> actual = adjacencyMatrix.getNeighbours(2);

        // verify
        assertThat(actual, is(expected));
    }

    private boolean isEqual(Integer[][] expected, Integer[][] actual) {
        boolean res = true;

        if (expected.length == actual.length) {
            for (int i = 0; i < expected.length; i++) {
                for (int j = 0; j < expected.length; j++) {
                    if (
                            (null != expected[i][j] && null == actual[i][j])
                            || (null == expected[i][j] && null != actual[i][j])
                            || ((null != expected[i][j] && null != actual[i][j] && !expected[i][j].equals(actual[i][j])))
                    ) {
                        res = false;
                        break;
                    }
                }
            }
        } else {
            res = false;
        }

        return res;
    }

}
