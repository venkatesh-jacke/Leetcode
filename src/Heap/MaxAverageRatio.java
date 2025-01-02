package Heap;

import java.util.PriorityQueue;


//1792. Maximum Average Pass Ratio
public class MaxAverageRatio {
    public static void main(String[] args) {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
    }

    static  public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int i = 0; i < n; i++) {
            double curAvg = (double) classes[i][0] / classes[i][1];
            double newAvg = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double possibleInc = newAvg - curAvg;
            maxHeap.offer(new double[] { possibleInc, i });
        }
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            int idx = (int) top[1];
            classes[idx][0]++;
            classes[idx][1]++;
            double curAvg = (double) classes[idx][0] / classes[idx][1];
            double newAvg = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            double possibleInc = newAvg - curAvg;
            maxHeap.offer(new double[] { possibleInc, idx });

        }
        double maxAvg = 0.0;
        for (int[] clazz : classes) {
            maxAvg += (double) clazz[0] / clazz[1];
        }
        return maxAvg / n;
    }
}
