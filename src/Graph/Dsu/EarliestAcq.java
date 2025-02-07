package Graph.Dsu;

//1101. The Earliest Moment When Everyone Become Friends

import java.util.Arrays;

public class EarliestAcq {
    public static void main(String[] args) {
        int[][] logs = {
                {20190101, 0, 1},
                {20190104, 3, 4},
                {20190107, 2, 3},
                {20190211, 1, 5},
                {20190224, 2, 4},
                {20190301, 0, 3},
                {20190312, 1, 2},
                {20190322, 4, 5}
        };
        int n = 6;
        System.out.println(earliestAcq(logs, n));

    }

    static public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,(a,b)->Integer.compare(a[0],b[0]));
        Dsu dsu = new Dsu(n);
        int connections = n;
        for (int[] log : logs) {
            int time = log[0];
            int x = log[1];
            int y = log[2];
            if (dsu.union(x, y)) {
                connections--;
                if (connections == 1) {
                    return time;
                }
            }
        }
        return -1;
    }
}
