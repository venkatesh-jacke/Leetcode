package TwoPointer;

public class FindLengthOfShortestSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(findLengthOfShortestSubarray(arr));
    }

    static  public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0, right = arr.length - 1;

        //Find the rightmost part of the array that is already sorted.
        while (right - 1 >= 0 && arr[right - 1] <= arr[right])
            right--;
        //If the entire array is already sorted, no elements need to be removed.
        int ans = right;

        while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
            // Move `right` until `arr[left]` can be merged with the sorted right part.
            while (right < arr.length && arr[left] > arr[right]) {
                right++;
            }
            ans = Math.min(ans, right - left - 1);
            left++;
        }
        return ans;
    }
}
