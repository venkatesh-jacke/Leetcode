package Graph.Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2492. Minimum Score of a Path Between Two Cities
public class MinScore {
    static int minScore = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {
                {1, 2, 9},
                {2, 3, 6},
                {2, 4, 5},
                {1, 4, 7}
        };

        System.out.println(minScore(n, roads));
    }

    static public int minScore(int n, int[][] roads) {
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            graph[u].add(new int[]{v, dist});
            graph[v].add(new int[]{u, dist});
        }
//        for (int i = 1; i <= n; i++) {
//            System.out.print(i + " -> ");
//            for (int[] edge : graph[i]) {
//                System.out.print(Arrays.toString(edge) + " ");
//            }
//            System.out.println();
//        }

        boolean[] vis = new boolean[n+1];
        
        return 1;

    }
}
