package Heap;

import java.util.Collections;
import java.util.PriorityQueue;


//2500. Delete Greatest Value in Each Row
public class DeleteGreatestValue {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        System.out.println(deleteGreatestValue(grid));
    }

    // static public int deleteGreatestValue(int[][] grid) {
    // int rows=grid.length,cols=grid[0].length;
    // int sum=0;
    // for(int i[]:grid){
    // Arrays.sort(i);
    // }
    // for(int col=cols-1;col>=0;col--){
    // int max=1;
    // for(int row=0;row<rows;row++){
    // max=Math.max(max,grid[row][col]);

    // }
    // System.out.println(max);
    // sum+=max;
    // }
    // return sum;
    // }


    //Space is O(m) Time is O(n∗mlogm)
    static public int deleteGreatestValue(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int[] sum = new int[grid[0].length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pq.add(grid[i][j]);
            }
            int k = grid[i].length;
            while (k-- > 0) {
                int t = pq.poll();
                sum[k] = Math.max(sum[k], t);

            }

        }
        for (int i : sum)
            ans += i;
        return ans;
    }
}
