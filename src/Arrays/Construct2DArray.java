package Arrays;

import java.util.Arrays;

public class Construct2DArray {
    public static void main(String[] args) {
        int[] arr = {};
        int m = 1;
        int n = 1;
        int[][] res = construct2DArray(arr, m, n);
        for (int[] i : res)
            System.out.println(Arrays.toString(i));
    }

    static public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        if (m * n != original.length)
            return new int[0][0];
        for (int i = 0; i < original.length; i++) {
            res[i / n][i % n] = original[i];
        }
        return res;
    }
}
