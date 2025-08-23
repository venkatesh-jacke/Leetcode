package SlidingWindow;

//992. Subarrays with K Different Integers

import java.util.HashMap;

public class SubarraysWithKDistinct {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(arr, k));
    }

    static public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    static public int atMost(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int l = 0, r = 0; r < arr.length; r++) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            while (map.size() > k) {
                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
                if (map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;
            }
            cnt += (r - l + 1);
        }
        return cnt;
    }
}
