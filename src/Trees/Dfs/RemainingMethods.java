package Trees.Dfs;

import java.util.ArrayList;
import java.util.List;

//3310. Remove Methods From Project
public class RemainingMethods {
    public static void main(String[] args) {
        int n = 5, k = 0;
        int[][] invocations = {{1, 2}, {0, 2}, {0, 1}, {3, 4}};
        System.out.println(remainingMethods(n, k, invocations));
    }

    static public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int edge[] : invocations) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }
        // suspicious[i] = true if reachable from k
        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);
        // If any safe method calls a suspicious method,
        // we cannot remove the suspicious group.
        for (int[] edge : invocations) {
            int from = edge[0];
            int to = edge[1];
            if (!suspicious[from] && suspicious[to]){
                // Return all methods
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) res.add(i);
        }
        return res;

    }

    static public void dfs(int k, List<Integer>[] graph, boolean[] suspicious) {
        suspicious[k] = true;
        for (int neighbor : graph[k]) {
            if (!suspicious[neighbor]) {
                dfs(neighbor, graph, suspicious);
            }
        }
    }
}
