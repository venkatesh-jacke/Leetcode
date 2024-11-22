package HashTable;

import java.util.Arrays;
import java.util.HashMap;

//1072. Flip Columns For Maximum Number of Equal Rows
public class MaxEqualRowsAfterFlips {
    public static void main(String[] args) {
        int[][] arr={{0,1},{1,1}};
        System.out.println(maxEqualRowsAfterFlips(arr));
    }
    static public int maxEqualRowsAfterFlips(int[][] arr) {
        int cols=arr[0].length;
        HashMap<String,Integer> map= new HashMap<>();
        for(int[] row:arr){
            StringBuilder pattern= new StringBuilder();
            for(int col=0;col<cols;col++){
                pattern.append(row[0]==row[col]?'T':'F');
            }
            map.put(pattern.toString(),map.getOrDefault(pattern.toString(),0)+1);
        }
        System.out.println(map);
        return map.values().stream().max(Integer::compare).orElse(0);
    }
}
