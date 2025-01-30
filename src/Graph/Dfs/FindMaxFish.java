package Graph.Dfs;

//2658. Maximum Number of Fish in a Grid

public class FindMaxFish {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
        System.out.println(findMaxFish(grid));
    }

    static public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxFish = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !vis[i][j]) {
                    maxFish = Math.max(maxFish, dfs(grid, vis, i, j));
                }
            }
        }
        return maxFish;
    }

    static public int dfs(int[][] grid, boolean[][] vis, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || vis[r][c]) {
            return 0;
        }
        vis[r][c] = true;
        return grid[r][c] + dfs(grid, vis, r, c + 1) + dfs(grid, vis, r, c - 1) + dfs(grid, vis, r + 1, c)
                + dfs(grid, vis, r - 1, c);
    }
}
