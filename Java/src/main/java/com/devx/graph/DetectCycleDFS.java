package com.devx.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author I348618
 * @since 5/14/2021
 */
class Graph {
    int vertices;
    List<List<Integer>> adj;

    public Graph(int count) {
        vertices = count;
        adj = new ArrayList<>();
        for (int i = 0; i < count; i++)
            adj.add(new LinkedList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public boolean dfsUtil(int u, boolean[] visited, boolean[] recStack) {

        visited[u] = true;
        recStack[u] = true;
        for (int v : adj.get(u)) {
            if (recStack[v])
                return true;
            if (!visited[v])
                dfsUtil(v, visited, recStack);
        }
        recStack[u] = false;
        return false;
    }

    public boolean isCyclicDfs() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfsUtil(i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class DetectCycleDFS {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        if(graph.isCyclicDfs())
            System.out.println("Graph contains cycle");
        else System.out.println("Graph doesn't "
                +"contain cycle");
    }
}
