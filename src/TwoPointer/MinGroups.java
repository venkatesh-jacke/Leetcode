package TwoPointer;


import java.util.Arrays;

//2406. Divide Intervals Into Minimum Number of Groups
public class MinGroups {
    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals = {
                {5, 10},
                {6, 8},
                {1, 5},
                {2, 3},
                {1, 10}
        };
        System.out.println(minGroups(intervals));
    }

    static public int minGroups(int[][] intervals) {
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
            // If a meeting starts before or when the earliest meeting ends, allocate a new group
            if (startTime[startPtr] <= endTime[endPtr]) {
                groups++;
                startPtr++;
            } else {
                // Otherwise, free up a group as a meeting has ended
                endPtr++;
                groups--;
            }
            min_groups = Math.max(min_groups, groups);
        }
        return min_groups;
    }
}
