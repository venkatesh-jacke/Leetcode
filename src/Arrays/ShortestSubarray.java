    package Arrays;

    import java.util.ArrayDeque;
    import java.util.Arrays;
    import java.util.Deque;

    public class ShortestSubarray {
        public static void main(String[] args) {
            int[] arr = new int[]{48, 99, 37, 4, -31};
            int k = 140;
            System.out.println(shortestSubarray(arr, k));
        }

        static public int shortestSubarray(int[] arr, int k) {
            int n = arr.length;
            int min_len = n + 1;
            long[] prefix = new long[n + 1];

            // Calculate prefix sums
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + arr[i];
            }
            System.out.println(Arrays.toString(prefix));
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n + 1; i++) {
                System.out.println("Iteration : "+i);
                long prefixSum = prefix[i];
                System.out.println("prefixSum: "+prefixSum);

                while (!deque.isEmpty() && (prefixSum - prefix[deque.getFirst()]) >= k) {
                    int pollFirst= deque.pollFirst();
                    System.out.println("Removing First item " +pollFirst);
                    System.out.println("Found the SubArray  min of ("+min_len+","+(i-pollFirst)+")");
                    min_len = Math.min(min_len, i - pollFirst);

                }

                //If DQ last element is greater than current prefix remove the last index from queue since we have enough sum for target
                while (!deque.isEmpty() && (prefix[deque.getLast()] >= prefixSum)) {
                    long removeLast=   deque.pollLast();
                    System.out.println("Removing Last item in iteration "+removeLast);

                }

                deque.add(i);
                System.out.println(deque);

                System.out.println("===========================================");
            }

            return min_len == n + 1 ? -1 : min_len;
        }
    }
