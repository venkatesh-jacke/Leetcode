package Leetcode_75;

public class MaxVowels {
    public static void main(String[] args) {
        String s = "\"ibpbhixfiouhdljnjfflpapptrxgcomvnb\"";
        System.out.println(maxVowels(s, 33));
    }

    static public int maxVowels(String s, int k) {
        int current = 0, ans = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                current += 1;
        }
        int l = 0;
        for (int r = k; r < s.length(); r++) {
            if (isVowel(s.charAt(r)))
                current += 1;
            if (isVowel(s.charAt(l)))
                current -= 1;
            l += 1;
            ans = Math.max(ans, current);
        }
        return ans;
    }

    static public boolean isVowel(char c) {
        return (c > 96 && c < 123) && ("aeiou".indexOf(c) != -1);
    }
}
