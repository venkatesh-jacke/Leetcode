package Strings;

//3863. Minimum Operations to Sort a String

public class MinOperations {
    public static void main(String[] args) {
        String s = "card";
        System.out.println(minOperations(s));
    }

    static public int minOperations(String s) {
        int n = s.length();

        // Case 1: Already sorted
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        // Case 2: Length 2, and not sorted
        // The only proper substrings have length 1,
        // so sorting them cannot change the string.
        if (n == 2) {
            return -1;
        }

        // Find the minimum and maximum characters
        char minChar = 'z';
        char maxChar = 'a';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            minChar = (char) Math.min(minChar, c);
            maxChar = (char) Math.max(maxChar, c);
        }

        // Case 3: One operation is enough
        if (s.charAt(0) == minChar ||
                s.charAt(n - 1) == maxChar) {
            return 1;
        }

        // Case 4: Check whether an extreme is in the middle
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == minChar ||
                    s.charAt(i) == maxChar) {
                return 2;
            }
        }

        // Case 5: Both extremes are at the wrong boundaries
        return 3;
    }
}
