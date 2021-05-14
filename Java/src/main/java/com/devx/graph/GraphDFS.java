package com.devx.graph;

import java.util.LinkedList;

/**
 * @author I348618
 * @since 5/14/2021
 */
public class GraphDFS {

    int v;
    LinkedList<Integer>[] adj;

    public GraphDFS(int vertex) {
        v = vertex;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public String dfsUtil(int u, boolean[] visited) {
        StringBuilder output = new StringBuilder(u + ", ");
        visited[u] = true;
        for(int v : adj[u]) {
            if(!visited[v]) {
                output.append(dfsUtil(v, visited));
            }
        }
        return output.toString();
    }

    public String dfs(int u) {
        boolean[] visited = new boolean[4];
        String dfs = dfsUtil(u, visited);
        for(int i=0; i<4; i++) {
            if(!visited[i]) {
                dfs += dfsUtil(i, visited);
            }
        }
        return dfs;
    }

    public static void main(String[] arg) {
        GraphDFS graph = new GraphDFS(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.print("DFS of the graph: [" + graph.dfs(2) + "]");
    }
}
