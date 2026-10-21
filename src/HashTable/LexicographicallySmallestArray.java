package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

//2948. Make Lexicographically Smallest Array by Swapping Elements

public class LexicographicallySmallestArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 9, 8};
        int limit = 2;
        System.out.println(Arrays.toString(lexicographicallySmallestArray(nums, limit)));

    }

    static public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] numsSorted = new int[nums.length];
        // Sort copy to identify connected groups.
        System.arraycopy(nums, 0, numsSorted, 0, n);
        Arrays.sort(numsSorted);
        int currGroup = 0;
        // value -> group
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);
        // group -> sorted values
        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(currGroup, new LinkedList<>(Arrays.asList(numsSorted[0])));
        for (int i = 1; i < n; i++) {
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
                currGroup++;
            }
            numToGroup.put(numsSorted[i], currGroup);
            if (!groupToList.containsKey(currGroup)) {
                groupToList.put(currGroup, new LinkedList<>());
            }
            groupToList.get(currGroup).add(numsSorted[i]);
        }
        /*
         * Process original array.
         *
         * For each number:
         * 1. Find its group.
         * 2. Take the smallest remaining value from that group.
         */
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }
        return nums;
    }
}
