package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestDistancePairs {
    public static void main(String[] args) {
        int[] nums = {1, 6, 1};
        int k = 3;
        System.out.println(smallestDistancePair(nums, k));
    }

    static public int smallestDistancePair(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                list.add(Math.abs(nums[i] - nums[j]));
            }
        }
        Collections.sort(list);
        System.out.println(list);
        return list.get(k-1);
    }
}
