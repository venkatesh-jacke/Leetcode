package HashSet;

import java.util.*;


//2657. Find the Prefix Common Array of Two Arrays

public class FindThePrefixCommonArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4};
        int[] b = {3, 1, 2, 4};
        System.out.println(Arrays.toString(findThePrefixCommonArray(a, b)));
    }

    static public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(A[i]);
            setB.add(B[i]);
            int commonCount = 0;
            for (int element : setA) {
                if (setB.contains(element)) {
                    commonCount++;
                }
            }

            prefixCommonArray[i] = commonCount;
        }
        return prefixCommonArray;
    }
}
