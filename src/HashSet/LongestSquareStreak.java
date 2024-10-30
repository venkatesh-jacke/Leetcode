package HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;


//2501. Longest Square Streak in an Array
public class LongestSquareStreak {
    public static void main(String[] args) {
        int nums[] = {4, 3, 6, 16, 8, 2};
        System.out.println(longestSquareStreak(nums));
    }

    static public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (long i : nums) set.add(i);
        int ans = 1;
        for (long i : set) {
            long temp = i;
            int c = 1;
            while (set.contains(temp * temp)) {
                c++;
                temp = temp * temp;
            }
            ans = Math.max(ans, c);
        }
        return ans == 1 ? -1 : ans;
    }
}
