package Graph.Bfs;


import java.util.*;

//2684. Maximum Number of Moves in a Grid
public class MaxMoves {
    public static final int[] dirs = { -1, 0, 1 };
    public static void main(String[] args) {
        int[][] grid = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        System.out.println(maxMoves(grid));
    }

    static  public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            vis[i][0] = true; // Mark the starting cell as visited
            q.offer(new int[] { i, 0, 0 }); // {row, column, move count}
        }
        while (!q.isEmpty()) {
            int size = q.size();
            // Process all nodes at the current distance level
            while (size-- > 0) {
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];
                int count = cur[2];
                max = Math.max(max, count);
                // Explore all three directions from the current cell.
                for (int dir : dirs) {
                    int newRow = row + dir, newCol = col + 1;
                    if (newRow >= 0 &&
                            newRow < m &&
                            newCol >= 0 &&
                            newCol < n &&
                            !vis[newRow][newCol] &&
                            grid[newRow][newCol] > grid[row][col]) {
                        vis[newRow][newCol] = true;
                        q.offer(new int[] { newRow, newCol, count + 1 });
                    }
                }
            }
        }

        return max;
    }
}
