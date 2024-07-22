package Arrays;

import java.util.*;

//1380. Lucky Numbers in a Matrix
public class LuckyNumbers {
    public static void main(String[] args) {

    }
    static   public List<Integer> luckyNumbers(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int min = Integer.MAX_VALUE;
            int minColIdx = 0;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < col; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    minColIdx=j;
                }
            }
            for(int k=0;k<row;k++){
                if(arr[k][minColIdx]>max){
                    max=arr[k][minColIdx];
                }
            }
            if(min==max) res.add(min);
        }
        return res;
    }
}
