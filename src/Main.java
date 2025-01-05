import java.util.*;
import java.util.HashMap;

class Main {


    public static void main(String[] args) {
        int arr[] = {-3, -1, -1, 0, 1, 2};
        int target = -2;
        System.out.println(countTriplets2(arr, target));

    }

    static public int countTriplets(int[] arr, int target) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    static  public int countTriplets2(int[] arr, int target) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            Set<Integer> seen = new HashSet<>();

            // Iterate over the remaining elements
            for (int j = i + 1; j < n; j++) {
                int complement = target - (arr[i] + arr[j]);

                // If complement is in the seen set, it means we found a valid triplet
                if (seen.contains(complement)) {
                    count++;
                }

                // Add the current element to the set for future comparisons
                seen.add(arr[j]);
            }
        }

        return count;
    }

}
