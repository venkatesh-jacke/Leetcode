package Strings;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    static public String largestNumber(int[] nums) {
        String[] numsString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsString[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numsString, (a, b) -> (b + a).compareTo(a + b));
        System.out.println(Arrays.toString(numsString));
        StringBuilder sb = new StringBuilder();
        if (numsString[0].equals("0")) return "0";
        for (String s : numsString) {
            sb.append(s);
        }
        return sb.toString();
    }
}
