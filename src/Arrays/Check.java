package Arrays;


//1752. Check if Array Is Sorted and Rotated

public class Check {
    public static void main(String[] args) {
        int[] nums = {2,7,4,1,2,6,2};
        System.out.println(check(nums));
    }

    static public boolean check(int[] nums) {
        int n = nums.length;
        int breaks = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                breaks++;
            }
            if (breaks > 1)
                return false;
        }
        return true;
    }
}
