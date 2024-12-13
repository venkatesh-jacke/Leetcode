package TwoPointer;


//28. Find the Index of the First Occurrence in a String
public class Strstr {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    static public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int start = i; //find the startingIndex and store it to iterate
                int j = 0;
                while (start < haystack.length() && j < needle.length() && haystack.charAt(start) == needle.charAt(j)) {
                    j++;
                    start++;
                }
                if (j == needle.length())
                    return i;
            }
        }
        return -1;
    }
}
