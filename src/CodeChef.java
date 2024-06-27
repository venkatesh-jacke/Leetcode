import java.util.*;

public class CodeChef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            if (canFormPermutation(A, N)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }

    private static boolean canFormPermutation(int[] A, int N) {
        Set<Integer> requiredNumbers = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            requiredNumbers.add(i);
        }

        // Frequency map to count occurrences of each element in A
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Try to form each number from 1 to N
        for (int num = 1; num <= N; num++) {
            boolean found = false;
            for (int a : frequencyMap.keySet()) {
                int b = num - a;
                if (b >= 0 && frequencyMap.get(a) > 0) {
                    frequencyMap.put(a, frequencyMap.get(a) - 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }
}
