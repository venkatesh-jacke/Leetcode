package Arrays.Matrix;


//2017. Grid Game
public class GridGame {
    public static void main(String[] args) {
        int[][] grid={{2,5,4},{1,5,1}};
        System.out.println();
    }
    static  public long gridGame(int[][] grid) {
        long topSum = 0, bottomSum = 0;
        long minSum = Long.MAX_VALUE;
        for (int i : grid[0]) {
            topSum += i;
        }
        for (int i = 0; i < grid[0].length; i++) {
            topSum -= grid[0][i];
            minSum = Math.min(minSum, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
        }
        return minSum;
    }
}
