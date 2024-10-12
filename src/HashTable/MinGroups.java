package HashTable;

import java.util.Arrays;
import java.util.TreeMap;

//2406. Divide Intervals Into Minimum Number of Groups
public class MinGroups {
    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        int[][] meetings2 = {{7, 10}, {2, 4}};
        System.out.println(minGroups(meetings));
    }

    //Line Sweep Algorithm
    static public int minGroups(int[][] intervals) {
        int n = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1]+1, map.getOrDefault(interval[1]+1, 0) - 1); //interval[1]+1 because end time is inclusive
        }
        int cur=0,max=0;
        for(int key:map.keySet()){
            cur+=map.get(key);
            max=Math.max(max,cur);
        }
        return max;
    }
}
