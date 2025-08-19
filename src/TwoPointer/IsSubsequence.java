package TwoPointer;

//392. Is Subsequence
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    static public boolean isSubsequence(String s, String t) {
        int slen = s.length(), tlen = t.length(), i = 0, j = 0;
        while (i < slen && j < tlen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == slen;
    }
}
