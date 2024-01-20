package Arrays;


import java.util.ArrayList;
import java.util.*;

//2824. Count Pairs Whose Sum is Less than Target
public class CountPairs {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(-1, 1, 2, 3, 1));
        int target = 2;
        System.out.println(countPairs2(nums, target));


    }


    //Time Complexity O(n^2)
    //Space Complexity O(1)
    static public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }

    //Time Complexity O(NLogN)
    //Space Complexity O(1)

    static public int countPairs2(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            int sum = nums.get(i) + nums.get(j);
            if (sum < target) {
                // If the sum is less than the target, all pairs with the current i element will also be less than the target
                count = count + (j - i);
                i++;
            } else {
                // If the sum is greater or equal to the target, move the j pointer to explore smaller values
                j--;
            }
        }
        return count;
    }
}
