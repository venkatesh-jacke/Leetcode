package Graph.Dijkstra;

import java.util.PriorityQueue;

public class MinimumObstacles {

    static private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {

    }

    static public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] obstacles = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacles[i][j] = Integer.MAX_VALUE;
            }
        }
        obstacles[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{obstacles[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int obstacle = cur[0], row = cur[1], col = cur[2];
            if (row == m - 1 && col == n - 1)
                return obstacle;
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (isValid(grid, newRow, newCol)) {
                    int newObstacle = obstacle + grid[newRow][newCol];
                    if (newObstacle < obstacles[newRow][newCol]) {
                        obstacles[newRow][newCol] = newObstacle;
                        pq.add(new int[]{newObstacle, newRow, newCol});
                    }
                }
            }
        }

        return obstacles[m - 1][n - 1];

    }

    static
    private boolean isValid(int[][] grid, int row, int col) {
        return (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length);
    }
}
