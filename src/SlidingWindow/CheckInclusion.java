package SlidingWindow;


//567. Permutation in String
public class CheckInclusion {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    static public boolean checkInclusion(String s1, String s2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        //Create a starting window
        for (char c : s1.toCharArray()) {
            f1[c - 'a']++;
        }
        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            f2[s2.charAt(i) - 'a']++;
            if (i >= windowSize) {
                f2[s2.charAt(i - windowSize) - 'a']--;
            }
            if (matches(f1, f2)) {
                return true;
            }
        }
        return false;

    }

    static public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        //create the first window
        for (int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(f1, f2))
                return true;
            f2[s2.charAt(i + s1.length()) - 'a']++;
            f2[s2.charAt(i) - 'a']--;
        }
        return matches(f1, f2); //check the last window
    }

    static private boolean matches(int[] f1, int[] f2) {
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }
        return true;
    }
}
