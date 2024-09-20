package BitManipulation;

import java.util.Arrays;

public class XorQueries {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    static public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int idx = 0;
        int[] prefixXor = new int[arr.length + 1];
        for (int i = 1; i < prefixXor.length; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
        }
        for(int[] query:queries){
            int from=query[0];
            int to=query[1];
            res[idx++] = prefixXor[to+1] ^prefixXor[from];
        }
        System.out.println(Arrays.toString(prefixXor));
        return res;
    }
}
