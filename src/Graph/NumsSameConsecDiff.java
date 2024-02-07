package Graph;

import java.util.*;


//967. Numbers With Same Consecutive Differences
public class NumsSameConsecDiff {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
    }

    private static void dfs(int i, int n, int k, List<Integer> res) {
        if (n == 0) {
            res.add(i);
            return;
        }
        int lastDigit = i % 10;
        if (k != 0 && lastDigit + k <= 9)
            dfs(i * 10 + lastDigit + k, n - 1, k, res);
        if (lastDigit - k >= 0)
            dfs(i * 10 + lastDigit - k, n - 1, k, res);
    }

    private static int[] bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        // Add digits 1 through 9 to the queue to start the BFS
        for (int i = 1; i <= 9; i++)
            q.add(i);

        // Initialize the length of numbers being generated
        int len = 1;

        // Continue BFS until either the queue is empty or the desired length is reached
        while (!q.isEmpty() && len < n) {
            len++; // Increment the length for the next level
            int s = q.size(); // Get the number of elements at the current level

            // Process each element at the current level
            for (int i = 0; i < s; i++) {
                int current = q.remove();
                int lastDigit = current % 10;
                if (k != 0 && lastDigit + k <= 9)
                    q.add(current * 10 + lastDigit + k);
                if (lastDigit - k >= 0)
                    q.add(current * 10 + lastDigit - k);
            }
        }
        int res[] = new int[q.size()];
        int a = 0;
        while (!q.isEmpty()) {
            res[a++] = q.remove();
        }

        // Return the array containing all numbers of length n with the given difference k
        return res;
    }


    static public int[] numsSameConsecDiff(int n, int k) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 1; i <= 9; i++) {
//            dfs(i, n - 1, k, res);
//        }
//
//        int[] ans = new int[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            ans[i] = res.get(i);
//        }
//        return ans;

        return bfs(n,k);
    }
}
