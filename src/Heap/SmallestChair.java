package Heap;

import java.util.*;


//1942. The Number of the Smallest Unoccupied Chair

public class SmallestChair {
    public static void main(String[] args) {
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        int target = 1;
        System.out.println(smallestChair(times, target));
    }

    static public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        // List of arrivals with friend index
        List<int[]> arrivals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrivals.add(new int[]{times[i][0], i});
        }

        // Sort friends by arrival time
        arrivals.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Min-Heap to track available chairs
        //availableChairs[0] = arrival Time
        //availableChairs[1] = index
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        // Priority queue to track when chairs are freed
        //leavingQueue[0] = leaving Time
        //leavingQueue[1] = chair Index
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));


        // Iterate through each friend based on arrival
        for (int[] arrival : arrivals) {
            int arrivalTime = arrival[0];
            int friendIndex = arrival[1];

            // Free chairs that are vacated before the current arrival time
            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrivalTime) {
                availableChairs.add(leavingQueue.poll()[1]);
            }

            // Assign the smallest available chair
            int chair = availableChairs.poll();

            // If this is the target friend, return their chair number
            if (friendIndex == targetFriend) {
                return chair;
            }

            // Mark the chair as being used until the friend's leave time
            leavingQueue.add(new int[]{times[friendIndex][1], chair});
        }

        return -1; // Should never reach here
    }

}