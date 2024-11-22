package Arrays.Matrix;

import java.util.Arrays;


//1072. Flip Columns For Maximum Number of Equal Rows
public class MaxEqualRowsAfterFlips {
    public static void main(String[] args) {
        int[][] arr={{0,1},{1,1}};
        System.out.println(maxEqualRowsAfterFlips(arr));
    }
    static public int maxEqualRowsAfterFlips(int[][] arr) {
        int cols=arr[0].length;
        int ans=0;
        for(int[] row:arr){
            int[] flip=new int[cols];
            int count=0;
            for(int col=0;col<cols;col++){
                flip[col]=1-row[col];
            }
            for(int[] compareRow:arr){
                if(Arrays.equals(compareRow,row)|| Arrays.equals(compareRow,flip)){
                    count++;
                }
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
