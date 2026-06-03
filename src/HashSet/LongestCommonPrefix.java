package HashSet;

import java.util.HashSet;

//3043. Find the Length of the Longest Common Prefix
public class LongestCommonPrefix {
    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100}, arr2 = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }

    static public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr1) {
            while (!set.contains(i) && i > 0) {
                set.add(i);
                i /= 10;
            }
        }
        int res = 0;
        for (int i : arr2) {
            while (!set.contains(i) && i > 0) {
                i /= 10;
            }
            //Match found
            if (i > 0) {
                res = Math.max(res, (int) Math.log10(i) + 1);
            }
        }
        return res;
    }
}

