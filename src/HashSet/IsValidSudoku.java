package HashSet;

import java.util.HashSet;
import java.util.Set;

//36. Valid Sudoku

public class IsValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku2(board));
    }


    //Time Complexity is O(9*9)
    //Space Complexity is O(1)
    static public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isValid(board, i, j)) return false;
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col) {
        return isValidRow(board, row) && isValidCol(board, col) && isValidBox(board, row - row % 3, col - col % 3);
    }


    //row - row % 3, col - col % 3  this calculates where the 3*3 box starts for a given cell
    private static boolean isValidBox(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cur = board[i + row][j + col];
                if (set.contains(cur)) return false;
                if (cur != '.') set.add(cur);
            }

        }
        return true;
    }

    private static boolean isValidCol(char[][] board, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char cur = board[i][col];
            if (set.contains(cur)) return false;
            if (cur != '.') set.add(cur);
        }
        return true;
    }

    private static boolean isValidRow(char[][] board, int row) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char cur = board[row][i];
            if (set.contains(cur)) return false;
            if (cur != '.') set.add(cur);
        }
        return true;
    }

    //Time	O(1) (or O(N²) generalized)
    //Space	O(1) (or O(N²) generalized)
    static public boolean isValidSudoku2(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur != '.')
                    if (!seen.add(cur + " in row " + i) || !seen.add(cur + " in col " + j) || !seen.add(cur + " in box " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
            }
            System.out.println(seen);
        }
        return true;
    }

    //Time	O(1)
    //Space	O(1)
    static public boolean isValidSudoku3(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                //index = row * number_of_columns + column
                int boxIndex = (i / 3) * 3 + (j / 3);
                int mask = 1 << num;
                if ((row[i] & mask) != 0 || (col[j] & mask) != 0 || ((box[boxIndex] & mask) != 0)) return false;
                row[i] |= mask;
                col[j] |= mask;
                box[boxIndex] |= mask;
            }
        }
        return true;
    }

}
