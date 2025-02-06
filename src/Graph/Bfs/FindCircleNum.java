package Graph.Bfs;

import java.util.LinkedList;
import java.util.Queue;

//547. Number of Provinces

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
                bfs(isConnected, vis, n, i);
            }
        }
        return count;
    }


    //Just visiting all neighbour nodes and marking as visited
    public static void bfs(int[][] graph, boolean[] vis, int n, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1 && !vis[i]) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
    }
}
