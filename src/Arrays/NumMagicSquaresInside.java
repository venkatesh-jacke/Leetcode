package Arrays;

import java.util.HashSet;

public class NumMagicSquaresInside {
    public static void main(String[] args) {
        int[][] grid = {{8,1,6}, {3,5,7}, {4,9,2}};
        System.out.println(numMagicSquaresInside(grid));
    }

    static public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i <= cols - 3; i++) {
            for (int j = 0; j <= rows - 3; j++) {
                if (isMagicSquare(i, j, grid)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    static boolean isMagicSquare(int startRow, int startCol, int[][] grid) {
        if (grid[startRow][startCol] > 9)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || !set.add(num)) {
                    return false;
                }
            }
        }


        //Sum of 1st row
        int sum = grid[startRow][startCol] + grid[startRow][startCol + 1] + grid[startRow][startCol + 2];
        for (int i = 0; i < 3; i++) {
            //row
            if (grid[startRow + i][startCol] + grid[startRow + i][startCol + 1]
                    + grid[startRow + i][startCol + 2] != sum) {
                return false;
            }
            //col
            if (grid[startRow][startCol + i] + grid[startRow + 1][startCol + i]
                    + grid[startRow + 2][startCol + i] != sum) {
                return false;
            }
        }
        //Diagonal
        if (grid[startRow][startCol] + grid[startRow + 1][startCol + 1] + grid[startRow + 2][startCol + 2] != sum) {
            return false;
        }
        return true;
    }
}
