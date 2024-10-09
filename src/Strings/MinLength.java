package Strings;


//2696. Minimum String Length After Removing Substrings
public class MinLength {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(minLength(s));
    }


    //Time Complexity is O(n*n)
    static public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) {
                s = s.replace("AB", "");
            } else {
                s = s.replace("CD", "");
            }
        }
        return s.length();
    }
}
