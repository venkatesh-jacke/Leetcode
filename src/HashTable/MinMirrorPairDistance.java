package HashTable;

import java.util.HashMap;

//3761. Minimum Absolute Distance Between Mirror Pairs

public class MinMirrorPairDistance {
    public static void main(String[] args) {
        int[] nums = {12, 21, 45, 33, 54};
        System.out.println(minMirrorPairDistance(nums));
    }

    static public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x;
            if (seen.containsKey(nums[i])) {
                ans = Math.min(ans, i - seen.get(nums[i]));
            }
            for (x = 0; nums[i] > 0; nums[i] /= 10) {
                x = (x * 10)+(nums[i] % 10) ;
            }
            seen.put(x, i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}

//Store reversed numbers, so when the original appears later, we detect a mirror pair instantly.