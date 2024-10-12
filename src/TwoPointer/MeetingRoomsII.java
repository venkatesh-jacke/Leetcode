package TwoPointer;

import java.util.Arrays;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals = {
                {5, 10},
                {6, 8},
                {1, 5},
                {2, 3},
                {1, 10}
        };
        System.out.println(minMeetingRooms(intervals));
    }

    static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int startPtr = 0, endPtr = 0, min_rooms = 0, roomInUse = 0;
        while(startPtr < n){
           // If a meeting starts before or when the earliest meeting ends, allocate a new group
            if (startTime[startPtr] < endTime[endPtr]){
                roomInUse++;
                startPtr++;
            }

            // Otherwise, free up a group as a meeting has ended
            else{
                roomInUse--;
                endPtr++;
            }
            min_rooms=Math.max(min_rooms,roomInUse);
        }
        return min_rooms;
    }
}
