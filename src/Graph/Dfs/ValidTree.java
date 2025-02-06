package Graph.Dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//261. Graph Valid Tree
public class ValidTree {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int n = 5;
        System.out.println(validTree(n, edges));
    }

    static public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        if (edges.length != n - 1) return false; // N nodes must have only N-1 edges
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        boolean[] vis = new boolean[n];
        dfs(graph, vis, 0);

        //If any nodes doesn't visited
        for (boolean v : vis) {
            if (!v) return false;
        }
        return true;
    }

    private static void dfs(List<List<Integer>> graph, boolean[] vis, int src) {
        vis[src] = true;
        for (int neighbor : graph.get(src)) {
            if (!vis[neighbor]) {
                dfs(graph, vis, neighbor);
            }
        }
    }


}
