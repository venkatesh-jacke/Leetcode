package Heap;

import java.util.*;
import java.util.PriorityQueue;

//2064. Minimized Maximum of Products Distributed to Any Store
public class MinimizedMaximum {
    public static void main(String[] args) {
        int n = 6;
        int quantities[] = {11, 6};
        System.out.println(minimizedMaximum(n, quantities));
    }

    static
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        List<int[]> typeStorePairsArray = new ArrayList<>();

        // Push all product types to the list, after assigning one store to each of them
        for (int i = 0; i < m; i++) {
            typeStorePairsArray.add(new int[] { quantities[i], 1 });
        }


        // PriorityQueue<int[]> typeStorePairs = new PriorityQueue<>((a, b) ->
        //     Long.compare((long) b[0] * a[1], (long) a[0] * b[1])
        // );
        PriorityQueue<int[]> typeStorePairs = new PriorityQueue<>((a, b) -> {
            double ratioA = (double) a[0] / a[1];  // Calculate ratio of a
            double ratioB = (double) b[0] / b[1];  // Calculate ratio of b
            return Double.compare(ratioB, ratioA);  // Compare the two ratios
        });
        typeStorePairs.addAll(typeStorePairsArray);

        // Iterate over the remaining n - m stores.
        for (int i = 0; i < n - m; i++) {
            int[] pairWithMaxRatio = typeStorePairs.poll();
            System.out.println(Arrays.toString(pairWithMaxRatio));
            int totalQuantityOfType = pairWithMaxRatio[0];
            int storesAssignedToType = pairWithMaxRatio[1];

            // Push the same element after assigning one more store to its product type
            typeStorePairs.offer(new int[] { totalQuantityOfType, storesAssignedToType + 1 });
        }
        int[] pairWithMaxRatio = typeStorePairs.poll();
        int totalQuantityOfType = pairWithMaxRatio[0];
        int storesAssignedToType = pairWithMaxRatio[1];

        // Return the maximum minimum ratio
        return (int) Math.ceil(
                (double) totalQuantityOfType / storesAssignedToType
        );
    }
}
