package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        int[][] meetings2 = {{7, 10}, {2, 4}};
        System.out.println(minMeetingRooms(meetings));
    }

    static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        heap.add(intervals[0][1]);
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.poll();
            }
            heap.add(intervals[i][1]);
        }
        return heap.size();
    }
}
