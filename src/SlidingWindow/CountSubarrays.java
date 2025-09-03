package SlidingWindow;

//2962. Count Subarrays Where Max Element Appears at Least K Times
public class CountSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 3};
        int k = 2;
        System.out.println(countSubarrays(arr, k));
    }

    static public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int maxElement = 0;
        for (int i : nums) maxElement = Math.max(maxElement, i);
        int maxFreq = 0;
        for (int r = 0, l = 0; r < n; r++) {
            if (nums[r] == maxElement) maxFreq++; //monitoring only the maxElement in array
            //if condition satisfies than calculate the ans
            while (l <= r && maxFreq >= k) { //l<=r to chk single element also
                ans += (n - r); // all subarrays starting at index l and ending from r..n-1 are invalid (contain > k maxElement)
                if (nums[l] == maxElement) maxFreq--;
                l++;
            }
        }

        return ans;
    }
}
