package com.alexvolov.ads.ds.common;

/**
 * Represent edge in a graph.
 *
 * @author Alexander Volov (mailto: alevolov@gmail.com)
 * @version 07.03.15
 */
public class GraphEdge {

    private int source;
    private int destination;

    /**
     * Constructs a new instance of edge in the graph.
     *
     * @param source source vertex.
     * @param destination destination vertex.
     */
    public GraphEdge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphEdge graphEdge = (GraphEdge) o;

        if (destination != graphEdge.destination) return false;
        if (source != graphEdge.source) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = source;
        result = 31 * result + destination;
        return result;
    }

}
