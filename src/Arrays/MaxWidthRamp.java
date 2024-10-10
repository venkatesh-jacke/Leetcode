package Arrays;

import java.util.Arrays;


//962. Maximum Width Ramp
public class MaxWidthRamp {
    public static void main(String[] args) {
        int[] nums = {6, 0, 8, 2, 1, 5};
        System.out.println(maxWidthRamp(nums));
    }

    static public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> nums[i] != nums[j] ? nums[i] - nums[j] : i - j);
        System.out.println(Arrays.toString(indices));
        int minIdx = n;
        int maxWidth = 0;
        for (int i : indices) {
            maxWidth = Math.max(maxWidth, i - minIdx);
            minIdx = Math.min(minIdx, i);
        }
        return maxWidth;
    }

}
