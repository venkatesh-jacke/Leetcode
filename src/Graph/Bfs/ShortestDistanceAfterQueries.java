package Graph.Bfs;

import java.util.*;

public class ShortestDistanceAfterQueries {
    public static void main(String[] args) {

    }

    static public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] res = new int[queries.length];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) graph.get(i).add(i + 1);
        for (int i = 0; i < queries.length; i++) {
            graph.get(queries[i][0]).add(queries[i][1]);
            res[i] = bfs(n, graph);
        }
        return res;
    }

    static public int bfs(int n, List<List<Integer>> graph) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();
                if (node == n - 1) return distance;
                for (int neighbor : graph.get(node)) {
                    if (!vis[neighbor]) {
                        vis[neighbor] = true;
                        q.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return  -1;
    }
}
