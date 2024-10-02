package Arrays;

import java.util.*;


//1331. Rank Transform of an Array

public class ArrayRankTransform {
    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30};
        System.out.println(Arrays.toString(arrayRankTransform3(arr)));
    }

    static  public int[] arrayRankTransform(int[] arr) {
        int N = arr.length;
        int[] sortedArr = Arrays.copyOf(arr, N);
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0 && sortedArr[i] > sortedArr[i - 1])
                rank++;
            map.put(sortedArr[i], rank);
        }
        for (int i = 0; i < N; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;

    }

    static public int[] arrayRankTransform2(int[] arr) {
        int N = arr.length;
        int rank = 1;
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            set.add(i);
        for (int i : set) {
            map.put(i, rank);
            rank++;
        }
        for (int i = 0; i < N; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
    static public int[] arrayRankTransform3(int[] arr) {
        int N = arr.length;
        int rank = 1;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        for (int i : map.keySet()) {
            for (int idx : map.get(i)) {
                arr[idx] = rank;
            }
            rank++;
        }
        return arr;

    }
}
