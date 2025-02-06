package Graph.Bfs;

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

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            vis[cur] = true;
            for (int neighbor : graph.get(cur)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        //If any nodes doesn't visited
        for (boolean v : vis) {
            if (!v) return false;
        }
        return true;
    }
}
