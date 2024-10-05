package HashTable;

import java.util.HashMap;

public class MinSubArray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2};
        int p = 6;
        System.out.println(minSubarray(arr,p));
    }

    static public int minSubarray(int[] nums, int p) {
        int N = nums.length;
        int totalSum = 0;
        int minLen = N;
        for (int i : nums)
            totalSum = (totalSum + i) % p;
        int target = totalSum % p;
        if (target == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cur = 0;
        for (int i = 0; i < N; i++) {
            cur = (cur + nums[i]) % p;
            int need = (cur - target + p) % p;
            if (map.containsKey(need)) {
                minLen = Math.min(minLen, i - map.get(need));
            }
            map.put(cur, i);
        }
        return minLen == N ? -1 : minLen;
    }
}
