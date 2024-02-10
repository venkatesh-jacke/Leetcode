package Graph;

import java.util.LinkedList;
import java.util.Queue;


//547. Number of Provinces
public class FindCircleNum {
    public static void main(String[] args) {
        int graph[][] = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(graph));
    }

    private static void dfs(int[][] graph, int current, boolean[] vis, int n) {
        vis[current] = true;
        for (int i = 0; i < n; i++) {
            if (graph[current][i] == 1 && !vis[i]) {
                dfs(graph, i, vis, n);
            }
        }
    }

    private static void bfs(int[][] graph, int current, boolean[] vis, int n) {
        Queue<Integer> q= new LinkedList<>();
        q.add(current);
        vis[current]=true;
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int k=0;k<n;k++){
                if(graph[curr][k]==1 && !vis[k]){
                    vis[k]=true;
                    q.add(k);
                }
            }
        }
    }

    static public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                bfs(isConnected, i, vis, n);
            }
        }

        return count;
    }
}
