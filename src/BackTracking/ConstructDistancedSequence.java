package BackTracking;

//1718. Construct the Lexicographically Largest Valid Sequence

import java.util.Arrays;

public class ConstructDistancedSequence {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.toString(constructDistancedSequence(n)));

    }

    static public int[] constructDistancedSequence(int n) {
        int[] sequence = new int[(2 * n) - 1];
        boolean[] used = new boolean[n + 1];
        backTrack(n, sequence, used, 0);
        return sequence;

    }

    private static boolean backTrack(int n, int[] sequence, boolean[] used, int currentIndex) {
        //  Skip if currentIndex is already filled
        if (currentIndex == sequence.length) return true;
        // skips already filled positions in the sequence.
        if (sequence[currentIndex] != 0) return backTrack(n, sequence, used, currentIndex + 1);

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;

            //  Check if 'num' can be placed at currentIndex and (currentIndex + num)
            if (num > 1 && (currentIndex + num >= sequence.length || sequence[currentIndex + num] != 0)) continue;

            // Place the number
            used[num] = true;
            sequence[currentIndex] = num;
            if (num > 1) {
                sequence[currentIndex + num] = num;
            }

            //  Recursive call
            if (backTrack(n, sequence, used, currentIndex + 1)) return true;

            //  Undo placement (Backtracking)
            used[num] = false;
            sequence[currentIndex] = 0;
            if (num > 1) {
                sequence[currentIndex + num] = 0;
            }
        }
        return false;
    }


}
