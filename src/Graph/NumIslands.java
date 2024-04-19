package Graph;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;


//200. Number of Islands
public class NumIslands {
    static class MyPair {
        int first;
        int second;

        MyPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
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
   static public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(grid, visited, i, j, row, col);
                }
            }
        }
        return count;
    }
   static public boolean isSafe(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    static public void dfs(char[][] grid, boolean[][] vis, int i, int j, int row, int col) {
        vis[i][j] = true;
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        for (int k = 0; k < dir.length; k++) {
            int newi = i + dir[k][0];
            int newj = j + dir[k][1];
            if (isSafe(newi, newj, row, col) && grid[newi][newj] == '1' && !vis[newi][newj]) {
                vis[newi][newj] = true;
                dfs(grid, vis, newi, newj, row, col);
            }
        }
    }
   static public void bfs(char[][] grid, boolean[][] vis, int i, int j, int row, int col) {
        Queue<MyPair> q = new LinkedList<>();
        q.add(new MyPair(i, j));
        while (!q.isEmpty()) {
            MyPair cur = q.remove();
            int curi = cur.first;
            int curj = cur.second;
            int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
            for (int k = 0; k < dir.length; k++) {
                int newi = curi + dir[k][0];
                int newj = curj + dir[k][1];
                if (isSafe(newi, newj, row, col) && grid[newi][newj] == '1' && !vis[newi][newj]) {
                    vis[newi][newj] = true;
                    q.add(new MyPair(newi,newj));
                }
            }
        }
    }
}
