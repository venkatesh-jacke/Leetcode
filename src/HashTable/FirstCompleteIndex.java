package HashTable;


import java.util.HashMap;

//2661. First Completely Painted Row or Column

public class FirstCompleteIndex {
    public static void main(String[] args) {
        int[] arr = {1,4,5,2,6,3};
        int[][] mat = {
                {4,3,5},
                {1,2,6}
        };
        System.out.println(firstCompleteIndex(arr, mat));
    }

    static public int firstCompleteIndex(int[] arr, int[][] mat){
        int m = mat.length, n = mat[0].length;
        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i,j});
            }
        }
        int[] rowFreq = new int[m];
        int[] colFreq = new int[n];
        for (int i = 0; i < arr.length; i++) {
           int[] position = map.get(arr[i]);
            int r = position[0];
            int c =position[1];;
            rowFreq[r]++;
            colFreq[c]++;
            if (rowFreq[r] == n || colFreq[c]==m ) {
                return i;
            }
        }
        return -1;

    }
}
