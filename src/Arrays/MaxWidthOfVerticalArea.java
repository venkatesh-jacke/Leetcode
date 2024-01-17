package Arrays;


import java.util.Arrays;
import java.util.Comparator;

//1637. Widest Vertical Area Between Two Points Containing No Points
public class MaxWidthOfVerticalArea {
    public static void main(String[] args) {
        int arr[][] = new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};

        System.out.println(maxWidthOfVerticalArea(arr));

    }


    //Time Complexity O(NlogN)
    //Space Complexity O(1)
    static int maxWidthOfVerticalArea(int[][] arr) {
        int res = 0;
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < arr.length - 1; i++) {
            res = Math.max(res, arr[i + 1][0] - arr[i][0]);

        }
        return res;

    }
}
