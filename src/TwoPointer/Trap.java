package TwoPointer;


//42. Trapping Rain Water

public class Trap {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    static public int trap(int[] arr) {
        int n = arr.length;
        int totalWater = 0;
        int l = 0, r = n - 1;
        int maxLeft = 0, maxRight = 0;
        while (l < r) {
            if (arr[l] <= arr[r]) {
                totalWater += Math.max(0, maxLeft - arr[l]);
                maxLeft = Math.max(maxLeft, arr[l]);
                l++;
            } else {
                totalWater += Math.max(0, maxRight - arr[r]);
                maxRight = Math.max(maxRight, arr[r]);
                r--;
            }
        }
        return totalWater;
    }
}
