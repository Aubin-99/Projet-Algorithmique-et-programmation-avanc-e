package org.isep;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Juste\\Downloads\\graph-WDG.txt";
        WDgraph wGraph = GraphFactory.createWDigraphFromTextFile(path);
        Digraph<Integer> diGraph = GraphFactory.createDigraphFromTextFile(path);
        System.out.println(wGraph);
    }


    List<Integer> depthFirstTraversal(Graph graph, Integer root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }
}
