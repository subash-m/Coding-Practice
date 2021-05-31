package com.devx.graph;

/**
 * @author I348618
 * @since 5/30/2021
 */
public class UnionFindForCycle {
    class Subset {
        int parent, rank;
    }
    class Edge {
        int src, dest;
    }
    static class Graph {
        int noVertices, noEdges;
        Edge[] edge;
        public Graph(int v, int e) {
            noVertices = v;
            noEdges = e;
            edge = new Edge[e];
        }
    }

    int find(Subset[] subsets, int key) {
        if(subsets[key].parent != key) {
            subsets[key].parent = find(subsets, subsets[key].parent);
        }
        return subsets[key].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);
        if(subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else if(subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else {
            subsets[xRoot].parent = yRoot;
            subsets[yRoot].rank++;
        }
    }

    void isCyclic(Graph graph) {
        Subset[] subsets = new Subset[graph.noVertices];
        for(int i=0; i<graph.noVertices; i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        boolean isCyclic = false;
        for(Edge edge : graph.edge) {
            int xRoot = find(subsets, edge.src);
            int yRoot = find(subsets, edge.dest);
            if(xRoot == yRoot) {
                isCyclic = true;
                break;
            }
            union(subsets, xRoot, yRoot);
        }
        if(isCyclic) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't have any cycle");
        }
    }

    public static void main(String[] args) {
        int v = 3, e = 3;
        Graph graph = new Graph(v, e);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        UnionFindForCycle prg = new UnionFindForCycle();
        prg.isCyclic(graph);

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        prg.isCyclic(graph);
    }
}
