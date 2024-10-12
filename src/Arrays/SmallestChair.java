package Arrays;


import java.util.Arrays;

//1942. The Number of the Smallest Unoccupied Chair
public class SmallestChair {

    public static void main(String[] args) {
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        int target = 1;
        System.out.println(smallestChair(times, target));
    }

    static public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[] chairs = new int[n];
        int[] targetTime = times[targetFriend];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] time : times) {
            for (int i = 0; i < n; i++) {
                if (chairs[i] <= time[0]) {
                    chairs[i] = time[1];
                    if (Arrays.equals(targetTime, time))
                        return i;
                    break;

                }
            }
        }
        return 0;
    }
}
