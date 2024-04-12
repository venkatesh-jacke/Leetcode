package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerElement(arr)));
    }


    //TC O(N)
    //SC O(N)-STACK
    static int[] nextSmallerElement(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            while (!stack.isEmpty() && cur < arr[stack.peek()]) {
                int index = stack.pop();
                res[index] = cur;
            }
            stack.push(i);
        }
        return res;
    }
}
