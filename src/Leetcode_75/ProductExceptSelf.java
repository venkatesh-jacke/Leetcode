package Leetcode_75;


//238. Product of Array Except Self
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] arr = {23, 2, 4, 6, 6};
        System.out.println(subArray(arr, 7));
    }

    static boolean subArray(int[] arr, int x) {
        int n = arr.length;
        // Pick starting point
        for (int i = 0; i < n; i++) {
            // Pick ending point
            for (int j = i; j < n; j++) {
                // Print subarray between current starting
                // and ending points
                int sum = 0;
                for (int k = i; k <= j; k++)
                    System.out.print(arr[k]+" ");
                System.out.println();

            }
        }
        return false;
    }

    static  int[] subArray2(int[] nums, int x) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];
        for (int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] * nums[i + 1];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = prefix[i] * suffix[i];
        return ans;
    }
}
