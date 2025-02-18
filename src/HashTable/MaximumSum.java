package HashTable;

import java.util.HashMap;
import java.util.TreeSet;

//2342. Max Sum of a Pair With Equal Sum of Digits
public class MaximumSum {
    public static void main(String[] args) {
        int[] arr = {18, 43, 36, 13, 7};
        System.out.println(maximumSum(arr));
    }

    static public int maximumSum(int[] nums)  {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maximumSum = -1;
        for (int num : nums) {
            int digitSum = digitSum(num);
            if (map.containsKey(digitSum)) {
                maximumSum = Math.max(maximumSum, map.get(digitSum)+num);
                map.put(digitSum, Math.max(map.get(digitSum), num));
            } else {
                map.put(digitSum, num);
            }
        }
        return maximumSum;
    }

    static public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
