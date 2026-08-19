package BitManipulation;

import java.util.Arrays;
import java.util.HashMap;

//1386. Cinema Seat Allocation

public class MaxNumberOfFamilies {
    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = {{4, 3}, {1, 4}, {4, 6}, {1, 7}};
        maxNumberOfFamilies(3, new int[][]{
                {1, 2},
                {1, 3},
                {1, 8},
                {2, 6},
                {3, 1},
                {3, 10}
        });
        //System.out.println(maxNumberOfFamilies(n, reservedSeats));
    }

    static public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // row -> bitmask of reserved seats
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // Mark this seat as reserved
            // Example: row=1, col=3
            // old mask       = 0000  -> seats already reserved
            // 1 << 3         = 1000  -> mark seat 3
            // oldMask | seat = 1000  -> keep old + add new seat
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }
        // All rows without reservations can fit 2 families
        int ans = (n - map.size()) * 2;
        // Masks for the three possible family blocks
        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int reserved : map.values()) {
            boolean canLeft = (reserved & left) == 0;
            boolean canMiddle = (reserved & middle) == 0;
            boolean canRight = (reserved & right) == 0;
            if (canLeft && canRight) {
                // Left and right don't overlap
                ans += 2;
            } else if (canLeft || canRight || canMiddle) {
                // Only one block can be used
                ans += 1;
            }
        }

        return ans;
    }
}
