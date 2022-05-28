package org.isep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DijkstraSP {
    private Boolean[] marked;
    private int[] previous;
    private int[] distance;

    private DirectedEdge[] directedEdges;


    public DijkstraSP() {
    }

    public DijkstraSP(Boolean[] marked,  int[] previous, int[] distance) {
        this.marked = marked;
        this.previous = previous;
        this.distance = distance;
    }


    public Boolean verifyNonNegative(WDgraph G){
        List<Integer> vertices = G.vertices();
        for (int vertex: vertices
             ) {
            for(DirectedEdge e: G.outEdges(vertex)){
                if(e.weight() <= 0) return false;
            }
            for(DirectedEdge e: G.inEdges(vertex)){
                if(e.weight() <= 0) return false;
            }
        }

        return true;
    }



    public double distTo(int v) {
        validateVertex(v);
        return distance[v];
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distance[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> printSP(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = directedEdges[v]; e != null; e = directedEdges[e.from()]) {
            path.push(e);
        }
        return path;
    }

    private void validateVertex(int v) {
        int V = distance.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }



    public Boolean[] getMarked() {
        return marked;
    }

    public void setMarked(Boolean[] marked) {
        this.marked = marked;
    }

    public int[] getPrevious() {
        return previous;
    }

    public void setPrevious(int[] previous) {
        this.previous = previous;
    }

    public int[] getDistance() {
        return distance;
    }

    public void setDistance(int[] distance) {
        this.distance = distance;
    }
}
