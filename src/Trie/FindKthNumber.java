package Trie;

public class FindKthNumber {
    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 2));
    }

    static public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int step = countSteps(n, cur, cur + 1);
            if (step <= k) {
                cur++;
                k -= step;
            } else {
                cur = cur * 10;
                k--;
            }
        }
        return cur;
    }

    static public int countSteps(int n, long p1, long p2) {
        int steps = 0;
        while (p1 <= n) {
            steps += Math.min(n + 1, p2) - p1;
            p1 *= 10;
            p2 *= 10;
        }
        return steps;
    }
}
