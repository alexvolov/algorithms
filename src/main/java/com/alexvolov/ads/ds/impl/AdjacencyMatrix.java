package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.GraphEdge;
import com.alexvolov.ads.ds.common.GraphType;

import java.util.*;

import static com.alexvolov.ads.ds.common.GraphType.SIMPLE_DIRECTED;
import static com.alexvolov.ads.ds.common.GraphType.SIMPLE_UNDIRECTED;
import static com.alexvolov.ads.ds.common.GraphType.WEIGHTED_DIRECTED;
import static com.alexvolov.ads.ds.common.GraphType.WEIGHTED_UNDIRECTED;

/**
 * Simple implementation of a graph data structure that is based on adjacency matrix.
 * My version doesn't support resizing and two vertices can't have more than one edge.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 11.02.15
 */
public class AdjacencyMatrix implements Graph {

    private Integer[][] matrix;
    private int size;
    private GraphType graphType;
    private int numberOfEdges;
    private Set<Integer> startNodes;
    private Map<GraphEdge, Integer> edges;

    /**
     * Constrictor which creates a new instance of adjacency matrix.
     *
     * @param size number of vertices.
     * @param graphType type of the graph.
     */
    public AdjacencyMatrix(int size, GraphType graphType) {
        if (size < 1) {
            throw new IllegalArgumentException("Number of vertices must be grater than zero.");
        }

        this.edges = new HashMap<GraphEdge, Integer>();
        this.size = size;
        this.matrix = new Integer[size][size];
        this.startNodes = new HashSet<Integer>();
        this.graphType = graphType;
        this.numberOfEdges = 0;

        for (int i = 0 ; i < size ; i++) {
            startNodes.add(i);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addEdge(int i, int j, Integer weight) {
        if (graphType != WEIGHTED_DIRECTED && graphType != WEIGHTED_UNDIRECTED) {
            throw new UnsupportedOperationException("This operation is not supported for this graphType of graph.");
        }

        if (i > size - 1 || j > size - 1) {
            throw new IllegalArgumentException("Vertex is not found in matrix.");
        }

        if (null == weight) {
            throw new IllegalArgumentException("Weight cannot be null.");
        }

        if (weight < 0 && graphType == WEIGHTED_DIRECTED) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }

        edges.put(new GraphEdge(i, j), weight);
        matrix[i][j] = weight;
        if (null == matrix[j][i]) {
            if (graphType == WEIGHTED_DIRECTED) {
                matrix[j][i] = weight * (-1);
            } else {
                matrix[j][i] = weight;
            }
        }
        startNodes.remove(j);
        numberOfEdges++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addEdge(int i, int j) {
        if (graphType != SIMPLE_DIRECTED && graphType != SIMPLE_UNDIRECTED) {
            throw new UnsupportedOperationException("This operation is not supported for this graphType of graph.");
        }

        if (i > size - 1 || j > size - 1) {
            throw new IllegalArgumentException("Vertex is not found in matrix.");
        }

        edges.put(new GraphEdge(i, j), null);
        matrix[i][j] = 1;
        if (null == matrix[j][i]) {
            if (graphType == SIMPLE_DIRECTED) {
                matrix[j][i] = -1;
            } else {
                matrix[j][i] = 1;
            }
        }
        startNodes.remove(j);
        numberOfEdges++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEdge(int i, int j) {
        if (i > size - 1 || j > size - 1) {
            throw new IllegalArgumentException("Vertex is not found in matrix.");
        }
        edges.remove(new GraphEdge(i, j));
        matrix[i][j] = null;
        matrix[j][i] = null;
        numberOfEdges--;
        if (!hasParents(j)) {
            startNodes.add(j);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Integer> getStartNodes() {
        return startNodes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdjacent(int i, int j) {
        boolean result = false;

        if (null != matrix[i][j]) {
            result = true;
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Integer> getNeighbours(int vertex) {
        if (vertex > size - 1 || vertex < 0) {
            throw new IllegalArgumentException("Given vertex does not exists.");
        }
        Set<Integer> res = new HashSet<Integer>();
        for (int i = 0; i < size; i++) {
            if (null != matrix[vertex][i] && matrix[vertex][i] >= 0) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * Returns a copy of the adjacency matrix.
     *
     * @return adjacency matrix that is 2d array of {@code Integer} values.
     */
    public Integer[][] getMatrix() {
        Integer[][] result = new Integer[size][size];
        for(int i = 0; i < matrix.length; i++) {
            result[i] = matrix[i].clone();
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (null == matrix[i][j]) {
                    result.append("_");
                } else {
                    result.append(matrix[i][j]);
                }
                if (j < size - 1) {
                    result.append(", ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasParents(Integer v) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (null != matrix[i][v] && matrix[i][v] > 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphType getType() {
        return graphType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWeight(int source, int destination) {
        return matrix[source][destination];
    }

    @Override
    public Map<GraphEdge, Integer> getEdges() {
        return edges;
    }

}
