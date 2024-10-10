package Stack;

import java.util.Stack;

//962. Maximum Width Ramp
public class MaxWidthRamp {

    public static void main(String[] args) {
        int[] nums = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println(maxWidthRamp(nums));
    }

    static public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        System.out.println(stack);
        int maxWidth = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                maxWidth = Math.max(maxWidth, i - stack.peek());
                stack.pop();
            }
        }
        return maxWidth;
    }
}
