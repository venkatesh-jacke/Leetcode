package Leetcode_75;

//1456. Maximum Number of Vowels in a Substring of Given Length
public class MaxVowels {
    public static void main(String[] args) {
        String s = "\"ibpbhixfiouhdljnjfflpapptrxgcomvnb\"";
        System.out.println(maxVowels(s, 33));
    }

    static public int maxVowels(String s, int k) {
        char[] ca = s.toCharArray();
        int cur = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(ca[i])) cur++;
        }
        int ans = cur;
        for (int i = k; i < ca.length; i++) {
            if (isVowel(ca[i])) cur++;
            if (isVowel(ca[i - k])) cur--;
            ans = Math.max(cur, ans);
        }
        return ans;
    }

    static public boolean isVowel(char c) {
        return "aeiou".indexOf(c)!=-1;
    }
}
