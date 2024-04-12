package Arrays;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_II {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 10, 12, 1, 11};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
    }


    //TC is O(2n)
    //SC is O(n)
    static public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = (2 * n) - 1; i >= 0; i--) {  //traverse circular with same elements
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (!stack.isEmpty())
                arr[i % n] = stack.peek();
            else
                arr[i % n] = -1;
            stack.push(nums[i % n]);

        }
        return arr;
    }

    static public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        Arrays.fill(arr, -1); // Initialize result array with -1 for not found

        for (int i = 0; i < 2 * n - 1; i++) {  // traverse circular with same elements
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                int element = stack.pop(); // Store popped index
                arr[element] = nums[i % n]; // Update result for the popped index
            }

            stack.push(i % n); // Push current index onto the stack
        }

        return arr;

    }
}
