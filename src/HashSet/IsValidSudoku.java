package HashSet;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    static int c = 0;

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
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


    static public boolean isValidSudoku2(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur= board[i][j];
                if(cur!='.')
                    if(!seen.add(cur+" in roe "+i)|| !seen.add(cur+" in col "+j) ||!seen.add(cur+" in box "+i/3+"-"+j/3)){
                        return  false;
                }
            }
            System.out.println(seen);
        }
        return  true;
    }

}
