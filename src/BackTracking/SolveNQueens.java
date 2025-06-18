package BackTracking;

//51. N-Queens

import java.util.*;

public class SolveNQueens {
    static List<List<String>> result;

    public static void main(String[] args) {
        int n = 8;
        System.out.println(solveNQueens(n));
    }

    static public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        solve(board, n, 0);
        return result;
    }

    static public void solve(char[][] board, int n, int row) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, n, row, col)) {
                board[row][col] = 'Q';
                solve(board, n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    static public boolean isSafe(char[][] board, int n, int r, int c) {
        for (int row = 0; row < r; row++) {
            if (board[row][c] == 'Q')
                return false;
        }
        for (int row = r, col = c; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 'Q')
                return false;
        }
        for (int row = r, col = c; row >= 0 && col < n; row--, col++) {
            if (board[row][col] == 'Q')
                return false;
        }
        return true;
    }

    static public List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}
