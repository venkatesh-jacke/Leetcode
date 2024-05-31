import java.util.Arrays;


//1275. Find Winner on a Tic Tac Toe Game
public class TicTacToe {
    public static void main(String[] args) {
        int[][] moves = {
                {0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}
        };

        System.out.println(tictactoe(moves));
    }

    static  public String tictactoe(int[][] moves) {
        char[][] grid = new char[3][3];
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }
        boolean A = true;
        for (int[] pos : moves) {
            if (A) {
                grid[pos[0]][pos[1]] = 'X';
                A = false;
            } else {
                grid[pos[0]][pos[1]] = 'O';
                A = true;
            }
        }
        // Rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2])
                return grid[i][0] == 'X' ? "A" : "B";

        }

        // Cols
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] != ' ' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i])
                return grid[0][i] == 'X' ? "A" : "B";
        }
        // Diagonals
        if (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return grid[0][0] == 'X' ? "A" : "B";
        }
        if (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return grid[0][2] == 'X' ? "A" : "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
