package com.devx.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author I348618
 * @since 5/14/2021
 */
public class GraphBFS {
    int vertex;
    LinkedList<Integer>[] adj;

    public GraphBFS(int v) {
        vertex = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void bfs(int v) {
        Queue queue = new LinkedList();
        boolean[] visited = new boolean[vertex];
        queue.add(v);
        visited[v] = true;

        String output = "[";
        while(!queue.isEmpty()) {
            int u = (int) queue.poll();
            output += u + ", ";
            for(int adjacentVertex: adj[u]) {
                if(!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                }
            }
        }
        System.out.println("BFS: " + output + "]");
    }
    public static void main(String args[])
    {
        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);
    }
}
