package TwoPointer;

import java.util.Arrays;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        int[][] meetings2 = {{7, 10}, {2, 4}};
        System.out.println(minMeetingRooms(meetings));
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
        while(endPtr < n){
            //Need a new room
            if (startTime[startPtr] < endTime[endPtr]){
                roomInUse++;
                endPtr++;
            }

            //Room is free we can use it
            else{
                roomInUse--;
                startPtr++;
            }
            min_rooms=Math.max(min_rooms,roomInUse);
        }
        return min_rooms;
    }
}
