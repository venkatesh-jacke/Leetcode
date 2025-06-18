package TwoPointer;


//28. Find the Index of the First Occurrence in a String
public class Strstr {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    static public int strStr(String haystack, String needle) {
        int hayLen = haystack.length(), needleLen = needle.length();
        if (hayLen < needleLen)
            return -1;
        for (int i = 0; i <= hayLen - needleLen; i++) {
            int j = 0;
            while (j < needleLen && haystack.charAt(i + j) == needle.charAt(j++))
                if (j == needleLen)
                    return i;
        }
        return -1;
    }
}
