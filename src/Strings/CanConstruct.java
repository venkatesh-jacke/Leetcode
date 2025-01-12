package Strings;


//1400. Construct K Palindrome Strings

public class CanConstruct {
    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
    }

    static public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k)
            return false;
        int[] freq = new int[26];
        int odd = 0;
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;

        }
        for (int i : freq) {
            odd += i % 2 == 1 ? 1 : 0;
        }
        if (odd > k)
            return false;
        return true;
    }
}
