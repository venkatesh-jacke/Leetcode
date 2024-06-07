package Leetcode_75;


//605. Can Place Flowers
public class CanPlaceFlowers {
    public static void main(String[] args) {

    }
    static public boolean canPlaceFlowers(int[] arr, int n) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                boolean leftPot = (i == 0) || (arr[i - 1] == 0);
                boolean rightPot = (i == len - 1) || (arr[i + 1] == 0);
                if (leftPot && rightPot) {
                    arr[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
