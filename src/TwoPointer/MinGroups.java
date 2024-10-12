package TwoPointer;


import java.util.Arrays;

//2406. Divide Intervals Into Minimum Number of Groups
public class MinGroups {
    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        int[][] meetings2 = {{7, 10}, {2, 4}};
        System.out.println(minGroups(meetings));
    }
    static  public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int startPtr = 0, endPtr = 0, groups = 0, min_groups = 0;
        while (startPtr < n) {
            if (startTime[startPtr] <= endTime[endPtr]) {
                groups++;
                startPtr++;
            } else {
                endPtr++;
                groups--;
            }
            min_groups = Math.max(min_groups, groups);
        }
        return min_groups;
    }
}
