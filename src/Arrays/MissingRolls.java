package Arrays;

import java.util.Arrays;

public class MissingRolls {
    public static void main(String[] args) {
        int[] rolls = {3, 2, 4, 3};
        int mean = 4;
        int n = 2;
        System.out.println(Arrays.toString(missingRolls(rolls, mean, n)));
    }

    static public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int currentSum = 0;
        for (int i : rolls)
            currentSum += i;
        int totalSum = mean * (m + n);
        int missingSum = totalSum - currentSum;
        if ((missingSum < n) || (missingSum > 6 * n))
            return new int[0];
        int[] res = new int[n];
        int i = 0;
        while (n > 0) {
            int dice = Math.min(6, missingSum - n + 1);
            res[i++] = dice;
            missingSum -= dice;
            n--;
        }
        return res;
    }
}
