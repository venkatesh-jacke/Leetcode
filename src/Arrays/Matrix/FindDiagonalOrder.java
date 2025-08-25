package Arrays.Matrix;

//498. Diagonal Traverse

import java.util.*;

public class FindDiagonalOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
    }

    static public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        if (m == 0) return new int[0];
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }
        int[] ans = new int[m * n];
        int idx = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int diagonal = entry.getKey();
            List<Integer> values = entry.getValue();
            if (diagonal % 2 == 0) {
                for (int i = values.size()-1; i >= 0; i--) {
                    ans[idx++] = values.get(i);
                }
            } else {
                for (int i : values) {
                    ans[idx++] = i;
                }
            }
        }
        return ans;
    }
}
