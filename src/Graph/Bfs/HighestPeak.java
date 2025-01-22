package Graph.Bfs;


//1765. Map of Highest Peak

import java.util.*;

public class HighestPeak {
    public static void main(String[] args) {
        int[][] isWater = new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(highestPeak(isWater)));
    }

    static public int[][] highestPeak(int[][] isWater) {
        int[] dirs = {-1, 0, 1, 0, -1};
        int rows = isWater.length, cols = isWater[0].length;
        int[][] heights = new int[rows][cols];
        for (int[] row : heights) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    heights[i][j] = 0;
                }
            }
        }
        int nextLevel = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur[] = q.poll();
                for (int d = 0; d < 4; d++) {
                    int newX = cur[0] + dirs[d];
                    int newY = cur[1] + dirs[d + 1];
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && heights[newX][newY] == -1) {
                        heights[newX][newY] = nextLevel;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            nextLevel++;
        }
        return heights;
    }
}
