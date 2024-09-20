package Arrays;

import java.util.Arrays;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        int rows = 1, cols = 4, rStart = 0, cStart = 0;
        int[][] res = spiralMatrixIII(rows, cols, rStart, cStart);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }

    static public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[rows * cols][2];
        int i = 0, a = 0;
        int steps = 1;
        int r = rStart, c = cStart;
        res[a++] = new int[]{r, c};
        while (a < rows * cols) {
            for (int x = 0; x < 2; x++) {
                int dr = dir[i][0];
                int dc = dir[i][1];
                for (int s = 0; s < steps; s++) {
                    r = r + dr;
                    c = c + dc;
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        res[a++] = new int[]{r, c};
                    }
                }
                i = (i + 1) % 4;
            }
            steps += 1;

        }
        return res;
    }
    
}
