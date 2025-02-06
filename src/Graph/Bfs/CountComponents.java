package Graph.Bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//323. Number of Connected Components in an Undirected Graph
public class CountComponents {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(n, edges));
    }

    static public int countComponents(int n, int[][] edges) {
        int components = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                bfs(graph, vis, i);
            }
        }
        return components;
    }

    public static void bfs(List<List<Integer>> graph, boolean[] vis, int src) {
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()){
            int cur=q.poll();
            vis[cur]=true;
            for (int neighbor: graph.get(cur)){
                if(!vis[neighbor]){
                    q.add(neighbor);
                    vis[neighbor]=true;
                }
            }
        }
    }
}
