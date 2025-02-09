package HashTable;

import java.util.HashMap;

//2364. Count Number of Bad Pairs
public class CountBadPairs {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};
        System.out.println();

    }

    static public long countBadPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Long> freq = new HashMap<>();
        long goodPairs = 0;
        long totalPairs = n * (long)(n - 1) / 2;;
        for (int pos = 0; pos < n; pos++) {
            int diff = pos - nums[pos];
            // Add the number of previously seen indices with the same diff
            goodPairs += freq.getOrDefault(diff, 0L);
            freq.put(diff, freq.getOrDefault(diff, 0L) + 1);
        }
        // The number of bad pairs is total pairs minus good pairs.
        return totalPairs - goodPairs;
    }
}
