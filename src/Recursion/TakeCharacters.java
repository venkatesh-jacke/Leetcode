package Recursion;


////2516. Take K of Each Character From Left and Right
public class TakeCharacters {

    static int minMinutes = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String str = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(str, k));
    }

    static public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        int[] count = new int[3];
        solve(s, k, 0, s.length() - 1, count, 0);
        return minMinutes == Integer.MAX_VALUE ? -1 : minMinutes;
    }

    static void solve(String str, int k, int left, int right, int[] count, int minute) {
        if (count[0] >= k && count[1] >= k && count[2] >= k) {
            minMinutes = Math.min(minMinutes, minute);
            return;
        }
        if (left > right) return;

        //Take from left
        int[] leftCount = count.clone();
        leftCount[str.charAt(left) - 'a']++;
        solve(str, k, left + 1, right, leftCount, minute + 1);

        //take from right
        int[] rightCount = count.clone();
        rightCount[str.charAt(right) - 'a']++;
        solve(str, k, left, right - 1, rightCount, minute + 1);
    }
}
