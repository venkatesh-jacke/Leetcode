package Arrays;


//2239. Find Closest Number to Zero
public class FindClosestNumber {
    public static void main(String[] args) {
        int[] nums = {2, -1,1};
        System.out.println(findClosestNumber(nums));
    }

    static public int findClosestNumber(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i : nums) {
            if (Math.abs(i) < Math.abs(res) || i == Math.abs(res)) {
                res = i;
            }
        }
        return res;
    }
}
