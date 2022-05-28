package org.isep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

public class GraphFactory {

    public static Digraph<Integer> createDigraphFromTextFile(String path){
        InputStream txt;
        Digraph diGraph = new Digraph(0);
        diGraph.setAdj(new HashMap<>());

        try {
            txt = new FileInputStream(path);

            try (Scanner obj = new Scanner(txt)) {
                while (obj.hasNextLine()) {
                    String currentLine = obj.nextLine();
                    String[] directedEdges = currentLine.split(" ");

                        diGraph.addVertex(Integer.parseInt(directedEdges[0]));
                        diGraph.addVertex(Integer.parseInt(directedEdges[1]));
                        diGraph.addEdge(Integer.parseInt(directedEdges[0]),Integer.parseInt(directedEdges[1]));

                }

            }

            catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return diGraph;
    }

    public static  WDgraph createWDigraphFromTextFile(String path){
        InputStream txt;
        WDgraph wGraph = new WDgraph(0);
        wGraph.setAdj(new HashMap<>());
        try {
            txt = new FileInputStream(path);

            try (Scanner obj = new Scanner(txt)) {
                while (obj.hasNextLine()) {
                    String currentLine = obj.nextLine();
                    String[] directedEdges = currentLine.split(" ");
                    if(directedEdges.length==3) {
                        wGraph.addVertex(Integer.parseInt(directedEdges[0]));
                        wGraph.addVertex(Integer.parseInt(directedEdges[1]));
                        wGraph.addEdge(Integer.parseInt(directedEdges[0]),Integer.parseInt(directedEdges[1]), Double.parseDouble(directedEdges[2]));
                    }
                }

            }

            catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wGraph;
    }

}
