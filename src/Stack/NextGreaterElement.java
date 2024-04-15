package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;


//496. Next Greater Element I
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement2(nums1, nums2)));
    }

    //TC O(n * m^2).
    //SC O(1)
    static public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    int k = j;
                    while (k < nums2.length) {
                        if (nums2[k] > nums1[i]) {
                            nums1[i] = nums2[k];
                            flag = true;
                            break;
                        }
                        k++;
                    }
                    if (flag) break;
                }
            }
            if (!flag)
                nums1[i] = -1;
        }
        return nums1;

    }


    //TC O(n+m)
    //SC O(m)
    static public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        for (int i = 0; i < nums2.length; i++) {
            int cur = nums2[i];
            while (!stack.isEmpty() && cur > stack.peek() ) {
                int val = stack.pop();
                int ind = map.get(val);
                res[ind] = cur;
            }
            if (map.containsKey(cur))
                stack.push(cur);

        }
        return res;
    }

}
