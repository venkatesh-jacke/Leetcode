package Arrays;

import java.util.Arrays;

public class LeftmostBuildingQueries {
    public static void main(String[] args) {
        int[] heights = {6, 4, 8, 5, 2, 7};
        int[][] queries = {
                {0, 1},
                {0, 3},
                {2, 4},
                {3, 4},
                {2, 2}
        };
        System.out.println(Arrays.toString(leftmostBuildingQueries(heights, queries)));

    }

    static public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < queries.length; i++) {
            Arrays.sort(queries[i]);
            int a = queries[i][0];
            int b = queries[i][1];
            if (a == b || heights[b] > heights[a]) {
                res[i] = b;
                continue;
            }
            for (int j = b + 1; j < heights.length; j++) {
                if (heights[j] > Math.max(heights[a], heights[b])) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}
