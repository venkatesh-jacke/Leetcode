package Graph.Dfs;

//547. Number of Provinces

import java.util.LinkedList;
import java.util.Queue;

public class FindCircleNum {
    public static void main(String[] args) {
        int[][] edges = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(edges));
    }

    static public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        //Run bfs on all disconnected components
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(isConnected, vis, n, i);
            }
        }
        return count;
    }


    //Just visiting all neighbour nodes and marking as visited
    public static void dfs(int[][] graph, boolean[] vis, int n, int src) {
        vis[src] = true;
        for (int i = 0; i < n; i++) {
            if (graph[src][i] == 1 && !vis[i]) {
                dfs(graph, vis, n, i);
            }
        }
    }
}
