package TwoPointer;

//2210. Count Hills and Valleys in an Array
public class CountHillValley {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 1, 6, 5};
        System.out.println(countHillValley(arr));
    }

    static public int countHillValley(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 1; i < nums.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            if (nums[i] == nums[i - 1]) continue; // Skip duplicates
            
            //go to closest non-equal neighbors
            while (left >= 0 && nums[left] == nums[i]) left--;
            while (right < nums.length && nums[right] == nums[i]) right++;

            if (left >= 0 && right < nums.length) {
                if ((nums[i] > nums[left] && nums[i] > nums[right]) || (nums[i] < nums[left] && nums[i] < nums[right]))
                    count++;

            }
        }
        return count;
    }
}
