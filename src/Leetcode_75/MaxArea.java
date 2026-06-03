package Leetcode_75;


//11. Container With Most Water
public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    static public int maxArea(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        int ans = 0;
        while (i < j) {
            ans = Math.max(ans, Math.min(nums[i], nums[j]) * (j - i));
            if (nums[i] < nums[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
