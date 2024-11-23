package Arrays.Matrix;


import java.util.Arrays;

//867. Transpose Matrix
public class Transpose {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(transpose(arr)));
    }
   static public int[][] transpose(int[][] matrix)  {
       int R = matrix.length, C = matrix[0].length;
       int[][] ans = new int[C][R];
       for (int r = 0; r < R; r++) {
           for (int c = 0; c < C; c++) {
               ans[c][r] = matrix[r][c];
           }
       }
       return ans;
   }
}
