package Leetcode_75;

//1768. Merge Strings Alternately
public class MergeAlternately {
    public static void main(String[] args) {

    }

    //One Pointer
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length(), len2 = word2.length();
        for (int i = 0; i < Math.max(len1, len2); i++) {
            if (i < len1) sb.append(word1.charAt(i));
            if (i < len2) sb.append(word2.charAt(i));
        }
        return sb.toString();
    }

    //Two Pointer
    public String mergeAlternately2(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length(), len2 = word2.length();
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            if (i < len1) sb.append(word1.charAt(i++));
            if (j < len2) sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }

}
