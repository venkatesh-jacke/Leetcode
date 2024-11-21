package TwoPointer;


import java.util.Arrays;

//2563. Count the Number of Fair Pairs
public class CountFairPairs {
    public static void main(String[] args) {
        int[] arr = {0, 1, 7, 4, 4, 5};
        int lower = 3;
        int upper = 6;
        System.out.println(countFairPairs(arr, lower, upper));
    }

    static public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long sumLessThanUpperBound = lowerBound(nums, upper + 1); //all pairs <= upper
        long sumLessThanLowerBound = lowerBound(nums, lower); // all pairs <= lower
        return sumLessThanUpperBound - sumLessThanLowerBound;
    }

    static public long lowerBound(int arr[], int value) {
        int left = 0, right = arr.length - 1;
        long res = 0;
        while (left <= right) {
            if (arr[left] + arr[right] < value) {
                res += right - left;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
