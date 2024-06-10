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
}
