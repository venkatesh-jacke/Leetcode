package Arrays.BinarySearch;

//33. Search in Rotated Sorted Array

public class Search {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 3;
        System.out.println(search(nums, target));
    }

    static public int search(int[] nums, int target){
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return mid;
            //Left side sorted
            //include equality (<= / >=) because target can be at boundary positions.
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target <= nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            //Right side sorted
            else {
                if (target >= nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
