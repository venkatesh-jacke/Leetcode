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
        // Iterate through diagonals in ascending order of their keys (i + j)
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int diagonal = entry.getKey();
            List<Integer> values = entry.getValue();
            // Reverse the order for even-numbered diagonals to achieve the upward zigzag direction
            if (diagonal % 2 == 0) {
                for (int i = values.size() - 1; i >= 0; i--) {
                    ans[idx++] = values.get(i);
                }
            } else {
                // Odd-numbered diagonals are traversed downward naturally (no reversal needed)
                for (int val : values) {
                    ans[idx++] = val;
                }
            }
        }
        return ans;
    }
}
