package Heap;

import javafx.util.Pair;

import java.util.*;

public class MincostToHireWorkers {
    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;
        System.out.println(mincostToHireWorkers(quality, wage, k));
    }

    static public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;
        List<Pair<Double, Integer>> wageToQualityRatio = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            wageToQualityRatio.add(new Pair<>(wage[i] * (1.0) / quality[i], quality[i]));
        }

        Collections.sort(wageToQualityRatio, Comparator.comparingDouble(Pair::getKey));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            maxHeap.add(wageToQualityRatio.get(i).getValue());
            currentTotalQuality += wageToQualityRatio.get(i).getValue();
            if (maxHeap.size() > k) {
                currentTotalQuality -= maxHeap.poll();
            }
            if (maxHeap.size() == k) {
                totalCost = Math.min(totalCost, currentTotalQuality * wageToQualityRatio.get(i).getKey());
            }
        }
        return totalCost;
    }
}
