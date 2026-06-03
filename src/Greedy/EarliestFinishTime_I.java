package Greedy;

//3633. Earliest Finish Time for Land and Water Rides I

public class EarliestFinishTime_I {
    public static void main(String[] args) {
        int[] landStartTime = {2, 8}, landDuration = {4, 1}, waterStartTime = {6}, waterDuration = {3};
        System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    static public int earliestFinishTime_Brute(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int land = landStartTime[i] + landDuration[i];
                int land_water = Math.max(land, waterStartTime[j]) + waterDuration[j];
                res = Math.min(res, land_water);

                int water = waterStartTime[j] + waterDuration[j];
                int water_land = Math.max(water, landStartTime[i]) + landDuration[i];
                res = Math.min(res, water_land);

            }
        }
        return res;
    }

    static public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land_water = solve(landStartTime, landDuration, waterStartTime, waterDuration); //case1: land-->water
        int water_land = solve(waterStartTime, waterDuration, landStartTime, landDuration); //case2: water-->land
        return Math.min(land_water, water_land);

    }

    static public int solve(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]);
        }
        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            finish2 = Math.min(finish2, Math.max(finish1, start2[i]) + duration2[i]);
        }
        return finish2;
    }
}


// Among all possible first rides (Land or Water),
// find the ride that finishes the earliest.
//
// Why?
// For the second ride, finishing the first ride earlier
// is always better (or at least never worse), because:
//
// max(earlierFinish, secondRideStart)
// <=
// max(laterFinish, secondRideStart)
//
// Therefore we only need the minimum finish time of the
// first ride category instead of considering every ride.
//finish1 = Math.min(finish1, start1[i] + duration1[i]);