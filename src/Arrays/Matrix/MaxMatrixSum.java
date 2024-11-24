package Arrays.Matrix;

public class MaxMatrixSum {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {1, -2, -3}, {1, 2, -3}};
        System.out.println(maxMatrixSum(matrix));
    }

    static public long maxMatrixSum(int[][] matrix) {
        int negativeCount = 0;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        for (int[] row : matrix) {
            for (int i : row) {
                if (i < 0)
                    negativeCount++;
                min = Math.min(min, Math.abs(i));
                sum += Math.abs(i);
            }
        }
        return negativeCount % 2 == 0 ? sum : sum - (2L * min);
    }
}
