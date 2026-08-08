package Graph.Dijkstra;

//3286. Find a Safe Walk Through a Grid

import java.util.*;

//3286. Find a Safe Walk Through a Grid

//This Dijkstra solution tracks the minimum health lost to reach each cell.
//Remaining Health = Initial Health - Health Lost
public class FindSafeWalk {
    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 1, 1),
                Arrays.asList(1, 0, 1),
                Arrays.asList(1, 1, 1)
        );
        int health = 5;
        System.out.println(findSafeWalk(grid, health));
    }

    static public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], -1);
        }
        int[][] dir = {
                {-1, 0}, // Up
                {0, 1},  // Right
                {1, 0},  // Down
                {0, -1}  // Left
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        //{health,row,col}
        pq.offer(new int[]{grid.get(0).get(0), 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0];
            int cx = cur[1];
            int cy = cur[2];
            //"If we've already found the minimum cost to reach this cell, skip it."
            if (dis[cx][cy] >= 0) continue;
            dis[cx][cy] = val;
            for (int[] d : dir) {
                int newX = cx + d[0];
                int newY = cy + d[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && dis[newX][newY] < 0) {
                    pq.offer(new int[]{val + grid.get(newX).get(newY),newX,newY});
                }
            }
        }
        return dis[m - 1][n - 1] < health;
        //"If the minimum health lost to reach the destination is less than my initial health, then I can safely reach the destination."
    }
}

//The first time a node is removed from the PriorityQueue, we have already found the minimum possible cost to reach it.
//Since the queue always pops the smallest cost first, no later entry can have a smaller cost.
