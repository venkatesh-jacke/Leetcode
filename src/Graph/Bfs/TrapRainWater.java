package Graph.Bfs;

import java.util.Arrays;
import java.util.PriorityQueue;


//407. Trapping Rain Water II

public class TrapRainWater {
    public static void main(String[] args) {
        int[][] heights = {
                {3, 3, 3, 3, 3},
                {3, 2, 2, 2, 3},
                {3, 2, 1, 2, 3},
                {3, 2, 2, 2, 3},
                {3, 3, 3, 3, 3}
        };
        System.out.println(trapRainWater(heights));
    }

    static public int trapRainWater(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int trappedWater = 0;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        //Add all boundary cells to the priority queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == n - 1 || j == 0) {
                    vis[i][j] = true;
                    pq.offer(new int[] { arr[i][j], i, j });
                }
            }
        }
        int level = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int ht = cur[0];
            int x = cur[1];
            int y = cur[2];
            level = Math.max(level, ht); //store maximum height traversing level by level
            int[] dirs = { -1, 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++) {
                int newX = x + dirs[i];
                int newY = y + dirs[i + 1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !vis[newX][newY]) {
                    vis[newX][newY] = true;
                    pq.offer(new int[] { arr[newX][newY], newX, newY });
                    // If the neighboring cell is lower than the current water level, water is trapped
                    if (arr[newX][newY] < level) {
                        trappedWater += level - arr[newX][newY];
                    }
                }
            }

        }
        return trappedWater;
    }
}


//https://leetcode.com/problems/trapping-rain-water-ii/solutions/1138028/python3-visualization-bfs-solution-with-explanation/