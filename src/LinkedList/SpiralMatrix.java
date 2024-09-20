package LinkedList;

import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        int m = 3;
        int n = 5;
        ListNode head = ListNode.createLinkedList(arr);
        int[][] res = spiralMatrix(m, n, head);
        for (int[] i : res)
            System.out.println(Arrays.toString(i));
    }

    static public int[][] spiralMatrix(int m, int n, ListNode head) {
        int i = 0, j = 0, cur_dir = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[m][n];
        for (int[] k : res)
            Arrays.fill(k, -1);
        while (head != null) {
            res[i][j] = head.val;
            
            // Calculate the next cell's row (newi) and column (newj) based on the current direction.
            int newi = i + dir[cur_dir][0];
            int newj = j + dir[cur_dir][1];

            // Check if the new position is out of bounds or already filled.
            // If so, change the direction by moving clockwise.
            if (Math.min(newi, newj) < 0 || newi >= m || newj >= n || res[newi][newj] != -1) {
                cur_dir = (cur_dir + 1) % 4;
            }
            i += dir[cur_dir][0];
            j += dir[cur_dir][1];
            head = head.next;
        }
        return res;
    }
}
