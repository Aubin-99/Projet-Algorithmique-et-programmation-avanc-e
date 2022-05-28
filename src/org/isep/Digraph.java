package org.isep;

import java.util.*;

public class Digraph<V extends Comparable<V>> extends Graph<V> {
    private Map<V, ArrayList<Edge<V>>> adj;

    public Digraph() {

    }


    public Digraph(int nbVertices){
        super(nbVertices, 0);
    }


    public Map<V, ArrayList<Edge<V>>> getAdj() {
        return adj;
    }

    public void addVertex(V v){
        if(!adj.containsKey(v)){

            super.n = super.n + 1;
            adj.put(v, new ArrayList<>());
        }
    }

    public void removeVertex(V v) {
        adj.values().stream().forEach(e -> removeInArray(e, v));
        adj.remove(v);
    }

    private void removeInArray(ArrayList<Edge<V>> e, V v) {
        Iterator<Edge<V>> itr = e.iterator();
        while (itr.hasNext()){
            Edge directedEdge = itr.next();
            if(directedEdge.from() == v || directedEdge.to()== v){
                itr.remove();
            }
        }
    }

    void addEdge(V v1, V v2) {
        adj.get(v1).add(new Edge(v1, v2));
    }

    void removeEdge(int v1, int v2) {
        ArrayList<Edge<V>> eV1 = adj.get(v1);
        if (eV1 != null)
            eV1.remove(v2);
    }

    public void setAdj(Map<V, ArrayList<Edge<V>>> adj) {
        this.adj = adj;
    }



    @Override
    public String toString() {
        final String[] val = {""};
        adj.forEach((key, e) -> {
            val[0] = val[0].concat(key + " -> " + e.toString() +"\n");
        });

        return "Digraph : \n"+ val[0];}
}
