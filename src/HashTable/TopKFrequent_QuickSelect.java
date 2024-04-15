package HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class TopKFrequent_QuickSelect {

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

    }

    static HashMap<Integer, Integer> map;
    static int[] arr;

    static public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int n = map.size();
        arr = new int[n];
        int j = 0;
        for (int i : map.keySet()) arr[j++] = i;
        quickSelect(0, n - 1, n - k);


        return Arrays.copyOfRange(arr, n - k, n);

    }

    public static void quickSelect(int left, int right, int k) {
        if (left < right) {
            int pi = partition(left, right, right);
            if (pi == k) return;
            if (pi > k) quickSelect(left, pi - 1, k);
            else quickSelect(pi + 1, right, k);
        }
    }

    public static int partition(int low, int high, int piIndex) {
        int pivotFreq = map.get(arr[piIndex]);
        int i = low - 1;
        for (int j = low; j <= high; j++) {
            if (map.get(arr[j]) < pivotFreq) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, piIndex);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
