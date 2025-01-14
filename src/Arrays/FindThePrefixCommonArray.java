package Arrays;

import java.util.Arrays;


//2657. Find the Prefix Common Array of Two Arrays
public class FindThePrefixCommonArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4};
        int[] b = {3, 1, 2, 4};
        System.out.println(Arrays.toString(findThePrefixCommonArray(a, b)));
    }

    static public int[] findThePrefixCommonArray_brute(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];

        for (int i = 0; i < n; i++) {
            int commonCount = 0;
            for (int aIndex = 0; aIndex <= i; aIndex++) {
                for (int bIndex = 0; bIndex <= i; bIndex++) {
                    if (A[aIndex] == B[bIndex]) {
                        commonCount++;
                        break;
                    }
                }
            }
            prefixCommonArray[i] = commonCount;
        }
        return prefixCommonArray;
    }

    static public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        int[] freq = new int[n + 1];
        int common = 0;
        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
            if (freq[A[i]] == 2) common++;
            freq[B[i]]++;
            if (freq[B[i]] == 2) common++;
            prefixCommonArray[i] = common;


        }
        return prefixCommonArray;
    }
}
