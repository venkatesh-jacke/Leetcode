package Arrays.Matrix;

//3070. Count Submatrices with Top-Left Element and Sum Less Than k

public class CountSubmatrices {
    public static void main(String[] args) {
        int[][] grid = {
                {7, 2, 9},
                {1, 5, 0},
                {2, 6, 6}
        };

        int k = 20;

        System.out.println(countSubmatrices(grid, k));
    }

    static public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] cols = new int[m];
        int res=0;
        for(int i=0;i<m;i++){
            int rowSum =0;
            for(int j=0;j<n;j++){
                cols[j]+=grid[i][j];
                rowSum+=cols[j];
            }
            if(rowSum<=k){
                res++;
            }
        }
        return res;
    }
}
