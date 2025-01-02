package TwoPointer;

import java.util.Arrays;
import java.util.List;


//https://www.hackerrank.com/challenges/game-of-two-stacks/problem
public class GameOfTwoStacks {
    public static void main(String[] args) {
        int maxSum = 10;
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> b = Arrays.asList(6, 7, 8, 9);
        System.out.println(twoStacks(maxSum, a, b));
    }

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int maxCount, sum = 0, i = 0, j = 0;
        while (i < a.size() && sum + a.get(i) <= maxSum) {
            sum += a.get(i);
            i++;
        }
        maxCount = i;
        while (j < b.size() && (i > 0 || sum + b.get(j) <= maxSum)) {
            sum += b.get(j);
            j++;
            while (sum > maxSum && i > 0) {
                i--;
                sum -= a.get(i);

            }
            if (sum <= maxSum) {
                maxCount = Math.max(maxCount, i + j);
            }
        }

        return maxCount;
    }
}
