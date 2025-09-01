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
/*
Pseudocode

1. For each class:
       calculate current pass ratio = passed / total
       calculate ratio if we add one more student = (passed+1) / (total+1)
       calculate gain = newRatio - currentRatio
       put {gain, classIndex} into a maxHeap (priority queue)

2. While we still have extra students:
       pick the class with the largest gain (from maxHeap)
       assign 1 student to that class (increase passed & total by 1)
       recalculate its new gain (if we add another student in future)
       push updated {gain, classIndex} back into maxHeap

3. After all students are assigned:
       calculate average ratio = sum(pass/total for each class) / numberOfClasses
       return this average
 */