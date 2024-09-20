package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMinDifference {
    public static void main(String[] args) {
        List<String> time = Arrays.asList("00:00", "23:59", "00:00");
        System.out.println(findMinDifference(time));
    }


    static public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }
        Arrays.sort(minutes);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }
        return Math.min(ans, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);

    }
}
