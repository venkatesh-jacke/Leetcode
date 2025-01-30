package Graph.Dfs;

import java.util.*;


//1462. Course Schedule IV


public class CheckIfPrerequisite {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries = {{1, 0}, {1, 2}};
        System.out.println(checkIfPrerequisite(numCourses, prerequisites, queries));

    }

    static public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : prerequisites) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            boolean[] vis = new boolean[numCourses];
            res.add(isPrerequisite(graph, vis, queries[i][0], queries[i][1]));
        }
        return res;
    }

    static boolean isPrerequisite(Map<Integer, List<Integer>> graph, boolean[] vis, int src, int target) {
        vis[src] = true;
        if (src == target) return true;
        boolean answer = false;
        List<Integer> neighbors = graph.getOrDefault(src, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (!vis[neighbor]) {
                answer = answer || isPrerequisite(graph, vis, neighbor, target);
            }
        }
        return answer;
    }
}
