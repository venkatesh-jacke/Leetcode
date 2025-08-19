package Arrays.BinarySearch;


import java.util.Arrays;

//2563. Count the Number of Fair Pairs
public class CountFairPairs {
    public static void main(String[] args) {
        int[] arr={0,1,7,4,4,5};
        int lower=3;
        int upper=6;
        System.out.println(countFairPairs(arr,lower,upper));
    }
   static public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            long low = binarySearch(nums, i + 1, n - 1, lower - nums[i]);
            long high = binarySearch(nums, i + 1, n - 1, upper - nums[i] + 1);
            count += (high - low);
        }
        return count;
    }

   static public long binarySearch(int arr[], int low, int high, int element) {
       //System.out.println(element);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
