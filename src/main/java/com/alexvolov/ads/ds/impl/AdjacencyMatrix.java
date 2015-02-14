package com.alexvolov.ads.ds.impl;

import com.alexvolov.ads.ds.Graph;
import com.alexvolov.ads.ds.common.GraphType;

import java.util.HashSet;
import java.util.Set;

import static com.alexvolov.ads.ds.common.GraphType.SIMPLE_DIRECTED;
import static com.alexvolov.ads.ds.common.GraphType.SIMPLE_UNDIRECTED;
import static com.alexvolov.ads.ds.common.GraphType.WEIGHTED_DIRECTED;
import static com.alexvolov.ads.ds.common.GraphType.WEIGHTED_UNDIRECTED;

/**
 * An implementation of graph data structure that is based on adjacency matrix.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 11.02.15
 */
public class AdjacencyMatrix implements Graph {

    private Integer[][] matrix;
    private int size;
    private GraphType graphType;
    private int numberOfEdges;

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

        this.size = size;
        this.matrix = new Integer[size][size];
        this.graphType = graphType;
        this.numberOfEdges = 0;
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

        matrix[i][j] = weight;
        if (graphType == WEIGHTED_DIRECTED) {
            matrix[j][i] = weight * (-1);
        } else {
            matrix[j][i] = weight;
        }
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

        matrix[i][j] = 1;
        if (graphType == SIMPLE_DIRECTED) {
            matrix[j][i] = -1;
        } else {
            matrix[j][i] = 1;
        }
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
        matrix[i][j] = null;
        matrix[j][i] = null;
        numberOfEdges--;
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
            if (null != matrix[vertex][i]) {
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
}
