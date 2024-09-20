package TreeSet;


import java.util.*;

public class NthUglyNumber {
    public static void main(String[] args) {
        int n = 10;

    }

    static public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        Long current = 1L;
        set.add(current);
        for (int i = 0; i < n; i++) {
            current = set.pollFirst();
            set.add(2 * current);
            set.add(3 * current);
            set.add(5 * current);
        }
        return current.intValue();
    }

    static public int nthUglyNumber2(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        int[] primeFactors = { 2, 3, 5 };
        long current = 1L;
        minHeap.offer(current);
        seen.add(current);
        for (int i = 0; i < n; i++) {
            current = minHeap.poll();
            for (int prime : primeFactors) {
                long next = current * prime;
                if (seen.add(next)) {
                    minHeap.offer(next);
                }
            }
        }
        return (int) current;
    }
}
