package Arrays;

public class MinOperations {
    public static void main(String[] args) {
        String str = "110";
        System.out.println();
    }

    static public int[] minOperations_brute(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int steps = 0;
            for (int j = 0; j < i; j++) {
                if (boxes.charAt(j) == '1') {
                    steps += i - j;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (boxes.charAt(k) == '1') {
                    steps += k - i;
                }
            }
            ans[i] = steps;
        }
        return ans;
    }

    static public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];
        int ballsToLeft = 0, ballsToRight = 0, movesToLeft = 0, movesToRight = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = movesToLeft;
            ballsToLeft += Character.getNumericValue(boxes.charAt(i));
            movesToLeft += ballsToLeft;

            ans[n - i - 1] = movesToRight;
            ballsToRight = Character.getNumericValue(boxes.charAt(i));
            movesToRight += ballsToRight;

        }
        return ans;
    }
}
