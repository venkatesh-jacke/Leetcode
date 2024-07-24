package Arrays;

import java.util.*;


//2191. Sort the Jumbled Numbers
public class SortJumbled {
    public static void main(String[] args) {
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
    }

    static public int[] sortJumbled(int[] mapping, int[] nums) {
        ArrayList<Integer[]> pairs = new ArrayList<>();
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs.add(new Integer[]{convert(nums[i], mapping), i});
        }
        pairs.sort((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < pairs.size(); i++) {
            ans[i] = nums[pairs.get(i)[1]];
        }
        return ans;

    }

    static public int convert(int n, int[] mapping) {
        String s = Integer.toString(n);
        StringBuilder newNumber = new StringBuilder();

        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);
            newNumber.append(mapping[digit]);
        }

        return Integer.parseInt(newNumber.toString());
    }
}
