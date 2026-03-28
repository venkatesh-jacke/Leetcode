package Arrays.Matrix;

//3212. Count Submatrices With Equal Frequency of X and Y

public class NumberOfSubmatrices {
    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'Y', '.'},
                {'Y', '.', '.'}
        };
        System.out.println(numberOfSubmatrices(grid));
    }
    static  public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] sumX = new int[n];
        int[] sumY = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            int xCount = 0, yCount = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X')
                    xCount++;
                else if (grid[i][j] == 'Y')
                    yCount++;
                sumX[j] += xCount;
                sumY[j] += yCount;
                if (sumX[j] > 0 && sumX[j] == sumY[j])
                    res++;
            }
        }
        return res;
    }

}

