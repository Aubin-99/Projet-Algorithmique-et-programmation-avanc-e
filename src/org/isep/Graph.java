package org.isep;

import java.util.*;

public abstract class Graph<V extends Comparable<V> > {

    protected int n;
    protected int m;


    public Graph(int nbVertices, int nbEdges) {
        this.n = nbVertices;
        this.m = nbEdges;
    }

    /**
     * Initializes an empty graph
     */
    public  Graph() {

    }

    public  int order(){
        return n;
    }

    public  int size(){
        return m;
    }

    public void setOrder(int n){
        this.n = n;
    }

    public void setSize(int m){
        this.m = m;
    }






}
