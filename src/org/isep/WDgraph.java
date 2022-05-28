package org.isep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class WDgraph extends Graph<Integer> {
    private Map<Integer, ArrayList<DirectedEdge>> adj;

    public WDgraph(){
    }

    public WDgraph(int nbVertices){
        super(nbVertices, 0);
    }

    public WDgraph(int nbVertices, int nbEdges, Map<Integer, ArrayList<DirectedEdge>> adj) {
        super(nbVertices, nbEdges);
        this.adj = adj;
    }


    public void addVertex(int v){
        adj.putIfAbsent(v, new ArrayList<>());
        int n1 = super.n;
        super.setSize(n1 + 1);
    }

    public void removeVertex(int v) {
        adj.values().stream().forEach(e -> removeInArray(e, v));
        adj.remove(v);
    }

    public List<Integer> vertices(){
        List<Integer> out = new ArrayList<>();
        out.addAll(adj.keySet());
        return out;
    }

    public  List<DirectedEdge> inEdges(Integer vertice){
        List<DirectedEdge> out = new LinkedList<>();
        for (Integer source:vertices()
             ) {
            for(DirectedEdge e: outEdges(source)){
                if(e.to() == vertice.intValue()) out.add(e);
            }

        }
        return out;
    }

    public  List<DirectedEdge> outEdges(Integer vertice){
        return (List) adj.get(vertice);
    }


    public List<DirectedEdge> edges(){
        List<DirectedEdge> edges = new LinkedList<>();
        for (int vertex: vertices()) {
                edges.addAll(outEdges(vertex));
                edges.addAll(inEdges(vertex));
        }

        return edges;
    }

    private void removeInArray(ArrayList<DirectedEdge> e, int v) {
        Iterator<DirectedEdge> itr = e.iterator();
        while (itr.hasNext()){
            DirectedEdge directedEdge = itr.next();
            if(directedEdge.from() == v || directedEdge.to()==v){
                itr.remove();
            }
        }
    }

    void addEdge(int v1, int v2, Double weight) {
        adj.get(v1).add(new DirectedEdge(v1, v2, weight));
        int m1 = super.m;
        super.setSize(m1 + 1);
    }

    void removeEdge(int v1, int v2) {

        ArrayList<DirectedEdge> eV1 = adj.get(v1);

        if (eV1 != null)
            eV1.remove(v2);

    }

    public void setAdj(Map<Integer, ArrayList<DirectedEdge>> adj) {
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
