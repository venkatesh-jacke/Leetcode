package Graph.Dfs;

import java.util.*;
import java.util.Arrays;

//684. Redundant Connection

public class FindRedundantConnection {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    static public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            boolean[] vis = new boolean[n];
            if (isConnected(graph, vis, edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
            graph[edge[0] - 1].add(edge[1] - 1);
            graph[edge[1] - 1].add(edge[0] - 1);
        }
        return new int[]{};
    }

    static public boolean isConnected(List<Integer>[] graph, boolean[] vis, int src, int target) {
        vis[src] = true;
        if (src == target) return true;
        boolean connected = false;
        for (int i : graph[src]) {
            if (!vis[i]) {
                connected = connected || isConnected(graph, vis, i, target);
            }
        }
        return connected;
    }

}
