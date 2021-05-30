package com.devx.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author I348618
 * @since 5/30/2021
 */
public class DetectCycleUndirected {

    private Graph graph;

    public DetectCycleUndirected(int v) {
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
        graph.adjList[end].add(start);
    }

    boolean dfs(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        for(int v : graph.adjList[vertex]) {
//            if(!visited[v]) {
//                if(dfs(v, visited, vertex))
//                    return true;
//            } else if(v!=parent)
//                return true;

            if((visited[v]&&v!= parent)||(!visited[v] && dfs(v, visited, vertex))) {
                return true;
            }
        }
        return false;
    }

    void dfsDetectCycle(int vertices) {
        boolean[] visited = new boolean[vertices];
        boolean isCyclic = false;
        for(int i=0; i<vertices; i++) {
            if(!visited[i] && dfs(i, visited, -1)) {
                isCyclic = true;
                break;
            }
        }
        if(isCyclic) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't have any cycle");
        }
    }

    public static void main(String[] args) {
        DetectCycleUndirected graph = new DetectCycleUndirected(4);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.dfsDetectCycle(4);

        graph.addEdge(1, 2);
        graph.dfsDetectCycle(4);
    }
}
