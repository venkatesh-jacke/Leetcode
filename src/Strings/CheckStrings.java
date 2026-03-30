package Strings;

//2840. Check if Strings Can be Made Equal With Operations II

public class CheckStrings {
    public static void main(String[] args) {
        String s1 = "abcdba", s2 = "cabdab";
        System.out.println(checkStrings(s1, s2));
    }

    static public boolean checkStrings(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) return false;
        }
        return true;
    }
}
