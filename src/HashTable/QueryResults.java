package HashTable;

//3160. Find the Number of Distinct Colors Among the Balls

import java.util.Arrays;
import java.util.HashMap;

public class QueryResults {
    public static void main(String[] args) {
        int limit = 4;
        int[][] queries = new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        System.out.println(Arrays.toString(queryResults(limit, queries)));
    }

    static public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        HashMap<Integer, Long> ballColor = new HashMap<>(); //ball->color
        HashMap<Long, Long> colorCount = new HashMap<>(); //color->count
        int i=0;
        for (int[] q : queries) {
            int ball = q[0];
            long color = q[1];
            // If the ball was already painted, update the count of the previous color
            if (ballColor.containsKey(ball)) {
                Long prevColor = ballColor.get(ball);
                colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                if (colorCount.get(prevColor) == 0) {
                    colorCount.remove(prevColor);
                }
            }
            // Update the count of the new color
            colorCount.put(color, colorCount.getOrDefault(color, 0L) + 1);

            // Paint the ball with the new color
            ballColor.put(ball,color);

            result[i++]=colorCount.size(); //unique colorCount
        }
        return result;
    }
}
