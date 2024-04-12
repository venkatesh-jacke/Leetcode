package Graph;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid2));
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    //Time Complexity is O(m*n)
    //Space Complexity is O(m*n)
    private static void dfs(char[][] grid, int i, int j, boolean[][] vis, int m, int n) {

        vis[i][j] = true;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int k = 0; k < dirs.length; k++) {
            int newi = i + dirs[k][0];
            int newj = j + dirs[k][1];

            if (isBound(newi, newj, m, n) && grid[newi][newj] == '1' && !vis[newi][newj]) {
                vis[newi][newj] = true;
                dfs(grid, newi, newj, vis, m, n);
            }

        }
    }

    private static void bfs(char[][] grid, int i, int j, boolean[][] vis, int m, int n) {
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
           Pair curr=q.remove();
            int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};  //Traverse 4 all direction
            for (int k = 0; k < dirs.length; k++) {
                int newi = curr.first + dirs[k][0]; //next neighbor i index
                int newj = curr.second + dirs[k][1];//next neighbor j index
                if (isBound(newi, newj, m, n) && grid[newi][newj] == '1' && !vis[newi][newj]) {
                    vis[newi][newj] = true;
                    dfs(grid, newi, newj, vis, m, n);  //call with next neighbor;s index
                }

            }
        }

    }

    static private boolean isBound(int newi, int newj, int m, int n) {
        return newi >= 0 && newi < m && newj >= 0 && newj < n;
    }

    static public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    c++;
                    bfs(grid, i, j, vis, m, n);
                }
            }
        }
        return c;

    }
}
