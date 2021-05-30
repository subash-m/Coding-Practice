package com.devx.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author I348618
 * @since 5/30/2021
 */
public class DetectCycleUsingColor {

    private Graph graph;

    public DetectCycleUsingColor(int v) {
        graph = new Graph(v);
    }

    enum Color {
        WHITE,
        GRAY,
        BLACK
    }

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;
        public Graph(int v){
            vertices = v;
            adjList = new LinkedList[v];
            for(int i=0; i<v; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
    }

    void addEdge(int start, int end) {
        graph.adjList[start].add(end);
    }

    boolean dfs(int vertex, Color[] color) {
        color[vertex] = Color.GRAY;
        for(int v : graph.adjList[vertex]) {
            if(color[v] == Color.GRAY)
                return true;
            if(color[v]==Color.WHITE && dfs(v,color))
                return true;
        }
        color[vertex] = Color.BLACK;
        return false;
    }

    boolean dfsDetectCycle(int start, int vertices) {
        Color[] color = new Color[vertices];
        Arrays.fill(color, Color.WHITE);

        for(int i=0; i<vertices; i++) {
            if(color[i] == Color.WHITE && dfs(i, color))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleUsingColor graph = new DetectCycleUsingColor(4);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
//        graph.addEdge(2,0);
        graph.addEdge(2,3);
//        graph.addEdge(3,3);

        if(graph.dfsDetectCycle(0, 4)) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't have any cycle");
        }
    }
}
