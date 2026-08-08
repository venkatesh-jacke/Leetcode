package Recursion;

//486. Predict the Winner

public class PredictTheWinner {
    public static void main(String[] args) {
        int[] arr = {1, 5, 233, 7};
        System.out.println(predictTheWinner(arr));
    }

    static public boolean predictTheWinner(int[] nums) {
        // If my final score difference is >= 0,
        // I can win (or tie).
        return solve(nums, 0, nums.length - 1) >= 0;  //Current player's advantage. if positive player 1 win's
    }

    // Returns:
    // Current player's score - Other player's score
    static public int solve(int[] arr, int left, int right) {
        // Only one number left.
        // Current player takes it.v
        if (left == right) {
            return arr[left];
        }
        int takeLeft = arr[left] - solve(arr, left + 1, right);
        int takeRight = arr[right] - solve(arr, left, right - 1);
        return Math.max(takeLeft, takeRight);
    }
}
