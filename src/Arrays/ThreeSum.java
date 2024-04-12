package Arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1};
        System.out.println(threeSum(arr));
    }

    static public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            int cur = nums[i];
            if (i > 0 && cur == nums[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> li = new ArrayList<>(Arrays.asList(nums[left],nums[right],cur));
                    res.add(li);
                    left++;
                    right--;
                    while (nums[left] == nums[left -1] && left < right) left++;
                    while (nums[right] == nums[right + 1] && left < right) right--;
                }
                else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return res;
    }
}
